package com.p016a.p019b.p036f.p037a;

import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0886p;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.f.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0742c extends C0886p implements Comparable {

    /* JADX INFO: renamed from: a */
    public static final C0742c f1614a;

    /* JADX INFO: renamed from: b */
    private final TreeMap f1615b = new TreeMap();

    static {
        C0742c c0742c = new C0742c();
        f1614a = c0742c;
        c0742c.mo549b_();
    }

    /* JADX INFO: renamed from: a */
    public static C0742c m1444a(C0742c c0742c, C0740a c0740a) {
        C0742c c0742c2 = new C0742c();
        c0742c2.m1446b(c0742c);
        c0742c2.m1448a(c0740a);
        c0742c2.mo549b_();
        return c0742c2;
    }

    /* JADX INFO: renamed from: a */
    public static C0742c m1445a(C0742c c0742c, C0742c c0742c2) {
        C0742c c0742c3 = new C0742c();
        c0742c3.m1446b(c0742c);
        c0742c3.m1446b(c0742c2);
        c0742c3.mo549b_();
        return c0742c3;
    }

    /* JADX INFO: renamed from: b */
    private void m1446b(C0742c c0742c) {
        m2004l();
        if (c0742c == null) {
            throw new NullPointerException("toAdd == null");
        }
        Iterator it = c0742c.f1615b.values().iterator();
        while (it.hasNext()) {
            m1448a((C0740a) it.next());
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0742c c0742c) {
        Iterator it = this.f1615b.values().iterator();
        Iterator it2 = c0742c.f1615b.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iM1437a = ((C0740a) it.next()).compareTo((C0740a) it2.next());
            if (iM1437a != 0) {
                return iM1437a;
            }
        }
        if (it.hasNext()) {
            return 1;
        }
        return it2.hasNext() ? -1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m1448a(C0740a c0740a) {
        m2004l();
        if (c0740a == null) {
            throw new NullPointerException("annotation == null");
        }
        C0802z c0802zM1439b = c0740a.m1439b();
        if (this.f1615b.containsKey(c0802zM1439b)) {
            throw new IllegalArgumentException("duplicate type: " + c0802zM1439b.mo657d());
        }
        this.f1615b.put(c0802zM1439b, c0740a);
    }

    /* JADX INFO: renamed from: b */
    public final int m1449b() {
        return this.f1615b.size();
    }

    /* JADX INFO: renamed from: d */
    public final Collection m1450d() {
        return Collections.unmodifiableCollection(this.f1615b.values());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0742c) {
            return this.f1615b.equals(((C0742c) obj).f1615b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1615b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("annotations{");
        boolean z = true;
        for (C0740a c0740a : this.f1615b.values()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(c0740a.mo657d());
        }
        sb.append("}");
        return sb.toString();
    }
}
