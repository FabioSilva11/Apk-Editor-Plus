package com.gmail.heagoo.p054a.p058b;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.a.b.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0982h extends AbstractC0976b {

    /* JADX INFO: renamed from: a */
    private String f2470a;

    public C0982h(String str) {
        this.f2470a = str;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final int mo2158a() {
        return this.f2470a.length();
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final void mo2159a(OutputStream outputStream) throws IOException {
        outputStream.write(19);
        m2160a(outputStream, this.f2470a.length());
        outputStream.write(this.f2470a.getBytes());
    }
}
