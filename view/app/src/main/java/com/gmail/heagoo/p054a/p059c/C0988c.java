package com.gmail.heagoo.p054a.p059c;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.a.c.c */
/* JADX INFO: loaded from: classes.dex */
final class C0988c extends OutputStream {

    /* JADX INFO: renamed from: a */
    private long f2489a = 0;

    /* JADX INFO: renamed from: b */
    private OutputStream f2490b;

    public C0988c(OutputStream outputStream) {
        this.f2490b = outputStream;
    }

    /* JADX INFO: renamed from: a */
    public final long m2313a() {
        return this.f2489a;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f2490b.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f2490b.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f2490b.write(i);
        this.f2489a++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.f2490b.write(bArr, i, i2);
        this.f2489a += (long) i2;
    }
}
