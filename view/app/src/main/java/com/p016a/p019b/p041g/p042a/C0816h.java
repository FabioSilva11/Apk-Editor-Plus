package com.p016a.p019b.p041g.p042a;

import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p036f.p038b.C0751c;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p043h.C0880j;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.g.a.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0816h {

    /* JADX INFO: renamed from: a */
    private final C0772x f2061a;

    /* JADX INFO: renamed from: b */
    private final C0751c f2062b;

    /* JADX INFO: renamed from: c */
    private final C0751c f2063c;

    public C0816h(C0772x c0772x) {
        this.f2061a = c0772x;
        this.f2062b = this.f2061a.m1582a();
        this.f2063c = this.f2062b.m1482h();
    }

    /* JADX INFO: renamed from: a */
    private void m1735a(int i, C0880j c0880j) {
        int iM1985b = c0880j.m1985b();
        for (int i2 = 0; i2 < iM1985b; i2++) {
            int iM1986b = c0880j.m1986b(i2);
            C0880j c0880jM1583a = this.f2061a.m1583a(this.f2062b.m1478b(iM1986b).mo559a());
            int iM1985b2 = c0880jM1583a.m1985b();
            for (int i3 = 0; i3 < iM1985b2; i3++) {
                C0745a c0745aM1478b = this.f2063c.m1478b(c0880jM1583a.m1986b(i3));
                C0880j c0880jM1995f = c0745aM1478b.m1458c().m1995f();
                c0880jM1995f.m1987b(c0880jM1995f.m1994f(iM1986b), i);
                int iM1459d = c0745aM1478b.m1459d();
                if (iM1459d == iM1986b) {
                    iM1459d = i;
                }
                c0880jM1995f.mo549b_();
                this.f2063c.m1476a(this.f2063c.m2000c(c0745aM1478b.mo559a()), new C0745a(c0745aM1478b.mo559a(), c0745aM1478b.m1457b(), c0880jM1995f, iM1459d));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0772x m1736a() {
        int iD_ = this.f2062b.m1977d_();
        BitSet bitSet = new BitSet(this.f2062b.m2001j());
        for (int i = 0; i < iD_; i++) {
            C0745a c0745aM1475a = this.f2062b.m1475a(i);
            if (!bitSet.get(c0745aM1475a.mo559a())) {
                C0880j c0880jM1583a = this.f2061a.m1583a(c0745aM1475a.mo559a());
                int iM1985b = c0880jM1583a.m1985b();
                for (int i2 = 0; i2 < iM1985b; i2++) {
                    int iM1986b = c0880jM1583a.m1986b(i2);
                    C0745a c0745aM1478b = this.f2062b.m1478b(iM1986b);
                    if (!bitSet.get(iM1986b) && c0745aM1478b.m1458c().m1985b() <= 1 && c0745aM1478b.m1461f().m1490f().m1574a() != 55) {
                        C0880j c0880j = new C0880j();
                        for (int i3 = i2 + 1; i3 < iM1985b; i3++) {
                            int iM1986b2 = c0880jM1583a.m1986b(i3);
                            C0745a c0745aM1478b2 = this.f2062b.m1478b(iM1986b2);
                            if (c0745aM1478b2.m1458c().m1985b() == 1 && c0745aM1478b.m1457b().m1500a(c0745aM1478b2.m1457b())) {
                                c0880j.m1988c(iM1986b2);
                                bitSet.set(iM1986b2);
                            }
                        }
                        m1735a(iM1986b, c0880j);
                    }
                }
            }
        }
        for (int i4 = iD_ - 1; i4 >= 0; i4--) {
            if (bitSet.get(this.f2063c.m1475a(i4).mo559a())) {
                this.f2063c.m1476a(i4, (C0745a) null);
            }
        }
        this.f2063c.mo1980i();
        this.f2063c.mo549b_();
        return new C0772x(this.f2063c, this.f2061a.m1584b());
    }
}
