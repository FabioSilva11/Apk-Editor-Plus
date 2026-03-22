package com.android.apksig.internal.apk.p047v4;

import android.support.v7.widget.ActivityChooserView;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.apk.SignatureAlgorithm;
import com.android.apksig.internal.apk.p045v2.V2SchemeVerifier;
import com.android.apksig.internal.apk.p046v3.V3SchemeSigner;
import com.android.apksig.internal.apk.p046v3.V3SchemeVerifier;
import com.android.apksig.internal.apk.p047v4.V4Signature;
import com.android.apksig.internal.util.Pair;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipFormatException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class V4SchemeSigner {

    /* JADX INFO: renamed from: com.android.apksig.internal.apk.v4.V4SchemeSigner$1 */
    public static /* synthetic */ class C09121 {

        /* JADX INFO: renamed from: $SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm */
        public static final /* synthetic */ int[] f2277x5cfc638a;

        static {
            int[] iArr = new int[ContentDigestAlgorithm.values().length];
            f2277x5cfc638a = iArr;
            try {
                iArr[ContentDigestAlgorithm.CHUNKED_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2277x5cfc638a[ContentDigestAlgorithm.VERITY_CHUNKED_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2277x5cfc638a[ContentDigestAlgorithm.CHUNKED_SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static Pair<Integer, Byte> convertToV4HashingInfo(ContentDigestAlgorithm contentDigestAlgorithm) throws NoSuchAlgorithmException {
        if (C09121.f2277x5cfc638a[contentDigestAlgorithm.ordinal()] == 2) {
            return Pair.m2038of(1, (byte) 12);
        }
        throw new NoSuchAlgorithmException("Invalid hash algorithm, only SHA2-256 over 4 KB chunks supported.");
    }

    public static int digestAlgorithmSortingOrder(ContentDigestAlgorithm contentDigestAlgorithm) {
        int i = C09121.f2277x5cfc638a[contentDigestAlgorithm.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? -1 : 2;
        }
        return 1;
    }

    public static V4Signature generateSignature(ApkSigningBlockUtils.SignerConfig signerConfig, V4Signature.HashingInfo hashingInfo, byte[] bArr, byte[] bArr2, long j) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateEncodingException {
        if (signerConfig.certificates.isEmpty()) {
            throw new SignatureException("No certificates configured for signer");
        }
        if (signerConfig.certificates.size() != 1) {
            throw new CertificateEncodingException("Should only have one certificate");
        }
        PublicKey publicKey = signerConfig.certificates.get(0).getPublicKey();
        byte[] bArr3 = ApkSigningBlockUtils.encodeCertificates(signerConfig.certificates).get(0);
        List<Pair<Integer, byte[]>> listGenerateSignaturesOverData = ApkSigningBlockUtils.generateSignaturesOverData(signerConfig, V4Signature.getSigningData(j, hashingInfo, new V4Signature.SigningInfo(bArr, bArr3, bArr2, publicKey.getEncoded(), -1, null)));
        if (listGenerateSignaturesOverData.size() != 1) {
            throw new SignatureException("Should only be one signature generated");
        }
        return new V4Signature(2, hashingInfo.toByteArray(), new V4Signature.SigningInfo(bArr, bArr3, bArr2, publicKey.getEncoded(), listGenerateSignaturesOverData.get(0).getFirst().intValue(), listGenerateSignaturesOverData.get(0).getSecond()).toByteArray());
    }

    public static Pair<V4Signature, byte[]> generateV4Signature(DataSource dataSource, ApkSigningBlockUtils.SignerConfig signerConfig) throws NoSuchAlgorithmException, IOException, InvalidKeyException {
        long size = dataSource.size();
        byte[] apkDigest = getApkDigest(dataSource);
        ApkSigningBlockUtils.VerityTreeAndDigest verityTreeAndDigestComputeChunkVerityTreeAndDigest = ApkSigningBlockUtils.computeChunkVerityTreeAndDigest(dataSource);
        ContentDigestAlgorithm contentDigestAlgorithm = verityTreeAndDigestComputeChunkVerityTreeAndDigest.contentDigestAlgorithm;
        byte[] bArr = verityTreeAndDigestComputeChunkVerityTreeAndDigest.rootHash;
        byte[] bArr2 = verityTreeAndDigestComputeChunkVerityTreeAndDigest.tree;
        Pair<Integer, Byte> pairConvertToV4HashingInfo = convertToV4HashingInfo(contentDigestAlgorithm);
        try {
            return Pair.m2038of(generateSignature(signerConfig, new V4Signature.HashingInfo(pairConvertToV4HashingInfo.getFirst().intValue(), pairConvertToV4HashingInfo.getSecond().byteValue(), null, bArr), apkDigest, null, size), bArr2);
        } catch (InvalidKeyException | SignatureException | CertificateEncodingException e) {
            throw new InvalidKeyException("Signer failed", e);
        }
    }

    public static void generateV4Signature(DataSource dataSource, ApkSigningBlockUtils.SignerConfig signerConfig, File file) throws NoSuchAlgorithmException, IOException, InvalidKeyException {
        Pair<V4Signature, byte[]> pairGenerateV4Signature = generateV4Signature(dataSource, signerConfig);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                pairGenerateV4Signature.getFirst().writeTo(fileOutputStream);
                V4Signature.writeBytes(fileOutputStream, pairGenerateV4Signature.getSecond());
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }

    public static byte[] getApkDigest(DataSource dataSource) throws IOException {
        try {
            ApkUtils.ZipSections zipSectionsFindZipSections = ApkUtils.findZipSections(dataSource);
            try {
                return getBestV3Digest(dataSource, zipSectionsFindZipSections);
            } catch (SignatureException e) {
                try {
                    return getBestV2Digest(dataSource, zipSectionsFindZipSections);
                } catch (SignatureException e2) {
                    throw new IOException("Failed to obtain v2/v3 digest, v3 exception: " + e + ", v2 exception: " + e2);
                }
            }
        } catch (ZipFormatException e3) {
            throw new IOException("Malformed APK: not a ZIP archive", e3);
        }
    }

    public static byte[] getBestV2Digest(DataSource dataSource, ApkUtils.ZipSections zipSections) throws SignatureException {
        HashSet hashSet = new HashSet(1);
        HashSet hashSet2 = new HashSet(1);
        ApkSigningBlockUtils.Result result = new ApkSigningBlockUtils.Result(2);
        try {
            V2SchemeVerifier.parseSigners(ApkSigningBlockUtils.findSignature(dataSource, zipSections, 1896449818, result).signatureBlock, hashSet, Collections.emptyMap(), hashSet2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, result);
            if (result.signers.size() != 1) {
                throw new SignatureException("Should only have one signer, errors: " + result.getErrors());
            }
            ApkSigningBlockUtils.Result.SignerInfo signerInfo = result.signers.get(0);
            if (!signerInfo.containsErrors()) {
                return pickBestDigest(signerInfo.contentDigests);
            }
            throw new SignatureException("Parsing failed: " + signerInfo.getErrors());
        } catch (Exception e) {
            throw new SignatureException("Failed to extract and parse v2 block", e);
        }
    }

    public static byte[] getBestV3Digest(DataSource dataSource, ApkUtils.ZipSections zipSections) throws SignatureException {
        HashSet hashSet = new HashSet(1);
        ApkSigningBlockUtils.Result result = new ApkSigningBlockUtils.Result(3);
        try {
            V3SchemeVerifier.parseSigners(ApkSigningBlockUtils.findSignature(dataSource, zipSections, -262969152, result).signatureBlock, hashSet, result);
            if (result.signers.size() != 1) {
                throw new SignatureException("Should only have one signer, errors: " + result.getErrors());
            }
            ApkSigningBlockUtils.Result.SignerInfo signerInfo = result.signers.get(0);
            if (!signerInfo.containsErrors()) {
                return pickBestDigest(result.signers.get(0).contentDigests);
            }
            throw new SignatureException("Parsing failed: " + signerInfo.getErrors());
        } catch (Exception e) {
            throw new SignatureException("Failed to extract and parse v3 block", e);
        }
    }

    public static List<SignatureAlgorithm> getSuggestedSignatureAlgorithms(PublicKey publicKey, int i, boolean z) throws InvalidKeyException {
        List<SignatureAlgorithm> suggestedSignatureAlgorithms = V3SchemeSigner.getSuggestedSignatureAlgorithms(publicKey, i, z);
        ListIterator<SignatureAlgorithm> listIterator = suggestedSignatureAlgorithms.listIterator();
        while (listIterator.hasNext()) {
            if (!isSupported(listIterator.next().getContentDigestAlgorithm(), false)) {
                listIterator.remove();
            }
        }
        return suggestedSignatureAlgorithms;
    }

    public static boolean isSupported(ContentDigestAlgorithm contentDigestAlgorithm, boolean z) {
        if (contentDigestAlgorithm == null) {
            return false;
        }
        if (contentDigestAlgorithm == ContentDigestAlgorithm.CHUNKED_SHA256 || contentDigestAlgorithm == ContentDigestAlgorithm.CHUNKED_SHA512) {
            return true;
        }
        return z && contentDigestAlgorithm == ContentDigestAlgorithm.VERITY_CHUNKED_SHA256;
    }

    public static byte[] pickBestDigest(List<ApkSigningBlockUtils.Result.SignerInfo.ContentDigest> list) throws SignatureException {
        int iDigestAlgorithmSortingOrder;
        if (list == null || list.isEmpty()) {
            throw new SignatureException("Should have at least one digest");
        }
        int i = -1;
        byte[] value = null;
        for (ApkSigningBlockUtils.Result.SignerInfo.ContentDigest contentDigest : list) {
            ContentDigestAlgorithm contentDigestAlgorithm = SignatureAlgorithm.findById(contentDigest.getSignatureAlgorithmId()).getContentDigestAlgorithm();
            if (isSupported(contentDigestAlgorithm, true) && i < (iDigestAlgorithmSortingOrder = digestAlgorithmSortingOrder(contentDigestAlgorithm))) {
                value = contentDigest.getValue();
                i = iDigestAlgorithmSortingOrder;
            }
        }
        if (value != null) {
            return value;
        }
        throw new SignatureException("Failed to find a supported digest in the source APK");
    }
}
