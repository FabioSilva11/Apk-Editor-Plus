package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0880j;
import com.p016a.p019b.p043h.InterfaceC0882l;

/* JADX INFO: renamed from: com.a.b.a.b.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0465c implements InterfaceC0882l {

    /* JADX INFO: renamed from: a */
    private final int f540a;

    /* JADX INFO: renamed from: b */
    private final int f541b;

    /* JADX INFO: renamed from: c */
    private final int f542c;

    /* JADX INFO: renamed from: d */
    private final C0880j f543d;

    /* JADX INFO: renamed from: e */
    private final C0467e f544e;

    public C0465c(int i, int i2, int i3, C0880j c0880j, C0467e c0467e) {
        if (i < 0) {
            throw new IllegalArgumentException("label < 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (i3 <= i2) {
            throw new IllegalArgumentException("end <= start");
        }
        if (c0880j == null) {
            throw new NullPointerException("targets == null");
        }
        int iM1985b = c0880j.m1985b();
        for (int i4 = 0; i4 < iM1985b; i4++) {
            if (c0880j.m1986b(i4) < 0) {
                throw new IllegalArgumentException("successors[" + i4 + "] == " + c0880j.m1986b(i4));
            }
        }
        if (c0467e == null) {
            throw new NullPointerException("catches == null");
        }
        this.f540a = i;
        this.f541b = i2;
        this.f542c = i3;
        this.f543d = c0880j;
        this.f544e = c0467e;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0882l
    /* JADX INFO: renamed from: a */
    public final int mo559a() {
        return this.f540a;
    }

    /* JADX INFO: renamed from: b */
    public final int m560b() {
        return this.f541b;
    }

    /* JADX INFO: renamed from: c */
    public final int m561c() {
        return this.f542c;
    }

    /* JADX INFO: renamed from: d */
    public final C0880j m562d() {
        return this.f543d;
    }

    /* JADX INFO: renamed from: e */
    public final C0467e m563e() {
        return this.f544e;
    }

    public final String toString() {
        return "{" + C0985a.m2296v(this.f540a) + ": " + C0985a.m2296v(this.f541b) + ".." + C0985a.m2296v(this.f542c) + '}';
    }
}
