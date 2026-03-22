package com.p016a.p019b.p041g;

import android.support.v7.appcompat.C0299R;
import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;

/* JADX INFO: renamed from: com.a.b.g.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0870z extends AbstractC0836al implements Cloneable {

    /* JADX INFO: renamed from: a */
    private AbstractC0757i f2225a;

    C0870z(AbstractC0757i abstractC0757i, C0833ai c0833ai) {
        super(abstractC0757i.m1492h(), c0833ai);
        this.f2225a = abstractC0757i;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: a */
    public final C0768t mo1756a() {
        return this.f2225a.m1494j();
    }

    /* JADX INFO: renamed from: a */
    public final void m1939a(int i, C0766r c0766r) {
        C0768t c0768tM1494j = this.f2225a.m1494j();
        int iD_ = c0768tM1494j.m1977d_();
        C0768t c0768t = new C0768t(iD_);
        int i2 = 0;
        while (i2 < iD_) {
            c0768t.m1552a(i2, i2 == i ? c0766r : c0768tM1494j.m1553b(i2));
            i2++;
        }
        c0768t.mo549b_();
        C0766r c0766rM1553b = c0768tM1494j.m1553b(i);
        if (c0766rM1553b.m1533g() != c0766r.m1533g()) {
            m1832o().m1816n().m1845a(this, c0766rM1553b, c0766r);
        }
        this.f2225a = this.f2225a.mo1465a(m1831n(), c0768t);
    }

    /* JADX INFO: renamed from: a */
    public final void m1940a(C0768t c0768t) {
        if (this.f2225a.m1494j().m1977d_() != c0768t.m1977d_()) {
            throw new RuntimeException("Sources counts don't match");
        }
        this.f2225a = this.f2225a.mo1465a(m1831n(), c0768t);
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: a */
    public final void mo1761a(AbstractC0831ag abstractC0831ag) {
        C0768t c0768tM1494j = this.f2225a.m1494j();
        C0768t c0768tM1774a = abstractC0831ag.m1774a(c0768tM1494j);
        if (c0768tM1774a != c0768tM1494j) {
            this.f2225a = this.f2225a.mo1465a(m1831n(), c0768tM1774a);
            m1832o().m1816n().m1846a(this, c0768tM1494j);
        }
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: a */
    public final void mo1762a(InterfaceC0837am interfaceC0837am) {
        if (mo1829h()) {
            interfaceC0837am.mo1729a(this);
        } else {
            interfaceC0837am.mo1730b(this);
        }
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: b */
    public final AbstractC0757i mo1764b() {
        return this.f2225a.mo1465a(m1831n(), this.f2225a.m1494j());
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: c */
    public final C0771w mo1765c() {
        return this.f2225a.m1490f();
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    public final /* synthetic */ Object clone() {
        return (C0870z) super.clone();
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return mo1764b().mo657d();
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: e */
    public final AbstractC0757i mo1766e() {
        return this.f2225a;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: f */
    public final C0766r mo1828f() {
        C0766r c0766rM1553b = this.f2225a.m1490f().m1574a() == 54 ? this.f2225a.m1494j().m1553b(0) : m1831n();
        if (c0766rM1553b == null || c0766rM1553b.m1535i() == null) {
            return null;
        }
        return c0766rM1553b;
    }

    /* JADX INFO: renamed from: g */
    public final void m1941g() {
        C0768t c0768tM1494j = this.f2225a.m1494j();
        this.f2225a = this.f2225a.mo1496l();
        m1832o().m1816n().m1846a(this, c0768tM1494j);
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: h */
    public final boolean mo1829h() {
        return this.f2225a.m1490f().m1574a() == 2;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: i */
    public final boolean mo1830i() {
        return this.f2225a.m1490f().m1574a() == 4;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: j */
    public final boolean mo1768j() {
        return this.f2225a.m1495k();
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: k */
    public final boolean mo1769k() {
        return mo1829h();
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: l */
    public final boolean mo1770l() {
        C0771w c0771wM1490f = this.f2225a.m1490f();
        if (c0771wM1490f.m1577d() != 1) {
            return true;
        }
        boolean z = C0825aa.m1752a() && mo1828f() != null;
        switch (c0771wM1490f.m1574a()) {
            case 2:
            case 5:
            case C0299R.styleable.AppCompatTheme_selectableItemBackgroundBorderless /* 55 */:
                return z;
            default:
                return true;
        }
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: m */
    public final /* bridge */ /* synthetic */ AbstractC0836al clone() {
        return (C0870z) super.clone();
    }
}
