package com.android.apksig.internal.asn1;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Asn1OpaqueObject {
    public final ByteBuffer mEncoded;

    public Asn1OpaqueObject(ByteBuffer byteBuffer) {
        this.mEncoded = byteBuffer.slice();
    }

    public Asn1OpaqueObject(byte[] bArr) {
        this.mEncoded = ByteBuffer.wrap(bArr);
    }

    public ByteBuffer getEncoded() {
        return this.mEncoded.slice();
    }
}
