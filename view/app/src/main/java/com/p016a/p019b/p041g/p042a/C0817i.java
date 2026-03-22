package com.p016a.p019b.p041g.p042a;

import com.p016a.p019b.p041g.C0849e;
import com.p016a.p019b.p043h.InterfaceC0881k;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.g.a.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0817i {

    /* JADX INFO: renamed from: a */
    private final ArrayList f2064a;

    public C0817i(int i) {
        this.f2064a = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f2064a.add(C0849e.m1892a(i));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1737a(int i, int i2) {
        int iMax = Math.max(i, i2) + 1;
        this.f2064a.ensureCapacity(iMax);
        for (int size = this.f2064a.size(); size < iMax; size++) {
            this.f2064a.add(C0849e.m1892a(iMax));
        }
        ((InterfaceC0881k) this.f2064a.get(i)).mo1944a(i2);
        ((InterfaceC0881k) this.f2064a.get(i2)).mo1944a(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m1738a(int i, InterfaceC0881k interfaceC0881k) {
        if (i < this.f2064a.size()) {
            interfaceC0881k.mo1945a((InterfaceC0881k) this.f2064a.get(i));
        }
    }
}
