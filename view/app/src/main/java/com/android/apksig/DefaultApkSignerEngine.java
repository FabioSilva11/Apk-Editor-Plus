package com.android.apksig;

import android.support.v7.widget.ActivityChooserView;
import com.android.apksig.ApkSignerEngine;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.apk.SignatureAlgorithm;
import com.android.apksig.internal.apk.p044v1.DigestAlgorithm;
import com.android.apksig.internal.apk.p044v1.V1SchemeSigner;
import com.android.apksig.internal.apk.p044v1.V1SchemeVerifier;
import com.android.apksig.internal.apk.p045v2.V2SchemeSigner;
import com.android.apksig.internal.apk.p046v3.V3SchemeSigner;
import com.android.apksig.internal.apk.p047v4.V4SchemeSigner;
import com.android.apksig.internal.apk.p047v4.V4Signature;
import com.android.apksig.internal.apk.stamp.V2SourceStampSigner;
import com.android.apksig.internal.jar.ManifestParser;
import com.android.apksig.internal.util.Pair;
import com.android.apksig.internal.util.TeeDataSink;
import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSinks;
import com.android.apksig.util.DataSource;
import com.android.apksig.util.RunnablesExecutor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DefaultApkSignerEngine implements ApkSignerEngine {
    public OutputApkSigningBlockRequestImpl mAddSigningBlockRequest;
    public OutputJarSignatureRequestImpl mAddV1SignatureRequest;
    public boolean mClosed;
    public final String mCreatedBy;
    public Boolean mDebuggable;
    public final boolean mDebuggableApkPermitted;
    public final Map<String, byte[]> mEmittedSignatureJarEntryData;
    public RunnablesExecutor mExecutor;
    public GetJarEntryDataRequest mInputJarManifestEntryDataRequest;
    public final int mMinSdkVersion;
    public final boolean mOtherSignersSignaturesPreserved;
    public GetJarEntryDataRequest mOutputAndroidManifestEntryDataRequest;
    public final Map<String, GetJarEntryDataDigestRequest> mOutputJarEntryDigestRequests;
    public final Map<String, byte[]> mOutputJarEntryDigests;
    public final Map<String, GetJarEntryDataRequest> mOutputSignatureJarEntryDataRequests;
    public Set<String> mSignatureExpectedOutputJarEntryNames;
    public final List<SignerConfig> mSignerConfigs;
    public final SigningCertificateLineage mSigningCertificateLineage;
    public final SignerConfig mSourceStampSignerConfig;
    public final SigningCertificateLineage mSourceStampSigningCertificateLineage;
    public DigestAlgorithm mV1ContentDigestAlgorithm;
    public boolean mV1SignaturePending;
    public List<V1SchemeSigner.SignerConfig> mV1SignerConfigs;
    public final boolean mV1SigningEnabled;
    public boolean mV2SignaturePending;
    public final boolean mV2SigningEnabled;
    public boolean mV3SignaturePending;
    public final boolean mV3SigningEnabled;
    public final boolean mVerityEnabled;

    /* JADX INFO: renamed from: com.android.apksig.DefaultApkSignerEngine$1 */
    public static /* synthetic */ class C08941 {

        /* JADX INFO: renamed from: $SwitchMap$com$android$apksig$ApkSignerEngine$InputJarEntryInstructions$OutputPolicy */
        public static final /* synthetic */ int[] f2275x62cebf84;

        static {
            int[] iArr = new int[ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.values().length];
            f2275x62cebf84 = iArr;
            try {
                iArr[ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.SKIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2275x62cebf84[ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2275x62cebf84[ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT_BY_ENGINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Builder {
        public final int mMinSdkVersion;
        public boolean mOtherSignersSignaturesPreserved;
        public List<SignerConfig> mSignerConfigs;
        public SigningCertificateLineage mSigningCertificateLineage;
        public SigningCertificateLineage mSourceStampSigningCertificateLineage;
        public SignerConfig mStampSignerConfig;
        public boolean mV3SigningEnabled;
        public boolean mV1SigningEnabled = true;
        public boolean mV2SigningEnabled = true;
        public boolean mVerityEnabled = false;
        public boolean mDebuggableApkPermitted = true;
        public String mCreatedBy = "1.0 (Android)";
        public boolean mV3SigningExplicitlyDisabled = false;
        public boolean mV3SigningExplicitlyEnabled = false;

        public Builder(List<SignerConfig> list, int i) {
            this.mV3SigningEnabled = true;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("At least one signer config must be provided");
            }
            if (list.size() > 1) {
                this.mV3SigningEnabled = false;
            }
            this.mSignerConfigs = new ArrayList(list);
            this.mMinSdkVersion = i;
        }

        public DefaultApkSignerEngine build() throws InvalidKeyException {
            boolean z = this.mV3SigningExplicitlyDisabled;
            if (z && this.mV3SigningExplicitlyEnabled) {
                throw new IllegalStateException("Builder configured to both enable and disable APK Signature Scheme v3 signing");
            }
            if (z) {
                this.mV3SigningEnabled = false;
            } else if (this.mV3SigningExplicitlyEnabled) {
                this.mV3SigningEnabled = true;
            }
            SigningCertificateLineage signingCertificateLineage = this.mSigningCertificateLineage;
            if (signingCertificateLineage != null) {
                try {
                    List<SignerConfig> listSortSignerConfigs = signingCertificateLineage.sortSignerConfigs(this.mSignerConfigs);
                    this.mSignerConfigs = listSortSignerConfigs;
                    if (!this.mV3SigningEnabled && listSortSignerConfigs.size() > 1) {
                        throw new IllegalStateException("Provided multiple signers which are part of the SigningCertificateLineage, but not signing with APK Signature Scheme v3");
                    }
                } catch (IllegalArgumentException e) {
                    throw new IllegalStateException("Provided signer configs do not match the provided SigningCertificateLineage", e);
                }
            } else if (this.mV3SigningEnabled && this.mSignerConfigs.size() > 1) {
                throw new IllegalStateException("Multiple signing certificates provided for use with APK Signature Scheme v3 without an accompanying SigningCertificateLineage");
            }
            return new DefaultApkSignerEngine(this.mSignerConfigs, this.mStampSignerConfig, this.mSourceStampSigningCertificateLineage, this.mMinSdkVersion, this.mV1SigningEnabled, this.mV2SigningEnabled, this.mV3SigningEnabled, this.mVerityEnabled, this.mDebuggableApkPermitted, this.mOtherSignersSignaturesPreserved, this.mCreatedBy, this.mSigningCertificateLineage, null);
        }

        public Builder setCreatedBy(String str) {
            str.getClass();
            this.mCreatedBy = str;
            return this;
        }

        public Builder setDebuggableApkPermitted(boolean z) {
            this.mDebuggableApkPermitted = z;
            return this;
        }

        public Builder setOtherSignersSignaturesPreserved(boolean z) {
            this.mOtherSignersSignaturesPreserved = z;
            return this;
        }

        public Builder setSigningCertificateLineage(SigningCertificateLineage signingCertificateLineage) {
            if (signingCertificateLineage != null) {
                this.mV3SigningEnabled = true;
                this.mSigningCertificateLineage = signingCertificateLineage;
            }
            return this;
        }

        public Builder setSourceStampSigningCertificateLineage(SigningCertificateLineage signingCertificateLineage) {
            this.mSourceStampSigningCertificateLineage = signingCertificateLineage;
            return this;
        }

        public Builder setStampSignerConfig(SignerConfig signerConfig) {
            this.mStampSignerConfig = signerConfig;
            return this;
        }

        public Builder setV1SigningEnabled(boolean z) {
            this.mV1SigningEnabled = z;
            return this;
        }

        public Builder setV2SigningEnabled(boolean z) {
            this.mV2SigningEnabled = z;
            return this;
        }

        public Builder setV3SigningEnabled(boolean z) {
            this.mV3SigningEnabled = z;
            if (z) {
                this.mV3SigningExplicitlyEnabled = true;
            } else {
                this.mV3SigningExplicitlyDisabled = true;
            }
            return this;
        }

        public Builder setVerityEnabled(boolean z) {
            this.mVerityEnabled = z;
            return this;
        }
    }

    public static class CompoundInspectJarEntryRequest implements ApkSignerEngine.InspectJarEntryRequest {
        public final String mEntryName;
        public final Object mLock;
        public final ApkSignerEngine.InspectJarEntryRequest[] mRequests;
        public DataSink mSink;

        public CompoundInspectJarEntryRequest(String str, ApkSignerEngine.InspectJarEntryRequest... inspectJarEntryRequestArr) {
            this.mLock = new Object();
            this.mEntryName = str;
            this.mRequests = inspectJarEntryRequestArr;
        }

        public /* synthetic */ CompoundInspectJarEntryRequest(String str, ApkSignerEngine.InspectJarEntryRequest[] inspectJarEntryRequestArr, C08941 c08941) {
            this(str, inspectJarEntryRequestArr);
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public void done() {
            for (ApkSignerEngine.InspectJarEntryRequest inspectJarEntryRequest : this.mRequests) {
                inspectJarEntryRequest.done();
            }
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public DataSink getDataSink() {
            DataSink dataSink;
            synchronized (this.mLock) {
                if (this.mSink == null) {
                    int length = this.mRequests.length;
                    DataSink[] dataSinkArr = new DataSink[length];
                    for (int i = 0; i < length; i++) {
                        dataSinkArr[i] = this.mRequests[i].getDataSink();
                    }
                    this.mSink = new TeeDataSink(dataSinkArr);
                }
                dataSink = this.mSink;
            }
            return dataSink;
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public String getEntryName() {
            return this.mEntryName;
        }
    }

    public static class GetJarEntryDataDigestRequest implements ApkSignerEngine.InspectJarEntryRequest {
        public DataSink mDataSink;
        public byte[] mDigest;
        public boolean mDone;
        public final String mEntryName;
        public final String mJcaDigestAlgorithm;
        public final Object mLock;
        public MessageDigest mMessageDigest;

        public GetJarEntryDataDigestRequest(String str, String str2) {
            this.mLock = new Object();
            this.mEntryName = str;
            this.mJcaDigestAlgorithm = str2;
        }

        public /* synthetic */ GetJarEntryDataDigestRequest(String str, String str2, C08941 c08941) {
            this(str, str2);
        }

        public final void checkNotDone() throws IllegalStateException {
            synchronized (this.mLock) {
                if (this.mDone) {
                    throw new IllegalStateException("Already done");
                }
            }
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public void done() {
            synchronized (this.mLock) {
                if (this.mDone) {
                    return;
                }
                this.mDone = true;
                this.mDigest = getMessageDigest().digest();
                this.mMessageDigest = null;
                this.mDataSink = null;
            }
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public DataSink getDataSink() {
            DataSink dataSink;
            synchronized (this.mLock) {
                checkNotDone();
                if (this.mDataSink == null) {
                    this.mDataSink = DataSinks.asDataSink(getMessageDigest());
                }
                dataSink = this.mDataSink;
            }
            return dataSink;
        }

        public final byte[] getDigest() {
            byte[] bArr;
            synchronized (this.mLock) {
                if (!this.mDone) {
                    throw new IllegalStateException("Not yet done");
                }
                bArr = (byte[]) this.mDigest.clone();
            }
            return bArr;
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public String getEntryName() {
            return this.mEntryName;
        }

        public final MessageDigest getMessageDigest() {
            MessageDigest messageDigest;
            synchronized (this.mLock) {
                if (this.mMessageDigest == null) {
                    try {
                        this.mMessageDigest = MessageDigest.getInstance(this.mJcaDigestAlgorithm);
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(this.mJcaDigestAlgorithm + " MessageDigest not available", e);
                    }
                }
                messageDigest = this.mMessageDigest;
            }
            return messageDigest;
        }

        public final boolean isDone() {
            boolean z;
            synchronized (this.mLock) {
                z = this.mDone;
            }
            return z;
        }
    }

    public static class GetJarEntryDataRequest implements ApkSignerEngine.InspectJarEntryRequest {
        public DataSink mDataSink;
        public ByteArrayOutputStream mDataSinkBuf;
        public boolean mDone;
        public final String mEntryName;
        public final Object mLock;

        public GetJarEntryDataRequest(String str) {
            this.mLock = new Object();
            this.mEntryName = str;
        }

        public /* synthetic */ GetJarEntryDataRequest(String str, C08941 c08941) {
            this(str);
        }

        public final void checkNotDone() throws IllegalStateException {
            synchronized (this.mLock) {
                if (this.mDone) {
                    throw new IllegalStateException("Already done");
                }
            }
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public void done() {
            synchronized (this.mLock) {
                if (this.mDone) {
                    return;
                }
                this.mDone = true;
            }
        }

        public final byte[] getData() {
            byte[] byteArray;
            synchronized (this.mLock) {
                if (!this.mDone) {
                    throw new IllegalStateException("Not yet done");
                }
                ByteArrayOutputStream byteArrayOutputStream = this.mDataSinkBuf;
                byteArray = byteArrayOutputStream != null ? byteArrayOutputStream.toByteArray() : new byte[0];
            }
            return byteArray;
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public DataSink getDataSink() {
            DataSink dataSink;
            synchronized (this.mLock) {
                checkNotDone();
                if (this.mDataSinkBuf == null) {
                    this.mDataSinkBuf = new ByteArrayOutputStream();
                }
                if (this.mDataSink == null) {
                    this.mDataSink = DataSinks.asDataSink(this.mDataSinkBuf);
                }
                dataSink = this.mDataSink;
            }
            return dataSink;
        }

        @Override // com.android.apksig.ApkSignerEngine.InspectJarEntryRequest
        public String getEntryName() {
            return this.mEntryName;
        }

        public final boolean isDone() {
            boolean z;
            synchronized (this.mLock) {
                z = this.mDone;
            }
            return z;
        }
    }

    public static class OutputApkSigningBlockRequestImpl implements ApkSignerEngine.OutputApkSigningBlockRequest, ApkSignerEngine.OutputApkSigningBlockRequest2 {
        public final byte[] mApkSigningBlock;
        public volatile boolean mDone;
        public final int mPaddingBeforeApkSigningBlock;

        public OutputApkSigningBlockRequestImpl(byte[] bArr, int i) {
            this.mApkSigningBlock = (byte[]) bArr.clone();
            this.mPaddingBeforeApkSigningBlock = i;
        }

        public /* synthetic */ OutputApkSigningBlockRequestImpl(byte[] bArr, int i, C08941 c08941) {
            this(bArr, i);
        }

        @Override // com.android.apksig.ApkSignerEngine.OutputApkSigningBlockRequest, com.android.apksig.ApkSignerEngine.OutputApkSigningBlockRequest2
        public void done() {
            this.mDone = true;
        }

        @Override // com.android.apksig.ApkSignerEngine.OutputApkSigningBlockRequest, com.android.apksig.ApkSignerEngine.OutputApkSigningBlockRequest2
        public byte[] getApkSigningBlock() {
            return (byte[]) this.mApkSigningBlock.clone();
        }

        @Override // com.android.apksig.ApkSignerEngine.OutputApkSigningBlockRequest2
        public int getPaddingSizeBeforeApkSigningBlock() {
            return this.mPaddingBeforeApkSigningBlock;
        }

        public final boolean isDone() {
            return this.mDone;
        }
    }

    public static class OutputJarSignatureRequestImpl implements ApkSignerEngine.OutputJarSignatureRequest {
        public final List<ApkSignerEngine.OutputJarSignatureRequest.JarEntry> mAdditionalJarEntries;
        public volatile boolean mDone;

        public OutputJarSignatureRequestImpl(List<ApkSignerEngine.OutputJarSignatureRequest.JarEntry> list) {
            this.mAdditionalJarEntries = Collections.unmodifiableList(new ArrayList(list));
        }

        public /* synthetic */ OutputJarSignatureRequestImpl(List list, C08941 c08941) {
            this(list);
        }

        @Override // com.android.apksig.ApkSignerEngine.OutputJarSignatureRequest
        public void done() {
            this.mDone = true;
        }

        @Override // com.android.apksig.ApkSignerEngine.OutputJarSignatureRequest
        public List<ApkSignerEngine.OutputJarSignatureRequest.JarEntry> getAdditionalJarEntries() {
            return this.mAdditionalJarEntries;
        }

        public final boolean isDone() {
            return this.mDone;
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

        public /* synthetic */ SignerConfig(String str, PrivateKey privateKey, List list, C08941 c08941) {
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

    public DefaultApkSignerEngine(List<SignerConfig> list, SignerConfig signerConfig, SigningCertificateLineage signingCertificateLineage, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, SigningCertificateLineage signingCertificateLineage2) throws InvalidKeyException {
        this.mV1SignerConfigs = Collections.emptyList();
        this.mSignatureExpectedOutputJarEntryNames = Collections.emptySet();
        this.mOutputJarEntryDigestRequests = new HashMap();
        this.mOutputJarEntryDigests = new HashMap();
        this.mEmittedSignatureJarEntryData = new HashMap();
        this.mOutputSignatureJarEntryDataRequests = new HashMap();
        this.mExecutor = RunnablesExecutor.MULTI_THREADED;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        if (z6) {
            throw new UnsupportedOperationException("Preserving other signer's signatures is not yet implemented");
        }
        this.mV1SigningEnabled = z;
        this.mV2SigningEnabled = z2;
        this.mV3SigningEnabled = z3;
        this.mVerityEnabled = z4;
        this.mV1SignaturePending = z;
        this.mV2SignaturePending = z2;
        this.mV3SignaturePending = z3;
        this.mDebuggableApkPermitted = z5;
        this.mOtherSignersSignaturesPreserved = z6;
        this.mCreatedBy = str;
        this.mSignerConfigs = list;
        this.mSourceStampSignerConfig = signerConfig;
        this.mSourceStampSigningCertificateLineage = signingCertificateLineage;
        this.mMinSdkVersion = i;
        this.mSigningCertificateLineage = signingCertificateLineage2;
        if (z) {
            if (!z3) {
                createV1SignerConfigs(list, i);
                return;
            }
            SignerConfig signerConfig2 = list.get(0);
            if (signingCertificateLineage2 != null && signingCertificateLineage2.getSubLineage((X509Certificate) signerConfig2.mCertificates.get(0)).size() != 1) {
                throw new IllegalArgumentException("v1 signing enabled but the oldest signer in the SigningCertificateLineage is missing.  Please provide the oldest signer to enable v1 signing");
            }
            createV1SignerConfigs(Collections.singletonList(signerConfig2), i);
        }
    }

    public /* synthetic */ DefaultApkSignerEngine(List list, SignerConfig signerConfig, SigningCertificateLineage signingCertificateLineage, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, SigningCertificateLineage signingCertificateLineage2, C08941 c08941) throws InvalidKeyException {
        this(list, signerConfig, signingCertificateLineage, i, z, z2, z3, z4, z5, z6, str, signingCertificateLineage2);
    }

    public final void checkNotClosed() {
        if (this.mClosed) {
            throw new IllegalStateException("Engine closed");
        }
    }

    public final void checkOutputApkNotDebuggableIfDebuggableMustBeRejected() throws SignatureException {
        if (this.mDebuggableApkPermitted) {
            return;
        }
        try {
            if (isOutputApkDebuggable()) {
                throw new SignatureException("APK is debuggable (see android:debuggable attribute) and this engine is configured to refuse to sign debuggable APKs");
            }
        } catch (ApkFormatException e) {
            throw new SignatureException("Failed to determine whether the APK is debuggable", e);
        }
    }

    public final void checkSigningBlockDoneIfEnabled() {
        if (this.mV2SignaturePending || this.mV3SignaturePending) {
            OutputApkSigningBlockRequestImpl outputApkSigningBlockRequestImpl = this.mAddSigningBlockRequest;
            if (outputApkSigningBlockRequestImpl == null) {
                throw new IllegalStateException("Signed APK Signing BLock not yet generated. Skipped outputZipSections()?");
            }
            if (!outputApkSigningBlockRequestImpl.isDone()) {
                throw new IllegalStateException("APK Signing Block addition of signature(s) requested by outputZipSections() hasn't been fulfilled yet");
            }
            this.mAddSigningBlockRequest = null;
            this.mV2SignaturePending = false;
            this.mV3SignaturePending = false;
        }
    }

    public final void checkV1SigningDoneIfEnabled() {
        if (this.mV1SignaturePending) {
            OutputJarSignatureRequestImpl outputJarSignatureRequestImpl = this.mAddV1SignatureRequest;
            if (outputJarSignatureRequestImpl == null) {
                throw new IllegalStateException("v1 signature (JAR signature) not yet generated. Skipped outputJarEntries()?");
            }
            if (!outputJarSignatureRequestImpl.isDone()) {
                throw new IllegalStateException("v1 signature (JAR signature) addition requested by outputJarEntries() hasn't been fulfilled");
            }
            for (Map.Entry<String, byte[]> entry : this.mEmittedSignatureJarEntryData.entrySet()) {
                String key = entry.getKey();
                byte[] value = entry.getValue();
                GetJarEntryDataRequest getJarEntryDataRequest = this.mOutputSignatureJarEntryDataRequests.get(key);
                if (getJarEntryDataRequest == null) {
                    throw new IllegalStateException("APK entry " + key + " not yet output despite this having been requested");
                }
                if (!getJarEntryDataRequest.isDone()) {
                    throw new IllegalStateException("Still waiting to inspect output APK's " + key);
                }
                if (!Arrays.equals(value, getJarEntryDataRequest.getData())) {
                    throw new IllegalStateException("Output APK entry " + key + " data differs from what was requested");
                }
            }
            this.mV1SignaturePending = false;
        }
    }

    @Override // com.android.apksig.ApkSignerEngine, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
        this.mAddV1SignatureRequest = null;
        this.mInputJarManifestEntryDataRequest = null;
        this.mOutputAndroidManifestEntryDataRequest = null;
        this.mDebuggable = null;
        this.mOutputJarEntryDigestRequests.clear();
        this.mOutputJarEntryDigests.clear();
        this.mEmittedSignatureJarEntryData.clear();
        this.mOutputSignatureJarEntryDataRequests.clear();
        this.mAddSigningBlockRequest = null;
    }

    public final ApkSigningBlockUtils.SignerConfig createSigningBlockSignerConfig(SignerConfig signerConfig, boolean z, int i) throws InvalidKeyException {
        List<X509Certificate> certificates = signerConfig.getCertificates();
        boolean z2 = false;
        PublicKey publicKey = certificates.get(0).getPublicKey();
        ApkSigningBlockUtils.SignerConfig signerConfig2 = new ApkSigningBlockUtils.SignerConfig();
        signerConfig2.privateKey = signerConfig.getPrivateKey();
        signerConfig2.certificates = certificates;
        if (i == 0) {
            signerConfig2.signatureAlgorithms = Collections.singletonList(SignatureAlgorithm.RSA_PKCS1_V1_5_WITH_SHA256);
        } else if (i == 2) {
            int i2 = this.mMinSdkVersion;
            if (z && this.mVerityEnabled) {
                z2 = true;
            }
            signerConfig2.signatureAlgorithms = V2SchemeSigner.getSuggestedSignatureAlgorithms(publicKey, i2, z2);
        } else if (i == 3) {
            try {
                int i3 = this.mMinSdkVersion;
                if (z && this.mVerityEnabled) {
                    z2 = true;
                }
                signerConfig2.signatureAlgorithms = V3SchemeSigner.getSuggestedSignatureAlgorithms(publicKey, i3, z2);
            } catch (InvalidKeyException unused) {
                signerConfig2.signatureAlgorithms = null;
            }
        } else {
            if (i != 4) {
                throw new IllegalArgumentException("Unknown APK Signature Scheme ID requested");
            }
            try {
                signerConfig2.signatureAlgorithms = V4SchemeSigner.getSuggestedSignatureAlgorithms(publicKey, this.mMinSdkVersion, z);
            } catch (InvalidKeyException unused2) {
                signerConfig2.signatureAlgorithms = null;
            }
        }
        return signerConfig2;
    }

    public final List<ApkSigningBlockUtils.SignerConfig> createSigningBlockSignerConfigs(boolean z, int i) throws InvalidKeyException {
        ArrayList arrayList = new ArrayList(this.mSignerConfigs.size());
        for (int i2 = 0; i2 < this.mSignerConfigs.size(); i2++) {
            arrayList.add(createSigningBlockSignerConfig(this.mSignerConfigs.get(i2), z, i));
        }
        return arrayList;
    }

    public final ApkSigningBlockUtils.SignerConfig createSourceStampSignerConfig() throws InvalidKeyException {
        ApkSigningBlockUtils.SignerConfig signerConfigCreateSigningBlockSignerConfig = createSigningBlockSignerConfig(this.mSourceStampSignerConfig, false, 0);
        SigningCertificateLineage signingCertificateLineage = this.mSourceStampSigningCertificateLineage;
        if (signingCertificateLineage != null) {
            signerConfigCreateSigningBlockSignerConfig.mSigningCertificateLineage = signingCertificateLineage.getSubLineage(signerConfigCreateSigningBlockSignerConfig.certificates.get(0));
        }
        return signerConfigCreateSigningBlockSignerConfig;
    }

    public final void createV1SignerConfigs(List<SignerConfig> list, int i) throws InvalidKeyException {
        this.mV1SignerConfigs = new ArrayList(list.size());
        HashMap map = new HashMap(list.size());
        DigestAlgorithm digestAlgorithm = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            SignerConfig signerConfig = list.get(i2);
            List<X509Certificate> certificates = signerConfig.getCertificates();
            PublicKey publicKey = certificates.get(0).getPublicKey();
            String safeSignerName = V1SchemeSigner.getSafeSignerName(signerConfig.getName());
            Integer num = (Integer) map.put(safeSignerName, Integer.valueOf(i2));
            if (num != null) {
                throw new IllegalArgumentException("Signers #" + (num.intValue() + 1) + " and #" + (i2 + 1) + " have the same name: " + safeSignerName + ". v1 signer names must be unique");
            }
            DigestAlgorithm suggestedSignatureDigestAlgorithm = V1SchemeSigner.getSuggestedSignatureDigestAlgorithm(publicKey, i);
            V1SchemeSigner.SignerConfig signerConfig2 = new V1SchemeSigner.SignerConfig();
            signerConfig2.name = safeSignerName;
            signerConfig2.privateKey = signerConfig.getPrivateKey();
            signerConfig2.certificates = certificates;
            signerConfig2.signatureDigestAlgorithm = suggestedSignatureDigestAlgorithm;
            if (digestAlgorithm == null || DigestAlgorithm.BY_STRENGTH_COMPARATOR.compare(suggestedSignatureDigestAlgorithm, digestAlgorithm) > 0) {
                digestAlgorithm = suggestedSignatureDigestAlgorithm;
            }
            this.mV1SignerConfigs.add(signerConfig2);
        }
        this.mV1ContentDigestAlgorithm = digestAlgorithm;
        this.mSignatureExpectedOutputJarEntryNames = V1SchemeSigner.getOutputEntryNames(this.mV1SignerConfigs);
    }

    public final List<ApkSigningBlockUtils.SignerConfig> createV2SignerConfigs(boolean z) throws InvalidKeyException {
        if (!this.mV3SigningEnabled) {
            return createSigningBlockSignerConfigs(z, 2);
        }
        ArrayList arrayList = new ArrayList();
        SignerConfig signerConfig = this.mSignerConfigs.get(0);
        SigningCertificateLineage signingCertificateLineage = this.mSigningCertificateLineage;
        if (signingCertificateLineage != null && signingCertificateLineage.getSubLineage((X509Certificate) signerConfig.mCertificates.get(0)).size() != 1) {
            throw new IllegalArgumentException("v2 signing enabled but the oldest signer in the SigningCertificateLineage is missing.  Please provide the oldest signer to enable v2 signing.");
        }
        arrayList.add(createSigningBlockSignerConfig(this.mSignerConfigs.get(0), z, 2));
        return arrayList;
    }

    public final List<ApkSigningBlockUtils.SignerConfig> createV3SignerConfigs(boolean z) throws InvalidKeyException {
        return processV3Configs(createSigningBlockSignerConfigs(z, 3));
    }

    public final ApkSigningBlockUtils.SignerConfig createV4SignerConfig() throws InvalidKeyException {
        List<ApkSigningBlockUtils.SignerConfig> listCreateSigningBlockSignerConfigs = createSigningBlockSignerConfigs(true, 4);
        if (listCreateSigningBlockSignerConfigs.size() != 1) {
            listCreateSigningBlockSignerConfigs = processV3Configs(listCreateSigningBlockSignerConfigs);
        }
        if (listCreateSigningBlockSignerConfigs.size() == 1) {
            return listCreateSigningBlockSignerConfigs.get(0);
        }
        throw new InvalidKeyException("Only accepting one signer config for V4 Signature.");
    }

    public final void forgetOutputApkDebuggableStatus() {
        this.mDebuggable = null;
    }

    @Override // com.android.apksig.ApkSignerEngine
    public byte[] generateSourceStampCertificateDigest() throws SignatureException {
        if (this.mSourceStampSignerConfig.getCertificates().isEmpty()) {
            throw new SignatureException("No certificates configured for stamp");
        }
        try {
            return ApkUtils.computeSha256DigestBytes(this.mSourceStampSignerConfig.getCertificates().get(0).getEncoded());
        } catch (CertificateEncodingException e) {
            throw new SignatureException("Failed to encode source stamp certificate", e);
        }
    }

    public final ApkSignerEngine.InputJarEntryInstructions.OutputPolicy getInputJarEntryOutputPolicy(String str) {
        return this.mSignatureExpectedOutputJarEntryNames.contains(str) ? ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT_BY_ENGINE : (this.mOtherSignersSignaturesPreserved || V1SchemeSigner.isJarEntryDigestNeededInManifest(str)) ? ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT : ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.SKIP;
    }

    public final int getMinSdkFromV3SignatureAlgorithms(List<SignatureAlgorithm> list) {
        Iterator<SignatureAlgorithm> it = list.iterator();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        while (it.hasNext()) {
            int minSdkVersion = it.next().getMinSdkVersion();
            if (minSdkVersion < i) {
                if (minSdkVersion <= this.mMinSdkVersion || minSdkVersion <= 28) {
                    return minSdkVersion;
                }
                i = minSdkVersion;
            }
        }
        return i;
    }

    @Override // com.android.apksig.ApkSignerEngine
    public Set<String> initWith(byte[] bArr, Set<String> set) {
        Pair<ManifestParser.Section, Map<String, ManifestParser.Section>> manifest = V1SchemeVerifier.parseManifest(bArr, set, new V1SchemeVerifier.Result());
        String jcaMessageDigestAlgorithm = V1SchemeSigner.getJcaMessageDigestAlgorithm(this.mV1ContentDigestAlgorithm);
        for (Map.Entry<String, ManifestParser.Section> entry : manifest.getSecond().entrySet()) {
            String key = entry.getKey();
            if (V1SchemeSigner.isJarEntryDigestNeededInManifest(entry.getKey()) && isDebuggable(key)) {
                V1SchemeVerifier.NamedDigest namedDigest = null;
                Iterator<V1SchemeVerifier.NamedDigest> it = V1SchemeVerifier.getDigestsToVerify(entry.getValue(), "-Digest", this.mMinSdkVersion, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    V1SchemeVerifier.NamedDigest next = it.next();
                    if (next.jcaDigestAlgorithm.equals(jcaMessageDigestAlgorithm)) {
                        namedDigest = next;
                        break;
                    }
                }
                if (namedDigest != null) {
                    this.mOutputJarEntryDigests.put(key, namedDigest.digest);
                }
            }
        }
        return this.mOutputJarEntryDigests.keySet();
    }

    @Override // com.android.apksig.ApkSignerEngine
    public void inputApkSigningBlock(DataSource dataSource) {
        checkNotClosed();
        if (dataSource != null) {
            dataSource.size();
        }
    }

    @Override // com.android.apksig.ApkSignerEngine
    public ApkSignerEngine.InputJarEntryInstructions inputJarEntry(String str) {
        checkNotClosed();
        ApkSignerEngine.InputJarEntryInstructions.OutputPolicy inputJarEntryOutputPolicy = getInputJarEntryOutputPolicy(str);
        int i = C08941.f2275x62cebf84[inputJarEntryOutputPolicy.ordinal()];
        if (i == 1) {
            return new ApkSignerEngine.InputJarEntryInstructions(ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.SKIP);
        }
        if (i == 2) {
            return new ApkSignerEngine.InputJarEntryInstructions(ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT);
        }
        if (i != 3) {
            throw new RuntimeException("Unsupported output policy: " + inputJarEntryOutputPolicy);
        }
        if (!"META-INF/MANIFEST.MF".equals(str)) {
            return new ApkSignerEngine.InputJarEntryInstructions(ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT_BY_ENGINE);
        }
        GetJarEntryDataRequest getJarEntryDataRequest = new GetJarEntryDataRequest(str, null);
        this.mInputJarManifestEntryDataRequest = getJarEntryDataRequest;
        return new ApkSignerEngine.InputJarEntryInstructions(ApkSignerEngine.InputJarEntryInstructions.OutputPolicy.OUTPUT_BY_ENGINE, getJarEntryDataRequest);
    }

    @Override // com.android.apksig.ApkSignerEngine
    public ApkSignerEngine.InputJarEntryInstructions.OutputPolicy inputJarEntryRemoved(String str) {
        checkNotClosed();
        return getInputJarEntryOutputPolicy(str);
    }

    public final void invalidateV1Signature() {
        if (this.mV1SigningEnabled) {
            this.mV1SignaturePending = true;
        }
        invalidateV2Signature();
    }

    public final void invalidateV2Signature() {
        if (this.mV2SigningEnabled) {
            this.mV2SignaturePending = true;
            this.mAddSigningBlockRequest = null;
        }
    }

    public final void invalidateV3Signature() {
        if (this.mV3SigningEnabled) {
            this.mV3SignaturePending = true;
            this.mAddSigningBlockRequest = null;
        }
    }

    public final boolean isDebuggable(String str) {
        return this.mDebuggableApkPermitted || !ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(str);
    }

    @Override // com.android.apksig.ApkSignerEngine
    public boolean isEligibleForSourceStamp() {
        return this.mSourceStampSignerConfig != null && (this.mV2SigningEnabled || this.mV3SigningEnabled || this.mV1SigningEnabled);
    }

    public final boolean isOutputApkDebuggable() throws ApkFormatException {
        Boolean bool = this.mDebuggable;
        if (bool != null) {
            return bool.booleanValue();
        }
        GetJarEntryDataRequest getJarEntryDataRequest = this.mOutputAndroidManifestEntryDataRequest;
        if (getJarEntryDataRequest == null) {
            throw new IllegalStateException("Cannot determine debuggable status of output APK because AndroidManifest.xml entry contents have not yet been requested");
        }
        if (getJarEntryDataRequest.isDone()) {
            Boolean boolValueOf = Boolean.valueOf(ApkUtils.getDebuggableFromBinaryAndroidManifest(ByteBuffer.wrap(this.mOutputAndroidManifestEntryDataRequest.getData())));
            this.mDebuggable = boolValueOf;
            return boolValueOf.booleanValue();
        }
        throw new IllegalStateException("Still waiting to inspect output APK's " + this.mOutputAndroidManifestEntryDataRequest.getEntryName());
    }

    @Override // com.android.apksig.ApkSignerEngine
    public void outputDone() {
        checkNotClosed();
        checkV1SigningDoneIfEnabled();
        checkSigningBlockDoneIfEnabled();
    }

    @Override // com.android.apksig.ApkSignerEngine
    public ApkSignerEngine.OutputJarSignatureRequest outputJarEntries() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, ApkFormatException {
        List<Pair> listSign;
        checkNotClosed();
        C08941 c08941 = null;
        if (!this.mV1SignaturePending) {
            return null;
        }
        GetJarEntryDataRequest getJarEntryDataRequest = this.mInputJarManifestEntryDataRequest;
        if (getJarEntryDataRequest != null && !getJarEntryDataRequest.isDone()) {
            throw new IllegalStateException("Still waiting to inspect input APK's " + this.mInputJarManifestEntryDataRequest.getEntryName());
        }
        for (GetJarEntryDataDigestRequest getJarEntryDataDigestRequest : this.mOutputJarEntryDigestRequests.values()) {
            String entryName = getJarEntryDataDigestRequest.getEntryName();
            if (!getJarEntryDataDigestRequest.isDone()) {
                throw new IllegalStateException("Still waiting to inspect output APK's " + entryName);
            }
            this.mOutputJarEntryDigests.put(entryName, getJarEntryDataDigestRequest.getDigest());
        }
        if (isEligibleForSourceStamp()) {
            MessageDigest messageDigest = MessageDigest.getInstance(V1SchemeSigner.getJcaMessageDigestAlgorithm(this.mV1ContentDigestAlgorithm));
            messageDigest.update(generateSourceStampCertificateDigest());
            this.mOutputJarEntryDigests.put("stamp-cert-sha256", messageDigest.digest());
        }
        this.mOutputJarEntryDigestRequests.clear();
        for (GetJarEntryDataRequest getJarEntryDataRequest2 : this.mOutputSignatureJarEntryDataRequests.values()) {
            if (!getJarEntryDataRequest2.isDone()) {
                throw new IllegalStateException("Still waiting to inspect output APK's " + getJarEntryDataRequest2.getEntryName());
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.mV2SigningEnabled) {
            arrayList.add(2);
        }
        if (this.mV3SigningEnabled) {
            arrayList.add(3);
        }
        GetJarEntryDataRequest getJarEntryDataRequest3 = this.mInputJarManifestEntryDataRequest;
        byte[] data = getJarEntryDataRequest3 != null ? getJarEntryDataRequest3.getData() : null;
        if (isEligibleForSourceStamp()) {
            data = V1SchemeSigner.generateManifestFile(this.mV1ContentDigestAlgorithm, this.mOutputJarEntryDigests, data).contents;
        }
        byte[] bArr = data;
        checkOutputApkNotDebuggableIfDebuggableMustBeRejected();
        OutputJarSignatureRequestImpl outputJarSignatureRequestImpl = this.mAddV1SignatureRequest;
        if (outputJarSignatureRequestImpl == null || !outputJarSignatureRequestImpl.isDone()) {
            try {
                listSign = V1SchemeSigner.sign(this.mV1SignerConfigs, this.mV1ContentDigestAlgorithm, this.mOutputJarEntryDigests, arrayList, bArr, this.mCreatedBy);
            } catch (CertificateException e) {
                throw new SignatureException("Failed to generate v1 signature", e);
            }
        } else {
            V1SchemeSigner.OutputManifestFile outputManifestFileGenerateManifestFile = V1SchemeSigner.generateManifestFile(this.mV1ContentDigestAlgorithm, this.mOutputJarEntryDigests, bArr);
            if (Arrays.equals(outputManifestFileGenerateManifestFile.contents, this.mEmittedSignatureJarEntryData.get("META-INF/MANIFEST.MF"))) {
                listSign = new ArrayList();
                for (Map.Entry<String, byte[]> entry : this.mEmittedSignatureJarEntryData.entrySet()) {
                    String key = entry.getKey();
                    byte[] value = entry.getValue();
                    GetJarEntryDataRequest getJarEntryDataRequest4 = this.mOutputSignatureJarEntryDataRequests.get(key);
                    if (getJarEntryDataRequest4 == null) {
                        listSign.add(Pair.m2038of(key, value));
                    } else if (!Arrays.equals(value, getJarEntryDataRequest4.getData())) {
                        listSign.add(Pair.m2038of(key, value));
                    }
                }
                if (listSign.isEmpty()) {
                    return null;
                }
            } else {
                try {
                    listSign = V1SchemeSigner.signManifest(this.mV1SignerConfigs, this.mV1ContentDigestAlgorithm, arrayList, this.mCreatedBy, outputManifestFileGenerateManifestFile);
                } catch (CertificateException e2) {
                    throw new SignatureException("Failed to generate v1 signature", e2);
                }
            }
        }
        if (listSign.isEmpty()) {
            this.mV1SignaturePending = false;
            return null;
        }
        ArrayList arrayList2 = new ArrayList(listSign.size());
        for (Pair pair : listSign) {
            String str = (String) pair.getFirst();
            byte[] bArr2 = (byte[]) pair.getSecond();
            arrayList2.add(new ApkSignerEngine.OutputJarSignatureRequest.JarEntry(str, bArr2));
            this.mEmittedSignatureJarEntryData.put(str, bArr2);
        }
        OutputJarSignatureRequestImpl outputJarSignatureRequestImpl2 = new OutputJarSignatureRequestImpl(arrayList2, c08941);
        this.mAddV1SignatureRequest = outputJarSignatureRequestImpl2;
        return outputJarSignatureRequestImpl2;
    }

    @Override // com.android.apksig.ApkSignerEngine
    public ApkSignerEngine.InspectJarEntryRequest outputJarEntry(String str) {
        GetJarEntryDataRequest getJarEntryDataRequest;
        checkNotClosed();
        invalidateV2Signature();
        if (!isDebuggable(str)) {
            forgetOutputApkDebuggableStatus();
        }
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        byte b7 = 0;
        if (!this.mV1SigningEnabled) {
            if (isDebuggable(str)) {
                return null;
            }
            GetJarEntryDataRequest getJarEntryDataRequest2 = new GetJarEntryDataRequest(str, b7 == true ? 1 : 0);
            this.mOutputAndroidManifestEntryDataRequest = getJarEntryDataRequest2;
            return getJarEntryDataRequest2;
        }
        if (V1SchemeSigner.isJarEntryDigestNeededInManifest(str)) {
            invalidateV1Signature();
            GetJarEntryDataDigestRequest getJarEntryDataDigestRequest = new GetJarEntryDataDigestRequest(str, V1SchemeSigner.getJcaMessageDigestAlgorithm(this.mV1ContentDigestAlgorithm), b6 == true ? 1 : 0);
            this.mOutputJarEntryDigestRequests.put(str, getJarEntryDataDigestRequest);
            this.mOutputJarEntryDigests.remove(str);
            if (this.mDebuggableApkPermitted || !ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(str)) {
                return getJarEntryDataDigestRequest;
            }
            GetJarEntryDataRequest getJarEntryDataRequest3 = new GetJarEntryDataRequest(str, b5 == true ? 1 : 0);
            this.mOutputAndroidManifestEntryDataRequest = getJarEntryDataRequest3;
            return new CompoundInspectJarEntryRequest(str, new ApkSignerEngine.InspectJarEntryRequest[]{getJarEntryDataRequest3, getJarEntryDataDigestRequest}, b4 == true ? 1 : 0);
        }
        if (!this.mSignatureExpectedOutputJarEntryNames.contains(str)) {
            return null;
        }
        invalidateV1Signature();
        if ("META-INF/MANIFEST.MF".equals(str)) {
            getJarEntryDataRequest = new GetJarEntryDataRequest(str, b3 == true ? 1 : 0);
            this.mInputJarManifestEntryDataRequest = getJarEntryDataRequest;
        } else {
            getJarEntryDataRequest = this.mEmittedSignatureJarEntryData.containsKey(str) ? new GetJarEntryDataRequest(str, b2 == true ? 1 : 0) : null;
        }
        if (getJarEntryDataRequest != null) {
            this.mOutputSignatureJarEntryDataRequests.put(str, getJarEntryDataRequest);
        }
        return getJarEntryDataRequest;
    }

    @Override // com.android.apksig.ApkSignerEngine
    public void outputJarEntryRemoved(String str) {
        checkNotClosed();
        invalidateV2Signature();
        if (this.mV1SigningEnabled) {
            if (!V1SchemeSigner.isJarEntryDigestNeededInManifest(str)) {
                if (this.mSignatureExpectedOutputJarEntryNames.contains(str)) {
                    invalidateV1Signature();
                }
            } else {
                invalidateV1Signature();
                this.mOutputJarEntryDigests.remove(str);
                this.mOutputJarEntryDigestRequests.remove(str);
                this.mOutputSignatureJarEntryDataRequests.remove(str);
            }
        }
    }

    @Override // com.android.apksig.ApkSignerEngine
    @Deprecated
    public ApkSignerEngine.OutputApkSigningBlockRequest outputZipSections(DataSource dataSource, DataSource dataSource2, DataSource dataSource3) throws SignatureException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        return outputZipSectionsInternal(dataSource, dataSource2, dataSource3, false);
    }

    @Override // com.android.apksig.ApkSignerEngine
    public ApkSignerEngine.OutputApkSigningBlockRequest2 outputZipSections2(DataSource dataSource, DataSource dataSource2, DataSource dataSource3) throws SignatureException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        return outputZipSectionsInternal(dataSource, dataSource2, dataSource3, true);
    }

    public final OutputApkSigningBlockRequestImpl outputZipSectionsInternal(DataSource dataSource, DataSource dataSource2, DataSource dataSource3, boolean z) throws SignatureException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        ApkSigningBlockUtils.SigningSchemeBlockAndDigests signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV2Block;
        ApkSigningBlockUtils.SigningSchemeBlockAndDigests signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV3Block;
        checkNotClosed();
        checkV1SigningDoneIfEnabled();
        C08941 c08941 = null;
        if (!this.mV2SigningEnabled && !this.mV3SigningEnabled && !isEligibleForSourceStamp()) {
            return null;
        }
        checkOutputApkNotDebuggableIfDebuggableMustBeRejected();
        Pair<DataSource, Integer> pairGenerateApkSigningBlockPadding = ApkSigningBlockUtils.generateApkSigningBlockPadding(dataSource, z);
        DataSource first = pairGenerateApkSigningBlockPadding.getFirst();
        int iIntValue = pairGenerateApkSigningBlockPadding.getSecond().intValue();
        DataSource dataSourceCopyWithModifiedCDOffset = ApkSigningBlockUtils.copyWithModifiedCDOffset(first, dataSource3);
        ArrayList arrayList = new ArrayList();
        if (this.mV2SigningEnabled) {
            invalidateV2Signature();
            signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV2Block = V2SchemeSigner.generateApkSignatureSchemeV2Block(this.mExecutor, first, dataSource2, dataSourceCopyWithModifiedCDOffset, createV2SignerConfigs(z), this.mV3SigningEnabled);
            arrayList.add(signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV2Block.signingSchemeBlock);
        } else {
            signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV2Block = null;
        }
        if (this.mV3SigningEnabled) {
            invalidateV3Signature();
            signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV3Block = V3SchemeSigner.generateApkSignatureSchemeV3Block(this.mExecutor, first, dataSource2, dataSourceCopyWithModifiedCDOffset, createV3SignerConfigs(z));
            arrayList.add(signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV3Block.signingSchemeBlock);
        } else {
            signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV3Block = null;
        }
        if (isEligibleForSourceStamp()) {
            ApkSigningBlockUtils.SignerConfig signerConfigCreateSourceStampSignerConfig = createSourceStampSignerConfig();
            HashMap map = new HashMap();
            if (this.mV3SigningEnabled) {
                map.put(3, signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV3Block.digestInfo);
            }
            if (this.mV2SigningEnabled) {
                map.put(2, signingSchemeBlockAndDigestsGenerateApkSignatureSchemeV2Block.digestInfo);
            }
            if (this.mV1SigningEnabled) {
                HashMap map2 = new HashMap();
                try {
                    GetJarEntryDataRequest getJarEntryDataRequest = this.mInputJarManifestEntryDataRequest;
                    map2.put(ContentDigestAlgorithm.SHA256, ApkUtils.computeSha256DigestBytes(V1SchemeSigner.generateManifestFile(this.mV1ContentDigestAlgorithm, this.mOutputJarEntryDigests, getJarEntryDataRequest != null ? getJarEntryDataRequest.getData() : null).contents));
                    map.put(1, map2);
                } catch (ApkFormatException e) {
                    throw new RuntimeException("Failed to generate manifest file", e);
                }
            }
            arrayList.add(V2SourceStampSigner.generateSourceStampBlock(signerConfigCreateSourceStampSignerConfig, map));
        }
        OutputApkSigningBlockRequestImpl outputApkSigningBlockRequestImpl = new OutputApkSigningBlockRequestImpl(ApkSigningBlockUtils.generateApkSigningBlock(arrayList), iIntValue, c08941);
        this.mAddSigningBlockRequest = outputApkSigningBlockRequestImpl;
        return outputApkSigningBlockRequestImpl;
    }

    public final List<ApkSigningBlockUtils.SignerConfig> processV3Configs(List<ApkSigningBlockUtils.SignerConfig> list) throws InvalidKeyException {
        ArrayList arrayList = new ArrayList();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int size = list.size() - 1; size >= 0; size--) {
            ApkSigningBlockUtils.SignerConfig signerConfig = list.get(size);
            if (signerConfig.signatureAlgorithms == null) {
                throw new InvalidKeyException("Unsupported key algorithm " + signerConfig.certificates.get(0).getPublicKey().getAlgorithm() + " is not supported for APK Signature Scheme v3 signing");
            }
            if (size == list.size() - 1) {
                signerConfig.maxSdkVersion = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            } else {
                signerConfig.maxSdkVersion = i - 1;
            }
            signerConfig.minSdkVersion = getMinSdkFromV3SignatureAlgorithms(signerConfig.signatureAlgorithms);
            SigningCertificateLineage signingCertificateLineage = this.mSigningCertificateLineage;
            if (signingCertificateLineage != null) {
                signerConfig.mSigningCertificateLineage = signingCertificateLineage.getSubLineage(signerConfig.certificates.get(0));
            }
            arrayList.add(signerConfig);
            i = signerConfig.minSdkVersion;
            if (i <= this.mMinSdkVersion || i <= 28) {
                break;
            }
        }
        if (i <= 28 || i <= this.mMinSdkVersion) {
            return arrayList;
        }
        throw new InvalidKeyException("Provided key algorithms not supported on all desired Android SDK versions");
    }

    public byte[] produceV4Signature(DataSource dataSource, OutputStream outputStream) throws SignatureException {
        if (outputStream == null) {
            throw new SignatureException("Missing V4 output streams.");
        }
        try {
            Pair<V4Signature, byte[]> pairGenerateV4Signature = V4SchemeSigner.generateV4Signature(dataSource, createV4SignerConfig());
            pairGenerateV4Signature.getFirst().writeTo(outputStream);
            return pairGenerateV4Signature.getSecond();
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException e) {
            throw new SignatureException("V4 signing failed", e);
        }
    }

    @Override // com.android.apksig.ApkSignerEngine
    public void setExecutor(RunnablesExecutor runnablesExecutor) {
        this.mExecutor = runnablesExecutor;
    }

    @Override // com.android.apksig.ApkSignerEngine
    public void signV4(DataSource dataSource, File file, boolean z) throws SignatureException {
        if (file == null) {
            if (!z) {
                throw new SignatureException("Missing V4 output file.");
            }
            return;
        }
        try {
            V4SchemeSigner.generateV4Signature(dataSource, createV4SignerConfig(), file);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException e) {
            if (!z) {
                throw new SignatureException("V4 signing failed", e);
            }
        }
    }
}
