package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p039c.AbstractC0775a;

/* JADX INFO: renamed from: com.a.b.f.b.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0753e extends AbstractC0757i {

    /* JADX INFO: renamed from: a */
    private final AbstractC0775a f1628a;

    public AbstractC0753e(C0771w c0771w, C0774z c0774z, C0766r c0766r, C0768t c0768t, AbstractC0775a abstractC0775a) {
        super(c0771w, c0774z, c0766r, c0768t);
        if (abstractC0775a == null) {
            throw new NullPointerException("cst == null");
        }
        this.f1628a = abstractC0775a;
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public String mo1467a() {
        return this.f1628a.mo657d();
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final boolean mo1469a(AbstractC0757i abstractC0757i) {
        return super.mo1469a(abstractC0757i) && this.f1628a.equals(((AbstractC0753e) abstractC0757i).f1628a);
    }

    /* JADX INFO: renamed from: g_ */
    public final AbstractC0775a m1486g_() {
        return this.f1628a;
    }
}
