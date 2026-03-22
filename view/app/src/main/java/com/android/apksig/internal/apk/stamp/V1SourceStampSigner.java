package com.android.apksig.internal.apk.stamp;

import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.util.Pair;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class V1SourceStampSigner {
    public static final int V1_SOURCE_STAMP_BLOCK_ID = 722016414;

    public static final class SourceStampBlock {
        public List<Pair<Integer, byte[]>> signedDigests;
        public byte[] stampCertificate;

        public SourceStampBlock() {
        }
    }

    public static Pair<byte[], Integer> generateSourceStampBlock(ApkSigningBlockUtils.SignerConfig signerConfig, Map<ContentDigestAlgorithm, byte[]> map) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (signerConfig.certificates.isEmpty()) {
            throw new SignatureException("No certificates configured for signer");
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ContentDigestAlgorithm, byte[]> entry : map.entrySet()) {
            arrayList.add(Pair.m2038of(Integer.valueOf(entry.getKey().getId()), entry.getValue()));
        }
        Collections.sort(arrayList, new Comparator<Pair<Integer, byte[]>>() { // from class: com.android.apksig.internal.apk.stamp.V1SourceStampSigner.1
            @Override // java.util.Comparator
            public int compare(Pair<Integer, byte[]> pair, Pair<Integer, byte[]> pair2) {
                return pair.getFirst().compareTo(pair2.getFirst());
            }
        });
        SourceStampBlock sourceStampBlock = new SourceStampBlock();
        try {
            sourceStampBlock.stampCertificate = signerConfig.certificates.get(0).getEncoded();
            List<Pair<Integer, byte[]>> listGenerateSignaturesOverData = ApkSigningBlockUtils.generateSignaturesOverData(signerConfig, ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(arrayList));
            sourceStampBlock.signedDigests = listGenerateSignaturesOverData;
            return Pair.m2038of(ApkSigningBlockUtils.encodeAsLengthPrefixedElement(ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedElements(new byte[][]{sourceStampBlock.stampCertificate, ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(listGenerateSignaturesOverData)})), 722016414);
        } catch (CertificateEncodingException e) {
            throw new SignatureException("Retrieving the encoded form of the stamp certificate failed", e);
        }
    }
}
