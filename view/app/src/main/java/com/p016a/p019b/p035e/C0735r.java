package com.p016a.p019b.p035e;

import com.p016a.p019b.p033d.InterfaceC0714c;
import com.p016a.p019b.p033d.p034a.AbstractC0692f;

/* JADX INFO: renamed from: com.a.b.e.r */
/* JADX INFO: loaded from: classes.dex */
final class C0735r implements InterfaceC0714c {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0732o f1598a;

    private C0735r(C0732o c0732o) {
        this.f1598a = c0732o;
    }

    /* synthetic */ C0735r(C0732o c0732o, byte b2) {
        this(c0732o);
    }

    @Override // com.p016a.p019b.p033d.InterfaceC0714c
    /* JADX INFO: renamed from: a */
    public final void mo1335a(AbstractC0692f abstractC0692f) {
        int iM1411d = this.f1598a.f1592a.m1411d(abstractC0692f.m1299d());
        C0732o.m1426a(abstractC0692f.m1295b() == 27, iM1411d);
        this.f1598a.f1594c[C0732o.m1428b(this.f1598a)] = abstractC0692f.mo1263d(iM1411d);
    }
}
