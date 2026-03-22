package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1012m {

    /* JADX INFO: renamed from: a */
    int f2856a = 0;

    /* JADX INFO: renamed from: b */
    InputStream f2857b;

    public C1012m(InputStream inputStream) {
        this.f2857b = inputStream;
    }

    /* JADX INFO: renamed from: a */
    public final int m2687a() throws IOException {
        byte[] bArr = new byte[4];
        this.f2857b.read(bArr);
        this.f2856a += 4;
        return C1004e.m2667a(bArr, 0);
    }

    /* JADX INFO: renamed from: a */
    public final void m2688a(byte[] bArr) {
        int i;
        int i2 = 0;
        while (i2 < bArr.length && (i = this.f2857b.read(bArr, i2, bArr.length - i2)) != -1) {
            if (i > 0) {
                this.f2856a += i;
                i2 += i;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2689a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = this.f2857b.read(bArr, i3 + 8, i2 - i3);
            if (i4 == -1) {
                return;
            }
            if (i4 > 0) {
                this.f2856a += i4;
                i3 += i4;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2690a(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = m2687a();
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m2691b(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f2857b.read(bArr, 0, 4096);
        if (i3 > 0) {
            this.f2856a += i3;
        }
        return i3;
    }
}
