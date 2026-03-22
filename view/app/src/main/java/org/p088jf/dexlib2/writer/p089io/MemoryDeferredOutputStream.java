package org.p088jf.dexlib2.writer.p089io;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MemoryDeferredOutputStream extends DeferredOutputStream {
    public final List<byte[]> buffers = Lists.newArrayList();
    public byte[] currentBuffer;
    public int currentPosition;

    public MemoryDeferredOutputStream(int i) {
        this.currentBuffer = new byte[i];
    }

    public static DeferredOutputStreamFactory getFactory() {
        return getFactory(16384);
    }

    public static DeferredOutputStreamFactory getFactory(final int i) {
        return new DeferredOutputStreamFactory() { // from class: org.jf.dexlib2.writer.io.MemoryDeferredOutputStream.1
            @Override // org.p088jf.dexlib2.writer.p089io.DeferredOutputStreamFactory
            public DeferredOutputStream makeDeferredOutputStream() {
                return new MemoryDeferredOutputStream(i);
            }
        };
    }

    public final int remaining() {
        return this.currentBuffer.length - this.currentPosition;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (remaining() == 0) {
            this.buffers.add(this.currentBuffer);
            this.currentBuffer = new byte[this.currentBuffer.length];
            this.currentPosition = 0;
        }
        byte[] bArr = this.currentBuffer;
        int i2 = this.currentPosition;
        this.currentPosition = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int iRemaining = remaining();
        int i3 = 0;
        while (true) {
            int i4 = i2 - i3;
            if (i4 <= 0) {
                return;
            }
            int iMin = Math.min(iRemaining, i4);
            System.arraycopy(bArr, i + i3, this.currentBuffer, this.currentPosition, iMin);
            i3 += iMin;
            this.currentPosition += iMin;
            iRemaining = remaining();
            if (iRemaining == 0) {
                this.buffers.add(this.currentBuffer);
                byte[] bArr2 = new byte[this.currentBuffer.length];
                this.currentBuffer = bArr2;
                this.currentPosition = 0;
                iRemaining = bArr2.length;
            }
        }
    }

    @Override // org.p088jf.dexlib2.writer.p089io.DeferredOutputStream
    public void writeTo(OutputStream outputStream) throws IOException {
        Iterator<byte[]> it = this.buffers.iterator();
        while (it.hasNext()) {
            outputStream.write(it.next());
        }
        int i = this.currentPosition;
        if (i > 0) {
            outputStream.write(this.currentBuffer, 0, i);
        }
        this.buffers.clear();
        this.currentPosition = 0;
    }
}
