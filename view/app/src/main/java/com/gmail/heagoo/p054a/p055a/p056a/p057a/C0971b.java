package com.gmail.heagoo.p054a.p055a.p056a.p057a;

/* JADX INFO: renamed from: com.gmail.heagoo.a.a.a.a.b */
/* JADX INFO: loaded from: classes.dex */
class C0971b {

    /* JADX INFO: renamed from: a */
    private int[] f2448a = new int[32];

    /* JADX INFO: renamed from: b */
    private int f2449b;

    /* JADX INFO: renamed from: c */
    private int f2450c;

    /* JADX INFO: renamed from: d */
    private int f2451d;

    /* JADX INFO: renamed from: a */
    private final int m2128a(int i, boolean z) {
        if (this.f2449b == 0 || i < 0) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = this.f2451d; i3 != 0; i3--) {
            int i4 = this.f2448a[i2];
            if (i < i4) {
                int i5 = (i << 1) + 1 + i2;
                if (!z) {
                    i5++;
                }
                return this.f2448a[i5];
            }
            i -= i4;
            i2 += (i4 << 1) + 2;
        }
        return -1;
    }

    /* JADX INFO: renamed from: e */
    private void m2129e(int i) {
        int length = this.f2448a.length - this.f2449b;
        if (length > 2) {
            return;
        }
        int[] iArr = new int[(length + this.f2448a.length) << 1];
        System.arraycopy(this.f2448a, 0, iArr, 0, this.f2449b);
        this.f2448a = iArr;
    }

    /* JADX INFO: renamed from: a */
    public final int m2130a(int i) {
        int i2 = 0;
        if (this.f2449b != 0 && i >= 0) {
            if (i > this.f2451d) {
                i = this.f2451d;
            }
            int i3 = 0;
            while (i != 0) {
                int i4 = this.f2448a[i3];
                i--;
                i3 = (i4 << 1) + 2 + i3;
                i2 += i4;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m2131a() {
        this.f2449b = 0;
        this.f2450c = 0;
        this.f2451d = 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m2132a(int i, int i2) {
        if (this.f2451d == 0) {
            m2139e();
        }
        m2129e(2);
        int i3 = this.f2449b - 1;
        int i4 = this.f2448a[i3];
        this.f2448a[(i3 - 1) - (i4 << 1)] = i4 + 1;
        this.f2448a[i3] = i;
        this.f2448a[i3 + 1] = i2;
        this.f2448a[i3 + 2] = i4 + 1;
        this.f2449b += 2;
        this.f2450c++;
    }

    /* JADX INFO: renamed from: b */
    public final int m2133b() {
        if (this.f2449b == 0) {
            return 0;
        }
        return this.f2448a[this.f2449b - 1];
    }

    /* JADX INFO: renamed from: b */
    public final int m2134b(int i) {
        return m2128a(i, true);
    }

    /* JADX INFO: renamed from: c */
    public final int m2135c(int i) {
        return m2128a(i, false);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m2136c() {
        int i;
        int i2;
        if (this.f2449b == 0 || (i2 = this.f2448a[this.f2449b - 1]) == 0) {
            return false;
        }
        int i3 = i2 - 1;
        int i4 = i - 2;
        this.f2448a[i4] = i3;
        this.f2448a[i4 - ((i3 << 1) + 1)] = i3;
        this.f2449b -= 2;
        this.f2450c--;
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final int m2137d() {
        return this.f2451d;
    }

    /* JADX INFO: renamed from: d */
    public final int m2138d(int i) {
        if (this.f2449b != 0) {
            int i2 = this.f2449b - 1;
            for (int i3 = this.f2451d; i3 != 0; i3--) {
                i2 -= 2;
                for (int i4 = this.f2448a[i2]; i4 != 0; i4--) {
                    if (this.f2448a[i2 + 1] == i) {
                        return this.f2448a[i2];
                    }
                    i2 -= 2;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: e */
    public final void m2139e() {
        m2129e(2);
        int i = this.f2449b;
        this.f2448a[i] = 0;
        this.f2448a[i + 1] = 0;
        this.f2449b += 2;
        this.f2451d++;
    }

    /* JADX INFO: renamed from: f */
    public final void m2140f() {
        if (this.f2449b == 0) {
            return;
        }
        int i = this.f2449b - 1;
        int i2 = this.f2448a[i];
        if ((i - 1) - (i2 << 1) != 0) {
            this.f2449b -= (i2 << 1) + 2;
            this.f2450c -= i2;
            this.f2451d--;
        }
    }
}
