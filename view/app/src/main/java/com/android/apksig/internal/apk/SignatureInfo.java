package com.android.apksig.internal.apk;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class SignatureInfo {
    public final long apkSigningBlockOffset;
    public final long centralDirOffset;
    public final ByteBuffer eocd;
    public final long eocdOffset;
    public final ByteBuffer signatureBlock;

    public SignatureInfo(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
        this.signatureBlock = byteBuffer;
        this.apkSigningBlockOffset = j;
        this.centralDirOffset = j2;
        this.eocdOffset = j3;
        this.eocd = byteBuffer2;
    }
}
