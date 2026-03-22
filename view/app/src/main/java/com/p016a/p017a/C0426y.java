package com.p016a.p017a;

import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.a.a.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0426y implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0410i f418a;

    /* JADX INFO: renamed from: b */
    private final int f419b;

    /* JADX INFO: renamed from: c */
    private final int f420c;

    /* JADX INFO: renamed from: d */
    private final int f421d;

    public C0426y(C0410i c0410i, int i, int i2, int i3) {
        this.f418a = c0410i;
        this.f419b = i;
        this.f420c = i2;
        this.f421d = i3;
    }

    /* JADX INFO: renamed from: a */
    public final int m436a() {
        return this.f419b;
    }

    /* JADX INFO: renamed from: a */
    public final void m437a(C0416o c0416o) {
        c0416o.m392f(this.f419b);
        c0416o.m392f(this.f420c);
        c0416o.m392f(this.f421d);
    }

    /* JADX INFO: renamed from: b */
    public final int m438b() {
        return this.f420c;
    }

    /* JADX INFO: renamed from: c */
    public final int m439c() {
        return this.f421d;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        C0426y c0426y = (C0426y) obj;
        return this.f420c != c0426y.f420c ? C0985a.m2170a(this.f420c, c0426y.f420c) : C0985a.m2170a(this.f421d, c0426y.f421d);
    }

    public final String toString() {
        return this.f418a == null ? this.f419b + " " + this.f420c + " " + this.f421d : ((String) this.f418a.m363e().get(this.f419b)) + ": " + ((String) this.f418a.m365g().get(this.f420c)) + " " + this.f418a.m359b(this.f421d);
    }
}
