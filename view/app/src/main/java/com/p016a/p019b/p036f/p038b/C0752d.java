package com.p016a.p019b.p036f.p038b;

/* JADX INFO: renamed from: com.a.b.f.b.d */
/* JADX INFO: loaded from: classes.dex */
class C0752d implements InterfaceC0759k {

    /* JADX INFO: renamed from: a */
    private int f1627a = 0;

    /* JADX INFO: renamed from: a */
    private void m1483a(AbstractC0757i abstractC0757i) {
        C0766r c0766rM1492h = abstractC0757i.m1492h();
        if (c0766rM1492h != null) {
            m1484a(c0766rM1492h);
        }
        C0768t c0768tM1494j = abstractC0757i.m1494j();
        int iD_ = c0768tM1494j.m1977d_();
        for (int i = 0; i < iD_; i++) {
            m1484a(c0768tM1494j.m1553b(i));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1484a(C0766r c0766r) {
        int iM1536j = c0766r.m1536j();
        if (iM1536j > this.f1627a) {
            this.f1627a = iM1536j;
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m1485a() {
        return this.f1627a;
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public final void mo891a(C0746aa c0746aa) {
        m1483a((AbstractC0757i) c0746aa);
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public final void mo892a(C0747ab c0747ab) {
        m1483a((AbstractC0757i) c0747ab);
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public final void mo893a(C0748ac c0748ac) {
        m1483a((AbstractC0757i) c0748ac);
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public final void mo899a(C0756h c0756h) {
        m1483a((AbstractC0757i) c0756h);
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public final void mo889a(C0764p c0764p) {
        m1483a((AbstractC0757i) c0764p);
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public final void mo894a(C0765q c0765q) {
        m1483a((AbstractC0757i) c0765q);
    }
}
