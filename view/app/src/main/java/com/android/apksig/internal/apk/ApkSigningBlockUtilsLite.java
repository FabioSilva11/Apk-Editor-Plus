package com.android.apksig.internal.apk;

import android.support.v7.widget.ActivityChooserView;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkSigningBlockNotFoundException;
import com.android.apksig.apk.ApkUtilsLite;
import com.android.apksig.internal.util.Pair;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipSections;
import com.gmail.heagoo.neweditor.Token;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApkSigningBlockUtilsLite {
    public static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: com.android.apksig.internal.apk.ApkSigningBlockUtilsLite$2 */
    public static /* synthetic */ class C09012 {

        /* JADX INFO: renamed from: $SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm */
        public static final /* synthetic */ int[] f2276x5cfc638a;

        static {
            int[] iArr = new int[ContentDigestAlgorithm.values().length];
            f2276x5cfc638a = iArr;
            try {
                iArr[ContentDigestAlgorithm.CHUNKED_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2276x5cfc638a[ContentDigestAlgorithm.CHUNKED_SHA512.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2276x5cfc638a[ContentDigestAlgorithm.VERITY_CHUNKED_SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void checkByteOrderLittleEndian(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int compareContentDigestAlgorithm(ContentDigestAlgorithm contentDigestAlgorithm, ContentDigestAlgorithm contentDigestAlgorithm2) {
        int[] iArr = C09012.f2276x5cfc638a;
        int i = iArr[contentDigestAlgorithm.ordinal()];
        if (i == 1) {
            int i2 = iArr[contentDigestAlgorithm2.ordinal()];
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown alg2: " + contentDigestAlgorithm2);
        }
        if (i == 2) {
            int i3 = iArr[contentDigestAlgorithm2.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return 0;
                }
                if (i3 != 3) {
                    throw new IllegalArgumentException("Unknown alg2: " + contentDigestAlgorithm2);
                }
            }
            return 1;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown alg1: " + contentDigestAlgorithm);
        }
        int i4 = iArr[contentDigestAlgorithm2.ordinal()];
        if (i4 == 1) {
            return 1;
        }
        if (i4 == 2) {
            return -1;
        }
        if (i4 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown alg2: " + contentDigestAlgorithm2);
    }

    public static int compareSignatureAlgorithm(SignatureAlgorithm signatureAlgorithm, SignatureAlgorithm signatureAlgorithm2) {
        return compareContentDigestAlgorithm(signatureAlgorithm.getContentDigestAlgorithm(), signatureAlgorithm2.getContentDigestAlgorithm());
    }

    public static byte[] encodeAsSequenceOfLengthPrefixedPairsOfIntAndLengthPrefixedBytes(List<Pair<Integer, byte[]>> list) {
        Iterator<Pair<Integer, byte[]>> it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().getSecond().length + 12;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        for (Pair<Integer, byte[]> pair : list) {
            byte[] second = pair.getSecond();
            byteBufferAllocate.putInt(second.length + 8);
            byteBufferAllocate.putInt(pair.getFirst().intValue());
            byteBufferAllocate.putInt(second.length);
            byteBufferAllocate.put(second);
        }
        return byteBufferAllocate.array();
    }

    public static ByteBuffer findApkSignatureSchemeBlock(ByteBuffer byteBuffer, int i) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer byteBufferSliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (byteBufferSliceFromTo.hasRemaining()) {
            i2++;
            if (byteBufferSliceFromTo.remaining() < 8) {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j = byteBufferSliceFromTo.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int iPosition = byteBufferSliceFromTo.position() + i3;
            if (i3 > byteBufferSliceFromTo.remaining()) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferSliceFromTo.remaining());
            }
            if (byteBufferSliceFromTo.getInt() == i) {
                return getByteBuffer(byteBufferSliceFromTo, i3 - 4);
            }
            byteBufferSliceFromTo.position(iPosition);
        }
        throw new SignatureNotFoundException("No APK Signature Scheme block in APK Signing Block with ID: " + i);
    }

    public static SignatureInfo findSignature(DataSource dataSource, ZipSections zipSections, int i) throws SignatureNotFoundException, IOException {
        try {
            ApkUtilsLite.ApkSigningBlock apkSigningBlockFindApkSigningBlock = ApkUtilsLite.findApkSigningBlock(dataSource, zipSections);
            long startOffset = apkSigningBlockFindApkSigningBlock.getStartOffset();
            DataSource contents = apkSigningBlockFindApkSigningBlock.getContents();
            ByteBuffer byteBuffer = contents.getByteBuffer(0L, (int) contents.size());
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return new SignatureInfo(findApkSignatureSchemeBlock(byteBuffer, i), startOffset, zipSections.getZipCentralDirectoryOffset(), zipSections.getZipEndOfCentralDirectoryOffset(), zipSections.getZipEndOfCentralDirectory());
        } catch (ApkSigningBlockNotFoundException e) {
            throw new SignatureNotFoundException(e.getMessage(), e);
        }
    }

    public static ByteBuffer getByteBuffer(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size: " + i);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    public static ByteBuffer getLengthPrefixedSlice(ByteBuffer byteBuffer) throws ApkFormatException {
        if (byteBuffer.remaining() < 4) {
            throw new ApkFormatException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            return getByteBuffer(byteBuffer, i);
        }
        throw new ApkFormatException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
    }

    public static <T extends ApkSupportedSignature> List<T> getSignaturesToVerify(List<T> list, int i, int i2) throws NoApkSupportedSignaturesException {
        return getSignaturesToVerify(list, i, i2, false);
    }

    public static <T extends ApkSupportedSignature> List<T> getSignaturesToVerify(List<T> list, int i, int i2, boolean z) throws NoApkSupportedSignaturesException {
        HashMap map = new HashMap();
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (T t : list) {
            SignatureAlgorithm signatureAlgorithm = t.algorithm;
            int jcaSigAlgMinSdkVersion = z ? signatureAlgorithm.getJcaSigAlgMinSdkVersion() : signatureAlgorithm.getMinSdkVersion();
            if (jcaSigAlgMinSdkVersion <= i2) {
                if (jcaSigAlgMinSdkVersion < i3) {
                    i3 = jcaSigAlgMinSdkVersion;
                }
                ApkSupportedSignature apkSupportedSignature = (ApkSupportedSignature) map.get(Integer.valueOf(jcaSigAlgMinSdkVersion));
                if (apkSupportedSignature == null || compareSignatureAlgorithm(signatureAlgorithm, apkSupportedSignature.algorithm) > 0) {
                    map.put(Integer.valueOf(jcaSigAlgMinSdkVersion), t);
                }
            }
        }
        if (i >= i3) {
            if (map.isEmpty()) {
                throw new NoApkSupportedSignaturesException("No supported signature");
            }
            ArrayList arrayList = new ArrayList(map.values());
            Collections.sort(arrayList, new Comparator<T>() { // from class: com.android.apksig.internal.apk.ApkSigningBlockUtilsLite.1
                /* JADX WARN: Incorrect types in method signature: (TT;TT;)I */
                @Override // java.util.Comparator
                public int compare(ApkSupportedSignature apkSupportedSignature2, ApkSupportedSignature apkSupportedSignature3) {
                    return ApkSigningBlockUtilsLite$1$$ExternalSyntheticBackport0.m2037m(apkSupportedSignature2.algorithm.getId(), apkSupportedSignature3.algorithm.getId());
                }
            });
            return arrayList;
        }
        throw new NoApkSupportedSignaturesException("Minimum provided signature version " + i3 + " > minSdkVersion " + i);
    }

    public static byte[] readLengthPrefixedByteArray(ByteBuffer byteBuffer) throws ApkFormatException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new ApkFormatException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new ApkFormatException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
    }

    public static ByteBuffer sliceFromTo(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int iCapacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }

    public static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = (bArr[i] & 255) >>> 4;
            int i3 = bArr[i] & Token.LITERAL3;
            char[] cArr = HEX_DIGITS;
            sb.append(cArr[i2]);
            sb.append(cArr[i3]);
        }
        return sb.toString();
    }
}
