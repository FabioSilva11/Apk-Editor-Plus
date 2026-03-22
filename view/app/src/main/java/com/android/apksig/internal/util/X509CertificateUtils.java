package com.android.apksig.internal.util;

import android.util.Base64;
import com.android.apksig.internal.asn1.Asn1BerParser;
import com.android.apksig.internal.asn1.Asn1DecodingException;
import com.android.apksig.internal.asn1.Asn1DerEncoder;
import com.android.apksig.internal.asn1.Asn1EncodingException;
import com.android.apksig.internal.x509.Certificate;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class X509CertificateUtils {
    public static final byte[] BEGIN_CERT_HEADER = "-----BEGIN CERTIFICATE-----".getBytes();
    public static final byte[] END_CERT_FOOTER = "-----END CERTIFICATE-----".getBytes();
    public static CertificateFactory sCertFactory;

    public static void buildCertFactory() {
        if (sCertFactory != null) {
            return;
        }
        try {
            sCertFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new RuntimeException("Failed to create X.509 CertificateFactory", e);
        }
    }

    public static X509Certificate generateCertificate(InputStream inputStream) throws CertificateException {
        try {
            return generateCertificate(ByteStreams.toByteArray(inputStream));
        } catch (IOException e) {
            throw new CertificateException("Failed to parse certificate", e);
        }
    }

    public static X509Certificate generateCertificate(byte[] bArr) throws CertificateException {
        if (sCertFactory == null) {
            buildCertFactory();
        }
        return generateCertificate(bArr, sCertFactory);
    }

    public static X509Certificate generateCertificate(byte[] bArr, CertificateFactory certificateFactory) throws CertificateException {
        try {
            try {
                return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
            } catch (Asn1DecodingException | Asn1EncodingException | CertificateException e) {
                throw new CertificateException("Failed to parse certificate", e);
            }
        } catch (CertificateException unused) {
            ByteBuffer nextDEREncodedCertificateBlock = getNextDEREncodedCertificateBlock(ByteBuffer.wrap(bArr));
            int iPosition = nextDEREncodedCertificateBlock.position();
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(Asn1DerEncoder.encode((Certificate) Asn1BerParser.parse(nextDEREncodedCertificateBlock, Certificate.class))));
            byte[] bArr2 = new byte[nextDEREncodedCertificateBlock.position() - iPosition];
            nextDEREncodedCertificateBlock.position(iPosition);
            nextDEREncodedCertificateBlock.get(bArr2);
            return new GuaranteedEncodedFormX509Certificate(x509Certificate, bArr2);
        }
    }

    public static Collection<? extends java.security.cert.Certificate> generateCertificates(InputStream inputStream) throws CertificateException {
        if (sCertFactory == null) {
            buildCertFactory();
        }
        return generateCertificates(inputStream, sCertFactory);
    }

    public static Collection<? extends java.security.cert.Certificate> generateCertificates(InputStream inputStream, CertificateFactory certificateFactory) throws CertificateException {
        try {
            byte[] byteArray = ByteStreams.toByteArray(inputStream);
            try {
                try {
                    return certificateFactory.generateCertificates(new ByteArrayInputStream(byteArray));
                } catch (Asn1DecodingException | Asn1EncodingException e) {
                    throw new CertificateException("Failed to parse certificates", e);
                }
            } catch (CertificateException unused) {
                ArrayList arrayList = new ArrayList(1);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArray);
                while (byteBufferWrap.hasRemaining()) {
                    ByteBuffer nextDEREncodedCertificateBlock = getNextDEREncodedCertificateBlock(byteBufferWrap);
                    int iPosition = nextDEREncodedCertificateBlock.position();
                    X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(Asn1DerEncoder.encode((Certificate) Asn1BerParser.parse(nextDEREncodedCertificateBlock, Certificate.class))));
                    byte[] bArr = new byte[nextDEREncodedCertificateBlock.position() - iPosition];
                    nextDEREncodedCertificateBlock.position(iPosition);
                    nextDEREncodedCertificateBlock.get(bArr);
                    arrayList.add(new GuaranteedEncodedFormX509Certificate(x509Certificate, bArr));
                }
                return arrayList;
            }
        } catch (IOException e2) {
            throw new CertificateException("Failed to read the input stream", e2);
        }
    }

    public static ByteBuffer getNextDEREncodedCertificateBlock(ByteBuffer byteBuffer) throws CertificateException {
        char c;
        if (byteBuffer == null) {
            throw new NullPointerException("The certificateBuffer cannot be null");
        }
        if (byteBuffer.remaining() < BEGIN_CERT_HEADER.length) {
            return byteBuffer;
        }
        byteBuffer.mark();
        int i = 0;
        while (true) {
            byte[] bArr = BEGIN_CERT_HEADER;
            if (i >= bArr.length) {
                StringBuilder sb = new StringBuilder();
                while (byteBuffer.hasRemaining() && (c = (char) byteBuffer.get()) != '-') {
                    if (!Character.isWhitespace(c)) {
                        sb.append(c);
                    }
                }
                int i2 = 1;
                while (true) {
                    byte[] bArr2 = END_CERT_FOOTER;
                    if (i2 >= bArr2.length) {
                        byte[] bArrDecode = Base64.decode(sb.toString(), 2);
                        int iPosition = byteBuffer.position();
                        while (byteBuffer.hasRemaining() && Character.isWhitespace((char) byteBuffer.get())) {
                            iPosition++;
                        }
                        byteBuffer.position(iPosition);
                        return ByteBuffer.wrap(bArrDecode);
                    }
                    if (!byteBuffer.hasRemaining()) {
                        throw new CertificateException("The provided input contains the PEM certificate header but does not contain sufficient data for the footer");
                    }
                    if (byteBuffer.get() != bArr2[i2]) {
                        throw new CertificateException("The provided input contains the PEM certificate header without a valid certificate footer");
                    }
                    i2++;
                }
            } else {
                if (byteBuffer.get() != bArr[i]) {
                    byteBuffer.reset();
                    return byteBuffer;
                }
                i++;
            }
        }
    }
}
