package com.p016a.p019b.p036f.p037a;

import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0886p;
import com.p016a.p019b.p043h.InterfaceC0889s;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.f.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0740a extends C0886p implements InterfaceC0889s, Comparable {

    /* JADX INFO: renamed from: a */
    private final C0802z f1605a;

    /* JADX INFO: renamed from: b */
    private final EnumC0741b f1606b;

    /* JADX INFO: renamed from: c */
    private final TreeMap f1607c;

    public C0740a(C0802z c0802z, EnumC0741b enumC0741b) {
        if (c0802z == null) {
            throw new NullPointerException("type == null");
        }
        if (enumC0741b == null) {
            throw new NullPointerException("visibility == null");
        }
        this.f1605a = c0802z;
        this.f1606b = enumC0741b;
        this.f1607c = new TreeMap();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0740a c0740a) {
        int iA = this.f1605a.compareTo(c0740a.f1605a);
        if (iA != 0) {
            return iA;
        }
        int iCompareTo = this.f1606b.compareTo(c0740a.f1606b);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        Iterator it = this.f1607c.values().iterator();
        Iterator it2 = c0740a.f1607c.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompareTo2 = ((C0744e) it.next()).compareTo((C0744e) it2.next());
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
        }
        if (it.hasNext()) {
            return 1;
        }
        return it2.hasNext() ? -1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m1438a(C0744e c0744e) {
        m2004l();
        this.f1607c.put(c0744e.m1455a(), c0744e);
    }

    /* JADX INFO: renamed from: b */
    public final C0802z m1439b() {
        return this.f1605a;
    }

    /* JADX INFO: renamed from: b */
    public final void m1440b(C0744e c0744e) {
        m2004l();
        if (c0744e == null) {
            throw new NullPointerException("pair == null");
        }
        C0801y c0801yM1455a = c0744e.m1455a();
        if (this.f1607c.get(c0801yM1455a) != null) {
            throw new IllegalArgumentException("name already added: " + c0801yM1455a);
        }
        this.f1607c.put(c0801yM1455a, c0744e);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1606b.mo657d());
        sb.append("-annotation ");
        sb.append(this.f1605a.mo657d());
        sb.append(" {");
        boolean z = true;
        for (C0744e c0744e : this.f1607c.values()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(c0744e.m1455a().mo657d());
            sb.append(": ");
            sb.append(c0744e.m1456b().mo657d());
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public final EnumC0741b m1441e() {
        return this.f1606b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0740a)) {
            return false;
        }
        C0740a c0740a = (C0740a) obj;
        if (this.f1605a.equals(c0740a.f1605a) && this.f1606b == c0740a.f1606b) {
            return this.f1607c.equals(c0740a.f1607c);
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public final Collection m1442f() {
        return Collections.unmodifiableCollection(this.f1607c.values());
    }

    public final int hashCode() {
        return (((this.f1605a.hashCode() * 31) + this.f1607c.hashCode()) * 31) + this.f1606b.hashCode();
    }

    public final String toString() {
        return mo657d();
    }
}
