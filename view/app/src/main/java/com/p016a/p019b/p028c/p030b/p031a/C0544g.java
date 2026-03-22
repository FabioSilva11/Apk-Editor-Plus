package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0584i;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0888r;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.c.b.a.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0544g extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f709a = new C0544g();

    private C0544g() {
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final int mo845a() {
        return 2;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo846a(AbstractC0587l abstractC0587l) {
        return abstractC0587l.m963j().m1553b(0).m1539m() + ", " + m1003f(abstractC0587l);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo847a(AbstractC0587l abstractC0587l, boolean z) {
        return z ? m1004g(abstractC0587l) : "";
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final void mo848a(C0888r c0888r, AbstractC0587l abstractC0587l) {
        m993a(c0888r, m990a(abstractC0587l, abstractC0587l.m963j().m1553b(0).m1533g()), (short) ((C0584i) abstractC0587l).m938d());
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: b */
    public final boolean mo850b(AbstractC0587l abstractC0587l) {
        C0766r c0766rM1553b;
        if (!(abstractC0587l instanceof C0584i)) {
            return false;
        }
        C0768t c0768tM963j = abstractC0587l.m963j();
        switch (c0768tM963j.m1977d_()) {
            case 1:
                c0766rM1553b = c0768tM963j.m1553b(0);
                break;
            case 2:
                c0766rM1553b = c0768tM963j.m1553b(0);
                if (c0766rM1553b.m1533g() != c0768tM963j.m1553b(1).m1533g()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        if (!m998c(c0766rM1553b.m1533g())) {
            return false;
        }
        C0584i c0584i = (C0584i) abstractC0587l;
        int iM938d = c0584i.m938d();
        AbstractC0775a abstractC0775aM937c = c0584i.m937c();
        if (m1002e(iM938d)) {
            return (abstractC0775aM937c instanceof C0802z) || (abstractC0775aM937c instanceof C0788l) || (abstractC0775aM937c instanceof C0801y);
        }
        return false;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: c */
    public final BitSet mo851c(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        int iD_ = c0768tM963j.m1977d_();
        BitSet bitSet = new BitSet(iD_);
        boolean zC = m998c(c0768tM963j.m1553b(0).m1533g());
        if (iD_ == 1) {
            bitSet.set(0, zC);
        } else if (c0768tM963j.m1553b(0).m1533g() == c0768tM963j.m1553b(1).m1533g()) {
            bitSet.set(0, zC);
            bitSet.set(1, zC);
        }
        return bitSet;
    }
}
