package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p041g.AbstractC0831ag;

/* JADX INFO: renamed from: com.a.b.c.b.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0599x extends AbstractC0576an {

    /* JADX INFO: renamed from: a */
    private final C0766r f1035a;

    public C0599x(C0774z c0774z, C0766r c0766r) {
        super(c0774z);
        if (c0766r == null) {
            throw new NullPointerException("local == null");
        }
        this.f1035a = c0766r;
    }

    /* JADX INFO: renamed from: a */
    public static String m1030a(C0766r c0766r) {
        return c0766r.m1539m() + ' ' + c0766r.m1535i().toString() + ": " + c0766r.m1534h().mo657d();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        return new C0599x(m962i(), this.f1035a);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo953a(AbstractC0831ag abstractC0831ag) {
        return new C0599x(m962i(), abstractC0831ag.mo1700a(this.f1035a));
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    protected final String mo842a(boolean z) {
        return "local-start " + m1030a(this.f1035a);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        return this.f1035a.toString();
    }

    /* JADX INFO: renamed from: c */
    public final C0766r m1031c() {
        return this.f1035a;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0576an, com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: d */
    public final AbstractC0587l mo914d(int i) {
        return new C0599x(m962i(), this.f1035a.m1530b(i));
    }
}
