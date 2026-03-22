package com.android.apksig.internal.util;

import com.android.apksig.util.DataSink;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public class RandomAccessFileDataSink implements DataSink {
    public final RandomAccessFile mFile;
    public final FileChannel mFileChannel;
    public long mPosition;

    public RandomAccessFileDataSink(RandomAccessFile randomAccessFile) {
        this(randomAccessFile, 0L);
    }

    public RandomAccessFileDataSink(RandomAccessFile randomAccessFile, long j) {
        if (randomAccessFile == null) {
            throw new NullPointerException("file == null");
        }
        if (j >= 0) {
            this.mFile = randomAccessFile;
            this.mFileChannel = randomAccessFile.getChannel();
            this.mPosition = j;
        } else {
            throw new IllegalArgumentException("startPosition: " + j);
        }
    }

    @Override // com.android.apksig.util.DataSink
    public void consume(ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        synchronized (this.mFile) {
            this.mFile.seek(this.mPosition);
            while (byteBuffer.hasRemaining()) {
                this.mFileChannel.write(byteBuffer);
            }
            this.mPosition += (long) iRemaining;
        }
    }

    @Override // com.android.apksig.util.DataSink
    public void consume(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("offset: " + i);
        }
        if (i > bArr.length) {
            throw new IndexOutOfBoundsException("offset: " + i + ", buf.length: " + bArr.length);
        }
        if (i2 == 0) {
            return;
        }
        synchronized (this.mFile) {
            this.mFile.seek(this.mPosition);
            this.mFile.write(bArr, i, i2);
            this.mPosition += (long) i2;
        }
    }

    public RandomAccessFile getFile() {
        return this.mFile;
    }
}
