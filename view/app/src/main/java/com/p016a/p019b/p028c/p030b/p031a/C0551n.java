package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0574al;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p043h.C0888r;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.c.b.a.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0551n extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f716a = new C0551n();

    private C0551n() {
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final int mo845a() {
        return 2;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo846a(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        return c0768tM963j.m1553b(0).m1539m() + ", " + c0768tM963j.m1553b(1).m1539m() + ", " + m999d(abstractC0587l);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo847a(AbstractC0587l abstractC0587l, boolean z) {
        return m1001e(abstractC0587l);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final void mo848a(C0888r c0888r, AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        m993a(c0888r, m990a(abstractC0587l, m996b(c0768tM963j.m1553b(0).m1533g(), c0768tM963j.m1553b(1).m1533g())), (short) ((C0574al) abstractC0587l).m912e());
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final boolean mo849a(C0574al c0574al) {
        int iM912e = c0574al.m912e();
        return iM912e != 0 && m1000d(iM912e);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: b */
    public final boolean mo850b(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        if (!(abstractC0587l instanceof C0574al) || c0768tM963j.m1977d_() != 2 || !m995a(c0768tM963j.m1553b(0).m1533g()) || !m995a(c0768tM963j.m1553b(1).m1533g())) {
            return false;
        }
        C0574al c0574al = (C0574al) abstractC0587l;
        if (c0574al.m913n()) {
            return mo849a(c0574al);
        }
        return true;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: c */
    public final BitSet mo851c(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, m995a(c0768tM963j.m1553b(0).m1533g()));
        bitSet.set(1, m995a(c0768tM963j.m1553b(1).m1533g()));
        return bitSet;
    }
}
