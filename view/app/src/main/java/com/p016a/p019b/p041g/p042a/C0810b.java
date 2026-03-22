package com.p016a.p019b.p041g.p042a;

import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p041g.AbstractC0836al;
import com.p016a.p019b.p041g.C0825aa;
import com.p016a.p019b.p041g.C0827ac;
import com.p016a.p019b.p041g.C0870z;
import com.p016a.p019b.p041g.InterfaceC0837am;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.g.a.b */
/* JADX INFO: loaded from: classes.dex */
final class C0810b implements InterfaceC0837am {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0809a f2054a;

    C0810b(C0809a c0809a) {
        this.f2054a = c0809a;
    }

    /* JADX INFO: renamed from: a */
    private void m1727a(AbstractC0836al abstractC0836al) {
        C0766r c0766rMo1828f = abstractC0836al.mo1828f();
        if (c0766rMo1828f != null) {
            C0761m c0761mM1535i = c0766rMo1828f.m1535i();
            ArrayList arrayList = (ArrayList) this.f2054a.f2045b.get(c0761mM1535i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f2054a.f2045b.put(c0761mM1535i, arrayList);
            }
            arrayList.add(c0766rMo1828f);
        }
        if (!(abstractC0836al instanceof C0870z)) {
            if (abstractC0836al instanceof C0827ac) {
                this.f2054a.f2048e.add((C0827ac) abstractC0836al);
            }
        } else if (abstractC0836al.mo1765c().m1574a() == 56) {
            this.f2054a.f2046c.add((C0870z) abstractC0836al);
        } else if (C0825aa.m1753b().mo1474a(abstractC0836al.mo1766e().m1490f(), abstractC0836al.mo1756a())) {
            this.f2054a.f2047d.add((C0870z) abstractC0836al);
        }
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1728a(C0827ac c0827ac) {
        m1727a((AbstractC0836al) c0827ac);
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: a */
    public final void mo1729a(C0870z c0870z) {
        m1727a((AbstractC0836al) c0870z);
    }

    @Override // com.p016a.p019b.p041g.InterfaceC0837am
    /* JADX INFO: renamed from: b */
    public final void mo1730b(C0870z c0870z) {
        m1727a((AbstractC0836al) c0870z);
    }
}
