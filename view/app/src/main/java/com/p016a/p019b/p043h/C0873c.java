package com.p016a.p019b.p043h;

/* JADX INFO: renamed from: com.a.b.h.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0873c {

    /* JADX INFO: renamed from: a */
    private final byte[] f2229a;

    /* JADX INFO: renamed from: b */
    private final int f2230b;

    /* JADX INFO: renamed from: c */
    private final int f2231c;

    public C0873c(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private C0873c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start");
        }
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("end > bytes.length");
        }
        this.f2229a = bArr;
        this.f2230b = i;
        this.f2231c = i2 - i;
    }

    /* JADX INFO: renamed from: b */
    private void m1952b(int i, int i2) {
        if (i < 0 || i2 < i || i2 > this.f2231c) {
            throw new IllegalArgumentException("bad range: " + i + ".." + i2 + "; actual size " + this.f2231c);
        }
    }

    /* JADX INFO: renamed from: g */
    private int m1955g(int i) {
        return this.f2229a[this.f2230b + i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public int m1956h(int i) {
        return this.f2229a[this.f2230b + i] & 255;
    }

    /* JADX INFO: renamed from: a */
    public final int m1957a() {
        return this.f2231c;
    }

    /* JADX INFO: renamed from: a */
    public final int m1958a(int i) {
        m1952b(i, i + 1);
        return m1955g(i);
    }

    /* JADX INFO: renamed from: a */
    public final C0873c m1959a(int i, int i2) {
        m1952b(i, i2);
        return new C0873c(this.f2229a, this.f2230b + i, this.f2230b + i2);
    }

    /* JADX INFO: renamed from: a */
    public final void m1960a(byte[] bArr, int i) {
        if (bArr.length - i < this.f2231c) {
            throw new IndexOutOfBoundsException("(out.length - offset) < size()");
        }
        System.arraycopy(this.f2229a, this.f2230b, bArr, i, this.f2231c);
    }

    /* JADX INFO: renamed from: b */
    public final int m1961b(int i) {
        m1952b(i, i + 2);
        return (m1955g(i) << 8) | m1956h(i + 1);
    }

    /* JADX INFO: renamed from: b */
    public final C0874d m1962b() {
        return new C0874d(new C0875e(this));
    }

    /* JADX INFO: renamed from: c */
    public final int m1963c(int i) {
        m1952b(i, i + 4);
        return (m1955g(i) << 24) | (m1956h(i + 1) << 16) | (m1956h(i + 2) << 8) | m1956h(i + 3);
    }

    /* JADX INFO: renamed from: d */
    public final long m1964d(int i) {
        m1952b(i, i + 8);
        return (((long) ((((m1955g(i) << 24) | (m1956h(i + 1) << 16)) | (m1956h(i + 2) << 8)) | m1956h(i + 3))) << 32) | (((long) ((m1955g(i + 4) << 24) | (m1956h(i + 5) << 16) | (m1956h(i + 6) << 8) | m1956h(i + 7))) & 4294967295L);
    }

    /* JADX INFO: renamed from: e */
    public final int m1965e(int i) {
        m1952b(i, i + 1);
        return m1956h(i);
    }

    /* JADX INFO: renamed from: f */
    public final int m1966f(int i) {
        m1952b(i, i + 2);
        return (m1956h(i) << 8) | m1956h(i + 1);
    }
}
