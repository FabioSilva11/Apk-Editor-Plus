package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import com.p016a.p019b.p043h.C0886p;

/* JADX INFO: renamed from: com.a.b.a.b.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0475m extends C0886p {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0806d[] f565a;

    /* JADX INFO: renamed from: b */
    private final boolean[] f566b;

    /* JADX INFO: renamed from: c */
    private int f567c;

    public C0475m(int i) {
        super(i != 0);
        this.f565a = new InterfaceC0806d[i];
        this.f566b = new boolean[i];
        this.f567c = 0;
    }

    /* JADX INFO: renamed from: a */
    private static InterfaceC0806d m596a(String str) {
        throw new C0459ah("stack: " + str);
    }

    /* JADX INFO: renamed from: b */
    private static String m597b(InterfaceC0806d interfaceC0806d) {
        return interfaceC0806d == null ? "<invalid>" : interfaceC0806d.toString();
    }

    /* JADX INFO: renamed from: a */
    public final C0475m m598a() {
        C0475m c0475m = new C0475m(this.f565a.length);
        System.arraycopy(this.f565a, 0, c0475m.f565a, 0, this.f565a.length);
        System.arraycopy(this.f566b, 0, c0475m.f566b, 0, this.f566b.length);
        c0475m.f567c = this.f567c;
        return c0475m;
    }

    /* JADX INFO: renamed from: a */
    public final C0475m m599a(C0475m c0475m) {
        try {
            return C0985a.m2183a(this, c0475m);
        } catch (C0459ah e) {
            e.m311a("underlay stack:");
            m602a(e);
            e.m311a("overlay stack:");
            c0475m.m602a(e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC0806d m600a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        return i >= this.f567c ? m596a("underflow") : this.f565a[(this.f567c - i) - 1];
    }

    /* JADX INFO: renamed from: a */
    public final void m601a(int i, InterfaceC0806d interfaceC0806d) {
        m2004l();
        try {
            InterfaceC0806d interfaceC0806dMo664b = interfaceC0806d.mo664b();
            int i2 = (this.f567c - i) - 1;
            InterfaceC0806d interfaceC0806d2 = this.f565a[i2];
            if (interfaceC0806d2 == null || interfaceC0806d2.mo663a().m1687i() != interfaceC0806dMo664b.mo663a().m1687i()) {
                m596a("incompatible substitution: " + m597b(interfaceC0806d2) + " -> " + m597b(interfaceC0806dMo664b));
            }
            this.f565a[i2] = interfaceC0806dMo664b;
        } catch (NullPointerException e) {
            throw new NullPointerException("type == null");
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m602a(C0400d c0400d) {
        int i = this.f567c - 1;
        int i2 = 0;
        while (i2 <= i) {
            c0400d.m311a("stack[" + (i2 == i ? "top0" : C0985a.m2296v(i - i2)) + "]: " + m597b(this.f565a[i2]));
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m603a(C0805c c0805c) {
        if (this.f567c == 0) {
            return;
        }
        m2004l();
        C0805c c0805cM1695q = c0805c.m1695q();
        for (int i = 0; i < this.f567c; i++) {
            if (this.f565a[i] == c0805c) {
                this.f565a[i] = c0805cM1695q;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m604a(InterfaceC0806d interfaceC0806d) {
        m2004l();
        try {
            InterfaceC0806d interfaceC0806dMo664b = interfaceC0806d.mo664b();
            int iM1687i = interfaceC0806dMo664b.mo663a().m1687i();
            if (this.f567c + iM1687i > this.f565a.length) {
                m596a("overflow");
                return;
            }
            if (iM1687i == 2) {
                this.f565a[this.f567c] = null;
                this.f567c++;
            }
            this.f565a[this.f567c] = interfaceC0806dMo664b;
            this.f567c++;
        } catch (NullPointerException e) {
            throw new NullPointerException("type == null");
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m605b() {
        return this.f567c;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m606b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        if (i >= this.f567c) {
            throw new C0459ah("stack: underflow");
        }
        return this.f566b[(this.f567c - i) - 1];
    }

    /* JADX INFO: renamed from: c */
    public final C0805c m607c(int i) {
        return m600a(i).mo663a();
    }

    /* JADX INFO: renamed from: c */
    public final void m608c() {
        m2004l();
        for (int i = 0; i < this.f567c; i++) {
            this.f565a[i] = null;
            this.f566b[i] = false;
        }
        this.f567c = 0;
    }

    /* JADX INFO: renamed from: d */
    public final void m609d() {
        m2004l();
        this.f566b[this.f567c] = true;
    }

    /* JADX INFO: renamed from: e */
    public final InterfaceC0806d m610e() {
        m2004l();
        InterfaceC0806d interfaceC0806dM600a = m600a(0);
        this.f565a[this.f567c - 1] = null;
        this.f566b[this.f567c - 1] = false;
        this.f567c -= interfaceC0806dM600a.mo663a().m1687i();
        return interfaceC0806dM600a;
    }
}
