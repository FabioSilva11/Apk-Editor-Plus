package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0770v;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p041g.AbstractC0831ag;

/* JADX INFO: renamed from: com.a.b.c.b.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0598w extends AbstractC0576an {

    /* JADX INFO: renamed from: a */
    private final C0770v f1034a;

    public C0598w(C0774z c0774z, C0770v c0770v) {
        super(c0774z);
        if (c0770v == null) {
            throw new NullPointerException("locals == null");
        }
        this.f1034a = c0770v;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        return new C0598w(m962i(), this.f1034a);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo953a(AbstractC0831ag abstractC0831ag) {
        return new C0598w(m962i(), abstractC0831ag.m1775a(this.f1034a));
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    protected final String mo842a(boolean z) {
        int iM1571d = this.f1034a.m1571d();
        int iM1567b = this.f1034a.m1567b();
        StringBuffer stringBuffer = new StringBuffer((iM1571d * 40) + 100);
        stringBuffer.append("local-snapshot");
        for (int i = 0; i < iM1567b; i++) {
            C0766r c0766rM1562a = this.f1034a.m1562a(i);
            if (c0766rM1562a != null) {
                stringBuffer.append("\n  ");
                stringBuffer.append(C0599x.m1030a(c0766rM1562a));
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        return this.f1034a.toString();
    }

    /* JADX INFO: renamed from: c */
    public final C0770v m1029c() {
        return this.f1034a;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0576an, com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: d */
    public final AbstractC0587l mo914d(int i) {
        return new C0598w(m962i(), this.f1034a.m1569b(i));
    }
}
