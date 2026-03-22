package com.p016a.p019b.p028c.p030b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p028c.C0533a;
import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p036f.p038b.C0751c;
import com.p016a.p019b.p036f.p038b.C0763o;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p043h.C0880j;

/* JADX INFO: renamed from: com.a.b.c.b.ae */
/* JADX INFO: loaded from: classes.dex */
public final class C0567ae {

    /* JADX INFO: renamed from: a */
    private final C0772x f740a;

    /* JADX INFO: renamed from: b */
    private final int f741b;

    /* JADX INFO: renamed from: c */
    private final C0763o f742c;

    /* JADX INFO: renamed from: d */
    private final C0577b f743d;

    /* JADX INFO: renamed from: e */
    private final C0601z f744e;

    /* JADX INFO: renamed from: f */
    private final C0570ah f745f;

    /* JADX INFO: renamed from: g */
    private final int f746g;

    /* JADX INFO: renamed from: h */
    private int[] f747h = null;

    /* JADX INFO: renamed from: i */
    private final int f748i;

    /* JADX INFO: renamed from: j */
    private boolean f749j;

    private C0567ae(C0772x c0772x, int i, C0763o c0763o, int i2, C0533a c0533a) {
        this.f740a = c0772x;
        this.f741b = i;
        this.f742c = c0763o;
        this.f743d = new C0577b(c0772x);
        this.f748i = i2;
        boolean[] zArr = {true};
        c0772x.m1582a().m1477a(new C0568af(zArr, c0772x.m1582a().m1479e(), i2));
        this.f749j = zArr[0];
        C0751c c0751cM1582a = c0772x.m1582a();
        int iD_ = c0751cM1582a.m1977d_();
        int iM1480f = (iD_ * 3) + c0751cM1582a.m1480f();
        iM1480f = c0763o != null ? iM1480f + c0763o.m1514b() + iD_ : iM1480f;
        this.f746g = (this.f749j ? 0 : this.f748i) + c0751cM1582a.m1479e();
        this.f744e = new C0601z(c0533a, iM1480f, iD_ * 3, this.f746g, i2);
        if (c0763o != null) {
            this.f745f = new C0569ag(this, this.f744e, c0763o);
        } else {
            this.f745f = new C0570ah(this, this.f744e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0585j m880a(C0772x c0772x, int i, C0763o c0763o, int i2, C0533a c0533a) {
        int i3;
        C0745a c0745aM1478b;
        int i4;
        int iM1986b;
        C0567ae c0567ae = new C0567ae(c0772x, i, c0763o, i2, c0533a);
        C0751c c0751cM1582a = c0567ae.f740a.m1582a();
        int iD_ = c0751cM1582a.m1977d_();
        int iJ = c0751cM1582a.m2001j();
        int[] iArrM2293s = C0985a.m2293s(iJ);
        int[] iArrM2293s2 = C0985a.m2293s(iJ);
        for (int i5 = 0; i5 < iD_; i5++) {
            C0985a.m2246b(iArrM2293s, c0751cM1582a.m1475a(i5).mo559a());
        }
        int[] iArr = new int[iD_];
        int i6 = 0;
        int iM1584b = c0567ae.f740a.m1584b();
        while (iM1584b != -1) {
            while (true) {
                C0880j c0880jM1583a = c0567ae.f740a.m1583a(iM1584b);
                int iM1985b = c0880jM1583a.m1985b();
                for (0; i3 < iM1985b; i3 + 1) {
                    iM1986b = c0880jM1583a.m1986b(i3);
                    if (!C0985a.m2227a(iArrM2293s2, iM1986b)) {
                        i3 = (C0985a.m2227a(iArrM2293s, iM1986b) && c0751cM1582a.m1478b(iM1986b).m1459d() == iM1584b) ? 0 : i3 + 1;
                    }
                }
                C0985a.m2246b(iArrM2293s2, iM1986b);
                iM1584b = iM1986b;
            }
            int iMo559a = iM1584b;
            int i7 = i6;
            while (iMo559a != -1) {
                C0985a.m2259c(iArrM2293s, iMo559a);
                C0985a.m2259c(iArrM2293s2, iMo559a);
                iArr[i7] = iMo559a;
                i7++;
                C0745a c0745aM1478b2 = c0751cM1582a.m1478b(iMo559a);
                int iM1459d = c0745aM1478b2.m1459d();
                C0880j c0880jM1458c = c0745aM1478b2.m1458c();
                switch (c0880jM1458c.m1985b()) {
                    case 0:
                        c0745aM1478b = null;
                        break;
                    case 1:
                        c0745aM1478b = c0751cM1582a.m1478b(c0880jM1458c.m1986b(0));
                        break;
                    default:
                        c0745aM1478b = iM1459d != -1 ? c0751cM1582a.m1478b(iM1459d) : c0751cM1582a.m1478b(c0880jM1458c.m1986b(0));
                        break;
                }
                if (c0745aM1478b != null) {
                    iMo559a = c0745aM1478b.mo559a();
                    int iM1459d2 = c0745aM1478b2.m1459d();
                    if (!C0985a.m2227a(iArrM2293s, iMo559a)) {
                        if (iM1459d2 == iMo559a || iM1459d2 < 0 || !C0985a.m2227a(iArrM2293s, iM1459d2)) {
                            C0880j c0880jM1458c2 = c0745aM1478b2.m1458c();
                            int iM1985b2 = c0880jM1458c2.m1985b();
                            while (true) {
                                if (i4 < iM1985b2) {
                                    iMo559a = c0880jM1458c2.m1986b(i4);
                                    i4 = C0985a.m2227a(iArrM2293s, iMo559a) ? 0 : i4 + 1;
                                } else {
                                    iMo559a = -1;
                                }
                            }
                        } else {
                            iMo559a = iM1459d2;
                        }
                    }
                }
            }
            i6 = i7;
            iM1584b = C0985a.m2262d(iArrM2293s, 0);
        }
        if (i6 != iD_) {
            throw new RuntimeException("shouldn't happen");
        }
        c0567ae.f747h = iArr;
        c0567ae.m883a();
        return new C0585j(c0567ae.f741b, c0567ae.f744e.m1033a(), new C0572aj(c0567ae.f740a, c0567ae.f747h, c0567ae.f743d));
    }

    /* JADX INFO: renamed from: a */
    private void m883a() {
        C0751c c0751cM1582a = this.f740a.m1582a();
        int[] iArr = this.f747h;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 1;
            int i3 = i2 == iArr.length ? -1 : iArr[i2];
            C0745a c0745aM1478b = c0751cM1582a.m1478b(iArr[i]);
            C0583h c0583hM917a = this.f743d.m917a(c0745aM1478b);
            this.f744e.m1035a(c0583hM917a);
            if (this.f742c != null) {
                this.f744e.m1035a(new C0598w(c0583hM917a.m962i(), this.f742c.m1511a(c0745aM1478b.mo559a())));
            }
            this.f745f.m898a(c0745aM1478b, this.f743d.m918b(c0745aM1478b));
            c0745aM1478b.m1457b().m1499a(this.f745f);
            this.f744e.m1035a(this.f743d.m919c(c0745aM1478b));
            int iM1459d = c0745aM1478b.m1459d();
            AbstractC0757i abstractC0757iM1462g = c0745aM1478b.m1462g();
            if (iM1459d >= 0 && iM1459d != i3) {
                if (abstractC0757iM1462g.m1490f().m1577d() == 4 && c0745aM1478b.m1460e() == i3) {
                    this.f744e.m1034a(1, this.f743d.m916a(iM1459d));
                } else {
                    this.f744e.m1035a(new C0574al(C0590o.f804H, abstractC0757iM1462g.m1491g(), C0768t.f1671a, this.f743d.m916a(iM1459d)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static C0768t m884b(AbstractC0757i abstractC0757i, C0766r c0766r) {
        C0768t c0768tM1494j = abstractC0757i.m1494j();
        if (abstractC0757i.m1490f().m1579f() && c0768tM1494j.m1977d_() == 2 && c0766r.m1533g() == c0768tM1494j.m1553b(1).m1533g()) {
            c0768tM1494j = C0768t.m1547a(c0768tM1494j.m1553b(1), c0768tM1494j.m1553b(0));
        }
        return c0766r == null ? c0768tM1494j : c0768tM1494j.m1554b(c0766r);
    }
}
