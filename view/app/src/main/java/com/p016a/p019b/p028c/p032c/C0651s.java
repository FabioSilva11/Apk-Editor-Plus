package com.p016a.p019b.p028c.p032c;

import com.p016a.p019b.p036f.p039c.C0780d;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0651s extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final C0780d f1204a;

    /* JADX INFO: renamed from: b */
    private byte[] f1205b;

    public C0651s(C0780d c0780d) {
        super(1, -1);
        if (c0780d == null) {
            throw new NullPointerException("array == null");
        }
        this.f1204a = c0780d;
        this.f1205b = null;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final int mo1039a(AbstractC0618ap abstractC0618ap) {
        return this.f1204a.compareTo(((C0651s) abstractC0618ap).f1204a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1061q;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final void mo1041a(AbstractC0622at abstractC0622at, int i) {
        C0888r c0888r = new C0888r();
        new C0634be(abstractC0622at.m1099e(), c0888r).m1131a(this.f1204a, false);
        this.f1205b = c0888r.m2028g();
        m1080a(this.f1205b.length);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        C0634be.m1127a(c0650r, this.f1204a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        if (!c0888r.m2019b()) {
            c0888r.m2016a(this.f1205b);
        } else {
            c0888r.m2010a(0, m1085h() + " encoded array");
            new C0634be(c0650r, c0888r).m1131a(this.f1204a, true);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        return this.f1204a.mo657d();
    }

    public final int hashCode() {
        return this.f1204a.hashCode();
    }
}
