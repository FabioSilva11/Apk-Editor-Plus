package com.p016a.p019b.p036f.p039c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0800x extends AbstractC0793q {

    /* JADX INFO: renamed from: a */
    public static final C0800x f1935a = m1644a((short) 0);

    private C0800x(short s) {
        super(s);
    }

    /* JADX INFO: renamed from: a */
    public static C0800x m1643a(int i) {
        short s = (short) i;
        if (s != i) {
            throw new IllegalArgumentException("bogus short value: " + i);
        }
        return m1644a(s);
    }

    /* JADX INFO: renamed from: a */
    private static C0800x m1644a(short s) {
        return new C0800x(s);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2017h;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return Integer.toString(mo1632j());
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "short";
    }

    public final String toString() {
        int iJ = mo1632j();
        return "short{0x" + C0985a.m2296v(iJ) + " / " + iJ + '}';
    }
}
