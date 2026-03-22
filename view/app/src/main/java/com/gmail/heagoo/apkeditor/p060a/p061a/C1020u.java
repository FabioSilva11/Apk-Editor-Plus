package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.IOException;
import java.io.OutputStream;
import p000a.p001a.p003b.p004a.C0028b;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.u */
/* JADX INFO: loaded from: classes.dex */
final class C1020u {

    /* JADX INFO: renamed from: a */
    public int f2906a;

    /* JADX INFO: renamed from: b */
    private byte[] f2907b;

    C1020u() {
    }

    /* JADX INFO: renamed from: a */
    public final void m2723a(int i) {
        this.f2906a = i;
        byte[] bArr = this.f2907b;
        bArr[4] = (byte) i;
        bArr[5] = (byte) (i >> 8);
        bArr[6] = (byte) (i >> 16);
        bArr[7] = (byte) (i >>> 24);
    }

    /* JADX INFO: renamed from: a */
    public final void m2724a(C0028b c0028b) throws IOException {
        this.f2907b = new byte[8];
        c0028b.readFully(this.f2907b);
        byte[] bArr = this.f2907b;
        this.f2906a = (bArr[4] & 255) | (bArr[7] << 24) | ((bArr[6] & 255) << 16) | ((bArr[5] & 255) << 8);
    }

    /* JADX INFO: renamed from: a */
    public final void m2725a(OutputStream outputStream) throws IOException {
        outputStream.write(this.f2907b);
    }
}
