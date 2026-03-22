package com.android.apksig.internal.util;

import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferDataSource implements DataSource {
    public final ByteBuffer mBuffer;
    public final int mSize;

    public ByteBufferDataSource(ByteBuffer byteBuffer) {
        this(byteBuffer, true);
    }

    public ByteBufferDataSource(ByteBuffer byteBuffer, boolean z) {
        this.mBuffer = z ? byteBuffer.slice() : byteBuffer;
        this.mSize = byteBuffer.remaining();
    }

    public final void checkChunkValid(long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: " + j);
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: " + j2);
        }
        int i = this.mSize;
        if (j > i) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + this.mSize + ")");
        }
        long j3 = j + j2;
        if (j3 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + this.mSize + ")");
    }

    @Override // com.android.apksig.util.DataSource
    public void copyTo(long j, int i, ByteBuffer byteBuffer) {
        byteBuffer.put(getByteBuffer(j, i));
    }

    @Override // com.android.apksig.util.DataSource
    public void feed(long j, long j2, DataSink dataSink) throws IOException {
        if (j2 >= 0 && j2 <= this.mSize) {
            dataSink.consume(getByteBuffer(j, (int) j2));
            return;
        }
        throw new IndexOutOfBoundsException("size: " + j2 + ", source size: " + this.mSize);
    }

    @Override // com.android.apksig.util.DataSource
    public ByteBuffer getByteBuffer(long j, int i) {
        ByteBuffer byteBufferSlice;
        checkChunkValid(j, i);
        int i2 = (int) j;
        int i3 = i + i2;
        synchronized (this.mBuffer) {
            this.mBuffer.position(0);
            this.mBuffer.limit(i3);
            this.mBuffer.position(i2);
            byteBufferSlice = this.mBuffer.slice();
        }
        return byteBufferSlice;
    }

    @Override // com.android.apksig.util.DataSource
    public long size() {
        return this.mSize;
    }

    @Override // com.android.apksig.util.DataSource
    public ByteBufferDataSource slice(long j, long j2) {
        if (j == 0 && j2 == this.mSize) {
            return this;
        }
        if (j2 >= 0 && j2 <= this.mSize) {
            return new ByteBufferDataSource(getByteBuffer(j, (int) j2), false);
        }
        throw new IndexOutOfBoundsException("size: " + j2 + ", source size: " + this.mSize);
    }
}
