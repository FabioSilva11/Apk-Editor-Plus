package com.p016a.p019b.p028c.p030b;

/* JADX INFO: renamed from: com.a.b.c.b.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0582g implements Comparable {

    /* JADX INFO: renamed from: a */
    private final int f773a;

    /* JADX INFO: renamed from: b */
    private final int f774b;

    /* JADX INFO: renamed from: c */
    private final C0579d f775c;

    public C0582g(int i, int i2, C0579d c0579d) {
        if (i < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (i2 <= i) {
            throw new IllegalArgumentException("end <= start");
        }
        if (c0579d.m2002c_()) {
            throw new IllegalArgumentException("handlers.isMutable()");
        }
        this.f773a = i;
        this.f774b = i2;
        this.f775c = c0579d;
    }

    /* JADX INFO: renamed from: a */
    public final int m930a() {
        return this.f773a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0582g c0582g) {
        if (this.f773a < c0582g.f773a) {
            return -1;
        }
        if (this.f773a > c0582g.f773a) {
            return 1;
        }
        if (this.f774b < c0582g.f774b) {
            return -1;
        }
        if (this.f774b > c0582g.f774b) {
            return 1;
        }
        return this.f775c.compareTo(c0582g.f775c);
    }

    /* JADX INFO: renamed from: b */
    public final int m932b() {
        return this.f774b;
    }

    /* JADX INFO: renamed from: c */
    public final C0579d m933c() {
        return this.f775c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0582g) && compareTo((C0582g) obj) == 0;
    }

    public final int hashCode() {
        return (((this.f773a * 31) + this.f774b) * 31) + this.f775c.hashCode();
    }
}
