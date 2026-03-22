package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.a.b.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0479q extends C0877g {

    /* JADX INFO: renamed from: a */
    public static final C0479q f574a = new C0479q(0);

    public C0479q(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0479q m631a(C0479q c0479q, C0479q c0479q2) {
        if (c0479q == f574a) {
            return c0479q2;
        }
        int iD_ = c0479q.m1977d_();
        int iD_2 = c0479q2.m1977d_();
        C0479q c0479q3 = new C0479q(iD_ + iD_2);
        for (int i = 0; i < iD_; i++) {
            c0479q3.m633a(i, c0479q.m632a(i));
        }
        for (int i2 = 0; i2 < iD_2; i2++) {
            c0479q3.m633a(iD_ + i2, c0479q2.m632a(i2));
        }
        c0479q3.mo549b_();
        return c0479q3;
    }

    /* JADX INFO: renamed from: a */
    private C0480r m632a(int i) {
        return (C0480r) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    private void m633a(int i, C0480r c0480r) {
        if (c0480r == null) {
            throw new NullPointerException("item == null");
        }
        m1975a(i, (Object) c0480r);
    }

    /* JADX INFO: renamed from: b */
    public static C0479q m634b(C0479q c0479q, C0479q c0479q2) {
        C0480r c0480r;
        int iD_ = c0479q.m1977d_();
        C0479q c0479q3 = new C0479q(iD_);
        for (int i = 0; i < iD_; i++) {
            C0480r c0480rM632a = c0479q.m632a(i);
            int iD_2 = c0479q2.m1977d_();
            int i2 = 0;
            while (true) {
                if (i2 >= iD_2) {
                    c0480r = null;
                    break;
                }
                c0480r = (C0480r) c0479q2.m1978e(i2);
                if (c0480r != null && c0480r.m641a(c0480rM632a)) {
                    break;
                }
                i2++;
            }
            c0479q3.m633a(i, c0480r != null ? c0480rM632a.m638a(c0480r.f579e) : c0480rM632a);
        }
        c0479q3.mo549b_();
        return c0479q3;
    }

    /* JADX INFO: renamed from: a */
    public final C0480r m635a(int i, int i2) {
        int iD_ = m1977d_();
        for (int i3 = 0; i3 < iD_; i3++) {
            C0480r c0480r = (C0480r) m1978e(i3);
            if (c0480r != null && c0480r.m640a(i, i2)) {
                return c0480r;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m636a(int i, int i2, int i3, C0801y c0801y, C0801y c0801y2, C0801y c0801y3, int i4) {
        m1975a(i, (Object) new C0480r(i2, i3, c0801y, c0801y2, c0801y3, i4));
    }
}
