package com.p016a.p019b.p020a.p024d;

import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p036f.p039c.C0776aa;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0873c;

/* JADX INFO: renamed from: com.a.b.a.d.l */
/* JADX INFO: loaded from: classes.dex */
final class C0501l implements InterfaceC0807e {

    /* JADX INFO: renamed from: a */
    private final C0873c f638a;

    /* JADX INFO: renamed from: b */
    private final int f639b;

    /* JADX INFO: renamed from: c */
    private final C0776aa f640c;

    public C0501l(C0873c c0873c, int i, int i2, C0776aa c0776aa, InterfaceC0515j interfaceC0515j) {
        if (i2 < 0) {
            throw new IllegalArgumentException("size < 0");
        }
        C0873c c0873cM1959a = c0873c.m1959a(i, (i2 << 1) + i);
        this.f638a = c0873cM1959a;
        this.f639b = i2;
        this.f640c = c0776aa;
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                C0802z c0802z = (C0802z) c0776aa.mo1607a(c0873cM1959a.m1966f(i3 << 1));
                if (interfaceC0515j != null) {
                    new StringBuilder("  ").append(c0802z);
                }
            } catch (ClassCastException e) {
                throw new RuntimeException("bogus class cpi", e);
            }
        }
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0807e
    /* JADX INFO: renamed from: a */
    public final C0805c mo756a(int i) {
        return ((C0802z) this.f640c.mo1607a(this.f638a.m1966f(i << 1))).m1655i();
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0807e
    /* JADX INFO: renamed from: a */
    public final InterfaceC0807e mo757a(C0805c c0805c) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0807e
    /* JADX INFO: renamed from: c_ */
    public final boolean mo758c_() {
        return false;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0807e
    /* JADX INFO: renamed from: d_ */
    public final int mo759d_() {
        return this.f639b;
    }
}
