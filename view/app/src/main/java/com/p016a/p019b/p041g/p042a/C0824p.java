package com.p016a.p019b.p041g.p042a;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p041g.C0827ac;
import com.p016a.p019b.p041g.C0833ai;
import com.p016a.p019b.p041g.InterfaceC0829ae;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.g.a.p */
/* JADX INFO: loaded from: classes.dex */
final class C0824p implements InterfaceC0829ae {

    /* JADX INFO: renamed from: a */
    private final ArrayList f2085a;

    public C0824p(ArrayList arrayList) {
        this.f2085a = arrayList;
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0829ae
    /* JADX INFO: renamed from: a */
    public final void mo1749a(C0827ac c0827ac) {
        C0768t c0768tMo1756a = c0827ac.mo1756a();
        C0766r c0766rN = c0827ac.m1831n();
        int iD_ = c0768tMo1756a.m1977d_();
        for (int i = 0; i < iD_; i++) {
            ((C0833ai) this.f2085a.get(c0827ac.m1755a(i))).m1793a(c0766rN, c0768tMo1756a.m1553b(i));
        }
    }
}
