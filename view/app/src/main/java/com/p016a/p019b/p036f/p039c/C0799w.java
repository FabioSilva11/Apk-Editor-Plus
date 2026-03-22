package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0799w extends AbstractC0775a {

    /* JADX INFO: renamed from: a */
    public static final C0799w f1932a = new C0799w(new C0801y("TYPE"), new C0801y("Ljava/lang/Class;"));

    /* JADX INFO: renamed from: b */
    private final C0801y f1933b;

    /* JADX INFO: renamed from: c */
    private final C0801y f1934c;

    public C0799w(C0801y c0801y, C0801y c0801y2) {
        if (c0801y == null) {
            throw new NullPointerException("name == null");
        }
        if (c0801y2 == null) {
            throw new NullPointerException("descriptor == null");
        }
        this.f1933b = c0801y;
        this.f1934c = c0801y2;
    }

    /* JADX INFO: renamed from: a */
    public final C0801y m1638a() {
        return this.f1933b;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        C0799w c0799w = (C0799w) abstractC0775a;
        int iA = this.f1933b.compareTo(c0799w.f1933b);
        return iA != 0 ? iA : this.f1934c.compareTo(c0799w.f1934c);
    }

    /* JADX INFO: renamed from: b */
    public final C0801y m1639b() {
        return this.f1934c;
    }

    /* JADX INFO: renamed from: c */
    public final C0805c m1640c() {
        return C0805c.m1679a(this.f1934c.m1649j());
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1933b.mo657d() + ':' + this.f1934c.mo657d();
    }

    /* JADX INFO: renamed from: e */
    public final boolean m1641e() {
        return this.f1933b.m1649j().equals("<init>");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0799w)) {
            return false;
        }
        C0799w c0799w = (C0799w) obj;
        return this.f1933b.equals(c0799w.f1933b) && this.f1934c.equals(c0799w.f1934c);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m1642f() {
        return this.f1933b.m1649j().equals("<clinit>");
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: g */
    public final boolean mo1603g() {
        return false;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "nat";
    }

    public final int hashCode() {
        return (this.f1933b.hashCode() * 31) ^ this.f1934c.hashCode();
    }

    public final String toString() {
        return "nat{" + mo657d() + '}';
    }
}
