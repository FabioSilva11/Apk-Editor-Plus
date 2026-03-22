package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1018s {

    /* JADX INFO: renamed from: m */
    private static final CharsetDecoder f2881m = Charset.forName("UTF-16LE").newDecoder();

    /* JADX INFO: renamed from: n */
    private static final CharsetDecoder f2882n = Charset.forName("UTF-8").newDecoder();

    /* JADX INFO: renamed from: a */
    public int f2883a;

    /* JADX INFO: renamed from: b */
    int f2884b;

    /* JADX INFO: renamed from: c */
    int f2885c;

    /* JADX INFO: renamed from: d */
    String[] f2886d;

    /* JADX INFO: renamed from: f */
    private int f2888f;

    /* JADX INFO: renamed from: g */
    private int f2889g;

    /* JADX INFO: renamed from: h */
    private int f2890h;

    /* JADX INFO: renamed from: i */
    private boolean f2891i;

    /* JADX INFO: renamed from: j */
    private Object[] f2892j;

    /* JADX INFO: renamed from: e */
    private byte[] f2887e = new byte[28];

    /* JADX INFO: renamed from: k */
    private int[] f2893k = null;

    /* JADX INFO: renamed from: l */
    private int[] f2894l = null;

    /* JADX INFO: renamed from: o */
    private List f2895o = new ArrayList();

    /* JADX INFO: renamed from: a */
    private String m2705a(byte[] bArr, int i, int i2) {
        try {
            return (this.f2891i ? f2882n : f2881m).decode(ByteBuffer.wrap(bArr, i, i2)).toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m2706a(int i) {
        return i > 16383 ? new byte[]{(byte) ((i & 127) | 128), (byte) (((i >> 7) & 127) | 128), (byte) (i >> 14)} : i >= 128 ? new byte[]{(byte) ((i & 127) | 128), (byte) (i >> 7)} : new byte[]{(byte) i};
    }

    /* JADX INFO: renamed from: b */
    private static byte[] m2707b(String str) {
        byte[] bArr;
        UnsupportedEncodingException e;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = str.length();
            int length2 = bytes.length;
            byte[] bArrM2706a = m2706a(length);
            byte[] bArrM2706a2 = m2706a(length2);
            bArr = new byte[bArrM2706a.length + bArrM2706a2.length + bytes.length + 1];
            try {
                System.arraycopy(bArrM2706a, 0, bArr, 0, bArrM2706a.length);
                System.arraycopy(bArrM2706a2, 0, bArr, bArrM2706a.length, bArrM2706a2.length);
                System.arraycopy(bytes, 0, bArr, bArrM2706a2.length + bArrM2706a.length, bytes.length);
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e3) {
            bArr = null;
            e = e3;
        }
        return bArr;
    }

    /* JADX INFO: renamed from: c */
    private static byte[] m2708c(String str) {
        byte[] bArr;
        UnsupportedEncodingException e;
        byte[] bytes;
        int i;
        int i2 = 0;
        try {
            bytes = str.getBytes("UTF-16LE");
            int length = bytes.length;
            if (bytes.length >= 2 && (bytes[0] & 255) == 255 && (bytes[1] & 255) == 254) {
                i2 = 2;
                i = length - 2;
            } else {
                i = length;
            }
            bArr = new byte[i];
        } catch (UnsupportedEncodingException e2) {
            bArr = null;
            e = e2;
        }
        try {
            System.arraycopy(bytes, i2, bArr, 0, i);
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            e.printStackTrace();
        }
        return bArr;
    }

    /* JADX INFO: renamed from: d */
    private byte[] m2709d(String str) {
        return this.f2891i ? m2707b(str) : m2708c(str);
    }

    /* JADX INFO: renamed from: a */
    public final int m2710a(String str) {
        for (int i = 0; i < this.f2886d.length; i++) {
            if (this.f2886d[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public final List m2711a() {
        return this.f2895o;
    }

    /* JADX INFO: renamed from: a */
    public final void m2712a(int i, String str) {
        byte[] bArrM2709d = m2709d(str);
        this.f2886d[i] = str;
        this.f2892j[i] = bArrM2709d;
    }

    /* JADX INFO: renamed from: a */
    public final void m2713a(C1011l c1011l) throws IOException {
        byte[] bArr;
        int[] iArr = new int[this.f2884b];
        int i = 0;
        for (int i2 = 0; i2 < this.f2884b; i2++) {
            iArr[i2] = i;
            int length = ((byte[]) this.f2892j[i2]).length;
            i = this.f2891i ? i + length : i + (length / 2 <= 32767 ? 2 : 4) + length + 2;
        }
        this.f2883a = (this.f2894l != null ? this.f2894l.length : 0) + (this.f2888f > 0 ? this.f2888f << 2 : 0) + (this.f2884b << 2) + 28 + i;
        int i3 = (4 - (this.f2883a % 4)) % 4;
        this.f2883a += i3;
        C1004e.m2673a(this.f2887e, 4, this.f2883a);
        if (this.f2889g > 0) {
            this.f2889g = this.f2883a - this.f2894l.length;
            C1004e.m2673a(this.f2887e, 24, this.f2889g);
        }
        c1011l.m2682a(this.f2887e);
        c1011l.m2684a(iArr);
        if (this.f2888f > 0) {
            c1011l.m2684a(this.f2893k);
        }
        for (int i4 = 0; i4 < this.f2884b; i4++) {
            byte[] bArr2 = (byte[]) this.f2892j[i4];
            if (this.f2891i) {
                c1011l.m2683a(bArr2, 0, bArr2.length);
            } else {
                int length2 = bArr2.length / 2;
                if (length2 > 32767) {
                    bArr = new byte[4];
                    C1004e.m2675b(bArr, 0, (length2 >> 15) & 32767);
                    C1004e.m2675b(bArr, 2, length2 & 32767);
                } else {
                    bArr = new byte[2];
                    C1004e.m2675b(bArr, 0, length2);
                }
                c1011l.m2682a(bArr);
                c1011l.m2683a(bArr2, 0, bArr2.length);
                c1011l.m2686b(0);
            }
        }
        if (i3 > 0) {
            switch (i3) {
                case 1:
                    c1011l.m2682a(new byte[]{0});
                    break;
                case 2:
                    c1011l.m2686b(0);
                    break;
                case 3:
                    c1011l.m2682a(new byte[]{0, 0, 0});
                    break;
            }
        }
        if (this.f2894l != null) {
            c1011l.m2684a(this.f2894l);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2714a(C1012m c1012m) {
        int i;
        int i2;
        c1012m.m2688a(this.f2887e);
        this.f2883a = C1004e.m2667a(this.f2887e, 4);
        this.f2884b = C1004e.m2667a(this.f2887e, 8);
        this.f2888f = C1004e.m2667a(this.f2887e, 12);
        this.f2890h = C1004e.m2667a(this.f2887e, 16);
        this.f2885c = C1004e.m2667a(this.f2887e, 20);
        this.f2889g = C1004e.m2667a(this.f2887e, 24);
        this.f2891i = (this.f2890h & 256) != 0;
        int[] iArr = new int[this.f2884b];
        this.f2886d = new String[this.f2884b];
        c1012m.m2690a(iArr);
        if (this.f2888f != 0) {
            this.f2893k = new int[this.f2888f];
            c1012m.m2690a(this.f2893k);
        }
        int i3 = this.f2885c - (((this.f2884b * 4) + 28) + (this.f2888f * 4));
        new Object[1][0] = Integer.valueOf(i3);
        if (i3 > 0 && i3 > 0) {
            c1012m.f2857b.skip(i3);
            c1012m.f2856a = i3 + c1012m.f2856a;
        }
        byte[] bArr = new byte[(this.f2889g == 0 ? this.f2883a : this.f2889g) - this.f2885c];
        c1012m.m2688a(bArr);
        if (this.f2889g > 0) {
            int i4 = this.f2883a - this.f2889g;
            this.f2894l = new int[i4 / 4];
            c1012m.m2690a(this.f2894l);
            int i5 = i4 % 4;
            if (i5 > 0) {
                while (true) {
                    int i6 = i5 - 1;
                    if (i5 <= 0) {
                        break;
                    }
                    c1012m.f2857b.read();
                    c1012m.f2856a++;
                    i5 = i6;
                }
            }
        }
        this.f2892j = new Object[iArr.length];
        Object[] objArr = this.f2892j;
        String[] strArr = this.f2886d;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            int i8 = iArr[i7];
            if (this.f2891i) {
                int i9 = (bArr[i8] & 128) != 0 ? i8 + 2 : i8 + 1;
                int i10 = (bArr[i9] & 128) != 0 ? i9 + 2 : i9 + 1;
                int i11 = 0;
                while (bArr[i10 + i11] != 0) {
                    i11++;
                }
                int[] iArr2 = {i10, i11};
                int i12 = iArr2[0] - i8;
                i = iArr2[0];
                i2 = iArr2[1];
                objArr[i7] = new byte[i2 + i12 + 1];
                System.arraycopy(bArr, i - i12, objArr[i7], 0, i12 + i2);
            } else {
                int i13 = (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8);
                int[] iArr3 = i13 == 32768 ? new int[]{4, (((bArr[i8 + 3] & 255) << 8) + (bArr[i8 + 2] & 255)) << 1} : new int[]{2, i13 << 1};
                i = iArr3[0] + i8;
                i2 = iArr3[1];
                objArr[i7] = new byte[i2];
                System.arraycopy(bArr, i, objArr[i7], 0, i2);
            }
            strArr[i7] = m2705a(bArr, i, i2);
            Object[] objArr2 = {Integer.valueOf(i7), strArr[i7]};
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2715a(String str, int i) {
        new StringBuilder("StringChunk.addString: ").append(str).append(", ").append(i);
        this.f2883a = ((str.length() + 2) << 1) + 4 + this.f2883a;
        this.f2884b++;
        this.f2885c += 4;
        C1004e.m2673a(this.f2887e, 4, this.f2883a);
        C1004e.m2673a(this.f2887e, 8, this.f2884b);
        C1004e.m2673a(this.f2887e, 20, this.f2885c);
        String[] strArr = new String[this.f2884b];
        Object[] objArr = new Object[this.f2884b];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f2884b; i3++) {
            if (i3 != i) {
                strArr[i3] = this.f2886d[i2];
                objArr[i3] = this.f2892j[i2];
                i2++;
            } else {
                strArr[i3] = str;
                objArr[i3] = m2709d(str);
            }
        }
        this.f2886d = strArr;
        this.f2892j = objArr;
        this.f2895o.add(0, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: b */
    public final String m2716b(int i) {
        if (i < 0 || i >= this.f2886d.length) {
            return null;
        }
        return this.f2886d[i];
    }

    /* JADX INFO: renamed from: b */
    public final int[] m2717b() {
        int i = 0;
        int length = this.f2886d.length - this.f2895o.size();
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f2895o.contains(Integer.valueOf(i2))) {
                i++;
            }
            iArr[i2] = i2 + i;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: c */
    public final int m2718c() {
        return this.f2886d.length;
    }
}
