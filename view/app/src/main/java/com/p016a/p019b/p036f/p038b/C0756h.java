package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.f.b.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0756h extends AbstractC0757i {

    /* JADX INFO: renamed from: a */
    private final ArrayList f1647a;

    /* JADX INFO: renamed from: b */
    private final AbstractC0775a f1648b;

    public C0756h(C0771w c0771w, C0774z c0774z, C0768t c0768t, ArrayList arrayList, AbstractC0775a abstractC0775a) {
        super(c0771w, c0774z, null, c0768t);
        if (c0771w.m1577d() != 1) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        this.f1647a = arrayList;
        this.f1648b = abstractC0775a;
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1465a(C0766r c0766r, C0768t c0768t) {
        return new C0756h(m1490f(), m1491g(), c0768t, this.f1647a, this.f1648b);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1466a(C0805c c0805c) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final void mo1468a(InterfaceC0759k interfaceC0759k) {
        interfaceC0759k.mo899a(this);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: b */
    public final InterfaceC0807e mo1470b() {
        return C0804b.f1974a;
    }

    /* JADX INFO: renamed from: c */
    public final ArrayList m1487c() {
        return this.f1647a;
    }

    /* JADX INFO: renamed from: e */
    public final AbstractC0775a m1488e() {
        return this.f1648b;
    }
}
