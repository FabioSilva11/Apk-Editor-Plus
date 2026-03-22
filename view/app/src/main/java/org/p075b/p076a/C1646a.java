package org.p075b.p076a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: org.b.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1646a {

    /* JADX INFO: renamed from: a */
    private byte[] f4711a;

    /* JADX INFO: renamed from: b */
    private final int[] f4712b;

    /* JADX INFO: renamed from: c */
    private final String[] f4713c;

    /* JADX INFO: renamed from: d */
    private final int f4714d;

    /* JADX INFO: renamed from: e */
    private int f4715e;

    public C1646a(InputStream inputStream) {
        this(m3794a(inputStream));
    }

    private C1646a(byte[] bArr) {
        this(bArr, 0);
    }

    private C1646a(byte[] bArr, int i) {
        int iM3793a;
        this.f4711a = bArr;
        this.f4712b = new int[m3793a(8)];
        int length = this.f4712b.length;
        this.f4713c = new String[length];
        int i2 = 0;
        int i3 = 1;
        int i4 = 10;
        while (i3 < length) {
            this.f4712b[i3] = i4 + 1;
            switch (bArr[i4]) {
                case 1:
                    iM3793a = m3793a(i4 + 1) + 3;
                    if (iM3793a > i2) {
                        i2 = iM3793a;
                    }
                    break;
                case 2:
                case 7:
                case 8:
                default:
                    iM3793a = 3;
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    iM3793a = 5;
                    break;
                case 5:
                case 6:
                    iM3793a = 9;
                    i3++;
                    break;
            }
            i3++;
            i4 = iM3793a + i4;
        }
        this.f4714d = i2;
        this.f4715e = i4;
    }

    /* JADX INFO: renamed from: a */
    private int m3793a(int i) {
        byte[] bArr = this.f4711a;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m3794a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("Class not found");
        }
        byte[] bArr = new byte[inputStream.available()];
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                if (i >= bArr.length) {
                    return bArr;
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                return bArr2;
            }
            int i3 = i2 + i;
            if (i3 == bArr.length) {
                int i4 = inputStream.read();
                if (i4 < 0) {
                    return bArr;
                }
                byte[] bArr3 = new byte[bArr.length + 1000];
                System.arraycopy(bArr, 0, bArr3, 0, i3);
                i = i3 + 1;
                bArr3[i3] = (byte) i4;
                bArr = bArr3;
            } else {
                i = i3;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m3795a() {
        int i = this.f4715e + 2;
        char[] cArr = new char[this.f4714d];
        int iM3793a = m3793a(this.f4712b[m3793a(i)]);
        String str = this.f4713c[iM3793a];
        if (str != null) {
            return str;
        }
        int i2 = this.f4712b[iM3793a];
        String[] strArr = this.f4713c;
        int i3 = i2 + 2;
        int iM3793a2 = i3 + m3793a(i2);
        byte[] bArr = this.f4711a;
        char c = 0;
        int i4 = 0;
        int i5 = i3;
        char c2 = 0;
        while (i5 < iM3793a2) {
            int i6 = i5 + 1;
            byte b2 = bArr[i5];
            switch (c) {
                case 0:
                    int i7 = b2 & 255;
                    if (i7 < 128) {
                        cArr[i4] = (char) i7;
                        i4++;
                        i5 = i6;
                    } else if (i7 >= 224 || i7 <= 191) {
                        c2 = (char) (i7 & 15);
                        c = 2;
                        i5 = i6;
                        continue;
                    } else {
                        c2 = (char) (i7 & 31);
                        c = 1;
                        i5 = i6;
                    }
                    break;
                case 1:
                    cArr[i4] = (char) ((b2 & 63) | (c2 << 6));
                    i4++;
                    i5 = i6;
                    c = 0;
                    continue;
                case 2:
                    c2 = (char) ((c2 << 6) | (b2 & 63));
                    c = 1;
                    break;
            }
            i5 = i6;
        }
        String str2 = new String(cArr, 0, i4);
        strArr[iM3793a] = str2;
        return str2;
    }
}
