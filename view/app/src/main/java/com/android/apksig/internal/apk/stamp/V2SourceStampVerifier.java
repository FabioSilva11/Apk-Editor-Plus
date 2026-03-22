package com.android.apksig.internal.apk.stamp;

import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.internal.apk.ApkSigResult;
import com.android.apksig.internal.apk.ApkSignerInfo;
import com.android.apksig.internal.apk.ApkSigningBlockUtilsLite;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.apk.SignatureNotFoundException;
import com.android.apksig.internal.util.Pair;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipSections;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class V2SourceStampVerifier {
    public static List<Pair<Integer, byte[]>> getApkDigests(Map<ContentDigestAlgorithm, byte[]> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ContentDigestAlgorithm, byte[]> entry : map.entrySet()) {
            arrayList.add(Pair.m2038of(Integer.valueOf(entry.getKey().getId()), entry.getValue()));
        }
        Collections.sort(arrayList, new Comparator<Pair<Integer, byte[]>>() { // from class: com.android.apksig.internal.apk.stamp.V2SourceStampVerifier.1
            @Override // java.util.Comparator
            public int compare(Pair<Integer, byte[]> pair, Pair<Integer, byte[]> pair2) {
                return pair.getFirst().compareTo(pair2.getFirst());
            }
        });
        return arrayList;
    }

    public static Map<Integer, byte[]> getSignatureSchemeDigests(Map<Integer, Map<ContentDigestAlgorithm, byte[]>> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Integer, Map<ContentDigestAlgorithm, byte[]>> entry : map.entrySet()) {
            map2.put(entry.getKey(), ApkSigningBlockUtilsLite.encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(getApkDigests(entry.getValue())));
        }
        return map2;
    }

    public static ApkSigResult verify(DataSource dataSource, ZipSections zipSections, byte[] bArr, Map<Integer, Map<ContentDigestAlgorithm, byte[]>> map, int i, int i2) throws SignatureNotFoundException, NoSuchAlgorithmException, IOException {
        ApkSigResult apkSigResult = new ApkSigResult(0);
        verify(ApkSigningBlockUtilsLite.findSignature(dataSource, zipSections, 1845461005).signatureBlock, bArr, map, i, i2, apkSigResult);
        return apkSigResult;
    }

    public static void verify(ByteBuffer byteBuffer, byte[] bArr, Map<Integer, Map<ContentDigestAlgorithm, byte[]>> map, int i, int i2, ApkSigResult apkSigResult) throws NoSuchAlgorithmException {
        ApkSignerInfo apkSignerInfo = new ApkSignerInfo();
        apkSigResult.mSigners.add(apkSignerInfo);
        try {
            SourceStampVerifier.verifyV2SourceStamp(ApkSigningBlockUtilsLite.getLengthPrefixedSlice(byteBuffer), CertificateFactory.getInstance("X.509"), apkSignerInfo, getSignatureSchemeDigests(map), bArr, i, i2);
            apkSigResult.verified = (apkSigResult.containsErrors() || apkSigResult.containsWarnings()) ? false : true;
        } catch (ApkFormatException | BufferUnderflowException unused) {
            apkSignerInfo.addWarning(20, new Object[0]);
        } catch (CertificateException e) {
            throw new IllegalStateException("Failed to obtain X.509 CertificateFactory", e);
        }
    }
}
