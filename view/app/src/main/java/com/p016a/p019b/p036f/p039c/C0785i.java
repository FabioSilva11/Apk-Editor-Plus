package com.p016a.p019b.p036f.p039c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0785i extends AbstractC0793q {

    /* JADX INFO: renamed from: a */
    public static final C0785i f1909a = m1623a((char) 0);

    private C0785i(char c) {
        super(c);
    }

    /* JADX INFO: renamed from: a */
    private static C0785i m1623a(char c) {
        return new C0785i(c);
    }

    /* JADX INFO: renamed from: a */
    public static C0785i m1624a(int i) {
        char c = (char) i;
        if (c != i) {
            throw new IllegalArgumentException("bogus char value: " + i);
        }
        return m1623a(c);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2012c;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return Integer.toString(mo1632j());
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "char";
    }

    public final String toString() {
        int iJ = mo1632j();
        return "char{0x" + C0985a.m2296v(iJ) + " / " + iJ + '}';
    }
}
