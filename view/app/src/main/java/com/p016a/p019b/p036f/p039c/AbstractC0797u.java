package com.p016a.p019b.p036f.p039c;

/* JADX INFO: renamed from: com.a.b.f.c.u */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0797u extends AbstractC0777ab {

    /* JADX INFO: renamed from: a */
    private final C0802z f1930a;

    /* JADX INFO: renamed from: b */
    private final C0799w f1931b;

    AbstractC0797u(C0802z c0802z, C0799w c0799w) {
        if (c0802z == null) {
            throw new NullPointerException("definingClass == null");
        }
        if (c0799w == null) {
            throw new NullPointerException("nat == null");
        }
        this.f1930a = c0802z;
        this.f1931b = c0799w;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected int mo1602b(AbstractC0775a abstractC0775a) {
        AbstractC0797u abstractC0797u = (AbstractC0797u) abstractC0775a;
        int iA = this.f1930a.compareTo(abstractC0797u.f1930a);
        return iA != 0 ? iA : this.f1931b.m1638a().compareTo(abstractC0797u.f1931b.m1638a());
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1930a.mo657d() + '.' + this.f1931b.mo657d();
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC0797u abstractC0797u = (AbstractC0797u) obj;
        return this.f1930a.equals(abstractC0797u.f1930a) && this.f1931b.equals(abstractC0797u.f1931b);
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: g */
    public final boolean mo1603g() {
        return false;
    }

    public final int hashCode() {
        return (this.f1930a.hashCode() * 31) ^ this.f1931b.hashCode();
    }

    /* JADX INFO: renamed from: k */
    public final C0802z m1636k() {
        return this.f1930a;
    }

    /* JADX INFO: renamed from: l */
    public final C0799w m1637l() {
        return this.f1931b;
    }

    public final String toString() {
        return mo1604h() + '{' + mo657d() + '}';
    }
}
