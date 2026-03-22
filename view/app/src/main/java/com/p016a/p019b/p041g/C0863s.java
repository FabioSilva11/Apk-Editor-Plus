package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0764p;
import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0795s;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.g.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0863s {

    /* JADX INFO: renamed from: a */
    private final C0838an f2207a;

    private C0863s(C0838an c0838an) {
        this.f2207a = c0838an;
    }

    /* JADX INFO: renamed from: a */
    public static void m1924a(C0838an c0838an) {
        C0863s c0863s = new C0863s(c0838an);
        c0863s.f2207a.m1847a(new C0864t(c0863s, C0825aa.m1753b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m1926a(C0870z c0870z, C0768t c0768t, int i, AbstractC0775a abstractC0775a) {
        AbstractC0757i abstractC0757iMo1766e = c0870z.mo1766e();
        C0771w c0771wM1585a = C0773y.m1585a(i, c0870z.m1831n(), c0768t, abstractC0775a);
        C0870z c0870z2 = new C0870z(abstractC0775a == null ? new C0765q(c0771wM1585a, abstractC0757iMo1766e.m1491g(), c0870z.m1831n(), c0768t) : new C0764p(c0771wM1585a, abstractC0757iMo1766e.m1491g(), c0870z.m1831n(), c0768t, abstractC0775a), c0870z.m1832o());
        ArrayList arrayListM1801c = c0870z.m1832o().m1801c();
        this.f2207a.m1853b(c0870z);
        arrayListM1801c.set(arrayListM1801c.lastIndexOf(c0870z), c0870z2);
        this.f2207a.m1843a(c0870z2);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m1927a(C0766r c0766r) {
        boolean z;
        InterfaceC0806d interfaceC0806dM1534h = c0766r.m1534h();
        if (!(interfaceC0806dM1534h instanceof AbstractC0795s)) {
            z = false;
        } else {
            if (((AbstractC0795s) interfaceC0806dM1534h).mo1633k() != 0) {
                return false;
            }
            z = true;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m1928a(C0863s c0863s, C0870z c0870z) {
        C0771w c0771wM1490f = c0870z.mo1766e().m1490f();
        C0766r c0766rN = c0870z.m1831n();
        if (c0766rN != null && !c0863s.f2207a.m1850a(c0766rN) && c0771wM1490f.m1574a() != 5) {
            InterfaceC0806d interfaceC0806dM1534h = c0870z.m1831n().m1534h();
            if (interfaceC0806dM1534h.mo667f() && interfaceC0806dM1534h.mo665c() == 6) {
                c0863s.m1926a(c0870z, C0768t.f1671a, 5, (AbstractC0775a) interfaceC0806dM1534h);
                if (c0771wM1490f.m1574a() == 56) {
                    c0863s.m1926a((C0870z) ((C0833ai) c0863s.f2207a.m1864j().get(c0870z.m1832o().m1809g().nextSetBit(0))).m1801c().get(r0.size() - 1), C0768t.f1671a, 6, null);
                }
                return true;
            }
        }
        return false;
    }
}
