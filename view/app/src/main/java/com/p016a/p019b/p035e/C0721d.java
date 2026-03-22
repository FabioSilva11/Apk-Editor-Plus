package com.p016a.p019b.p035e;

import com.p016a.p017a.C0401aa;
import com.p016a.p017a.C0416o;
import com.p016a.p017a.C0421t;
import com.p016a.p017a.C0427z;

/* JADX INFO: renamed from: com.a.b.e.d */
/* JADX INFO: loaded from: classes.dex */
final class C0721d extends AbstractC0727j {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0719b f1553a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0721d(C0719b c0719b, C0416o c0416o) {
        super(c0719b, c0416o);
        this.f1553a = c0719b;
    }

    @Override // com.p016a.p019b.p035e.AbstractC0727j
    /* JADX INFO: renamed from: a */
    final C0401aa mo1374a(C0427z c0427z) {
        return c0427z.f424c;
    }

    @Override // com.p016a.p019b.p035e.AbstractC0727j
    /* JADX INFO: renamed from: a */
    final /* synthetic */ Comparable mo1375a(C0416o c0416o, C0730m c0730m, int i) {
        return Integer.valueOf(c0730m.m1399a(c0416o.m385b()));
    }

    @Override // com.p016a.p019b.p035e.AbstractC0727j
    /* JADX INFO: renamed from: a */
    final void mo1376a(int i, C0730m c0730m, int i2, int i3) {
        if (i3 < 0 || i3 > 65535) {
            throw new C0421t("type ID not in [0, 0xffff]: " + i3);
        }
        c0730m.f1579b[i2] = (short) i3;
    }

    @Override // com.p016a.p019b.p035e.AbstractC0727j
    /* JADX INFO: renamed from: a */
    final /* synthetic */ void mo1377a(Comparable comparable) {
        this.f1553a.f1534g.m392f(((Integer) comparable).intValue());
    }
}
