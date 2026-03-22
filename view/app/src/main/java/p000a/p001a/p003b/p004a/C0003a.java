package p000a.p001a.p003b.p004a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: a.a.b.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0003a extends FilterInputStream {

    /* JADX INFO: renamed from: a */
    private int f0a;

    /* JADX INFO: renamed from: b */
    private int f1b;

    public C0003a(InputStream inputStream) {
        super(inputStream);
        this.f1b = -1;
    }

    /* JADX INFO: renamed from: a */
    public final int m0a() {
        return this.f0a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.f1b = this.f0a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = this.in.read();
        if (i != -1) {
            this.f0a++;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.in.read(bArr, i, i2);
        if (i3 != -1) {
            this.f0a += i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f1b == -1) {
            throw new IOException("Mark not set");
        }
        this.in.reset();
        this.f0a = this.f1b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jSkip = this.in.skip(j);
        this.f0a = (int) (((long) this.f0a) + jSkip);
        return jSkip;
    }
}
