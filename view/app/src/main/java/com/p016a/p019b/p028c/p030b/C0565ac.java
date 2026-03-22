package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0774z;

/* JADX INFO: renamed from: com.a.b.c.b.ac */
/* JADX INFO: loaded from: classes.dex */
public final class C0565ac {

    /* JADX INFO: renamed from: a */
    private final int f737a;

    /* JADX INFO: renamed from: b */
    private final C0774z f738b;

    public C0565ac(int i, C0774z c0774z) {
        if (i < 0) {
            throw new IllegalArgumentException("address < 0");
        }
        if (c0774z == null) {
            throw new NullPointerException("position == null");
        }
        this.f737a = i;
        this.f738b = c0774z;
    }

    /* JADX INFO: renamed from: a */
    public final int m876a() {
        return this.f737a;
    }

    /* JADX INFO: renamed from: b */
    public final C0774z m877b() {
        return this.f738b;
    }
}
