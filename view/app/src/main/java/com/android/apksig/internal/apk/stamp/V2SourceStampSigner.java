package com.android.apksig.internal.apk.stamp;

import com.android.apksig.SigningCertificateLineage;
import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class V2SourceStampSigner {
    public static final int V2_SOURCE_STAMP_BLOCK_ID = 1845461005;

    public static final class SourceStampBlock {
        public List<Pair<Integer, byte[]>> signedDigests;
        public List<Pair<Integer, byte[]>> signedStampAttributes;
        public byte[] stampAttributes;
        public byte[] stampCertificate;

        public SourceStampBlock() {
        }
    }

    public static byte[] encodeStampAttributes(Map<Integer, byte[]> map) {
        Iterator<byte[]> it = map.values().iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 4);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(length);
        for (Map.Entry<Integer, byte[]> entry : map.entrySet()) {
            byteBufferAllocate.putInt(entry.getValue().length + 4);
            byteBufferAllocate.putInt(entry.getKey().intValue());
            byteBufferAllocate.put(entry.getValue());
        }
        return byteBufferAllocate.array();
    }

    public static Pair<byte[], Integer> generateSourceStampBlock(ApkSigningBlockUtils.SignerConfig signerConfig, Map<Integer, Map<ContentDigestAlgorithm, byte[]>> map) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (signerConfig.certificates.isEmpty()) {
            throw new SignatureException("No certificates configured for signer");
        }
        ArrayList arrayList = new ArrayList();
        getSignedDigestsFor(3, map, signerConfig, arrayList);
        getSignedDigestsFor(2, map, signerConfig, arrayList);
        getSignedDigestsFor(1, map, signerConfig, arrayList);
        Collections.sort(arrayList, new Comparator<Pair<Integer, byte[]>>() { // from class: com.android.apksig.internal.apk.stamp.V2SourceStampSigner.1
            @Override // java.util.Comparator
            public int compare(Pair<Integer, byte[]> pair, Pair<Integer, byte[]> pair2) {
                return pair.getFirst().compareTo(pair2.getFirst());
            }
        });
        SourceStampBlock sourceStampBlock = new SourceStampBlock();
        try {
            sourceStampBlock.stampCertificate = signerConfig.certificates.get(0).getEncoded();
            sourceStampBlock.signedDigests = arrayList;
            byte[] bArrEncodeStampAttributes = encodeStampAttributes(generateStampAttributes(signerConfig.mSigningCertificateLineage));
            sourceStampBlock.stampAttributes = bArrEncodeStampAttributes;
            sourceStampBlock.signedStampAttributes = ApkSigningBlockUtils.generateSignaturesOverData(signerConfig, bArrEncodeStampAttributes);
            return Pair.m2038of(ApkSigningBlockUtils.encodeAsLengthPrefixedElement(ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedElements(new byte[][]{sourceStampBlock.stampCertificate, ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(sourceStampBlock.signedDigests), sourceStampBlock.stampAttributes, ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(sourceStampBlock.signedStampAttributes)})), 1845461005);
        } catch (CertificateEncodingException e) {
            throw new SignatureException("Retrieving the encoded form of the stamp certificate failed", e);
        }
    }

    public static Map<Integer, byte[]> generateStampAttributes(SigningCertificateLineage signingCertificateLineage) {
        HashMap map = new HashMap();
        if (signingCertificateLineage != null) {
            map.put(Integer.valueOf(SourceStampConstants.PROOF_OF_ROTATION_ATTR_ID), signingCertificateLineage.encodeSigningCertificateLineage());
        }
        return map;
    }

    public static void getSignedDigestsFor(int i, Map<Integer, Map<ContentDigestAlgorithm, byte[]>> map, ApkSigningBlockUtils.SignerConfig signerConfig, List<Pair<Integer, byte[]>> list) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (map.containsKey(Integer.valueOf(i))) {
            Map<ContentDigestAlgorithm, byte[]> map2 = map.get(Integer.valueOf(i));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<ContentDigestAlgorithm, byte[]> entry : map2.entrySet()) {
                arrayList.add(Pair.m2038of(Integer.valueOf(entry.getKey().getId()), entry.getValue()));
            }
            Collections.sort(arrayList, new Comparator<Pair<Integer, byte[]>>() { // from class: com.android.apksig.internal.apk.stamp.V2SourceStampSigner.2
                @Override // java.util.Comparator
                public int compare(Pair<Integer, byte[]> pair, Pair<Integer, byte[]> pair2) {
                    return pair.getFirst().compareTo(pair2.getFirst());
                }
            });
            list.add(Pair.m2038of(Integer.valueOf(i), ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(ApkSigningBlockUtils.generateSignaturesOverData(signerConfig, ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(arrayList)))));
        }
    }
}
