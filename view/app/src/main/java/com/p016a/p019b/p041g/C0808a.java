package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p043h.C0880j;

/* JADX INFO: renamed from: com.a.b.g.a */
/* JADX INFO: loaded from: classes.dex */
public class C0808a extends AbstractC0831ag {

    /* JADX INFO: renamed from: a */
    private C0880j f2043a;

    /* JADX INFO: renamed from: b */
    private int f2044b;

    public C0808a(int i) {
        this.f2043a = new C0880j(i);
    }

    @Override // com.p016a.p019b.p041g.AbstractC0831ag
    /* JADX INFO: renamed from: a */
    public final int mo1698a() {
        return this.f2044b;
    }

    /* JADX INFO: renamed from: a */
    public final int m1699a(int i) {
        if (i >= this.f2043a.m1985b()) {
            return -1;
        }
        return this.f2043a.m1986b(i);
    }

    @Override // com.p016a.p019b.p041g.AbstractC0831ag
    /* JADX INFO: renamed from: a */
    public final C0766r mo1700a(C0766r c0766r) {
        int iM1986b;
        if (c0766r == null) {
            return null;
        }
        try {
            iM1986b = this.f2043a.m1986b(c0766r.m1533g());
        } catch (IndexOutOfBoundsException e) {
            iM1986b = -1;
        }
        if (iM1986b < 0) {
            throw new RuntimeException("no mapping specified for register");
        }
        return c0766r.m1525a(iM1986b);
    }

    /* JADX INFO: renamed from: a */
    public void mo1701a(int i, int i2, int i3) {
        if (i >= this.f2043a.m1985b()) {
            for (int iM1985b = i - this.f2043a.m1985b(); iM1985b >= 0; iM1985b--) {
                this.f2043a.m1988c(-1);
            }
        }
        this.f2043a.m1987b(i, i2);
        if (this.f2044b < i2 + i3) {
            this.f2044b = i2 + i3;
        }
    }
}
