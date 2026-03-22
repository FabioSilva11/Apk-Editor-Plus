package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0574al;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.b.a.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0543f extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f708a = new C0543f();

    private C0543f() {
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final int mo845a() {
        return 2;
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
        m993a(c0888r, m990a(abstractC0587l, 0), (short) ((C0574al) abstractC0587l).m912e());
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
