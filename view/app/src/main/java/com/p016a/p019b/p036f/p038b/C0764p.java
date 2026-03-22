package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;

/* JADX INFO: renamed from: com.a.b.f.b.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0764p extends AbstractC0753e {
    public C0764p(C0771w c0771w, C0774z c0774z, C0766r c0766r, C0768t c0768t, AbstractC0775a abstractC0775a) {
        super(c0771w, c0774z, c0766r, c0768t, abstractC0775a);
        if (c0771w.m1577d() != 1) {
            throw new IllegalArgumentException("bogus branchingness");
        }
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1465a(C0766r c0766r, C0768t c0768t) {
        return new C0764p(m1490f(), m1491g(), c0766r, c0768t, m1486g_());
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1466a(C0805c c0805c) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final void mo1468a(InterfaceC0759k interfaceC0759k) {
        interfaceC0759k.mo889a(this);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: b */
    public final InterfaceC0807e mo1470b() {
        return C0804b.f1974a;
    }
}
