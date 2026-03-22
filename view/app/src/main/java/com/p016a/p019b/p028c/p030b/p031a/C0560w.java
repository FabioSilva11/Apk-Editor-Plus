package com.p016a.p019b.p028c.p030b.p031a;

import com.p016a.p019b.p028c.p030b.AbstractC0587l;
import com.p016a.p019b.p028c.p030b.AbstractC0593r;
import com.p016a.p019b.p028c.p030b.C0584i;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.b.a.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0560w extends AbstractC0593r {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0593r f725a = new C0560w();

    private C0560w() {
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final int mo845a() {
        return 3;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo846a(AbstractC0587l abstractC0587l) {
        StringBuilder sb = new StringBuilder();
        C0768t c0768tM963j = abstractC0587l.m963j();
        int iD_ = c0768tM963j.m1977d_();
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("{");
        switch (iD_) {
            case 0:
                break;
            case 1:
                sb2.append(c0768tM963j.m1553b(0).m1539m());
                break;
            default:
                C0766r c0766rM1553b = c0768tM963j.m1553b(iD_ - 1);
                if (c0766rM1553b.m1537k() == 2) {
                    c0766rM1553b = c0766rM1553b.m1530b(1);
                }
                sb2.append(c0768tM963j.m1553b(0).m1539m());
                sb2.append("..");
                sb2.append(c0766rM1553b.m1539m());
                break;
        }
        sb2.append("}");
        return sb.append(sb2.toString()).append(", ").append(m1003f(abstractC0587l)).toString();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final String mo847a(AbstractC0587l abstractC0587l, boolean z) {
        return z ? m1004g(abstractC0587l) : "";
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: a */
    public final void mo848a(C0888r c0888r, AbstractC0587l abstractC0587l) {
        C0768t c0768tM963j = abstractC0587l.m963j();
        m994a(c0888r, m990a(abstractC0587l, c0768tM963j.m1557e()), (short) ((C0584i) abstractC0587l).m938d(), (short) (c0768tM963j.m1977d_() == 0 ? 0 : c0768tM963j.m1553b(0).m1533g()));
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0593r
    /* JADX INFO: renamed from: b */
    public final boolean mo850b(AbstractC0587l abstractC0587l) {
        boolean z;
        if (!(abstractC0587l instanceof C0584i)) {
            return false;
        }
        C0584i c0584i = (C0584i) abstractC0587l;
        int iM938d = c0584i.m938d();
        AbstractC0775a abstractC0775aM937c = c0584i.m937c();
        if (!m1002e(iM938d)) {
            return false;
        }
        if (!(abstractC0775aM937c instanceof C0798v) && !(abstractC0775aM937c instanceof C0802z)) {
            return false;
        }
        C0768t c0768tJ = c0584i.m963j();
        if (c0768tJ.m1977d_() != 0) {
            int iD_ = c0768tJ.m1977d_();
            if (iD_ < 2) {
                z = true;
                return z ? false : false;
            }
            int iM1533g = c0768tJ.m1553b(0).m1533g();
            for (int i = 0; i < iD_; i++) {
                C0766r c0766rM1553b = c0768tJ.m1553b(i);
                if (c0766rM1553b.m1533g() != iM1533g) {
                    z = false;
                    break;
                }
                iM1533g += c0766rM1553b.m1537k();
            }
            z = true;
            if (z || !m1002e(c0768tJ.m1553b(0).m1533g()) || !m998c(c0768tJ.m1557e())) {
                return false;
            }
        }
        return true;
    }
}
