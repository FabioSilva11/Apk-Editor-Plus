package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.AbstractC0753e;
import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p039c.C0790n;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: renamed from: com.a.b.g.x */
/* JADX INFO: loaded from: classes.dex */
final class C0868x implements InterfaceC0837am {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C0867w f2219a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0766r[] f2220b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ HashSet f2221c;

    C0868x(C0867w c0867w, C0766r[] c0766rArr, HashSet hashSet) {
        this.f2219a = c0867w;
        this.f2220b = c0766rArr;
        this.f2221c = hashSet;
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1728a(C0827ac c0827ac) {
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1729a(C0870z c0870z) {
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: b */
    public final void mo1730b(C0870z c0870z) {
        if (c0870z.mo1765c().m1574a() != 3) {
            return;
        }
        C0867w c0867w = this.f2219a;
        int iJ = ((C0790n) ((AbstractC0753e) c0870z.mo1766e()).m1486g_()).mo1632j();
        if (this.f2220b[iJ] == null) {
            this.f2220b[iJ] = c0870z.m1831n();
            return;
        }
        C0766r c0766r = this.f2220b[iJ];
        C0766r c0766rN = c0870z.m1831n();
        C0761m c0761mM1535i = c0766r.m1535i();
        C0761m c0761mM1535i2 = c0766rN.m1535i();
        if (c0761mM1535i != null) {
            if (c0761mM1535i2 != null && !c0761mM1535i.equals(c0761mM1535i2)) {
                return;
            } else {
                c0761mM1535i2 = c0761mM1535i;
            }
        }
        this.f2219a.f2218a.m1855c(c0766r.m1533g()).m1823a(c0761mM1535i2);
        C0869y c0869y = new C0869y(this, c0766rN, c0766r);
        List listM1857d = this.f2219a.f2218a.m1857d(c0766rN.m1533g());
        for (int size = listM1857d.size() - 1; size >= 0; size--) {
            ((AbstractC0836al) listM1857d.get(size)).mo1761a(c0869y);
        }
        this.f2221c.add(c0870z);
    }
}
