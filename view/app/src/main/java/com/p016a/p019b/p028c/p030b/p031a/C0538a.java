package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0574al;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.b.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0538a extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f703a = new C0538a();

    private C0538a() {
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final int mo845a() {
        return 1;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo846a(AbstractC0587l abstractC0587l) {
        return m999d(abstractC0587l);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo847a(AbstractC0587l abstractC0587l, boolean z) {
        return m1001e(abstractC0587l);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final void mo848a(C0888r c0888r, AbstractC0587l abstractC0587l) {
        c0888r.m2018b(m990a(abstractC0587l, ((C0574al) abstractC0587l).m912e() & 255));
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final boolean mo849a(C0574al c0574al) {
        int iM912e = c0574al.m912e();
        return iM912e != 0 && m997b(iM912e);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: b */
    public final boolean mo850b(AbstractC0587l abstractC0587l) {
        if (!(abstractC0587l instanceof C0574al) || abstractC0587l.m963j().m1977d_() != 0) {
            return false;
        }
        C0574al c0574al = (C0574al) abstractC0587l;
        if (c0574al.m913n()) {
            return mo849a(c0574al);
        }
        return true;
    }
}
