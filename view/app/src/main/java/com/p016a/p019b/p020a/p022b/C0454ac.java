package com.p016a.p019b.p020a.p022b;

/* JADX INFO: renamed from: com.a.b.a.b.ac */
/* JADX INFO: loaded from: classes.dex */
final class C0454ac extends C0455ad {

    /* JADX INFO: renamed from: b */
    private int f491b;

    C0454ac(C0486x c0486x) {
        super(c0486x.f588d);
        this.f491b = c0486x.f588d + c0486x.f585a.m594l().m1977d_();
    }

    @Override // com.p016a.p019b.p020a.p022b.C0455ad
    /* JADX INFO: renamed from: a */
    final int mo504a() {
        if (this.f492a >= this.f491b) {
            throw new IndexOutOfBoundsException();
        }
        int i = this.f492a;
        this.f492a = i + 1;
        return i;
    }
}
