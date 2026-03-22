package com.gmail.heagoo.p054a.p058b;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

/* JADX INFO: renamed from: com.gmail.heagoo.a.b.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0976b {
    /* JADX INFO: renamed from: a */
    public static void m2160a(OutputStream outputStream, int i) throws IOException {
        if (i <= 127) {
            outputStream.write(i);
            return;
        }
        byte[] byteArray = BigInteger.valueOf(i).toByteArray();
        if (byteArray[0] == 0) {
            outputStream.write((byteArray.length - 1) | 128);
            outputStream.write(byteArray, 1, byteArray.length - 1);
        } else {
            outputStream.write(byteArray.length | 128);
            outputStream.write(byteArray);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo2158a();

    /* JADX INFO: renamed from: a */
    public abstract void mo2159a(OutputStream outputStream);

    /* JADX INFO: renamed from: b */
    public final int m2161b() {
        int length;
        int iMo2158a = mo2158a();
        if (iMo2158a > 127) {
            byte[] byteArray = BigInteger.valueOf(iMo2158a).toByteArray();
            length = byteArray[0] == 0 ? byteArray.length : byteArray.length + 1;
        } else {
            length = 1;
        }
        return length + 1 + mo2158a();
    }
}
