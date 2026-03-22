package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0770v;

/* JADX INFO: renamed from: com.a.b.g.ag */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0831ag {
    /* JADX INFO: renamed from: a */
    public abstract int mo1698a();

    /* JADX INFO: renamed from: a */
    public abstract C0766r mo1700a(C0766r c0766r);

    /* JADX INFO: renamed from: a */
    public final C0768t m1774a(C0768t c0768t) {
        int iD_ = c0768t.m1977d_();
        C0768t c0768t2 = new C0768t(iD_);
        for (int i = 0; i < iD_; i++) {
            c0768t2.m1552a(i, mo1700a(c0768t.m1553b(i)));
        }
        c0768t2.mo549b_();
        return c0768t2.equals(c0768t) ? c0768t : c0768t2;
    }

    /* JADX INFO: renamed from: a */
    public final C0770v m1775a(C0770v c0770v) {
        int iM1567b = c0770v.m1567b();
        C0770v c0770v2 = new C0770v(mo1698a());
        for (int i = 0; i < iM1567b; i++) {
            C0766r c0766rM1562a = c0770v.m1562a(i);
            if (c0766rM1562a != null) {
                c0770v2.m1572d(mo1700a(c0766rM1562a));
            }
        }
        c0770v2.mo549b_();
        return c0770v2.equals(c0770v) ? c0770v : c0770v2;
    }
}
