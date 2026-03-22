package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;

/* JADX INFO: renamed from: com.a.b.f.b.ab */
/* JADX INFO: loaded from: classes.dex */
public final class C0747ab extends AbstractC0753e {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0807e f1624a;

    public C0747ab(C0771w c0771w, C0774z c0774z, C0768t c0768t, InterfaceC0807e interfaceC0807e, AbstractC0775a abstractC0775a) {
        super(c0771w, c0774z, null, c0768t, abstractC0775a);
        if (c0771w.m1577d() != 6) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        if (interfaceC0807e == null) {
            throw new NullPointerException("catches == null");
        }
        this.f1624a = interfaceC0807e;
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1465a(C0766r c0766r, C0768t c0768t) {
        return new C0747ab(m1490f(), m1491g(), c0768t, this.f1624a, m1486g_());
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1466a(C0805c c0805c) {
        return new C0747ab(m1490f(), m1491g(), m1494j(), this.f1624a.mo757a(c0805c), m1486g_());
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0753e, com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final String mo1467a() {
        AbstractC0775a abstractC0775aG_ = m1486g_();
        return (abstractC0775aG_ instanceof C0801y ? ((C0801y) abstractC0775aG_).m1648i() : abstractC0775aG_.mo657d()) + " " + C0748ac.m1472a(this.f1624a);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final void mo1468a(InterfaceC0759k interfaceC0759k) {
        interfaceC0759k.mo892a(this);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: b */
    public final InterfaceC0807e mo1470b() {
        return this.f1624a;
    }
}
