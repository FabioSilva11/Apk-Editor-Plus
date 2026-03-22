package com.p050c.p051a;

import android.graphics.PointF;

/* JADX INFO: renamed from: com.c.a.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0951q implements InterfaceC0935a {

    /* JADX INFO: renamed from: b */
    private float f2403b;

    /* JADX INFO: renamed from: c */
    private float f2404c;

    /* JADX INFO: renamed from: d */
    private float f2405d;

    /* JADX INFO: renamed from: e */
    private float f2406e;

    /* JADX INFO: renamed from: f */
    private float f2407f;

    /* JADX INFO: renamed from: g */
    private float f2408g;

    /* JADX INFO: renamed from: h */
    private float f2409h;

    /* JADX INFO: renamed from: k */
    private InterfaceC0952r f2412k;

    /* JADX INFO: renamed from: a */
    private boolean f2402a = true;

    /* JADX INFO: renamed from: i */
    private long f2410i = 200;

    /* JADX INFO: renamed from: j */
    private long f2411j = 0;

    /* JADX INFO: renamed from: a */
    public final void m2100a(float f) {
        this.f2403b = 2.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m2101a(InterfaceC0952r interfaceC0952r) {
        this.f2412k = interfaceC0952r;
    }

    @Override // com.p050c.p051a.InterfaceC0935a
    /* JADX INFO: renamed from: a */
    public final boolean mo2048a(C0940f c0940f, long j) {
        if (this.f2402a) {
            this.f2402a = false;
            this.f2404c = c0940f.m2074f();
            this.f2405d = c0940f.m2075g();
            this.f2406e = c0940f.m2073e();
            this.f2409h = (this.f2403b * this.f2406e) - this.f2406e;
            if (this.f2409h > 0.0f) {
                C0950p c0950p = new C0950p();
                c0950p.m2096a(new PointF(0.0f, 0.0f));
                c0950p.m2098b(new PointF(this.f2404c, this.f2405d));
                c0950p.m2099c();
                c0950p.f2398a = c0950p.m2097b() * this.f2403b;
                c0950p.m2095a();
                this.f2407f = c0950p.f2400c.x - this.f2404c;
                this.f2408g = c0950p.f2400c.y - this.f2405d;
            } else {
                this.f2407f = c0940f.m2077i() - this.f2404c;
                this.f2408g = c0940f.m2078j() - this.f2405d;
            }
        }
        this.f2411j += j;
        float f = this.f2411j / this.f2410i;
        if (f < 1.0f) {
            if (f > 0.0f) {
                float f2 = (this.f2409h * f) + this.f2406e;
                float f3 = (this.f2407f * f) + this.f2404c;
                float f4 = (f * this.f2408g) + this.f2405d;
                if (this.f2412k != null) {
                    this.f2412k.mo2092a(f2, f3, f4);
                }
            }
            return true;
        }
        float f5 = this.f2409h + this.f2406e;
        float f6 = this.f2407f + this.f2404c;
        float f7 = this.f2408g + this.f2405d;
        if (this.f2412k == null) {
            return false;
        }
        this.f2412k.mo2092a(f5, f6, f7);
        this.f2412k.mo2091a();
        return false;
    }
}
