package com.p016a.p017a;

import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.a.j */
/* JADX INFO: loaded from: classes.dex */
final class C0411j implements Iterable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0410i f391a;

    private C0411j(C0410i c0410i) {
        this.f391a = c0410i;
    }

    /* synthetic */ C0411j(C0410i c0410i, byte b2) {
        this(c0410i);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return !this.f391a.f383c.f428g.m312a() ? Collections.emptySet().iterator() : new C0412k(this.f391a, (byte) 0);
    }
}
