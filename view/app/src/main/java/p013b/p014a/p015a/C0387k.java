package p013b.p014a.p015a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.a.a.k */
/* JADX INFO: loaded from: classes.dex */
final class C0387k extends FilterOutputStream {
    public C0387k(OutputStream outputStream) {
        super(outputStream);
    }

    /* JADX INFO: renamed from: a */
    public final void m292a() throws IOException {
        this.out.write("0\r\n\r\n".getBytes());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        this.out.write(String.format("%x\r\n", Integer.valueOf(i2)).getBytes());
        this.out.write(bArr, i, i2);
        this.out.write("\r\n".getBytes());
    }
}
