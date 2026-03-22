package com.gmail.heagoo.p054a.p058b;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.a.b.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0980f extends AbstractC0976b {

    /* JADX INFO: renamed from: a */
    private int[] f2468a;

    public C0980f(String str) {
        String[] strArrSplit = str.split("\\.");
        this.f2468a = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            this.f2468a[i] = Integer.parseInt(strArrSplit[i]);
        }
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final int mo2158a() {
        int i = 1;
        if (this.f2468a.length < 2 || this.f2468a[0] < 0 || this.f2468a[0] > 2 || this.f2468a[1] < 0 || this.f2468a[1] > 39) {
            throw new IllegalArgumentException("Object identifier out of range");
        }
        for (int i2 = 2; i2 < this.f2468a.length; i2++) {
            i = this.f2468a[i2] > 16384 ? i + 3 : this.f2468a[i2] > 128 ? i + 2 : i + 1;
        }
        return i;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final void mo2159a(OutputStream outputStream) throws IOException {
        int i;
        int i2;
        int i3 = 1;
        outputStream.write(6);
        int iMo2158a = mo2158a();
        m2160a(outputStream, mo2158a());
        byte[] bArr = new byte[iMo2158a];
        bArr[0] = (byte) ((this.f2468a[0] * 40) + this.f2468a[1]);
        for (int i4 = 2; i4 < this.f2468a.length; i4++) {
            int i5 = this.f2468a[i4];
            if (i5 >= 16384) {
                i = i3 + 1;
                bArr[i3] = (byte) ((i5 >> 14) | 128);
                i2 = i5 & 16383;
            } else {
                i = i3;
                i2 = i5;
            }
            if (i2 >= 128) {
                bArr[i] = (byte) ((i2 >> 7) | 128);
                i2 &= 127;
                i++;
            }
            int i6 = i2;
            i3 = i + 1;
            bArr[i] = (byte) i6;
        }
        outputStream.write(bArr);
    }
}
