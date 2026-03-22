package org.p088jf.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public class RandomAccessFileOutputStream extends OutputStream {
    public int filePosition;
    public final RandomAccessFile raf;

    public RandomAccessFileOutputStream(RandomAccessFile randomAccessFile, int i) {
        this.filePosition = i;
        this.raf = randomAccessFile;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.raf.seek(this.filePosition);
        this.filePosition++;
        this.raf.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.raf.seek(this.filePosition);
        this.filePosition += bArr.length;
        this.raf.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.raf.seek(this.filePosition);
        this.filePosition += i2;
        this.raf.write(bArr, i, i2);
    }
}
