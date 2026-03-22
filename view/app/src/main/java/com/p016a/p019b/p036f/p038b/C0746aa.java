package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0880j;

/* JADX INFO: renamed from: com.a.b.f.b.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C0746aa extends AbstractC0757i {

    /* JADX INFO: renamed from: a */
    private final C0880j f1623a;

    public C0746aa(C0771w c0771w, C0774z c0774z, C0766r c0766r, C0768t c0768t, C0880j c0880j) {
        super(c0771w, c0774z, c0766r, c0768t);
        if (c0771w.m1577d() != 5) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        if (c0880j == null) {
            throw new NullPointerException("cases == null");
        }
        this.f1623a = c0880j;
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1465a(C0766r c0766r, C0768t c0768t) {
        return new C0746aa(m1490f(), m1491g(), c0766r, c0768t, this.f1623a);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1466a(C0805c c0805c) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final String mo1467a() {
        return this.f1623a.toString();
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final void mo1468a(InterfaceC0759k interfaceC0759k) {
        interfaceC0759k.mo891a(this);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final boolean mo1469a(AbstractC0757i abstractC0757i) {
        return false;
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: b */
    public final InterfaceC0807e mo1470b() {
        return C0804b.f1974a;
    }

    /* JADX INFO: renamed from: c */
    public final C0880j m1471c() {
        return this.f1623a;
    }
}
