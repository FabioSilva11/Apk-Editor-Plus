package com.p016a.p019b.p036f.p038b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0880j;

/* JADX INFO: renamed from: com.a.b.f.b.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0772x {

    /* JADX INFO: renamed from: a */
    private final C0751c f1686a;

    /* JADX INFO: renamed from: b */
    private final int f1687b;

    /* JADX INFO: renamed from: c */
    private C0880j[] f1688c;

    /* JADX INFO: renamed from: d */
    private C0880j f1689d;

    public C0772x(C0751c c0751c, int i) {
        if (c0751c == null) {
            throw new NullPointerException("blocks == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("firstLabel < 0");
        }
        this.f1686a = c0751c;
        this.f1687b = i;
        this.f1688c = null;
        this.f1689d = null;
    }

    /* JADX INFO: renamed from: a */
    public final C0751c m1582a() {
        return this.f1686a;
    }

    /* JADX INFO: renamed from: a */
    public final C0880j m1583a(int i) {
        if (this.f1689d == null) {
            int iJ = this.f1686a.m2001j();
            C0880j[] c0880jArr = new C0880j[iJ];
            C0880j c0880j = new C0880j(10);
            int iD_ = this.f1686a.m1977d_();
            for (int i2 = 0; i2 < iD_; i2++) {
                C0745a c0745aM1475a = this.f1686a.m1475a(i2);
                int iMo559a = c0745aM1475a.mo559a();
                C0880j c0880jM1458c = c0745aM1475a.m1458c();
                int iM1985b = c0880jM1458c.m1985b();
                if (iM1985b == 0) {
                    c0880j.m1988c(iMo559a);
                } else {
                    for (int i3 = 0; i3 < iM1985b; i3++) {
                        int iM1986b = c0880jM1458c.m1986b(i3);
                        C0880j c0880j2 = c0880jArr[iM1986b];
                        if (c0880j2 == null) {
                            c0880j2 = new C0880j(10);
                            c0880jArr[iM1986b] = c0880j2;
                        }
                        c0880j2.m1988c(iMo559a);
                    }
                }
            }
            for (int i4 = 0; i4 < iJ; i4++) {
                C0880j c0880j3 = c0880jArr[i4];
                if (c0880j3 != null) {
                    c0880j3.m1997g();
                    c0880j3.mo549b_();
                }
            }
            c0880j.m1997g();
            c0880j.mo549b_();
            if (c0880jArr[this.f1687b] == null) {
                c0880jArr[this.f1687b] = C0880j.f2245a;
            }
            this.f1688c = c0880jArr;
            this.f1689d = c0880j;
        }
        C0880j c0880j4 = this.f1688c[i];
        if (c0880j4 == null) {
            throw new RuntimeException("no such block: " + C0985a.m2296v(i));
        }
        return c0880j4;
    }

    /* JADX INFO: renamed from: b */
    public final int m1584b() {
        return this.f1687b;
    }
}
