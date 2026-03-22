package com.p016a.p019b.p043h;

import java.util.Arrays;

/* JADX INFO: renamed from: com.a.b.h.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0880j extends C0886p {

    /* JADX INFO: renamed from: a */
    public static final C0880j f2245a;

    /* JADX INFO: renamed from: b */
    private int[] f2246b;

    /* JADX INFO: renamed from: c */
    private int f2247c;

    /* JADX INFO: renamed from: d */
    private boolean f2248d;

    static {
        C0880j c0880j = new C0880j(0);
        f2245a = c0880j;
        c0880j.mo549b_();
    }

    public C0880j() {
        this(4);
    }

    public C0880j(int i) {
        super(true);
        try {
            this.f2246b = new int[i];
            this.f2247c = 0;
            this.f2248d = true;
        } catch (NegativeArraySizeException e) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0880j m1982a(int i) {
        C0880j c0880j = new C0880j(1);
        c0880j.m1988c(i);
        c0880j.mo549b_();
        return c0880j;
    }

    /* JADX INFO: renamed from: a */
    public static C0880j m1983a(int i, int i2) {
        C0880j c0880j = new C0880j(2);
        c0880j.m1988c(i);
        c0880j.m1988c(i2);
        c0880j.mo549b_();
        return c0880j;
    }

    /* JADX INFO: renamed from: h */
    private void m1984h() {
        if (this.f2247c == this.f2246b.length) {
            int[] iArr = new int[((this.f2247c * 3) / 2) + 10];
            System.arraycopy(this.f2246b, 0, iArr, 0, this.f2247c);
            this.f2246b = iArr;
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m1985b() {
        return this.f2247c;
    }

    /* JADX INFO: renamed from: b */
    public final int m1986b(int i) {
        if (i >= this.f2247c) {
            throw new IndexOutOfBoundsException("n >= size()");
        }
        try {
            return this.f2246b[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("n < 0");
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1987b(int i, int i2) {
        m2004l();
        if (i >= this.f2247c) {
            throw new IndexOutOfBoundsException("n >= size()");
        }
        try {
            this.f2246b[i] = i2;
            this.f2248d = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            if (i < 0) {
                throw new IllegalArgumentException("n < 0");
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m1988c(int i) {
        m2004l();
        m1984h();
        int[] iArr = this.f2246b;
        int i2 = this.f2247c;
        this.f2247c = i2 + 1;
        iArr[i2] = i;
        if (!this.f2248d || this.f2247c <= 1) {
            return;
        }
        this.f2248d = i >= this.f2246b[this.f2247c + (-2)];
    }

    /* JADX INFO: renamed from: c */
    public final void m1989c(int i, int i2) {
        if (i > this.f2247c) {
            throw new IndexOutOfBoundsException("n > size()");
        }
        m1984h();
        System.arraycopy(this.f2246b, i, this.f2246b, i + 1, this.f2247c - i);
        this.f2246b[i] = i2;
        this.f2247c++;
        this.f2248d = this.f2248d && (i == 0 || i2 > this.f2246b[i + (-1)]) && (i == this.f2247c + (-1) || i2 < this.f2246b[i + 1]);
    }

    /* JADX INFO: renamed from: d */
    public final int m1990d() {
        return m1986b(this.f2247c - 1);
    }

    /* JADX INFO: renamed from: d */
    public final void m1991d(int i) {
        if (i >= this.f2247c) {
            throw new IndexOutOfBoundsException("n >= size()");
        }
        System.arraycopy(this.f2246b, i + 1, this.f2246b, i, (this.f2247c - i) - 1);
        this.f2247c--;
    }

    /* JADX INFO: renamed from: e */
    public final int m1992e() {
        m2004l();
        this.f2247c--;
        return m1986b(this.f2247c - 1);
    }

    /* JADX INFO: renamed from: e */
    public final void m1993e(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("newSize < 0");
        }
        if (i > this.f2247c) {
            throw new IllegalArgumentException("newSize > size");
        }
        m2004l();
        this.f2247c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0880j)) {
            return false;
        }
        C0880j c0880j = (C0880j) obj;
        if (this.f2248d != c0880j.f2248d || this.f2247c != c0880j.f2247c) {
            return false;
        }
        for (int i = 0; i < this.f2247c; i++) {
            if (this.f2246b[i] != c0880j.f2246b[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final int m1994f(int i) {
        int iM1996g = m1996g(i);
        if (iM1996g >= 0) {
            return iM1996g;
        }
        return -1;
    }

    /* JADX INFO: renamed from: f */
    public final C0880j m1995f() {
        int i = this.f2247c;
        C0880j c0880j = new C0880j(i);
        for (int i2 = 0; i2 < i; i2++) {
            c0880j.m1988c(this.f2246b[i2]);
        }
        return c0880j;
    }

    /* JADX INFO: renamed from: g */
    public final int m1996g(int i) {
        int i2 = this.f2247c;
        if (!this.f2248d) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.f2246b[i3] == i) {
                    return i3;
                }
            }
            return -i2;
        }
        int i4 = i2;
        int i5 = -1;
        while (i4 > i5 + 1) {
            int i6 = ((i4 - i5) >> 1) + i5;
            if (i <= this.f2246b[i6]) {
                i4 = i6;
            } else {
                i5 = i6;
            }
        }
        return i4 != i2 ? i != this.f2246b[i4] ? (-i4) - 1 : i4 : (-i2) - 1;
    }

    /* JADX INFO: renamed from: g */
    public final void m1997g() {
        m2004l();
        if (this.f2248d) {
            return;
        }
        Arrays.sort(this.f2246b, 0, this.f2247c);
        this.f2248d = true;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m1998h(int i) {
        return m1994f(i) >= 0;
    }

    public final int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.f2247c; i2++) {
            i = (i * 31) + this.f2246b[i2];
        }
        return i;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f2247c * 5) + 10);
        stringBuffer.append('{');
        for (int i = 0; i < this.f2247c; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.f2246b[i]);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
