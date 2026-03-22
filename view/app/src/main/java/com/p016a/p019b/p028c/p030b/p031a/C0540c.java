package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0584i;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0795s;
import com.p016a.p019b.p043h.C0888r;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.c.b.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0540c extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f705a = new C0540c();

    private C0540c() {
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final int mo845a() {
        return 1;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo846a(AbstractC0587l abstractC0587l) {
        return abstractC0587l.m963j().m1553b(0).m1539m() + ", " + m987a((AbstractC0795s) ((C0584i) abstractC0587l).m937c());
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo847a(AbstractC0587l abstractC0587l, boolean z) {
        return m988a((AbstractC0795s) ((C0584i) abstractC0587l).m937c(), 4);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final void mo848a(C0888r c0888r, AbstractC0587l abstractC0587l) {
        c0888r.m2018b(m990a(abstractC0587l, m996b(abstractC0587l.m963j().m1553b(0).m1533g(), ((AbstractC0795s) ((C0584i) abstractC0587l).m937c()).mo1632j() & 15)));
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: b */
    public final boolean mo850b(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        if (!(abstractC0587l instanceof C0584i) || c0768tM963j.m1977d_() != 1 || !m995a(c0768tM963j.m1553b(0).m1533g())) {
            return false;
        }
        AbstractC0775a abstractC0775aM937c = ((C0584i) abstractC0587l).m937c();
        if (!(abstractC0775aM937c instanceof AbstractC0795s)) {
            return false;
        }
        AbstractC0795s abstractC0795s = (AbstractC0795s) abstractC0775aM937c;
        if (abstractC0795s.mo1631i()) {
            int iMo1632j = abstractC0795s.mo1632j();
            if (iMo1632j >= -8 && iMo1632j <= 7) {
                return true;
            }
        }
        return false;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: c */
    public final BitSet mo851c(AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        BitSet bitSet = new BitSet(1);
        bitSet.set(0, m995a(c0768tM963j.m1553b(0).m1533g()));
        return bitSet;
    }
}
