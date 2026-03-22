package org.p088jf.dexlib2.writer.p089io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import org.p088jf.util.RandomAccessFileInputStream;
import org.p088jf.util.RandomAccessFileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileDataStore implements DexDataStore {
    public final RandomAccessFile raf;

    public FileDataStore(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.raf = randomAccessFile;
        randomAccessFile.setLength(0L);
    }

    @Override // org.p088jf.dexlib2.writer.p089io.DexDataStore
    public void close() throws IOException {
        this.raf.close();
    }

    @Override // org.p088jf.dexlib2.writer.p089io.DexDataStore
    public OutputStream outputAt(int i) {
        return new RandomAccessFileOutputStream(this.raf, i);
    }

    @Override // org.p088jf.dexlib2.writer.p089io.DexDataStore
    public InputStream readAt(int i) {
        return new RandomAccessFileInputStream(this.raf, i);
    }
}
