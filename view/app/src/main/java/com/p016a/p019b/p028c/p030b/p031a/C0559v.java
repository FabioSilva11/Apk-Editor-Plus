package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0584i;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0888r;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.c.b.a.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0559v extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f724a = new C0559v();

    private C0559v() {
    }

    /* JADX INFO: renamed from: b */
    private static int m852b(C0768t c0768t) {
        int i = 0;
        int iD_ = c0768t.m1977d_();
        if (iD_ > 5) {
            return -1;
        }
        int i2 = 0;
        while (i2 < iD_) {
            int iM1537k = c0768t.m1553b(i2).m1537k() + i;
            if (!m995a((r5.m1533g() + r5.m1537k()) - 1)) {
                return -1;
            }
            i2++;
            i = iM1537k;
        }
        if (i <= 5) {
            return i;
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    private static C0768t m853c(C0768t c0768t) {
        int i = 0;
        int iM852b = m852b(c0768t);
        int iD_ = c0768t.m1977d_();
        if (iM852b == iD_) {
            return c0768t;
        }
        C0768t c0768t2 = new C0768t(iM852b);
        for (int i2 = 0; i2 < iD_; i2++) {
            C0766r c0766rM1553b = c0768t.m1553b(i2);
            c0768t2.m1552a(i, c0766rM1553b);
            if (c0766rM1553b.m1537k() == 2) {
                c0768t2.m1552a(i + 1, C0766r.m1516a(c0766rM1553b.m1533g() + 1, C0805c.f2018i));
                i += 2;
            } else {
                i++;
            }
        }
        c0768t2.mo549b_();
        return c0768t2;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final int mo845a() {
        return 3;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo846a(AbstractC0587l abstractC0587l) {
        return m986a(m853c(abstractC0587l.m963j())) + ", " + m1003f(abstractC0587l);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo847a(AbstractC0587l abstractC0587l, boolean z) {
        return z ? m1004g(abstractC0587l) : "";
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final void mo848a(C0888r c0888r, AbstractC0587l abstractC0587l) {
        int iM938d = ((C0584i) abstractC0587l).m938d();
        C0768t c0768tM853c = m853c(abstractC0587l.m963j());
        int iD_ = c0768tM853c.m1977d_();
        int iM1533g = iD_ > 0 ? c0768tM853c.m1553b(0).m1533g() : 0;
        int iM1533g2 = iD_ > 1 ? c0768tM853c.m1553b(1).m1533g() : 0;
        int iM1533g3 = iD_ > 2 ? c0768tM853c.m1553b(2).m1533g() : 0;
        int iM1533g4 = iD_ > 3 ? c0768tM853c.m1553b(3).m1533g() : 0;
        short sA = m990a(abstractC0587l, m996b(iD_ > 4 ? c0768tM853c.m1553b(4).m1533g() : 0, iD_));
        short s = (short) iM938d;
        if ((iM1533g & 15) != iM1533g) {
            throw new IllegalArgumentException("n0 out of range 0..15");
        }
        if ((iM1533g2 & 15) != iM1533g2) {
            throw new IllegalArgumentException("n1 out of range 0..15");
        }
        if ((iM1533g3 & 15) != iM1533g3) {
            throw new IllegalArgumentException("n2 out of range 0..15");
        }
        if ((iM1533g4 & 15) != iM1533g4) {
            throw new IllegalArgumentException("n3 out of range 0..15");
        }
        m994a(c0888r, sA, s, (short) ((iM1533g4 << 12) | (iM1533g3 << 8) | (iM1533g2 << 4) | iM1533g));
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: b */
    public final boolean mo850b(AbstractC0587l abstractC0587l) {
        if (!(abstractC0587l instanceof C0584i)) {
            return false;
        }
        C0584i c0584i = (C0584i) abstractC0587l;
        if (!m1002e(c0584i.m938d())) {
            return false;
        }
        AbstractC0775a abstractC0775aM937c = c0584i.m937c();
        return ((abstractC0775aM937c instanceof C0798v) || (abstractC0775aM937c instanceof C0802z)) && m852b(c0584i.m963j()) >= 0;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: c */
    public final BitSet mo851c(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        int iD_ = c0768tM963j.m1977d_();
        BitSet bitSet = new BitSet(iD_);
        for (int i = 0; i < iD_; i++) {
            C0766r c0766rM1553b = c0768tM963j.m1553b(i);
            bitSet.set(i, m995a((c0766rM1553b.m1537k() + c0766rM1553b.m1533g()) - 1));
        }
        return bitSet;
    }
}
