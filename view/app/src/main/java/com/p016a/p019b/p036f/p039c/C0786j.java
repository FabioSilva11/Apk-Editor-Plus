package com.p016a.p019b.p036f.p039c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0786j extends AbstractC0794r {

    /* JADX INFO: renamed from: a */
    public static final C0786j f1910a = new C0786j(Double.doubleToLongBits(0.0d));

    /* JADX INFO: renamed from: b */
    public static final C0786j f1911b = new C0786j(Double.doubleToLongBits(1.0d));

    private C0786j(long j) {
        super(j);
    }

    /* JADX INFO: renamed from: a */
    public static C0786j m1625a(long j) {
        return new C0786j(j);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2013d;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return Double.toString(Double.longBitsToDouble(mo1633k()));
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "double";
    }

    public final String toString() {
        long jK = mo1633k();
        return "double{0x" + C0985a.m2193a(jK) + " / " + Double.longBitsToDouble(jK) + '}';
    }
}
