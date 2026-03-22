package com.p016a.p019b.p041g;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

/* JADX INFO: renamed from: com.a.b.g.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0853i {

    /* JADX INFO: renamed from: a */
    private final boolean f2174a;

    /* JADX INFO: renamed from: b */
    private final C0838an f2175b;

    /* JADX INFO: renamed from: c */
    private final ArrayList f2176c;

    /* JADX INFO: renamed from: d */
    private final C0854j[] f2177d;

    /* JADX INFO: renamed from: e */
    private final ArrayList f2178e = new ArrayList();

    /* JADX INFO: renamed from: f */
    private final C0852h[] f2179f;

    private C0853i(C0838an c0838an, C0852h[] c0852hArr, boolean z) {
        this.f2175b = c0838an;
        this.f2179f = c0852hArr;
        this.f2174a = z;
        this.f2176c = c0838an.m1864j();
        this.f2177d = new C0854j[this.f2176c.size() + 2];
    }

    /* JADX INFO: renamed from: a */
    private C0833ai m1901a(C0833ai c0833ai) {
        C0854j c0854j = this.f2177d[c0833ai.m1806e()];
        if (c0854j.f2183d == null) {
            return c0833ai;
        }
        if (this.f2177d[this.f2177d[c0833ai.m1806e()].f2183d.m1806e()].f2183d != null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            arrayList.add(c0833ai);
            while (!arrayList.isEmpty()) {
                int size = arrayList.size();
                C0854j c0854j2 = this.f2177d[((C0833ai) arrayList.get(size - 1)).m1806e()];
                C0833ai c0833ai2 = c0854j2.f2183d;
                C0854j c0854j3 = this.f2177d[c0833ai2.m1806e()];
                if (!hashSet.add(c0833ai2) || c0854j3.f2183d == null) {
                    arrayList.remove(size - 1);
                    if (c0854j3.f2183d != null) {
                        C0833ai c0833ai3 = c0854j3.f2182c;
                        if (this.f2177d[c0833ai3.m1806e()].f2180a < this.f2177d[c0854j2.f2182c.m1806e()].f2180a) {
                            c0854j2.f2182c = c0833ai3;
                        }
                        c0854j2.f2183d = c0854j3.f2183d;
                    }
                } else {
                    arrayList.add(c0833ai2);
                }
            }
        }
        return c0854j.f2182c;
    }

    /* JADX INFO: renamed from: a */
    public static C0853i m1902a(C0838an c0838an, C0852h[] c0852hArr, boolean z) {
        int i;
        byte b2 = 0;
        C0853i c0853i = new C0853i(c0838an, c0852hArr, false);
        C0833ai c0833aiM1860f = c0853i.f2174a ? c0853i.f2175b.m1860f() : c0853i.f2175b.m1856d();
        if (c0833aiM1860f != null) {
            c0853i.f2178e.add(c0833aiM1860f);
            c0853i.f2179f[c0833aiM1860f.m1806e()].f2173b = c0833aiM1860f.m1806e();
        }
        c0853i.f2175b.m1849a(c0853i.f2174a, new C0855k(c0853i, b2));
        int size = c0853i.f2178e.size() - 1;
        for (int i2 = size; i2 >= 2; i2--) {
            C0833ai c0833ai = (C0833ai) c0853i.f2178e.get(i2);
            C0854j c0854j = c0853i.f2177d[c0833ai.m1806e()];
            BitSet bitSetM1810h = c0853i.f2174a ? c0833ai.m1810h() : c0833ai.m1809g();
            for (int iNextSetBit = bitSetM1810h.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSetM1810h.nextSetBit(iNextSetBit + 1)) {
                C0833ai c0833ai2 = (C0833ai) c0853i.f2176c.get(iNextSetBit);
                if (c0853i.f2177d[c0833ai2.m1806e()] != null && (i = c0853i.f2177d[c0853i.m1901a(c0833ai2).m1806e()].f2180a) < c0854j.f2180a) {
                    c0854j.f2180a = i;
                }
            }
            c0853i.f2177d[((C0833ai) c0853i.f2178e.get(c0854j.f2180a)).m1806e()].f2184e.add(c0833ai);
            c0854j.f2183d = c0854j.f2181b;
            ArrayList arrayList = c0853i.f2177d[c0854j.f2181b.m1806e()].f2184e;
            while (!arrayList.isEmpty()) {
                C0833ai c0833ai3 = (C0833ai) arrayList.remove(arrayList.size() - 1);
                C0833ai c0833aiM1901a = c0853i.m1901a(c0833ai3);
                if (c0853i.f2177d[c0833aiM1901a.m1806e()].f2180a < c0853i.f2177d[c0833ai3.m1806e()].f2180a) {
                    c0853i.f2179f[c0833ai3.m1806e()].f2173b = c0833aiM1901a.m1806e();
                } else {
                    c0853i.f2179f[c0833ai3.m1806e()].f2173b = c0854j.f2181b.m1806e();
                }
            }
        }
        for (int i3 = 2; i3 <= size; i3++) {
            C0833ai c0833ai4 = (C0833ai) c0853i.f2178e.get(i3);
            if (c0853i.f2179f[c0833ai4.m1806e()].f2173b != ((C0833ai) c0853i.f2178e.get(c0853i.f2177d[c0833ai4.m1806e()].f2180a)).m1806e()) {
                c0853i.f2179f[c0833ai4.m1806e()].f2173b = c0853i.f2179f[c0853i.f2179f[c0833ai4.m1806e()].f2173b].f2173b;
            }
        }
        return c0853i;
    }
}
