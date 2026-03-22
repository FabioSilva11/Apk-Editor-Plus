package com.p016a.p019b.p043h;

import java.io.InputStream;

/* JADX INFO: renamed from: com.a.b.h.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0875e extends InputStream {

    /* JADX INFO: renamed from: a */
    private int f2232a = 0;

    /* JADX INFO: renamed from: b */
    private int f2233b = 0;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C0873c f2234c;

    public C0875e(C0873c c0873c) {
        this.f2234c = c0873c;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f2234c.f2231c - this.f2232a;
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f2233b = this.f2232a;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f2232a >= this.f2234c.f2231c) {
            return -1;
        }
        int iM1956h = this.f2234c.m1956h(this.f2232a);
        this.f2232a++;
        return iM1956h;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            i2 = bArr.length - i;
        }
        int i3 = this.f2234c.f2231c - this.f2232a;
        if (i2 > i3) {
            i2 = i3;
        }
        System.arraycopy(this.f2234c.f2229a, this.f2232a + this.f2234c.f2230b, bArr, i, i2);
        this.f2232a += i2;
        return i2;
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f2232a = this.f2233b;
    }
}
