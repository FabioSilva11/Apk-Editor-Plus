package com.p016a.p019b.p043h;

/* JADX INFO: renamed from: com.a.b.h.p */
/* JADX INFO: loaded from: classes.dex */
public class C0886p {

    /* JADX INFO: renamed from: a */
    private boolean f2253a;

    public C0886p() {
        this.f2253a = true;
    }

    public C0886p(boolean z) {
        this.f2253a = z;
    }

    /* JADX INFO: renamed from: b_ */
    public void mo549b_() {
        this.f2253a = false;
    }

    /* JADX INFO: renamed from: c_ */
    public final boolean m2002c_() {
        return this.f2253a;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m2003k() {
        return !this.f2253a;
    }

    /* JADX INFO: renamed from: l */
    public final void m2004l() {
        if (!this.f2253a) {
            throw new C0887q("immutable instance");
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m2005m() {
        if (this.f2253a) {
            throw new C0887q("mutable instance");
        }
    }
}
