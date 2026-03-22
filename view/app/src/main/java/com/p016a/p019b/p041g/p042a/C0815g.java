package com.p016a.p019b.p041g.p042a;

/* JADX INFO: renamed from: com.a.b.g.a.g */
/* JADX INFO: loaded from: classes.dex */
final class C0815g {

    /* JADX INFO: renamed from: a */
    private final int[] f2058a;

    /* JADX INFO: renamed from: b */
    private final int[] f2059b;

    /* JADX INFO: renamed from: c */
    private int f2060c = 0;

    public C0815g(int i) {
        this.f2058a = new int[i];
        this.f2059b = new int[i];
    }

    /* JADX INFO: renamed from: a */
    public final int m1732a() {
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < this.f2060c; i4++) {
            if (i < this.f2059b[i4]) {
                i2 = this.f2058a[i4];
                i = this.f2059b[i4];
                i3 = i4;
            }
        }
        this.f2059b[i3] = 0;
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m1733a(int i) {
        for (int i2 = 0; i2 < this.f2060c; i2++) {
            if (this.f2058a[i2] == i) {
                int[] iArr = this.f2059b;
                iArr[i2] = iArr[i2] + 1;
                return;
            }
        }
        this.f2058a[this.f2060c] = i;
        this.f2059b[this.f2060c] = 1;
        this.f2060c++;
    }

    /* JADX INFO: renamed from: b */
    public final int m1734b() {
        return this.f2060c;
    }
}
