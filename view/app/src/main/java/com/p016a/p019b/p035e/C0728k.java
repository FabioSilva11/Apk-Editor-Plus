package com.p016a.p019b.p035e;

import com.p016a.p017a.C0410i;

/* JADX INFO: renamed from: com.a.b.e.k */
/* JADX INFO: loaded from: classes.dex */
final class C0728k implements Comparable {

    /* JADX INFO: renamed from: a */
    final C0410i f1561a;

    /* JADX INFO: renamed from: b */
    final Comparable f1562b;

    /* JADX INFO: renamed from: c */
    final int f1563c;

    /* JADX INFO: renamed from: d */
    final int f1564d;

    C0728k(AbstractC0727j abstractC0727j, C0410i c0410i, C0730m c0730m, Comparable comparable, int i, int i2) {
        this.f1561a = c0410i;
        this.f1562b = comparable;
        this.f1563c = i;
        this.f1564d = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0728k c0728k) {
        return this.f1562b.compareTo(c0728k.f1562b);
    }
}
