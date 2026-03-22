package jadx.core.xmlgen;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CommonBinaryParser extends ParserConstants {

    /* JADX INFO: renamed from: is */
    protected ParserStream f4702is;

    private static String extractString16(byte[] bArr, int i) {
        int length = bArr.length;
        int iSkipStrLen16 = i + skipStrLen16(bArr, i);
        int i2 = iSkipStrLen16;
        while (i2 + 1 < length && (bArr[i2] != 0 || bArr[i2 + 1] != 0)) {
            i2 += 2;
        }
        return new String(Arrays.copyOfRange(bArr, iSkipStrLen16, i2), ParserStream.STRING_CHARSET_UTF16);
    }

    private static String extractString8(byte[] bArr, int i) {
        int i2;
        int iSkipStrLen8 = skipStrLen8(bArr, i) + i;
        int i3 = iSkipStrLen8 + 1;
        int i4 = bArr[iSkipStrLen8];
        if (i4 == 0) {
            return "";
        }
        if ((i4 & 128) != 0) {
            i2 = i3 + 1;
            i4 = ((i4 & 127) << 8) | (bArr[i3] & 255);
        } else {
            i2 = i3;
        }
        return new String(Arrays.copyOfRange(bArr, i2, i4 + i2), ParserStream.STRING_CHARSET_UTF8);
    }

    private static int skipStrLen16(byte[] bArr, int i) {
        return (bArr[i + 1] & 128) == 0 ? 2 : 4;
    }

    private static int skipStrLen8(byte[] bArr, int i) {
        return (bArr[i] & 128) == 0 ? 1 : 2;
    }

    protected void die(String str) throws IOException {
        throw new IOException("Decode error: " + str + ", position: 0x" + Long.toHexString(this.f4702is.getPos()));
    }

    protected String[] parseStringPool() throws IOException {
        this.f4702is.checkInt16(1, "String pool expected");
        return parseStringPoolNoType();
    }

    protected String[] parseStringPoolNoType() throws IOException {
        long pos = this.f4702is.getPos() - 2;
        this.f4702is.checkInt16(28, "String pool header size not 0x001c");
        long uInt32 = pos + this.f4702is.readUInt32();
        int int32 = this.f4702is.readInt32();
        int int322 = this.f4702is.readInt32();
        int int323 = this.f4702is.readInt32();
        long int324 = this.f4702is.readInt32();
        long int325 = this.f4702is.readInt32();
        int[] int32Array = this.f4702is.readInt32Array(int32);
        this.f4702is.readInt32Array(int322);
        this.f4702is.checkPos(int324 + pos, "Expected strings start");
        String[] strArr = new String[int32];
        byte[] int8Array = this.f4702is.readInt8Array((int) ((int325 == 0 ? uInt32 : pos + int325) - this.f4702is.getPos()));
        if ((int323 & 256) != 0) {
            for (int i = 0; i < int32; i++) {
                strArr[i] = extractString8(int8Array, int32Array[i]);
            }
        } else {
            for (int i2 = 0; i2 < int32; i2++) {
                strArr[i2] = extractString16(int8Array, int32Array[i2]);
            }
        }
        if (int325 != 0) {
            this.f4702is.checkPos(pos + int325, "Expected styles start");
        }
        this.f4702is.skipToPos(uInt32, "Skip string pool padding");
        return strArr;
    }
}
