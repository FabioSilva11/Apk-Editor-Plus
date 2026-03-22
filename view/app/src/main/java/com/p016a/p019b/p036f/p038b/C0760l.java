package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.f.b.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0760l extends C0877g {
    public C0760l(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0757i m1497a(int i) {
        return (AbstractC0757i) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m1498a(int i, AbstractC0757i abstractC0757i) {
        m1975a(i, (Object) abstractC0757i);
    }

    /* JADX INFO: renamed from: a */
    public final void m1499a(InterfaceC0759k interfaceC0759k) {
        int iD_ = m1977d_();
        for (int i = 0; i < iD_; i++) {
            m1497a(i).mo1468a(interfaceC0759k);
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1500a(C0760l c0760l) {
        int iD_;
        if (c0760l == null || (iD_ = m1977d_()) != c0760l.m1977d_()) {
            return false;
        }
        for (int i = 0; i < iD_; i++) {
            if (!m1497a(i).mo1469a(c0760l.m1497a(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: e */
    public final AbstractC0757i m1501e() {
        return m1497a(m1977d_() - 1);
    }
}
