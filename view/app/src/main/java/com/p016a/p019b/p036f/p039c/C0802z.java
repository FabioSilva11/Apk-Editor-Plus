package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p036f.p040d.C0805c;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.f.c.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0802z extends AbstractC0777ab {

    /* JADX INFO: renamed from: t */
    private final C0805c f1957t;

    /* JADX INFO: renamed from: u */
    private C0801y f1958u;

    /* JADX INFO: renamed from: j */
    private static final HashMap f1947j = new HashMap(100);

    /* JADX INFO: renamed from: a */
    public static final C0802z f1938a = m1654b(C0805c.f2023n);

    /* JADX INFO: renamed from: k */
    private static C0802z f1948k = m1654b(C0805c.f2027r);

    /* JADX INFO: renamed from: l */
    private static C0802z f1949l = m1654b(C0805c.f2028s);

    /* JADX INFO: renamed from: m */
    private static C0802z f1950m = m1654b(C0805c.f2029t);

    /* JADX INFO: renamed from: n */
    private static C0802z f1951n = m1654b(C0805c.f2030u);

    /* JADX INFO: renamed from: o */
    private static C0802z f1952o = m1654b(C0805c.f2031v);

    /* JADX INFO: renamed from: p */
    private static C0802z f1953p = m1654b(C0805c.f2033x);

    /* JADX INFO: renamed from: q */
    private static C0802z f1954q = m1654b(C0805c.f2032w);

    /* JADX INFO: renamed from: r */
    private static C0802z f1955r = m1654b(C0805c.f2034y);

    /* JADX INFO: renamed from: s */
    private static C0802z f1956s = m1654b(C0805c.f2035z);

    /* JADX INFO: renamed from: b */
    public static final C0802z f1939b = m1654b(C0805c.f2000A);

    /* JADX INFO: renamed from: c */
    public static final C0802z f1940c = m1654b(C0805c.f2001B);

    /* JADX INFO: renamed from: d */
    public static final C0802z f1941d = m1654b(C0805c.f2002C);

    /* JADX INFO: renamed from: e */
    public static final C0802z f1942e = m1654b(C0805c.f2003D);

    /* JADX INFO: renamed from: f */
    public static final C0802z f1943f = m1654b(C0805c.f2004E);

    /* JADX INFO: renamed from: g */
    public static final C0802z f1944g = m1654b(C0805c.f2006G);

    /* JADX INFO: renamed from: h */
    public static final C0802z f1945h = m1654b(C0805c.f2005F);

    /* JADX INFO: renamed from: i */
    public static final C0802z f1946i = m1654b(C0805c.f2008I);

    public C0802z(C0805c c0805c) {
        if (c0805c == null) {
            throw new NullPointerException("type == null");
        }
        if (c0805c == C0805c.f2019j) {
            throw new UnsupportedOperationException("KNOWN_NULL is not representable");
        }
        this.f1957t = c0805c;
        this.f1958u = null;
    }

    /* JADX INFO: renamed from: a */
    public static C0802z m1653a(C0805c c0805c) {
        switch (c0805c.mo665c()) {
            case 0:
                return f1956s;
            case 1:
                return f1948k;
            case 2:
                return f1949l;
            case 3:
                return f1950m;
            case 4:
                return f1951n;
            case 5:
                return f1952o;
            case 6:
                return f1954q;
            case 7:
                return f1953p;
            case 8:
                return f1955r;
            default:
                throw new IllegalArgumentException("not primitive: " + c0805c);
        }
    }

    /* JADX INFO: renamed from: b */
    public static C0802z m1654b(C0805c c0805c) {
        C0802z c0802z;
        synchronized (f1947j) {
            c0802z = (C0802z) f1947j.get(c0805c);
            if (c0802z == null) {
                c0802z = new C0802z(c0805c);
                f1947j.put(c0805c, c0802z);
            }
        }
        return c0802z;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2021l;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        return this.f1957t.m1685g().compareTo(((C0802z) abstractC0775a).f1957t.m1685g());
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1957t.mo657d();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0802z) && this.f1957t == ((C0802z) obj).f1957t;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: g */
    public final boolean mo1603g() {
        return false;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "type";
    }

    public final int hashCode() {
        return this.f1957t.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final C0805c m1655i() {
        return this.f1957t;
    }

    /* JADX INFO: renamed from: j */
    public final C0801y m1656j() {
        if (this.f1958u == null) {
            this.f1958u = new C0801y(this.f1957t.m1685g());
        }
        return this.f1958u;
    }

    public final String toString() {
        return "type{" + mo657d() + '}';
    }
}
