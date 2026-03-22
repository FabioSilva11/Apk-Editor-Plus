package com.p016a.p019b.p035e;

import java.util.Comparator;

/* JADX INFO: renamed from: com.a.b.e.v */
/* JADX INFO: loaded from: classes.dex */
final class C0739v implements Comparator {
    C0739v() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        C0738u c0738u = (C0738u) obj;
        C0738u c0738u2 = (C0738u) obj2;
        if (c0738u == c0738u2) {
            return 0;
        }
        if (c0738u2 == null) {
            return -1;
        }
        if (c0738u == null) {
            return 1;
        }
        return c0738u.f1604d != c0738u2.f1604d ? c0738u.f1604d - c0738u2.f1604d : c0738u.m1435c() - c0738u2.m1435c();
    }
}
