package com.p016a.p019b.p041g;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.InterfaceC0749ad;

/* JADX INFO: renamed from: com.a.b.g.t */
/* JADX INFO: loaded from: classes.dex */
final class C0864t implements InterfaceC0837am {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ InterfaceC0749ad f2208a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0863s f2209b;

    C0864t(C0863s c0863s, InterfaceC0749ad interfaceC0749ad) {
        this.f2209b = c0863s;
        this.f2208a = interfaceC0749ad;
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1728a(C0827ac c0827ac) {
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1729a(C0870z c0870z) {
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: b */
    public final void mo1730b(C0870z c0870z) {
        C0771w c0771wM1490f = c0870z.mo1766e().m1490f();
        C0768t c0768tMo1756a = c0870z.mo1756a();
        if (!C0863s.m1928a(this.f2209b, c0870z) && c0768tMo1756a.m1977d_() == 2) {
            if (c0771wM1490f.m1577d() == 4) {
                if (C0863s.m1927a(c0768tMo1756a.m1553b(0))) {
                    this.f2209b.m1926a(c0870z, c0768tMo1756a.m1558f(), C0985a.m2292r(c0771wM1490f.m1574a()), null);
                    return;
                } else {
                    if (C0863s.m1927a(c0768tMo1756a.m1553b(1))) {
                        this.f2209b.m1926a(c0870z, c0768tMo1756a.m1559g(), c0771wM1490f.m1574a(), null);
                        return;
                    }
                    return;
                }
            }
            if (this.f2208a.mo1473a(c0771wM1490f, c0768tMo1756a.m1553b(0), c0768tMo1756a.m1553b(1))) {
                c0870z.m1941g();
            } else if (c0771wM1490f.m1579f() && this.f2208a.mo1473a(c0771wM1490f, c0768tMo1756a.m1553b(1), c0768tMo1756a.m1553b(0))) {
                c0870z.m1940a(C0768t.m1547a(c0768tMo1756a.m1553b(1), c0768tMo1756a.m1553b(0)));
                c0870z.m1941g();
            }
        }
    }
}
