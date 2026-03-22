package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.InterfaceC0513h;
import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p036f.p038b.C0747ab;
import com.p016a.p019b.p036f.p038b.C0748ac;
import com.p016a.p019b.p036f.p038b.C0751c;
import com.p016a.p019b.p036f.p038b.C0760l;
import com.p016a.p019b.p036f.p038b.C0764p;
import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p036f.p038b.InterfaceC0749ad;
import com.p016a.p019b.p036f.p038b.InterfaceC0750b;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0880j;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.a.b.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0486x {

    /* JADX INFO: renamed from: a */
    private final C0474l f585a;

    /* JADX INFO: renamed from: b */
    private final C0466d f586b;

    /* JADX INFO: renamed from: c */
    private final int f587c;

    /* JADX INFO: renamed from: d */
    private final int f588d;

    /* JADX INFO: renamed from: e */
    private final C0458ag f589e;

    /* JADX INFO: renamed from: f */
    private final C0460ai f590f;

    /* JADX INFO: renamed from: g */
    private final C0476n[] f591g;

    /* JADX INFO: renamed from: h */
    private final ArrayList f592h;

    /* JADX INFO: renamed from: i */
    private final ArrayList f593i;

    /* JADX INFO: renamed from: j */
    private final C0452aa[] f594j;

    /* JADX INFO: renamed from: k */
    private boolean f595k;

    /* JADX INFO: renamed from: l */
    private final C0456ae[] f596l;

    /* JADX INFO: renamed from: m */
    private boolean f597m;

    /* JADX INFO: renamed from: n */
    private final C0454ac f598n;

    private C0486x(C0474l c0474l, InterfaceC0749ad interfaceC0749ad, InterfaceC0513h interfaceC0513h) {
        if (c0474l == null) {
            throw new NullPointerException("method == null");
        }
        if (interfaceC0749ad == null) {
            throw new NullPointerException("advice == null");
        }
        this.f585a = c0474l;
        this.f586b = C0464b.m554a(c0474l);
        this.f588d = this.f586b.m2001j();
        this.f587c = c0474l.m592j();
        this.f589e = new C0458ag(this, c0474l, interfaceC0749ad, interfaceC0513h);
        this.f590f = new C0460ai(this.f589e, c0474l);
        this.f591g = new C0476n[this.f588d];
        this.f596l = new C0456ae[this.f588d];
        this.f592h = new ArrayList((this.f586b.m1977d_() << 1) + 10);
        this.f593i = new ArrayList((this.f586b.m1977d_() << 1) + 10);
        this.f594j = new C0452aa[this.f588d];
        this.f595k = false;
        this.f591g[0] = new C0476n(this.f587c, c0474l.m591i());
        this.f598n = new C0454ac(this);
    }

    /* JADX INFO: renamed from: a */
    private int m669a(int i) {
        return this.f588d + this.f585a.m594l().m1977d_() + (i ^ (-1));
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C0760l m672a(C0486x c0486x, C0760l c0760l) {
        int i;
        int i2 = 0;
        int iD_ = c0760l.m1977d_();
        int i3 = 0;
        for (int i4 = 0; i4 < iD_; i4++) {
            if (c0760l.m1497a(i4).m1490f() != C0773y.f1877g) {
                i3++;
            }
        }
        if (i3 == iD_) {
            return c0760l;
        }
        C0760l c0760l2 = new C0760l(i3);
        int i5 = 0;
        while (i5 < iD_) {
            AbstractC0757i abstractC0757iM1497a = c0760l.m1497a(i5);
            if (abstractC0757iM1497a.m1490f() != C0773y.f1877g) {
                i = i2 + 1;
                c0760l2.m1498a(i2, abstractC0757iM1497a);
            } else {
                i = i2;
            }
            i5++;
            i2 = i;
        }
        c0760l2.mo549b_();
        return c0760l2;
    }

    /* JADX INFO: renamed from: a */
    public static C0772x m673a(C0474l c0474l, InterfaceC0749ad interfaceC0749ad, InterfaceC0513h interfaceC0513h) {
        C0760l c0760l;
        try {
            C0486x c0486x = new C0486x(c0474l, interfaceC0749ad, interfaceC0513h);
            int[] iArrM2293s = C0985a.m2293s(c0486x.f588d);
            C0985a.m2246b(iArrM2293s, 0);
            C0479q c0479qM595m = c0486x.f585a.m595m();
            C0774z c0774zM582a = c0486x.f585a.m582a(0);
            C0804b c0804bM1665b = c0486x.f585a.mo589g().m1665b();
            int iD_ = c0804bM1665b.m1977d_();
            C0760l c0760l2 = new C0760l(iD_ + 1);
            int iM1687i = 0;
            for (int i = 0; i < iD_; i++) {
                C0805c c0805cM1676b = c0804bM1665b.m1676b(i);
                C0480r c0480rM635a = c0479qM595m.m635a(0, iM1687i);
                c0760l2.m1498a(i, (AbstractC0757i) new C0764p(C0773y.m1592b(c0805cM1676b), c0774zM582a, c0480rM635a == null ? C0766r.m1516a(iM1687i, c0805cM1676b) : C0766r.m1520b(iM1687i, c0805cM1676b, c0480rM635a.m639a()), C0768t.f1671a, C0790n.m1629a(iM1687i)));
                iM1687i = c0805cM1676b.m1687i() + iM1687i;
            }
            c0760l2.m1498a(iD_, (AbstractC0757i) new C0765q(C0773y.f1889s, c0774zM582a, (C0766r) null, C0768t.f1671a));
            c0760l2.mo549b_();
            boolean zM694d = c0486x.m694d();
            int iM669a = zM694d ? c0486x.m669a(-4) : 0;
            c0486x.m679a(new C0745a(c0486x.m669a(-1), c0760l2, C0880j.m1982a(iM669a), iM669a), C0880j.f2245a);
            if (zM694d) {
                C0766r c0766rM697g = c0486x.m697g();
                if (c0486x.m695e()) {
                    C0747ab c0747ab = new C0747ab(C0773y.f1887q, c0774zM582a, C0768t.f1671a, C0804b.f1974a, c0486x.f585a.mo588f());
                    C0760l c0760l3 = new C0760l(1);
                    c0760l3.m1498a(0, (AbstractC0757i) c0747ab);
                    c0760l = c0760l3;
                } else {
                    C0760l c0760l4 = new C0760l(2);
                    c0760l4.m1498a(0, (AbstractC0757i) new C0764p(C0773y.f1882l, c0774zM582a, c0766rM697g, C0768t.f1671a, C0790n.f1917b));
                    c0760l4.m1498a(1, (AbstractC0757i) new C0765q(C0773y.f1889s, c0774zM582a, (C0766r) null, C0768t.f1671a));
                    c0760l = c0760l4;
                }
                int iM669a2 = c0486x.m669a(-5);
                c0760l.mo549b_();
                c0486x.m679a(new C0745a(iM669a, c0760l, C0880j.m1982a(iM669a2), iM669a2), C0880j.f2245a);
                C0760l c0760l5 = new C0760l(c0486x.m695e() ? 2 : 1);
                if (c0486x.m695e()) {
                    c0760l5.m1498a(0, (AbstractC0757i) new C0765q(C0773y.m1595e(c0766rM697g), c0774zM582a, c0766rM697g, C0768t.f1671a));
                }
                c0760l5.m1498a(c0486x.m695e() ? 1 : 0, (AbstractC0757i) new C0748ac(C0773y.f1805bj, c0774zM582a, C0768t.m1546a(c0766rM697g), C0804b.f1974a));
                c0760l5.mo549b_();
                c0486x.m679a(new C0745a(iM669a2, c0760l5, C0880j.m1982a(0), 0), C0880j.f2245a);
            }
            c0486x.f591g[0].m617a(c0486x.f585a.mo589g().m1665b());
            c0486x.f591g[0].m620b();
            while (true) {
                int iM2262d = C0985a.m2262d(iArrM2293s, 0);
                if (iM2262d < 0) {
                    break;
                }
                C0985a.m2259c(iArrM2293s, iM2262d);
                try {
                    c0486x.m676a(c0486x.f586b.m564a(iM2262d), c0486x.f591g[iM2262d], iArrM2293s);
                } catch (C0459ah e) {
                    e.m311a("...while working on block " + C0985a.m2296v(iM2262d));
                    throw e;
                }
            }
            C0771w c0771wM518n = c0486x.f589e.m518n();
            if (c0771wM518n != null) {
                C0774z c0774zM519o = c0486x.f589e.m519o();
                int iM669a3 = c0486x.m669a(-2);
                if (c0486x.m694d()) {
                    C0760l c0760l6 = new C0760l(1);
                    c0760l6.m1498a(0, (AbstractC0757i) new C0748ac(C0773y.f1806bk, c0774zM519o, C0768t.m1546a(c0486x.m697g()), C0804b.f1974a));
                    c0760l6.mo549b_();
                    int iM669a4 = c0486x.m669a(-3);
                    c0486x.m679a(new C0745a(iM669a3, c0760l6, C0880j.m1982a(iM669a4), iM669a4), C0880j.f2245a);
                    iM669a3 = iM669a4;
                }
                C0760l c0760l7 = new C0760l(1);
                InterfaceC0807e interfaceC0807eM1576c = c0771wM518n.m1576c();
                c0760l7.m1498a(0, (AbstractC0757i) new C0765q(c0771wM518n, c0774zM519o, (C0766r) null, interfaceC0807eM1576c.mo759d_() == 0 ? C0768t.f1671a : C0768t.m1546a(C0766r.m1516a(0, interfaceC0807eM1576c.mo756a(0)))));
                c0760l7.mo549b_();
                c0486x.m679a(new C0745a(iM669a3, c0760l7, C0880j.f2245a, -1), C0880j.f2245a);
            }
            if (c0486x.f595k) {
                C0774z c0774zM582a2 = c0486x.f585a.m582a(0);
                C0766r c0766rM1516a = C0766r.m1516a(0, C0805c.f2026q);
                C0760l c0760l8 = new C0760l(2);
                c0760l8.m1498a(0, (AbstractC0757i) new C0765q(C0773y.m1593c(C0805c.f2026q), c0774zM582a2, c0766rM1516a, C0768t.f1671a));
                c0760l8.m1498a(1, (AbstractC0757i) new C0748ac(C0773y.f1806bk, c0774zM582a2, C0768t.m1546a(c0486x.m697g()), C0804b.f1974a));
                c0760l8.mo549b_();
                int iM669a5 = c0486x.m669a(-7);
                c0486x.m679a(new C0745a(c0486x.m669a(-6), c0760l8, C0880j.m1982a(iM669a5), iM669a5), C0880j.f2245a);
                C0760l c0760l9 = new C0760l(1);
                c0760l9.m1498a(0, (AbstractC0757i) new C0748ac(C0773y.f1804bi, c0774zM582a2, C0768t.m1546a(c0766rM1516a), C0804b.f1974a));
                c0760l9.mo549b_();
                c0486x.m679a(new C0745a(iM669a5, c0760l9, C0880j.f2245a, -1), C0880j.f2245a);
            }
            c0486x.m699i();
            if (c0486x.f597m) {
                c0486x.m700j();
            }
            return c0486x.m698h();
        } catch (C0459ah e2) {
            e2.m311a("...while working on method " + c0474l.mo583a().mo657d());
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m674a(int i, int i2, C0456ae c0456ae, C0476n c0476n, int[] iArr) {
        C0476n c0476n2 = this.f591g[i];
        if (c0476n2 != null) {
            C0476n c0476nM614a = c0456ae != null ? c0476n2.m614a(c0476n, c0456ae.m507a(), i2) : c0476n2.m613a(c0476n);
            if (c0476nM614a == c0476n2) {
                return;
            } else {
                this.f591g[i] = c0476nM614a;
            }
        } else if (c0456ae != null) {
            this.f591g[i] = c0476n.m619b(i, i2);
        } else {
            this.f591g[i] = c0476n;
        }
        C0985a.m2246b(iArr, i);
    }

    /* JADX INFO: renamed from: a */
    private void m675a(int i, InterfaceC0750b interfaceC0750b) {
        m678a(m692c(i), interfaceC0750b, new BitSet(this.f588d));
    }

    /* JADX INFO: renamed from: a */
    private void m676a(C0465c c0465c, C0476n c0476n, int[] iArr) {
        int iM1985b;
        C0880j c0880j;
        int i;
        C0880j c0880jM1982a;
        int iM1986b;
        C0880j c0880j2;
        C0880j c0880jM1982a2;
        C0467e c0467eM563e = c0465c.m563e();
        this.f589e.m516a(c0467eM563e.m568a_());
        C0476n c0476nM611a = c0476n.m611a();
        this.f590f.m532a(c0465c, c0476nM611a);
        c0476nM611a.m620b();
        int iM523s = this.f589e.m523s();
        ArrayList arrayListM517m = this.f589e.m517m();
        int size = arrayListM517m.size();
        int iD_ = c0467eM563e.m1977d_();
        C0880j c0880jM562d = c0465c.m562d();
        C0456ae c0456ae = null;
        if (this.f589e.m525u()) {
            iM1985b = 1;
            int iM1986b2 = c0880jM562d.m1986b(1);
            if (this.f596l[iM1986b2] == null) {
                this.f596l[iM1986b2] = new C0456ae(this, iM1986b2);
            }
            this.f596l[iM1986b2].m511b(c0465c.mo559a());
            c0456ae = this.f596l[iM1986b2];
            c0880j = c0880jM562d;
        } else if (this.f589e.m526v()) {
            int iM668g = this.f589e.m527w().m668g();
            if (this.f596l[iM668g] == null) {
                this.f596l[iM668g] = new C0456ae(this, iM668g, c0465c.mo559a());
            } else {
                this.f596l[iM668g].m508a(c0465c.mo559a());
            }
            C0880j c0880jM510b = this.f596l[iM668g].m510b();
            this.f596l[iM668g].m509a(c0476nM611a, iArr);
            iM1985b = c0880jM510b.m1985b();
            c0880j = c0880jM510b;
        } else if (this.f589e.m520p()) {
            iM1985b = iD_;
            c0880j = c0880jM562d;
        } else {
            iM1985b = 0;
            c0880j = c0880jM562d;
        }
        int iM1985b2 = c0880j.m1985b();
        for (int i2 = iM1985b; i2 < iM1985b2; i2++) {
            int iM1986b3 = c0880j.m1986b(i2);
            try {
                m674a(iM1986b3, c0465c.mo559a(), c0456ae, c0476nM611a, iArr);
            } catch (C0459ah e) {
                e.m311a("...while merging to block " + C0985a.m2296v(iM1986b3));
                throw e;
            }
        }
        if (iM1985b2 == 0 && this.f589e.m521q()) {
            i = 1;
            c0880jM1982a = C0880j.m1982a(m669a(-2));
        } else {
            i = iM1985b2;
            c0880jM1982a = c0880j;
        }
        if (i == 0) {
            iM1986b = -1;
        } else {
            int iM522r = this.f589e.m522r();
            iM1986b = iM522r >= 0 ? c0880jM1982a.m1986b(iM522r) : iM522r;
        }
        boolean z = m694d() && this.f589e.m524t();
        if (z || iD_ != 0) {
            C0880j c0880j3 = new C0880j(i);
            boolean z2 = false;
            int i3 = 0;
            while (i3 < iD_) {
                C0468f c0468fM566a = c0467eM563e.m566a(i3);
                C0802z c0802zM574d = c0468fM566a.m574d();
                int iM573c = c0468fM566a.m573c();
                boolean z3 = z2 | (c0802zM574d == C0802z.f1938a);
                try {
                    m674a(iM573c, c0465c.mo559a(), null, c0476nM611a.m615a(c0802zM574d), iArr);
                    C0452aa c0452aa = this.f594j[iM573c];
                    if (c0452aa == null) {
                        c0452aa = new C0452aa(this, (byte) 0);
                        this.f594j[iM573c] = c0452aa;
                    }
                    c0880j3.m1988c(c0452aa.m500a(c0802zM574d.m1655i()).m503b());
                    i3++;
                    z2 = z3;
                } catch (C0459ah e2) {
                    e2.m311a("...while merging exception to block " + C0985a.m2296v(iM573c));
                    throw e2;
                }
            }
            if (z && !z2) {
                c0880j3.m1988c(m669a(-6));
                this.f595k = true;
                for (int i4 = (size - iM523s) - 1; i4 < size; i4++) {
                    AbstractC0757i abstractC0757i = (AbstractC0757i) arrayListM517m.get(i4);
                    if (abstractC0757i.m1495k()) {
                        arrayListM517m.set(i4, abstractC0757i.mo1466a(C0805c.f2023n));
                    }
                }
            }
            if (iM1986b >= 0) {
                c0880j3.m1988c(iM1986b);
            }
            c0880j3.mo549b_();
            c0880j2 = c0880j3;
        } else {
            c0880j2 = c0880jM1982a;
        }
        int iM1994f = c0880j2.m1994f(iM1986b);
        int i5 = iM1986b;
        C0880j c0880jM1995f = c0880j2;
        int i6 = iM523s;
        int i7 = size;
        while (i6 > 0) {
            int i8 = i7 - 1;
            AbstractC0757i abstractC0757i2 = (AbstractC0757i) arrayListM517m.get(i8);
            boolean z4 = abstractC0757i2.m1490f().m1577d() == 1;
            C0760l c0760l = new C0760l(z4 ? 2 : 1);
            c0760l.m1498a(0, abstractC0757i2);
            if (z4) {
                c0760l.m1498a(1, (AbstractC0757i) new C0765q(C0773y.f1889s, abstractC0757i2.m1491g(), (C0766r) null, C0768t.f1671a));
                c0880jM1982a2 = C0880j.m1982a(i5);
            } else {
                c0880jM1982a2 = c0880jM1995f;
            }
            c0760l.mo549b_();
            int iM690c = m690c();
            m679a(new C0745a(iM690c, c0760l, c0880jM1982a2, i5), c0476nM611a.m623e());
            c0880jM1995f = c0880jM1995f.m1995f();
            c0880jM1995f.m1987b(iM1994f, iM690c);
            c0880jM1995f.mo549b_();
            i5 = iM690c;
            i6--;
            i7 = i8;
        }
        AbstractC0757i abstractC0757i3 = i7 == 0 ? null : (AbstractC0757i) arrayListM517m.get(i7 - 1);
        if (abstractC0757i3 == null || abstractC0757i3.m1490f().m1577d() == 1) {
            arrayListM517m.add(new C0765q(C0773y.f1889s, abstractC0757i3 == null ? C0774z.f1897a : abstractC0757i3.m1491g(), (C0766r) null, C0768t.f1671a));
            i7++;
        }
        C0760l c0760l2 = new C0760l(i7);
        for (int i9 = 0; i9 < i7; i9++) {
            c0760l2.m1498a(i9, (AbstractC0757i) arrayListM517m.get(i9));
        }
        c0760l2.mo549b_();
        m689b(new C0745a(c0465c.mo559a(), c0760l2, c0880jM1995f, i5), c0476nM611a.m623e());
    }

    /* JADX INFO: renamed from: a */
    private void m678a(C0745a c0745a, InterfaceC0750b interfaceC0750b, BitSet bitSet) {
        int iM685b;
        interfaceC0750b.mo703a(c0745a);
        bitSet.set(c0745a.mo559a());
        C0880j c0880jM1458c = c0745a.m1458c();
        int iM1985b = c0880jM1458c.m1985b();
        for (int i = 0; i < iM1985b; i++) {
            int iM1986b = c0880jM1458c.m1986b(i);
            if (!bitSet.get(iM1986b) && ((!m683a(c0745a) || i <= 0) && (iM685b = m685b(iM1986b)) >= 0)) {
                m678a((C0745a) this.f592h.get(iM685b), interfaceC0750b, bitSet);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m679a(C0745a c0745a, C0880j c0880j) {
        if (c0745a == null) {
            throw new NullPointerException("block == null");
        }
        this.f592h.add(c0745a);
        c0880j.m2005m();
        this.f593i.add(c0880j);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m681a(C0486x c0486x, C0745a c0745a, C0880j c0880j) {
        boolean z;
        if (c0745a == null) {
            throw new NullPointerException("block == null");
        }
        int iM685b = c0486x.m685b(c0745a.mo559a());
        if (iM685b < 0) {
            z = false;
        } else {
            c0486x.f592h.remove(iM685b);
            c0486x.f593i.remove(iM685b);
            z = true;
        }
        c0486x.f592h.add(c0745a);
        c0880j.m2005m();
        c0486x.f593i.add(c0880j);
        return z;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m682a(C0486x c0486x, boolean z) {
        c0486x.f597m = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m683a(C0745a c0745a) {
        int iM1986b;
        C0880j c0880jM1458c = c0745a.m1458c();
        return c0880jM1458c.m1985b() >= 2 && (iM1986b = c0880jM1458c.m1986b(1)) < this.f596l.length && this.f596l[iM1986b] != null;
    }

    /* JADX INFO: renamed from: b */
    private int m684b() {
        return this.f588d + this.f585a.m594l().m1977d_() + 7;
    }

    /* JADX INFO: renamed from: b */
    private int m685b(int i) {
        int size = this.f592h.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0745a) this.f592h.get(i2)).mo559a() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ C0456ae m687b(C0486x c0486x, int i) {
        for (int length = c0486x.f596l.length - 1; length >= 0; length--) {
            if (c0486x.f596l[length] != null) {
                C0456ae c0456ae = c0486x.f596l[length];
                if (c0456ae.f494b.get(i)) {
                    return c0456ae;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private boolean m689b(C0745a c0745a, C0880j c0880j) {
        boolean z;
        int iM685b = m685b(c0745a.mo559a());
        if (iM685b < 0) {
            z = false;
        } else {
            m693d(iM685b);
            z = true;
        }
        this.f592h.add(c0745a);
        c0880j.m2005m();
        this.f593i.add(c0880j);
        return z;
    }

    /* JADX INFO: renamed from: c */
    private int m690c() {
        int iM684b = m684b();
        Iterator it = this.f592h.iterator();
        while (true) {
            int i = iM684b;
            if (!it.hasNext()) {
                return i;
            }
            int iMo559a = ((C0745a) it.next()).mo559a();
            iM684b = iMo559a >= i ? iMo559a + 1 : i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public C0745a m692c(int i) {
        int iM685b = m685b(i);
        if (iM685b < 0) {
            throw new IllegalArgumentException("no such label " + C0985a.m2296v(i));
        }
        return (C0745a) this.f592h.get(iM685b);
    }

    /* JADX INFO: renamed from: d */
    private void m693d(int i) {
        int iM684b = m684b();
        C0880j c0880jM1458c = ((C0745a) this.f592h.get(i)).m1458c();
        int iM1985b = c0880jM1458c.m1985b();
        this.f592h.remove(i);
        this.f593i.remove(i);
        for (int i2 = 0; i2 < iM1985b; i2++) {
            int iM1986b = c0880jM1458c.m1986b(i2);
            if (iM1986b >= iM684b) {
                int iM685b = m685b(iM1986b);
                if (iM685b < 0) {
                    throw new RuntimeException("Invalid label " + C0985a.m2296v(iM1986b));
                }
                m693d(iM685b);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m694d() {
        return (this.f585a.mo586d() & 32) != 0;
    }

    /* JADX INFO: renamed from: e */
    private boolean m695e() {
        return (this.f585a.mo586d() & 8) != 0;
    }

    /* JADX INFO: renamed from: f */
    private int m696f() {
        return this.f587c + this.f585a.m591i();
    }

    /* JADX INFO: renamed from: g */
    private C0766r m697g() {
        int iM696f = m696f();
        if (iM696f <= 0) {
            iM696f = 1;
        }
        return C0766r.m1516a(iM696f, C0805c.f2023n);
    }

    /* JADX INFO: renamed from: h */
    private C0772x m698h() {
        int size = this.f592h.size();
        C0751c c0751c = new C0751c(size);
        for (int i = 0; i < size; i++) {
            c0751c.m1476a(i, (C0745a) this.f592h.get(i));
        }
        c0751c.mo549b_();
        return new C0772x(c0751c, m669a(-1));
    }

    /* JADX INFO: renamed from: i */
    private void m699i() {
        int length = this.f594j.length;
        for (int i = 0; i < length; i++) {
            C0452aa c0452aa = this.f594j[i];
            if (c0452aa != null) {
                for (C0453ab c0453ab : c0452aa.m501a()) {
                    C0774z c0774zM1491g = m692c(i).m1461f().m1491g();
                    C0760l c0760l = new C0760l(2);
                    c0760l.m1498a(0, (AbstractC0757i) new C0765q(C0773y.m1593c(c0453ab.m502a()), c0774zM1491g, C0766r.m1516a(this.f587c, c0453ab.m502a()), C0768t.f1671a));
                    c0760l.m1498a(1, (AbstractC0757i) new C0765q(C0773y.f1889s, c0774zM1491g, (C0766r) null, C0768t.f1671a));
                    c0760l.mo549b_();
                    m679a(new C0745a(c0453ab.m503b(), c0760l, C0880j.m1982a(i), i), this.f591g[i].m623e());
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    private void m700j() {
        C0880j c0880j = new C0880j(4);
        m675a(0, new C0487y(this, c0880j));
        int iM690c = m690c();
        ArrayList arrayList = new ArrayList(iM690c);
        for (int i = 0; i < iM690c; i++) {
            arrayList.add(null);
        }
        for (int i2 = 0; i2 < this.f592h.size(); i2++) {
            C0745a c0745a = (C0745a) this.f592h.get(i2);
            if (c0745a != null) {
                arrayList.set(c0745a.mo559a(), (C0880j) this.f593i.get(i2));
            }
        }
        int iM1985b = c0880j.m1985b();
        for (int i3 = 0; i3 < iM1985b; i3++) {
            new C0457af(this, new C0455ad(m690c()), arrayList).m513a(m692c(c0880j.m1986b(i3)));
        }
        m701k();
    }

    /* JADX INFO: renamed from: k */
    private void m701k() {
        C0880j c0880j = new C0880j(this.f592h.size());
        this.f593i.clear();
        m675a(m669a(-1), new C0488z(this, c0880j));
        c0880j.m1997g();
        for (int size = this.f592h.size() - 1; size >= 0; size--) {
            if (c0880j.m1994f(((C0745a) this.f592h.get(size)).mo559a()) < 0) {
                this.f592h.remove(size);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final int m702a() {
        int iM696f = m696f();
        return m694d() ? iM696f + 1 : iM696f;
    }
}
