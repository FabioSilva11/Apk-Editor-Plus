package p000a.p011d;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: renamed from: a.d.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0072d implements DataInput {

    /* JADX INFO: renamed from: a */
    private DataInput f189a;

    public AbstractC0072d(DataInput dataInput) {
        this.f189a = dataInput;
    }

    /* JADX INFO: renamed from: a */
    public final int[] m182a(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f189a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f189a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f189a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f189a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f189a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.f189a.readFully(bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f189a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f189a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f189a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f189a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f189a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f189a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f189a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f189a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.f189a.skipBytes(i);
    }
}
