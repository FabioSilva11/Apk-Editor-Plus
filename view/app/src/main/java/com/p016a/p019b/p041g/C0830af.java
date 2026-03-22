package com.p016a.p019b.p041g;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: renamed from: com.a.b.g.af */
/* JADX INFO: loaded from: classes.dex */
public final class C0830af {

    /* JADX INFO: renamed from: a */
    private C0838an f2099a;

    /* JADX INFO: renamed from: b */
    private final BitSet f2100b;

    private C0830af(C0838an c0838an) {
        this.f2099a = c0838an;
        this.f2100b = new BitSet(c0838an.m1861g());
    }

    /* JADX INFO: renamed from: a */
    public static void m1772a(C0838an c0838an) {
        boolean z;
        C0830af c0830af = new C0830af(c0838an);
        int iM1861g = c0830af.f2099a.m1861g();
        for (int i = 0; i < iM1861g; i++) {
            AbstractC0836al abstractC0836alM1855c = c0830af.f2099a.m1855c(i);
            if (abstractC0836alM1855c != null && abstractC0836alM1855c.m1831n().mo665c() == 0) {
                c0830af.f2100b.set(i);
            }
        }
        while (true) {
            int iNextSetBit = c0830af.f2100b.nextSetBit(0);
            if (iNextSetBit < 0) {
                return;
            }
            c0830af.f2100b.clear(iNextSetBit);
            C0827ac c0827ac = (C0827ac) c0830af.f2099a.m1855c(iNextSetBit);
            c0827ac.m1763a(c0830af.f2099a);
            C0768t c0768tMo1756a = c0827ac.mo1756a();
            int i2 = -1;
            int iD_ = c0768tMo1756a.m1977d_();
            int i3 = 0;
            C0766r c0766r = null;
            while (i3 < iD_) {
                C0766r c0766rM1553b = c0768tMo1756a.m1553b(i3);
                if (c0766rM1553b.mo665c() != 0) {
                    i2 = i3;
                } else {
                    c0766rM1553b = c0766r;
                }
                i3++;
                c0766r = c0766rM1553b;
            }
            if (c0766r == null) {
                z = false;
            } else {
                C0761m c0761mM1535i = c0766r.m1535i();
                InterfaceC0806d interfaceC0806dMo663a = c0766r.mo663a();
                boolean z2 = true;
                for (int i4 = 0; i4 < iD_; i4++) {
                    if (i4 != i2) {
                        C0766r c0766rM1553b2 = c0768tMo1756a.m1553b(i4);
                        if (c0766rM1553b2.mo665c() != 0) {
                            z2 = z2 && m1773a(c0761mM1535i, c0766rM1553b2.m1535i());
                            interfaceC0806dMo663a = C0985a.m2186a(interfaceC0806dMo663a, c0766rM1553b2.mo663a());
                        }
                    }
                }
                if (interfaceC0806dMo663a == null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i5 = 0; i5 < iD_; i5++) {
                        sb.append(c0768tMo1756a.m1553b(i5).toString());
                        sb.append(' ');
                    }
                    throw new RuntimeException("Couldn't map types in phi insn:" + ((Object) sb));
                }
                C0761m c0761m = z2 ? c0761mM1535i : null;
                C0766r c0766rN = c0827ac.m1831n();
                if (c0766rN.m1534h() == interfaceC0806dMo663a && m1773a(c0761m, c0766rN.m1535i())) {
                    z = false;
                } else {
                    c0827ac.m1760a(interfaceC0806dMo663a, c0761m);
                    z = true;
                }
            }
            if (z) {
                List listM1857d = c0830af.f2099a.m1857d(iNextSetBit);
                int size = listM1857d.size();
                for (int i6 = 0; i6 < size; i6++) {
                    AbstractC0836al abstractC0836al = (AbstractC0836al) listM1857d.get(i6);
                    C0766r c0766rM1831n = abstractC0836al.m1831n();
                    if (c0766rM1831n != null && (abstractC0836al instanceof C0827ac)) {
                        c0830af.f2100b.set(c0766rM1831n.m1533g());
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1773a(C0761m c0761m, C0761m c0761m2) {
        return c0761m == c0761m2 || (c0761m != null && c0761m.equals(c0761m2));
    }
}
