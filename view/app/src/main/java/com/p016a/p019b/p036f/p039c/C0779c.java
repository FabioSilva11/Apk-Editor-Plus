package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p036f.p037a.C0740a;

/* JADX INFO: renamed from: com.a.b.f.c.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0779c extends AbstractC0775a {

    /* JADX INFO: renamed from: a */
    private final C0740a f1902a;

    public C0779c(C0740a c0740a) {
        if (c0740a == null) {
            throw new NullPointerException("annotation == null");
        }
        c0740a.m2005m();
        this.f1902a = c0740a;
    }

    /* JADX INFO: renamed from: a */
    public final C0740a m1611a() {
        return this.f1902a;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        return this.f1902a.compareTo(((C0779c) abstractC0775a).f1902a);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1902a.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0779c) {
            return this.f1902a.equals(((C0779c) obj).f1902a);
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
        return "annotation";
    }

    public final int hashCode() {
        return this.f1902a.hashCode();
    }

    public final String toString() {
        return this.f1902a.toString();
    }
}
