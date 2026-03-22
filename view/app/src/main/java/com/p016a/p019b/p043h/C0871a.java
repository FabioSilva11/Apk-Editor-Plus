package com.p016a.p019b.p043h;

import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.a.b.h.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0871a implements InterfaceC0881k {

    /* JADX INFO: renamed from: a */
    int[] f2226a;

    public C0871a(int i) {
        this.f2226a = C0985a.m2293s(i);
    }

    /* JADX INFO: renamed from: c */
    private void m1942c(int i) {
        if (i >= C0985a.m2175a(this.f2226a)) {
            int[] iArrM2293s = C0985a.m2293s(Math.max(i + 1, C0985a.m2175a(this.f2226a) * 2));
            System.arraycopy(this.f2226a, 0, iArrM2293s, 0, this.f2226a.length);
            this.f2226a = iArrM2293s;
        }
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: a */
    public final int mo1943a() {
        return C0985a.m2252c(this.f2226a);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: a */
    public final void mo1944a(int i) {
        m1942c(i);
        C0985a.m2221a(this.f2226a, i, true);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: a */
    public final void mo1945a(InterfaceC0881k interfaceC0881k) {
        if (interfaceC0881k instanceof C0871a) {
            C0871a c0871a = (C0871a) interfaceC0881k;
            m1942c(C0985a.m2175a(c0871a.f2226a) + 1);
            C0985a.m2222a(this.f2226a, c0871a.f2226a);
        } else {
            if (!(interfaceC0881k instanceof C0884n)) {
                InterfaceC0879i interfaceC0879iMo1946b = interfaceC0881k.mo1946b();
                while (interfaceC0879iMo1946b.mo1948a()) {
                    mo1944a(interfaceC0879iMo1946b.mo1949b());
                }
                return;
            }
            C0884n c0884n = (C0884n) interfaceC0881k;
            int iM1985b = c0884n.f2250a.m1985b();
            if (iM1985b > 0) {
                m1942c(c0884n.f2250a.m1986b(iM1985b - 1));
            }
            for (int i = 0; i < c0884n.f2250a.m1985b(); i++) {
                C0985a.m2221a(this.f2226a, c0884n.f2250a.m1986b(i), true);
            }
        }
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: b */
    public final InterfaceC0879i mo1946b() {
        return new C0872b(this);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0881k
    /* JADX INFO: renamed from: b */
    public final boolean mo1947b(int i) {
        return i < C0985a.m2175a(this.f2226a) && C0985a.m2227a(this.f2226a, i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean z = true;
        int iM2262d = C0985a.m2262d(this.f2226a, 0);
        while (iM2262d >= 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(iM2262d);
            iM2262d = C0985a.m2262d(this.f2226a, iM2262d + 1);
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }
}
