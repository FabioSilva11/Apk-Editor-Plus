package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.C0520o;
import com.p016a.p019b.p020a.p025e.C0521p;
import com.p016a.p019b.p020a.p025e.InterfaceC0507b;
import com.p016a.p019b.p020a.p025e.InterfaceC0511f;
import com.p016a.p019b.p020a.p025e.InterfaceC0512g;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0802z;

/* JADX INFO: renamed from: com.a.b.a.d.o */
/* JADX INFO: loaded from: classes.dex */
final class C0504o extends AbstractC0503n {

    /* JADX INFO: renamed from: a */
    private final C0521p f648a;

    public C0504o(C0500k c0500k, C0802z c0802z, int i, C0491b c0491b) {
        super(c0500k, c0802z, i, c0491b);
        this.f648a = new C0521p(m768f());
    }

    @Override // com.p016a.p019b.p020a.p024d.AbstractC0503n
    /* JADX INFO: renamed from: a */
    protected final InterfaceC0511f mo760a(int i, int i2, C0799w c0799w, InterfaceC0507b interfaceC0507b) {
        C0520o c0520o = new C0520o(m769g(), i2, c0799w, interfaceC0507b);
        this.f648a.m798a(i, (InterfaceC0512g) c0520o);
        return c0520o;
    }

    /* JADX INFO: renamed from: a */
    public final C0521p m770a() {
        m767e();
        return this.f648a;
    }

    @Override // com.p016a.p019b.p020a.p024d.AbstractC0503n
    /* JADX INFO: renamed from: a */
    protected final String mo762a(int i) {
        return C0985a.m2281j(i);
    }

    @Override // com.p016a.p019b.p020a.p024d.AbstractC0503n
    /* JADX INFO: renamed from: b */
    protected final String mo763b() {
        return "method";
    }

    @Override // com.p016a.p019b.p020a.p024d.AbstractC0503n
    /* JADX INFO: renamed from: c */
    protected final int mo764c() {
        return 2;
    }
}
