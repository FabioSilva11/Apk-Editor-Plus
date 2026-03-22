package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p028c.p030b.C0585j;
import com.p016a.p019b.p036f.p039c.AbstractC0782f;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0888r;
import java.io.PrintWriter;

/* JADX INFO: renamed from: com.a.b.c.c.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0654v extends AbstractC0653u implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0798v f1208a;

    /* JADX INFO: renamed from: b */
    private final C0644l f1209b;

    public C0654v(C0798v c0798v, int i, C0585j c0585j, InterfaceC0807e interfaceC0807e) {
        super(i);
        this.f1208a = c0798v;
        if (c0585j == null) {
            this.f1209b = null;
        } else {
            this.f1209b = new C0644l(c0798v, c0585j, (i & 8) != 0, interfaceC0807e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0654v c0654v) {
        return this.f1208a.compareTo(c0654v.f1208a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0653u
    /* JADX INFO: renamed from: a */
    public final int mo1238a(C0650r c0650r, C0888r c0888r, int i, int i2) {
        int iM1069b = c0650r.m1232n().m1069b(this.f1208a);
        int i3 = iM1069b - i;
        int iB = m1241b();
        int iM1079b = AbstractC0618ap.m1079b(this.f1209b);
        if ((iM1079b != 0) != ((iB & 1280) == 0)) {
            throw new UnsupportedOperationException("code vs. access_flags mismatch");
        }
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, String.format("  [%x] %s", Integer.valueOf(i2), this.f1208a.mo657d()));
            c0888r.m2010a(C0985a.m2261d(i3), "    method_idx:   " + C0985a.m2294t(iM1069b));
            c0888r.m2010a(C0985a.m2261d(iB), "    access_flags: " + C0985a.m2281j(iB));
            c0888r.m2010a(C0985a.m2261d(iM1079b), "    code_off:     " + C0985a.m2294t(iM1079b));
        }
        c0888r.m2024e(i3);
        c0888r.m2024e(iB);
        c0888r.m2024e(iM1079b);
        return iM1069b;
    }

    /* JADX INFO: renamed from: a */
    public final C0801y m1243a() {
        return this.f1208a.m1637l().m1638a();
    }

    /* JADX INFO: renamed from: a */
    public final void m1244a(C0650r c0650r) {
        C0613ak c0613akM1232n = c0650r.m1232n();
        C0614al c0614alM1223e = c0650r.m1223e();
        c0613akM1232n.m1067a((AbstractC0782f) this.f1208a);
        if (this.f1209b != null) {
            c0614alM1223e.m1071a((AbstractC0618ap) this.f1209b);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1245a(PrintWriter printWriter, boolean z) {
        if (this.f1209b == null) {
            printWriter.println(this.f1208a.mo657d() + ": abstract or native");
        } else {
            this.f1209b.m1191a(printWriter, "  ", z);
        }
    }

    /* JADX INFO: renamed from: c */
    public final C0798v m1246c() {
        return this.f1208a;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1208a.mo657d();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0654v) && compareTo((C0654v) obj) == 0;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(C0985a.m2296v(m1241b()));
        stringBuffer.append(' ');
        stringBuffer.append(this.f1208a);
        if (this.f1209b != null) {
            stringBuffer.append(' ');
            stringBuffer.append(this.f1209b);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
