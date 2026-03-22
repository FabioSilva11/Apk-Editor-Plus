package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p037a.C0742c;
import com.p016a.p019b.p036f.p039c.AbstractC0782f;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p043h.C0888r;
import com.p016a.p019b.p043h.InterfaceC0889s;
import jadx.core.codegen.CodeWriter;

/* JADX INFO: renamed from: com.a.b.c.c.ai */
/* JADX INFO: loaded from: classes.dex */
public final class C0611ai implements InterfaceC0889s, Comparable {

    /* JADX INFO: renamed from: a */
    private final C0798v f1075a;

    /* JADX INFO: renamed from: b */
    private C0636d f1076b;

    public C0611ai(C0798v c0798v, C0636d c0636d) {
        if (c0798v == null) {
            throw new NullPointerException("method == null");
        }
        this.f1075a = c0798v;
        this.f1076b = c0636d;
    }

    /* JADX INFO: renamed from: a */
    public final C0798v m1062a() {
        return this.f1075a;
    }

    /* JADX INFO: renamed from: a */
    public final void m1063a(C0650r c0650r) {
        C0613ak c0613akM1232n = c0650r.m1232n();
        C0614al c0614alM1223e = c0650r.m1223e();
        c0613akM1232n.m1067a((AbstractC0782f) this.f1075a);
        this.f1076b = (C0636d) c0614alM1223e.m1074b(this.f1076b);
    }

    /* JADX INFO: renamed from: a */
    public final void m1064a(C0650r c0650r, C0888r c0888r) {
        int iM1069b = c0650r.m1232n().m1069b(this.f1075a);
        int iF = this.f1076b.m1083f();
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, CodeWriter.INDENT + this.f1075a.mo657d());
            c0888r.m2010a(4, "      method_idx:      " + C0985a.m2294t(iM1069b));
            c0888r.m2010a(4, "      annotations_off: " + C0985a.m2294t(iF));
        }
        c0888r.m2020c(iM1069b);
        c0888r.m2020c(iF);
    }

    /* JADX INFO: renamed from: b */
    public final C0742c m1065b() {
        return this.f1076b.m1133c();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.f1075a.compareTo(((C0611ai) obj).f1075a);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1075a.mo657d() + ": " + this.f1076b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0611ai) {
            return this.f1075a.equals(((C0611ai) obj).f1075a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1075a.hashCode();
    }
}
