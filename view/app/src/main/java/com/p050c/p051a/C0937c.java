package com.p050c.p051a;

/* JADX INFO: renamed from: com.c.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0937c implements InterfaceC0935a {

    /* JADX INFO: renamed from: a */
    private float f2313a;

    /* JADX INFO: renamed from: b */
    private float f2314b;

    /* JADX INFO: renamed from: c */
    private float f2315c = 0.95f;

    /* JADX INFO: renamed from: d */
    private float f2316d = 10.0f;

    /* JADX INFO: renamed from: e */
    private InterfaceC0938d f2317e;

    /* JADX INFO: renamed from: a */
    public final void m2053a(float f) {
        this.f2313a = f;
    }

    /* JADX INFO: renamed from: a */
    public final void m2054a(InterfaceC0938d interfaceC0938d) {
        this.f2317e = interfaceC0938d;
    }

    @Override // com.p050c.p051a.InterfaceC0935a
    /* JADX INFO: renamed from: a */
    public final boolean mo2048a(C0940f c0940f, long j) {
        float f = j / 1000.0f;
        float f2 = this.f2313a * f;
        float f3 = this.f2314b * f;
        this.f2313a *= this.f2315c;
        this.f2314b *= this.f2315c;
        boolean z = Math.abs(this.f2313a) > this.f2316d && Math.abs(this.f2314b) > this.f2316d;
        if (this.f2317e != null) {
            this.f2317e.mo2056a(f2, f3);
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    public final void m2055b(float f) {
        this.f2314b = f;
    }
}
