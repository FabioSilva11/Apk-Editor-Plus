package com.android.apksig.internal.asn1.ber;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class InputStreamBerDataValueReader implements BerDataValueReader {
    public final InputStream mIn;

    public static class RecordingInputStream extends InputStream {
        public final ByteArrayOutputStream mBuf;
        public final InputStream mIn;

        public RecordingInputStream(InputStream inputStream) {
            this.mIn = inputStream;
            this.mBuf = new ByteArrayOutputStream();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return super.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
        }

        public int getReadByteCount() {
            return this.mBuf.size();
        }

        public byte[] getReadBytes() {
            return this.mBuf.toByteArray();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i = this.mIn.read();
            if (i != -1) {
                this.mBuf.write(i);
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int i = this.mIn.read(bArr);
            if (i > 0) {
                this.mBuf.write(bArr, 0, i);
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.mIn.read(bArr, i, i2);
            if (i3 > 0) {
                this.mBuf.write(bArr, i, i3);
            }
            return i3;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            throw new IOException("mark/reset not supported");
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (j <= 0) {
                return this.mIn.skip(j);
            }
            byte[] bArr = new byte[4096];
            int i = this.mIn.read(bArr, 0, (int) Math.min(4096, j));
            if (i > 0) {
                this.mBuf.write(bArr, 0, i);
            }
            if (i < 0) {
                return 0L;
            }
            return i;
        }
    }

    public InputStreamBerDataValueReader(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        }
        this.mIn = inputStream;
    }

    public static BerDataValue readDataValue(InputStream inputStream) throws BerDataValueFormatException {
        int readByteCount;
        int iSkipConstructedIndefiniteLengthContents;
        RecordingInputStream recordingInputStream = new RecordingInputStream(inputStream);
        try {
            int i = recordingInputStream.read();
            if (i == -1) {
                return null;
            }
            int tagNumber = readTagNumber(recordingInputStream, i);
            int i2 = recordingInputStream.read();
            if (i2 == -1) {
                throw new BerDataValueFormatException("Missing length");
            }
            byte b2 = (byte) i;
            boolean zIsConstructed = BerEncoding.isConstructed(b2);
            if ((i2 & 128) == 0) {
                iSkipConstructedIndefiniteLengthContents = readShortFormLength(i2);
                readByteCount = recordingInputStream.getReadByteCount();
                skipDefiniteLengthContents(recordingInputStream, iSkipConstructedIndefiniteLengthContents);
            } else if ((i2 & 255) != 128) {
                iSkipConstructedIndefiniteLengthContents = readLongFormLength(recordingInputStream, i2);
                readByteCount = recordingInputStream.getReadByteCount();
                skipDefiniteLengthContents(recordingInputStream, iSkipConstructedIndefiniteLengthContents);
            } else {
                readByteCount = recordingInputStream.getReadByteCount();
                iSkipConstructedIndefiniteLengthContents = zIsConstructed ? skipConstructedIndefiniteLengthContents(recordingInputStream) : skipPrimitiveIndefiniteLengthContents(recordingInputStream);
            }
            byte[] readBytes = recordingInputStream.getReadBytes();
            return new BerDataValue(ByteBuffer.wrap(readBytes), ByteBuffer.wrap(readBytes, readByteCount, iSkipConstructedIndefiniteLengthContents), BerEncoding.getTagClass(b2), zIsConstructed, tagNumber);
        } catch (IOException e) {
            throw new BerDataValueFormatException("Failed to read data value", e);
        }
    }

    public static int readHighTagNumber(InputStream inputStream) throws IOException, BerDataValueFormatException {
        int i;
        int i2 = 0;
        do {
            i = inputStream.read();
            if (i == -1) {
                throw new BerDataValueFormatException("Truncated tag number");
            }
            if (i2 > 16777215) {
                throw new BerDataValueFormatException("Tag number too large");
            }
            i2 = (i2 << 7) | (i & 127);
        } while ((i & 128) != 0);
        return i2;
    }

    public static int readLongFormLength(InputStream inputStream, int i) throws IOException, BerDataValueFormatException {
        int i2 = i & 127;
        if (i2 > 4) {
            throw new BerDataValueFormatException("Length too large: " + i2 + " bytes");
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw new BerDataValueFormatException("Truncated length");
            }
            if (i3 > 8388607) {
                throw new BerDataValueFormatException("Length too large");
            }
            i3 = (i3 << 8) | (i5 & 255);
        }
        return i3;
    }

    public static int readShortFormLength(int i) {
        return i & 127;
    }

    public static int readTagNumber(InputStream inputStream, int i) throws IOException, BerDataValueFormatException {
        int tagNumber = BerEncoding.getTagNumber((byte) i);
        return tagNumber == 31 ? readHighTagNumber(inputStream) : tagNumber;
    }

    public static int skipConstructedIndefiniteLengthContents(RecordingInputStream recordingInputStream) throws BerDataValueFormatException {
        int readByteCount = recordingInputStream.getReadByteCount();
        while (true) {
            BerDataValue dataValue = readDataValue(recordingInputStream);
            if (dataValue == null) {
                throw new BerDataValueFormatException("Truncated indefinite-length contents: " + (recordingInputStream.getReadByteCount() - readByteCount) + " bytes read");
            }
            if (recordingInputStream.getReadByteCount() <= 0) {
                throw new BerDataValueFormatException("Indefinite-length contents too long");
            }
            ByteBuffer encoded = dataValue.getEncoded();
            if (encoded.remaining() == 2 && encoded.get(0) == 0 && encoded.get(1) == 0) {
                return (recordingInputStream.getReadByteCount() - readByteCount) - 2;
            }
        }
    }

    public static void skipDefiniteLengthContents(InputStream inputStream, int i) throws IOException, BerDataValueFormatException {
        long j = 0;
        while (i > 0) {
            int iSkip = (int) inputStream.skip(i);
            if (iSkip <= 0) {
                throw new BerDataValueFormatException("Truncated definite-length contents: " + j + " bytes read, " + i + " missing");
            }
            i -= iSkip;
            j += (long) iSkip;
        }
    }

    public static int skipPrimitiveIndefiniteLengthContents(InputStream inputStream) throws IOException, BerDataValueFormatException {
        int i = 0;
        while (true) {
            boolean z = false;
            while (true) {
                int i2 = inputStream.read();
                if (i2 == -1) {
                    throw new BerDataValueFormatException("Truncated indefinite-length contents: " + i + " bytes read");
                }
                i++;
                if (i < 0) {
                    throw new BerDataValueFormatException("Indefinite-length contents too long");
                }
                if (i2 == 0) {
                    if (z) {
                        return i - 2;
                    }
                    z = true;
                }
            }
        }
    }

    @Override // com.android.apksig.internal.asn1.ber.BerDataValueReader
    public BerDataValue readDataValue() throws BerDataValueFormatException {
        return readDataValue(this.mIn);
    }
}
