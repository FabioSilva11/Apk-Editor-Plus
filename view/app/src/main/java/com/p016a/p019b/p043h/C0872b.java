package com.p016a.p019b.p043h;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.a.b.h.b */
/* JADX INFO: loaded from: classes.dex */
final class C0872b implements InterfaceC0879i {

    /* JADX INFO: renamed from: a */
    private int f2227a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0871a f2228b;

    C0872b(C0871a c0871a) {
        this.f2228b = c0871a;
        this.f2227a = C0985a.m2262d(this.f2228b.f2226a, 0);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0879i
    /* JADX INFO: renamed from: a */
    public final boolean mo1948a() {
        return this.f2227a >= 0;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0879i
    /* JADX INFO: renamed from: b */
    public final int mo1949b() {
        if (!mo1948a()) {
            throw new NoSuchElementException();
        }
        int i = this.f2227a;
        this.f2227a = C0985a.m2262d(this.f2228b.f2226a, this.f2227a + 1);
        return i;
    }
}
