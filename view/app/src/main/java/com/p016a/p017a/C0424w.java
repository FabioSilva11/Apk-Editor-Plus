package com.p016a.p017a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import jadx.core.deobf.Deobfuscator;

/* JADX INFO: renamed from: com.a.a.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0424w implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0410i f410a;

    /* JADX INFO: renamed from: b */
    private final int f411b;

    /* JADX INFO: renamed from: c */
    private final int f412c;

    /* JADX INFO: renamed from: d */
    private final int f413d;

    public C0424w(C0410i c0410i, int i, int i2, int i3) {
        this.f410a = c0410i;
        this.f411b = i;
        this.f412c = i2;
        this.f413d = i3;
    }

    /* JADX INFO: renamed from: a */
    public final int m428a() {
        return this.f411b;
    }

    /* JADX INFO: renamed from: a */
    public final void m429a(C0416o c0416o) {
        c0416o.m390e(this.f411b);
        c0416o.m390e(this.f412c);
        c0416o.m392f(this.f413d);
    }

    /* JADX INFO: renamed from: b */
    public final int m430b() {
        return this.f412c;
    }

    /* JADX INFO: renamed from: c */
    public final int m431c() {
        return this.f413d;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        C0424w c0424w = (C0424w) obj;
        return this.f411b != c0424w.f411b ? C0985a.m2170a(this.f411b, c0424w.f411b) : this.f413d != c0424w.f413d ? C0985a.m2170a(this.f413d, c0424w.f413d) : C0985a.m2170a(this.f412c, c0424w.f412c);
    }

    public final String toString() {
        return this.f410a == null ? this.f411b + " " + this.f412c + " " + this.f413d : ((String) this.f410a.m365g().get(this.f412c)) + Deobfuscator.CLASS_NAME_SEPARATOR + ((String) this.f410a.m363e().get(this.f413d));
    }
}
