package com.p016a.p019b.p041g;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0747ab;
import com.p016a.p019b.p036f.p038b.C0748ac;
import com.p016a.p019b.p036f.p038b.C0755g;
import com.p016a.p019b.p036f.p038b.C0756h;
import com.p016a.p019b.p036f.p038b.C0764p;
import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0777ab;
import com.p016a.p019b.p036f.p039c.AbstractC0795s;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.g.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0856l {

    /* JADX INFO: renamed from: a */
    private C0838an f2187a;

    /* JADX INFO: renamed from: b */
    private int f2188b;

    /* JADX INFO: renamed from: c */
    private ArrayList f2189c = new ArrayList();

    private C0856l(C0838an c0838an) {
        this.f2187a = c0838an;
        this.f2188b = c0838an.m1861g();
    }

    /* JADX INFO: renamed from: a */
    private int m1905a(C0766r c0766r) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.f2189c.size() || ((C0860p) this.f2189c.get(i)).f2195a.get(c0766r.m1533g())) {
                break;
            }
            i2 = i + 1;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private AbstractC0836al m1906a(AbstractC0836al abstractC0836al) {
        return (AbstractC0836al) ((C0833ai) this.f2187a.m1864j().get(abstractC0836al.m1832o().m1809g().nextSetBit(0))).m1801c().get(r0.size() - 1);
    }

    /* JADX INFO: renamed from: a */
    private void m1908a() {
        for (int i = 0; i < this.f2187a.m1861g(); i++) {
            AbstractC0836al abstractC0836alM1855c = this.f2187a.m1855c(i);
            if (abstractC0836alM1855c != null && abstractC0836alM1855c.mo1765c() != null && abstractC0836alM1855c.mo1765c().m1574a() == 2) {
                ArrayList[] arrayListArrM1868n = this.f2187a.m1868n();
                C0766r c0766rM1553b = abstractC0836alM1855c.mo1756a().m1553b(0);
                C0766r c0766rM1831n = abstractC0836alM1855c.m1831n();
                if (c0766rM1553b.m1533g() >= this.f2188b || c0766rM1831n.m1533g() >= this.f2188b) {
                    C0857m c0857m = new C0857m(this, c0766rM1831n, c0766rM1553b);
                    Iterator it = arrayListArrM1868n[c0766rM1831n.m1533g()].iterator();
                    while (it.hasNext()) {
                        ((AbstractC0836al) it.next()).mo1761a(c0857m);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x002a A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m1909a(com.p016a.p019b.p036f.p038b.C0766r r10, com.p016a.p019b.p041g.C0860p r11) {
        /*
            Method dump skipped, instruction units count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p019b.p041g.C0856l.m1909a(com.a.b.f.b.r, com.a.b.g.p):void");
    }

    /* JADX INFO: renamed from: a */
    private void m1910a(AbstractC0836al abstractC0836al, int i, ArrayList arrayList) {
        C0805c c0805cMo663a = abstractC0836al.m1831n().mo663a();
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC0775a abstractC0775aM2185a = C0985a.m2185a(c0805cMo663a.m1697s());
            C0766r c0766rM1516a = C0766r.m1516a(this.f2187a.m1869o(), (AbstractC0777ab) abstractC0775aM2185a);
            arrayList.add(c0766rM1516a);
            m1912a(abstractC0836al, C0768t.f1671a, c0766rM1516a, 5, abstractC0775aM2185a);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1911a(AbstractC0836al abstractC0836al, C0766r c0766r, HashSet hashSet) {
        C0802z c0802z = new C0802z(C0755g.f1631a);
        m1918b(abstractC0836al, C0768t.f1671a, null, 40, c0802z);
        C0833ai c0833aiM1832o = abstractC0836al.m1832o();
        C0833ai c0833aiM1797b = c0833aiM1832o.m1797b(c0833aiM1832o.m1814l());
        AbstractC0836al abstractC0836al2 = (AbstractC0836al) c0833aiM1797b.m1801c().get(0);
        C0766r c0766rM1516a = C0766r.m1516a(this.f2187a.m1869o(), c0802z);
        m1912a(abstractC0836al2, C0768t.f1671a, c0766rM1516a, 56, null);
        C0833ai c0833aiM1797b2 = c0833aiM1797b.m1797b(c0833aiM1797b.m1814l());
        AbstractC0836al abstractC0836al3 = (AbstractC0836al) c0833aiM1797b2.m1801c().get(0);
        m1918b(abstractC0836al3, C0768t.m1547a(c0766rM1516a, c0766r), null, 52, new C0798v(c0802z, new C0799w(new C0801y("<init>"), new C0801y("(I)V"))));
        hashSet.add(abstractC0836al3);
        C0833ai c0833aiM1797b3 = c0833aiM1797b2.m1797b(c0833aiM1797b2.m1814l());
        AbstractC0836al abstractC0836al4 = (AbstractC0836al) c0833aiM1797b3.m1801c().get(0);
        m1918b(abstractC0836al4, C0768t.m1546a(c0766rM1516a), null, 35, null);
        c0833aiM1797b3.m1790a(c0833aiM1797b3.m1812j(), this.f2187a.m1860f().m1806e());
        hashSet.add(abstractC0836al4);
    }

    /* JADX INFO: renamed from: a */
    private void m1912a(AbstractC0836al abstractC0836al, C0768t c0768t, C0766r c0766r, int i, AbstractC0775a abstractC0775a) {
        AbstractC0757i abstractC0757iMo1766e = abstractC0836al.mo1766e();
        C0771w c0771wM1595e = i == 56 ? C0773y.m1595e(c0766r.mo663a()) : C0773y.m1585a(i, c0766r, c0768t, abstractC0775a);
        C0870z c0870z = new C0870z(abstractC0775a == null ? new C0765q(c0771wM1595e, abstractC0757iMo1766e.m1491g(), c0766r, c0768t) : new C0764p(c0771wM1595e, abstractC0757iMo1766e.m1491g(), c0766r, c0768t, abstractC0775a), abstractC0836al.m1832o());
        ArrayList arrayListM1801c = abstractC0836al.m1832o().m1801c();
        arrayListM1801c.add(arrayListM1801c.lastIndexOf(abstractC0836al), c0870z);
        this.f2187a.m1843a(c0870z);
    }

    /* JADX INFO: renamed from: a */
    private void m1913a(AbstractC0836al abstractC0836al, AbstractC0836al abstractC0836al2, ArrayList arrayList, HashSet hashSet) {
        int size = arrayList.size();
        switch (abstractC0836al.mo1765c().m1574a()) {
            case 34:
                Object objM1534h = abstractC0836al2.mo1756a().m1553b(0).m1534h();
                AbstractC0836al abstractC0836alM1917b = m1917b(abstractC0836al);
                m1912a(abstractC0836alM1917b, C0768t.f1671a, abstractC0836alM1917b.m1831n(), 5, (AbstractC0775a) objM1534h);
                hashSet.add(abstractC0836alM1917b);
                break;
            case 38:
                AbstractC0836al abstractC0836alM1917b2 = m1917b(abstractC0836al);
                C0768t c0768tMo1756a = abstractC0836al.mo1756a();
                int iMo1632j = ((AbstractC0795s) c0768tMo1756a.m1553b(1).m1534h()).mo1632j();
                if (iMo1632j < size) {
                    C0766r c0766r = (C0766r) arrayList.get(iMo1632j);
                    m1912a(abstractC0836alM1917b2, C0768t.m1546a(c0766r), c0766r.m1525a(abstractC0836alM1917b2.m1831n().m1533g()), 2, null);
                } else {
                    m1911a(abstractC0836alM1917b2, c0768tMo1756a.m1553b(1), hashSet);
                    hashSet.add(abstractC0836alM1917b2.m1832o().m1801c().get(2));
                }
                hashSet.add(abstractC0836alM1917b2);
                break;
            case 39:
                C0768t c0768tMo1756a2 = abstractC0836al.mo1756a();
                int iMo1632j2 = ((AbstractC0795s) c0768tMo1756a2.m1553b(2).m1534h()).mo1632j();
                if (iMo1632j2 < size) {
                    C0766r c0766rM1553b = c0768tMo1756a2.m1553b(0);
                    C0766r c0766rM1525a = c0766rM1553b.m1525a(((C0766r) arrayList.get(iMo1632j2)).m1533g());
                    m1912a(abstractC0836al, C0768t.m1546a(c0766rM1553b), c0766rM1525a, 2, null);
                    arrayList.set(iMo1632j2, c0766rM1525a.m1540n());
                } else {
                    m1911a(abstractC0836al, c0768tMo1756a2.m1553b(2), hashSet);
                }
                break;
            case C0299R.styleable.AppCompatTheme_dividerVertical /* 57 */:
                ArrayList arrayListM1487c = ((C0756h) abstractC0836al.mo1766e()).m1487c();
                for (int i = 0; i < size; i++) {
                    C0766r c0766rM1516a = C0766r.m1516a(((C0766r) arrayList.get(i)).m1533g(), (InterfaceC0806d) arrayListM1487c.get(i));
                    m1912a(abstractC0836al, C0768t.f1671a, c0766rM1516a, 5, (AbstractC0775a) arrayListM1487c.get(i));
                    arrayList.set(i, c0766rM1516a);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1914a(C0838an c0838an) {
        C0856l c0856l = new C0856l(c0838an);
        c0856l.f2187a.m1842a(new C0858n(c0856l));
        for (C0860p c0860p : c0856l.f2189c) {
            if (c0860p.f2196b != EnumC0861q.f2200a) {
                for (C0860p c0860p2 : c0860p.f2197c) {
                    if (c0860p.f2196b.compareTo(c0860p2.f2196b) > 0) {
                        c0860p2.f2196b = c0860p.f2196b;
                    }
                }
            }
        }
        for (C0860p c0860p3 : c0856l.f2189c) {
            if (c0860p3.f2199e && c0860p3.f2196b == EnumC0861q.f2200a) {
                int iNextSetBit = c0860p3.f2195a.nextSetBit(0);
                AbstractC0836al abstractC0836alM1855c = c0856l.f2187a.m1855c(iNextSetBit);
                AbstractC0836al abstractC0836alM1906a = c0856l.m1906a(abstractC0836alM1855c);
                int iMo1632j = ((AbstractC0795s) abstractC0836alM1906a.mo1756a().m1553b(0).m1534h()).mo1632j();
                ArrayList arrayList = new ArrayList(iMo1632j);
                HashSet hashSet = new HashSet();
                c0856l.m1910a(abstractC0836alM1855c, iMo1632j, arrayList);
                hashSet.add(abstractC0836alM1906a);
                hashSet.add(abstractC0836alM1855c);
                for (AbstractC0836al abstractC0836al : c0856l.f2187a.m1857d(iNextSetBit)) {
                    c0856l.m1913a(abstractC0836al, abstractC0836alM1906a, arrayList, hashSet);
                    hashSet.add(abstractC0836al);
                }
                c0856l.f2187a.m1848a(hashSet);
                c0856l.f2187a.m1867m();
                C0849e.m1894a(c0856l.f2187a, c0856l.f2188b);
                c0856l.m1908a();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1915a(C0856l c0856l, AbstractC0836al abstractC0836al) {
        C0860p c0860p;
        int iM1574a = abstractC0836al.mo1765c().m1574a();
        C0766r c0766rM1831n = abstractC0836al.m1831n();
        if (iM1574a != 56 || c0766rM1831n.m1534h().mo665c() != 9) {
            if (iM1574a == 3 && c0766rM1831n.m1534h().mo665c() == 9) {
                C0860p c0860p2 = new C0860p(c0766rM1831n.m1533g(), c0856l.f2188b, EnumC0861q.f2200a);
                c0856l.f2189c.add(c0860p2);
                c0856l.m1909a(c0766rM1831n, c0860p2);
                return;
            } else {
                if (iM1574a == 55 && c0766rM1831n.m1534h().mo665c() == 9) {
                    C0860p c0860p3 = new C0860p(c0766rM1831n.m1533g(), c0856l.f2188b, EnumC0861q.f2200a);
                    c0856l.f2189c.add(c0860p3);
                    c0856l.m1909a(c0766rM1831n, c0860p3);
                    return;
                }
                return;
            }
        }
        C0766r c0766rM1831n2 = abstractC0836al.m1831n();
        AbstractC0836al abstractC0836alM1906a = c0856l.m1906a(abstractC0836al);
        switch (abstractC0836alM1906a.mo1765c().m1574a()) {
            case 5:
            case 40:
                c0860p = new C0860p(c0766rM1831n2.m1533g(), c0856l.f2188b, EnumC0861q.f2200a);
                c0856l.f2189c.add(c0860p);
                break;
            case 38:
            case 43:
            case 45:
                C0766r c0766rM1553b = abstractC0836alM1906a.mo1756a().m1553b(0);
                int iM1905a = c0856l.m1905a(c0766rM1553b);
                if (iM1905a == c0856l.f2189c.size()) {
                    c0860p = c0766rM1553b.mo663a() == C0805c.f2019j ? new C0860p(c0766rM1831n2.m1533g(), c0856l.f2188b, EnumC0861q.f2200a) : new C0860p(c0766rM1831n2.m1533g(), c0856l.f2188b, EnumC0861q.f2203d);
                    c0856l.f2189c.add(c0860p);
                } else {
                    c0860p = (C0860p) c0856l.f2189c.get(iM1905a);
                    c0860p.f2195a.set(c0766rM1831n2.m1533g());
                }
                break;
            case 41:
            case 42:
                if (abstractC0836alM1906a.mo1756a().m1553b(0).m1534h().mo667f()) {
                    c0860p = new C0860p(c0766rM1831n2.m1533g(), c0856l.f2188b, EnumC0861q.f2200a);
                    c0860p.f2199e = true;
                } else {
                    c0860p = new C0860p(c0766rM1831n2.m1533g(), c0856l.f2188b, EnumC0861q.f2203d);
                }
                c0856l.f2189c.add(c0860p);
                break;
            case 46:
                c0860p = new C0860p(c0766rM1831n2.m1533g(), c0856l.f2188b, EnumC0861q.f2203d);
                c0856l.f2189c.add(c0860p);
                break;
            default:
                c0860p = null;
                break;
        }
        c0856l.m1909a(c0766rM1831n, c0860p);
    }

    /* JADX INFO: renamed from: a */
    private static void m1916a(C0860p c0860p, C0860p c0860p2) {
        if (!c0860p2.f2198d.contains(c0860p)) {
            c0860p2.f2198d.add(c0860p);
        }
        if (c0860p.f2197c.contains(c0860p2)) {
            return;
        }
        c0860p.f2197c.add(c0860p2);
    }

    /* JADX INFO: renamed from: b */
    private AbstractC0836al m1917b(AbstractC0836al abstractC0836al) {
        return (AbstractC0836al) ((C0833ai) this.f2187a.m1864j().get(abstractC0836al.m1832o().m1810h().nextSetBit(0))).m1801c().get(0);
    }

    /* JADX INFO: renamed from: b */
    private void m1918b(AbstractC0836al abstractC0836al, C0768t c0768t, C0766r c0766r, int i, AbstractC0775a abstractC0775a) {
        AbstractC0757i abstractC0757iMo1766e = abstractC0836al.mo1766e();
        C0771w c0771wM1585a = C0773y.m1585a(i, null, c0768t, abstractC0775a);
        C0870z c0870z = new C0870z(abstractC0775a == null ? new C0748ac(c0771wM1585a, abstractC0757iMo1766e.m1491g(), c0768t, C0804b.f1974a) : new C0747ab(c0771wM1585a, abstractC0757iMo1766e.m1491g(), c0768t, C0804b.f1974a, abstractC0775a), abstractC0836al.m1832o());
        ArrayList arrayListM1801c = abstractC0836al.m1832o().m1801c();
        arrayListM1801c.add(arrayListM1801c.lastIndexOf(abstractC0836al), c0870z);
        this.f2187a.m1843a(c0870z);
    }

    /* JADX INFO: renamed from: b */
    private static void m1919b(C0860p c0860p, C0860p c0860p2) {
        for (C0860p c0860p3 : c0860p2.f2198d) {
            c0860p3.f2197c.remove(c0860p2);
            c0860p3.f2197c.add(c0860p);
            c0860p.f2198d.add(c0860p3);
        }
        for (C0860p c0860p4 : c0860p2.f2197c) {
            c0860p4.f2198d.remove(c0860p2);
            c0860p4.f2198d.add(c0860p);
            c0860p.f2197c.add(c0860p4);
        }
    }
}
