package com.p016a.p017a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.a.a.m */
/* JADX INFO: loaded from: classes.dex */
final class C0414m extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0410i f396a;

    private C0414m(C0410i c0410i) {
        this.f396a = c0410i;
    }

    /* synthetic */ C0414m(C0410i c0410i, byte b2) {
        this(c0410i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        C0410i.m350b(i, this.f396a.f383c.f427f.f342b);
        return this.f396a.m354a(this.f396a.f383c.f427f.f343c + (i * 8)).m395h();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f396a.f383c.f427f.f342b;
    }
}
