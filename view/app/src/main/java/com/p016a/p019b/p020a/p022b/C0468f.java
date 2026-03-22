package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p036f.p039c.C0802z;

/* JADX INFO: renamed from: com.a.b.a.b.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0468f {

    /* JADX INFO: renamed from: a */
    private final int f546a;

    /* JADX INFO: renamed from: b */
    private final int f547b;

    /* JADX INFO: renamed from: c */
    private final int f548c;

    /* JADX INFO: renamed from: d */
    private final C0802z f549d;

    public C0468f(int i, int i2, int i3, C0802z c0802z) {
        if (i < 0) {
            throw new IllegalArgumentException("startPc < 0");
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endPc < startPc");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("handlerPc < 0");
        }
        this.f546a = i;
        this.f547b = i2;
        this.f548c = i3;
        this.f549d = c0802z;
    }

    /* JADX INFO: renamed from: a */
    public final int m570a() {
        return this.f546a;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m571a(int i) {
        return i >= this.f546a && i < this.f547b;
    }

    /* JADX INFO: renamed from: b */
    public final int m572b() {
        return this.f547b;
    }

    /* JADX INFO: renamed from: c */
    public final int m573c() {
        return this.f548c;
    }

    /* JADX INFO: renamed from: d */
    public final C0802z m574d() {
        return this.f549d != null ? this.f549d : C0802z.f1938a;
    }
}
