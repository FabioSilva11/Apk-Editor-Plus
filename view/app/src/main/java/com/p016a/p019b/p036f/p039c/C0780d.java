package com.p016a.p019b.p036f.p039c;

/* JADX INFO: renamed from: com.a.b.f.c.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0780d extends AbstractC0775a {

    /* JADX INFO: renamed from: a */
    private final C0781e f1903a;

    public C0780d(C0781e c0781e) {
        c0781e.m2005m();
        this.f1903a = c0781e;
    }

    /* JADX INFO: renamed from: a */
    public final C0781e m1612a() {
        return this.f1903a;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        return this.f1903a.compareTo(((C0780d) abstractC0775a).f1903a);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1903a.m1976b("{", ", ", "}");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0780d) {
            return this.f1903a.equals(((C0780d) obj).f1903a);
        }
        return false;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: g */
    public final boolean mo1603g() {
        return false;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "array";
    }

    public final int hashCode() {
        return this.f1903a.hashCode();
    }

    public final String toString() {
        return this.f1903a.m1974a("array{", ", ", "}");
    }
}
