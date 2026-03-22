package com.p016a.p019b.p028c.p032c;

import java.util.Comparator;

/* JADX INFO: renamed from: com.a.b.c.c.c */
/* JADX INFO: loaded from: classes.dex */
final class C0635c implements Comparator {
    private C0635c() {
    }

    /* synthetic */ C0635c(byte b2) {
        this();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        int i = ((C0602a) obj).f1040c.m1051i();
        int i2 = ((C0602a) obj2).f1040c.m1051i();
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
