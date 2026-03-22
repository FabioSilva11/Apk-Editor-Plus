package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0787k extends AbstractC0797u {

    /* JADX INFO: renamed from: a */
    private C0788l f1912a;

    public C0787k(C0799w c0799w) {
        super(new C0802z(c0799w.m1640c()), c0799w);
        this.f1912a = null;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return m1636k().m1655i();
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "enum";
    }

    /* JADX INFO: renamed from: i */
    public final C0788l m1626i() {
        if (this.f1912a == null) {
            this.f1912a = new C0788l(m1636k(), m1637l());
        }
        return this.f1912a;
    }
}
