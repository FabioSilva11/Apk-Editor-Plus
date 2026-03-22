package com.p016a.p019b.p041g;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p036f.p038b.C0751c;
import com.p016a.p019b.p036f.p038b.C0760l;
import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p043h.C0880j;
import com.p016a.p019b.p043h.InterfaceC0881k;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.a.b.g.ai */
/* JADX INFO: loaded from: classes.dex */
public final class C0833ai {

    /* JADX INFO: renamed from: b */
    private BitSet f2112b;

    /* JADX INFO: renamed from: c */
    private BitSet f2113c;

    /* JADX INFO: renamed from: f */
    private int f2116f;

    /* JADX INFO: renamed from: g */
    private C0838an f2117g;

    /* JADX INFO: renamed from: h */
    private int f2118h;

    /* JADX INFO: renamed from: m */
    private InterfaceC0881k f2123m;

    /* JADX INFO: renamed from: n */
    private InterfaceC0881k f2124n;

    /* JADX INFO: renamed from: e */
    private int f2115e = -1;

    /* JADX INFO: renamed from: j */
    private int f2120j = 0;

    /* JADX INFO: renamed from: k */
    private int f2121k = 0;

    /* JADX INFO: renamed from: l */
    private int f2122l = -1;

    /* JADX INFO: renamed from: a */
    private ArrayList f2111a = new ArrayList();

    /* JADX INFO: renamed from: d */
    private C0880j f2114d = new C0880j();

    /* JADX INFO: renamed from: i */
    private final ArrayList f2119i = new ArrayList();

    static {
        new C0834aj();
    }

    public C0833ai(int i, int i2, C0838an c0838an) {
        this.f2117g = c0838an;
        this.f2118h = i;
        this.f2116f = i2;
        this.f2112b = new BitSet(c0838an.m1864j().size());
        this.f2113c = new BitSet(c0838an.m1864j().size());
    }

    /* JADX INFO: renamed from: a */
    public static C0833ai m1782a(C0772x c0772x, int i, C0838an c0838an) {
        C0751c c0751cM1582a = c0772x.m1582a();
        C0745a c0745aM1475a = c0751cM1582a.m1475a(i);
        C0833ai c0833ai = new C0833ai(i, c0745aM1475a.mo559a(), c0838an);
        C0760l c0760lM1457b = c0745aM1475a.m1457b();
        c0833ai.f2111a.ensureCapacity(c0760lM1457b.m1977d_());
        int iD_ = c0760lM1457b.m1977d_();
        for (int i2 = 0; i2 < iD_; i2++) {
            c0833ai.f2111a.add(new C0870z(c0760lM1457b.m1497a(i2), c0833ai));
        }
        c0833ai.f2112b = C0838an.m1834a(c0751cM1582a, c0772x.m1583a(c0745aM1475a.mo559a()));
        c0833ai.f2113c = C0838an.m1834a(c0751cM1582a, c0745aM1475a.m1458c());
        C0880j c0880jM1458c = c0745aM1475a.m1458c();
        C0880j c0880j = new C0880j(c0880jM1458c.m1985b());
        int iM1985b = c0880jM1458c.m1985b();
        for (int i3 = 0; i3 < iM1985b; i3++) {
            c0880j.m1988c(c0751cM1582a.m2000c(c0880jM1458c.m1986b(i3)));
        }
        c0833ai.f2114d = c0880j;
        if (c0833ai.f2114d.m1985b() != 0) {
            int iM1459d = c0745aM1475a.m1459d();
            c0833ai.f2115e = iM1459d < 0 ? -1 : c0751cM1582a.m2000c(iM1459d);
        }
        return c0833ai;
    }

