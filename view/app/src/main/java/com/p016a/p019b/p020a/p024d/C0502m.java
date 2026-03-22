package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.C0517l;
import com.p016a.p019b.p020a.p025e.C0518m;
import com.p016a.p019b.p020a.p025e.InterfaceC0507b;
import com.p016a.p019b.p020a.p025e.InterfaceC0509d;
import com.p016a.p019b.p020a.p025e.InterfaceC0511f;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0802z;

/* JADX INFO: renamed from: com.a.b.a.d.m */
/* JADX INFO: loaded from: classes.dex */
final class C0502m extends AbstractC0503n {

    /* JADX INFO: renamed from: a */
    private final C0518m f641a;

    public C0502m(C0500k c0500k, C0802z c0802z, int i, C0491b c0491b) {
        super(c0500k, c0802z, i, c0491b);
        this.f641a = new C0518m(m768f());
    }

    @Override // com.p016a.p019b.p020a.p024d.AbstractC0503n
    /* JADX INFO: renamed from: a */
    protected final InterfaceC0511f mo760a(int i, int i2, C0799w c0799w, InterfaceC0507b interfaceC0507b) {
        C0517l c0517l = new C0517l(m769g(), i2, c0799w, interfaceC0507b);
        this.f641a.m797a(i, (InterfaceC0509d) c0517l);
        return c0517l;
    }

    /* JADX INFO: renamed from: a */
    public final C0518m m761a() {
        m767e();
        return this.f641a;
    }

    @Override // com.p016a.p019b.p020a.p024d.AbstractC0503n
    /* JADX INFO: renamed from: a */
    protected final String mo762a(int i) {
        return C0985a.m2278i(i);
    }

    @Override // com.p016a.p019b.p020a.p024d.AbstractC0503n
    /* JADX INFO: renamed from: b */
    protected final String mo763b() {
        return "field";
    }

    @Override // com.p016a.p019b.p020a.p024d.AbstractC0503n
    /* JADX INFO: renamed from: c */
    protected final int mo764c() {
        return 1;
    }
}
