package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p039c.C0801y;

/* JADX INFO: renamed from: com.a.b.f.b.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0761m implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0801y f1653a;

    /* JADX INFO: renamed from: b */
    private final C0801y f1654b;

    private C0761m(C0801y c0801y, C0801y c0801y2) {
        this.f1653a = c0801y;
        this.f1654b = c0801y2;
    }

    /* JADX INFO: renamed from: a */
    public static C0761m m1502a(C0801y c0801y, C0801y c0801y2) {
        if (c0801y == null && c0801y2 == null) {
            return null;
        }
        return new C0761m(c0801y, c0801y2);
    }

    /* JADX INFO: renamed from: b */
    private static int m1503b(C0801y c0801y, C0801y c0801y2) {
        if (c0801y == c0801y2) {
            return 0;
        }
        if (c0801y == null) {
            return -1;
        }
        if (c0801y2 == null) {
            return 1;
        }
        return c0801y.compareTo(c0801y2);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0761m c0761m) {
        int iM1503b = m1503b(this.f1653a, c0761m.f1653a);
        return iM1503b != 0 ? iM1503b : m1503b(this.f1654b, c0761m.f1654b);
    }

    /* JADX INFO: renamed from: a */
    public final C0801y m1505a() {
        return this.f1653a;
    }

    /* JADX INFO: renamed from: b */
    public final C0801y m1506b() {
        return this.f1654b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0761m) && compareTo((C0761m) obj) == 0;
    }

    public final int hashCode() {
        return ((this.f1653a == null ? 0 : this.f1653a.hashCode()) * 31) + (this.f1654b != null ? this.f1654b.hashCode() : 0);
    }

    public final String toString() {
        if (this.f1653a != null && this.f1654b == null) {
            return this.f1653a.m1648i();
        }
        if (this.f1653a == null && this.f1654b == null) {
            return "";
        }
        return "[" + (this.f1653a == null ? "" : this.f1653a.m1648i()) + "|" + (this.f1654b == null ? "" : this.f1654b.m1648i());
    }
}
