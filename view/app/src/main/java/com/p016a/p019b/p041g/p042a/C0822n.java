package com.p016a.p019b.p041g.p042a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p036f.p038b.C0751c;
import com.p016a.p019b.p036f.p038b.C0760l;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p041g.AbstractC0831ag;
import com.p016a.p019b.p041g.AbstractC0836al;
import com.p016a.p019b.p041g.C0808a;
import com.p016a.p019b.p041g.C0833ai;
import com.p016a.p019b.p041g.C0838an;
import com.p016a.p019b.p041g.InterfaceC0835ak;
import com.p016a.p019b.p043h.C0880j;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.g.a.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0822n {

    /* JADX INFO: renamed from: a */
    private final C0838an f2081a;

    /* JADX INFO: renamed from: b */
    private final boolean f2082b;

    /* JADX INFO: renamed from: c */
    private final C0817i f2083c;

    private C0822n(C0838an c0838an, boolean z) {
        this.f2082b = z;
        this.f2081a = c0838an;
        this.f2083c = C0818j.m1739a(c0838an);
    }

    /* JADX INFO: renamed from: a */
    private C0751c m1745a() {
        int i;
        C0880j c0880j;
        int i2 = 0;
        ArrayList arrayListM1864j = this.f2081a.m1864j();
        C0833ai c0833aiM1860f = this.f2081a.m1860f();
        this.f2081a.m1866l();
        C0751c c0751c = new C0751c(this.f2081a.m1865k() - ((c0833aiM1860f == null || !c0833aiM1860f.m1820r()) ? 0 : 1));
        Iterator it = arrayListM1864j.iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                if (c0833aiM1860f == null || c0833aiM1860f.m1801c().size() == 0) {
                    return c0751c;
                }
                throw new RuntimeException("Exit block must have no insns when leaving SSA form");
            }
            C0833ai c0833ai = (C0833ai) it.next();
            if (!c0833ai.m1820r() || c0833ai == c0833aiM1860f) {
                i2 = i3;
            } else {
                int i4 = i3 + 1;
                C0880j c0880jM1815m = c0833ai.m1815m();
                int iM1813k = c0833ai.m1813k();
                C0833ai c0833aiM1860f2 = this.f2081a.m1860f();
                if (!c0880jM1815m.m1998h(c0833aiM1860f2 == null ? -1 : c0833aiM1860f2.m1808f())) {
                    i = iM1813k;
                    c0880j = c0880jM1815m;
                } else {
                    if (c0880jM1815m.m1985b() > 1) {
                        throw new RuntimeException("Exit predecessor must have no other successors" + C0985a.m2296v(c0833ai.m1808f()));
                    }
                    c0880j = C0880j.f2245a;
                    C0771w c0771wMo1765c = ((AbstractC0836al) c0833ai.m1801c().get(r1.size() - 1)).mo1765c();
                    if (c0771wMo1765c.m1577d() != 2 && c0771wMo1765c != C0773y.f1804bi) {
                        throw new RuntimeException("Exit predecessor must end in valid exit statement.");
                    }
                    i = -1;
                }
                c0880j.mo549b_();
                c0751c.m1476a(i3, new C0745a(c0833ai.m1808f(), m1746a(c0833ai.m1801c()), c0880j, i));
                i2 = i4;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static C0760l m1746a(ArrayList arrayList) {
        int size = arrayList.size();
        C0760l c0760l = new C0760l(size);
        for (int i = 0; i < size; i++) {
            c0760l.m1498a(i, ((AbstractC0836al) arrayList.get(i)).mo1764b());
        }
        c0760l.mo549b_();
        return c0760l;
    }

    /* JADX INFO: renamed from: a */
    public static C0772x m1747a(C0838an c0838an, boolean z) {
        C0822n c0822n = new C0822n(c0838an, z);
        AbstractC0831ag abstractC0831agMo1726a = new C0809a(c0822n.f2081a, c0822n.f2083c, c0822n.f2082b).mo1726a();
        c0822n.f2081a.m1870p();
        c0822n.f2081a.m1841a(abstractC0831agMo1726a);
        ArrayList<C0833ai> arrayListM1864j = c0822n.f2081a.m1864j();
        for (C0833ai c0833ai : arrayListM1864j) {
            c0833ai.m1794a(new C0824p(arrayListM1864j));
            c0833ai.m1798b();
        }
        Iterator it = arrayListM1864j.iterator();
        while (it.hasNext()) {
            ((C0833ai) it.next()).m1821s();
        }
        int iM1862h = c0822n.f2081a.m1862h();
        C0808a c0808a = new C0808a(c0822n.f2081a.m1861g());
        int iM1861g = c0822n.f2081a.m1861g();
        for (int i = 0; i < iM1861g; i++) {
            if (i < iM1862h) {
                c0808a.mo1701a(i, (iM1861g - iM1862h) + i, 1);
            } else {
                c0808a.mo1701a(i, i - iM1862h, 1);
            }
        }
        c0822n.f2081a.m1841a(c0808a);
        c0822n.f2081a.m1849a(false, (InterfaceC0835ak) new C0823o(c0822n, c0822n.f2081a.m1864j()));
        return new C0816h(new C0772x(c0822n.m1745a(), c0822n.f2081a.m1839a(c0822n.f2081a.m1854c()))).m1736a();
    }
}
