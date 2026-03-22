package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0777ab;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.g.ah */
/* JADX INFO: loaded from: classes.dex */
public final class C0832ah {

    /* JADX INFO: renamed from: a */
    private C0838an f2101a;

    /* JADX INFO: renamed from: b */
    private int f2102b;

    /* JADX INFO: renamed from: c */
    private int[] f2103c;

    /* JADX INFO: renamed from: d */
    private AbstractC0775a[] f2104d;

    /* JADX INFO: renamed from: g */
    private BitSet f2107g;

    /* JADX INFO: renamed from: e */
    private ArrayList f2105e = new ArrayList();

    /* JADX INFO: renamed from: f */
    private ArrayList f2106f = new ArrayList();

    /* JADX INFO: renamed from: h */
    private ArrayList f2108h = new ArrayList();

    /* JADX INFO: renamed from: i */
    private ArrayList f2109i = new ArrayList();

    /* JADX INFO: renamed from: j */
    private ArrayList f2110j = new ArrayList();

    private C0832ah(C0838an c0838an) {
        this.f2101a = c0838an;
        this.f2102b = c0838an.m1861g();
        this.f2103c = new int[this.f2102b];
        this.f2104d = new AbstractC0775a[this.f2102b];
        this.f2107g = new BitSet(c0838an.m1864j().size());
        for (int i = 0; i < this.f2102b; i++) {
            this.f2103c[i] = 0;
            this.f2104d[i] = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1776a(int i, int i2) {
        if (i2 == 2) {
            Iterator it = this.f2101a.m1857d(i).iterator();
            while (it.hasNext()) {
                this.f2109i.add((AbstractC0836al) it.next());
            }
            return;
        }
        Iterator it2 = this.f2101a.m1857d(i).iterator();
        while (it2.hasNext()) {
            this.f2108h.add((AbstractC0836al) it2.next());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1777a(C0827ac c0827ac) {
        int iM1533g = c0827ac.m1831n().m1533g();
        if (this.f2103c[iM1533g] == 2) {
            return;
        }
        C0768t c0768tMo1756a = c0827ac.mo1756a();
        int iD_ = c0768tMo1756a.m1977d_();
        int i = 0;
        int i2 = 0;
        AbstractC0775a abstractC0775a = null;
        while (true) {
            if (i >= iD_) {
                break;
            }
            int iM1755a = c0827ac.m1755a(i);
            int iM1533g2 = c0768tMo1756a.m1553b(i).m1533g();
            int i3 = this.f2103c[iM1533g2];
            if (this.f2107g.get(iM1755a)) {
                if (i3 != 1) {
                    i2 = i3;
                    break;
                } else if (abstractC0775a == null) {
                    abstractC0775a = this.f2104d[iM1533g2];
                    i2 = 1;
                } else if (!this.f2104d[iM1533g2].equals(abstractC0775a)) {
                    i2 = 2;
                    break;
                }
            }
            i++;
        }
        if (m1781a(iM1533g, i2, abstractC0775a)) {
            m1776a(iM1533g, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1778a(C0833ai c0833ai) {
        if (this.f2107g.get(c0833ai.m1806e())) {
            this.f2106f.add(c0833ai);
        } else {
            this.f2105e.add(c0833ai);
            this.f2107g.set(c0833ai.m1806e());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m1779a(com.p016a.p019b.p041g.AbstractC0836al r12) {
        /*
            Method dump skipped, instruction units count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p019b.p041g.C0832ah.m1779a(com.a.b.g.al):void");
    }

    /* JADX INFO: renamed from: a */
    public static void m1780a(C0838an c0838an) {
        C0832ah c0832ah = new C0832ah(c0838an);
        c0832ah.m1778a(c0832ah.f2101a.m1856d());
        while (true) {
            if (c0832ah.f2105e.isEmpty() && c0832ah.f2106f.isEmpty() && c0832ah.f2108h.isEmpty() && c0832ah.f2109i.isEmpty()) {
                break;
            }
            while (!c0832ah.f2105e.isEmpty()) {
                for (AbstractC0836al abstractC0836al : ((C0833ai) c0832ah.f2105e.remove(c0832ah.f2105e.size() - 1)).m1801c()) {
                    if (abstractC0836al instanceof C0827ac) {
                        c0832ah.m1777a((C0827ac) abstractC0836al);
                    } else {
                        c0832ah.m1779a(abstractC0836al);
                    }
                }
            }
            while (!c0832ah.f2106f.isEmpty()) {
                for (AbstractC0836al abstractC0836al2 : ((C0833ai) c0832ah.f2106f.remove(c0832ah.f2106f.size() - 1)).m1801c()) {
                    if (abstractC0836al2 instanceof C0827ac) {
                        c0832ah.m1777a((C0827ac) abstractC0836al2);
                    }
                }
            }
            while (!c0832ah.f2109i.isEmpty()) {
                AbstractC0836al abstractC0836al3 = (AbstractC0836al) c0832ah.f2109i.remove(c0832ah.f2109i.size() - 1);
                if (c0832ah.f2107g.get(abstractC0836al3.m1832o().m1806e())) {
                    if (abstractC0836al3 instanceof C0827ac) {
                        c0832ah.m1777a((C0827ac) abstractC0836al3);
                    } else {
                        c0832ah.m1779a(abstractC0836al3);
                    }
                }
            }
            while (!c0832ah.f2108h.isEmpty()) {
                AbstractC0836al abstractC0836al4 = (AbstractC0836al) c0832ah.f2108h.remove(c0832ah.f2108h.size() - 1);
                if (c0832ah.f2107g.get(abstractC0836al4.m1832o().m1806e())) {
                    if (abstractC0836al4 instanceof C0827ac) {
                        c0832ah.m1777a((C0827ac) abstractC0836al4);
                    } else {
                        c0832ah.m1779a(abstractC0836al4);
                    }
                }
            }
        }
        for (int i = 0; i < c0832ah.f2102b; i++) {
            if (c0832ah.f2103c[i] == 1 && (c0832ah.f2104d[i] instanceof AbstractC0777ab)) {
                AbstractC0836al abstractC0836alM1855c = c0832ah.f2101a.m1855c(i);
                if (!abstractC0836alM1855c.m1831n().m1534h().mo667f()) {
                    abstractC0836alM1855c.m1824b(abstractC0836alM1855c.m1831n().m1528a((AbstractC0777ab) c0832ah.f2104d[i]));
                    for (AbstractC0836al abstractC0836al5 : c0832ah.f2101a.m1857d(i)) {
                        if (!abstractC0836al5.mo1769k()) {
                            C0870z c0870z = (C0870z) abstractC0836al5;
                            C0768t c0768tMo1756a = abstractC0836al5.mo1756a();
                            int iM1555c = c0768tMo1756a.m1555c(i);
                            c0870z.m1939a(iM1555c, c0768tMo1756a.m1553b(iM1555c).m1528a((AbstractC0777ab) c0832ah.f2104d[i]));
                        }
                    }
                }
            }
        }
        for (AbstractC0836al abstractC0836al6 : c0832ah.f2110j) {
            C0833ai c0833aiM1832o = abstractC0836al6.m1832o();
            int iM1985b = c0833aiM1832o.m1811i().m1985b();
            int i2 = 0;
            int i3 = -1;
            while (i2 < iM1985b) {
                int iM1986b = c0833aiM1832o.m1811i().m1986b(i2);
                if (c0832ah.f2107g.get(iM1986b)) {
                    iM1986b = i3;
                }
                i2++;
                i3 = iM1986b;
            }
            if (iM1985b == 2 && i3 != -1) {
                c0833aiM1832o.m1800b(new C0765q(C0773y.f1889s, abstractC0836al6.mo1766e().m1491g(), (C0766r) null, C0768t.f1671a));
                c0833aiM1832o.m1799b(i3);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1781a(int i, int i2, AbstractC0775a abstractC0775a) {
        if (i2 != 1) {
            if (this.f2103c[i] == i2) {
                return false;
            }
            this.f2103c[i] = i2;
            return true;
        }
        if (this.f2103c[i] == i2 && this.f2104d[i].equals(abstractC0775a)) {
            return false;
        }
        this.f2103c[i] = i2;
        this.f2104d[i] = abstractC0775a;
        return true;
    }
}