    /* JADX INFO: renamed from: a */
    private static void m1783a(BitSet bitSet, C0766r c0766r) {
        bitSet.set(c0766r.m1533g());
        if (c0766r.m1537k() > 1) {
            bitSet.set(c0766r.m1533g() + 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1784a(List list) {
        int size;
        AbstractC0836al abstractC0836al;
        int i;
        BitSet bitSet = new BitSet(this.f2117g.m1861g());
        BitSet bitSet2 = new BitSet(this.f2117g.m1861g());
        int size2 = list.size();
        int i2 = 0;
        while (i2 < size2) {
            for (int i3 = i2; i3 < size2; i3++) {
                m1783a(bitSet, ((AbstractC0836al) list.get(i3)).mo1756a().m1553b(0));
                m1783a(bitSet2, ((AbstractC0836al) list.get(i3)).m1831n());
            }
            int i4 = i2;
            int i5 = i2;
            while (i4 < size2) {
                if (m1785b(bitSet, ((AbstractC0836al) list.get(i4)).m1831n())) {
                    i = i5;
                } else {
                    i = i5 + 1;
                    Collections.swap(list, i4, i5);
                }
                i4++;
                i5 = i;
            }
            if (i2 == i5) {
                int i6 = i5;
                while (true) {
                    if (i6 >= size2) {
                        abstractC0836al = null;
                        break;
                    }
                    abstractC0836al = (AbstractC0836al) list.get(i6);
                    if (m1785b(bitSet, abstractC0836al.m1831n()) && m1785b(bitSet2, abstractC0836al.mo1756a().m1553b(0))) {
                        Collections.swap(list, i5, i6);
                        break;
                    }
                    i6++;
                }
                C0766r c0766rM1831n = abstractC0836al.m1831n();
                C0766r c0766rM1525a = c0766rM1831n.m1525a(this.f2117g.m1851b(c0766rM1831n.m1537k()));
                C0870z c0870z = new C0870z(new C0765q(C0773y.m1587a(c0766rM1831n.mo663a()), C0774z.f1897a, c0766rM1525a, abstractC0836al.mo1756a()), this);
                int i7 = i5 + 1;
                list.add(i5, c0870z);
                list.set(i7, new C0870z(new C0765q(C0773y.m1587a(c0766rM1831n.mo663a()), C0774z.f1897a, c0766rM1831n, C0768t.m1546a(c0766rM1525a)), this));
                size = list.size();
                i5 = i7;
            } else {
                size = size2;
            }
            bitSet.clear();
            bitSet2.clear();
            i2 = i5;
            size2 = size;
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m1785b(BitSet bitSet, C0766r c0766r) {
        int iM1533g = c0766r.m1533g();
        return bitSet.get(iM1533g) || (c0766r.m1537k() == 2 && bitSet.get(iM1533g + 1));
    }

    /* JADX INFO: renamed from: t */
    private int m1787t() {
        int size = this.f2111a.size();
        int i = 0;
        while (i < size && (((AbstractC0836al) this.f2111a.get(i)) instanceof C0827ac)) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public final ArrayList m1788a() {
        return this.f2119i;
    }

    /* JADX INFO: renamed from: a */
    public final void m1789a(int i) {
        this.f2111a.add(0, new C0827ac(i, this));
    }

    /* JADX INFO: renamed from: a */
    public final void m1790a(int i, int i2) {
        if (i == i2) {
            return;
        }
        this.f2113c.set(i2);
        if (this.f2115e == i) {
            this.f2115e = i2;
        }
        for (int iM1985b = this.f2114d.m1985b() - 1; iM1985b >= 0; iM1985b--) {
            if (this.f2114d.m1986b(iM1985b) == i) {
                this.f2114d.m1987b(iM1985b, i2);
            }
        }
        this.f2113c.clear(i);
        ((C0833ai) this.f2117g.m1864j().get(i2)).f2112b.set(this.f2118h);
        ((C0833ai) this.f2117g.m1864j().get(i)).f2112b.clear(this.f2118h);
    }

    /* JADX INFO: renamed from: a */
    public final void m1791a(AbstractC0757i abstractC0757i) {
        AbstractC0836al abstractC0836alM1822a = AbstractC0836al.m1822a(abstractC0757i, this);
        this.f2111a.add(m1787t(), abstractC0836alM1822a);
        this.f2117g.m1843a(abstractC0836alM1822a);
    }

    /* JADX INFO: renamed from: a */
    public final void m1792a(C0766r c0766r) {
        this.f2111a.add(0, new C0827ac(c0766r, this));
    }

    /* JADX INFO: renamed from: a */
    public final void m1793a(C0766r c0766r, C0766r c0766r2) {
        if (c0766r.m1533g() == c0766r2.m1533g()) {
            return;
        }
        C0870z c0870z = (C0870z) this.f2111a.get(this.f2111a.size() - 1);
        if (c0870z.m1831n() == null && c0870z.mo1756a().m1977d_() <= 0) {
            this.f2111a.add(this.f2111a.size() - 1, new C0870z(new C0765q(C0773y.m1587a(c0766r.mo663a()), C0774z.f1897a, c0766r, C0768t.m1546a(c0766r2)), this));
            this.f2120j++;
            return;
        }
        int iNextSetBit = this.f2113c.nextSetBit(0);
        while (iNextSetBit >= 0) {
            C0833ai c0833ai = (C0833ai) this.f2117g.m1864j().get(iNextSetBit);
            if (c0766r.m1533g() != c0766r2.m1533g()) {
                c0833ai.f2111a.add(c0833ai.m1787t(), new C0870z(new C0765q(C0773y.m1587a(c0766r.mo663a()), C0774z.f1897a, c0766r, C0768t.m1546a(c0766r2)), c0833ai));
                c0833ai.f2121k++;
            }
            iNextSetBit = this.f2113c.nextSetBit(iNextSetBit + 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1794a(InterfaceC0829ae interfaceC0829ae) {
        int size = this.f2111a.size();
        for (int i = 0; i < size; i++) {
            AbstractC0836al abstractC0836al = (AbstractC0836al) this.f2111a.get(i);
            if (!(abstractC0836al instanceof C0827ac)) {
                return;
            }
            interfaceC0829ae.mo1749a((C0827ac) abstractC0836al);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1795a(C0833ai c0833ai) {
        this.f2119i.add(c0833ai);
    }

    /* JADX INFO: renamed from: a */
    public final void m1796a(InterfaceC0837am interfaceC0837am) {
        int size = this.f2111a.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC0836al) this.f2111a.get(i)).mo1762a(interfaceC0837am);
        }
    }

    /* JADX INFO: renamed from: b */
    public final C0833ai m1797b(C0833ai c0833ai) {
        C0833ai c0833aiM1852b = this.f2117g.m1852b();
        if (!this.f2113c.get(c0833ai.f2118h)) {
            throw new RuntimeException("Block " + C0985a.m2296v(c0833ai.f2116f) + " not successor of " + C0985a.m2296v(this.f2116f));
        }
        c0833aiM1852b.f2112b.set(this.f2118h);
        c0833aiM1852b.f2113c.set(c0833ai.f2118h);
        c0833aiM1852b.f2114d.m1988c(c0833ai.f2118h);
        c0833aiM1852b.f2115e = c0833ai.f2118h;
        for (int iM1985b = this.f2114d.m1985b() - 1; iM1985b >= 0; iM1985b--) {
            if (this.f2114d.m1986b(iM1985b) == c0833ai.f2118h) {
                this.f2114d.m1987b(iM1985b, c0833aiM1852b.f2118h);
            }
        }
        if (this.f2115e == c0833ai.f2118h) {
            this.f2115e = c0833aiM1852b.f2118h;
        }
        this.f2113c.clear(c0833ai.f2118h);
        this.f2113c.set(c0833aiM1852b.f2118h);
        c0833ai.f2112b.set(c0833aiM1852b.f2118h);
        c0833ai.f2112b.set(this.f2118h, this.f2113c.get(c0833ai.f2118h));
        return c0833aiM1852b;
    }

    /* JADX INFO: renamed from: b */
    public final void m1798b() {
        this.f2111a.subList(0, m1787t()).clear();
    }

    /* JADX INFO: renamed from: b */
    public final void m1799b(int i) {
        int i2 = 0;
        for (int iM1985b = this.f2114d.m1985b() - 1; iM1985b >= 0; iM1985b--) {
            if (this.f2114d.m1986b(iM1985b) == i) {
                i2 = iM1985b;
            } else {
                this.f2115e = this.f2114d.m1986b(iM1985b);
            }
        }
        this.f2114d.m1991d(i2);
        this.f2113c.clear(i);
        ((C0833ai) this.f2117g.m1864j().get(i)).f2112b.clear(this.f2118h);
    }

    /* JADX INFO: renamed from: b */
    public final void m1800b(AbstractC0757i abstractC0757i) {
        if (abstractC0757i.m1490f().m1577d() == 1) {
            throw new IllegalArgumentException("last insn must branch");
        }
        AbstractC0836al abstractC0836al = (AbstractC0836al) this.f2111a.get(this.f2111a.size() - 1);
        AbstractC0836al abstractC0836alM1822a = AbstractC0836al.m1822a(abstractC0757i, this);
        this.f2111a.set(this.f2111a.size() - 1, abstractC0836alM1822a);
        this.f2117g.m1853b(abstractC0836al);
        this.f2117g.m1843a(abstractC0836alM1822a);
    }

    /* JADX INFO: renamed from: c */
    public final ArrayList m1801c() {
        return this.f2111a;
    }

    /* JADX INFO: renamed from: c */
    public final void m1802c(int i) {
        if (this.f2124n == null) {
            this.f2124n = C0849e.m1898b(this.f2117g.m1861g());
        }
        this.f2124n.mo1944a(i);
    }

    /* JADX INFO: renamed from: c */
    public final void m1803c(C0833ai c0833ai) {
        if (this != c0833ai && this.f2114d.m1985b() == 0) {
            this.f2113c.set(c0833ai.f2118h);
            this.f2114d.m1988c(c0833ai.f2118h);
            this.f2115e = c0833ai.f2118h;
            c0833ai.f2112b.set(this.f2118h);
        }
    }

    /* JADX INFO: renamed from: d */
    public final List m1804d() {
        return this.f2111a.subList(0, m1787t());
    }

    /* JADX INFO: renamed from: d */
    public final void m1805d(int i) {
        if (this.f2123m == null) {
            this.f2123m = C0849e.m1898b(this.f2117g.m1861g());
        }
        this.f2123m.mo1944a(i);
    }

    /* JADX INFO: renamed from: e */
    public final int m1806e() {
        return this.f2118h;
    }

    /* JADX INFO: renamed from: e */
    public final void m1807e(int i) {
        this.f2122l = i;
    }

    /* JADX INFO: renamed from: f */
    public final int m1808f() {
        return this.f2116f;
    }

    /* JADX INFO: renamed from: g */
    public final BitSet m1809g() {
        return this.f2112b;
    }

    /* JADX INFO: renamed from: h */
    public final BitSet m1810h() {
        return this.f2113c;
    }

    /* JADX INFO: renamed from: i */
    public final C0880j m1811i() {
        return this.f2114d;
    }

    /* JADX INFO: renamed from: j */
    public final int m1812j() {
        return this.f2115e;
    }

    /* JADX INFO: renamed from: k */
    public final int m1813k() {
        return this.f2117g.m1839a(this.f2115e);
    }

    /* JADX INFO: renamed from: l */
    public final C0833ai m1814l() {
        if (this.f2115e < 0) {
            return null;
        }
        return (C0833ai) this.f2117g.m1864j().get(this.f2115e);
    }

    /* JADX INFO: renamed from: m */
    public final C0880j m1815m() {
        C0880j c0880j = new C0880j(this.f2114d.m1985b());
        int iM1985b = this.f2114d.m1985b();
        for (int i = 0; i < iM1985b; i++) {
            c0880j.m1988c(this.f2117g.m1839a(this.f2114d.m1986b(i)));
        }
        return c0880j;
    }

    /* JADX INFO: renamed from: n */
    public final C0838an m1816n() {
        return this.f2117g;
    }

    /* JADX INFO: renamed from: o */
    public final C0833ai m1817o() {
        C0833ai c0833aiM1852b = this.f2117g.m1852b();
        c0833aiM1852b.f2112b = this.f2112b;
        c0833aiM1852b.f2113c.set(this.f2118h);
        c0833aiM1852b.f2114d.m1988c(this.f2118h);
        c0833aiM1852b.f2115e = this.f2118h;
        this.f2112b = new BitSet(this.f2117g.m1864j().size());
        this.f2112b.set(c0833aiM1852b.f2118h);
        for (int iNextSetBit = c0833aiM1852b.f2112b.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = c0833aiM1852b.f2112b.nextSetBit(iNextSetBit + 1)) {
            ((C0833ai) this.f2117g.m1864j().get(iNextSetBit)).m1790a(this.f2118h, c0833aiM1852b.f2118h);
        }
        return c0833aiM1852b;
    }

    /* JADX INFO: renamed from: p */
    public final InterfaceC0881k m1818p() {
        if (this.f2124n == null) {
            this.f2124n = C0849e.m1898b(this.f2117g.m1861g());
        }
        return this.f2124n;
    }

    /* JADX INFO: renamed from: q */
    public final boolean m1819q() {
        return this.f2118h == this.f2117g.m1858e();
    }

    /* JADX INFO: renamed from: r */
    public final boolean m1820r() {
        if (this.f2122l == -1) {
            this.f2117g.m1866l();
        }
        return this.f2122l == 1;
    }

    /* JADX INFO: renamed from: s */
    public final void m1821s() {
        if (this.f2121k > 1) {
            m1784a(this.f2111a.subList(0, this.f2121k));
            if (((AbstractC0836al) this.f2111a.get(this.f2121k)).mo1830i()) {
                throw new RuntimeException("Unexpected: moves from phis before move-exception");
            }
        }
        if (this.f2120j > 1) {
            m1784a(this.f2111a.subList((this.f2111a.size() - this.f2120j) - 1, this.f2111a.size() - 1));
        }
        this.f2117g.m1863i();
    }

    public final String toString() {
        return "{" + this.f2118h + ":" + C0985a.m2296v(this.f2116f) + '}';
    }
}
