package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0788l extends AbstractC0797u {
    public C0788l(C0802z c0802z, C0799w c0799w) {
        super(c0802z, c0799w);
    }

    /* JADX INFO: renamed from: a */
    public static C0788l m1627a(C0805c c0805c) {
        return new C0788l(C0802z.m1653a(c0805c), C0799w.f1932a);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return m1637l().m1640c();
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0797u, com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        int iMo1602b = super.mo1602b(abstractC0775a);
        return iMo1602b != 0 ? iMo1602b : m1637l().m1639b().compareTo(((C0788l) abstractC0775a).m1637l().m1639b());
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "field";
    }
}
