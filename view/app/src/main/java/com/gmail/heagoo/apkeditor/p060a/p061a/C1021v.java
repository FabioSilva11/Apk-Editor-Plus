package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.v */
/* JADX INFO: loaded from: classes.dex */
public final class C1021v {

    /* JADX INFO: renamed from: a */
    private static final CharsetDecoder f2908a = Charset.forName("UTF-16LE").newDecoder();

    /* JADX INFO: renamed from: b */
    private static final CharsetDecoder f2909b = Charset.forName("UTF-8").newDecoder();

    /* JADX INFO: renamed from: c */
    private C1020u f2910c;

    /* JADX INFO: renamed from: d */
    private byte[] f2911d;

    /* JADX INFO: renamed from: e */
    private int f2912e;

    /* JADX INFO: renamed from: f */
    private int f2913f;

    /* JADX INFO: renamed from: g */
    private int f2914g;

    /* JADX INFO: renamed from: h */
    private int f2915h;

    /* JADX INFO: renamed from: i */
    private int f2916i;

    /* JADX INFO: renamed from: j */
    private int f2917j;

    /* JADX INFO: renamed from: k */
    private boolean f2918k;

    /* JADX INFO: renamed from: l */
    private int[] f2919l;

    /* JADX INFO: renamed from: m */
    private int[] f2920m;

    /* JADX INFO: renamed from: n */
    private int f2921n = 0;

