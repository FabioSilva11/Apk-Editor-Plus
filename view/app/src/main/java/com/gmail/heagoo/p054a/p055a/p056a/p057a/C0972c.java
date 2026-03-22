package com.gmail.heagoo.p054a.p055a.p056a.p057a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.a.a.a.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0972c {

    /* JADX INFO: renamed from: a */
    private InputStream f2452a;

    /* JADX INFO: renamed from: b */
    private boolean f2453b;

    /* JADX INFO: renamed from: c */
    private int f2454c;

    public C0972c() {
    }

    public C0972c(InputStream inputStream, boolean z) {
        m2141a(inputStream, false);
    }

    /* JADX INFO: renamed from: a */
    private void m2141a(InputStream inputStream, boolean z) {
        this.f2452a = inputStream;
        this.f2453b = z;
        this.f2454c = 0;
    }

    /* JADX INFO: renamed from: b */
    private int m2142b(int i) throws IOException {
        int i2 = 0;
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException();
        }
        if (this.f2453b) {
            int i3 = (i - 1) << 3;
            while (i3 >= 0) {
                int i4 = this.f2452a.read();
                if (i4 == -1) {
                    throw new EOFException();
                }
                this.f2454c++;
                int i5 = (i4 << i3) | i2;
                i3 -= 8;
                i2 = i5;
            }
        } else {
            int i6 = i << 3;
            int i7 = 0;
            while (i7 != i6) {
                int i8 = this.f2452a.read();
                if (i8 == -1) {
                    throw new EOFException();
                }
                this.f2454c++;
                int i9 = (i8 << i7) | i2;
                i7 += 8;
                i2 = i9;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m2143a() {
        if (this.f2452a == null) {
            return;
        }
        try {
            this.f2452a.close();
        } catch (IOException e) {
        }
        m2141a(null, false);
    }

    /* JADX INFO: renamed from: a */
    public final void m2144a(byte[] bArr) throws IOException {
        int i = 0;
        int length = bArr.length;
        while (i < length) {
            int i2 = this.f2452a.read(bArr, i + 0, length - i);
            if (i2 == -1) {
                return;
            }
            if (i2 > 0) {
                this.f2454c += i2;
                i += i2;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final int[] m2145a(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = m2142b(4);
            i--;
            i2++;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: b */
    public final int m2146b() {
        return m2142b(1);
    }

    /* JADX INFO: renamed from: c */
    public final int m2147c() {
        return m2142b(4);
    }

    /* JADX INFO: renamed from: d */
    public final void m2148d() throws IOException {
        long jSkip = this.f2452a.skip(4L);
        this.f2454c = (int) (((long) this.f2454c) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }
}
