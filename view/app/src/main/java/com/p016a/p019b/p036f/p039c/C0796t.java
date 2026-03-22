package com.p016a.p019b.p036f.p039c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.t */
/* JADX INFO: loaded from: classes.dex */
public final class C0796t extends AbstractC0794r {

    /* JADX INFO: renamed from: a */
    public static final C0796t f1928a = m1635a(0);

    /* JADX INFO: renamed from: b */
    public static final C0796t f1929b = m1635a(1);

    private C0796t(long j) {
        super(j);
    }

    /* JADX INFO: renamed from: a */
    public static C0796t m1635a(long j) {
        return new C0796t(j);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2016g;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return Long.toString(mo1633k());
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "long";
    }

    public final String toString() {
        long jK = mo1633k();
        return "long{0x" + C0985a.m2193a(jK) + " / " + jK + '}';
    }
}
