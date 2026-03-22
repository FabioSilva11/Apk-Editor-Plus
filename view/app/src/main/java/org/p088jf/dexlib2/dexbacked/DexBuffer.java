package org.p088jf.dexlib2.dexbacked;

import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class DexBuffer {
    public final int baseOffset;
    public final byte[] buf;

    public DexBuffer(byte[] bArr) {
        this(bArr, 0);
    }

    public DexBuffer(byte[] bArr, int i) {
        this.buf = bArr;
        this.baseOffset = i;
    }

    public int getBaseOffset() {
        return this.baseOffset;
    }

    public int readByte(int i) {
        return this.buf[this.baseOffset + i];
    }

    public int readInt(int i) {
        byte[] bArr = this.buf;
        int i2 = i + this.baseOffset;
        return (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long readLong(int i) {
        byte[] bArr = this.buf;
        int i2 = i + this.baseOffset;
        return ((long) ((bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16))) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48) | (((long) bArr[i2 + 7]) << 56);
    }

    public int readLongAsSmallUint(int i) {
        byte[] bArr = this.buf;
        int i2 = i + this.baseOffset;
        long j = ((long) ((bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16))) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48) | (((long) bArr[i2 + 7]) << 56);
        if (j < 0 || j > 2147483647L) {
            throw new ExceptionWithContext("Encountered out-of-range ulong at offset 0x%x", Integer.valueOf(i2));
        }
        return (int) j;
    }

    public int readOptionalUint(int i) {
        byte[] bArr = this.buf;
        int i2 = i + this.baseOffset;
        int i3 = (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        if (i3 >= -1) {
            return i3;
        }
        throw new ExceptionWithContext("Encountered optional uint that is out of range at offset 0x%x", Integer.valueOf(i2));
    }

    public int readShort(int i) {
        byte[] bArr = this.buf;
        int i2 = i + this.baseOffset;
        return (bArr[i2 + 1] << 8) | (bArr[i2] & 255);
    }

    public int readSmallUint(int i) {
        byte[] bArr = this.buf;
        int i2 = i + this.baseOffset;
        int i3 = (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        if (i3 >= 0) {
            return i3;
        }
        throw new ExceptionWithContext("Encountered small uint that is out of range at offset 0x%x", Integer.valueOf(i2));
    }

    public int readUbyte(int i) {
        return this.buf[i + this.baseOffset] & 255;
    }

    public int readUshort(int i) {
        byte[] bArr = this.buf;
        int i2 = i + this.baseOffset;
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255);
    }

    public DexReader<? extends DexBuffer> readerAt(int i) {
        return new DexReader<>(this, i);
    }
}
