package org.p088jf.util;

/* JADX INFO: loaded from: classes.dex */
public final class Utf8Utils {
    public static final ThreadLocal<char[]> localBuffer = new ThreadLocal<char[]>() { // from class: org.jf.util.Utf8Utils.1
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[256];
        }
    };

    public static String throwBadUtf8(int i, int i2) {
        throw new IllegalArgumentException("bad utf-8 byte " + Hex.m3938u1(i) + " at offset " + Hex.m3939u4(i2));
    }

    public static String utf8BytesWithUtf16LengthToString(byte[] bArr, int i, int i2, int[] iArr) {
        char c;
        int i3;
        ThreadLocal<char[]> threadLocal = localBuffer;
        char[] cArr = threadLocal.get();
        if (cArr == null || cArr.length < i2) {
            cArr = new char[i2];
            threadLocal.set(cArr);
        }
        int i4 = i;
        int i5 = 0;
        while (i2 > 0) {
            int i6 = bArr[i4] & 255;
            switch (i6 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (i6 == 0) {
                        return throwBadUtf8(i6, i4);
                    }
                    c = (char) i6;
                    i4++;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return throwBadUtf8(i6, i4);
                case 12:
                case 13:
                    int i7 = i4 + 1;
                    int i8 = bArr[i7] & 255;
                    if ((i8 & 192) != 128) {
                        return throwBadUtf8(i8, i7);
                    }
                    int i9 = ((i6 & 31) << 6) | (i8 & 63);
                    if (i9 != 0 && i9 < 128) {
                        return throwBadUtf8(i8, i7);
                    }
                    c = (char) i9;
                    i4 += 2;
                    break;
                    break;
                case 14:
                    int i10 = i4 + 1;
                    int i11 = bArr[i10] & 255;
                    if ((i11 & 192) != 128) {
                        return throwBadUtf8(i11, i10);
                    }
                    int i12 = i4 + 2;
                    int i13 = bArr[i12] & 255;
                    if ((i13 & 192) == 128 && (i3 = ((i6 & 15) << 12) | ((i11 & 63) << 6) | (i13 & 63)) >= 2048) {
                        c = (char) i3;
                        i4 += 3;
                        break;
                    }
                    return throwBadUtf8(i13, i12);
            }
            cArr[i5] = c;
            i5++;
            i2--;
        }
        if (iArr != null && iArr.length > 0) {
            int i14 = i4 - i;
            iArr[0] = i14;
            iArr[0] = i14;
        }
        return new String(cArr, 0, i5);
    }
}