    public C1021v(C1020u c1020u, byte[] bArr) {
        this.f2910c = c1020u;
        this.f2911d = bArr;
        this.f2912e = c1020u.f2906a;
        this.f2913f = m2726a(bArr, 0);
        this.f2914g = m2726a(bArr, 4);
        this.f2915h = m2726a(bArr, 8);
        this.f2916i = m2726a(bArr, 12);
        this.f2917j = m2726a(bArr, 16);
        this.f2918k = (this.f2915h & 256) != 0;
        this.f2919l = new int[this.f2913f];
        int i = 20;
        for (int i2 = 0; i2 < this.f2913f; i2++) {
            this.f2919l[i2] = m2726a(bArr, i);
            i += 4;
        }
        if (this.f2914g != 0) {
            this.f2920m = new int[this.f2914g];
            for (int i3 = 0; i3 < this.f2914g; i3++) {
                this.f2920m[i3] = m2726a(bArr, i);
                i += 4;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m2726a(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* JADX INFO: renamed from: a */
    private String m2727a(int i, int i2) {
        try {
            return (this.f2918k ? f2909b : f2908a).decode(ByteBuffer.wrap(this.f2911d, i, i2)).toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2728a(int i, int i2, int i3, byte[] bArr) {
        int i4;
        this.f2912e += bArr.length - i3;
        if (this.f2912e % 4 != 0) {
            i4 = 4 - (this.f2912e % 4);
            this.f2912e += i4;
        } else {
            i4 = 0;
        }
        int length = bArr.length - i3;
        this.f2910c.m2723a(this.f2912e);
        if (this.f2917j > 0 && this.f2914g > 0) {
            this.f2917j += length + i4;
            m2729a(this.f2911d, 16, this.f2917j);
        }
        int i5 = ((i + 1) << 2) + 20;
        for (int i6 = i + 1; i6 < this.f2913f; i6++) {
            int[] iArr = this.f2919l;
            iArr[i6] = iArr[i6] + length;
            m2729a(this.f2911d, i5, this.f2919l[i6]);
            i5 += 4;
        }
        byte[] bArr2 = new byte[this.f2911d.length + length + i4];
        System.arraycopy(this.f2911d, 0, bArr2, 0, i2);
        System.arraycopy(bArr, 0, bArr2, i2, bArr.length);
        if (this.f2917j > 0) {
            int i7 = ((this.f2917j - length) - i4) - 8;
            System.arraycopy(this.f2911d, i2 + i3, bArr2, bArr.length + i2, (i7 - i2) - i3);
            System.arraycopy(this.f2911d, i7, bArr2, i7 + length + i4, this.f2911d.length - i7);
        } else {
            System.arraycopy(this.f2911d, i2 + i3, bArr2, bArr.length + i2, (this.f2911d.length - i2) - i3);
        }
        this.f2911d = bArr2;
        this.f2921n = i4 + length + this.f2921n;
    }

    /* JADX INFO: renamed from: a */
    private static void m2729a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >>> 24);
    }

    /* JADX INFO: renamed from: a */
    private byte[] m2730a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-16LE");
            while (bytes.length > 32767) {
                str = str.substring(0, str.length() - 1);
                bytes = str.getBytes("UTF-16LE");
            }
            int length = str.length();
            byte[] bArr = new byte[bytes.length + 4];
            bArr[0] = (byte) length;
            bArr[1] = (byte) (length >> 8);
            System.arraycopy(bytes, 0, bArr, 2, bytes.length);
            bArr[bytes.length + 2] = 0;
            bArr[bytes.length + 3] = 0;
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static byte[] m2731b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            while (bytes.length >= 128) {
                str = str.substring(0, str.length() - 1);
                bytes = str.getBytes("UTF-8");
            }
            int length = str.length();
            int length2 = bytes.length;
            byte[] bArr = new byte[length2 + 3];
            bArr[0] = (byte) length;
            bArr[1] = (byte) length2;
            System.arraycopy(bytes, 0, bArr, 2, length2);
            bArr[length2 + 2] = 0;
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m2732a() {
        return this.f2921n;
    }

    /* JADX INFO: renamed from: a */
    public final void m2733a(OutputStream outputStream) throws IOException {
        this.f2910c.m2725a(outputStream);
        outputStream.write(this.f2911d);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m2734a(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            r6 = 1
            r1 = 0
            r0 = r1
            r2 = r1
        L4:
            int r3 = r10.f2913f
            if (r0 >= r3) goto L92
            if (r0 < 0) goto L90
            int[] r3 = r10.f2919l
            r3 = r3[r0]
            boolean r4 = r10.f2918k
            if (r4 == 0) goto L50
            int r4 = r10.f2916i
            int r3 = r3 + r4
            int r3 = r3 + (-8)
            byte[] r4 = r10.f2911d
            int[] r7 = p000a.p001a.p003b.p006b.C0056n.m149a(r4, r3)
            r4 = r7[r1]
            int r5 = r4 - r3
            r3 = r7[r6]
        L23:
            java.lang.String r8 = r10.m2727a(r4, r3)
            if (r8 == 0) goto L90
            r7 = 0
            boolean r9 = r8.equals(r11)
            if (r9 == 0) goto L67
            if (r12 == 0) goto L67
            r7 = r12
        L33:
            if (r7 == 0) goto L90
            int r8 = r5 + r3
            boolean r3 = r10.f2918k
            if (r3 == 0) goto L89
            r3 = r6
        L3c:
            int r8 = r8 + r3
            boolean r3 = r10.f2918k
            if (r3 == 0) goto L8b
            byte[] r3 = m2731b(r7)
        L45:
            int r4 = r4 - r5
            r10.m2728a(r0, r4, r8, r3)
            r3 = r6
        L4a:
            if (r3 == 0) goto L4d
            r2 = r6
        L4d:
            int r0 = r0 + 1
            goto L4
        L50:
            byte[] r4 = r10.f2911d
            int r5 = r10.f2916i
            int r5 = r5 + r3
            int r5 = r5 + (-8)
            int[] r7 = p000a.p001a.p003b.p006b.C0056n.m150b(r4, r5)
            r5 = r7[r1]
            int r4 = r10.f2916i
            int r3 = r3 + r4
            int r3 = r3 + (-8)
            int r4 = r3 + r5
            r3 = r7[r6]
            goto L23
        L67:
            boolean r9 = r8.startsWith(r13)
            if (r9 == 0) goto L33
            if (r14 == 0) goto L33
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r7 = r7.append(r14)
            int r9 = r13.length()
            java.lang.String r8 = r8.substring(r9)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L33
        L89:
            r3 = 2
            goto L3c
        L8b:
            byte[] r3 = r10.m2730a(r7)
            goto L45
        L90:
            r3 = r1
            goto L4a
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p060a.p061a.C1021v.m2734a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
