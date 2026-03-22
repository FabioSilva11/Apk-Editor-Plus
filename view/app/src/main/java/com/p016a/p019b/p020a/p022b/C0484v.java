package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;

/* JADX INFO: renamed from: com.a.b.a.b.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0484v extends AbstractC0481s {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0806d[] f583a;

    public C0484v(int i) {
        super(i != 0);
        this.f583a = new InterfaceC0806d[i];
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final AbstractC0481s mo644a(AbstractC0481s abstractC0481s) {
        return abstractC0481s instanceof C0484v ? m658a((C0484v) abstractC0481s) : abstractC0481s.mo644a(this);
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final C0482t mo645a(AbstractC0481s abstractC0481s, int i) {
        return new C0482t(this.f583a.length).mo645a(abstractC0481s, i);
    }

    /* JADX INFO: renamed from: a */
    public final C0484v m658a(C0484v c0484v) {
        try {
            return C0985a.m2184a(this, c0484v);
        } catch (C0459ah e) {
            e.m311a("underlay locals:");
            mo648a(e);
            e.m311a("overlay locals:");
            c0484v.mo648a(e);
            throw e;
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final InterfaceC0806d mo646a(int i) {
        InterfaceC0806d interfaceC0806d = this.f583a[i];
        if (interfaceC0806d == null) {
            throw new C0459ah("local " + C0985a.m2296v(i) + ": invalid");
        }
        return interfaceC0806d;
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final void mo647a(int i, InterfaceC0806d interfaceC0806d) {
        InterfaceC0806d interfaceC0806d2;
        m2004l();
        try {
            InterfaceC0806d interfaceC0806dMo664b = interfaceC0806d.mo664b();
            if (i < 0) {
                throw new IndexOutOfBoundsException("idx < 0");
            }
            if (interfaceC0806dMo664b.mo663a().m1689k()) {
                this.f583a[i + 1] = null;
            }
            this.f583a[i] = interfaceC0806dMo664b;
            if (i == 0 || (interfaceC0806d2 = this.f583a[i - 1]) == null || !interfaceC0806d2.mo663a().m1689k()) {
                return;
            }
            this.f583a[i - 1] = null;
        } catch (NullPointerException e) {
            throw new NullPointerException("type == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final void mo648a(C0400d c0400d) {
        for (int i = 0; i < this.f583a.length; i++) {
            InterfaceC0806d interfaceC0806d = this.f583a[i];
            c0400d.m311a("locals[" + C0985a.m2296v(i) + "]: " + (interfaceC0806d == null ? "<invalid>" : interfaceC0806d.toString()));
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final void mo649a(C0766r c0766r) {
        mo647a(c0766r.m1533g(), c0766r);
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final void mo650a(C0805c c0805c) {
        int length = this.f583a.length;
        if (length == 0) {
            return;
        }
        m2004l();
        C0805c c0805cM1695q = c0805c.m1695q();
        for (int i = 0; i < length; i++) {
            if (this.f583a[i] == c0805c) {
                this.f583a[i] = c0805cM1695q;
            }
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: b */
    protected final C0484v mo651b() {
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final void m659b(int i) {
        m2004l();
        this.f583a[i] = null;
    }

    /* JADX INFO: renamed from: c */
    public final InterfaceC0806d m660c(int i) {
        return this.f583a[i];
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f583a.length; i++) {
            InterfaceC0806d interfaceC0806d = this.f583a[i];
            sb.append("locals[" + C0985a.m2296v(i) + "]: " + (interfaceC0806d == null ? "<invalid>" : interfaceC0806d.toString()) + "\n");
        }
        return sb.toString();
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final C0484v mo643a() {
        C0484v c0484v = new C0484v(this.f583a.length);
        System.arraycopy(this.f583a, 0, c0484v.f583a, 0, this.f583a.length);
        return c0484v;
    }

    /* JADX INFO: renamed from: f */
    public final int m662f() {
        return this.f583a.length;
    }
}
