package com.p016a.p019b.p043h;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.a.b.h.o */
/* JADX INFO: loaded from: classes.dex */
final class C0885o implements InterfaceC0879i {

    /* JADX INFO: renamed from: a */
    private int f2251a = 0;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0884n f2252b;

    C0885o(C0884n c0884n) {
        this.f2252b = c0884n;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0879i
    /* JADX INFO: renamed from: a */
    public final boolean mo1948a() {
        return this.f2251a < this.f2252b.f2250a.m1985b();
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0879i
    /* JADX INFO: renamed from: b */
    public final int mo1949b() {
        if (!mo1948a()) {
            throw new NoSuchElementException();
        }
        C0880j c0880j = this.f2252b.f2250a;
        int i = this.f2251a;
        this.f2251a = i + 1;
        return c0880j.m1986b(i);
    }
}
