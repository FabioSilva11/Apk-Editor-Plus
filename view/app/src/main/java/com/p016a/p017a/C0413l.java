package com.p016a.p017a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.a.a.l */
/* JADX INFO: loaded from: classes.dex */
final class C0413l extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0410i f395a;

    private C0413l(C0410i c0410i) {
        this.f395a = c0410i;
    }

    /* synthetic */ C0413l(C0410i c0410i, byte b2) {
        this(c0410i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        C0410i.m350b(i, this.f395a.f383c.f426e.f342b);
        return this.f395a.m354a(this.f395a.f383c.f426e.f343c + (i * 8)).m393g();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f395a.f383c.f426e.f342b;
    }
}
