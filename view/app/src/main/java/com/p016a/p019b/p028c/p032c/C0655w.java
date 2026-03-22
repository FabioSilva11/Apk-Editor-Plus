package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p043h.C0888r;
import com.p016a.p019b.p043h.InterfaceC0889s;
import jadx.core.codegen.CodeWriter;

/* JADX INFO: renamed from: com.a.b.c.c.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0655w implements InterfaceC0889s, Comparable {

    /* JADX INFO: renamed from: a */
    private final C0788l f1210a;

    /* JADX INFO: renamed from: b */
    private C0636d f1211b;

    public C0655w(C0788l c0788l, C0636d c0636d) {
        if (c0788l == null) {
            throw new NullPointerException("field == null");
        }
        this.f1210a = c0788l;
        this.f1211b = c0636d;
    }

    /* JADX INFO: renamed from: a */
    public final void m1247a(C0650r c0650r) {
        C0657y c0657yM1231m = c0650r.m1231m();
        C0614al c0614alM1223e = c0650r.m1223e();
        c0657yM1231m.m1250a(this.f1210a);
        this.f1211b = (C0636d) c0614alM1223e.m1074b(this.f1211b);
    }

    /* JADX INFO: renamed from: a */
    public final void m1248a(C0650r c0650r, C0888r c0888r) {
        int iM1252b = c0650r.m1231m().m1252b(this.f1210a);
        int iF = this.f1211b.m1083f();
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, CodeWriter.INDENT + this.f1210a.mo657d());
            c0888r.m2010a(4, "      field_idx:       " + C0985a.m2294t(iM1252b));
            c0888r.m2010a(4, "      annotations_off: " + C0985a.m2294t(iF));
        }
        c0888r.m2020c(iM1252b);
        c0888r.m2020c(iF);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.f1210a.compareTo(((C0655w) obj).f1210a);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1210a.mo657d() + ": " + this.f1211b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0655w) {
            return this.f1210a.equals(((C0655w) obj).f1210a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1210a.hashCode();
    }
}
