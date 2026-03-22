package com.p016a.p019b.p028c.p030b;

import java.util.HashSet;

/* JADX INFO: renamed from: com.a.b.c.b.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0585j {

    /* JADX INFO: renamed from: a */
    private final int f780a;

    /* JADX INFO: renamed from: b */
    private C0563aa f781b;

    /* JADX INFO: renamed from: c */
    private InterfaceC0578c f782c;

    /* JADX INFO: renamed from: d */
    private C0581f f783d;

    /* JADX INFO: renamed from: e */
    private C0564ab f784e;

    /* JADX INFO: renamed from: f */
    private C0594s f785f;

    /* JADX INFO: renamed from: g */
    private C0588m f786g;

    public C0585j(int i, C0563aa c0563aa, InterfaceC0578c interfaceC0578c) {
        if (c0563aa == null) {
            throw new NullPointerException("unprocessedInsns == null");
        }
        this.f780a = i;
        this.f781b = c0563aa;
        this.f782c = interfaceC0578c;
        this.f783d = null;
        this.f784e = null;
        this.f785f = null;
        this.f786g = null;
    }

    /* JADX INFO: renamed from: j */
    private void m940j() {
        if (this.f786g != null) {
            return;
        }
        this.f786g = this.f781b.m873d();
        this.f784e = C0564ab.m874a(this.f786g, this.f780a);
        this.f785f = C0594s.m1005a(this.f786g);
        this.f783d = this.f782c.mo903a();
        this.f781b = null;
        this.f782c = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m941a(InterfaceC0586k interfaceC0586k) {
        this.f781b.m868a(interfaceC0586k);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m942a() {
        return this.f780a != 1 && this.f781b.m870a();
    }

    /* JADX INFO: renamed from: b */
    public final boolean m943b() {
        return this.f781b.m871b();
    }

    /* JADX INFO: renamed from: c */
    public final boolean m944c() {
        return this.f782c.mo904b();
    }

    /* JADX INFO: renamed from: d */
    public final HashSet m945d() {
        return this.f782c.mo905c();
    }

    /* JADX INFO: renamed from: e */
    public final HashSet m946e() {
        return this.f781b.m872c();
    }

    /* JADX INFO: renamed from: f */
    public final C0588m m947f() {
        m940j();
        return this.f786g;
    }

    /* JADX INFO: renamed from: g */
    public final C0581f m948g() {
        m940j();
        return this.f783d;
    }

    /* JADX INFO: renamed from: h */
    public final C0564ab m949h() {
        m940j();
        return this.f784e;
    }

    /* JADX INFO: renamed from: i */
    public final C0594s m950i() {
        m940j();
        return this.f785f;
    }
}
