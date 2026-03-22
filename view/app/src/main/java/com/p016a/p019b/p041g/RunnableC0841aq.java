package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p040d.C0805c;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.g.aq */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0841aq implements Runnable {

    /* JADX INFO: renamed from: a */
    private final C0838an f2141a;

    /* JADX INFO: renamed from: b */
    private int f2142b;

    /* JADX INFO: renamed from: c */
    private final int f2143c;

    /* JADX INFO: renamed from: d */
    private int f2144d;

    /* JADX INFO: renamed from: e */
    private final C0766r[][] f2145e;

    /* JADX INFO: renamed from: f */
    private final ArrayList f2146f;

    public RunnableC0841aq(C0838an c0838an) {
        this.f2143c = c0838an.m1861g();
        this.f2141a = c0838an;
        this.f2142b = this.f2143c;
        this.f2144d = 0;
        this.f2145e = new C0766r[c0838an.m1864j().size()][];
        this.f2146f = new ArrayList();
        C0766r[] c0766rArr = new C0766r[this.f2143c];
        for (int i = 0; i < this.f2143c; i++) {
            c0766rArr[i] = C0766r.m1516a(i, C0805c.f2018i);
        }
        this.f2145e[c0838an.m1854c()] = c0766rArr;
    }

    public RunnableC0841aq(C0838an c0838an, int i) {
        this(c0838an);
        this.f2144d = i;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C0761m m1872a(RunnableC0841aq runnableC0841aq, int i) {
        if (i < runnableC0841aq.f2146f.size()) {
            return (C0761m) runnableC0841aq.f2146f.get(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1873a(RunnableC0841aq runnableC0841aq, C0766r c0766r) {
        int iM1533g = c0766r.m1533g();
        C0761m c0761mM1535i = c0766r.m1535i();
        runnableC0841aq.f2146f.ensureCapacity(iM1533g + 1);
        while (runnableC0841aq.f2146f.size() <= iM1533g) {
            runnableC0841aq.f2146f.add(null);
        }
        runnableC0841aq.f2146f.set(iM1533g, c0761mM1535i);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m1874a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C0766r[] m1875a(C0766r[] c0766rArr) {
        C0766r[] c0766rArr2 = new C0766r[c0766rArr.length];
        System.arraycopy(c0766rArr, 0, c0766rArr2, 0, c0766rArr.length);
        return c0766rArr2;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ boolean m1878b(RunnableC0841aq runnableC0841aq, int i) {
        return i < runnableC0841aq.f2144d;
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ boolean m1880c(RunnableC0841aq runnableC0841aq, int i) {
        return i < runnableC0841aq.f2143c;
    }

    /* JADX INFO: renamed from: d */
    static /* synthetic */ int m1881d(RunnableC0841aq runnableC0841aq) {
        int i = runnableC0841aq.f2142b;
        runnableC0841aq.f2142b = i + 1;
        return i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2141a.m1842a(new C0842ar(this));
        this.f2141a.m1859e(this.f2142b);
        this.f2141a.m1867m();
    }
}
