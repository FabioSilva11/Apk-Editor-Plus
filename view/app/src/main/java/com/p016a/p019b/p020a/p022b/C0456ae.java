package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0880j;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.a.b.ae */
/* JADX INFO: loaded from: classes.dex */
final class C0456ae {

    /* JADX INFO: renamed from: a */
    private BitSet f493a;

    /* JADX INFO: renamed from: b */
    private BitSet f494b;

    /* JADX INFO: renamed from: c */
    private int f495c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ C0486x f496d;

    C0456ae(C0486x c0486x, int i) {
        this.f496d = c0486x;
        this.f495c = i;
        this.f494b = new BitSet(c0486x.f588d);
        this.f493a = new BitSet(c0486x.f588d);
        C0486x.m682a(c0486x, true);
    }

    C0456ae(C0486x c0486x, int i, int i2) {
        this(c0486x, i);
        m508a(i2);
    }

    /* JADX INFO: renamed from: a */
    final int m507a() {
        return this.f495c;
    }

    /* JADX INFO: renamed from: a */
    final void m508a(int i) {
        this.f494b.set(i);
    }

    /* JADX INFO: renamed from: a */
    final void m509a(C0476n c0476n, int[] iArr) {
        int iNextSetBit = this.f493a.nextSetBit(0);
        while (iNextSetBit >= 0) {
            int iM1986b = this.f496d.m692c(iNextSetBit).m1458c().m1986b(0);
            C0476n c0476nM612a = c0476n.m612a(this.f495c, iNextSetBit);
            if (c0476nM612a != null) {
                this.f496d.m674a(iM1986b, -1, null, c0476nM612a, iArr);
            } else {
                C0985a.m2246b(iArr, iNextSetBit);
            }
            iNextSetBit = this.f493a.nextSetBit(iNextSetBit + 1);
        }
    }

    /* JADX INFO: renamed from: b */
    final C0880j m510b() {
        C0880j c0880j = new C0880j(this.f493a.size());
        int iNextSetBit = this.f493a.nextSetBit(0);
        while (iNextSetBit >= 0) {
            c0880j.m1988c(this.f496d.m692c(iNextSetBit).m1458c().m1986b(0));
            iNextSetBit = this.f493a.nextSetBit(iNextSetBit + 1);
        }
        c0880j.mo549b_();
        return c0880j;
    }

    /* JADX INFO: renamed from: b */
    final void m511b(int i) {
        this.f493a.set(i);
    }
}
