package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.a.b.ai */
/* JADX INFO: loaded from: classes.dex */
public final class C0460ai {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0483u f522a;

    /* JADX INFO: renamed from: b */
    private final C0470h f523b;

    /* JADX INFO: renamed from: c */
    private final C0479q f524c;

    /* JADX INFO: renamed from: d */
    private final C0461aj f525d;

    public C0460ai(InterfaceC0483u interfaceC0483u, C0474l c0474l) {
        if (interfaceC0483u == null) {
            throw new NullPointerException("machine == null");
        }
        if (c0474l == null) {
            throw new NullPointerException("method == null");
        }
        this.f522a = interfaceC0483u;
        this.f523b = c0474l.m593k();
        this.f524c = c0474l.m595m();
        this.f525d = new C0461aj(this);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C0459ah m528a() {
        return new C0459ah("stack mismatch: illegal top-of-stack for opcode");
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C0805c m530a(C0805c c0805c, C0805c c0805c2) {
        if (c0805c2 != C0805c.f2019j) {
            if (c0805c == C0805c.f2023n && c0805c2.m1693o() && c0805c2.m1697s().m1692n()) {
                return c0805c2;
            }
            if (c0805c == C0805c.f2011b && c0805c2 == C0805c.f2000A) {
                return C0805c.f2000A;
            }
        }
        return c0805c.m1696r();
    }

    /* JADX INFO: renamed from: a */
    public final void m532a(C0465c c0465c, C0476n c0476n) {
        int iM561c = c0465c.m561c();
        this.f525d.m543a(c0476n);
        try {
            int iM560b = c0465c.m560b();
            while (iM560b < iM561c) {
                int iM577a = this.f523b.m577a(iM560b, this.f525d);
                this.f525d.mo535a(iM560b);
                iM560b += iM577a;
            }
        } catch (C0459ah e) {
            c0476n.m616a(e);
            throw e;
        }
    }
}
