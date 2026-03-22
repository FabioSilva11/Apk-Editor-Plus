package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0768t;

/* JADX INFO: renamed from: com.a.b.g.ap */
/* JADX INFO: loaded from: classes.dex */
final class C0840ap implements InterfaceC0837am {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0838an f2140a;

    C0840ap(C0838an c0838an) {
        this.f2140a = c0838an;
    }

    /* JADX INFO: renamed from: a */
    private void m1871a(AbstractC0836al abstractC0836al) {
        C0768t c0768tMo1756a = abstractC0836al.mo1756a();
        int iD_ = c0768tMo1756a.m1977d_();
        for (int i = 0; i < iD_; i++) {
            this.f2140a.f2136j[c0768tMo1756a.m1553b(i).m1533g()].add(abstractC0836al);
        }
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1728a(C0827ac c0827ac) {
        m1871a((AbstractC0836al) c0827ac);
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1729a(C0870z c0870z) {
        m1871a((AbstractC0836al) c0870z);
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: b */
    public final void mo1730b(C0870z c0870z) {
        m1871a((AbstractC0836al) c0870z);
    }
}
