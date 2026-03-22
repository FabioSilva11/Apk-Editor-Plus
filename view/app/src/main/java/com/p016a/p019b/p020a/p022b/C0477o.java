package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.a.b.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0477o extends C0877g {

    /* JADX INFO: renamed from: a */
    public static final C0477o f571a = new C0477o(0);

    public C0477o(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0477o m624a(C0477o c0477o, C0477o c0477o2) {
        if (c0477o == f571a) {
            return c0477o2;
        }
        int iD_ = c0477o.m1977d_();
        int iD_2 = c0477o2.m1977d_();
        C0477o c0477o3 = new C0477o(iD_ + iD_2);
        for (int i = 0; i < iD_; i++) {
            c0477o3.m625a(i, c0477o.m626b(i));
        }
        for (int i2 = 0; i2 < iD_2; i2++) {
            c0477o3.m625a(iD_ + i2, c0477o2.m626b(i2));
        }
        return c0477o3;
    }

    /* JADX INFO: renamed from: a */
    private void m625a(int i, C0478p c0478p) {
        if (c0478p == null) {
            throw new NullPointerException("item == null");
        }
        m1975a(i, (Object) c0478p);
    }

    /* JADX INFO: renamed from: b */
    private C0478p m626b(int i) {
        return (C0478p) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final int m627a(int i) {
        int iD_ = m1977d_();
        int i2 = 0;
        int i3 = -1;
        int iM630b = -1;
        while (i2 < iD_) {
            C0478p c0478pM626b = m626b(i2);
            int iM629a = c0478pM626b.m629a();
            if (iM629a <= i && iM629a > i3) {
                iM630b = c0478pM626b.m630b();
                if (iM629a == i) {
                    break;
                }
            } else {
                iM629a = i3;
            }
            i2++;
            i3 = iM629a;
        }
        return iM630b;
    }

    /* JADX INFO: renamed from: a */
    public final void m628a(int i, int i2, int i3) {
        m1975a(i, (Object) new C0478p(i2, i3));
    }
}
