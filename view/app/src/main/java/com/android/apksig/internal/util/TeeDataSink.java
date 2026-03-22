package com.android.apksig.internal.util;

import com.android.apksig.util.DataSink;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class TeeDataSink implements DataSink {
    public final DataSink[] mSinks;

    public TeeDataSink(DataSink[] dataSinkArr) {
        this.mSinks = dataSinkArr;
    }

    @Override // com.android.apksig.util.DataSink
    public void consume(ByteBuffer byteBuffer) throws IOException {
        int iPosition = byteBuffer.position();
        for (int i = 0; i < this.mSinks.length; i++) {
            if (i > 0) {
                byteBuffer.position(iPosition);
            }
            this.mSinks[i].consume(byteBuffer);
        }
    }

    @Override // com.android.apksig.util.DataSink
    public void consume(byte[] bArr, int i, int i2) throws IOException {
        for (DataSink dataSink : this.mSinks) {
            dataSink.consume(bArr, i, i2);
        }
    }
}
