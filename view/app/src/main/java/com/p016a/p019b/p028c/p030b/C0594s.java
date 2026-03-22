package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.c.b.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0594s extends C0877g {

    /* JADX INFO: renamed from: a */
    public static final C0594s f1018a = new C0594s(0);

    public C0594s(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0594s m1005a(C0588m c0588m) {
        int iD_ = c0588m.m1977d_();
        C0597v c0597v = new C0597v(iD_);
        for (int i = 0; i < iD_; i++) {
            AbstractC0587l abstractC0587lM968a = c0588m.m968a(i);
            if (abstractC0587lM968a instanceof C0598w) {
                c0597v.m1028a(abstractC0587lM968a.m960g(), ((C0598w) abstractC0587lM968a).m1029c());
            } else if (abstractC0587lM968a instanceof C0599x) {
                c0597v.m1027a(abstractC0587lM968a.m960g(), ((C0599x) abstractC0587lM968a).m1031c());
            }
        }
        return c0597v.m1026a();
    }

    /* JADX INFO: renamed from: a */
    public final C0596u m1006a(int i) {
        return (C0596u) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m1007a(int i, C0596u c0596u) {
        m1975a(i, (Object) c0596u);
    }
}
