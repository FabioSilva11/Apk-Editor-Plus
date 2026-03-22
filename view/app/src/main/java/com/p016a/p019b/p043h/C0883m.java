package com.p016a.p019b.p043h;

/* JADX INFO: renamed from: com.a.b.h.m */
/* JADX INFO: loaded from: classes.dex */
public class C0883m extends C0877g {

    /* JADX INFO: renamed from: a */
    private final C0880j f2249a;

    public C0883m(int i) {
        super(i);
        this.f2249a = new C0880j(i);
    }

    public C0883m(C0883m c0883m) {
        super(c0883m.m1977d_());
        this.f2249a = c0883m.f2249a.m1995f();
        int iD_ = c0883m.m1977d_();
        for (int i = 0; i < iD_; i++) {
            Object objE = c0883m.m1978e(i);
            if (objE != null) {
                m1975a(i, objE);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m1999a(int i, InterfaceC0882l interfaceC0882l) {
        InterfaceC0882l interfaceC0882l2 = (InterfaceC0882l) m1979f(i);
        m1975a(i, (Object) interfaceC0882l);
        if (interfaceC0882l2 != null) {
            this.f2249a.m1987b(interfaceC0882l2.mo559a(), -1);
        }
        if (interfaceC0882l != null) {
            int iMo559a = interfaceC0882l.mo559a();
            int iM1985b = this.f2249a.m1985b();
            for (int i2 = 0; i2 <= iMo559a - iM1985b; i2++) {
                this.f2249a.m1988c(-1);
            }
            this.f2249a.m1987b(iMo559a, i);
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m2000c(int i) {
        if (i >= this.f2249a.m1985b()) {
            return -1;
        }
        return this.f2249a.m1986b(i);
    }

    @Override // com.p016a.p019b.p043h.C0877g
    /* JADX INFO: renamed from: i */
    public final void mo1980i() {
        super.mo1980i();
        int iD_ = m1977d_();
        for (int i = 0; i < iD_; i++) {
            InterfaceC0882l interfaceC0882l = (InterfaceC0882l) m1978e(i);
            if (interfaceC0882l != null) {
                this.f2249a.m1987b(interfaceC0882l.mo559a(), i);
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final int m2001j() {
        int iM1985b = this.f2249a.m1985b() - 1;
        while (iM1985b >= 0 && this.f2249a.m1986b(iM1985b) < 0) {
            iM1985b--;
        }
        int i = iM1985b + 1;
        this.f2249a.m1993e(i);
        return i;
    }
}
