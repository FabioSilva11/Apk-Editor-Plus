package com.p016a.p019b.p035e;

import com.p016a.p017a.C0406e;
import com.p016a.p017a.C0410i;
import java.util.Comparator;

/* JADX INFO: renamed from: com.a.b.e.u */
/* JADX INFO: loaded from: classes.dex */
final class C0738u {

    /* JADX INFO: renamed from: a */
    public static final Comparator f1601a = new C0739v();

    /* JADX INFO: renamed from: b */
    private final C0410i f1602b;

    /* JADX INFO: renamed from: c */
    private C0406e f1603c;

    /* JADX INFO: renamed from: d */
    private int f1604d = -1;

    public C0738u(C0410i c0410i, C0406e c0406e) {
        this.f1602b = c0410i;
        this.f1603c = c0406e;
    }

    /* JADX INFO: renamed from: a */
    public final C0410i m1432a() {
        return this.f1602b;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1433a(C0738u[] c0738uArr) {
        int iMax;
        if (this.f1603c.m325c() == -1) {
            iMax = 0;
        } else {
            C0738u c0738u = c0738uArr[this.f1603c.m325c()];
            if (c0738u == null) {
                iMax = 1;
            } else {
                if (c0738u.f1604d == -1) {
                    return false;
                }
                iMax = c0738u.f1604d;
            }
        }
        for (short s : this.f1603c.m327e()) {
            C0738u c0738u2 = c0738uArr[s];
            if (c0738u2 == null) {
                iMax = Math.max(iMax, 1);
            } else {
                if (c0738u2.f1604d == -1) {
                    return false;
                }
                iMax = Math.max(iMax, c0738u2.f1604d);
            }
        }
        this.f1604d = iMax + 1;
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final C0406e m1434b() {
        return this.f1603c;
    }

    /* JADX INFO: renamed from: c */
    public final int m1435c() {
        return this.f1603c.m324b();
    }

    /* JADX INFO: renamed from: d */
    public final boolean m1436d() {
        return this.f1604d != -1;
    }
}
