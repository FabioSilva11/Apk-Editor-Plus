package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p037a.C0743d;
import com.p016a.p019b.p036f.p039c.AbstractC0782f;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p043h.C0888r;
import com.p016a.p019b.p043h.InterfaceC0889s;
import jadx.core.codegen.CodeWriter;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.c.c.aq */
/* JADX INFO: loaded from: classes.dex */
public final class C0619aq implements InterfaceC0889s, Comparable {

    /* JADX INFO: renamed from: a */
    private final C0798v f1092a;

    /* JADX INFO: renamed from: b */
    private final C0743d f1093b;

    /* JADX INFO: renamed from: c */
    private final C0633bd f1094c;

    public C0619aq(C0798v c0798v, C0743d c0743d, C0650r c0650r) {
        if (c0798v == null) {
            throw new NullPointerException("method == null");
        }
        if (c0743d == null) {
            throw new NullPointerException("annotationsList == null");
        }
        this.f1092a = c0798v;
        this.f1093b = c0743d;
        int iD_ = c0743d.m1977d_();
        ArrayList arrayList = new ArrayList(iD_);
        for (int i = 0; i < iD_; i++) {
            arrayList.add(new C0637e(new C0636d(c0743d.m1452a(i), c0650r)));
        }
        this.f1094c = new C0633bd(EnumC0607ae.f1054j, arrayList);
    }

    /* JADX INFO: renamed from: a */
    public final C0798v m1086a() {
        return this.f1092a;
    }

    /* JADX INFO: renamed from: a */
    public final void m1087a(C0650r c0650r) {
        C0613ak c0613akM1232n = c0650r.m1232n();
        C0614al c0614alM1223e = c0650r.m1223e();
        c0613akM1232n.m1067a((AbstractC0782f) this.f1092a);
        c0614alM1223e.m1071a((AbstractC0618ap) this.f1094c);
    }

    /* JADX INFO: renamed from: a */
    public final void m1088a(C0650r c0650r, C0888r c0888r) {
        int iM1069b = c0650r.m1232n().m1069b(this.f1092a);
        int iF = this.f1094c.m1083f();
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, CodeWriter.INDENT + this.f1092a.mo657d());
            c0888r.m2010a(4, "      method_idx:      " + C0985a.m2294t(iM1069b));
            c0888r.m2010a(4, "      annotations_off: " + C0985a.m2294t(iF));
        }
        c0888r.m2020c(iM1069b);
        c0888r.m2020c(iF);
    }

    /* JADX INFO: renamed from: b */
    public final C0743d m1089b() {
        return this.f1093b;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.f1092a.compareTo(((C0619aq) obj).f1092a);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1092a.mo657d());
        sb.append(": ");
        boolean z = true;
        for (C0637e c0637e : this.f1094c.m1124c()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(c0637e.mo1045b());
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0619aq) {
            return this.f1092a.equals(((C0619aq) obj).f1092a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1092a.hashCode();
    }
}
