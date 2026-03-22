package com.p016a.p019b.p035e;

import com.p016a.p019b.p033d.InterfaceC0714c;
import com.p016a.p019b.p033d.p034a.AbstractC0692f;

/* JADX INFO: renamed from: com.a.b.e.p */
/* JADX INFO: loaded from: classes.dex */
final class C0733p implements InterfaceC0714c {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0732o f1596a;

    private C0733p(C0732o c0732o) {
        this.f1596a = c0732o;
    }

    /* synthetic */ C0733p(C0732o c0732o, byte b2) {
        this(c0732o);
    }

    @Override // com.p016a.p019b.p033d.InterfaceC0714c
    /* JADX INFO: renamed from: a */
    public final void mo1335a(AbstractC0692f abstractC0692f) {
        int iM1409c = this.f1596a.f1592a.m1409c(abstractC0692f.m1299d());
        C0732o.m1426a(abstractC0692f.m1295b() == 27, iM1409c);
        this.f1596a.f1594c[C0732o.m1428b(this.f1596a)] = abstractC0692f.mo1263d(iM1409c);
    }
}
