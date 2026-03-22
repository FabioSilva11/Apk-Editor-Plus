package com.p016a.p017a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.a.a.p */
/* JADX INFO: loaded from: classes.dex */
final class C0417p extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0410i f402a;

    private C0417p(C0410i c0410i) {
        this.f402a = c0410i;
    }

    /* synthetic */ C0417p(C0410i c0410i, byte b2) {
        this(c0410i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        C0410i.m350b(i, this.f402a.f383c.f423b.f342b);
        return this.f402a.m354a(this.f402a.f383c.f423b.f343c + (i << 2)).m391f();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f402a.f383c.f423b.f342b;
    }
}
