package com.gmail.heagoo.p054a.p058b;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.a.b.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0977c extends AbstractC0976b {

    /* JADX INFO: renamed from: a */
    private String f2465a;

    public C0977c(String str) {
        this.f2465a = str;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final int mo2158a() {
        return this.f2465a.length();
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final void mo2159a(OutputStream outputStream) throws IOException {
        outputStream.write(22);
        m2160a(outputStream, this.f2465a.length());
        outputStream.write(this.f2465a.getBytes());
    }
}
