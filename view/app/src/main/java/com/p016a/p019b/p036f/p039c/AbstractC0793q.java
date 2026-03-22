package com.p016a.p019b.p036f.p039c;

/* JADX INFO: renamed from: com.a.b.f.c.q */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0793q extends AbstractC0795s {

    /* JADX INFO: renamed from: a */
    private final int f1926a;

    AbstractC0793q(int i) {
        this.f1926a = i;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        int i = ((AbstractC0793q) abstractC0775a).f1926a;
        if (this.f1926a < i) {
            return -1;
        }
        return this.f1926a > i ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.f1926a == ((AbstractC0793q) obj).f1926a;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: g */
    public final boolean mo1603g() {
        return false;
    }

    public final int hashCode() {
        return this.f1926a;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0795s
    /* JADX INFO: renamed from: i */
    public final boolean mo1631i() {
        return true;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0795s
    /* JADX INFO: renamed from: j */
    public final int mo1632j() {
        return this.f1926a;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0795s
    /* JADX INFO: renamed from: k */
    public final long mo1633k() {
        return this.f1926a;
    }
}
