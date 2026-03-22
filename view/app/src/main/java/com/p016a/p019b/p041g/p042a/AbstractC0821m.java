package com.p016a.p019b.p041g.p042a;

import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p041g.AbstractC0831ag;
import com.p016a.p019b.p041g.AbstractC0836al;
import com.p016a.p019b.p041g.C0833ai;
import com.p016a.p019b.p041g.C0838an;
import com.p016a.p019b.p043h.InterfaceC0879i;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.g.a.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0821m {

    /* JADX INFO: renamed from: a */
    protected final C0838an f2079a;

    /* JADX INFO: renamed from: b */
    private C0817i f2080b;

    public AbstractC0821m(C0838an c0838an, C0817i c0817i) {
        this.f2079a = c0838an;
        this.f2080b = c0817i;
    }

    /* JADX INFO: renamed from: a */
    protected final C0766r m1743a(AbstractC0836al abstractC0836al, C0766r c0766r) {
        C0833ai c0833aiM1832o = abstractC0836al.m1832o();
        ArrayList arrayListM1801c = c0833aiM1832o.m1801c();
        int iIndexOf = arrayListM1801c.indexOf(abstractC0836al);
        if (iIndexOf < 0) {
            throw new IllegalArgumentException("specified insn is not in this block");
        }
        if (iIndexOf != arrayListM1801c.size() - 1) {
            throw new IllegalArgumentException("Adding move here not supported:" + abstractC0836al.mo657d());
        }
        C0766r c0766rM1516a = C0766r.m1516a(this.f2079a.m1869o(), c0766r.m1534h());
        arrayListM1801c.add(iIndexOf, AbstractC0836al.m1822a(new C0765q(C0773y.m1587a(c0766rM1516a.mo663a()), C0774z.f1897a, c0766rM1516a, C0768t.m1546a(c0766r)), c0833aiM1832o));
        int iM1533g = c0766rM1516a.m1533g();
        InterfaceC0879i interfaceC0879iMo1946b = c0833aiM1832o.m1818p().mo1946b();
        while (interfaceC0879iMo1946b.mo1948a()) {
            this.f2080b.m1737a(iM1533g, interfaceC0879iMo1946b.mo1949b());
        }
        C0768t c0768tMo1756a = abstractC0836al.mo1756a();
        int iD_ = c0768tMo1756a.m1977d_();
        for (int i = 0; i < iD_; i++) {
            this.f2080b.m1737a(iM1533g, c0768tMo1756a.m1553b(i).m1533g());
        }
        this.f2079a.m1867m();
        return c0766rM1516a;
    }

    /* JADX INFO: renamed from: a */
    public abstract AbstractC0831ag mo1726a();

    /* JADX INFO: renamed from: b */
    protected final C0766r m1744b(int i) {
        AbstractC0836al abstractC0836alM1855c = this.f2079a.m1855c(i);
        if (abstractC0836alM1855c == null) {
            return null;
        }
        return abstractC0836alM1855c.m1831n();
    }
}
