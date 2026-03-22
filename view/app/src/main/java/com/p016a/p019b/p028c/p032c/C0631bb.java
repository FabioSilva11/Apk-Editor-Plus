package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.bb */
/* JADX INFO: loaded from: classes.dex */
public final class C0631bb extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0807e f1116a;

    public C0631bb(InterfaceC0807e interfaceC0807e) {
        super(4, (interfaceC0807e.mo759d_() << 1) + 4);
        this.f1116a = interfaceC0807e;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final int mo1039a(AbstractC0618ap abstractC0618ap) {
        return C0804b.m1673b(this.f1116a, ((C0631bb) abstractC0618ap).f1116a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1053i;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        C0630ba c0630baM1229k = c0650r.m1229k();
        int iMo759d_ = this.f1116a.mo759d_();
        for (int i = 0; i < iMo759d_; i++) {
            c0630baM1229k.m1118a(this.f1116a.mo756a(i));
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        C0630ba c0630baM1229k = c0650r.m1229k();
        int iMo759d_ = this.f1116a.mo759d_();
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, m1085h() + " type_list");
            c0888r.m2010a(4, "  size: " + C0985a.m2294t(iMo759d_));
            for (int i = 0; i < iMo759d_; i++) {
                C0805c c0805cMo756a = this.f1116a.mo756a(i);
                c0888r.m2010a(2, "  " + C0985a.m2296v(c0630baM1229k.m1120b(c0805cMo756a)) + " // " + c0805cMo756a.mo657d());
            }
        }
        c0888r.m2020c(iMo759d_);
        for (int i2 = 0; i2 < iMo759d_; i2++) {
            c0888r.m2018b(c0630baM1229k.m1120b(this.f1116a.mo756a(i2)));
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        throw new RuntimeException("unsupported");
    }

    /* JADX INFO: renamed from: c */
    public final InterfaceC0807e m1122c() {
        return this.f1116a;
    }

    public final int hashCode() {
        return C0804b.m1672b(this.f1116a);
    }
}
