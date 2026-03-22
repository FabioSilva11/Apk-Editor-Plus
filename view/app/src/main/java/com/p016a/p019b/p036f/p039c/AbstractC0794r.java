package com.p016a.p019b.p036f.p039c;

/* JADX INFO: renamed from: com.a.b.f.c.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0794r extends AbstractC0795s {

    /* JADX INFO: renamed from: a */
    private final long f1927a;

    AbstractC0794r(long j) {
        this.f1927a = j;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        long j = ((AbstractC0794r) abstractC0775a).f1927a;
        if (this.f1927a < j) {
            return -1;
        }
        return this.f1927a > j ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.f1927a == ((AbstractC0794r) obj).f1927a;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: g */
    public final boolean mo1603g() {
        return true;
    }

    public final int hashCode() {
        return ((int) this.f1927a) ^ ((int) (this.f1927a >> 32));
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0795s
    /* JADX INFO: renamed from: i */
    public final boolean mo1631i() {
        return ((long) ((int) this.f1927a)) == this.f1927a;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0795s
    /* JADX INFO: renamed from: j */
    public final int mo1632j() {
        return (int) this.f1927a;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0795s
    /* JADX INFO: renamed from: k */
    public final long mo1633k() {
        return this.f1927a;
    }
}
