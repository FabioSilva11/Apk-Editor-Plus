package com.gmail.heagoo.p054a.p058b;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.a.b.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0975a extends AbstractC0976b {

    /* JADX INFO: renamed from: a */
    private byte[] f2463a;

    /* JADX INFO: renamed from: b */
    private AbstractC0976b f2464b;

    public C0975a(AbstractC0976b abstractC0976b) {
        this.f2464b = abstractC0976b;
        this.f2463a = null;
    }

    public C0975a(byte[] bArr) {
        this.f2464b = null;
        this.f2463a = bArr;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final int mo2158a() {
        return this.f2464b == null ? this.f2463a.length : this.f2464b.m2161b();
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final void mo2159a(OutputStream outputStream) throws IOException {
        outputStream.write(160);
        m2160a(outputStream, mo2158a());
        if (this.f2464b == null) {
            outputStream.write(this.f2463a);
        } else {
            this.f2464b.mo2159a(outputStream);
        }
    }
}
