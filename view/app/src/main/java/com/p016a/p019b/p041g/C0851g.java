package com.p016a.p019b.p041g;

import com.p016a.p019b.p043h.C0871a;
import com.p016a.p019b.p043h.C0884n;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.g.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0851g {

    /* JADX INFO: renamed from: a */
    private static boolean f2168a = false;

    /* JADX INFO: renamed from: b */
    private final C0838an f2169b;

    /* JADX INFO: renamed from: c */
    private final ArrayList f2170c;

    /* JADX INFO: renamed from: d */
    private final C0852h[] f2171d;

    public C0851g(C0838an c0838an) {
        this.f2169b = c0838an;
        this.f2170c = c0838an.m1864j();
        int size = this.f2170c.size();
        this.f2171d = new C0852h[size];
        for (int i = 0; i < size; i++) {
            this.f2171d[i] = new C0852h();
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0852h[] m1900a() {
        int size = this.f2170c.size();
        C0853i.m1902a(this.f2169b, this.f2171d, false);
        int size2 = this.f2170c.size();
        for (int i = 0; i < size2; i++) {
            C0852h c0852h = this.f2171d[i];
            if (c0852h.f2173b != -1) {
                ((C0833ai) this.f2170c.get(c0852h.f2173b)).m1795a((C0833ai) this.f2170c.get(i));
            }
        }
        for (int i2 = 0; i2 < size; i2++) {
            this.f2171d[i2].f2172a = size <= 3072 ? new C0871a(size) : new C0884n();
        }
        int size3 = this.f2170c.size();
        for (int i3 = 0; i3 < size3; i3++) {
            C0833ai c0833ai = (C0833ai) this.f2170c.get(i3);
            C0852h c0852h2 = this.f2171d[i3];
            BitSet bitSetM1809g = c0833ai.m1809g();
            if (bitSetM1809g.cardinality() > 1) {
                for (int iNextSetBit = bitSetM1809g.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSetM1809g.nextSetBit(iNextSetBit + 1)) {
                    int i4 = iNextSetBit;
                    while (i4 != c0852h2.f2173b && i4 != -1) {
                        C0852h c0852h3 = this.f2171d[i4];
                        if (!c0852h3.f2172a.mo1947b(i3)) {
                            c0852h3.f2172a.mo1944a(i3);
                            i4 = c0852h3.f2173b;
                        }
                    }
                }
            }
        }
        return this.f2171d;
    }
}
