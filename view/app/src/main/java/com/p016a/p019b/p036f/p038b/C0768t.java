package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0877g;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.f.b.t */
/* JADX INFO: loaded from: classes.dex */
public final class C0768t extends C0877g implements InterfaceC0807e {

    /* JADX INFO: renamed from: a */
    public static final C0768t f1671a = new C0768t(0);

    public C0768t(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0768t m1546a(C0766r c0766r) {
        C0768t c0768t = new C0768t(1);
        c0768t.m1975a(0, (Object) c0766r);
        return c0768t;
    }

    /* JADX INFO: renamed from: a */
    public static C0768t m1547a(C0766r c0766r, C0766r c0766r2) {
        C0768t c0768t = new C0768t(2);
        c0768t.m1975a(0, (Object) c0766r);
        c0768t.m1975a(1, (Object) c0766r2);
        return c0768t;
    }

    /* JADX INFO: renamed from: a */
    public final C0768t m1550a(int i, boolean z, BitSet bitSet) {
        byte b2 = 0;
        byte b3 = 0;
        int iD_ = m1977d_();
        if (iD_ == 0) {
            return this;
        }
        C0769u c0769u = new C0769u(this, bitSet, b3 == true ? 1 : 0, z, b2 == true ? 1 : 0);
        for (int i2 = 0; i2 < iD_; i2++) {
            C0769u.m1561a(c0769u, i2);
        }
        return C0769u.m1560a(c0769u);
    }

    /* JADX INFO: renamed from: a */
    public final C0768t m1551a(BitSet bitSet) {
        int iD_ = m1977d_() - bitSet.cardinality();
        if (iD_ == 0) {
            return f1671a;
        }
        C0768t c0768t = new C0768t(iD_);
        int i = 0;
        for (int i2 = 0; i2 < m1977d_(); i2++) {
            if (!bitSet.get(i2)) {
                c0768t.m1975a(i, m1978e(i2));
                i++;
            }
        }
        if (m2003k()) {
            c0768t.mo549b_();
        }
        return c0768t;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0807e
    /* JADX INFO: renamed from: a */
    public final C0805c mo756a(int i) {
        return m1553b(i).mo663a().mo663a();
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0807e
    /* JADX INFO: renamed from: a */
    public final InterfaceC0807e mo757a(C0805c c0805c) {
        throw new UnsupportedOperationException("unsupported");
    }

    /* JADX INFO: renamed from: a */
    public final void m1552a(int i, C0766r c0766r) {
        m1975a(i, (Object) c0766r);
    }

    /* JADX INFO: renamed from: b */
    public final C0766r m1553b(int i) {
        return (C0766r) m1978e(i);
    }

    /* JADX INFO: renamed from: b */
    public final C0768t m1554b(C0766r c0766r) {
        int iD_ = m1977d_();
        C0768t c0768t = new C0768t(iD_ + 1);
        for (int i = 0; i < iD_; i++) {
            c0768t.m1975a(i + 1, m1978e(i));
        }
        c0768t.m1975a(0, (Object) c0766r);
        if (m2003k()) {
            c0768t.mo549b_();
        }
        return c0768t;
    }

    /* JADX INFO: renamed from: c */
    public final int m1555c(int i) {
        int iD_ = m1977d_();
        for (int i2 = 0; i2 < iD_; i2++) {
            if (m1553b(i2).m1533g() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: d */
    public final C0768t m1556d(int i) {
        int iD_ = m1977d_();
        if (iD_ == 0) {
            return this;
        }
        C0768t c0768t = new C0768t(iD_);
        for (int i2 = 0; i2 < iD_; i2++) {
            C0766r c0766r = (C0766r) m1978e(i2);
            if (c0766r != null) {
                c0768t.m1975a(i2, (Object) c0766r.m1530b(i));
            }
        }
        if (m2003k()) {
            c0768t.mo549b_();
        }
        return c0768t;
    }

    /* JADX INFO: renamed from: e */
    public final int m1557e() {
        int iD_ = m1977d_();
        int iM1687i = 0;
        for (int i = 0; i < iD_; i++) {
            iM1687i += mo756a(i).m1687i();
        }
        return iM1687i;
    }

    /* JADX INFO: renamed from: f */
    public final C0768t m1558f() {
        int iD_ = m1977d_() - 1;
        if (iD_ == 0) {
            return f1671a;
        }
        C0768t c0768t = new C0768t(iD_);
        for (int i = 0; i < iD_; i++) {
            c0768t.m1975a(i, m1978e(i + 1));
        }
        if (!m2003k()) {
            return c0768t;
        }
        c0768t.mo549b_();
        return c0768t;
    }

    /* JADX INFO: renamed from: g */
    public final C0768t m1559g() {
        int iD_ = m1977d_() - 1;
        if (iD_ == 0) {
            return f1671a;
        }
        C0768t c0768t = new C0768t(iD_);
        for (int i = 0; i < iD_; i++) {
            c0768t.m1975a(i, m1978e(i));
        }
        if (!m2003k()) {
            return c0768t;
        }
        c0768t.mo549b_();
        return c0768t;
    }
}
