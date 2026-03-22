package com.android.apksig.internal.util;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class ByteBufferUtils {
    public static byte[] toByteArray(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }
}
