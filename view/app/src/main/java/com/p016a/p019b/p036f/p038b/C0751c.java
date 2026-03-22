package com.p016a.p019b.p036f.p038b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0883m;
import com.p016a.p019b.p043h.InterfaceC0882l;

/* JADX INFO: renamed from: com.a.b.f.b.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0751c extends C0883m {

    /* JADX INFO: renamed from: a */
    private int f1626a;

    public C0751c(int i) {
        super(i);
        this.f1626a = -1;
    }

    private C0751c(C0751c c0751c) {
        super(c0751c);
        this.f1626a = c0751c.f1626a;
    }

    /* JADX INFO: renamed from: a */
    public final C0745a m1475a(int i) {
        return (C0745a) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m1476a(int i, C0745a c0745a) {
        super.m1999a(i, (InterfaceC0882l) c0745a);
        this.f1626a = -1;
    }

    /* JADX INFO: renamed from: a */
    public final void m1477a(InterfaceC0759k interfaceC0759k) {
        int iD_ = m1977d_();
        for (int i = 0; i < iD_; i++) {
            m1475a(i).m1457b().m1499a(interfaceC0759k);
        }
    }

    /* JADX INFO: renamed from: b */
    public final C0745a m1478b(int i) {
        int iC = m2000c(i);
        if (iC < 0) {
            throw new IllegalArgumentException("no such label: " + C0985a.m2296v(i));
        }
        return m1475a(iC);
    }

    /* JADX INFO: renamed from: e */
    public final int m1479e() {
        if (this.f1626a == -1) {
            C0752d c0752d = new C0752d();
            m1477a(c0752d);
            this.f1626a = c0752d.m1485a();
        }
        return this.f1626a;
    }

    /* JADX INFO: renamed from: f */
    public final int m1480f() {
        int iD_ = m1977d_();
        int i = 0;
        int iD_2 = 0;
        while (i < iD_) {
            C0745a c0745a = (C0745a) m1979f(i);
            i++;
            iD_2 = c0745a != null ? c0745a.m1457b().m1977d_() + iD_2 : iD_2;
        }
        return iD_2;
    }

    /* JADX INFO: renamed from: g */
    public final int m1481g() {
        int i;
        int iD_ = m1977d_();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iD_) {
            C0745a c0745a = (C0745a) m1979f(i2);
            if (c0745a != null) {
                C0760l c0760lM1457b = c0745a.m1457b();
                int iD_2 = c0760lM1457b.m1977d_();
                i = i3;
                for (int i4 = 0; i4 < iD_2; i4++) {
                    if (c0760lM1457b.m1497a(i4).m1490f().m1574a() != 54) {
                        i++;
                    }
                }
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        return i3;
    }

    /* JADX INFO: renamed from: h */
    public final C0751c m1482h() {
        return new C0751c(this);
    }
}
