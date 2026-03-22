package com.p016a.p019b.p041g.p042a;

import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p041g.AbstractC0836al;
import com.p016a.p019b.p041g.C0833ai;
import com.p016a.p019b.p041g.InterfaceC0835ak;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.g.a.o */
/* JADX INFO: loaded from: classes.dex */
final class C0823o implements InterfaceC0835ak {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ArrayList f2084a;

    C0823o(C0822n c0822n, ArrayList arrayList) {
        this.f2084a = arrayList;
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0835ak
    /* JADX INFO: renamed from: a */
    public final void mo1748a(C0833ai c0833ai, C0833ai c0833ai2) {
        ArrayList arrayListM1801c = c0833ai.m1801c();
        if (arrayListM1801c.size() == 1 && ((AbstractC0836al) arrayListM1801c.get(0)).mo1765c() == C0773y.f1889s) {
            BitSet bitSet = (BitSet) c0833ai.m1809g().clone();
            for (int iNextSetBit = bitSet.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1)) {
                ((C0833ai) this.f2084a.get(iNextSetBit)).m1790a(c0833ai.m1806e(), c0833ai.m1812j());
            }
        }
    }
}
