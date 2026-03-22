package com.p016a.p019b.p041g;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.a.b.g.ac */
/* JADX INFO: loaded from: classes.dex */
public final class C0827ac extends AbstractC0836al {

    /* JADX INFO: renamed from: a */
    private final int f2093a;

    /* JADX INFO: renamed from: b */
    private final ArrayList f2094b;

    /* JADX INFO: renamed from: c */
    private C0768t f2095c;

    public C0827ac(int i, C0833ai c0833ai) {
        super(C0766r.m1516a(i, C0805c.f2018i), c0833ai);
        this.f2094b = new ArrayList();
        this.f2093a = i;
    }

    public C0827ac(C0766r c0766r, C0833ai c0833ai) {
        super(c0766r, c0833ai);
        this.f2094b = new ArrayList();
        this.f2093a = c0766r.m1533g();
    }

    /* JADX INFO: renamed from: p */
    private static C0827ac m1754p() {
        throw new UnsupportedOperationException("can't clone phi");
    }

    /* JADX INFO: renamed from: a */
    public final int m1755a(int i) {
        return ((C0828ad) this.f2094b.get(i)).f2097b;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: a */
    public final C0768t mo1756a() {
        if (this.f2095c != null) {
            return this.f2095c;
        }
        if (this.f2094b.size() == 0) {
            return C0768t.f1671a;
        }
        int size = this.f2094b.size();
        this.f2095c = new C0768t(size);
        for (int i = 0; i < size; i++) {
            this.f2095c.m1552a(i, ((C0828ad) this.f2094b.get(i)).f2096a);
        }
        this.f2095c.mo549b_();
        return this.f2095c;
    }

    /* JADX INFO: renamed from: a */
    public final List m1757a(int i, C0838an c0838an) {
        ArrayList arrayList = new ArrayList();
        for (C0828ad c0828ad : this.f2094b) {
            if (c0828ad.f2096a.m1533g() == i) {
                arrayList.add(c0838an.m1864j().get(c0828ad.f2097b));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final void m1758a(C0766r c0766r) {
        ArrayList arrayList = new ArrayList();
        for (C0828ad c0828ad : this.f2094b) {
            if (c0828ad.f2096a.m1533g() == c0766r.m1533g()) {
                arrayList.add(c0828ad);
            }
        }
        this.f2094b.removeAll(arrayList);
        this.f2095c = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m1759a(C0766r c0766r, C0833ai c0833ai) {
        this.f2094b.add(new C0828ad(c0766r, c0833ai.m1806e(), c0833ai.m1808f()));
        this.f2095c = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m1760a(InterfaceC0806d interfaceC0806d, C0761m c0761m) {
        m1824b(C0766r.m1520b(m1831n().m1533g(), interfaceC0806d, c0761m));
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: a */
    public final void mo1761a(AbstractC0831ag abstractC0831ag) {
        for (C0828ad c0828ad : this.f2094b) {
            C0766r c0766r = c0828ad.f2096a;
            c0828ad.f2096a = abstractC0831ag.mo1700a(c0766r);
            if (c0766r != c0828ad.f2096a) {
                m1832o().m1816n().m1845a(this, c0766r, c0828ad.f2096a);
            }
        }
        this.f2095c = null;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: a */
    public final void mo1762a(InterfaceC0837am interfaceC0837am) {
        interfaceC0837am.mo1728a(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m1763a(C0838an c0838an) {
        for (C0828ad c0828ad : this.f2094b) {
            c0828ad.f2096a = c0828ad.f2096a.m1528a(c0838an.m1855c(c0828ad.f2096a.m1533g()).m1831n().mo663a());
        }
        this.f2095c = null;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: b */
    public final AbstractC0757i mo1764b() {
        throw new IllegalArgumentException("Cannot convert phi insns to rop form");
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: c */
    public final C0771w mo1765c() {
        return null;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    public final /* synthetic */ Object clone() {
        return m1754p();
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append(C0774z.f1897a);
        stringBuffer.append(": phi");
        C0766r c0766rN = m1831n();
        if (c0766rN == null) {
            stringBuffer.append(" .");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(c0766rN.mo657d());
        }
        stringBuffer.append(" <-");
        int iD_ = mo1756a().m1977d_();
        if (iD_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < iD_; i++) {
                stringBuffer.append(" ");
                stringBuffer.append(this.f2095c.m1553b(i).mo657d() + "[b=" + C0985a.m2296v(((C0828ad) this.f2094b.get(i)).f2098c) + "]");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: e */
    public final AbstractC0757i mo1766e() {
        return null;
    }

    /* JADX INFO: renamed from: g */
    public final int m1767g() {
        return this.f2093a;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: j */
    public final boolean mo1768j() {
        return false;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: k */
    public final boolean mo1769k() {
        return true;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: l */
    public final boolean mo1770l() {
        return C0825aa.m1752a() && mo1828f() != null;
    }

    @Override // com.p016a.p019b.p041g.AbstractC0836al
    /* JADX INFO: renamed from: m */
    public final /* synthetic */ AbstractC0836al clone() {
        return m1754p();
    }
}
