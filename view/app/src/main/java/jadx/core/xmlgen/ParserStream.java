package jadx.core.xmlgen;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class ParserStream {
    private final InputStream input;
    private long readPos = 0;
    protected static final Charset STRING_CHARSET_UTF16 = Charset.forName("UTF-16LE");
    protected static final Charset STRING_CHARSET_UTF8 = Charset.forName("UTF-8");
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public ParserStream(InputStream inputStream) {
        this.input = inputStream;
    }

    private void throwException(String str, int i, int i2) throws IOException {
        throw new IOException(str + ", expected: 0x" + Integer.toHexString(i) + ", actual: 0x" + Integer.toHexString(i2) + ", offset: 0x" + Long.toHexString(getPos()));
    }

    public void checkInt16(int i, String str) throws IOException {
        int int16 = readInt16();
        if (int16 != i) {
            throwException(str, i, int16);
        }
    }

    public void checkInt8(int i, String str) throws IOException {
        int int8 = readInt8();
        if (int8 != i) {
            throwException(str, i, int8);
        }
    }

    public void checkPos(long j, String str) throws IOException {
        if (getPos() != j) {
            throw new IOException(str + ", expected offset: 0x" + Long.toHexString(j) + ", actual: 0x" + Long.toHexString(getPos()));
        }
    }

    public long getPos() {
        return this.readPos;
    }

    public void mark(int i) throws IOException {
        if (!this.input.markSupported()) {
            throw new IOException("Mark not supported for input stream " + this.input.getClass());
        }
        this.input.mark(i);
    }

    public int readInt16() throws IOException {
        this.readPos += 2;
        return (this.input.read() & 255) | ((this.input.read() & 255) << 8);
    }

    public int readInt32() throws IOException {
        this.readPos += 4;
        InputStream inputStream = this.input;
        int i = inputStream.read();
        return (inputStream.read() << 24) | ((inputStream.read() & 255) << 16) | ((inputStream.read() & 255) << 8) | (i & 255);
    }

    public int[] readInt32Array(int i) {
        if (i == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt32();
        }
        return iArr;
    }

    public int readInt8() {
        this.readPos++;
        return this.input.read();
    }

    public byte[] readInt8Array(int i) throws IOException {
        if (i == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        this.readPos += (long) i;
        byte[] bArr = new byte[i];
        int i2 = this.input.read(bArr, 0, i);
        while (i2 < i) {
            int i3 = this.input.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new IOException("No data, can't read " + i + " bytes");
            }
            i2 += i3;
        }
        return bArr;
    }

    public String readString16Fixed(int i) {
        return new String(readInt8Array(i << 1), STRING_CHARSET_UTF16).trim();
    }

    public long readUInt32() {
        return ((long) readInt32()) & 4294967295L;
    }

    public void reset() throws IOException {
        this.input.reset();
    }

    public void skip(long j) throws IOException {
        this.readPos += j;
        long jSkip = this.input.skip(j);
        while (jSkip < j) {
            long jSkip2 = this.input.skip(j - jSkip);
            if (jSkip2 == -1) {
                throw new IOException("No data, can't skip " + j + " bytes");
            }
            jSkip += jSkip2;
        }
    }

    public void skipToPos(long j, String str) throws IOException {
        long pos = getPos();
        if (pos < j) {
            skip(j - pos);
        }
        checkPos(j, str);
    }

    public String toString() {
        return "pos: 0x" + Long.toHexString(this.readPos);
    }
}
