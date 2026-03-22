package com.p016a.p019b.p028c.p032c;

import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p028c.p030b.C0564ab;
import com.p016a.p019b.p028c.p030b.C0585j;
import com.p016a.p019b.p028c.p030b.C0588m;
import com.p016a.p019b.p028c.p030b.C0594s;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p043h.C0888r;
import java.io.PrintWriter;

/* JADX INFO: renamed from: com.a.b.c.c.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0649q extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final C0585j f1183a;

    /* JADX INFO: renamed from: b */
    private byte[] f1184b;

    /* JADX INFO: renamed from: c */
    private final boolean f1185c;

    /* JADX INFO: renamed from: d */
    private final C0798v f1186d;

    public C0649q(C0585j c0585j, boolean z, C0798v c0798v) {
        super(1, -1);
        if (c0585j == null) {
            throw new NullPointerException("code == null");
        }
        this.f1183a = c0585j;
        this.f1185c = z;
        this.f1186d = c0798v;
    }

    /* JADX INFO: renamed from: a */
    private byte[] m1209a(C0650r c0650r, String str, PrintWriter printWriter, C0888r c0888r, boolean z) {
        C0564ab c0564abM949h = this.f1183a.m949h();
        C0594s c0594sM950i = this.f1183a.m950i();
        C0588m c0588mM947f = this.f1183a.m947f();
        C0646n c0646n = new C0646n(c0564abM949h, c0594sM950i, c0650r, c0588mM947f.m971e(), c0588mM947f.m972f(), this.f1185c, this.f1186d);
        return (printWriter == null && c0888r == null) ? c0646n.m1207a() : c0646n.m1208a(str, printWriter, c0888r, z);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1059o;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final void mo1041a(AbstractC0622at abstractC0622at, int i) {
        try {
            this.f1184b = m1209a(abstractC0622at.m1099e(), null, null, null, false);
            m1080a(this.f1184b.length);
        } catch (RuntimeException e) {
            throw C0400d.m308a(e, "...while placing debug info for " + this.f1186d.mo657d());
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
    }

    /* JADX INFO: renamed from: a */
    public final void m1210a(C0650r c0650r, C0888r c0888r, String str) {
        m1209a(c0650r, str, null, c0888r, false);
    }

    /* JADX INFO: renamed from: a */
    public final void m1211a(PrintWriter printWriter, String str) {
        m1209a(null, str, printWriter, null, false);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        if (c0888r.m2019b()) {
            c0888r.m2015a(m1085h() + " debug info");
            m1209a(c0650r, null, null, c0888r, true);
        }
        c0888r.m2016a(this.f1184b);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        throw new RuntimeException("unsupported");
    }
}
