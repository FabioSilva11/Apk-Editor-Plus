package com.p016a.p019b.p036f.p037a;

import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0801y;

/* JADX INFO: renamed from: com.a.b.f.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0744e implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0801y f1617a;

    /* JADX INFO: renamed from: b */
    private final AbstractC0775a f1618b;

    public C0744e(C0801y c0801y, AbstractC0775a abstractC0775a) {
        if (c0801y == null) {
            throw new NullPointerException("name == null");
        }
        if (abstractC0775a == null) {
            throw new NullPointerException("value == null");
        }
        this.f1617a = c0801y;
        this.f1618b = abstractC0775a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0744e c0744e) {
        int iA = this.f1617a.compareTo(c0744e.f1617a);
        return iA != 0 ? iA : this.f1618b.compareTo(c0744e.f1618b);
    }

    /* JADX INFO: renamed from: a */
    public final C0801y m1455a() {
        return this.f1617a;
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0775a m1456b() {
        return this.f1618b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0744e)) {
            return false;
        }
        C0744e c0744e = (C0744e) obj;
        return this.f1617a.equals(c0744e.f1617a) && this.f1618b.equals(c0744e.f1618b);
    }

    public final int hashCode() {
        return (this.f1617a.hashCode() * 31) + this.f1618b.hashCode();
    }

    public final String toString() {
        return this.f1617a.mo657d() + ":" + this.f1618b;
    }
}
