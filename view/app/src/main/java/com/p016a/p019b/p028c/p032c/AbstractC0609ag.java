package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.AbstractC0797u;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.ag */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0609ag extends AbstractC0604ab {

    /* JADX INFO: renamed from: a */
    private final AbstractC0797u f1074a;

    public AbstractC0609ag(AbstractC0797u abstractC0797u) {
        super(abstractC0797u.m1636k());
        this.f1074a = abstractC0797u;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0604ab, com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public void mo1042a(C0650r c0650r) {
        super.mo1042a(c0650r);
        c0650r.m1226h().m1113a(this.f1074a.m1637l().m1638a());
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1053a(C0650r c0650r, C0888r c0888r) {
        C0630ba c0630baM1229k = c0650r.m1229k();
        C0627ay c0627ayM1226h = c0650r.m1226h();
        C0799w c0799wM1637l = this.f1074a.m1637l();
        int iM1119b = c0630baM1229k.m1119b(m1048d());
        int iM1114b = c0627ayM1226h.m1114b(c0799wM1637l.m1638a());
        int iMo1058b = mo1058b(c0650r);
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, m1052j() + ' ' + this.f1074a.mo657d());
            c0888r.m2010a(2, "  class_idx: " + C0985a.m2296v(iM1119b));
            c0888r.m2010a(2, String.format("  %-10s %s", mo1059c() + ':', C0985a.m2296v(iMo1058b)));
            c0888r.m2010a(4, "  name_idx:  " + C0985a.m2294t(iM1114b));
        }
        c0888r.m2018b(iM1119b);
        c0888r.m2018b(iMo1058b);
        c0888r.m2020c(iM1114b);
    }

    /* JADX INFO: renamed from: b */
    protected abstract int mo1058b(C0650r c0650r);

    /* JADX INFO: renamed from: c */
    protected abstract String mo1059c();

    /* JADX INFO: renamed from: e */
    public final AbstractC0797u m1060e() {
        return this.f1074a;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: e_ */
    public final int mo1054e_() {
        return 8;
    }
}
