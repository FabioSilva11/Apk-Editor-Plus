package com.p016a.p017a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.a.a.r */
/* JADX INFO: loaded from: classes.dex */
final class C0419r extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0410i f404a;

    private C0419r(C0410i c0410i) {
        this.f404a = c0410i;
    }

    /* synthetic */ C0419r(C0410i c0410i, byte b2) {
        this(c0410i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return this.f404a.f385e.get(this.f404a.m361c(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f404a.f383c.f424c.f342b;
    }
}
