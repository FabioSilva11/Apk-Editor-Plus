package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.a.b.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0467e extends C0877g {

    /* JADX INFO: renamed from: a */
    public static final C0467e f545a = new C0467e(0);

    public C0467e(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public final C0468f m566a(int i) {
        return (C0468f) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m567a(int i, int i2, int i3, int i4, C0802z c0802z) {
        m1975a(i, new C0468f(i2, i3, i4, c0802z));
    }

    /* JADX INFO: renamed from: a_ */
    public final InterfaceC0807e m568a_() {
        int iD_ = m1977d_();
        if (iD_ == 0) {
            return C0804b.f1974a;
        }
        C0804b c0804b = new C0804b(iD_);
        for (int i = 0; i < iD_; i++) {
            c0804b.m1675a(i, m566a(i).m574d().m1655i());
        }
        c0804b.mo549b_();
        return c0804b;
    }

    /* JADX INFO: renamed from: b */
    public final C0467e m569b(int i) {
        boolean z;
        int iD_ = m1977d_();
        C0468f[] c0468fArr = new C0468f[iD_];
        int i2 = 0;
        for (int i3 = 0; i3 < iD_; i3++) {
            C0468f c0468fM566a = m566a(i3);
            if (c0468fM566a.m571a(i)) {
                C0802z c0802zM574d = c0468fM566a.m574d();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0802z c0802zM574d2 = c0468fArr[i4].m574d();
                    if (c0802zM574d2 == c0802zM574d || c0802zM574d2 == C0802z.f1938a) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    c0468fArr[i2] = c0468fM566a;
                    i2++;
                }
            }
        }
        if (i2 == 0) {
            return f545a;
        }
        C0467e c0467e = new C0467e(i2);
        for (int i5 = 0; i5 < i2; i5++) {
            C0468f c0468f = c0468fArr[i5];
            if (c0468f == null) {
                throw new NullPointerException("item == null");
            }
            c0467e.m1975a(i5, c0468f);
        }
        c0467e.mo549b_();
        return c0467e;
    }
}
