package com.android.apksig.internal.util;

import com.android.apksig.util.DataSink;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class MessageDigestSink implements DataSink {
    public final MessageDigest[] mMessageDigests;

    public MessageDigestSink(MessageDigest[] messageDigestArr) {
        this.mMessageDigests = messageDigestArr;
    }

    @Override // com.android.apksig.util.DataSink
    public void consume(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        for (MessageDigest messageDigest : this.mMessageDigests) {
            byteBuffer.position(iPosition);
            messageDigest.update(byteBuffer);
        }
    }

    @Override // com.android.apksig.util.DataSink
    public void consume(byte[] bArr, int i, int i2) {
        for (MessageDigest messageDigest : this.mMessageDigests) {
            messageDigest.update(bArr, i, i2);
        }
    }
}
