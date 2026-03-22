package com.gmail.heagoo.p054a.p059c;

import com.gmail.heagoo.neweditor.Token;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
class HexEncoding {
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

    private HexEncoding() {
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static String encode(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = bArr[i + i3];
            sb.append(HEX_DIGITS[(b2 >>> 4) & 15]);
            sb.append(HEX_DIGITS[b2 & Token.LITERAL3]);
        }
        return sb.toString();
    }

    public static String encodeRemaining(ByteBuffer byteBuffer) {
        return encode(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }
}
