package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p043h.C0873c;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.aw */
/* JADX INFO: loaded from: classes.dex */
public final class C0625aw extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final C0801y f1110a;

    public C0625aw(C0801y c0801y) {
        super(1, C0985a.m2261d(c0801y.m1652m()) + c0801y.m1651l() + 1);
        this.f1110a = c0801y;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final int mo1039a(AbstractC0618ap abstractC0618ap) {
        return this.f1110a.compareTo(((C0625aw) abstractC0618ap).f1110a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1058n;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    public final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        C0873c c0873cM1650k = this.f1110a.m1650k();
        int iM1652m = this.f1110a.m1652m();
        if (c0888r.m2019b()) {
            c0888r.m2010a(C0985a.m2261d(iM1652m), "utf16_size: " + C0985a.m2294t(iM1652m));
            c0888r.m2010a(c0873cM1650k.m1957a() + 1, this.f1110a.m1648i());
        }
        c0888r.m2024e(iM1652m);
        c0888r.m2013a(c0873cM1650k);
        c0888r.mo307d(0);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        return this.f1110a.m1648i();
    }
}
