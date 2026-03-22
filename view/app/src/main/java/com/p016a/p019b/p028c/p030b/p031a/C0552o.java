package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0571ai;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p043h.C0888r;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.c.b.a.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0552o extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f717a = new C0552o();

    private C0552o() {
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
        return c0768tM963j.m1553b(0).m1539m() + ", " + c0768tM963j.m1553b(1).m1539m();
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
        m993a(c0888r, m990a(abstractC0587l, c0768tM963j.m1553b(0).m1533g()), (short) c0768tM963j.m1553b(1).m1533g());
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: b */
    public final boolean mo850b(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        return (abstractC0587l instanceof C0571ai) && c0768tM963j.m1977d_() == 2 && m998c(c0768tM963j.m1553b(0).m1533g()) && m1002e(c0768tM963j.m1553b(1).m1533g());
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: c */
    public final BitSet mo851c(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, m998c(c0768tM963j.m1553b(0).m1533g()));
        bitSet.set(1, m1002e(c0768tM963j.m1553b(1).m1533g()));
        return bitSet;
    }
}
