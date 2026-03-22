package com.p016a.p019b.p043h;

import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.a.b.h.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0884n implements InterfaceC0881k {

    /* JADX INFO: renamed from: a */
    final C0880j f2250a = new C0880j();

    public C0884n() {
        this.f2250a.m1997g();
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: a */
    public final int mo1943a() {
        return this.f2250a.m1985b();
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: a */
    public final void mo1944a(int i) {
        int iM1996g = this.f2250a.m1996g(i);
        if (iM1996g < 0) {
            this.f2250a.m1989c(-(iM1996g + 1), i);
        }
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: a */
    public final void mo1945a(InterfaceC0881k interfaceC0881k) {
        int iM2262d = 0;
        if (!(interfaceC0881k instanceof C0884n)) {
            if (!(interfaceC0881k instanceof C0871a)) {
                InterfaceC0879i interfaceC0879iMo1946b = interfaceC0881k.mo1946b();
                while (interfaceC0879iMo1946b.mo1948a()) {
                    mo1944a(interfaceC0879iMo1946b.mo1949b());
                }
                return;
            } else {
                C0871a c0871a = (C0871a) interfaceC0881k;
                while (iM2262d >= 0) {
                    this.f2250a.m1988c(iM2262d);
                    iM2262d = C0985a.m2262d(c0871a.f2226a, iM2262d + 1);
                }
                this.f2250a.m1997g();
                return;
            }
        }
        C0884n c0884n = (C0884n) interfaceC0881k;
        int iM1985b = this.f2250a.m1985b();
        int iM1985b2 = c0884n.f2250a.m1985b();
        int i = 0;
        while (iM2262d < iM1985b2 && i < iM1985b) {
            while (iM2262d < iM1985b2 && c0884n.f2250a.m1986b(iM2262d) < this.f2250a.m1986b(i)) {
                mo1944a(c0884n.f2250a.m1986b(iM2262d));
                iM2262d++;
            }
            if (iM2262d == iM1985b2) {
                break;
            }
            while (i < iM1985b && c0884n.f2250a.m1986b(iM2262d) >= this.f2250a.m1986b(i)) {
                i++;
            }
        }
        while (iM2262d < iM1985b2) {
            mo1944a(c0884n.f2250a.m1986b(iM2262d));
            iM2262d++;
        }
        this.f2250a.m1997g();
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: b */
    public final InterfaceC0879i mo1946b() {
        return new C0885o(this);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: b */
    public final boolean mo1947b(int i) {
        return this.f2250a.m1994f(i) >= 0;
    }

    public final String toString() {
        return this.f2250a.toString();
    }
}
