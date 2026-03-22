package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p039c.C0802z;

/* JADX INFO: renamed from: com.a.b.c.b.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0580e implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0802z f770a;

    /* JADX INFO: renamed from: b */
    private final int f771b;

    public C0580e(C0802z c0802z, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("handler < 0");
        }
        if (c0802z == null) {
            throw new NullPointerException("exceptionType == null");
        }
        this.f771b = i;
        this.f770a = c0802z;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0580e c0580e) {
        if (this.f771b < c0580e.f771b) {
            return -1;
        }
        if (this.f771b > c0580e.f771b) {
            return 1;
        }
        return this.f770a.compareTo(c0580e.f770a);
    }

    /* JADX INFO: renamed from: a */
    public final C0802z m926a() {
        return this.f770a;
    }

    /* JADX INFO: renamed from: b */
    public final int m927b() {
        return this.f771b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0580e) && compareTo((C0580e) obj) == 0;
    }

    public final int hashCode() {
        return (this.f771b * 31) + this.f770a.hashCode();
    }
}
