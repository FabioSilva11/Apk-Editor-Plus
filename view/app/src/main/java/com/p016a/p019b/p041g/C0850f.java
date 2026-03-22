package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0766r;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.g.f */
/* JADX INFO: loaded from: classes.dex */
final class C0850f implements InterfaceC0837am {

    /* JADX INFO: renamed from: a */
    private BitSet f2167a;

    public C0850f(BitSet bitSet) {
        this.f2167a = bitSet;
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1728a(C0827ac c0827ac) {
        if (C0849e.m1899b(c0827ac)) {
            return;
        }
        this.f2167a.set(c0827ac.m1831n().m1533g());
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1729a(C0870z c0870z) {
        if (C0849e.m1899b(c0870z)) {
            return;
        }
        this.f2167a.set(c0870z.m1831n().m1533g());
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: b */
    public final void mo1730b(C0870z c0870z) {
        C0766r c0766rN = c0870z.m1831n();
        if (C0849e.m1899b(c0870z) || c0766rN == null) {
            return;
        }
        this.f2167a.set(c0766rN.m1533g());
    }
}
