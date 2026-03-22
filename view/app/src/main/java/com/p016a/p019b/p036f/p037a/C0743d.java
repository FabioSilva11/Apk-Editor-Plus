package com.p016a.p019b.p036f.p037a;

import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.f.a.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0743d extends C0877g {

    /* JADX INFO: renamed from: a */
    public static final C0743d f1616a = new C0743d(0);

    public C0743d(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0743d m1451a(C0743d c0743d, C0743d c0743d2) {
        int iD_ = c0743d.m1977d_();
        if (iD_ != c0743d2.m1977d_()) {
            throw new IllegalArgumentException("list1.size() != list2.size()");
        }
        C0743d c0743d3 = new C0743d(iD_);
        for (int i = 0; i < iD_; i++) {
            c0743d3.m1453a(i, C0742c.m1445a(c0743d.m1452a(i), c0743d2.m1452a(i)));
        }
        c0743d3.mo549b_();
        return c0743d3;
    }

    /* JADX INFO: renamed from: a */
    public final C0742c m1452a(int i) {
        return (C0742c) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m1453a(int i, C0742c c0742c) {
        c0742c.m2005m();
        m1975a(i, (Object) c0742c);
    }
}
