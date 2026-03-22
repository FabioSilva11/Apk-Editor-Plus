package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p038b.C0774z;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: renamed from: com.a.b.g.as */
/* JADX INFO: loaded from: classes.dex */
final class C0843as implements InterfaceC0837am {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ RunnableC0841aq f2148a;

    /* JADX INFO: renamed from: b */
    private final C0833ai f2149b;

    /* JADX INFO: renamed from: c */
    private final C0766r[] f2150c;

    /* JADX INFO: renamed from: d */
    private final HashSet f2151d = new HashSet();

    /* JADX INFO: renamed from: e */
    private final HashMap f2152e = new HashMap();

    /* JADX INFO: renamed from: f */
    private final C0845au f2153f = new C0845au(this);

    C0843as(RunnableC0841aq runnableC0841aq, C0833ai c0833ai) {
        this.f2148a = runnableC0841aq;
        this.f2149b = c0833ai;
        this.f2150c = runnableC0841aq.f2145e[c0833ai.m1806e()];
        runnableC0841aq.f2145e[c0833ai.m1806e()] = null;
    }

    /* JADX INFO: renamed from: a */
    private void m1883a(int i, C0766r c0766r) {
        int iM1533g = c0766r.m1533g();
        C0761m c0761mM1535i = c0766r.m1535i();
        this.f2150c[i] = c0766r;
        for (int length = this.f2150c.length - 1; length >= 0; length--) {
            if (iM1533g == this.f2150c[length].m1533g()) {
                this.f2150c[length] = c0766r;
            }
        }
        if (c0761mM1535i == null) {
            return;
        }
        RunnableC0841aq.m1873a(this.f2148a, c0766r);
        for (int length2 = this.f2150c.length - 1; length2 >= 0; length2--) {
            C0766r c0766r2 = this.f2150c[length2];
            if (iM1533g != c0766r2.m1533g() && c0761mM1535i.equals(c0766r2.m1535i())) {
                this.f2150c[length2] = c0766r2.m1526a((C0761m) null);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1884a(AbstractC0836al abstractC0836al) {
        C0766r c0766rM1831n = abstractC0836al.m1831n();
        if (c0766rM1831n == null) {
            return;
        }
        int iM1533g = c0766rM1831n.m1533g();
        if (RunnableC0841aq.m1878b(this.f2148a, iM1533g)) {
            return;
        }
        abstractC0836al.m1827c(this.f2148a.f2142b);
        m1883a(iM1533g, abstractC0836al.m1831n());
        RunnableC0841aq.m1881d(this.f2148a);
    }

    /* JADX INFO: renamed from: a */
    public final void m1887a() {
        boolean z;
        this.f2149b.m1796a(this);
        C0844at c0844at = new C0844at(this);
        BitSet bitSetM1810h = this.f2149b.m1810h();
        for (int iNextSetBit = bitSetM1810h.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSetM1810h.nextSetBit(iNextSetBit + 1)) {
            ((C0833ai) this.f2148a.f2141a.m1864j().get(iNextSetBit)).m1794a(c0844at);
        }
        ArrayList arrayListM1801c = this.f2149b.m1801c();
        for (int size = arrayListM1801c.size() - 1; size >= 0; size--) {
            AbstractC0836al abstractC0836al = (AbstractC0836al) arrayListM1801c.get(size);
            AbstractC0836al abstractC0836al2 = (AbstractC0836al) this.f2152e.get(abstractC0836al);
            if (abstractC0836al2 != null) {
                arrayListM1801c.set(size, abstractC0836al2);
            } else if (abstractC0836al.mo1829h() && !this.f2151d.contains(abstractC0836al)) {
                arrayListM1801c.remove(size);
            }
        }
        boolean z2 = true;
        for (C0833ai c0833ai : this.f2149b.m1788a()) {
            if (c0833ai != this.f2149b) {
                this.f2148a.f2145e[c0833ai.m1806e()] = z2 ? this.f2150c : RunnableC0841aq.m1875a(this.f2150c);
                z = false;
            } else {
                z = z2;
            }
            z2 = z;
        }
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1728a(C0827ac c0827ac) {
        m1884a((AbstractC0836al) c0827ac);
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1729a(C0870z c0870z) {
        C0766r c0766rN = c0870z.m1831n();
        int iM1533g = c0766rN.m1533g();
        int iM1533g2 = c0870z.mo1756a().m1553b(0).m1533g();
        c0870z.mo1761a(this.f2153f);
        int iM1533g3 = c0870z.mo1756a().m1553b(0).m1533g();
        C0761m c0761mM1535i = this.f2150c[iM1533g2].m1535i();
        C0761m c0761mM1535i2 = c0766rN.m1535i();
        if (c0761mM1535i2 == null) {
            c0761mM1535i2 = c0761mM1535i;
        }
        C0761m c0761mM1872a = RunnableC0841aq.m1872a(this.f2148a, iM1533g3);
        boolean z = c0761mM1872a == null || c0761mM1535i2 == null || c0761mM1535i2.equals(c0761mM1872a);
        C0766r c0766rM1520b = C0766r.m1520b(iM1533g3, c0766rN.mo663a(), c0761mM1535i2);
        if (!C0825aa.m1752a() || (z && RunnableC0841aq.m1874a(c0761mM1535i2, c0761mM1535i) && this.f2148a.f2144d == 0)) {
            m1883a(iM1533g, c0766rM1520b);
            return;
        }
        if (z && c0761mM1535i == null && this.f2148a.f2144d == 0) {
            this.f2152e.put(c0870z, AbstractC0836al.m1822a(new C0765q(C0773y.m1597g(c0766rM1520b), C0774z.f1897a, (C0766r) null, C0768t.m1546a(C0766r.m1517a(c0766rM1520b.m1533g(), c0766rM1520b.mo663a(), c0761mM1535i2))), this.f2149b));
            m1883a(iM1533g, c0766rM1520b);
        } else {
            m1884a((AbstractC0836al) c0870z);
            this.f2151d.add(c0870z);
        }
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: b */
    public final void mo1730b(C0870z c0870z) {
        c0870z.mo1761a(this.f2153f);
        m1884a((AbstractC0836al) c0870z);
    }
}
