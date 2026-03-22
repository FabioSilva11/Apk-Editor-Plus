package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;

/* JADX INFO: renamed from: com.a.b.f.b.ac */
/* JADX INFO: loaded from: classes.dex */
public final class C0748ac extends AbstractC0757i {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0807e f1625a;

    public C0748ac(C0771w c0771w, C0774z c0774z, C0768t c0768t, InterfaceC0807e interfaceC0807e) {
        super(c0771w, c0774z, null, c0768t);
        if (c0771w.m1577d() != 6) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        if (interfaceC0807e == null) {
            throw new NullPointerException("catches == null");
        }
        this.f1625a = interfaceC0807e;
    }

    /* JADX INFO: renamed from: a */
    public static String m1472a(InterfaceC0807e interfaceC0807e) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("catch");
        int iMo759d_ = interfaceC0807e.mo759d_();
        for (int i = 0; i < iMo759d_; i++) {
            stringBuffer.append(" ");
            stringBuffer.append(interfaceC0807e.mo756a(i).mo657d());
        }
        return stringBuffer.toString();
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1465a(C0766r c0766r, C0768t c0768t) {
        return new C0748ac(m1490f(), m1491g(), c0768t, this.f1625a);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final AbstractC0757i mo1466a(C0805c c0805c) {
        return new C0748ac(m1490f(), m1491g(), m1494j(), this.f1625a.mo757a(c0805c));
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final String mo1467a() {
        return m1472a(this.f1625a);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: a */
    public final void mo1468a(InterfaceC0759k interfaceC0759k) {
        interfaceC0759k.mo893a(this);
    }

    @Override // com.p016a.p019b.p036f.p038b.AbstractC0757i
    /* JADX INFO: renamed from: b */
    public final InterfaceC0807e mo1470b() {
        return this.f1625a;
    }
}
