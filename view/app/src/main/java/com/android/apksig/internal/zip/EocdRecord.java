package com.android.apksig.internal.zip;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class EocdRecord {
    public static ByteBuffer createWithModifiedCentralDirectoryInfo(ByteBuffer byteBuffer, int i, long j, long j2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.put(byteBuffer.slice());
        byteBufferAllocate.flip();
        ZipUtils.setUnsignedInt16(byteBufferAllocate, 8, i);
        ZipUtils.setUnsignedInt16(byteBufferAllocate, 10, i);
        ZipUtils.setUnsignedInt32(byteBufferAllocate, 12, j);
        ZipUtils.setUnsignedInt32(byteBufferAllocate, 16, j2);
        return byteBufferAllocate;
    }
}
