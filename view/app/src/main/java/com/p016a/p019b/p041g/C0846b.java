package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0747ab;
import com.p016a.p019b.p036f.p038b.C0764p;
import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p036f.p039c.AbstractC0777ab;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: renamed from: com.a.b.g.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0846b {

    /* JADX INFO: renamed from: a */
    private static boolean f2156a = false;

    /* JADX INFO: renamed from: b */
    private static boolean f2157b = false;

    /* JADX INFO: renamed from: c */
    private final C0838an f2158c;

    private C0846b(C0838an c0838an) {
        this.f2158c = c0838an;
    }

    /* JADX INFO: renamed from: a */
    public static void m1889a(C0838an c0838an) {
        C0846b c0846b = new C0846b(c0838an);
        int iM1861g = c0846b.f2158c.m1861g();
        int iM1861g2 = c0846b.f2158c.m1861g();
        HashMap map = new HashMap();
        new HashSet();
        for (int i = 0; i < iM1861g2; i++) {
            AbstractC0836al abstractC0836alM1855c = c0846b.f2158c.m1855c(i);
            if (abstractC0836alM1855c != null && abstractC0836alM1855c.mo1765c() != null) {
                C0766r c0766rM1831n = abstractC0836alM1855c.m1831n();
                InterfaceC0806d interfaceC0806dM1534h = c0766rM1831n.m1534h();
                if (interfaceC0806dM1534h.mo667f()) {
                    AbstractC0777ab abstractC0777ab = (AbstractC0777ab) interfaceC0806dM1534h;
                    if (abstractC0836alM1855c.mo1765c().m1574a() == 56) {
                        abstractC0836alM1855c = (AbstractC0836al) ((C0833ai) c0846b.f2158c.m1864j().get(abstractC0836alM1855c.m1832o().m1809g().nextSetBit(0))).m1801c().get(r3.size() - 1);
                    }
                    if (abstractC0836alM1855c.mo1768j()) {
                        if (abstractC0777ab instanceof C0801y) {
                        }
                    } else if (!c0846b.f2158c.m1850a(c0766rM1831n)) {
                        Integer num = (Integer) map.get(abstractC0777ab);
                        if (num == null) {
                            map.put(abstractC0777ab, 1);
                        } else {
                            map.put(abstractC0777ab, Integer.valueOf(num.intValue() + 1));
                        }
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > 1) {
                arrayList.add(entry.getKey());
            }
        }
        Collections.sort(arrayList, new C0847c(c0846b, map));
        int iMin = Math.min(arrayList.size(), 5);
        C0833ai c0833aiM1856d = c0846b.f2158c.m1856d();
        HashMap map2 = new HashMap(iMin);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iMin) {
                c0846b.m1890a(map2, iM1861g);
                return;
            }
            AbstractC0777ab abstractC0777ab2 = (AbstractC0777ab) arrayList.get(i3);
            C0766r c0766rM1516a = C0766r.m1516a(c0846b.f2158c.m1869o(), abstractC0777ab2);
            C0771w c0771wM1596f = C0773y.m1596f(abstractC0777ab2);
            if (c0771wM1596f.m1577d() == 1) {
                c0833aiM1856d.m1791a(new C0764p(C0773y.m1596f(abstractC0777ab2), C0774z.f1897a, c0766rM1516a, C0768t.f1671a, abstractC0777ab2));
            } else {
                C0833ai c0833aiM1856d2 = c0846b.f2158c.m1856d();
                C0833ai c0833aiM1814l = c0833aiM1856d2.m1814l();
                C0833ai c0833aiM1797b = c0833aiM1856d2.m1797b(c0833aiM1814l);
                c0833aiM1797b.m1800b(new C0747ab(c0771wM1596f, C0774z.f1897a, C0768t.f1671a, C0804b.f1974a, abstractC0777ab2));
                c0833aiM1797b.m1797b(c0833aiM1814l).m1791a(new C0765q(C0773y.m1595e(c0766rM1516a.m1534h()), C0774z.f1897a, c0766rM1516a, C0768t.f1671a));
            }
            map2.put(abstractC0777ab2, c0766rM1516a);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1890a(HashMap map, int i) {
        C0766r c0766r;
        new HashSet();
        ArrayList[] arrayListArrM1868n = this.f2158c.m1868n();
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC0836al abstractC0836alM1855c = this.f2158c.m1855c(i2);
            if (abstractC0836alM1855c != null) {
                C0766r c0766rM1831n = abstractC0836alM1855c.m1831n();
                InterfaceC0806d interfaceC0806dM1534h = abstractC0836alM1855c.m1831n().m1534h();
                if (interfaceC0806dM1534h.mo667f() && (c0766r = (C0766r) map.get((AbstractC0777ab) interfaceC0806dM1534h)) != null && !this.f2158c.m1850a(c0766rM1831n)) {
                    C0848d c0848d = new C0848d(this, c0766rM1831n, c0766r);
                    for (AbstractC0836al abstractC0836al : arrayListArrM1868n[c0766rM1831n.m1533g()]) {
                        if (!abstractC0836al.mo1768j() || abstractC0836al.m1832o().m1810h().cardinality() <= 1) {
                            abstractC0836al.mo1761a(c0848d);
                        }
                    }
                }
            }
        }
    }
}
