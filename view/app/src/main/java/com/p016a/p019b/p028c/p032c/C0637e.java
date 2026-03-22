package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0637e extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private C0636d f1123a;

    public C0637e(C0636d c0636d) {
        super(4, 4);
        this.f1123a = c0636d;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1064t;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        this.f1123a = (C0636d) c0650r.m1223e().m1074b(this.f1123a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        int iF = this.f1123a.m1083f();
        if (c0888r.m2019b()) {
            c0888r.m2010a(4, "  annotations_off: " + C0985a.m2294t(iF));
        }
        c0888r.m2020c(iF);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        return this.f1123a.mo1045b();
    }
}
