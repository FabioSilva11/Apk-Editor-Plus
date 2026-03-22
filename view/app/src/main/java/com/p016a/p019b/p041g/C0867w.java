package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0766r;
import java.util.HashSet;

/* JADX INFO: renamed from: com.a.b.g.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0867w {

    /* JADX INFO: renamed from: a */
    private final C0838an f2218a;

    private C0867w(C0838an c0838an) {
        this.f2218a = c0838an;
    }

    /* JADX INFO: renamed from: a */
    public static void m1938a(C0838an c0838an) {
        C0867w c0867w = new C0867w(c0838an);
        C0766r[] c0766rArr = new C0766r[c0867w.f2218a.m1862h()];
        HashSet hashSet = new HashSet();
        c0867w.f2218a.m1847a(new C0868x(c0867w, c0766rArr, hashSet));
        c0867w.f2218a.m1848a(hashSet);
    }
}
