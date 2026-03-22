package com.android.apksig;

import android.support.v7.widget.ActivityChooserView;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtilsLite;
import com.android.apksig.internal.apk.ApkSigResult;
import com.android.apksig.internal.apk.ApkSignerInfo;
import com.android.apksig.internal.apk.ApkSigningBlockUtilsLite;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.apk.SignatureAlgorithm;
import com.android.apksig.internal.apk.SignatureInfo;
import com.android.apksig.internal.apk.SignatureNotFoundException;
import com.android.apksig.internal.apk.stamp.V2SourceStampVerifier;
import com.android.apksig.internal.util.GuaranteedEncodedFormX509Certificate;
import com.android.apksig.internal.zip.CentralDirectoryRecord;
import com.android.apksig.internal.zip.LocalFileRecord;
import com.android.apksig.internal.zip.ZipUtils;
import com.android.apksig.util.DataSource;
import com.android.apksig.util.DataSources;
import com.android.apksig.zip.ZipFormatException;
import com.android.apksig.zip.ZipSections;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SourceStampVerifier {
    public final DataSource mApkDataSource;
    public final File mApkFile;
    public final int mMaxSdkVersion;
    public final int mMinSdkVersion;

    public static class Builder {
        public final DataSource mApkDataSource;
        public final File mApkFile;
        public int mMinSdkVersion = 1;
        public int mMaxSdkVersion = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

        public Builder(DataSource dataSource) {
            if (dataSource == null) {
                throw new NullPointerException("apk == null");
            }
            this.mApkDataSource = dataSource;
            this.mApkFile = null;
        }

        public Builder(File file) {
            if (file == null) {
                throw new NullPointerException("apk == null");
            }
            this.mApkFile = file;
            this.mApkDataSource = null;
        }

        public SourceStampVerifier build() {
            return new SourceStampVerifier(this.mApkFile, this.mApkDataSource, this.mMinSdkVersion, this.mMaxSdkVersion);
        }

        public Builder setMaxCheckedPlatformVersion(int i) {
            this.mMaxSdkVersion = i;
            return this;
        }

        public Builder setMinCheckedPlatformVersion(int i) {
            this.mMinSdkVersion = i;
            return this;
        }
    }

    public static class Result {
        public final List<List<SignerInfo>> mAllSchemeSigners;
        public final List<ApkVerificationIssue> mErrors;
        public SourceStampInfo mSourceStampInfo;
        public final List<SignerInfo> mV1SchemeSigners;
        public final List<SignerInfo> mV2SchemeSigners;
        public final List<SignerInfo> mV3SchemeSigners;
        public boolean mVerified;
        public final List<ApkVerificationIssue> mWarnings;

        public static class SignerInfo {
            public X509Certificate mSigningCertificate;
            public final List<ApkVerificationIssue> mErrors = new ArrayList();
            public final List<ApkVerificationIssue> mWarnings = new ArrayList();

            public void addVerificationWarning(int i, Object... objArr) {
                this.mWarnings.add(new ApkVerificationIssue(i, objArr));
            }

            public boolean containsErrors() {
                return !this.mErrors.isEmpty();
            }

            public List<ApkVerificationIssue> getErrors() {
                return this.mErrors;
            }

            public X509Certificate getSigningCertificate() {
                return this.mSigningCertificate;
            }

            public List<ApkVerificationIssue> getWarnings() {
                return this.mWarnings;
            }

            public void setSigningCertificate(X509Certificate x509Certificate) {
                this.mSigningCertificate = x509Certificate;
            }
        }

        public static class SourceStampInfo {
            public final List<X509Certificate> mCertificateLineage;
            public final List<X509Certificate> mCertificates;
            public final List<ApkVerificationIssue> mErrors;
            public final List<ApkVerificationIssue> mWarnings;

            public SourceStampInfo(ApkSignerInfo apkSignerInfo) {
                ArrayList arrayList = new ArrayList();
                this.mErrors = arrayList;
                ArrayList arrayList2 = new ArrayList();
                this.mWarnings = arrayList2;
                this.mCertificates = apkSignerInfo.certs;
                this.mCertificateLineage = apkSignerInfo.certificateLineage;
                arrayList.addAll(apkSignerInfo.getErrors());
                arrayList2.addAll(apkSignerInfo.getWarnings());
            }

            public boolean containsErrors() {
                return (this.mErrors.isEmpty() && this.mWarnings.isEmpty()) ? false : true;
            }

            public X509Certificate getCertificate() {
                if (this.mCertificates.isEmpty()) {
                    return null;
                }
                return this.mCertificates.get(0);
            }

            public List<X509Certificate> getCertificatesInLineage() {
                return this.mCertificateLineage;
            }

            public List<ApkVerificationIssue> getErrors() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mErrors);
                arrayList.addAll(this.mWarnings);
                return arrayList;
            }

            public List<ApkVerificationIssue> getWarnings() {
                return this.mWarnings;
            }
        }

        public Result() {
            ArrayList arrayList = new ArrayList();
            this.mV1SchemeSigners = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mV2SchemeSigners = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.mV3SchemeSigners = arrayList3;
            this.mAllSchemeSigners = Arrays.asList(arrayList, arrayList2, arrayList3);
            this.mErrors = new ArrayList();
            this.mWarnings = new ArrayList();
        }

        public final void addV1Signer(SignerInfo signerInfo) {
            this.mV1SchemeSigners.add(signerInfo);
        }

        public final void addV2Signer(SignerInfo signerInfo) {
            this.mV2SchemeSigners.add(signerInfo);
        }

        public final void addV3Signer(SignerInfo signerInfo) {
            this.mV3SchemeSigners.add(signerInfo);
        }

        public void addVerificationError(int i, Object... objArr) {
            this.mErrors.add(new ApkVerificationIssue(i, objArr));
        }

        public void addVerificationWarning(int i, Object... objArr) {
            this.mWarnings.add(new ApkVerificationIssue(i, objArr));
        }

        public boolean containsErrors() {
            if (!this.mErrors.isEmpty()) {
                return true;
            }
            Iterator<List<SignerInfo>> it = this.mAllSchemeSigners.iterator();
            while (it.hasNext()) {
                Iterator<SignerInfo> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    if (it2.next().containsErrors()) {
                        return true;
                    }
                }
            }
            SourceStampInfo sourceStampInfo = this.mSourceStampInfo;
            return sourceStampInfo != null && sourceStampInfo.containsErrors();
        }

        public List<ApkVerificationIssue> getAllErrors() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mErrors);
            Iterator<List<SignerInfo>> it = this.mAllSchemeSigners.iterator();
            while (it.hasNext()) {
                Iterator<SignerInfo> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    arrayList.addAll(it2.next().getErrors());
                }
            }
            SourceStampInfo sourceStampInfo = this.mSourceStampInfo;
            if (sourceStampInfo != null) {
                arrayList.addAll(sourceStampInfo.getErrors());
            }
            return arrayList;
        }

        public List<ApkVerificationIssue> getAllWarnings() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mWarnings);
            Iterator<List<SignerInfo>> it = this.mAllSchemeSigners.iterator();
            while (it.hasNext()) {
                Iterator<SignerInfo> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    arrayList.addAll(it2.next().getWarnings());
                }
            }
            SourceStampInfo sourceStampInfo = this.mSourceStampInfo;
            if (sourceStampInfo != null) {
                arrayList.addAll(sourceStampInfo.getWarnings());
            }
            return arrayList;
        }

        public List<ApkVerificationIssue> getErrors() {
            return this.mErrors;
        }

        public SourceStampInfo getSourceStampInfo() {
            return this.mSourceStampInfo;
        }

        public List<SignerInfo> getV1SchemeSigners() {
            return this.mV1SchemeSigners;
        }

        public List<SignerInfo> getV2SchemeSigners() {
            return this.mV2SchemeSigners;
        }

        public List<SignerInfo> getV3SchemeSigners() {
            return this.mV3SchemeSigners;
        }

        public List<ApkVerificationIssue> getWarnings() {
            return this.mWarnings;
        }

        public boolean isVerified() {
            return this.mVerified;
        }

        public final void mergeFrom(ApkSigResult apkSigResult) {
            if (apkSigResult.signatureSchemeVersion != 0) {
                throw new IllegalArgumentException("Unknown ApkSigResult Signing Block Scheme Id " + apkSigResult.signatureSchemeVersion);
            }
            this.mVerified = apkSigResult.verified;
            if (apkSigResult.mSigners.isEmpty()) {
                return;
            }
            this.mSourceStampInfo = new SourceStampInfo(apkSigResult.mSigners.get(0));
        }
    }

    public SourceStampVerifier(File file, DataSource dataSource, int i, int i2) {
        this.mApkFile = file;
        this.mApkDataSource = dataSource;
        this.mMinSdkVersion = i;
        this.mMaxSdkVersion = i2;
    }

    public static Map<ContentDigestAlgorithm, byte[]> getApkContentDigestFromV1SigningScheme(List<CentralDirectoryRecord> list, DataSource dataSource, ZipSections zipSections, Result result) throws IOException, ApkFormatException {
        ArrayList<CentralDirectoryRecord> arrayList = new ArrayList(1);
        EnumMap enumMap = new EnumMap(ContentDigestAlgorithm.class);
        CentralDirectoryRecord centralDirectoryRecord = null;
        for (CentralDirectoryRecord centralDirectoryRecord2 : list) {
            String name = centralDirectoryRecord2.getName();
            if (name != null) {
                if (centralDirectoryRecord == null && "META-INF/MANIFEST.MF".equals(name)) {
                    centralDirectoryRecord = centralDirectoryRecord2;
                } else if (name.startsWith("META-INF/") && (name.endsWith(".RSA") || name.endsWith(".DSA") || name.endsWith(".EC"))) {
                    arrayList.add(centralDirectoryRecord2);
                }
            }
        }
        if (centralDirectoryRecord == null) {
            return enumMap;
        }
        if (arrayList.isEmpty()) {
            result.addVerificationWarning(36, new Object[0]);
        } else {
            for (CentralDirectoryRecord centralDirectoryRecord3 : arrayList) {
                try {
                    Iterator<? extends Certificate> it = CertificateFactory.getInstance("X.509").generateCertificates(new ByteArrayInputStream(LocalFileRecord.getUncompressedData(dataSource, centralDirectoryRecord3, zipSections.getZipCentralDirectoryOffset()))).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Certificate next = it.next();
                            if (next instanceof X509Certificate) {
                                Result.SignerInfo signerInfo = new Result.SignerInfo();
                                signerInfo.setSigningCertificate((X509Certificate) next);
                                result.addV1Signer(signerInfo);
                                break;
                            }
                        }
                    }
                } catch (ZipFormatException e) {
                    throw new ApkFormatException("Failed to read APK", e);
                } catch (CertificateException e2) {
                    result.addVerificationWarning(37, centralDirectoryRecord3.getName(), e2);
                }
            }
        }
        try {
            enumMap.put(ContentDigestAlgorithm.SHA256, ApkUtilsLite.computeSha256DigestBytes(LocalFileRecord.getUncompressedData(dataSource, centralDirectoryRecord, zipSections.getZipCentralDirectoryOffset())));
            return enumMap;
        } catch (ZipFormatException e3) {
            throw new ApkFormatException("Failed to read APK", e3);
        }
    }

    public static void parseSigner(ByteBuffer byteBuffer, int i, CertificateFactory certificateFactory, Map<ContentDigestAlgorithm, byte[]> map, Result.SignerInfo signerInfo) throws ApkFormatException {
        boolean z = i == 2;
        ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtilsLite.getLengthPrefixedSlice(byteBuffer);
        ByteBuffer lengthPrefixedSlice2 = ApkSigningBlockUtilsLite.getLengthPrefixedSlice(lengthPrefixedSlice);
        ByteBuffer lengthPrefixedSlice3 = ApkSigningBlockUtilsLite.getLengthPrefixedSlice(lengthPrefixedSlice);
        while (lengthPrefixedSlice2.hasRemaining()) {
            try {
                ByteBuffer lengthPrefixedSlice4 = ApkSigningBlockUtilsLite.getLengthPrefixedSlice(lengthPrefixedSlice2);
                int i2 = lengthPrefixedSlice4.getInt();
                byte[] lengthPrefixedByteArray = ApkSigningBlockUtilsLite.readLengthPrefixedByteArray(lengthPrefixedSlice4);
                SignatureAlgorithm signatureAlgorithmFindById = SignatureAlgorithm.findById(i2);
                if (signatureAlgorithmFindById != null) {
                    map.put(signatureAlgorithmFindById.getContentDigestAlgorithm(), lengthPrefixedByteArray);
                }
            } catch (ApkFormatException | BufferUnderflowException unused) {
                signerInfo.addVerificationWarning(z ? 8 : 16, new Object[0]);
                return;
            }
        }
        if (lengthPrefixedSlice3.hasRemaining()) {
            byte[] lengthPrefixedByteArray2 = ApkSigningBlockUtilsLite.readLengthPrefixedByteArray(lengthPrefixedSlice3);
            try {
                signerInfo.setSigningCertificate(new GuaranteedEncodedFormX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(lengthPrefixedByteArray2)), lengthPrefixedByteArray2));
            } catch (CertificateException unused2) {
                signerInfo.addVerificationWarning(z ? 6 : 14, new Object[0]);
                return;
            }
        }
        if (signerInfo.getSigningCertificate() == null) {
            signerInfo.addVerificationWarning(z ? 7 : 15, new Object[0]);
        }
    }

    public static void parseSigners(ByteBuffer byteBuffer, int i, Map<ContentDigestAlgorithm, byte[]> map, Result result) {
        boolean z = i == 2;
        try {
            ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtilsLite.getLengthPrefixedSlice(byteBuffer);
            if (!lengthPrefixedSlice.hasRemaining()) {
                result.addVerificationWarning(z ? 2 : 10, new Object[0]);
                return;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                while (lengthPrefixedSlice.hasRemaining()) {
                    Result.SignerInfo signerInfo = new Result.SignerInfo();
                    if (z) {
                        result.addV2Signer(signerInfo);
                    } else {
                        result.addV3Signer(signerInfo);
                    }
                    try {
                        parseSigner(ApkSigningBlockUtilsLite.getLengthPrefixedSlice(lengthPrefixedSlice), i, certificateFactory, map, signerInfo);
                    } catch (ApkFormatException | BufferUnderflowException unused) {
                        signerInfo.addVerificationWarning(z ? 3 : 11, new Object[0]);
                        return;
                    }
                }
            } catch (CertificateException e) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e);
            }
        } catch (ApkFormatException unused2) {
            result.addVerificationWarning(z ? 1 : 9, new Object[0]);
        }
    }

    public Result verifySourceStamp() {
        return verifySourceStamp(null);
    }

    public final Result verifySourceStamp(DataSource dataSource, String str) {
        CentralDirectoryRecord next;
        SignatureInfo signatureInfoFindSignature;
        SignatureInfo signatureInfoFindSignature2;
        boolean z;
        Result result = new Result();
        try {
            try {
                ZipSections zipSectionsFindZipSections = ApkUtilsLite.findZipSections(dataSource);
                List<CentralDirectoryRecord> zipCentralDirectory = ZipUtils.parseZipCentralDirectory(dataSource, zipSectionsFindZipSections);
                Iterator<CentralDirectoryRecord> it = zipCentralDirectory.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if ("stamp-cert-sha256".equals(next.getName())) {
                        break;
                    }
                }
                if (next == null) {
                    try {
                        ApkSigningBlockUtilsLite.findSignature(dataSource, zipSectionsFindZipSections, 1845461005);
                        z = true;
                    } catch (SignatureNotFoundException unused) {
                        z = false;
                    }
                    result.addVerificationError(z ? 24 : 25, new Object[0]);
                    return result;
                }
                byte[] uncompressedData = LocalFileRecord.getUncompressedData(dataSource, next, zipSectionsFindZipSections.getZipCentralDirectoryOffset());
                if (str != null) {
                    String hex = ApkSigningBlockUtilsLite.toHex(uncompressedData);
                    if (!str.equalsIgnoreCase(hex)) {
                        result.addVerificationError(23, hex, str);
                        return result;
                    }
                }
                HashMap map = new HashMap();
                if (this.mMaxSdkVersion >= 28) {
                    try {
                        signatureInfoFindSignature2 = ApkSigningBlockUtilsLite.findSignature(dataSource, zipSectionsFindZipSections, -262969152);
                    } catch (SignatureNotFoundException unused2) {
                        signatureInfoFindSignature2 = null;
                    }
                    if (signatureInfoFindSignature2 != null) {
                        EnumMap enumMap = new EnumMap(ContentDigestAlgorithm.class);
                        parseSigners(signatureInfoFindSignature2.signatureBlock, 3, enumMap, result);
                        map.put(3, enumMap);
                    }
                }
                if (this.mMaxSdkVersion >= 24 && (this.mMinSdkVersion < 28 || map.isEmpty())) {
                    try {
                        signatureInfoFindSignature = ApkSigningBlockUtilsLite.findSignature(dataSource, zipSectionsFindZipSections, 1896449818);
                    } catch (SignatureNotFoundException unused3) {
                        signatureInfoFindSignature = null;
                    }
                    if (signatureInfoFindSignature != null) {
                        EnumMap enumMap2 = new EnumMap(ContentDigestAlgorithm.class);
                        parseSigners(signatureInfoFindSignature.signatureBlock, 2, enumMap2, result);
                        map.put(2, enumMap2);
                    }
                }
                if (this.mMinSdkVersion < 24 || map.isEmpty()) {
                    map.put(1, getApkContentDigestFromV1SigningScheme(zipCentralDirectory, dataSource, zipSectionsFindZipSections, result));
                }
                result.mergeFrom(V2SourceStampVerifier.verify(dataSource, zipSectionsFindZipSections, uncompressedData, map, this.mMinSdkVersion, this.mMaxSdkVersion));
                return result;
            } catch (ApkFormatException e) {
                e = e;
                result.addVerificationError(28, e);
                return result;
            } catch (ZipFormatException e2) {
                e = e2;
                result.addVerificationError(28, e);
                return result;
            } catch (IOException e3) {
                e = e3;
                result.addVerificationError(28, e);
                return result;
            } catch (NoSuchAlgorithmException e4) {
                result.addVerificationError(29, e4);
                return result;
            }
        } catch (SignatureNotFoundException unused4) {
            result.addVerificationError(30, new Object[0]);
            return result;
        }
    }

    public Result verifySourceStamp(String str) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                DataSource dataSourceAsDataSource = this.mApkDataSource;
                if (dataSourceAsDataSource == null) {
                    if (this.mApkFile == null) {
                        throw new IllegalStateException("APK not provided");
                    }
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.mApkFile, "r");
                    try {
                        dataSourceAsDataSource = DataSources.asDataSource(randomAccessFile2, 0L, randomAccessFile2.length());
                        randomAccessFile = randomAccessFile2;
                    } catch (IOException e) {
                        e = e;
                        randomAccessFile = randomAccessFile2;
                        Result result = new Result();
                        result.addVerificationError(29, e);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused) {
                            }
                        }
                        return result;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
                Result resultVerifySourceStamp = verifySourceStamp(dataSourceAsDataSource, str);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                }
                return resultVerifySourceStamp;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
