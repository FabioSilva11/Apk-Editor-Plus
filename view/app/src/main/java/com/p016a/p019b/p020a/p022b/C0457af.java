package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p043h.C0880j;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.a.b.af */
/* JADX INFO: loaded from: classes.dex */
final class C0457af {

    /* JADX INFO: renamed from: a */
    private final HashMap f497a = new HashMap();

    /* JADX INFO: renamed from: b */
    private final BitSet f498b;

    /* JADX INFO: renamed from: c */
    private int f499c;

    /* JADX INFO: renamed from: d */
    private int f500d;

    /* JADX INFO: renamed from: e */
    private final C0455ad f501e;

    /* JADX INFO: renamed from: f */
    private final ArrayList f502f;

    /* JADX INFO: renamed from: g */
    private /* synthetic */ C0486x f503g;

    C0457af(C0486x c0486x, C0455ad c0455ad, ArrayList arrayList) {
        this.f503g = c0486x;
        this.f498b = new BitSet(c0486x.f588d);
        this.f501e = c0455ad;
        this.f502f = arrayList;
    }

    /* JADX INFO: renamed from: a */
    private int m512a(int i) {
        Integer num = (Integer) this.f497a.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        int i2 = this.f499c;
        C0880j c0880j = (C0880j) this.f502f.get(i);
        if (!(c0880j != null && c0880j.m1985b() > 0 && c0880j.m1990d() == i2)) {
            return i;
        }
        int iMo504a = this.f501e.mo504a();
        this.f498b.set(i);
        this.f497a.put(Integer.valueOf(i), Integer.valueOf(iMo504a));
        while (this.f502f.size() <= iMo504a) {
            this.f502f.add(null);
        }
        this.f502f.set(iMo504a, this.f502f.get(i));
        return iMo504a;
    }

    /* JADX INFO: renamed from: a */
    final void m513a(C0745a c0745a) {
        C0880j c0880jM1982a;
        this.f500d = c0745a.m1458c().m1986b(0);
        this.f499c = c0745a.m1458c().m1986b(1);
        int iM512a = m512a(this.f499c);
        int iNextSetBit = this.f498b.nextSetBit(0);
        while (iNextSetBit >= 0) {
            this.f498b.clear(iNextSetBit);
            int iIntValue = ((Integer) this.f497a.get(Integer.valueOf(iNextSetBit))).intValue();
            C0745a c0745aM692c = this.f503g.m692c(iNextSetBit);
            C0880j c0880jM1458c = c0745aM692c.m1458c();
            int i = -1;
            if (this.f503g.m683a(c0745aM692c)) {
                c0880jM1982a = C0880j.m1983a(m512a(c0880jM1458c.m1986b(0)), c0880jM1458c.m1986b(1));
            } else {
                C0456ae c0456aeM687b = C0486x.m687b(this.f503g, iNextSetBit);
                if (c0456aeM687b == null) {
                    int iM1459d = c0745aM692c.m1459d();
                    int iM1985b = c0880jM1458c.m1985b();
                    C0880j c0880j = new C0880j(iM1985b);
                    int i2 = 0;
                    while (i2 < iM1985b) {
                        int iM1986b = c0880jM1458c.m1986b(i2);
                        int iM512a2 = m512a(iM1986b);
                        c0880j.m1988c(iM512a2);
                        if (iM1459d != iM1986b) {
                            iM512a2 = i;
                        }
                        i2++;
                        i = iM512a2;
                    }
                    c0880j.mo549b_();
                    c0880jM1982a = c0880j;
                } else {
                    if (c0456aeM687b.f495c != this.f499c) {
                        throw new RuntimeException("ret instruction returns to label " + C0985a.m2296v(c0456aeM687b.f495c) + " expected: " + C0985a.m2296v(this.f499c));
                    }
                    c0880jM1982a = C0880j.m1982a(this.f500d);
                    i = this.f500d;
                }
            }
            this.f503g.m679a(new C0745a(iIntValue, C0486x.m672a(this.f503g, c0745aM692c.m1457b()), c0880jM1982a, i), (C0880j) this.f502f.get(iIntValue));
            if (this.f503g.m683a(this.f503g.m692c(iNextSetBit))) {
                new C0457af(this.f503g, this.f501e, this.f502f).m513a(this.f503g.m692c(iIntValue));
            }
            iNextSetBit = this.f498b.nextSetBit(0);
        }
        C0486x.m681a(this.f503g, new C0745a(c0745a.mo559a(), c0745a.m1457b(), C0880j.m1982a(iM512a), iM512a), (C0880j) this.f502f.get(c0745a.mo559a()));
    }
}
