package com.p016a.p017a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import jadx.core.deobf.Deobfuscator;

/* JADX INFO: renamed from: com.a.a.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0425x implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0410i f414a;

    /* JADX INFO: renamed from: b */
    private final int f415b;

    /* JADX INFO: renamed from: c */
    private final int f416c;

    /* JADX INFO: renamed from: d */
    private final int f417d;

    public C0425x(C0410i c0410i, int i, int i2, int i3) {
        this.f414a = c0410i;
        this.f415b = i;
        this.f416c = i2;
        this.f417d = i3;
    }

    /* JADX INFO: renamed from: a */
    public final int m432a() {
        return this.f415b;
    }

    /* JADX INFO: renamed from: a */
    public final void m433a(C0416o c0416o) {
        c0416o.m390e(this.f415b);
        c0416o.m390e(this.f416c);
        c0416o.m392f(this.f417d);
    }

    /* JADX INFO: renamed from: b */
    public final int m434b() {
        return this.f416c;
    }

    /* JADX INFO: renamed from: c */
    public final int m435c() {
        return this.f417d;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        C0425x c0425x = (C0425x) obj;
        return this.f415b != c0425x.f415b ? C0985a.m2170a(this.f415b, c0425x.f415b) : this.f417d != c0425x.f417d ? C0985a.m2170a(this.f417d, c0425x.f417d) : C0985a.m2170a(this.f416c, c0425x.f416c);
    }

    public final String toString() {
        return this.f414a == null ? this.f415b + " " + this.f416c + " " + this.f417d : ((String) this.f414a.m365g().get(this.f415b)) + Deobfuscator.CLASS_NAME_SEPARATOR + ((String) this.f414a.m363e().get(this.f417d)) + this.f414a.m359b(((C0426y) this.f414a.m366h().get(this.f416c)).m439c());
    }
}
