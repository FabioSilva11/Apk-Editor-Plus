package com.p016a.p019b.p036f.p038b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0880j;

/* JADX INFO: renamed from: com.a.b.f.b.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0762n {

    /* JADX INFO: renamed from: a */
    private final C0772x f1655a;

    /* JADX INFO: renamed from: b */
    private final C0751c f1656b;

    /* JADX INFO: renamed from: c */
    private final C0763o f1657c;

    /* JADX INFO: renamed from: d */
    private final int[] f1658d;

    private C0762n(C0772x c0772x) {
        if (c0772x == null) {
            throw new NullPointerException("method == null");
        }
        C0751c c0751cM1582a = c0772x.m1582a();
        int iJ = c0751cM1582a.m2001j();
        this.f1655a = c0772x;
        this.f1656b = c0751cM1582a;
        this.f1657c = new C0763o(c0772x);
        this.f1658d = C0985a.m2293s(iJ);
    }

    /* JADX INFO: renamed from: a */
    public static C0763o m1507a(C0772x c0772x) {
        C0762n c0762n = new C0762n(c0772x);
        for (int iM1584b = c0762n.f1655a.m1584b(); iM1584b >= 0; iM1584b = C0985a.m2262d(c0762n.f1658d, 0)) {
            C0985a.m2259c(c0762n.f1658d, iM1584b);
            C0770v c0770vM1515b = c0762n.f1657c.m1515b(iM1584b);
            C0745a c0745aM1478b = c0762n.f1656b.m1478b(iM1584b);
            C0760l c0760lM1457b = c0745aM1478b.m1457b();
            int iD_ = c0760lM1457b.m1977d_();
            boolean z = c0745aM1478b.m1464i() && c0760lM1457b.m1501e().m1492h() != null;
            int i = iD_ - 1;
            C0770v c0770vM1573e = c0770vM1515b;
            for (int i2 = 0; i2 < iD_; i2++) {
                if (z && i2 == i) {
                    c0770vM1573e.mo549b_();
                    c0770vM1573e = c0770vM1573e.m1573e();
                }
                AbstractC0757i abstractC0757iM1497a = c0760lM1457b.m1497a(i2);
                C0766r c0766rM1493i = abstractC0757iM1497a.m1493i();
                if (c0766rM1493i == null) {
                    C0766r c0766rM1492h = abstractC0757iM1497a.m1492h();
                    if (c0766rM1492h != null && c0770vM1573e.m1562a(c0766rM1492h.m1533g()) != null) {
                        c0770vM1573e.m1570c(c0770vM1573e.m1562a(c0766rM1492h.m1533g()));
                    }
                } else {
                    C0766r c0766rM1540n = c0766rM1493i.m1540n();
                    if (!c0766rM1540n.equals(c0770vM1573e.m1564a(c0766rM1540n))) {
                        C0766r c0766rM1563a = c0770vM1573e.m1563a(c0766rM1540n.m1535i());
                        if (c0766rM1563a != null && c0766rM1563a.m1533g() != c0766rM1540n.m1533g()) {
                            c0770vM1573e.m1570c(c0766rM1563a);
                        }
                        c0762n.f1657c.m1512a(abstractC0757iM1497a, c0766rM1540n);
                        c0770vM1573e.m1572d(c0766rM1540n);
                    }
                }
            }
            c0770vM1573e.mo549b_();
            C0880j c0880jM1458c = c0745aM1478b.m1458c();
            int iM1985b = c0880jM1458c.m1985b();
            int iM1459d = c0745aM1478b.m1459d();
            for (int i3 = 0; i3 < iM1985b; i3++) {
                int iM1986b = c0880jM1458c.m1986b(i3);
                if (c0762n.f1657c.m1513a(iM1986b, iM1986b == iM1459d ? c0770vM1573e : c0770vM1515b)) {
                    C0985a.m2246b(c0762n.f1658d, iM1986b);
                }
            }
        }
        c0762n.f1657c.mo549b_();
        return c0762n.f1657c;
    }
}
