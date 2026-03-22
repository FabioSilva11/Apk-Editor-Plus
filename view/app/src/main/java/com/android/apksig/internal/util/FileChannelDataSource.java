package com.android.apksig.internal.util;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSource;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public class FileChannelDataSource implements DataSource {
    public final FileChannel mChannel;
    public final long mOffset;
    public final long mSize;

    public FileChannelDataSource(FileChannel fileChannel) {
        this.mChannel = fileChannel;
        this.mOffset = 0L;
        this.mSize = -1L;
    }

    public FileChannelDataSource(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: " + j2);
        }
        if (j2 >= 0) {
            this.mChannel = fileChannel;
            this.mOffset = j;
            this.mSize = j2;
        } else {
            throw new IndexOutOfBoundsException("size: " + j2);
        }
    }

    public static void checkChunkValid(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: " + j);
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: " + j2);
        }
        if (j > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + j3 + ")");
        }
        long j4 = j + j2;
        if (j4 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j4 <= j3) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
    }

    @Override // com.android.apksig.util.DataSource
    public void copyTo(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        checkChunkValid(j, i, size());
        if (i == 0) {
            return;
        }
        if (i > byteBuffer.remaining()) {
            throw new BufferOverflowException();
        }
        long j2 = this.mOffset + j;
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i);
            while (i > 0) {
                synchronized (this.mChannel) {
                    this.mChannel.position(j2);
                    i2 = this.mChannel.read(byteBuffer);
                }
                j2 += (long) i2;
                i -= i2;
            }
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    @Override // com.android.apksig.util.DataSource
    public void feed(long j, long j2, DataSink dataSink) throws IOException {
        checkChunkValid(j, j2, size());
        if (j2 == 0) {
            return;
        }
        long j3 = this.mOffset + j;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((int) Math.min(j2, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
        while (j2 > 0) {
            int iMin = (int) Math.min(j2, byteBufferAllocateDirect.capacity());
            byteBufferAllocateDirect.limit(iMin);
            synchronized (this.mChannel) {
                this.mChannel.position(j3);
                int i = iMin;
                while (i > 0) {
                    int i2 = this.mChannel.read(byteBufferAllocateDirect);
                    if (i2 < 0) {
                        throw new IOException("Unexpected EOF encountered");
                    }
                    i -= i2;
                }
            }
            byteBufferAllocateDirect.flip();
            dataSink.consume(byteBufferAllocateDirect);
            byteBufferAllocateDirect.clear();
            long j4 = iMin;
            j3 += j4;
            j2 -= j4;
        }
    }

    @Override // com.android.apksig.util.DataSource
    public ByteBuffer getByteBuffer(long j, int i) throws IOException {
        if (i >= 0) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            copyTo(j, i, byteBufferAllocate);
            byteBufferAllocate.flip();
            return byteBufferAllocate;
        }
        throw new IndexOutOfBoundsException("size: " + i);
    }

    @Override // com.android.apksig.util.DataSource
    public long size() {
        long j = this.mSize;
        if (j != -1) {
            return j;
        }
        try {
            return this.mChannel.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    @Override // com.android.apksig.util.DataSource
    public FileChannelDataSource slice(long j, long j2) {
        long size = size();
        checkChunkValid(j, j2, size);
        return (j == 0 && j2 == size) ? this : new FileChannelDataSource(this.mChannel, this.mOffset + j, j2);
    }
}
