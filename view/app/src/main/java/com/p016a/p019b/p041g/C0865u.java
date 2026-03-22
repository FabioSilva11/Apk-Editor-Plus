package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0770v;
import com.p016a.p019b.p043h.C0880j;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.g.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0865u {

    /* JADX INFO: renamed from: a */
    private final C0838an f2210a;

    /* JADX INFO: renamed from: b */
    private final ArrayList f2211b;

    /* JADX INFO: renamed from: c */
    private final C0866v f2212c;

    /* JADX INFO: renamed from: d */
    private final BitSet f2213d;

    private C0865u(C0838an c0838an) {
        if (c0838an == null) {
            throw new NullPointerException("method == null");
        }
        ArrayList arrayListM1864j = c0838an.m1864j();
        this.f2210a = c0838an;
        this.f2211b = arrayListM1864j;
        this.f2212c = new C0866v(c0838an);
        this.f2213d = new BitSet(arrayListM1864j.size());
    }

    /* JADX INFO: renamed from: a */
    public static C0866v m1929a(C0838an c0838an) {
        C0770v c0770vM1573e;
        C0865u c0865u = new C0865u(c0838an);
        if (c0865u.f2210a.m1861g() > 0) {
            for (int iM1854c = c0865u.f2210a.m1854c(); iM1854c >= 0; iM1854c = c0865u.f2213d.nextSetBit(0)) {
                c0865u.f2213d.clear(iM1854c);
                C0770v c0770vM1935b = c0865u.f2212c.m1935b(iM1854c);
                C0833ai c0833ai = (C0833ai) c0865u.f2211b.get(iM1854c);
                ArrayList arrayListM1801c = c0833ai.m1801c();
                int size = arrayListM1801c.size();
                if (iM1854c != c0865u.f2210a.m1858e()) {
                    AbstractC0836al abstractC0836al = (AbstractC0836al) arrayListM1801c.get(size - 1);
                    boolean z = (abstractC0836al.mo1766e().mo1470b().mo759d_() != 0) && abstractC0836al.m1831n() != null;
                    int i = size - 1;
                    int i2 = 0;
                    C0770v c0770v = c0770vM1935b;
                    while (i2 < size) {
                        if (z && i2 == i) {
                            c0770v.mo549b_();
                            c0770vM1573e = c0770v.m1573e();
                        } else {
                            c0770vM1573e = c0770v;
                        }
                        AbstractC0836al abstractC0836al2 = (AbstractC0836al) arrayListM1801c.get(i2);
                        C0766r c0766rMo1828f = abstractC0836al2.mo1828f();
                        if (c0766rMo1828f == null) {
                            C0766r c0766rM1831n = abstractC0836al2.m1831n();
                            if (c0766rM1831n != null && c0770vM1573e.m1562a(c0766rM1831n.m1533g()) != null) {
                                c0770vM1573e.m1570c(c0770vM1573e.m1562a(c0766rM1831n.m1533g()));
                            }
                        } else {
                            C0766r c0766rM1540n = c0766rMo1828f.m1540n();
                            if (!c0766rM1540n.equals(c0770vM1573e.m1564a(c0766rM1540n))) {
                                C0766r c0766rM1563a = c0770vM1573e.m1563a(c0766rM1540n.m1535i());
                                if (c0766rM1563a != null && c0766rM1563a.m1533g() != c0766rM1540n.m1533g()) {
                                    c0770vM1573e.m1570c(c0766rM1563a);
                                }
                                c0865u.f2212c.m1933a(abstractC0836al2, c0766rM1540n);
                                c0770vM1573e.m1572d(c0766rM1540n);
                            }
                        }
                        i2++;
                        c0770v = c0770vM1573e;
                    }
                    c0770v.mo549b_();
                    C0880j c0880jM1811i = c0833ai.m1811i();
                    int iM1985b = c0880jM1811i.m1985b();
                    int iM1812j = c0833ai.m1812j();
                    for (int i3 = 0; i3 < iM1985b; i3++) {
                        int iM1986b = c0880jM1811i.m1986b(i3);
                        if (c0865u.f2212c.m1934a(iM1986b, iM1986b == iM1812j ? c0770v : c0770vM1935b)) {
                            c0865u.f2213d.set(iM1986b);
                        }
                    }
                }
            }
        }
        c0865u.f2212c.mo549b_();
        return c0865u.f2212c;
    }
}
