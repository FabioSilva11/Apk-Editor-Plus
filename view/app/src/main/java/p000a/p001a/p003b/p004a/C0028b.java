package p000a.p001a.p003b.p004a;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: a.a.b.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0028b implements DataInput {

    /* JADX INFO: renamed from: a */
    private DataInputStream f34a;

    /* JADX INFO: renamed from: b */
    private InputStream f35b;

    /* JADX INFO: renamed from: c */
    private byte[] f36c = new byte[8];

    public C0028b(InputStream inputStream) {
        this.f35b = inputStream;
        this.f34a = new DataInputStream(inputStream);
    }

    /* JADX INFO: renamed from: a */
    public final int m40a(byte[] bArr, int i, int i2) {
        return this.f35b.read(bArr, 0, 4096);
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return this.f34a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return this.f34a.readByte();
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        this.f34a.readFully(this.f36c, 0, 2);
        return (char) (((this.f36c[1] & 255) << 8) | (this.f36c[0] & 255));
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.f34a.readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f34a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.f34a.readFully(this.f36c, 0, 4);
        return (this.f36c[3] << 24) | ((this.f36c[2] & 255) << 16) | ((this.f36c[1] & 255) << 8) | (this.f36c[0] & 255);
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() {
        return this.f34a.readLine();
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        this.f34a.readFully(this.f36c, 0, 8);
        return (((long) this.f36c[7]) << 56) | (((long) (this.f36c[6] & 255)) << 48) | (((long) (this.f36c[5] & 255)) << 40) | (((long) (this.f36c[4] & 255)) << 32) | (((long) (this.f36c[3] & 255)) << 24) | (((long) (this.f36c[2] & 255)) << 16) | (((long) (this.f36c[1] & 255)) << 8) | ((long) (this.f36c[0] & 255));
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.f34a.readFully(this.f36c, 0, 2);
        return (short) (((this.f36c[1] & 255) << 8) | (this.f36c[0] & 255));
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return this.f34a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        return this.f34a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.f34a.readFully(this.f36c, 0, 2);
        return ((this.f36c[1] & 255) << 8) | (this.f36c[0] & 255);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        return this.f34a.skipBytes(i);
    }
}
