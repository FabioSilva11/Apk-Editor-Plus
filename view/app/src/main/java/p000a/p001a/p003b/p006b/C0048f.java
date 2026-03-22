package p000a.p001a.p003b.p006b;

/* JADX INFO: renamed from: a.a.b.b.f */
/* JADX INFO: loaded from: classes.dex */
final class C0048f {

    /* JADX INFO: renamed from: a */
    private int[] f149a = new int[32];

    /* JADX INFO: renamed from: b */
    private int f150b;

    /* JADX INFO: renamed from: c */
    private int f151c;

    /* JADX INFO: renamed from: d */
    private int f152d;

    /* JADX INFO: renamed from: a */
    private final int m121a(int i, boolean z) {
        if (this.f150b == 0 || i < 0) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = this.f152d; i3 != 0; i3--) {
            int i4 = this.f149a[i2];
            if (i < i4) {
                int i5 = (i << 1) + 1 + i2;
                if (!z) {
                    i5++;
                }
                return this.f149a[i5];
            }
            i -= i4;
            i2 += (i4 << 1) + 2;
        }
        return -1;
    }

    /* JADX INFO: renamed from: e */
    private void m122e(int i) {
        int length = this.f149a.length - this.f150b;
        if (length > 2) {
            return;
        }
        int[] iArr = new int[(length + this.f149a.length) << 1];
        System.arraycopy(this.f149a, 0, iArr, 0, this.f150b);
        this.f149a = iArr;
    }

    /* JADX INFO: renamed from: a */
    public final int m123a(int i) {
        int i2 = 0;
        if (this.f150b != 0 && i >= 0) {
            if (i > this.f152d) {
                i = this.f152d;
            }
            int i3 = 0;
            while (i != 0) {
                int i4 = this.f149a[i3];
                i--;
                i3 = (i4 << 1) + 2 + i3;
                i2 += i4;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m124a() {
        this.f150b = 0;
        this.f151c = 0;
        this.f152d = 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m125a(int i, int i2) {
        if (this.f152d == 0) {
            m132e();
        }
        m122e(2);
        int i3 = this.f150b - 1;
        int i4 = this.f149a[i3];
        this.f149a[(i3 - 1) - (i4 << 1)] = i4 + 1;
        this.f149a[i3] = i;
        this.f149a[i3 + 1] = i2;
        this.f149a[i3 + 2] = i4 + 1;
        this.f150b += 2;
        this.f151c++;
    }

    /* JADX INFO: renamed from: b */
    public final int m126b() {
        if (this.f150b == 0) {
            return 0;
        }
        return this.f149a[this.f150b - 1];
    }

    /* JADX INFO: renamed from: b */
    public final int m127b(int i) {
        return m121a(i, true);
    }

    /* JADX INFO: renamed from: c */
    public final int m128c(int i) {
        return m121a(i, false);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m129c() {
        int i;
        int i2;
        if (this.f150b == 0 || (i2 = this.f149a[this.f150b - 1]) == 0) {
            return false;
        }
        int i3 = i2 - 1;
        int i4 = i - 2;
        this.f149a[i4] = i3;
        this.f149a[i4 - ((i3 << 1) + 1)] = i3;
        this.f150b -= 2;
        this.f151c--;
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final int m130d() {
        return this.f152d;
    }

    /* JADX INFO: renamed from: d */
    public final int m131d(int i) {
        if (this.f150b != 0) {
            int i2 = this.f150b - 1;
            for (int i3 = this.f152d; i3 != 0; i3--) {
                i2 -= 2;
                for (int i4 = this.f149a[i2]; i4 != 0; i4--) {
                    if (this.f149a[i2 + 1] == i) {
                        return this.f149a[i2];
                    }
                    i2 -= 2;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: e */
    public final void m132e() {
        m122e(2);
        int i = this.f150b;
        this.f149a[i] = 0;
        this.f149a[i + 1] = 0;
        this.f150b += 2;
        this.f152d++;
    }

    /* JADX INFO: renamed from: f */
    public final void m133f() {
        if (this.f150b == 0) {
            return;
        }
        int i = this.f150b - 1;
        int i2 = this.f149a[i];
        if ((i - 1) - (i2 << 1) != 0) {
            this.f150b -= (i2 << 1) + 2;
            this.f151c -= i2;
            this.f152d--;
        }
    }
}
