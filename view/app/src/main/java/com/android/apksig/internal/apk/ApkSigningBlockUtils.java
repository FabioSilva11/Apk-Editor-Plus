package com.android.apksig.internal.apk;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.apksig.ApkVerifier;
import com.android.apksig.SigningCertificateLineage;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.internal.asn1.Asn1BerParser;
import com.android.apksig.internal.asn1.Asn1DecodingException;
import com.android.apksig.internal.asn1.Asn1DerEncoder;
import com.android.apksig.internal.asn1.Asn1EncodingException;
import com.android.apksig.internal.asn1.Asn1OpaqueObject;
import com.android.apksig.internal.pkcs7.AlgorithmIdentifier;
import com.android.apksig.internal.pkcs7.ContentInfo;
import com.android.apksig.internal.pkcs7.EncapsulatedContentInfo;
import com.android.apksig.internal.pkcs7.IssuerAndSerialNumber;
import com.android.apksig.internal.pkcs7.Pkcs7Constants;
import com.android.apksig.internal.pkcs7.SignedData;
import com.android.apksig.internal.pkcs7.SignerIdentifier;
import com.android.apksig.internal.pkcs7.SignerInfo;
import com.android.apksig.internal.util.ByteBufferDataSource;
import com.android.apksig.internal.util.ChainedDataSource;
import com.android.apksig.internal.util.Pair;
import com.android.apksig.internal.util.SupplierCompat;
import com.android.apksig.internal.util.VerityTreeBuilder;
import com.android.apksig.internal.x509.RSAPublicKey;
import com.android.apksig.internal.x509.SubjectPublicKeyInfo;
import com.android.apksig.internal.zip.ZipUtils;
import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSinks;
import com.android.apksig.util.DataSource;
import com.android.apksig.util.DataSources;
import com.android.apksig.util.RunnablesExecutor;
import com.android.apksig.util.RunnablesProvider;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ApkSigningBlockUtils {
    public static final int ANDROID_COMMON_PAGE_ALIGNMENT_BYTES = 4096;
    public static final byte[] APK_SIGNING_BLOCK_MAGIC = {65, 80, 75, 32, 83, 105, 103, 32, 66, 108, 111, 99, 107, 32, 52, 50};
    public static final ContentDigestAlgorithm[] V4_CONTENT_DIGEST_ALGORITHMS = {ContentDigestAlgorithm.CHUNKED_SHA512, ContentDigestAlgorithm.VERITY_CHUNKED_SHA256, ContentDigestAlgorithm.CHUNKED_SHA256};
    public static final int VERSION_APK_SIGNATURE_SCHEME_V2 = 2;
    public static final int VERSION_APK_SIGNATURE_SCHEME_V3 = 3;
    public static final int VERSION_APK_SIGNATURE_SCHEME_V4 = 4;
    public static final int VERSION_JAR_SIGNATURE_SCHEME = 1;
    public static final int VERSION_SOURCE_STAMP = 0;

    public static class ChunkDigester implements Runnable {
        public final List<ChunkDigests> chunkDigests;
        public final ChunkSupplier dataSupplier;
        public final DataSink mdSink;
        public final List<MessageDigest> messageDigests;

        public ChunkDigester(ChunkSupplier chunkSupplier, List<ChunkDigests> list) {
            this.dataSupplier = chunkSupplier;
            this.chunkDigests = list;
            this.messageDigests = new ArrayList(list.size());
            Iterator<ChunkDigests> it = list.iterator();
            while (it.hasNext()) {
                try {
                    this.messageDigests.add(it.next().createMessageDigest());
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }
            this.mdSink = DataSinks.asDataSink((MessageDigest[]) this.messageDigests.toArray(new MessageDigest[0]));
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[5];
            bArr[0] = -91;
            try {
                ChunkSupplier.Chunk chunk = this.dataSupplier.get();
                while (chunk != null) {
                    int i = chunk.size;
                    if (i > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                        throw new RuntimeException("Chunk size greater than expected: " + i);
                    }
                    ApkSigningBlockUtils.setUnsignedInt32LittleEndian(i, bArr, 1);
                    this.mdSink.consume(bArr, 0, 5);
                    this.mdSink.consume(chunk.data);
                    for (int i2 = 0; i2 < this.chunkDigests.size(); i2++) {
                        ChunkDigests chunkDigests = this.chunkDigests.get(i2);
                        int iDigest = this.messageDigests.get(i2).digest(chunkDigests.concatOfDigestsOfChunks, chunkDigests.getOffset(chunk.chunkIndex), chunkDigests.digestOutputSize);
                        if (iDigest != chunkDigests.digestOutputSize) {
                            throw new RuntimeException("Unexpected output size of " + chunkDigests.algorithm + " digest: " + iDigest);
                        }
                    }
                    chunk = this.dataSupplier.get();
                }
            } catch (IOException | DigestException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class ChunkDigests {
        public final ContentDigestAlgorithm algorithm;
        public final byte[] concatOfDigestsOfChunks;
        public final int digestOutputSize;

        public ChunkDigests(ContentDigestAlgorithm contentDigestAlgorithm, int i) {
            this.algorithm = contentDigestAlgorithm;
            int chunkDigestOutputSizeBytes = contentDigestAlgorithm.getChunkDigestOutputSizeBytes();
            this.digestOutputSize = chunkDigestOutputSizeBytes;
            byte[] bArr = new byte[(chunkDigestOutputSizeBytes * i) + 5];
            this.concatOfDigestsOfChunks = bArr;
            bArr[0] = 90;
            ApkSigningBlockUtils.setUnsignedInt32LittleEndian(i, bArr, 1);
        }

        public final MessageDigest createMessageDigest() throws NoSuchAlgorithmException {
            return MessageDigest.getInstance(this.algorithm.getJcaMessageDigestAlgorithm());
        }

        public final int getOffset(int i) {
            return (i * this.digestOutputSize) + 5;
        }
    }

    public static class ChunkSupplier implements SupplierCompat<Chunk> {
        public final int[] chunkCounts;
        public final DataSource[] dataSources;
        public final AtomicInteger nextIndex;
        public final int totalChunkCount;

        public static class Chunk {
            public final int chunkIndex;
            public final ByteBuffer data;
            public final int size;

            public Chunk(int i, ByteBuffer byteBuffer, int i2) {
                this.chunkIndex = i;
                this.data = byteBuffer;
                this.size = i2;
            }
        }

        public ChunkSupplier(DataSource[] dataSourceArr) {
            this.dataSources = dataSourceArr;
            this.chunkCounts = new int[dataSourceArr.length];
            int i = 0;
            for (int i2 = 0; i2 < dataSourceArr.length; i2++) {
                long chunkCount = ApkSigningBlockUtils.getChunkCount(dataSourceArr[i2].size(), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                if (chunkCount > 2147483647L) {
                    throw new RuntimeException(String.format("Number of chunks in dataSource[%d] is greater than max int.", Integer.valueOf(i2)));
                }
                this.chunkCounts[i2] = (int) chunkCount;
                i = (int) (((long) i) + chunkCount);
            }
            this.totalChunkCount = i;
            this.nextIndex = new AtomicInteger(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.apksig.internal.util.SupplierCompat
        public Chunk get() {
            DataSource[] dataSourceArr;
            int andIncrement = this.nextIndex.getAndIncrement();
            if (andIncrement < 0 || andIncrement >= this.totalChunkCount) {
                return null;
            }
            int i = 0;
            long j = andIncrement;
            while (true) {
                dataSourceArr = this.dataSources;
                if (i >= dataSourceArr.length) {
                    break;
                }
                int[] iArr = this.chunkCounts;
                if (j < iArr[i]) {
                    break;
                }
                j -= (long) iArr[i];
                i++;
            }
            long size = dataSourceArr[i].size();
            long j2 = j * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            int iMin = (int) Math.min(size - j2, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iMin);
            try {
                this.dataSources[i].copyTo(j2, iMin, byteBufferAllocate);
                byteBufferAllocate.rewind();
                return new Chunk(andIncrement, byteBufferAllocate, iMin);
            } catch (IOException e) {
                throw new IllegalStateException("Failed to read chunk", e);
            }
        }
    }

    public static class NoSupportedSignaturesException extends NoApkSupportedSignaturesException {
        public NoSupportedSignaturesException(String str) {
            super(str);
        }
    }

    public static class Result extends ApkSigResult {
        public final List<ApkVerifier.IssueWithParams> mErrors;
        public final List<ApkVerifier.IssueWithParams> mWarnings;
        public final List<SignerInfo> signers;
        public SigningCertificateLineage signingCertificateLineage;

        public static class SignerInfo extends ApkSignerInfo {
            public int maxSdkVersion;
            public int minSdkVersion;
            public byte[] signedData;
            public SigningCertificateLineage signingCertificateLineage;
            public List<ContentDigest> contentDigests = new ArrayList();
            public Map<ContentDigestAlgorithm, byte[]> verifiedContentDigests = new HashMap();
            public List<Signature> signatures = new ArrayList();
            public Map<SignatureAlgorithm, byte[]> verifiedSignatures = new HashMap();
            public List<AdditionalAttribute> additionalAttributes = new ArrayList();
            public final List<ApkVerifier.IssueWithParams> mWarnings = new ArrayList();
            public final List<ApkVerifier.IssueWithParams> mErrors = new ArrayList();

            public static class AdditionalAttribute {
                public final int mId;
                public final byte[] mValue;

                public AdditionalAttribute(int i, byte[] bArr) {
                    this.mId = i;
                    this.mValue = (byte[]) bArr.clone();
                }

                public int getId() {
                    return this.mId;
                }

                public byte[] getValue() {
                    return (byte[]) this.mValue.clone();
                }
            }

            public static class ContentDigest {
                public final int mSignatureAlgorithmId;
                public final byte[] mValue;

                public ContentDigest(int i, byte[] bArr) {
                    this.mSignatureAlgorithmId = i;
                    this.mValue = bArr;
                }

                public int getSignatureAlgorithmId() {
                    return this.mSignatureAlgorithmId;
                }

                public byte[] getValue() {
                    return this.mValue;
                }
            }

            public static class Signature {
                public final int mAlgorithmId;
                public final byte[] mValue;

                public Signature(int i, byte[] bArr) {
                    this.mAlgorithmId = i;
                    this.mValue = bArr;
                }

                public int getAlgorithmId() {
                    return this.mAlgorithmId;
                }

                public byte[] getValue() {
                    return this.mValue;
                }
            }

            public void addError(ApkVerifier.Issue issue, Object... objArr) {
                this.mErrors.add(new ApkVerifier.IssueWithParams(issue, objArr));
            }

            public void addWarning(ApkVerifier.Issue issue, Object... objArr) {
                this.mWarnings.add(new ApkVerifier.IssueWithParams(issue, objArr));
            }

            @Override // com.android.apksig.internal.apk.ApkSignerInfo
            public boolean containsErrors() {
                return !this.mErrors.isEmpty();
            }

            @Override // com.android.apksig.internal.apk.ApkSignerInfo
            public boolean containsWarnings() {
                return !this.mWarnings.isEmpty();
            }

            @Override // com.android.apksig.internal.apk.ApkSignerInfo
            public List<ApkVerifier.IssueWithParams> getErrors() {
                return this.mErrors;
            }

            @Override // com.android.apksig.internal.apk.ApkSignerInfo
            public List<ApkVerifier.IssueWithParams> getWarnings() {
                return this.mWarnings;
            }
        }

        public Result(int i) {
            super(i);
            this.signingCertificateLineage = null;
            this.signers = new ArrayList();
            this.mWarnings = new ArrayList();
            this.mErrors = new ArrayList();
        }

        public void addError(ApkVerifier.Issue issue, Object... objArr) {
            this.mErrors.add(new ApkVerifier.IssueWithParams(issue, objArr));
        }

        public void addWarning(ApkVerifier.Issue issue, Object... objArr) {
            this.mWarnings.add(new ApkVerifier.IssueWithParams(issue, objArr));
        }

        @Override // com.android.apksig.internal.apk.ApkSigResult
        public boolean containsErrors() {
            if (!this.mErrors.isEmpty()) {
                return true;
            }
            if (this.signers.isEmpty()) {
                return false;
            }
            Iterator<SignerInfo> it = this.signers.iterator();
            while (it.hasNext()) {
                if (it.next().containsErrors()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.android.apksig.internal.apk.ApkSigResult
        public boolean containsWarnings() {
            if (!this.mWarnings.isEmpty()) {
                return true;
            }
            if (this.signers.isEmpty()) {
                return false;
            }
            Iterator<SignerInfo> it = this.signers.iterator();
            while (it.hasNext()) {
                if (it.next().containsWarnings()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.android.apksig.internal.apk.ApkSigResult
        public List<ApkVerifier.IssueWithParams> getErrors() {
            return this.mErrors;
        }

        @Override // com.android.apksig.internal.apk.ApkSigResult
        public List<ApkVerifier.IssueWithParams> getWarnings() {
            return this.mWarnings;
        }
    }

    public static class SignatureNotFoundException extends Exception {
        public SignatureNotFoundException(String str) {
            super(str);
        }

        public SignatureNotFoundException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class SignerConfig {
        public List<X509Certificate> certificates;
        public SigningCertificateLineage mSigningCertificateLineage;
        public int maxSdkVersion;
        public int minSdkVersion;
        public PrivateKey privateKey;
        public List<SignatureAlgorithm> signatureAlgorithms;
    }

    public static class SigningSchemeBlockAndDigests {
        public final Map<ContentDigestAlgorithm, byte[]> digestInfo;
        public final Pair<byte[], Integer> signingSchemeBlock;

        public SigningSchemeBlockAndDigests(Pair<byte[], Integer> pair, Map<ContentDigestAlgorithm, byte[]> map) {
            this.signingSchemeBlock = pair;
            this.digestInfo = map;
        }
    }

    public static class SupportedSignature extends ApkSupportedSignature {
        public SupportedSignature(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
            super(signatureAlgorithm, bArr);
        }
    }

    public static class VerityTreeAndDigest {
        public final ContentDigestAlgorithm contentDigestAlgorithm;
        public final byte[] rootHash;
        public final byte[] tree;

        public VerityTreeAndDigest(ContentDigestAlgorithm contentDigestAlgorithm, byte[] bArr, byte[] bArr2) {
            this.contentDigestAlgorithm = contentDigestAlgorithm;
            this.rootHash = bArr;
            this.tree = bArr2;
        }
    }

    public static void checkByteOrderLittleEndian(ByteBuffer byteBuffer) {
        ApkSigningBlockUtilsLite.checkByteOrderLittleEndian(byteBuffer);
    }

    public static int compareSignatureAlgorithm(SignatureAlgorithm signatureAlgorithm, SignatureAlgorithm signatureAlgorithm2) {
        return ApkSigningBlockUtilsLite.compareSignatureAlgorithm(signatureAlgorithm, signatureAlgorithm2);
    }

    public static void computeApkVerityDigest(DataSource dataSource, DataSource dataSource2, DataSource dataSource3, Map<ContentDigestAlgorithm, byte[]> map) throws NoSuchAlgorithmException, IOException {
        ByteBuffer byteBufferCreateVerityDigestBuffer = createVerityDigestBuffer(true);
        VerityTreeBuilder verityTreeBuilder = new VerityTreeBuilder(new byte[8]);
        try {
            byteBufferCreateVerityDigestBuffer.put(verityTreeBuilder.generateVerityTreeRootHash(dataSource, dataSource2, dataSource3));
            byteBufferCreateVerityDigestBuffer.putLong(dataSource.size() + dataSource2.size() + dataSource3.size());
            map.put(ContentDigestAlgorithm.VERITY_CHUNKED_SHA256, byteBufferCreateVerityDigestBuffer.array());
            verityTreeBuilder.close();
        } catch (Throwable th) {
            try {
                verityTreeBuilder.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public static VerityTreeAndDigest computeChunkVerityTreeAndDigest(DataSource dataSource) throws NoSuchAlgorithmException, IOException {
        ByteBuffer byteBufferCreateVerityDigestBuffer = createVerityDigestBuffer(false);
        VerityTreeBuilder verityTreeBuilder = new VerityTreeBuilder(null);
        try {
            ByteBuffer byteBufferGenerateVerityTree = verityTreeBuilder.generateVerityTree(dataSource);
            byteBufferCreateVerityDigestBuffer.put(verityTreeBuilder.getRootHashFromTree(byteBufferGenerateVerityTree));
            VerityTreeAndDigest verityTreeAndDigest = new VerityTreeAndDigest(ContentDigestAlgorithm.VERITY_CHUNKED_SHA256, byteBufferCreateVerityDigestBuffer.array(), byteBufferGenerateVerityTree.array());
            verityTreeBuilder.close();
            return verityTreeAndDigest;
        } catch (Throwable th) {
            try {
                verityTreeBuilder.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public static Pair<List<SignerConfig>, Map<ContentDigestAlgorithm, byte[]>> computeContentDigests(RunnablesExecutor runnablesExecutor, DataSource dataSource, DataSource dataSource2, DataSource dataSource3, List<SignerConfig> list) throws SignatureException, NoSuchAlgorithmException, IOException {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("No signer configs provided. At least one is required");
        }
        HashSet hashSet = new HashSet(1);
        Iterator<SignerConfig> it = list.iterator();
        while (it.hasNext()) {
            Iterator<SignatureAlgorithm> it2 = it.next().signatureAlgorithms.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().getContentDigestAlgorithm());
            }
        }
        try {
            return Pair.m2038of(list, computeContentDigests(runnablesExecutor, hashSet, dataSource, dataSource2, dataSource3));
        } catch (IOException e) {
            throw new IOException("Failed to read APK being signed", e);
        } catch (DigestException e2) {
            throw new SignatureException("Failed to compute digests of APK", e2);
        }
    }

    public static Map<ContentDigestAlgorithm, byte[]> computeContentDigests(RunnablesExecutor runnablesExecutor, Set<ContentDigestAlgorithm> set, DataSource dataSource, DataSource dataSource2, DataSource dataSource3) throws NoSuchAlgorithmException, DigestException, IOException {
        HashMap map = new HashMap();
        HashSet hashSet = new HashSet();
        for (ContentDigestAlgorithm contentDigestAlgorithm : set) {
            if (contentDigestAlgorithm == ContentDigestAlgorithm.CHUNKED_SHA256 || contentDigestAlgorithm == ContentDigestAlgorithm.CHUNKED_SHA512) {
                hashSet.add(contentDigestAlgorithm);
            }
        }
        computeOneMbChunkContentDigests(runnablesExecutor, hashSet, new DataSource[]{dataSource, dataSource2, dataSource3}, map);
        if (set.contains(ContentDigestAlgorithm.VERITY_CHUNKED_SHA256)) {
            computeApkVerityDigest(dataSource, dataSource2, dataSource3, map);
        }
        return map;
    }

    public static void computeOneMbChunkContentDigests(RunnablesExecutor runnablesExecutor, Set<ContentDigestAlgorithm> set, DataSource[] dataSourceArr, Map<ContentDigestAlgorithm, byte[]> map) throws NoSuchAlgorithmException, DigestException {
        long chunkCount = 0;
        for (DataSource dataSource : dataSourceArr) {
            chunkCount += getChunkCount(dataSource.size(), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        }
        if (chunkCount > 2147483647L) {
            throw new DigestException("Input too long: " + chunkCount + " chunks");
        }
        int i = (int) chunkCount;
        final ArrayList<ChunkDigests> arrayList = new ArrayList(set.size());
        Iterator<ContentDigestAlgorithm> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else {
                arrayList.add(new ChunkDigests(it.next(), i));
            }
        }
        final ChunkSupplier chunkSupplier = new ChunkSupplier(dataSourceArr);
        runnablesExecutor.execute(new RunnablesProvider() { // from class: com.android.apksig.internal.apk.ApkSigningBlockUtils.1
            @Override // com.android.apksig.util.RunnablesProvider
            public Runnable createRunnable() {
                return new ChunkDigester(chunkSupplier, arrayList);
            }
        });
        for (ChunkDigests chunkDigests : arrayList) {
            map.put(chunkDigests.algorithm, chunkDigests.createMessageDigest().digest(chunkDigests.concatOfDigestsOfChunks));
        }
    }

    public static DataSource copyWithModifiedCDOffset(DataSource dataSource, DataSource dataSource2) throws IOException {
        long size = dataSource.size();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) dataSource2.size());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        dataSource2.copyTo(0L, (int) dataSource2.size(), byteBufferAllocate);
        byteBufferAllocate.flip();
        ZipUtils.setZipEocdCentralDirectoryOffset(byteBufferAllocate, size);
        return DataSources.asDataSource(byteBufferAllocate);
    }

    public static ByteBuffer createVerityDigestBuffer(boolean z) {
        int chunkDigestOutputSizeBytes = ContentDigestAlgorithm.VERITY_CHUNKED_SHA256.getChunkDigestOutputSizeBytes();
        if (z) {
            chunkDigestOutputSizeBytes += 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(chunkDigestOutputSizeBytes);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        return byteBufferAllocate;
    }

    public static byte[] encodeAsLengthPrefixedElement(byte[] bArr) {
        return encodeAsSequenceOfLengthPrefixedElements(new byte[][]{bArr});
    }

    public static byte[] encodeAsSequenceOfLengthPrefixedElements(List<byte[]> list) {
        return encodeAsSequenceOfLengthPrefixedElements((byte[][]) list.toArray(new byte[list.size()][]));
    }

    public static byte[] encodeAsSequenceOfLengthPrefixedElements(byte[][] bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        for (byte[] bArr3 : bArr) {
            byteBufferAllocate.putInt(bArr3.length);
            byteBufferAllocate.put(bArr3);
        }
        return byteBufferAllocate.array();
    }

    public static byte[] encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(List<Pair<Integer, byte[]>> list) {
        return ApkSigningBlockUtilsLite.encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(list);
    }

    public static List<byte[]> encodeCertificates(List<X509Certificate> list) throws CertificateEncodingException {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<X509Certificate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getEncoded());
        }
        return arrayList;
    }

    public static byte[] encodePublicKey(PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] encoded = null;
        if ("X.509".equals(publicKey.getFormat())) {
            byte[] encoded2 = publicKey.getEncoded();
            if ("RSA".equals(publicKey.getAlgorithm())) {
                try {
                    SubjectPublicKeyInfo subjectPublicKeyInfo = (SubjectPublicKeyInfo) Asn1BerParser.parse(ByteBuffer.wrap(encoded2), SubjectPublicKeyInfo.class);
                    ByteBuffer byteBuffer = subjectPublicKeyInfo.subjectPublicKey;
                    byte b2 = byteBuffer.get();
                    RSAPublicKey rSAPublicKey = (RSAPublicKey) Asn1BerParser.parse(byteBuffer, RSAPublicKey.class);
                    if (rSAPublicKey.modulus.compareTo(BigInteger.ZERO) < 0) {
                        byte[] byteArray = rSAPublicKey.modulus.toByteArray();
                        byte[] bArr = new byte[byteArray.length + 1];
                        bArr[0] = 0;
                        System.arraycopy(byteArray, 0, bArr, 1, byteArray.length);
                        rSAPublicKey.modulus = new BigInteger(bArr);
                        byte[] bArrEncode = Asn1DerEncoder.encode(rSAPublicKey);
                        byte[] bArr2 = new byte[bArrEncode.length + 1];
                        bArr2[0] = b2;
                        System.arraycopy(bArrEncode, 0, bArr2, 1, bArrEncode.length);
                        subjectPublicKeyInfo.subjectPublicKey = ByteBuffer.wrap(bArr2);
                        encoded2 = Asn1DerEncoder.encode(subjectPublicKeyInfo);
                    }
                    encoded = encoded2;
                } catch (Asn1DecodingException | Asn1EncodingException e) {
                    System.out.println("Caught a exception encoding the public key: " + e);
                    e.printStackTrace();
                }
            } else {
                encoded = encoded2;
            }
        }
        if (encoded == null) {
            try {
                encoded = ((X509EncodedKeySpec) KeyFactory.getInstance(publicKey.getAlgorithm()).getKeySpec(publicKey, X509EncodedKeySpec.class)).getEncoded();
            } catch (InvalidKeySpecException e2) {
                throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + publicKey + " of class " + publicKey.getClass().getName(), e2);
            }
        }
        if (encoded != null && encoded.length != 0) {
            return encoded;
        }
        throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + publicKey + " of class " + publicKey.getClass().getName());
    }

    public static ByteBuffer findApkSignatureSchemeBlock(ByteBuffer byteBuffer, int i, Result result) throws SignatureNotFoundException {
        try {
            return ApkSigningBlockUtilsLite.findApkSignatureSchemeBlock(byteBuffer, i);
        } catch (com.android.apksig.internal.apk.SignatureNotFoundException e) {
            throw new SignatureNotFoundException(e.getMessage());
        }
    }

    public static SignatureInfo findSignature(DataSource dataSource, ApkUtils.ZipSections zipSections, int i, Result result) throws SignatureNotFoundException, IOException {
        try {
            return ApkSigningBlockUtilsLite.findSignature(dataSource, zipSections, i);
        } catch (com.android.apksig.internal.apk.SignatureNotFoundException e) {
            throw new SignatureNotFoundException(e.getMessage());
        }
    }

    public static byte[] generateApkSigningBlock(List<Pair<byte[], Integer>> list) {
        Iterator<Pair<byte[], Integer>> it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().getFirst().length + 12;
        }
        int i = length + 8 + 8 + 16;
        ByteBuffer byteBuffer = null;
        int i2 = i % 4096;
        if (i2 != 0) {
            int i3 = 4096 - i2;
            if (i3 < 12) {
                i3 += 4096;
            }
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(i3).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.putLong(i3 - 8);
            byteBufferOrder.putInt(1114793335);
            byteBufferOrder.rewind();
            i += i3;
            byteBuffer = byteBufferOrder;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long j = ((long) i) - 8;
        byteBufferAllocate.putLong(j);
        for (Pair<byte[], Integer> pair : list) {
            byte[] first = pair.getFirst();
            int iIntValue = pair.getSecond().intValue();
            byteBufferAllocate.putLong(((long) first.length) + 4);
            byteBufferAllocate.putInt(iIntValue);
            byteBufferAllocate.put(first);
        }
        if (byteBuffer != null) {
            byteBufferAllocate.put(byteBuffer);
        }
        byteBufferAllocate.putLong(j);
        byteBufferAllocate.put(APK_SIGNING_BLOCK_MAGIC);
        return byteBufferAllocate.array();
    }

    public static Pair<DataSource, Integer> generateApkSigningBlockPadding(DataSource dataSource, boolean z) {
        int i = 0;
        if (z && dataSource.size() % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            int size = (int) (PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM - (dataSource.size() % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
            i = size;
            dataSource = new ChainedDataSource(dataSource, DataSources.asDataSource(ByteBuffer.allocate(size)));
        }
        return Pair.m2038of(dataSource, Integer.valueOf(i));
    }

    public static byte[] generatePkcs7DerEncodedMessage(byte[] bArr, ByteBuffer byteBuffer, List<X509Certificate> list, AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) throws Asn1EncodingException, CertificateEncodingException {
        SignerInfo signerInfo = new SignerInfo();
        signerInfo.version = 1;
        X509Certificate x509Certificate = list.get(0);
        signerInfo.sid = new SignerIdentifier(new IssuerAndSerialNumber(new Asn1OpaqueObject(x509Certificate.getIssuerX500Principal().getEncoded()), x509Certificate.getSerialNumber()));
        signerInfo.digestAlgorithm = algorithmIdentifier;
        signerInfo.signatureAlgorithm = algorithmIdentifier2;
        signerInfo.signature = ByteBuffer.wrap(bArr);
        SignedData signedData = new SignedData();
        signedData.certificates = new ArrayList(list.size());
        Iterator<X509Certificate> it = list.iterator();
        while (it.hasNext()) {
            signedData.certificates.add(new Asn1OpaqueObject(it.next().getEncoded()));
        }
        signedData.version = 1;
        signedData.digestAlgorithms = Collections.singletonList(algorithmIdentifier);
        EncapsulatedContentInfo encapsulatedContentInfo = new EncapsulatedContentInfo(Pkcs7Constants.OID_DATA);
        signedData.encapContentInfo = encapsulatedContentInfo;
        encapsulatedContentInfo.content = byteBuffer;
        signedData.signerInfos = Collections.singletonList(signerInfo);
        ContentInfo contentInfo = new ContentInfo();
        contentInfo.contentType = Pkcs7Constants.OID_SIGNED_DATA;
        contentInfo.content = new Asn1OpaqueObject(Asn1DerEncoder.encode(signedData));
        return Asn1DerEncoder.encode(contentInfo);
    }

    public static List<Pair<Integer, byte[]>> generateSignaturesOverData(SignerConfig signerConfig, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        ArrayList arrayList = new ArrayList(signerConfig.signatureAlgorithms.size());
        PublicKey publicKey = signerConfig.certificates.get(0).getPublicKey();
        for (SignatureAlgorithm signatureAlgorithm : signerConfig.signatureAlgorithms) {
            Pair<String, ? extends AlgorithmParameterSpec> jcaSignatureAlgorithmAndParams = signatureAlgorithm.getJcaSignatureAlgorithmAndParams();
            String first = jcaSignatureAlgorithmAndParams.getFirst();
            AlgorithmParameterSpec second = jcaSignatureAlgorithmAndParams.getSecond();
            try {
                Signature signature = Signature.getInstance(first);
                signature.initSign(signerConfig.privateKey);
                if (second != null) {
                    signature.setParameter(second);
                }
                signature.update(bArr);
                byte[] bArrSign = signature.sign();
                try {
                    Signature signature2 = Signature.getInstance(first);
                    signature2.initVerify(publicKey);
                    if (second != null) {
                        signature2.setParameter(second);
                    }
                    signature2.update(bArr);
                    if (!signature2.verify(bArrSign)) {
                        throw new SignatureException("Failed to verify generated " + first + " signature using public key from certificate");
                    }
                    arrayList.add(Pair.m2038of(Integer.valueOf(signatureAlgorithm.getId()), bArrSign));
                } catch (InvalidAlgorithmParameterException e) {
                    e = e;
                    throw new SignatureException("Failed to verify generated " + first + " signature using public key from certificate", e);
                } catch (InvalidKeyException e2) {
                    throw new InvalidKeyException("Failed to verify generated " + first + " signature using public key from certificate", e2);
                } catch (SignatureException e3) {
                    e = e3;
                    throw new SignatureException("Failed to verify generated " + first + " signature using public key from certificate", e);
                }
            } catch (InvalidAlgorithmParameterException e4) {
                e = e4;
                throw new SignatureException("Failed to sign using " + first, e);
            } catch (InvalidKeyException e5) {
                throw new InvalidKeyException("Failed to sign using " + first, e5);
            } catch (SignatureException e6) {
                e = e6;
                throw new SignatureException("Failed to sign using " + first, e);
            }
        }
        return arrayList;
    }

    public static long getChunkCount(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static ByteBuffer getLengthPrefixedSlice(ByteBuffer byteBuffer) throws ApkFormatException {
        return ApkSigningBlockUtilsLite.getLengthPrefixedSlice(byteBuffer);
    }

    public static <T extends ApkSupportedSignature> List<T> getSignaturesToVerify(List<T> list, int i, int i2) throws NoSupportedSignaturesException {
        return getSignaturesToVerify(list, i, i2, false);
    }

    public static <T extends ApkSupportedSignature> List<T> getSignaturesToVerify(List<T> list, int i, int i2, boolean z) throws NoSupportedSignaturesException {
        try {
            return ApkSigningBlockUtilsLite.getSignaturesToVerify(list, i, i2, z);
        } catch (NoApkSupportedSignaturesException e) {
            throw new NoSupportedSignaturesException(e.getMessage());
        }
    }

    public static byte[] pickBestDigestForV4(Map<ContentDigestAlgorithm, byte[]> map) {
        for (ContentDigestAlgorithm contentDigestAlgorithm : V4_CONTENT_DIGEST_ALGORITHMS) {
            if (map.containsKey(contentDigestAlgorithm)) {
                return map.get(contentDigestAlgorithm);
            }
        }
        return null;
    }

    public static byte[] readLengthPrefixedByteArray(ByteBuffer byteBuffer) throws ApkFormatException {
        return ApkSigningBlockUtilsLite.readLengthPrefixedByteArray(byteBuffer);
    }

    public static void setUnsignedInt32LittleEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    public static String toHex(byte[] bArr) {
        return ApkSigningBlockUtilsLite.toHex(bArr);
    }

    public static void verifyIntegrity(RunnablesExecutor runnablesExecutor, DataSource dataSource, DataSource dataSource2, ByteBuffer byteBuffer, Set<ContentDigestAlgorithm> set, Result result) throws NoSuchAlgorithmException, IOException {
        if (set.isEmpty()) {
            throw new RuntimeException("No content digests found");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        int iPosition = byteBuffer.position();
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.flip();
        byteBuffer.position(iPosition);
        ZipUtils.setZipEocdCentralDirectoryOffset(byteBufferAllocate, dataSource.size());
        try {
            Map<ContentDigestAlgorithm, byte[]> mapComputeContentDigests = computeContentDigests(runnablesExecutor, set, dataSource, dataSource2, new ByteBufferDataSource(byteBufferAllocate));
            if (mapComputeContentDigests.containsKey(ContentDigestAlgorithm.VERITY_CHUNKED_SHA256)) {
                if (dataSource.size() % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
                    throw new RuntimeException("APK Signing Block is not aligned on 4k boundary: " + dataSource.size());
                }
                long zipEocdCentralDirectoryOffset = ZipUtils.getZipEocdCentralDirectoryOffset(byteBuffer) - dataSource.size();
                if (zipEocdCentralDirectoryOffset % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
                    throw new RuntimeException("APK Signing Block size is not multiple of page size: " + zipEocdCentralDirectoryOffset);
                }
            }
            if (!set.equals(mapComputeContentDigests.keySet())) {
                throw new RuntimeException("Mismatch between sets of requested and computed content digests . Requested: " + set + ", computed: " + mapComputeContentDigests.keySet());
            }
            for (Result.SignerInfo signerInfo : result.signers) {
                for (Result.SignerInfo.ContentDigest contentDigest : signerInfo.contentDigests) {
                    SignatureAlgorithm signatureAlgorithmFindById = SignatureAlgorithm.findById(contentDigest.getSignatureAlgorithmId());
                    if (signatureAlgorithmFindById != null) {
                        ContentDigestAlgorithm contentDigestAlgorithm = signatureAlgorithmFindById.getContentDigestAlgorithm();
                        if (set.contains(contentDigestAlgorithm)) {
                            byte[] value = contentDigest.getValue();
                            byte[] bArr = mapComputeContentDigests.get(contentDigestAlgorithm);
                            if (Arrays.equals(value, bArr)) {
                                signerInfo.verifiedContentDigests.put(contentDigestAlgorithm, bArr);
                            } else {
                                int i = result.signatureSchemeVersion;
                                if (i == 2) {
                                    signerInfo.addError(ApkVerifier.Issue.V2_SIG_APK_DIGEST_DID_NOT_VERIFY, contentDigestAlgorithm, toHex(value), toHex(bArr));
                                } else if (i == 3) {
                                    signerInfo.addError(ApkVerifier.Issue.V3_SIG_APK_DIGEST_DID_NOT_VERIFY, contentDigestAlgorithm, toHex(value), toHex(bArr));
                                }
                            }
                        }
                    }
                }
            }
        } catch (DigestException e) {
            throw new RuntimeException("Failed to compute content digests", e);
        }
    }
}
