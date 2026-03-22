package com.p016a.p019b.p028c.p032c;

import com.p016a.p019b.p036f.p037a.C0740a;
import com.p016a.p019b.p036f.p037a.C0744e;
import com.p016a.p019b.p036f.p037a.EnumC0741b;
import com.p016a.p019b.p043h.C0888r;
import java.util.Arrays;

/* JADX INFO: renamed from: com.a.b.c.c.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0602a extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private static final C0635c f1038a = new C0635c(0);

    /* JADX INFO: renamed from: b */
    private final C0740a f1039b;

    /* JADX INFO: renamed from: c */
    private C0628az f1040c;

    /* JADX INFO: renamed from: d */
    private byte[] f1041d;

    public C0602a(C0740a c0740a, C0650r c0650r) {
        super(1, -1);
        if (c0740a == null) {
            throw new NullPointerException("annotation == null");
        }
        this.f1039b = c0740a;
        this.f1040c = null;
        this.f1041d = null;
        mo1042a(c0650r);
    }

    /* JADX INFO: renamed from: a */
    public static void m1038a(C0602a[] c0602aArr) {
        Arrays.sort(c0602aArr, f1038a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final int mo1039a(AbstractC0618ap abstractC0618ap) {
        return this.f1039b.compareTo(((C0602a) abstractC0618ap).f1039b);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1060p;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final void mo1041a(AbstractC0622at abstractC0622at, int i) {
        C0888r c0888r = new C0888r();
        new C0634be(abstractC0622at.m1099e(), c0888r).m1130a(this.f1039b, false);
        this.f1041d = c0888r.m2028g();
        m1080a(this.f1041d.length + 1);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        this.f1040c = c0650r.m1229k().m1117a(this.f1039b.m1439b());
        C0634be.m1126a(c0650r, this.f1039b);
    }

    /* JADX INFO: renamed from: a */
    public final void m1043a(C0888r c0888r, String str) {
        c0888r.m2010a(0, str + "visibility: " + this.f1039b.m1441e().mo657d());
        c0888r.m2010a(0, str + "type: " + this.f1039b.m1439b().mo657d());
        for (C0744e c0744e : this.f1039b.m1442f()) {
            c0888r.m2010a(0, str + c0744e.m1455a().mo657d() + ": " + C0634be.m1125a(c0744e.m1456b()));
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        boolean zM2019b = c0888r.m2019b();
        EnumC0741b enumC0741bM1441e = this.f1039b.m1441e();
        if (zM2019b) {
            c0888r.m2010a(0, m1085h() + " annotation");
            c0888r.m2010a(1, "  visibility: VISBILITY_" + enumC0741bM1441e);
        }
        switch (C0629b.f1114a[enumC0741bM1441e.ordinal()]) {
            case 1:
                c0888r.mo307d(0);
                break;
            case 2:
                c0888r.mo307d(1);
                break;
            case 3:
                c0888r.mo307d(2);
                break;
            default:
                throw new RuntimeException("shouldn't happen");
        }
        if (zM2019b) {
            new C0634be(c0650r, c0888r).m1130a(this.f1039b, true);
        } else {
            c0888r.m2016a(this.f1041d);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        return this.f1039b.mo657d();
    }

    public final int hashCode() {
        return this.f1039b.hashCode();
    }
}
