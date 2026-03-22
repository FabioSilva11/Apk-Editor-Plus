package com.p050c.p051a;

/* JADX INFO: renamed from: com.c.a.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0948n implements InterfaceC0935a {

    /* JADX INFO: renamed from: b */
    private float f2393b;

    /* JADX INFO: renamed from: c */
    private float f2394c;

    /* JADX INFO: renamed from: f */
    private InterfaceC0949o f2397f;

    /* JADX INFO: renamed from: a */
    private boolean f2392a = true;

    /* JADX INFO: renamed from: d */
    private long f2395d = 100;

    /* JADX INFO: renamed from: e */
    private long f2396e = 0;

    /* JADX INFO: renamed from: a */
    public final void m2094a(InterfaceC0949o interfaceC0949o) {
        this.f2397f = interfaceC0949o;
    }

    @Override // com.p050c.p051a.InterfaceC0935a
    /* JADX INFO: renamed from: a */
    public final boolean mo2048a(C0940f c0940f, long j) {
        this.f2396e += j;
        if (this.f2392a) {
            this.f2392a = false;
            this.f2393b = c0940f.m2074f();
            this.f2394c = c0940f.m2075g();
        }
        if (this.f2396e >= this.f2395d) {
            if (this.f2397f == null) {
                return false;
            }
            this.f2397f.mo2093a(0.0f, 0.0f);
            return false;
        }
        float f = this.f2396e / this.f2395d;
        float f2 = ((0.0f - this.f2393b) * f) + this.f2393b;
        float f3 = (f * (0.0f - this.f2394c)) + this.f2394c;
        if (this.f2397f != null) {
            this.f2397f.mo2093a(f2, f3);
        }
        return true;
    }
}
