package com.gmail.heagoo.apkeditor.p063b;

import p000a.p001a.p003b.p004a.p005a.C0027x;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.b.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1072j {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal f3060a = new C1073k();

    /* JADX INFO: renamed from: a */
    private static String m2806a(int i, int i2) {
        throw new IllegalArgumentException("bad utf-8 byte " + C0027x.m32b(i) + " at offset " + C0027x.m26a(i2));
    }

    /* JADX INFO: renamed from: a */
    public static String m2807a(byte[] bArr, int i, int i2, int[] iArr) {
        int i3;
        char c;
        char[] cArr = (char[]) f3060a.get();
        if (cArr == null || cArr.length < i2) {
            cArr = new char[i2];
            f3060a.set(cArr);
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
                        return m2806a(i6, i4);
                    }
                    c = (char) i6;
                    i4++;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return m2806a(i6, i4);
                case 12:
                case 13:
                    int i7 = bArr[i4 + 1] & 255;
                    if ((i7 & 192) != 128) {
                        return m2806a(i7, i4 + 1);
                    }
                    int i8 = ((i6 & 31) << 6) | (i7 & 63);
                    if (i8 != 0 && i8 < 128) {
                        return m2806a(i7, i4 + 1);
                    }
                    c = (char) i8;
                    i4 += 2;
                    break;
                    break;
                case 14:
                    int i9 = bArr[i4 + 1] & 255;
                    if ((i9 & 192) != 128) {
                        return m2806a(i9, i4 + 1);
                    }
                    int i10 = bArr[i4 + 2] & 255;
                    if ((i10 & 192) == 128 && (i3 = ((i6 & 15) << 12) | ((i9 & 63) << 6) | (i10 & 63)) >= 2048) {
                        c = (char) i3;
                        i4 += 3;
                        break;
                    }
                    return m2806a(i10, i4 + 2);
            }
            cArr[i5] = c;
            i2--;
            i5++;
        }
        iArr[0] = i4 - i;
        iArr[0] = i4 - i;
        return new String(cArr, 0, i5);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m2808a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length * 3];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != 0 && cCharAt < 128) {
                bArr[i] = (byte) cCharAt;
                i++;
            } else if (cCharAt < 2048) {
                bArr[i] = (byte) (((cCharAt >> 6) & 31) | 192);
                bArr[i + 1] = (byte) ((cCharAt & '?') | 128);
                i += 2;
            } else {
                bArr[i] = (byte) (((cCharAt >> '\f') & 15) | 224);
                bArr[i + 1] = (byte) (((cCharAt >> 6) & 63) | 128);
                bArr[i + 2] = (byte) ((cCharAt & '?') | 128);
                i += 3;
            }
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }
}
