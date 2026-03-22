package com.p016a.p019b.p041g;

/* JADX INFO: renamed from: com.a.b.g.k */
/* JADX INFO: loaded from: classes.dex */
final class C0855k implements InterfaceC0835ak {

    /* JADX INFO: renamed from: a */
    private int f2185a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0853i f2186b;

    private C0855k(C0853i c0853i) {
        this.f2186b = c0853i;
        this.f2185a = 0;
    }

    /* synthetic */ C0855k(C0853i c0853i, byte b2) {
        this(c0853i);
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0835ak
    /* JADX INFO: renamed from: a */
    public final void mo1748a(C0833ai c0833ai, C0833ai c0833ai2) {
        C0854j c0854j = new C0854j();
        int i = this.f2185a + 1;
        this.f2185a = i;
        c0854j.f2180a = i;
        c0854j.f2182c = c0833ai;
        c0854j.f2181b = c0833ai2;
        this.f2186b.f2178e.add(c0833ai);
        this.f2186b.f2177d[c0833ai.m1806e()] = c0854j;
    }
}
