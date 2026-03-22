package com.p016a.p019b.p036f.p038b;

import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.f.b.u */
/* JADX INFO: loaded from: classes.dex */
final class C0769u {

    /* JADX INFO: renamed from: a */
    private BitSet f1672a;

    /* JADX INFO: renamed from: b */
    private C0768t f1673b;

    /* JADX INFO: renamed from: c */
    private int f1674c;

    /* JADX INFO: renamed from: d */
    private C0768t f1675d;

    /* JADX INFO: renamed from: e */
    private boolean f1676e;

    private C0769u(C0768t c0768t, BitSet bitSet, int i, boolean z) {
        this.f1673b = c0768t;
        this.f1672a = bitSet;
        this.f1674c = i;
        this.f1675d = new C0768t(c0768t.m1977d_());
        this.f1676e = z;
    }

    /* synthetic */ C0769u(C0768t c0768t, BitSet bitSet, int i, boolean z, byte b2) {
        this(c0768t, bitSet, i, z);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C0768t m1560a(C0769u c0769u) {
        if (c0769u.f1673b.m2003k()) {
            c0769u.f1675d.mo549b_();
        }
        return c0769u.f1675d;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1561a(C0769u c0769u, int i) {
        boolean z = true;
        C0766r c0766rM1525a = (C0766r) c0769u.f1673b.m1978e(i);
        if (c0769u.f1672a != null && c0769u.f1672a.get(i)) {
            z = false;
        }
        if (z) {
            c0766rM1525a = c0766rM1525a.m1525a(c0769u.f1674c);
            if (!c0769u.f1676e) {
                c0769u.f1674c += c0766rM1525a.m1537k();
            }
            c0769u.f1676e = false;
        }
        c0769u.f1675d.m1975a(i, (Object) c0766rM1525a);
    }
}
