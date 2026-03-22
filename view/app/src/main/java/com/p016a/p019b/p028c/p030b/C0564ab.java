package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.c.b.ab */
/* JADX INFO: loaded from: classes.dex */
public final class C0564ab extends C0877g {

    /* JADX INFO: renamed from: a */
    private static C0564ab f736a = new C0564ab(0);

    private C0564ab(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0564ab m874a(C0588m c0588m, int i) {
        switch (i) {
            case 1:
                return f736a;
            case 2:
            case 3:
                C0774z c0774z = C0774z.f1897a;
                int iD_ = c0588m.m1977d_();
                C0565ac[] c0565acArr = new C0565ac[iD_];
                int i2 = 0;
                boolean z = false;
                C0774z c0774z2 = c0774z;
                for (int i3 = 0; i3 < iD_; i3++) {
                    AbstractC0587l abstractC0587lM968a = c0588m.m968a(i3);
                    if (abstractC0587lM968a instanceof C0583h) {
                        z = true;
                    } else {
                        C0774z c0774zM962i = abstractC0587lM968a.m962i();
                        if (!c0774zM962i.equals(c0774z) && !c0774zM962i.m1600a(c0774z2) && (i != 3 || z)) {
                            c0565acArr[i2] = new C0565ac(abstractC0587lM968a.m960g(), c0774zM962i);
                            i2++;
                            z = false;
                            c0774z2 = c0774zM962i;
                        }
                    }
                }
                C0564ab c0564ab = new C0564ab(i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    c0564ab.m1975a(i4, c0565acArr[i4]);
                }
                c0564ab.mo549b_();
                return c0564ab;
            default:
                throw new IllegalArgumentException("bogus howMuch");
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0565ac m875a(int i) {
        return (C0565ac) m1978e(i);
    }
}
