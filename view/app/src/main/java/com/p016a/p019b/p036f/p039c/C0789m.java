package com.p016a.p019b.p036f.p039c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0789m extends AbstractC0793q {

    /* JADX INFO: renamed from: a */
    public static final C0789m f1913a = m1628a(Float.floatToIntBits(0.0f));

    /* JADX INFO: renamed from: b */
    public static final C0789m f1914b = m1628a(Float.floatToIntBits(1.0f));

    /* JADX INFO: renamed from: c */
    public static final C0789m f1915c = m1628a(Float.floatToIntBits(2.0f));

    private C0789m(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0789m m1628a(int i) {
        return new C0789m(i);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2014e;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return Float.toString(Float.intBitsToFloat(mo1632j()));
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "float";
    }

    public final String toString() {
        int iJ = mo1632j();
        return "float{0x" + C0985a.m2294t(iJ) + " / " + Float.intBitsToFloat(iJ) + '}';
    }
}
