package com.android.apksig.internal.apk.p045v2;

import com.android.apksig.ApkVerifier;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.apk.SignatureAlgorithm;
import com.android.apksig.internal.apk.SignatureInfo;
import com.android.apksig.internal.util.ByteBufferUtils;
import com.android.apksig.internal.util.GuaranteedEncodedFormX509Certificate;
import com.android.apksig.internal.util.X509CertificateUtils;
import com.android.apksig.util.DataSource;
import com.android.apksig.util.RunnablesExecutor;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class V2SchemeVerifier {
    public static void parseSigner(ByteBuffer byteBuffer, CertificateFactory certificateFactory, ApkSigningBlockUtils.Result.SignerInfo signerInfo, Set<ContentDigestAlgorithm> set, Map<Integer, String> map, Set<Integer> set2, int i, int i2) throws NoSuchAlgorithmException, ApkFormatException {
        byte[] encoded;
        ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtils.getLengthPrefixedSlice(byteBuffer);
        byte[] bArr = new byte[lengthPrefixedSlice.remaining()];
        lengthPrefixedSlice.get(bArr);
        lengthPrefixedSlice.flip();
        signerInfo.signedData = bArr;
        ByteBuffer lengthPrefixedSlice2 = ApkSigningBlockUtils.getLengthPrefixedSlice(byteBuffer);
        byte[] lengthPrefixedByteArray = ApkSigningBlockUtils.readLengthPrefixedByteArray(byteBuffer);
        ArrayList arrayList = new ArrayList(1);
        int i3 = 0;
        while (lengthPrefixedSlice2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer lengthPrefixedSlice3 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice2);
                int i4 = lengthPrefixedSlice3.getInt();
                byte[] lengthPrefixedByteArray2 = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice3);
                signerInfo.signatures.add(new ApkSigningBlockUtils.Result.SignerInfo.Signature(i4, lengthPrefixedByteArray2));
                SignatureAlgorithm signatureAlgorithmFindById = SignatureAlgorithm.findById(i4);
                if (signatureAlgorithmFindById == null) {
                    signerInfo.addWarning(ApkVerifier.Issue.V2_SIG_UNKNOWN_SIG_ALGORITHM, Integer.valueOf(i4));
                } else {
                    arrayList.add(new ApkSigningBlockUtils.SupportedSignature(signatureAlgorithmFindById, lengthPrefixedByteArray2));
                }
            } catch (ApkFormatException | BufferUnderflowException unused) {
                signerInfo.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_SIGNATURE, Integer.valueOf(i3));
                return;
            }
        }
        if (signerInfo.signatures.isEmpty()) {
            signerInfo.addError(ApkVerifier.Issue.V2_SIG_NO_SIGNATURES, new Object[0]);
            return;
        }
        try {
            for (ApkSigningBlockUtils.SupportedSignature supportedSignature : ApkSigningBlockUtils.getSignaturesToVerify(arrayList, i, i2)) {
                SignatureAlgorithm signatureAlgorithm = supportedSignature.algorithm;
                String first = signatureAlgorithm.getJcaSignatureAlgorithmAndParams().getFirst();
                AlgorithmParameterSpec second = signatureAlgorithm.getJcaSignatureAlgorithmAndParams().getSecond();
                try {
                    PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(signatureAlgorithm.getJcaKeyAlgorithm()).generatePublic(new X509EncodedKeySpec(lengthPrefixedByteArray));
                    try {
                        Signature signature = Signature.getInstance(first);
                        signature.initVerify(publicKeyGeneratePublic);
                        if (second != null) {
                            signature.setParameter(second);
                        }
                        lengthPrefixedSlice.position(0);
                        signature.update(lengthPrefixedSlice);
                        byte[] bArr2 = supportedSignature.signature;
                        if (!signature.verify(bArr2)) {
                            signerInfo.addError(ApkVerifier.Issue.V2_SIG_DID_NOT_VERIFY, signatureAlgorithm);
                            return;
                        } else {
                            signerInfo.verifiedSignatures.put(signatureAlgorithm, bArr2);
                            set.add(signatureAlgorithm.getContentDigestAlgorithm());
                        }
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException | SignatureException e) {
                        signerInfo.addError(ApkVerifier.Issue.V2_SIG_VERIFY_EXCEPTION, signatureAlgorithm, e);
                        return;
                    }
                } catch (Exception e2) {
                    signerInfo.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_PUBLIC_KEY, e2);
                    return;
                }
            }
            lengthPrefixedSlice.position(0);
            ByteBuffer lengthPrefixedSlice4 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice);
            ByteBuffer lengthPrefixedSlice5 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice);
            ByteBuffer lengthPrefixedSlice6 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice);
            int i5 = -1;
            while (lengthPrefixedSlice5.hasRemaining()) {
                int i6 = i5 + 1;
                byte[] lengthPrefixedByteArray3 = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice5);
                try {
                    signerInfo.certs.add(new GuaranteedEncodedFormX509Certificate(X509CertificateUtils.generateCertificate(lengthPrefixedByteArray3, certificateFactory), lengthPrefixedByteArray3));
                    i5 = i6;
                } catch (CertificateException e3) {
                    signerInfo.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_CERTIFICATE, Integer.valueOf(i6), Integer.valueOf(i6 + 1), e3);
                    return;
                }
            }
            if (signerInfo.certs.isEmpty()) {
                signerInfo.addError(ApkVerifier.Issue.V2_SIG_NO_CERTIFICATES, new Object[0]);
                return;
            }
            X509Certificate x509Certificate = signerInfo.certs.get(0);
            try {
                encoded = ApkSigningBlockUtils.encodePublicKey(x509Certificate.getPublicKey());
            } catch (InvalidKeyException e4) {
                System.out.println("Caught an exception encoding the public key: " + e4);
                e4.printStackTrace();
                encoded = x509Certificate.getPublicKey().getEncoded();
            }
            if (!Arrays.equals(lengthPrefixedByteArray, encoded)) {
                signerInfo.addError(ApkVerifier.Issue.V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, ApkSigningBlockUtils.toHex(encoded), ApkSigningBlockUtils.toHex(lengthPrefixedByteArray));
                return;
            }
            int i7 = 0;
            while (lengthPrefixedSlice4.hasRemaining()) {
                i7++;
                try {
                    ByteBuffer lengthPrefixedSlice7 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice4);
                    signerInfo.contentDigests.add(new ApkSigningBlockUtils.Result.SignerInfo.ContentDigest(lengthPrefixedSlice7.getInt(), ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice7)));
                } catch (ApkFormatException | BufferUnderflowException unused2) {
                    signerInfo.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_DIGEST, Integer.valueOf(i7));
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList(signerInfo.signatures.size());
            Iterator<ApkSigningBlockUtils.Result.SignerInfo.Signature> it = signerInfo.signatures.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(it.next().getAlgorithmId()));
            }
            ArrayList arrayList3 = new ArrayList(signerInfo.contentDigests.size());
            Iterator<ApkSigningBlockUtils.Result.SignerInfo.ContentDigest> it2 = signerInfo.contentDigests.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(it2.next().getSignatureAlgorithmId()));
            }
            if (!arrayList2.equals(arrayList3)) {
                signerInfo.addError(ApkVerifier.Issue.V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS, arrayList2, arrayList3);
                return;
            }
            Set<Integer> setKeySet = map.keySet();
            HashSet hashSet = new HashSet(1);
            int i8 = 0;
            while (lengthPrefixedSlice6.hasRemaining()) {
                i8++;
                try {
                    ByteBuffer lengthPrefixedSlice8 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice6);
                    int i9 = lengthPrefixedSlice8.getInt();
                    byte[] byteArray = ByteBufferUtils.toByteArray(lengthPrefixedSlice8);
                    signerInfo.additionalAttributes.add(new ApkSigningBlockUtils.Result.SignerInfo.AdditionalAttribute(i9, byteArray));
                    if (i9 != -1091571699) {
                        signerInfo.addWarning(ApkVerifier.Issue.V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i9));
                    } else {
                        int i10 = ByteBuffer.wrap(byteArray).order(ByteOrder.LITTLE_ENDIAN).getInt();
                        if (setKeySet.contains(Integer.valueOf(i10))) {
                            hashSet.add(Integer.valueOf(i10));
                        } else {
                            signerInfo.addWarning(ApkVerifier.Issue.V2_SIG_UNKNOWN_APK_SIG_SCHEME_ID, Integer.valueOf(signerInfo.index), Integer.valueOf(i10));
                        }
                    }
                } catch (ApkFormatException | BufferUnderflowException unused3) {
                    signerInfo.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i8));
                    return;
                }
            }
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                int iIntValue = ((Integer) it3.next()).intValue();
                if (!set2.contains(Integer.valueOf(iIntValue))) {
                    signerInfo.addError(ApkVerifier.Issue.V2_SIG_MISSING_APK_SIG_REFERENCED, Integer.valueOf(signerInfo.index), (String) map.get(Integer.valueOf(iIntValue)));
                }
            }
        } catch (ApkSigningBlockUtils.NoSupportedSignaturesException e5) {
            signerInfo.addError(ApkVerifier.Issue.V2_SIG_NO_SUPPORTED_SIGNATURES, e5);
        }
    }

    public static void parseSigners(ByteBuffer byteBuffer, Set<ContentDigestAlgorithm> set, Map<Integer, String> map, Set<Integer> set2, int i, int i2, ApkSigningBlockUtils.Result result) throws NoSuchAlgorithmException {
        try {
            ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtils.getLengthPrefixedSlice(byteBuffer);
            if (!lengthPrefixedSlice.hasRemaining()) {
                result.addError(ApkVerifier.Issue.V2_SIG_NO_SIGNERS, new Object[0]);
                return;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                int i3 = 0;
                while (lengthPrefixedSlice.hasRemaining()) {
                    int i4 = i3 + 1;
                    ApkSigningBlockUtils.Result.SignerInfo signerInfo = new ApkSigningBlockUtils.Result.SignerInfo();
                    signerInfo.index = i3;
                    result.signers.add(signerInfo);
                    try {
                        parseSigner(ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice), certificateFactory, signerInfo, set, map, set2, i, i2);
                        i3 = i4;
                    } catch (ApkFormatException | BufferUnderflowException unused) {
                        signerInfo.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_SIGNER, new Object[0]);
                        return;
                    }
                }
            } catch (CertificateException e) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e);
            }
        } catch (ApkFormatException unused2) {
            result.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_SIGNERS, new Object[0]);
        }
    }

    public static ApkSigningBlockUtils.Result verify(RunnablesExecutor runnablesExecutor, DataSource dataSource, ApkUtils.ZipSections zipSections, Map<Integer, String> map, Set<Integer> set, int i, int i2) throws ApkSigningBlockUtils.SignatureNotFoundException, NoSuchAlgorithmException, IOException, ApkFormatException {
        ApkSigningBlockUtils.Result result = new ApkSigningBlockUtils.Result(2);
        SignatureInfo signatureInfoFindSignature = ApkSigningBlockUtils.findSignature(dataSource, zipSections, 1896449818, result);
        DataSource dataSourceSlice = dataSource.slice(0L, signatureInfoFindSignature.apkSigningBlockOffset);
        long j = signatureInfoFindSignature.centralDirOffset;
        verify(runnablesExecutor, dataSourceSlice, signatureInfoFindSignature.signatureBlock, dataSource.slice(j, signatureInfoFindSignature.eocdOffset - j), signatureInfoFindSignature.eocd, map, set, i, i2, result);
        return result;
    }

    public static void verify(RunnablesExecutor runnablesExecutor, DataSource dataSource, ByteBuffer byteBuffer, DataSource dataSource2, ByteBuffer byteBuffer2, Map<Integer, String> map, Set<Integer> set, int i, int i2, ApkSigningBlockUtils.Result result) throws NoSuchAlgorithmException, IOException {
        HashSet hashSet = new HashSet(1);
        parseSigners(byteBuffer, hashSet, map, set, i, i2, result);
        if (result.containsErrors()) {
            return;
        }
        ApkSigningBlockUtils.verifyIntegrity(runnablesExecutor, dataSource, dataSource2, byteBuffer2, hashSet, result);
        if (result.containsErrors()) {
            return;
        }
        result.verified = true;
    }
}
