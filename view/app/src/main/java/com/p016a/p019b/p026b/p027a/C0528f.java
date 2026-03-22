package com.p016a.p019b.p026b.p027a;

import com.p016a.p019b.p020a.p024d.InterfaceC0498i;

/* JADX INFO: renamed from: com.a.b.b.a.f */
/* JADX INFO: loaded from: classes.dex */
final class C0528f implements InterfaceC0498i {
    private C0528f() {
    }

    /* synthetic */ C0528f(byte b2) {
        this();
    }

    @Override // com.p016a.p019b.p020a.p024d.InterfaceC0498i
    /* JADX INFO: renamed from: a */
    public final boolean mo730a(String str) {
        if (!str.endsWith(".class")) {
            return true;
        }
        return C0523a.f669l.contains(C0523a.m818f(str));
    }
}
