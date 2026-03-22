package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0783g extends AbstractC0793q {

    /* JADX INFO: renamed from: a */
    public static final C0783g f1906a = new C0783g(false);

    /* JADX INFO: renamed from: b */
    private static C0783g f1907b = new C0783g(true);

    private C0783g(boolean z) {
        super(z ? 1 : 0);
    }

    /* JADX INFO: renamed from: a */
    public static C0783g m1619a(int i) {
        if (i == 0) {
            return f1906a;
        }
        if (i == 1) {
            return f1907b;
        }
        throw new IllegalArgumentException("bogus value: " + i);
    }

    /* JADX INFO: renamed from: m */
    private boolean m1620m() {
        return mo1632j() != 0;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2010a;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return m1620m() ? "true" : "false";
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "boolean";
    }

    public final String toString() {
        return m1620m() ? "boolean{true}" : "boolean{false}";
    }
}
