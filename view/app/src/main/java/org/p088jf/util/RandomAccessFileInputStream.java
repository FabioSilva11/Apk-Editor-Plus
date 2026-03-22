package org.p088jf.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public class RandomAccessFileInputStream extends InputStream {
    public int filePosition;
    public final RandomAccessFile raf;

    public RandomAccessFileInputStream(RandomAccessFile randomAccessFile, int i) {
        this.filePosition = i;
        this.raf = randomAccessFile;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return ((int) this.raf.length()) - this.filePosition;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.raf.seek(this.filePosition);
        this.filePosition++;
        return this.raf.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        this.raf.seek(this.filePosition);
        int i = this.raf.read(bArr);
        this.filePosition += i;
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.raf.seek(this.filePosition);
        int i3 = this.raf.read(bArr, i, i2);
        this.filePosition += i3;
        return i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        int iMin = Math.min((int) j, available());
        this.filePosition += iMin;
        return iMin;
    }
}
