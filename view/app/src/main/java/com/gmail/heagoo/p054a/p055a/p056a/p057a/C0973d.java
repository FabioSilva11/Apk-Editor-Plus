package com.gmail.heagoo.p054a.p055a.p056a.p057a;

import android.util.SparseArray;
import com.gmail.heagoo.neweditor.Token;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: renamed from: com.gmail.heagoo.a.a.a.a.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0973d {

    /* JADX INFO: renamed from: b */
    private int[] f2456b;

    /* JADX INFO: renamed from: c */
    private byte[] f2457c;

    /* JADX INFO: renamed from: d */
    private boolean f2458d;

    /* JADX INFO: renamed from: e */
    private int[] f2459e;

    /* JADX INFO: renamed from: a */
    private SparseArray f2455a = new SparseArray();

    /* JADX INFO: renamed from: f */
    private final CharsetDecoder f2460f = Charset.forName("UTF-16LE").newDecoder();

    /* JADX INFO: renamed from: g */
    private final CharsetDecoder f2461g = Charset.forName("UTF-8").newDecoder();

    private C0973d() {
    }

    /* JADX INFO: renamed from: a */
    private static final int m2149a(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* JADX INFO: renamed from: a */
    public static C0973d m2150a(C0972c c0972c) throws IOException {
        m2152a(c0972c, 1835009, 0);
        int iM2147c = c0972c.m2147c();
        int iM2147c2 = c0972c.m2147c();
        int iM2147c3 = c0972c.m2147c();
        int iM2147c4 = c0972c.m2147c();
        int iM2147c5 = c0972c.m2147c();
        int iM2147c6 = c0972c.m2147c();
        C0973d c0973d = new C0973d();
        c0973d.f2458d = (iM2147c4 & 256) != 0;
        c0973d.f2456b = c0972c.m2145a(iM2147c2);
        c0973d.f2459e = new int[iM2147c2];
        for (int i = 0; i < iM2147c2; i++) {
            c0973d.f2459e[i] = -1;
        }
        if (iM2147c3 != 0) {
            c0972c.m2145a(iM2147c3);
        }
        c0973d.f2457c = new byte[(iM2147c6 == 0 ? iM2147c : iM2147c6) - iM2147c5];
        c0972c.m2144a(c0973d.f2457c);
        if (iM2147c6 != 0) {
            int i2 = iM2147c - iM2147c6;
            c0972c.m2145a(i2 / 4);
            int i3 = i2 % 4;
            if (i3 > 0) {
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 <= 0) {
                        break;
                    }
                    c0972c.m2146b();
                    i3 = i4;
                }
            }
        }
        return c0973d;
    }

    /* JADX INFO: renamed from: a */
    private String m2151a(int i, int i2) {
        try {
            return (this.f2458d ? this.f2461g : this.f2460f).decode(ByteBuffer.wrap(this.f2457c, i, i2)).toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2152a(C0972c c0972c, int i, int i2) throws IOException {
        int iM2147c = c0972c.m2147c();
        if (iM2147c == i2 || iM2147c < i) {
            m2152a(c0972c, i, -1);
        } else if (iM2147c != i) {
            throw new IOException(String.format("Expected: 0x%08x, actual: 0x%08x", Integer.valueOf(i), Integer.valueOf(iM2147c)));
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m2153a(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i != this.f2456b.length; i++) {
            int i2 = this.f2456b[i];
            int iM2149a = m2149a(this.f2457c, i2);
            if (iM2149a == str.length()) {
                int i3 = i2;
                int i4 = 0;
                while (i4 != iM2149a) {
                    i3 += 2;
                    if (str.charAt(i4) != m2149a(this.f2457c, i3)) {
                        break;
                    }
                    i4++;
                }
                if (i4 == iM2149a) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public final String m2154a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String str = (String) this.f2455a.get(i);
        if (str != null) {
            return str;
        }
        if (i < 0 || this.f2456b == null || i >= this.f2456b.length) {
            return null;
        }
        int i6 = this.f2456b[i];
        if (this.f2458d) {
            byte[] bArr = this.f2457c;
            int i7 = (bArr[i6] & 128) != 0 ? i6 + 2 : i6 + 1;
            byte b2 = bArr[i7];
            int i8 = i7 + 1;
            if ((b2 & 128) != 0) {
                i4 = (bArr[i8] & 255) + ((b2 & Token.END) << 8);
                i5 = i8 + 1;
            } else {
                i4 = b2;
                i5 = i8;
            }
            int[] iArr = {i5, i4};
            i2 = iArr[0];
            i3 = iArr[1];
        } else {
            byte[] bArr2 = this.f2457c;
            int i9 = ((bArr2[i6 + 1] & 255) << 8) | (bArr2[i6] & 255);
            int[] iArr2 = (32768 & i9) != 0 ? new int[]{4, (((i9 & 32767) << 16) + ((bArr2[i6 + 2] & 255) + ((bArr2[i6 + 3] & 255) << 8))) << 1} : new int[]{2, i9 << 1};
            i2 = i6 + iArr2[0];
            i3 = iArr2[1];
        }
        return m2151a(i2, i3);
    }
}
