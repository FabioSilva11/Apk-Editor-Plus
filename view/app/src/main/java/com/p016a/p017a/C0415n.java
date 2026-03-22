package com.p016a.p017a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.a.a.n */
/* JADX INFO: loaded from: classes.dex */
final class C0415n extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0410i f397a;

    private C0415n(C0410i c0410i) {
        this.f397a = c0410i;
    }

    /* synthetic */ C0415n(C0410i c0410i, byte b2) {
        this(c0410i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        C0410i.m350b(i, this.f397a.f383c.f425d.f342b);
        return this.f397a.m354a(this.f397a.f383c.f425d.f343c + (i * 12)).m397i();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f397a.f383c.f425d.f342b;
    }
}
