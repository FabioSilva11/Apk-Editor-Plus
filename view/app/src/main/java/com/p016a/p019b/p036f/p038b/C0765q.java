package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;

/* JADX INFO: renamed from: com.a.b.f.b.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0765q extends AbstractC0757i {
    public C0765q(C0771w c0771w, C0774z c0774z, C0766r c0766r, C0766r c0766r2) {
        this(c0771w, c0774z, c0766r, C0768t.m1546a(c0766r2));
    }

    public C0765q(C0771w c0771w, C0774z c0774z, C0766r c0766r, C0768t c0768t) {
        super(c0771w, c0774z, c0766r, c0768t);
        switch (c0771w.m1577d()) {
            case 5:
            case 6:
                throw new IllegalArgumentException("bogus branchingness");
            default:
                if (c0766r != null && c0771w.m1577d() != 1) {
                    throw new IllegalArgumentException("can't mix branchingness with result");
                }
                return;
        }
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1465a(C0766r c0766r, C0768t c0768t) {
        return new C0765q(m1490f(), m1491g(), c0766r, c0768t);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1466a(C0805c c0805c) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final void mo1468a(InterfaceC0759k interfaceC0759k) {
        interfaceC0759k.mo894a(this);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: b */
    public final InterfaceC0807e mo1470b() {
        return C0804b.f1974a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: l */
    public final AbstractC0757i mo1496l() {
        AbstractC0775a abstractC0775aM1629a;
        int i;
        C0768t c0768tJ = m1494j();
        int iD_ = c0768tJ.m1977d_();
        if (iD_ == 0) {
            return this;
        }
        InterfaceC0806d interfaceC0806dM1534h = c0768tJ.m1553b(iD_ - 1).m1534h();
        if (!interfaceC0806dM1534h.mo667f()) {
            InterfaceC0806d interfaceC0806dM1534h2 = c0768tJ.m1553b(0).m1534h();
            if (iD_ != 2 || !interfaceC0806dM1534h2.mo667f()) {
                return this;
            }
            AbstractC0775a abstractC0775a = (AbstractC0775a) interfaceC0806dM1534h2;
            C0768t c0768tM1558f = c0768tJ.m1558f();
            return new C0764p(C0773y.m1585a(m1490f().m1574a(), m1492h(), c0768tM1558f, abstractC0775a), m1491g(), m1492h(), c0768tM1558f, abstractC0775a);
        }
        AbstractC0775a abstractC0775a2 = (AbstractC0775a) interfaceC0806dM1534h;
        C0768t c0768tM1559g = c0768tJ.m1559g();
        try {
            int iM1574a = m1490f().m1574a();
            if (iM1574a == 15 && (abstractC0775a2 instanceof C0790n)) {
                abstractC0775aM1629a = C0790n.m1629a(-((C0790n) abstractC0775a2).mo1632j());
                i = 14;
            } else {
                abstractC0775aM1629a = abstractC0775a2;
                i = iM1574a;
            }
            return new C0764p(C0773y.m1585a(i, m1492h(), c0768tM1559g, abstractC0775aM1629a), m1491g(), m1492h(), c0768tM1559g, abstractC0775aM1629a);
        } catch (IllegalArgumentException e) {
            return this;
        }
    }
}
