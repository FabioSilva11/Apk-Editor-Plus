package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p043h.C0880j;
import com.p016a.p019b.p043h.C0886p;

/* JADX INFO: renamed from: com.a.b.a.b.ak */
/* JADX INFO: loaded from: classes.dex */
public final class C0462ak extends C0886p {

    /* JADX INFO: renamed from: a */
    private final C0880j f530a;

    /* JADX INFO: renamed from: b */
    private final C0880j f531b;

    /* JADX INFO: renamed from: c */
    private int f532c;

    public C0462ak(int i) {
        super(true);
        this.f530a = new C0880j(i);
        this.f531b = new C0880j(i + 1);
        this.f532c = i;
    }

    /* JADX INFO: renamed from: a */
    public final int m544a() {
        return this.f532c;
    }

    /* JADX INFO: renamed from: a */
    public final int m545a(int i) {
        return this.f530a.m1986b(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m546a(int i, int i2) {
        m2004l();
        if (i2 < 0) {
            throw new IllegalArgumentException("target < 0");
        }
        this.f530a.m1988c(i);
        this.f531b.m1988c(i2);
    }

    /* JADX INFO: renamed from: b */
    public final int m547b() {
        return this.f531b.m1986b(this.f532c);
    }

    /* JADX INFO: renamed from: b */
    public final int m548b(int i) {
        return this.f531b.m1986b(i);
    }

    @Override // com.p016a.p019b.p043h.C0886p
    /* JADX INFO: renamed from: b_ */
    public final void mo549b_() {
        this.f530a.mo549b_();
        this.f531b.mo549b_();
        super.mo549b_();
    }

    /* JADX INFO: renamed from: c */
    public final void m550c(int i) {
        m2004l();
        if (i < 0) {
            throw new IllegalArgumentException("target < 0");
        }
        if (this.f531b.m1985b() != this.f532c) {
            throw new RuntimeException("non-default elements not all set");
        }
        this.f531b.m1988c(i);
    }

    /* JADX INFO: renamed from: d */
    public final C0880j m551d() {
        return this.f531b;
    }

    /* JADX INFO: renamed from: e */
    public final C0880j m552e() {
        return this.f530a;
    }

    /* JADX INFO: renamed from: f */
    public final void m553f() {
        int i = 0;
        m2004l();
        int i2 = this.f532c;
        if (i2 != this.f531b.m1985b() - 1) {
            throw new IllegalArgumentException("incomplete instance");
        }
        int iM1986b = this.f531b.m1986b(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int iM1986b2 = this.f531b.m1986b(i3);
            if (iM1986b2 != iM1986b) {
                if (i3 != i) {
                    this.f531b.m1987b(i, iM1986b2);
                    this.f530a.m1987b(i, this.f530a.m1986b(i3));
                }
                i++;
            }
        }
        if (i != i2) {
            this.f530a.m1993e(i);
            this.f531b.m1987b(i, iM1986b);
            this.f531b.m1993e(i + 1);
            this.f532c = i;
        }
    }
}
