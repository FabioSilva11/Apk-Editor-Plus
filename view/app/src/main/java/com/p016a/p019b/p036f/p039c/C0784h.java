package com.p016a.p019b.p036f.p039c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0784h extends AbstractC0793q {

    /* JADX INFO: renamed from: a */
    public static final C0784h f1908a = m1621a((byte) 0);

    private C0784h(byte b2) {
        super(b2);
    }

    /* JADX INFO: renamed from: a */
    private static C0784h m1621a(byte b2) {
        return new C0784h(b2);
    }

    /* JADX INFO: renamed from: a */
    public static C0784h m1622a(int i) {
        byte b2 = (byte) i;
        if (b2 != i) {
            throw new IllegalArgumentException("bogus byte value: " + i);
        }
        return m1621a(b2);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2011b;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return Integer.toString(mo1632j());
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "byte";
    }

    public final String toString() {
        int iJ = mo1632j();
        return "byte{0x" + C0985a.m2298x(iJ) + " / " + iJ + '}';
    }
}
