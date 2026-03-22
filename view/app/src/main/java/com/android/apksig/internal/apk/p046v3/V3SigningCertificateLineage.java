package com.android.apksig.internal.apk.p046v3;

import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.apk.SignatureAlgorithm;
import com.android.apksig.internal.util.GuaranteedEncodedFormX509Certificate;
import com.android.apksig.internal.util.X509CertificateUtils;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class V3SigningCertificateLineage {

    public static class SigningCertificateNode {
        public int flags;
        public final SignatureAlgorithm parentSigAlgorithm;
        public SignatureAlgorithm sigAlgorithm;
        public final byte[] signature;
        public final X509Certificate signingCert;

        public SigningCertificateNode(X509Certificate x509Certificate, SignatureAlgorithm signatureAlgorithm, SignatureAlgorithm signatureAlgorithm2, byte[] bArr, int i) {
            this.signingCert = x509Certificate;
            this.parentSigAlgorithm = signatureAlgorithm;
            this.sigAlgorithm = signatureAlgorithm2;
            this.signature = bArr;
            this.flags = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SigningCertificateNode)) {
                return false;
            }
            SigningCertificateNode signingCertificateNode = (SigningCertificateNode) obj;
            return this.signingCert.equals(signingCertificateNode.signingCert) && this.parentSigAlgorithm == signingCertificateNode.parentSigAlgorithm && this.sigAlgorithm == signingCertificateNode.sigAlgorithm && Arrays.equals(this.signature, signingCertificateNode.signature) && this.flags == signingCertificateNode.flags;
        }
    }

    public static byte[] encodeSignedData(X509Certificate x509Certificate, int i) {
        try {
            byte[] bArrEncodeAsLengthPrefixedElement = ApkSigningBlockUtils.encodeAsLengthPrefixedElement(x509Certificate.getEncoded());
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrEncodeAsLengthPrefixedElement.length + 4);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.put(bArrEncodeAsLengthPrefixedElement);
            byteBufferAllocate.putInt(i);
            return ApkSigningBlockUtils.encodeAsLengthPrefixedElement(byteBufferAllocate.array());
        } catch (CertificateEncodingException e) {
            throw new RuntimeException("Failed to encode V3SigningCertificateLineage certificate", e);
        }
    }

    public static byte[] encodeSigningCertificateLineage(List<SigningCertificateNode> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<SigningCertificateNode> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(encodeSigningCertificateNode(it.next()));
        }
        byte[] bArrEncodeAsSequenceOfLengthPrefixedElements = ApkSigningBlockUtils.encodeAsSequenceOfLengthPrefixedElements(arrayList);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrEncodeAsSequenceOfLengthPrefixedElements.length + 4);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.put(bArrEncodeAsSequenceOfLengthPrefixedElements);
        return byteBufferAllocate.array();
    }

    public static byte[] encodeSigningCertificateNode(SigningCertificateNode signingCertificateNode) {
        SignatureAlgorithm signatureAlgorithm = signingCertificateNode.parentSigAlgorithm;
        int id = signatureAlgorithm != null ? signatureAlgorithm.getId() : 0;
        SignatureAlgorithm signatureAlgorithm2 = signingCertificateNode.sigAlgorithm;
        int id2 = signatureAlgorithm2 != null ? signatureAlgorithm2.getId() : 0;
        byte[] bArrEncodeSignedData = encodeSignedData(signingCertificateNode.signingCert, id);
        byte[] bArrEncodeAsLengthPrefixedElement = ApkSigningBlockUtils.encodeAsLengthPrefixedElement(signingCertificateNode.signature);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrEncodeSignedData.length + 4 + 4 + bArrEncodeAsLengthPrefixedElement.length);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.put(bArrEncodeSignedData);
        byteBufferAllocate.putInt(signingCertificateNode.flags);
        byteBufferAllocate.putInt(id2);
        byteBufferAllocate.put(bArrEncodeAsLengthPrefixedElement);
        return byteBufferAllocate.array();
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0120: MOVE (r5 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:50:0x011f */
    public static List<SigningCertificateNode> readSigningCertificateLineage(ByteBuffer byteBuffer) throws IOException {
        String str;
        String str2;
        Throwable th;
        String str3;
        String str4;
        String str5 = " when parsing V3SigningCertificateLineage object";
        ArrayList arrayList = new ArrayList();
        GuaranteedEncodedFormX509Certificate guaranteedEncodedFormX509Certificate = null;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            return null;
        }
        ApkSigningBlockUtils.checkByteOrderLittleEndian(byteBuffer);
        int i = 0;
        try {
            try {
                try {
                    if (byteBuffer.getInt() != 1) {
                        throw new IllegalArgumentException("Encoded SigningCertificateLineage has a version different than any of which we are aware");
                    }
                    HashSet hashSet = new HashSet();
                    int i2 = 0;
                    while (byteBuffer.hasRemaining()) {
                        i++;
                        ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtils.getLengthPrefixedSlice(byteBuffer);
                        ByteBuffer lengthPrefixedSlice2 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice);
                        int i3 = lengthPrefixedSlice.getInt();
                        int i4 = lengthPrefixedSlice.getInt();
                        SignatureAlgorithm signatureAlgorithmFindById = SignatureAlgorithm.findById(i2);
                        byte[] lengthPrefixedByteArray = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice);
                        if (guaranteedEncodedFormX509Certificate != null) {
                            String first = signatureAlgorithmFindById.getJcaSignatureAlgorithmAndParams().getFirst();
                            AlgorithmParameterSpec second = signatureAlgorithmFindById.getJcaSignatureAlgorithmAndParams().getSecond();
                            PublicKey publicKey = guaranteedEncodedFormX509Certificate.getPublicKey();
                            str4 = str5;
                            Signature signature = Signature.getInstance(first);
                            signature.initVerify(publicKey);
                            if (second != null) {
                                signature.setParameter(second);
                            }
                            signature.update(lengthPrefixedSlice2);
                            if (!signature.verify(lengthPrefixedByteArray)) {
                                throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + first + " when verifying V3SigningCertificateLineage object");
                            }
                        } else {
                            str4 = str5;
                        }
                        lengthPrefixedSlice2.rewind();
                        byte[] lengthPrefixedByteArray2 = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice2);
                        int i5 = lengthPrefixedSlice2.getInt();
                        if (guaranteedEncodedFormX509Certificate != null && i2 != i5) {
                            throw new SecurityException("Signing algorithm ID mismatch for certificate #" + lengthPrefixedSlice + " when verifying V3SigningCertificateLineage object");
                        }
                        GuaranteedEncodedFormX509Certificate guaranteedEncodedFormX509Certificate2 = new GuaranteedEncodedFormX509Certificate(X509CertificateUtils.generateCertificate(lengthPrefixedByteArray2), lengthPrefixedByteArray2);
                        if (hashSet.contains(guaranteedEncodedFormX509Certificate2)) {
                            throw new SecurityException("Encountered duplicate entries in SigningCertificateLineage at certificate #" + i + ".  All signing certificates should be unique");
                        }
                        hashSet.add(guaranteedEncodedFormX509Certificate2);
                        arrayList.add(new SigningCertificateNode(guaranteedEncodedFormX509Certificate2, SignatureAlgorithm.findById(i5), SignatureAlgorithm.findById(i4), lengthPrefixedByteArray, i3));
                        guaranteedEncodedFormX509Certificate = guaranteedEncodedFormX509Certificate2;
                        i2 = i4;
                        str5 = str4;
                    }
                    return arrayList;
                } catch (InvalidAlgorithmParameterException e) {
                    e = e;
                    th = e;
                    str2 = str3;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
                } catch (InvalidKeyException e2) {
                    e = e2;
                    th = e;
                    str2 = str3;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    th = e;
                    str2 = str3;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
                } catch (SignatureException e4) {
                    e = e4;
                    th = e;
                    str2 = str3;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
                } catch (CertificateException e5) {
                    e = e5;
                    throw new SecurityException("Failed to decode certificate #" + i + str, e);
                }
            } catch (InvalidAlgorithmParameterException e6) {
                e = e6;
                str2 = str5;
                th = e;
            } catch (InvalidKeyException e7) {
                e = e7;
                str2 = str5;
                th = e;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                str2 = str5;
                th = e;
            } catch (SignatureException e9) {
                e = e9;
                str2 = str5;
                th = e;
            } catch (CertificateException e10) {
                e = e10;
                str = str5;
            }
            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
        } catch (ApkFormatException | BufferUnderflowException e11) {
            throw new IOException("Failed to parse V3SigningCertificateLineage object", e11);
        }
    }
}
