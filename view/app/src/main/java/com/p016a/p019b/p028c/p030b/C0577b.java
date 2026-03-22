package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p036f.p038b.C0751c;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p036f.p038b.C0774z;

/* JADX INFO: renamed from: com.a.b.c.b.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0577b {

    /* JADX INFO: renamed from: a */
    private final C0583h[] f766a;

    /* JADX INFO: renamed from: b */
    private final C0583h[] f767b;

    /* JADX INFO: renamed from: c */
    private final C0583h[] f768c;

    public C0577b(C0772x c0772x) {
        int iJ = c0772x.m1582a().m2001j();
        this.f766a = new C0583h[iJ];
        this.f767b = new C0583h[iJ];
        this.f768c = new C0583h[iJ];
        m915a(c0772x);
    }

    /* JADX INFO: renamed from: a */
    private void m915a(C0772x c0772x) {
        C0751c c0751cM1582a = c0772x.m1582a();
        int iD_ = c0751cM1582a.m1977d_();
        for (int i = 0; i < iD_; i++) {
            C0745a c0745aM1475a = c0751cM1582a.m1475a(i);
            int iMo559a = c0745aM1475a.mo559a();
            this.f766a[iMo559a] = new C0583h(c0745aM1475a.m1457b().m1497a(0).m1491g());
            C0774z c0774zM1491g = c0745aM1475a.m1462g().m1491g();
            this.f767b[iMo559a] = new C0583h(c0774zM1491g);
            this.f768c[iMo559a] = new C0583h(c0774zM1491g);
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0583h m916a(int i) {
        return this.f766a[i];
    }

    /* JADX INFO: renamed from: a */
    public final C0583h m917a(C0745a c0745a) {
        return this.f766a[c0745a.mo559a()];
    }

    /* JADX INFO: renamed from: b */
    public final C0583h m918b(C0745a c0745a) {
        return this.f767b[c0745a.mo559a()];
    }

    /* JADX INFO: renamed from: c */
    public final C0583h m919c(C0745a c0745a) {
        return this.f768c[c0745a.mo559a()];
    }
}
