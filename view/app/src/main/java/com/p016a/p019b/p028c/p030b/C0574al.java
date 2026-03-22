package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;

/* JADX INFO: renamed from: com.a.b.c.b.al */
/* JADX INFO: loaded from: classes.dex */
public final class C0574al extends AbstractC0591p {

    /* JADX INFO: renamed from: a */
    private C0583h f765a;

    public C0574al(C0589n c0589n, C0774z c0774z, C0768t c0768t, C0583h c0583h) {
        super(c0589n, c0774z, c0768t);
        if (c0583h == null) {
            throw new NullPointerException("target == null");
        }
        this.f765a = c0583h;
    }

    /* JADX INFO: renamed from: a */
    public final C0574al m909a(C0583h c0583h) {
        return new C0574al(m961h().m980g(), m962i(), m963j(), c0583h);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo900a(C0589n c0589n) {
        return new C0574al(c0589n, m962i(), m963j(), this.f765a);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        return new C0574al(m961h(), m962i(), c0768t, this.f765a);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        return this.f765a == null ? "????" : this.f765a.m965l();
    }

    /* JADX INFO: renamed from: c */
    public final C0583h m910c() {
        return this.f765a;
    }

    /* JADX INFO: renamed from: d */
    public final int m911d() {
        return this.f765a.m960g();
    }

    /* JADX INFO: renamed from: e */
    public final int m912e() {
        return this.f765a.m960g() - m960g();
    }

    /* JADX INFO: renamed from: n */
    public final boolean m913n() {
        return m959f() && this.f765a.m959f();
    }
}
