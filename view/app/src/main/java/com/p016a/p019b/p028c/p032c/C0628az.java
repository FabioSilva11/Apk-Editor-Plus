package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.az */
/* JADX INFO: loaded from: classes.dex */
public final class C0628az extends AbstractC0604ab {
    public C0628az(C0802z c0802z) {
        super(c0802z);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1047c;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0604ab, com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        c0650r.m1226h().m1113a(m1048d().m1656j());
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1053a(C0650r c0650r, C0888r c0888r) {
        C0801y c0801yM1656j = m1048d().m1656j();
        int iM1114b = c0650r.m1226h().m1114b(c0801yM1656j);
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, m1052j() + ' ' + c0801yM1656j.mo657d());
            c0888r.m2010a(4, "  descriptor_idx: " + C0985a.m2294t(iM1114b));
        }
        c0888r.m2020c(iM1114b);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: e_ */
    public final int mo1054e_() {
        return 4;
    }
}
