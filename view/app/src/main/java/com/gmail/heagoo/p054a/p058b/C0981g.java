package com.gmail.heagoo.p054a.p058b;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.a.b.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0981g extends AbstractC0976b {

    /* JADX INFO: renamed from: a */
    private byte[] f2469a;

    public C0981g(byte[] bArr) {
        this.f2469a = bArr;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final int mo2158a() {
        return this.f2469a.length;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final void mo2159a(OutputStream outputStream) throws IOException {
        outputStream.write(4);
        m2160a(outputStream, this.f2469a.length);
        outputStream.write(this.f2469a);
    }
}
