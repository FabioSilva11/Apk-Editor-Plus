package com.gmail.heagoo.p054a.p058b;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

/* JADX INFO: renamed from: com.gmail.heagoo.a.b.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0978d extends AbstractC0976b {

    /* JADX INFO: renamed from: a */
    private byte[] f2466a;

    /* JADX INFO: renamed from: b */
    private BigInteger f2467b;

    public C0978d(int i) {
        this.f2467b = BigInteger.valueOf(1L);
        this.f2466a = this.f2467b.toByteArray();
    }

    public C0978d(BigInteger bigInteger) {
        this.f2467b = bigInteger;
        this.f2466a = this.f2467b.toByteArray();
    }

    /* JADX INFO: renamed from: c */
    private boolean m2162c() {
        return this.f2467b.signum() > 0 && (this.f2466a[0] & 128) != 0;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final int mo2158a() {
        return !m2162c() ? this.f2466a.length : this.f2466a.length + 1;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final void mo2159a(OutputStream outputStream) throws IOException {
        outputStream.write(2);
        m2160a(outputStream, mo2158a());
        if (m2162c()) {
            outputStream.write(0);
        }
        outputStream.write(this.f2466a);
    }
}
