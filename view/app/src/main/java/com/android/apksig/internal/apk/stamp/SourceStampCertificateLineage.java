package com.android.apksig.internal.apk.stamp;

import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.internal.apk.ApkSigningBlockUtilsLite;
import com.android.apksig.internal.apk.SignatureAlgorithm;
import com.android.apksig.internal.util.GuaranteedEncodedFormX509Certificate;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SourceStampCertificateLineage {

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

        public int hashCode() {
            X509Certificate x509Certificate = this.signingCert;
            int iHashCode = ((x509Certificate == null ? 0 : x509Certificate.hashCode()) + 31) * 31;
            SignatureAlgorithm signatureAlgorithm = this.parentSigAlgorithm;
            int iHashCode2 = (iHashCode + (signatureAlgorithm == null ? 0 : signatureAlgorithm.hashCode())) * 31;
            SignatureAlgorithm signatureAlgorithm2 = this.sigAlgorithm;
            return ((((iHashCode2 + (signatureAlgorithm2 != null ? signatureAlgorithm2.hashCode() : 0)) * 31) + Arrays.hashCode(this.signature)) * 31) + this.flags;
        }
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x012e: MOVE (r4 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:52:0x012d */
    public static List<SigningCertificateNode> readSigningCertificateLineage(ByteBuffer byteBuffer) throws IOException {
        String str;
        String str2;
        Throwable th;
        String str3;
        String str4;
        String str5 = " when parsing SourceStampCertificateLineage object";
        ArrayList arrayList = new ArrayList();
        GuaranteedEncodedFormX509Certificate guaranteedEncodedFormX509Certificate = null;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            return null;
        }
        ApkSigningBlockUtilsLite.checkByteOrderLittleEndian(byteBuffer);
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            int i = 0;
            try {
                try {
                } catch (InvalidAlgorithmParameterException e) {
                    e = e;
                    str2 = str5;
                    th = e;
                } catch (InvalidKeyException e2) {
                    e = e2;
                    str2 = str5;
                    th = e;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    str2 = str5;
                    th = e;
                } catch (SignatureException e4) {
                    e = e4;
                    str2 = str5;
                    th = e;
                } catch (CertificateException e5) {
                    e = e5;
                    str = str5;
                }
                try {
                    if (byteBuffer.getInt() != 1) {
                        throw new IllegalArgumentException("Encoded SigningCertificateLineage has a version different than any of which we are aware");
                    }
                    HashSet hashSet = new HashSet();
                    int i2 = 0;
                    while (byteBuffer.hasRemaining()) {
                        i++;
                        ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtilsLite.getLengthPrefixedSlice(byteBuffer);
                        ByteBuffer lengthPrefixedSlice2 = ApkSigningBlockUtilsLite.getLengthPrefixedSlice(lengthPrefixedSlice);
                        int i3 = lengthPrefixedSlice.getInt();
                        int i4 = lengthPrefixedSlice.getInt();
                        SignatureAlgorithm signatureAlgorithmFindById = SignatureAlgorithm.findById(i2);
                        byte[] lengthPrefixedByteArray = ApkSigningBlockUtilsLite.readLengthPrefixedByteArray(lengthPrefixedSlice);
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
                                throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + first + " when verifying SourceStampCertificateLineage object");
                            }
                        } else {
                            str4 = str5;
                        }
                        lengthPrefixedSlice2.rewind();
                        byte[] lengthPrefixedByteArray2 = ApkSigningBlockUtilsLite.readLengthPrefixedByteArray(lengthPrefixedSlice2);
                        int i5 = lengthPrefixedSlice2.getInt();
                        if (guaranteedEncodedFormX509Certificate != null && i2 != i5) {
                            throw new SecurityException("Signing algorithm ID mismatch for certificate #" + lengthPrefixedSlice + " when verifying SourceStampCertificateLineage object");
                        }
                        GuaranteedEncodedFormX509Certificate guaranteedEncodedFormX509Certificate2 = new GuaranteedEncodedFormX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(lengthPrefixedByteArray2)), lengthPrefixedByteArray2);
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
                } catch (InvalidAlgorithmParameterException e6) {
                    e = e6;
                    th = e;
                    str2 = str3;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
                } catch (InvalidKeyException e7) {
                    e = e7;
                    th = e;
                    str2 = str3;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
                } catch (NoSuchAlgorithmException e8) {
                    e = e8;
                    th = e;
                    str2 = str3;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
                } catch (SignatureException e9) {
                    e = e9;
                    th = e;
                    str2 = str3;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
                } catch (CertificateException e10) {
                    e = e10;
                    throw new SecurityException("Failed to decode certificate #" + i + str, e);
                }
                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str2, th);
            } catch (ApkFormatException | BufferUnderflowException e11) {
                throw new IOException("Failed to parse SourceStampCertificateLineage object", e11);
            }
        } catch (CertificateException e12) {
            throw new IllegalStateException("Failed to obtain X.509 CertificateFactory", e12);
        }
    }
}
