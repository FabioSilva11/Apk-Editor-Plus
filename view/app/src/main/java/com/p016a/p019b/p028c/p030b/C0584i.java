package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;

/* JADX INFO: renamed from: com.a.b.c.b.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0584i extends AbstractC0591p {

    /* JADX INFO: renamed from: a */
    private final AbstractC0775a f777a;

    /* JADX INFO: renamed from: b */
    private int f778b;

    /* JADX INFO: renamed from: c */
    private int f779c;

    public C0584i(C0589n c0589n, C0774z c0774z, C0768t c0768t, AbstractC0775a abstractC0775a) {
        super(c0589n, c0774z, c0768t);
        if (abstractC0775a == null) {
            throw new NullPointerException("constant == null");
        }
        this.f777a = abstractC0775a;
        this.f778b = -1;
        this.f779c = -1;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo900a(C0589n c0589n) {
        C0584i c0584i = new C0584i(c0589n, m962i(), m963j(), this.f777a);
        if (this.f778b >= 0) {
            c0584i.m935a(this.f778b);
        }
        if (this.f779c >= 0) {
            c0584i.m936b(this.f779c);
        }
        return c0584i;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        C0584i c0584i = new C0584i(m961h(), m962i(), c0768t, this.f777a);
        if (this.f778b >= 0) {
            c0584i.m935a(this.f778b);
        }
        if (this.f779c >= 0) {
            c0584i.m936b(this.f779c);
        }
        return c0584i;
    }

    /* JADX INFO: renamed from: a */
    public final void m935a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (this.f778b >= 0) {
            throw new RuntimeException("index already set");
        }
        this.f778b = i;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        return this.f777a.mo657d();
    }

    /* JADX INFO: renamed from: b */
    public final void m936b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (this.f779c >= 0) {
            throw new RuntimeException("class index already set");
        }
        this.f779c = i;
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC0775a m937c() {
        return this.f777a;
    }

    /* JADX INFO: renamed from: d */
    public final int m938d() {
        if (this.f778b < 0) {
            throw new RuntimeException("index not yet set for " + this.f777a);
        }
        return this.f778b;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m939e() {
        return this.f778b >= 0;
    }
}
