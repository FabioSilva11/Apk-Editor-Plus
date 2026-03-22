package com.android.apksig;

import com.android.apksig.ApkSignerEngine;
import com.android.apksig.DefaultApkSignerEngine;
import com.android.apksig.Hints;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkSigningBlockNotFoundException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.apk.MinSdkVersionException;
import com.android.apksig.internal.util.ByteBufferDataSource;
import com.android.apksig.internal.zip.CentralDirectoryRecord;
import com.android.apksig.internal.zip.EocdRecord;
import com.android.apksig.internal.zip.LocalFileRecord;
import com.android.apksig.internal.zip.ZipUtils;
import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSinks;
import com.android.apksig.util.DataSource;
import com.android.apksig.util.DataSources;
import com.android.apksig.util.ReadableDataSink;
import com.android.apksig.zip.ZipFormatException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApkSigner {
    public final String mCreatedBy;
    public final boolean mDebuggableApkPermitted;
    public final boolean mForceSourceStampOverwrite;
    public final DataSource mInputApkDataSource;
    public final File mInputApkFile;
    public final Integer mMinSdkVersion;
    public final boolean mOtherSignersSignaturesPreserved;
    public final DataSink mOutputApkDataSink;
    public final DataSource mOutputApkDataSource;
    public final File mOutputApkFile;
    public final File mOutputV4File;
    public final List<SignerConfig> mSignerConfigs;
    public final ApkSignerEngine mSignerEngine;
    public final SigningCertificateLineage mSigningCertificateLineage;
    public final SignerConfig mSourceStampSignerConfig;
    public final SigningCertificateLineage mSourceStampSigningCertificateLineage;
    public final boolean mV1SigningEnabled;
    public final boolean mV2SigningEnabled;
    public final boolean mV3SigningEnabled;
    public final boolean mV4ErrorReportingEnabled;
    public final boolean mV4SigningEnabled;
    public final boolean mVerityEnabled;

    /* JADX INFO: renamed from: com.android.apksig.ApkSigner$1 */
    public static /* synthetic */ class C08921 {

        /* JADX INFO: renamed from: $SwitchMap$com$android$apksig$ApkSignerEngine$InputJarEntryInstructions$OutputPolicy */
        public static final /* synthetic */ int[] f2267x62cebf84;

        static {
            int[] iArr = new int[ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.values().length];
            f2267x62cebf84 = iArr;
            try {
                iArr[ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2267x62cebf84[ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT_BY_ENGINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2267x62cebf84[ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.SKIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Builder {
        public String mCreatedBy;
        public boolean mDebuggableApkPermitted;
        public boolean mForceSourceStampOverwrite;
        public DataSource mInputApkDataSource;
        public File mInputApkFile;
        public Integer mMinSdkVersion;
        public boolean mOtherSignersSignaturesPreserved;
        public DataSink mOutputApkDataSink;
        public DataSource mOutputApkDataSource;
        public File mOutputApkFile;
        public File mOutputV4File;
        public final List<SignerConfig> mSignerConfigs;
        public final ApkSignerEngine mSignerEngine;
        public SigningCertificateLineage mSigningCertificateLineage;
        public SignerConfig mSourceStampSignerConfig;
        public SigningCertificateLineage mSourceStampSigningCertificateLineage;
        public boolean mV1SigningEnabled;
        public boolean mV2SigningEnabled;
        public boolean mV3SigningEnabled;
        public boolean mV3SigningExplicitlyDisabled;
        public boolean mV3SigningExplicitlyEnabled;
        public boolean mV4ErrorReportingEnabled;
        public boolean mV4SigningEnabled;
        public boolean mVerityEnabled;

        public Builder(ApkSignerEngine apkSignerEngine) {
            this.mForceSourceStampOverwrite = false;
            this.mV1SigningEnabled = true;
            this.mV2SigningEnabled = true;
            this.mV3SigningEnabled = true;
            this.mV4SigningEnabled = true;
            this.mVerityEnabled = false;
            this.mV4ErrorReportingEnabled = false;
            this.mDebuggableApkPermitted = true;
            this.mV3SigningExplicitlyDisabled = false;
            this.mV3SigningExplicitlyEnabled = false;
            if (apkSignerEngine == null) {
                throw new NullPointerException("signerEngine == null");
            }
            this.mSignerEngine = apkSignerEngine;
            this.mSignerConfigs = null;
        }

        public Builder(List<SignerConfig> list) {
            this.mForceSourceStampOverwrite = false;
            this.mV1SigningEnabled = true;
            this.mV2SigningEnabled = true;
            this.mV3SigningEnabled = true;
            this.mV4SigningEnabled = true;
            this.mVerityEnabled = false;
            this.mV4ErrorReportingEnabled = false;
            this.mDebuggableApkPermitted = true;
            this.mV3SigningExplicitlyDisabled = false;
            this.mV3SigningExplicitlyEnabled = false;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("At least one signer config must be provided");
            }
            if (list.size() > 1) {
                this.mV3SigningEnabled = false;
            }
            this.mSignerConfigs = new ArrayList(list);
            this.mSignerEngine = null;
        }

        public ApkSigner build() {
            boolean z = this.mV3SigningExplicitlyDisabled;
            if (z && this.mV3SigningExplicitlyEnabled) {
                throw new IllegalStateException("Builder configured to both enable and disable APK Signature Scheme v3 signing");
            }
            if (z) {
                this.mV3SigningEnabled = false;
            }
            if (this.mV3SigningExplicitlyEnabled) {
                this.mV3SigningEnabled = true;
            }
            if (this.mV4SigningEnabled && !this.mV2SigningEnabled && !this.mV3SigningEnabled) {
                if (this.mV4ErrorReportingEnabled) {
                    throw new IllegalStateException("APK Signature Scheme v4 signing requires at least v2 or v3 signing to be enabled");
                }
                this.mV4SigningEnabled = false;
            }
            return new ApkSigner(this.mSignerConfigs, this.mSourceStampSignerConfig, this.mSourceStampSigningCertificateLineage, this.mForceSourceStampOverwrite, this.mMinSdkVersion, this.mV1SigningEnabled, this.mV2SigningEnabled, this.mV3SigningEnabled, this.mV4SigningEnabled, this.mVerityEnabled, this.mV4ErrorReportingEnabled, this.mDebuggableApkPermitted, this.mOtherSignersSignaturesPreserved, this.mCreatedBy, this.mSignerEngine, this.mInputApkFile, this.mInputApkDataSource, this.mOutputApkFile, this.mOutputApkDataSink, this.mOutputApkDataSource, this.mOutputV4File, this.mSigningCertificateLineage, null);
        }

        public final void checkInitializedWithoutEngine() {
            if (this.mSignerEngine != null) {
                throw new IllegalStateException("Operation is not available when builder initialized with an engine");
            }
        }

        public Builder setCreatedBy(String str) {
            checkInitializedWithoutEngine();
            str.getClass();
            this.mCreatedBy = str;
            return this;
        }

        public Builder setDebuggableApkPermitted(boolean z) {
            checkInitializedWithoutEngine();
            this.mDebuggableApkPermitted = z;
            return this;
        }

        public Builder setForceSourceStampOverwrite(boolean z) {
            this.mForceSourceStampOverwrite = z;
            return this;
        }

        public Builder setInputApk(File file) {
            if (file == null) {
                throw new NullPointerException("inputApk == null");
            }
            this.mInputApkFile = file;
            this.mInputApkDataSource = null;
            return this;
        }

        public Builder setMinSdkVersion(int i) {
            checkInitializedWithoutEngine();
            this.mMinSdkVersion = Integer.valueOf(i);
            return this;
        }

        public Builder setOtherSignersSignaturesPreserved(boolean z) {
            checkInitializedWithoutEngine();
            this.mOtherSignersSignaturesPreserved = z;
            return this;
        }

        public Builder setOutputApk(DataSink dataSink, DataSource dataSource) {
            if (dataSink == null) {
                throw new NullPointerException("outputApkOut == null");
            }
            if (dataSource == null) {
                throw new NullPointerException("outputApkIn == null");
            }
            this.mOutputApkFile = null;
            this.mOutputApkDataSink = dataSink;
            this.mOutputApkDataSource = dataSource;
            return this;
        }

        public Builder setOutputApk(ReadableDataSink readableDataSink) {
            if (readableDataSink != null) {
                return setOutputApk(readableDataSink, readableDataSink);
            }
            throw new NullPointerException("outputApk == null");
        }

        public Builder setOutputApk(File file) {
            if (file == null) {
                throw new NullPointerException("outputApk == null");
            }
            this.mOutputApkFile = file;
            this.mOutputApkDataSink = null;
            this.mOutputApkDataSource = null;
            return this;
        }

        public Builder setSigningCertificateLineage(SigningCertificateLineage signingCertificateLineage) {
            if (signingCertificateLineage != null) {
                this.mV3SigningEnabled = true;
                this.mSigningCertificateLineage = signingCertificateLineage;
            }
            return this;
        }

        public Builder setSourceStampSignerConfig(SignerConfig signerConfig) {
            this.mSourceStampSignerConfig = signerConfig;
            return this;
        }

        public Builder setSourceStampSigningCertificateLineage(SigningCertificateLineage signingCertificateLineage) {
            this.mSourceStampSigningCertificateLineage = signingCertificateLineage;
            return this;
        }

        public Builder setV1SigningEnabled(boolean z) {
            checkInitializedWithoutEngine();
            this.mV1SigningEnabled = z;
            return this;
        }

        public Builder setV2SigningEnabled(boolean z) {
            checkInitializedWithoutEngine();
            this.mV2SigningEnabled = z;
            return this;
        }

        public Builder setV3SigningEnabled(boolean z) {
            checkInitializedWithoutEngine();
            this.mV3SigningEnabled = z;
            if (z) {
                this.mV3SigningExplicitlyEnabled = true;
            } else {
                this.mV3SigningExplicitlyDisabled = true;
            }
            return this;
        }

        public Builder setV4ErrorReportingEnabled(boolean z) {
            checkInitializedWithoutEngine();
            this.mV4ErrorReportingEnabled = z;
            return this;
        }

        public Builder setV4SignatureOutputFile(File file) {
            if (file == null) {
                throw new NullPointerException("v4HashRootOutputFile == null");
            }
            this.mOutputV4File = file;
            return this;
        }

        public Builder setV4SigningEnabled(boolean z) {
            checkInitializedWithoutEngine();
            this.mV4SigningEnabled = z;
            this.mV4ErrorReportingEnabled = z;
            return this;
        }

        public Builder setVerityEnabled(boolean z) {
            checkInitializedWithoutEngine();
            this.mVerityEnabled = z;
            return this;
        }
    }

    public static class OutputSizeAndDataOffset {
        public long dataOffsetBytes;
        public long outputBytes;

        public OutputSizeAndDataOffset(long j, long j2) {
            this.outputBytes = j;
            this.dataOffsetBytes = j2;
        }
    }

    public static class SignerConfig {
        public final List<X509Certificate> mCertificates;
        public final String mName;
        public final PrivateKey mPrivateKey;

        public static class Builder {
            public final List<X509Certificate> mCertificates;
            public final String mName;
            public final PrivateKey mPrivateKey;

            public Builder(String str, PrivateKey privateKey, List<X509Certificate> list) {
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("Empty name");
                }
                this.mName = str;
                this.mPrivateKey = privateKey;
                this.mCertificates = new ArrayList(list);
            }

            public SignerConfig build() {
                return new SignerConfig(this.mName, this.mPrivateKey, this.mCertificates, null);
            }
        }

        public SignerConfig(String str, PrivateKey privateKey, List<X509Certificate> list) {
            this.mName = str;
            this.mPrivateKey = privateKey;
            this.mCertificates = Collections.unmodifiableList(new ArrayList(list));
        }

        public /* synthetic */ SignerConfig(String str, PrivateKey privateKey, List list, C08921 c08921) {
            this(str, privateKey, list);
        }

        public List<X509Certificate> getCertificates() {
            return this.mCertificates;
        }

        public String getName() {
            return this.mName;
        }

        public PrivateKey getPrivateKey() {
            return this.mPrivateKey;
        }
    }

    public ApkSigner(List<SignerConfig> list, SignerConfig signerConfig, SigningCertificateLineage signingCertificateLineage, boolean z, Integer num, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String str, ApkSignerEngine apkSignerEngine, File file, DataSource dataSource, File file2, DataSink dataSink, DataSource dataSource2, File file3, SigningCertificateLineage signingCertificateLineage2) {
        this.mSignerConfigs = list;
        this.mSourceStampSignerConfig = signerConfig;
        this.mSourceStampSigningCertificateLineage = signingCertificateLineage;
        this.mForceSourceStampOverwrite = z;
        this.mMinSdkVersion = num;
        this.mV1SigningEnabled = z2;
        this.mV2SigningEnabled = z3;
        this.mV3SigningEnabled = z4;
        this.mV4SigningEnabled = z5;
        this.mVerityEnabled = z6;
        this.mV4ErrorReportingEnabled = z7;
        this.mDebuggableApkPermitted = z8;
        this.mOtherSignersSignaturesPreserved = z9;
        this.mCreatedBy = str;
        this.mSignerEngine = apkSignerEngine;
        this.mInputApkFile = file;
        this.mInputApkDataSource = dataSource;
        this.mOutputApkFile = file2;
        this.mOutputApkDataSink = dataSink;
        this.mOutputApkDataSource = dataSource2;
        this.mOutputV4File = file3;
        this.mSigningCertificateLineage = signingCertificateLineage2;
    }

    public /* synthetic */ ApkSigner(List list, SignerConfig signerConfig, SigningCertificateLineage signingCertificateLineage, boolean z, Integer num, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String str, ApkSignerEngine apkSignerEngine, File file, DataSource dataSource, File file2, DataSink dataSink, DataSource dataSource2, File file3, SigningCertificateLineage signingCertificateLineage2, C08921 c08921) {
        this(list, signerConfig, signingCertificateLineage, z, num, z2, z3, z4, z5, z6, z7, z8, z9, str, apkSignerEngine, file, dataSource, file2, dataSink, dataSource2, file3, signingCertificateLineage2);
    }

    public static ByteBuffer createExtraFieldToAlignData(ByteBuffer byteBuffer, long j, int i) {
        if (i <= 1) {
            return byteBuffer;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining() + 5 + i);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer.remaining() >= 4) {
            short s = byteBuffer.getShort();
            int unsignedInt16 = ZipUtils.getUnsignedInt16(byteBuffer);
            if (unsignedInt16 > byteBuffer.remaining()) {
                break;
            }
            if ((s == 0 && unsignedInt16 == 0) || s == -9931) {
                byteBuffer.position(byteBuffer.position() + unsignedInt16);
            } else {
                byteBuffer.position(byteBuffer.position() - 4);
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + 4 + unsignedInt16);
                byteBufferAllocate.put(byteBuffer);
                byteBuffer.limit(iLimit);
            }
        }
        int iPosition = (i - ((int) (((j + ((long) byteBufferAllocate.position())) + 6) % ((long) i)))) % i;
        byteBufferAllocate.putShort((short) -9931);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, iPosition + 2);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, i);
        byteBufferAllocate.position(byteBufferAllocate.position() + iPosition);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static List<Hints.PatternWithRange> extractPinPatterns(List<CentralDirectoryRecord> list, DataSource dataSource) throws IOException, ApkFormatException {
        CentralDirectoryRecord centralDirectoryRecordFindCdRecord = findCdRecord(list, "assets/com.android.hints.pins.txt");
        if (centralDirectoryRecordFindCdRecord == null) {
            return null;
        }
        new ArrayList();
        try {
            return Hints.parsePinPatterns(LocalFileRecord.getUncompressedData(dataSource, centralDirectoryRecordFindCdRecord, dataSource.size()));
        } catch (ZipFormatException unused) {
            throw new ApkFormatException("Bad " + centralDirectoryRecordFindCdRecord);
        }
    }

    public static CentralDirectoryRecord findCdRecord(List<CentralDirectoryRecord> list, String str) {
        for (CentralDirectoryRecord centralDirectoryRecord : list) {
            if (str.equals(centralDirectoryRecord.getName())) {
                return centralDirectoryRecord;
            }
        }
        return null;
    }

    public static void fulfillInspectInputJarEntryRequest(DataSource dataSource, LocalFileRecord localFileRecord, ApkSignerEngine.InspectJarEntryRequest inspectJarEntryRequest) throws IOException, ApkFormatException {
        try {
            localFileRecord.outputUncompressedData(dataSource, inspectJarEntryRequest.getDataSink());
            inspectJarEntryRequest.done();
        } catch (ZipFormatException e) {
            throw new ApkFormatException("Malformed ZIP entry: " + localFileRecord.getName(), e);
        }
    }

    public static ByteBuffer getAndroidManifestFromApk(List<CentralDirectoryRecord> list, DataSource dataSource) throws IOException, ApkFormatException, ZipFormatException {
        CentralDirectoryRecord centralDirectoryRecordFindCdRecord = findCdRecord(list, ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
        if (centralDirectoryRecordFindCdRecord != null) {
            return ByteBuffer.wrap(LocalFileRecord.getUncompressedData(dataSource, centralDirectoryRecordFindCdRecord, dataSource.size()));
        }
        throw new ApkFormatException("Missing AndroidManifest.xml");
    }

    public static int getInputJarEntryDataAlignmentMultiple(LocalFileRecord localFileRecord) {
        if (localFileRecord.isDataCompressed()) {
            return 1;
        }
        return localFileRecord.getName().endsWith(".so") ? 4096 : 4;
    }

    public static int getMinSdkVersionFromApk(List<CentralDirectoryRecord> list, DataSource dataSource) throws MinSdkVersionException, IOException {
        try {
            return ApkUtils.getMinSdkVersionFromBinaryAndroidManifest(getAndroidManifestFromApk(list, dataSource));
        } catch (ApkFormatException | ZipFormatException e) {
            throw new MinSdkVersionException("Failed to determine APK's minimum supported Android platform version", e);
        }
    }

    public static ByteBuffer getZipCentralDirectory(DataSource dataSource, ApkUtils.ZipSections zipSections) throws IOException, ApkFormatException {
        long zipCentralDirectorySizeBytes = zipSections.getZipCentralDirectorySizeBytes();
        if (zipCentralDirectorySizeBytes <= 2147483647L) {
            ByteBuffer byteBuffer = dataSource.getByteBuffer(zipSections.getZipCentralDirectoryOffset(), (int) zipCentralDirectorySizeBytes);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return byteBuffer;
        }
        throw new ApkFormatException("ZIP Central Directory too large: " + zipCentralDirectorySizeBytes);
    }

    public static long outputDataToOutputApk(String str, byte[] bArr, long j, List<CentralDirectoryRecord> list, int i, int i2, DataSink dataSink) throws IOException {
        ZipUtils.DeflateResult deflateResultDeflate = ZipUtils.deflate(ByteBuffer.wrap(bArr));
        byte[] bArr2 = deflateResultDeflate.output;
        long j2 = deflateResultDeflate.inputCrc32;
        long jOutputRecordWithDeflateCompressedData = LocalFileRecord.outputRecordWithDeflateCompressedData(str, i, i2, bArr2, j2, bArr.length, dataSink);
        list.add(CentralDirectoryRecord.createWithDeflateCompressedData(str, i, i2, j2, bArr2.length, bArr.length, j));
        return jOutputRecordWithDeflateCompressedData;
    }

    public static OutputSizeAndDataOffset outputInputJarEntryLfhRecordPreservingDataAlignment(DataSource dataSource, LocalFileRecord localFileRecord, DataSink dataSink, long j) throws IOException {
        int inputJarEntryDataAlignmentMultiple = getInputJarEntryDataAlignmentMultiple(localFileRecord);
        if (inputJarEntryDataAlignmentMultiple <= 1) {
            return new OutputSizeAndDataOffset(localFileRecord.outputRecord(dataSource, dataSink), localFileRecord.getDataStartOffsetInRecord());
        }
        ByteBuffer byteBufferCreateExtraFieldToAlignData = createExtraFieldToAlignData(localFileRecord.getExtra(), j + ((long) localFileRecord.getExtraFieldStartOffsetInsideRecord()), inputJarEntryDataAlignmentMultiple);
        return new OutputSizeAndDataOffset(localFileRecord.outputRecordWithModifiedExtra(dataSource, byteBufferCreateExtraFieldToAlignData, dataSink), (((long) localFileRecord.getDataStartOffsetInRecord()) + ((long) byteBufferCreateExtraFieldToAlignData.remaining())) - ((long) localFileRecord.getExtra().remaining()));
    }

    public static List<CentralDirectoryRecord> parseZipCentralDirectory(ByteBuffer byteBuffer, ApkUtils.ZipSections zipSections) throws ApkFormatException {
        long zipCentralDirectoryOffset = zipSections.getZipCentralDirectoryOffset();
        int zipCentralDirectoryRecordCount = zipSections.getZipCentralDirectoryRecordCount();
        ArrayList arrayList = new ArrayList(zipCentralDirectoryRecordCount);
        HashSet hashSet = new HashSet(zipCentralDirectoryRecordCount);
        for (int i = 0; i < zipCentralDirectoryRecordCount; i++) {
            int iPosition = byteBuffer.position();
            try {
                CentralDirectoryRecord record = CentralDirectoryRecord.getRecord(byteBuffer);
                String name = record.getName();
                if (!hashSet.add(name)) {
                    throw new ApkFormatException("Multiple ZIP entries with the same name: " + name);
                }
                arrayList.add(record);
            } catch (ZipFormatException e) {
                throw new ApkFormatException("Malformed ZIP Central Directory record #" + (i + 1) + " at file offset " + (zipCentralDirectoryOffset + ((long) iPosition)), e);
            }
        }
        if (!byteBuffer.hasRemaining()) {
            return arrayList;
        }
        throw new ApkFormatException("Unused space at the end of ZIP Central Directory: " + byteBuffer.remaining() + " bytes starting at file offset " + (zipCentralDirectoryOffset + ((long) byteBuffer.position())));
    }

    public void sign() throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        DataSource dataSourceAsDataSource;
        DataSource dataSourceAsDataSource2;
        RandomAccessFile randomAccessFile2 = null;
        try {
            DataSource dataSource = this.mInputApkDataSource;
            if (dataSource != null) {
                dataSourceAsDataSource = dataSource;
                randomAccessFile = null;
            } else {
                if (this.mInputApkFile == null) {
                    throw new IllegalStateException("Input APK not specified");
                }
                randomAccessFile = new RandomAccessFile(this.mInputApkFile, "r");
                try {
                    dataSourceAsDataSource = DataSources.asDataSource(randomAccessFile);
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw th;
                }
            }
            try {
                DataSink dataSink = this.mOutputApkDataSink;
                if (dataSink != null) {
                    dataSourceAsDataSource2 = this.mOutputApkDataSource;
                } else {
                    if (this.mOutputApkFile == null) {
                        throw new IllegalStateException("Output APK not specified");
                    }
                    RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.mOutputApkFile, "rw");
                    try {
                        randomAccessFile3.setLength(0L);
                        DataSink dataSinkAsDataSink = DataSinks.asDataSink(randomAccessFile3);
                        dataSourceAsDataSource2 = DataSources.asDataSource(randomAccessFile3);
                        dataSink = dataSinkAsDataSink;
                        randomAccessFile2 = randomAccessFile3;
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = randomAccessFile3;
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        throw th;
                    }
                }
                sign(dataSourceAsDataSource, dataSink, dataSourceAsDataSource2);
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            randomAccessFile = null;
            th = th5;
        }
    }

    public final void sign(DataSource dataSource, DataSink dataSink, DataSource dataSource2) throws SignatureException, NoSuchAlgorithmException, IOException, InvalidKeyException, ApkFormatException {
        long zipCentralDirectoryOffset;
        DataSource contents;
        ApkSigner apkSigner;
        DataSink dataSink2;
        boolean z;
        HashMap map;
        ArrayList arrayList;
        byte[] bArr;
        int i;
        List<CentralDirectoryRecord> list;
        int i2;
        int i3;
        long j;
        HashMap map2;
        ArrayList arrayList2;
        Hints.ByteRange byteRangeClampToAbsoluteByteRange;
        ApkUtils.ApkSigningBlock apkSigningBlockFindApkSigningBlock;
        DataSink dataSink3 = dataSink;
        try {
            ApkUtils.ZipSections zipSectionsFindZipSections = ApkUtils.findZipSections(dataSource);
            try {
                apkSigningBlockFindApkSigningBlock = ApkUtils.findApkSigningBlock(dataSource, zipSectionsFindZipSections);
                zipCentralDirectoryOffset = apkSigningBlockFindApkSigningBlock.getStartOffset();
            } catch (ApkSigningBlockNotFoundException unused) {
                zipCentralDirectoryOffset = -1;
            }
            try {
                contents = apkSigningBlockFindApkSigningBlock.getContents();
            } catch (ApkSigningBlockNotFoundException unused2) {
                contents = null;
            }
            if (zipCentralDirectoryOffset == -1) {
                zipCentralDirectoryOffset = zipSectionsFindZipSections.getZipCentralDirectoryOffset();
            }
            DataSource dataSourceSlice = dataSource.slice(0L, zipCentralDirectoryOffset);
            List<CentralDirectoryRecord> zipCentralDirectory = parseZipCentralDirectory(getZipCentralDirectory(dataSource, zipSectionsFindZipSections), zipSectionsFindZipSections);
            List<Hints.PatternWithRange> listExtractPinPatterns = extractPinPatterns(zipCentralDirectory, dataSourceSlice);
            ArrayList arrayList3 = listExtractPinPatterns == null ? null : new ArrayList();
            ApkSignerEngine apkSignerEngineBuild = this.mSignerEngine;
            if (apkSignerEngineBuild == null) {
                Integer num = this.mMinSdkVersion;
                int iIntValue = num != null ? num.intValue() : getMinSdkVersionFromApk(zipCentralDirectory, dataSourceSlice);
                ArrayList arrayList4 = new ArrayList(this.mSignerConfigs.size());
                for (SignerConfig signerConfig : this.mSignerConfigs) {
                    arrayList4.add(new DefaultApkSignerEngine.SignerConfig.Builder(signerConfig.getName(), signerConfig.getPrivateKey(), signerConfig.getCertificates()).build());
                }
                DefaultApkSignerEngine.Builder signingCertificateLineage = new DefaultApkSignerEngine.Builder(arrayList4, iIntValue).setV1SigningEnabled(this.mV1SigningEnabled).setV2SigningEnabled(this.mV2SigningEnabled).setV3SigningEnabled(this.mV3SigningEnabled).setVerityEnabled(this.mVerityEnabled).setDebuggableApkPermitted(this.mDebuggableApkPermitted).setOtherSignersSignaturesPreserved(this.mOtherSignersSignaturesPreserved).setSigningCertificateLineage(this.mSigningCertificateLineage);
                String str = this.mCreatedBy;
                if (str != null) {
                    signingCertificateLineage.setCreatedBy(str);
                }
                SignerConfig signerConfig2 = this.mSourceStampSignerConfig;
                if (signerConfig2 != null) {
                    signingCertificateLineage.setStampSignerConfig(new DefaultApkSignerEngine.SignerConfig.Builder(signerConfig2.getName(), this.mSourceStampSignerConfig.getPrivateKey(), this.mSourceStampSignerConfig.getCertificates()).build());
                }
                SigningCertificateLineage signingCertificateLineage2 = this.mSourceStampSigningCertificateLineage;
                if (signingCertificateLineage2 != null) {
                    signingCertificateLineage.setSourceStampSigningCertificateLineage(signingCertificateLineage2);
                }
                apkSignerEngineBuild = signingCertificateLineage.build();
            }
            ApkSignerEngine apkSignerEngine = apkSignerEngineBuild;
            if (contents != null) {
                apkSignerEngine.inputApkSigningBlock(contents);
            }
            ArrayList arrayList5 = new ArrayList(zipCentralDirectory);
            Collections.sort(arrayList5, CentralDirectoryRecord.BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR);
            HashMap map3 = new HashMap(zipCentralDirectory.size());
            Iterator it = arrayList5.iterator();
            int i4 = -1;
            long j2 = 0;
            byte[] uncompressedData = null;
            int i5 = -1;
            long jOutputDataToOutputApk = 0;
            while (true) {
                ApkUtils.ZipSections zipSections = zipSectionsFindZipSections;
                if (!it.hasNext()) {
                    List<CentralDirectoryRecord> list2 = zipCentralDirectory;
                    byte[] bArr2 = uncompressedData;
                    int i6 = i5;
                    HashMap map4 = map3;
                    int i7 = i4;
                    long size = dataSourceSlice.size();
                    if (j2 < size) {
                        long j3 = size - j2;
                        dataSourceSlice.feed(j2, j3, dataSink);
                        jOutputDataToOutputApk += j3;
                    }
                    ArrayList arrayList6 = new ArrayList(list2.size() + 10);
                    Iterator<CentralDirectoryRecord> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        CentralDirectoryRecord centralDirectoryRecord = (CentralDirectoryRecord) map4.get(it2.next().getName());
                        if (centralDirectoryRecord != null) {
                            arrayList6.add(centralDirectoryRecord);
                        }
                    }
                    if (i6 == -1) {
                        i6 = 14881;
                        i7 = 0;
                    }
                    if (apkSignerEngine.isEligibleForSourceStamp()) {
                        byte[] bArrGenerateSourceStampCertificateDigest = apkSignerEngine.generateSourceStampCertificateDigest();
                        apkSigner = this;
                        if (!apkSigner.mForceSourceStampOverwrite && bArr2 != null && !Arrays.equals(bArrGenerateSourceStampCertificateDigest, bArr2)) {
                            throw new ApkFormatException(String.format("Cannot generate SourceStamp. APK contains an existing entry with the name: %s, and it is different than the provided source stamp certificate", "stamp-cert-sha256"));
                        }
                        jOutputDataToOutputApk += outputDataToOutputApk("stamp-cert-sha256", bArrGenerateSourceStampCertificateDigest, jOutputDataToOutputApk, arrayList6, i7, i6, dataSink);
                    } else {
                        apkSigner = this;
                    }
                    ApkSignerEngine.OutputJarSignatureRequest outputJarSignatureRequestOutputJarEntries = apkSignerEngine.outputJarEntries();
                    if (outputJarSignatureRequestOutputJarEntries != null) {
                        for (ApkSignerEngine.OutputJarSignatureRequest.JarEntry jarEntry : outputJarSignatureRequestOutputJarEntries.getAdditionalJarEntries()) {
                            String name = jarEntry.getName();
                            byte[] data = jarEntry.getData();
                            ApkSignerEngine.InspectJarEntryRequest inspectJarEntryRequestOutputJarEntry = apkSignerEngine.outputJarEntry(name);
                            if (inspectJarEntryRequestOutputJarEntry != null) {
                                inspectJarEntryRequestOutputJarEntry.getDataSink().consume(data, 0, data.length);
                                inspectJarEntryRequestOutputJarEntry.done();
                            }
                            jOutputDataToOutputApk += outputDataToOutputApk(name, data, jOutputDataToOutputApk, arrayList6, i7, i6, dataSink);
                        }
                        outputJarSignatureRequestOutputJarEntries.done();
                    }
                    long jOutputDataToOutputApk2 = jOutputDataToOutputApk;
                    if (arrayList3 != null) {
                        arrayList3.add(new Hints.ByteRange(jOutputDataToOutputApk2, Long.MAX_VALUE));
                        jOutputDataToOutputApk2 += outputDataToOutputApk("pinlist.meta", Hints.encodeByteRangeList(arrayList3), jOutputDataToOutputApk2, arrayList6, i7, i6, dataSink);
                    }
                    Iterator it3 = arrayList6.iterator();
                    long size2 = 0;
                    while (it3.hasNext()) {
                        size2 += (long) ((CentralDirectoryRecord) it3.next()).getSize();
                    }
                    if (size2 > 2147483647L) {
                        throw new IOException("Output ZIP Central Directory too large: " + size2 + " bytes");
                    }
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) size2);
                    Iterator it4 = arrayList6.iterator();
                    while (it4.hasNext()) {
                        ((CentralDirectoryRecord) it4.next()).copyTo(byteBufferAllocate);
                    }
                    byteBufferAllocate.flip();
                    ByteBufferDataSource byteBufferDataSource = new ByteBufferDataSource(byteBufferAllocate);
                    ByteBuffer byteBufferCreateWithModifiedCentralDirectoryInfo = EocdRecord.createWithModifiedCentralDirectoryInfo(zipSections.getZipEndOfCentralDirectory(), arrayList6.size(), byteBufferDataSource.size(), jOutputDataToOutputApk2);
                    ApkSignerEngine.OutputApkSigningBlockRequest2 outputApkSigningBlockRequest2OutputZipSections2 = apkSignerEngine.outputZipSections2(dataSource2, byteBufferDataSource, DataSources.asDataSource(byteBufferCreateWithModifiedCentralDirectoryInfo));
                    if (outputApkSigningBlockRequest2OutputZipSections2 != null) {
                        int paddingSizeBeforeApkSigningBlock = outputApkSigningBlockRequest2OutputZipSections2.getPaddingSizeBeforeApkSigningBlock();
                        dataSink2 = dataSink;
                        dataSink2.consume(ByteBuffer.allocate(paddingSizeBeforeApkSigningBlock));
                        byte[] apkSigningBlock = outputApkSigningBlockRequest2OutputZipSections2.getApkSigningBlock();
                        dataSink2.consume(apkSigningBlock, 0, apkSigningBlock.length);
                        ZipUtils.setZipEocdCentralDirectoryOffset(byteBufferCreateWithModifiedCentralDirectoryInfo, jOutputDataToOutputApk2 + ((long) paddingSizeBeforeApkSigningBlock) + ((long) apkSigningBlock.length));
                        outputApkSigningBlockRequest2OutputZipSections2.done();
                    } else {
                        dataSink2 = dataSink;
                    }
                    byteBufferDataSource.feed(0L, byteBufferDataSource.size(), dataSink);
                    dataSink2.consume(byteBufferCreateWithModifiedCentralDirectoryInfo);
                    apkSignerEngine.outputDone();
                    if (apkSigner.mV4SigningEnabled) {
                        apkSignerEngine.signV4(dataSource2, apkSigner.mOutputV4File, !apkSigner.mV4ErrorReportingEnabled);
                        return;
                    }
                    return;
                }
                CentralDirectoryRecord centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset = (CentralDirectoryRecord) it.next();
                String name2 = centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset.getName();
                if (!"pinlist.meta".equals(name2)) {
                    if ("stamp-cert-sha256".equals(name2)) {
                        int i8 = i4;
                        try {
                            uncompressedData = LocalFileRecord.getUncompressedData(dataSourceSlice, centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset, dataSourceSlice.size());
                            i4 = i8;
                        } catch (ZipFormatException unused3) {
                            throw new ApkFormatException("Bad source stamp entry");
                        }
                    } else {
                        int i9 = i4;
                        ApkSignerEngine.InputJarEntryInstructions inputJarEntryInstructionsInputJarEntry = apkSignerEngine.inputJarEntry(name2);
                        int i10 = C08921.f2267x62cebf84[inputJarEntryInstructionsInputJarEntry.getOutputPolicy().ordinal()];
                        byte[] bArr3 = uncompressedData;
                        if (i10 == 1) {
                            z = true;
                        } else {
                            if (i10 != 2 && i10 != 3) {
                                throw new RuntimeException("Unknown output policy: " + inputJarEntryInstructionsInputJarEntry.getOutputPolicy());
                            }
                            z = false;
                        }
                        long localFileHeaderOffset = centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset.getLocalFileHeaderOffset();
                        if (localFileHeaderOffset > j2) {
                            long j4 = localFileHeaderOffset - j2;
                            bArr = bArr3;
                            list = zipCentralDirectory;
                            i2 = i5;
                            map = map3;
                            arrayList = arrayList3;
                            i = -1;
                            i3 = i9;
                            dataSourceSlice.feed(j2, j4, dataSink);
                            jOutputDataToOutputApk += j4;
                            j2 = localFileHeaderOffset;
                        } else {
                            map = map3;
                            arrayList = arrayList3;
                            bArr = bArr3;
                            i = -1;
                            list = zipCentralDirectory;
                            i2 = i5;
                            i3 = i9;
                        }
                        try {
                            LocalFileRecord record = LocalFileRecord.getRecord(dataSourceSlice, centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset, dataSourceSlice.size());
                            long size3 = j2 + record.getSize();
                            ApkSignerEngine.InspectJarEntryRequest inspectJarEntryRequest = inputJarEntryInstructionsInputJarEntry.getInspectJarEntryRequest();
                            if (inspectJarEntryRequest != null) {
                                fulfillInspectInputJarEntryRequest(dataSourceSlice, record, inspectJarEntryRequest);
                            }
                            if (z) {
                                int lastModificationDate = centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset.getLastModificationDate();
                                int lastModificationTime = centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset.getLastModificationTime();
                                if (i2 == i || lastModificationDate > i2 || (lastModificationDate == i2 && lastModificationTime > i3)) {
                                    i3 = lastModificationTime;
                                } else {
                                    lastModificationDate = i2;
                                }
                                ApkSignerEngine.InspectJarEntryRequest inspectJarEntryRequestOutputJarEntry2 = apkSignerEngine.outputJarEntry(name2);
                                if (inspectJarEntryRequestOutputJarEntry2 != null) {
                                    fulfillInspectInputJarEntryRequest(dataSourceSlice, record, inspectJarEntryRequestOutputJarEntry2);
                                }
                                j = size3;
                                long j5 = jOutputDataToOutputApk;
                                OutputSizeAndDataOffset outputSizeAndDataOffsetOutputInputJarEntryLfhRecordPreservingDataAlignment = outputInputJarEntryLfhRecordPreservingDataAlignment(dataSourceSlice, record, dataSink3, j5);
                                int i11 = lastModificationDate;
                                long j6 = outputSizeAndDataOffsetOutputInputJarEntryLfhRecordPreservingDataAlignment.outputBytes + j5;
                                long j7 = outputSizeAndDataOffsetOutputInputJarEntryLfhRecordPreservingDataAlignment.dataOffsetBytes + j5;
                                if (listExtractPinPatterns != null) {
                                    Iterator<Hints.PatternWithRange> it5 = listExtractPinPatterns.iterator();
                                    boolean z2 = false;
                                    while (it5.hasNext()) {
                                        Hints.PatternWithRange next = it5.next();
                                        Iterator<Hints.PatternWithRange> it6 = it5;
                                        if (!next.matcher(centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset.getName()).matches() || (byteRangeClampToAbsoluteByteRange = next.ClampToAbsoluteByteRange(new Hints.ByteRange(j7, j6))) == null) {
                                            arrayList2 = arrayList;
                                        } else {
                                            arrayList2 = arrayList;
                                            arrayList2.add(byteRangeClampToAbsoluteByteRange);
                                            z2 = true;
                                        }
                                        arrayList = arrayList2;
                                        it5 = it6;
                                    }
                                    arrayList3 = arrayList;
                                    if (z2) {
                                        arrayList3.add(new Hints.ByteRange(j5, j7));
                                    }
                                } else {
                                    arrayList3 = arrayList;
                                }
                                if (j5 != record.getStartOffsetInArchive()) {
                                    centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset = centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset.createWithModifiedLocalFileHeaderOffset(j5);
                                }
                                map2 = map;
                                map2.put(name2, centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset);
                                jOutputDataToOutputApk = j6;
                                i5 = i11;
                            } else {
                                j = size3;
                                arrayList3 = arrayList;
                                map2 = map;
                                i5 = i2;
                            }
                            i4 = i3;
                            map3 = map2;
                            zipSectionsFindZipSections = zipSections;
                            zipCentralDirectory = list;
                            j2 = j;
                            uncompressedData = bArr;
                            dataSink3 = dataSink;
                        } catch (ZipFormatException e) {
                            throw new ApkFormatException("Malformed ZIP entry: " + centralDirectoryRecordCreateWithModifiedLocalFileHeaderOffset.getName(), e);
                        }
                    }
                }
                zipSectionsFindZipSections = zipSections;
            }
        } catch (ZipFormatException e2) {
            throw new ApkFormatException("Malformed APK: not a ZIP archive", e2);
        }
    }
}
