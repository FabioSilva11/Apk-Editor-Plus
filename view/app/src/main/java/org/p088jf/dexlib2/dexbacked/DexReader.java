package org.p088jf.dexlib2.dexbacked;

import com.gmail.heagoo.neweditor.Token;
import org.p088jf.dexlib2.dexbacked.DexBuffer;
import org.p088jf.util.ExceptionWithContext;
import org.p088jf.util.Utf8Utils;

/* JADX INFO: loaded from: classes.dex */
public class DexReader<T extends DexBuffer> {
    public final T dexBuf;
    public int offset;

    public DexReader(T t, int i) {
        this.dexBuf = t;
        this.offset = i;
    }

    public int getOffset() {
        return this.offset;
    }

    public void moveRelative(int i) {
        this.offset += i;
    }

    public int peekUbyte() {
        return this.dexBuf.readUbyte(this.offset);
    }

    public int peekUshort() {
        return this.dexBuf.readUshort(this.offset);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005a A[PHI: r2 r5
  0x005a: PHI (r2v7 int) = (r2v6 int), (r2v9 int) binds: [B:5:0x0020, B:9:0x003a] A[DONT_GENERATE, DONT_INLINE]
  0x005a: PHI (r5v1 int) = (r5v0 int), (r5v4 int) binds: [B:5:0x0020, B:9:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int readBigUleb128() {
        /*
            r7 = this;
            T extends org.jf.dexlib2.dexbacked.DexBuffer r0 = r7.dexBuf
            int r1 = r0.baseOffset
            int r2 = r7.offset
            int r2 = r2 + r1
            byte[] r0 = r0.buf
            int r3 = r2 + 1
            r2 = r0[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = 127(0x7f, float:1.78E-43)
            if (r2 <= r4) goto L5b
            int r5 = r3 + 1
            r3 = r0[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r6 = r3 & 127(0x7f, float:1.78E-43)
            int r6 = r6 << 7
            r2 = r2 | r6
            if (r3 <= r4) goto L5a
            int r3 = r5 + 1
            r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = r5 & 127(0x7f, float:1.78E-43)
            int r6 = r6 << 14
            r2 = r2 | r6
            if (r5 <= r4) goto L5b
            int r5 = r3 + 1
            r3 = r0[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r6 = r3 & 127(0x7f, float:1.78E-43)
            int r6 = r6 << 21
            r2 = r2 | r6
            if (r3 <= r4) goto L5a
            int r3 = r5 + 1
            r0 = r0[r5]
            if (r0 < 0) goto L46
            int r0 = r0 << 28
            r2 = r2 | r0
            goto L5b
        L46:
            org.jf.util.ExceptionWithContext r0 = new org.jf.util.ExceptionWithContext
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r7.offset
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "Invalid uleb128 integer encountered at offset 0x%x"
            r0.<init>(r2, r1)
            throw r0
        L5a:
            r3 = r5
        L5b:
            int r3 = r3 - r1
            r7.offset = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.dexlib2.dexbacked.DexReader.readBigUleb128():int");
    }

    public int readByte() {
        int i = this.offset;
        int i2 = this.dexBuf.readByte(i);
        this.offset = i + 1;
        return i2;
    }

    public int readLargeUleb128() {
        return readUleb128(true);
    }

    public int readSizedInt(int i) {
        int i2;
        int i3;
        int i4;
        T t = this.dexBuf;
        int i5 = t.baseOffset;
        int i6 = this.offset + i5;
        byte[] bArr = t.buf;
        if (i != 1) {
            if (i == 2) {
                i3 = bArr[i6] & 255;
                i4 = bArr[i6 + 1] << 8;
            } else if (i == 3) {
                i3 = (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8);
                i4 = bArr[i6 + 2] << Token.LITERAL4;
            } else {
                if (i != 4) {
                    throw new ExceptionWithContext("Invalid size %d for sized int at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.offset));
                }
                i3 = (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16);
                i4 = bArr[i6 + 3] << 24;
            }
            i2 = i4 | i3;
        } else {
            i2 = bArr[i6];
        }
        this.offset = (i6 + i) - i5;
        return i2;
    }

    public long readSizedLong(int i) {
        int i2;
        int i3;
        int i4;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        T t = this.dexBuf;
        int i5 = t.baseOffset;
        int i6 = this.offset + i5;
        byte[] bArr = t.buf;
        switch (i) {
            case 1:
                i2 = bArr[i6];
                j = i2;
                this.offset = (i6 + i) - i5;
                return j;
            case 2:
                i3 = bArr[i6] & 255;
                i4 = bArr[i6 + 1] << 8;
                i2 = i4 | i3;
                j = i2;
                this.offset = (i6 + i) - i5;
                return j;
            case 3:
                i3 = (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8);
                i4 = bArr[i6 + 2] << Token.LITERAL4;
                i2 = i4 | i3;
                j = i2;
                this.offset = (i6 + i) - i5;
                return j;
            case 4:
                j2 = (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16);
                j3 = ((long) bArr[i6 + 3]) << 24;
                j = j2 | j3;
                this.offset = (i6 + i) - i5;
                return j;
            case 5:
                j2 = ((long) ((bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16))) | ((255 & ((long) bArr[i6 + 3])) << 24);
                j3 = ((long) bArr[i6 + 4]) << 32;
                j = j2 | j3;
                this.offset = (i6 + i) - i5;
                return j;
            case 6:
                j4 = ((255 & ((long) bArr[i6 + 4])) << 32) | ((long) ((bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16))) | ((((long) bArr[i6 + 3]) & 255) << 24);
                j5 = ((long) bArr[i6 + 5]) << 40;
                j = j5 | j4;
                this.offset = (i6 + i) - i5;
                return j;
            case 7:
                j4 = ((((long) bArr[i6 + 4]) & 255) << 32) | ((long) ((bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16))) | ((((long) bArr[i6 + 3]) & 255) << 24) | ((255 & ((long) bArr[i6 + 5])) << 40);
                j5 = ((long) bArr[i6 + 6]) << 48;
                j = j5 | j4;
                this.offset = (i6 + i) - i5;
                return j;
            case 8:
                j2 = ((255 & ((long) bArr[i6 + 6])) << 48) | ((((long) bArr[i6 + 4]) & 255) << 32) | ((long) ((bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16))) | ((((long) bArr[i6 + 3]) & 255) << 24) | ((((long) bArr[i6 + 5]) & 255) << 40);
                j3 = ((long) bArr[i6 + 7]) << 56;
                j = j2 | j3;
                this.offset = (i6 + i) - i5;
                return j;
            default:
                throw new ExceptionWithContext("Invalid size %d for sized long at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.offset));
        }
    }

    public int readSizedRightExtendedInt(int i) {
        int i2;
        int i3;
        byte b2;
        T t = this.dexBuf;
        int i4 = t.baseOffset;
        int i5 = this.offset + i4;
        byte[] bArr = t.buf;
        if (i != 1) {
            if (i == 2) {
                i3 = (bArr[i5] & 255) << 16;
                b2 = bArr[i5 + 1];
            } else if (i == 3) {
                i3 = ((bArr[i5] & 255) << 8) | ((bArr[i5 + 1] & 255) << 16);
                b2 = bArr[i5 + 2];
            } else {
                if (i != 4) {
                    throw new ExceptionWithContext("Invalid size %d for sized, right extended int at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.offset));
                }
                i3 = (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
                b2 = bArr[i5 + 3];
            }
            i2 = (b2 << 24) | i3;
        } else {
            i2 = bArr[i5] << 24;
        }
        this.offset = (i5 + i) - i4;
        return i2;
    }

    public long readSizedRightExtendedLong(int i) {
        long j;
        long j2;
        byte b2;
        T t = this.dexBuf;
        int i2 = t.baseOffset;
        int i3 = this.offset + i2;
        byte[] bArr = t.buf;
        switch (i) {
            case 1:
                j = ((long) bArr[i3]) << 56;
                this.offset = (i3 + i) - i2;
                return j;
            case 2:
                j2 = (((long) bArr[i3]) & 255) << 48;
                b2 = bArr[i3 + 1];
                j = j2 | (((long) b2) << 56);
                this.offset = (i3 + i) - i2;
                return j;
            case 3:
                j2 = ((((long) bArr[i3]) & 255) << 40) | ((255 & ((long) bArr[i3 + 1])) << 48);
                b2 = bArr[i3 + 2];
                j = j2 | (((long) b2) << 56);
                this.offset = (i3 + i) - i2;
                return j;
            case 4:
                j2 = ((((long) bArr[i3]) & 255) << 32) | ((((long) bArr[i3 + 1]) & 255) << 40) | ((255 & ((long) bArr[i3 + 2])) << 48);
                b2 = bArr[i3 + 3];
                j = j2 | (((long) b2) << 56);
                this.offset = (i3 + i) - i2;
                return j;
            case 5:
                j2 = ((((long) bArr[i3 + 1]) & 255) << 32) | ((((long) bArr[i3]) & 255) << 24) | ((((long) bArr[i3 + 2]) & 255) << 40) | ((255 & ((long) bArr[i3 + 3])) << 48);
                b2 = bArr[i3 + 4];
                j = j2 | (((long) b2) << 56);
                this.offset = (i3 + i) - i2;
                return j;
            case 6:
                j2 = ((((long) bArr[i3 + 2]) & 255) << 32) | ((long) ((bArr[i3] & 255) << 16)) | ((((long) bArr[i3 + 1]) & 255) << 24) | ((((long) bArr[i3 + 3]) & 255) << 40) | ((255 & ((long) bArr[i3 + 4])) << 48);
                b2 = bArr[i3 + 5];
                j = j2 | (((long) b2) << 56);
                this.offset = (i3 + i) - i2;
                return j;
            case 7:
                j2 = ((((long) bArr[i3 + 3]) & 255) << 32) | ((long) (((bArr[i3] & 255) << 8) | ((bArr[i3 + 1] & 255) << 16))) | ((((long) bArr[i3 + 2]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 40) | ((255 & ((long) bArr[i3 + 5])) << 48);
                b2 = bArr[i3 + 6];
                j = j2 | (((long) b2) << 56);
                this.offset = (i3 + i) - i2;
                return j;
            case 8:
                j2 = ((((long) bArr[i3 + 4]) & 255) << 32) | ((long) ((bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16))) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((255 & ((long) bArr[i3 + 6])) << 48);
                b2 = bArr[i3 + 7];
                j = j2 | (((long) b2) << 56);
                this.offset = (i3 + i) - i2;
                return j;
            default:
                throw new ExceptionWithContext("Invalid size %d for sized, right extended long at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.offset));
        }
    }

    public int readSizedSmallUint(int i) {
        T t = this.dexBuf;
        int i2 = t.baseOffset;
        int i3 = this.offset + i2;
        byte[] bArr = t.buf;
        int i4 = 0;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new ExceptionWithContext("Invalid size %d for sized uint at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.offset));
                    }
                    byte b2 = bArr[i3 + 3];
                    if (b2 < 0) {
                        throw new ExceptionWithContext("Encountered valid sized uint that is out of range at offset 0x%x", Integer.valueOf(this.offset));
                    }
                    i4 = b2 << 24;
                }
                i4 |= (bArr[i3 + 2] & 255) << 16;
            }
            i4 |= (bArr[i3 + 1] & 255) << 8;
        }
        int i5 = (bArr[i3] & 255) | i4;
        this.offset = (i3 + i) - i2;
        return i5;
    }

    public int readSleb128() {
        int i;
        T t = this.dexBuf;
        int i2 = t.baseOffset;
        int i3 = this.offset + i2;
        byte[] bArr = t.buf;
        int i4 = i3 + 1;
        int i5 = bArr[i3] & 255;
        if (i5 <= 127) {
            i = (i5 << 25) >> 25;
        } else {
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            int i8 = (i5 & 127) | ((i7 & 127) << 7);
            if (i7 <= 127) {
                i = (i8 << 18) >> 18;
            } else {
                i4 = i6 + 1;
                int i9 = bArr[i6] & 255;
                int i10 = i8 | ((i9 & 127) << 14);
                if (i9 <= 127) {
                    i = (i10 << 11) >> 11;
                } else {
                    i6 = i4 + 1;
                    int i11 = bArr[i4] & 255;
                    int i12 = i10 | ((i11 & 127) << 21);
                    if (i11 <= 127) {
                        i = (i12 << 4) >> 4;
                    } else {
                        i4 = i6 + 1;
                        int i13 = bArr[i6] & 255;
                        if (i13 > 127) {
                            throw new ExceptionWithContext("Invalid sleb128 integer encountered at offset 0x%x", Integer.valueOf(this.offset));
                        }
                        i = (i13 << 28) | i12;
                    }
                }
            }
            i4 = i6;
        }
        this.offset = i4 - i2;
        return i;
    }

    public int readSmallUleb128() {
        return readUleb128(false);
    }

    public String readString(int i) {
        int[] iArr = new int[1];
        T t = this.dexBuf;
        String strUtf8BytesWithUtf16LengthToString = Utf8Utils.utf8BytesWithUtf16LengthToString(t.buf, t.baseOffset + this.offset, i, iArr);
        this.offset += iArr[0];
        return strUtf8BytesWithUtf16LengthToString;
    }

    public int readUbyte() {
        int i = this.offset;
        int ubyte = this.dexBuf.readUbyte(i);
        this.offset = i + 1;
        return ubyte;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0073 A[PHI: r2 r5
  0x0073: PHI (r2v7 int) = (r2v6 int), (r2v9 int) binds: [B:5:0x0020, B:9:0x003a] A[DONT_GENERATE, DONT_INLINE]
  0x0073: PHI (r5v1 int) = (r5v0 int), (r5v4 int) binds: [B:5:0x0020, B:9:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int readUleb128(boolean r9) {
        /*
            r8 = this;
            T extends org.jf.dexlib2.dexbacked.DexBuffer r0 = r8.dexBuf
            int r1 = r0.baseOffset
            int r2 = r8.offset
            int r2 = r2 + r1
            byte[] r0 = r0.buf
            int r3 = r2 + 1
            r2 = r0[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = 127(0x7f, float:1.78E-43)
            if (r2 <= r4) goto L74
            int r5 = r3 + 1
            r3 = r0[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r6 = r3 & 127(0x7f, float:1.78E-43)
            r7 = 7
            int r6 = r6 << r7
            r2 = r2 | r6
            if (r3 <= r4) goto L73
            int r3 = r5 + 1
            r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = r5 & 127(0x7f, float:1.78E-43)
            int r6 = r6 << 14
            r2 = r2 | r6
            if (r5 <= r4) goto L74
            int r5 = r3 + 1
            r3 = r0[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r6 = r3 & 127(0x7f, float:1.78E-43)
            int r6 = r6 << 21
            r2 = r2 | r6
            if (r3 <= r4) goto L73
            int r3 = r5 + 1
            r0 = r0[r5]
            r4 = 0
            r5 = 1
            if (r0 < 0) goto L61
            r6 = r0 & 15
            if (r6 <= r7) goto L5d
            if (r9 == 0) goto L4b
            goto L5d
        L4b:
            org.jf.util.ExceptionWithContext r9 = new org.jf.util.ExceptionWithContext
            java.lang.Object[] r0 = new java.lang.Object[r5]
            int r1 = r8.offset
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r4] = r1
            java.lang.String r1 = "Encountered valid uleb128 that is out of range at offset 0x%x"
            r9.<init>(r1, r0)
            throw r9
        L5d:
            int r9 = r0 << 28
            r2 = r2 | r9
            goto L74
        L61:
            org.jf.util.ExceptionWithContext r9 = new org.jf.util.ExceptionWithContext
            java.lang.Object[] r0 = new java.lang.Object[r5]
            int r1 = r8.offset
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r4] = r1
            java.lang.String r1 = "Invalid uleb128 integer encountered at offset 0x%x"
            r9.<init>(r1, r0)
            throw r9
        L73:
            r3 = r5
        L74:
            int r3 = r3 - r1
            r8.offset = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.dexlib2.dexbacked.DexReader.readUleb128(boolean):int");
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void skipByte() {
        this.offset++;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[PHI: r2
  0x003c: PHI (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:5:0x0013, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void skipUleb128() {
        /*
            r4 = this;
            T extends org.jf.dexlib2.dexbacked.DexBuffer r0 = r4.dexBuf
            int r1 = r0.baseOffset
            int r2 = r4.offset
            int r2 = r2 + r1
            byte[] r0 = r0.buf
            int r3 = r2 + 1
            r2 = r0[r2]
            if (r2 >= 0) goto L3d
            int r2 = r3 + 1
            r3 = r0[r3]
            if (r3 >= 0) goto L3c
            int r3 = r2 + 1
            r2 = r0[r2]
            if (r2 >= 0) goto L3d
            int r2 = r3 + 1
            r3 = r0[r3]
            if (r3 >= 0) goto L3c
            int r3 = r2 + 1
            r0 = r0[r2]
            if (r0 < 0) goto L28
            goto L3d
        L28:
            org.jf.util.ExceptionWithContext r0 = new org.jf.util.ExceptionWithContext
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.offset
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "Invalid uleb128 integer encountered at offset 0x%x"
            r0.<init>(r2, r1)
            throw r0
        L3c:
            r3 = r2
        L3d:
            int r3 = r3 - r1
            r4.offset = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.dexlib2.dexbacked.DexReader.skipUleb128():void");
    }
}
