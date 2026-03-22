package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0571ai;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p043h.C0888r;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.c.b.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0542e extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f707a = new C0542e();

    private C0542e() {
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final int mo845a() {
        return 1;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo846a(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        int iD_ = c0768tM963j.m1977d_();
        return c0768tM963j.m1553b(iD_ - 2).m1539m() + ", " + c0768tM963j.m1553b(iD_ - 1).m1539m();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo847a(AbstractC0587l abstractC0587l, boolean z) {
        return "";
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final void mo848a(C0888r c0888r, AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        int iD_ = c0768tM963j.m1977d_();
        c0888r.m2018b(m990a(abstractC0587l, m996b(c0768tM963j.m1553b(iD_ - 2).m1533g(), c0768tM963j.m1553b(iD_ - 1).m1533g())));
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: b */
    public final boolean mo850b(AbstractC0587l abstractC0587l) {
        C0766r c0766rM1553b;
        C0766r c0766rM1553b2;
        if (!(abstractC0587l instanceof C0571ai)) {
            return false;
        }
        C0768t c0768tM963j = abstractC0587l.m963j();
        switch (c0768tM963j.m1977d_()) {
            case 2:
                c0766rM1553b = c0768tM963j.m1553b(0);
                c0766rM1553b2 = c0768tM963j.m1553b(1);
                break;
            case 3:
                c0766rM1553b = c0768tM963j.m1553b(1);
                c0766rM1553b2 = c0768tM963j.m1553b(2);
                if (c0766rM1553b.m1533g() != c0768tM963j.m1553b(0).m1533g()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return m995a(c0766rM1553b.m1533g()) && m995a(c0766rM1553b2.m1533g());
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: c */
    public final BitSet mo851c(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        BitSet bitSet = new BitSet(2);
        int iM1533g = c0768tM963j.m1553b(0).m1533g();
        int iM1533g2 = c0768tM963j.m1553b(1).m1533g();
        switch (c0768tM963j.m1977d_()) {
            case 2:
                bitSet.set(0, m995a(iM1533g));
                bitSet.set(1, m995a(iM1533g2));
                return bitSet;
            case 3:
                if (iM1533g != iM1533g2) {
                    bitSet.set(0, false);
                    bitSet.set(1, false);
                } else {
                    boolean zA = m995a(iM1533g2);
                    bitSet.set(0, zA);
                    bitSet.set(1, zA);
                }
                bitSet.set(2, m995a(c0768tM963j.m1553b(2).m1533g()));
                return bitSet;
            default:
                throw new AssertionError();
        }
    }
}
