package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.t */
/* JADX INFO: loaded from: classes.dex */
public final class C0652t extends AbstractC0653u implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0788l f1206a;

    public C0652t(C0788l c0788l, int i) {
        super(i);
        this.f1206a = c0788l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0652t c0652t) {
        return this.f1206a.compareTo(c0652t.f1206a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0653u
    /* JADX INFO: renamed from: a */
    public final int mo1238a(C0650r c0650r, C0888r c0888r, int i, int i2) {
        int iM1252b = c0650r.m1231m().m1252b(this.f1206a);
        int i3 = iM1252b - i;
        int iB = m1241b();
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, String.format("  [%x] %s", Integer.valueOf(i2), this.f1206a.mo657d()));
            c0888r.m2010a(C0985a.m2261d(i3), "    field_idx:    " + C0985a.m2294t(iM1252b));
            c0888r.m2010a(C0985a.m2261d(iB), "    access_flags: " + C0985a.m2278i(iB));
        }
        c0888r.m2024e(i3);
        c0888r.m2024e(iB);
        return iM1252b;
    }

    /* JADX INFO: renamed from: a */
    public final C0788l m1239a() {
        return this.f1206a;
    }

    /* JADX INFO: renamed from: a */
    public final void m1240a(C0650r c0650r) {
        c0650r.m1231m().m1250a(this.f1206a);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1206a.mo657d();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0652t) && compareTo((C0652t) obj) == 0;
    }

    public final int hashCode() {
        return this.f1206a.hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(C0985a.m2296v(m1241b()));
        stringBuffer.append(' ');
        stringBuffer.append(this.f1206a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
