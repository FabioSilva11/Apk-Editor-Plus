package p000a.p001a.p003b.p004a;

import p000a.p001a.p003b.p004a.p005a.C0026w;

/* JADX INFO: renamed from: a.a.b.a.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0033g {

    /* JADX INFO: renamed from: a */
    private final C0034h f78a;

    /* JADX INFO: renamed from: b */
    private final C0032f f79b;

    /* JADX INFO: renamed from: c */
    private final C0026w f80c;

    public C0033g(C0034h c0034h, C0032f c0032f, C0026w c0026w) {
        this.f78a = c0034h;
        this.f79b = c0032f;
        this.f80c = c0026w;
    }

    /* JADX INFO: renamed from: a */
    public final String m71a() {
        return this.f79b.m69h().m80a() + this.f78a.m76a().m42a() + "/" + this.f79b.m67f();
    }

    /* JADX INFO: renamed from: a */
    public final void m72a(C0026w c0026w) {
        C0033g c0033g = new C0033g(this.f78a, this.f79b, c0026w);
        this.f78a.m78a(c0033g, true);
        this.f79b.m62a(c0033g, true);
    }

    /* JADX INFO: renamed from: b */
    public final C0034h m73b() {
        return this.f78a;
    }

    /* JADX INFO: renamed from: c */
    public final C0032f m74c() {
        return this.f79b;
    }

    /* JADX INFO: renamed from: d */
    public final C0026w m75d() {
        return this.f80c;
    }

    public final String toString() {
        return m71a();
    }
}
