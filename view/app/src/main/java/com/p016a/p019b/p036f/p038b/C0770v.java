package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p043h.C0886p;

/* JADX INFO: renamed from: com.a.b.f.b.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0770v extends C0886p {

    /* JADX INFO: renamed from: a */
    private final C0766r[] f1677a;

    /* JADX INFO: renamed from: b */
    private int f1678b;

    static {
        new C0770v(0);
    }

    public C0770v(int i) {
        super(i != 0);
        this.f1677a = new C0766r[i];
        this.f1678b = 0;
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1562a(int i) {
        try {
            return this.f1677a[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus reg");
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1563a(C0761m c0761m) {
        int length = this.f1677a.length;
        for (int i = 0; i < length; i++) {
            C0766r c0766r = this.f1677a[i];
            if (c0766r != null && c0761m.equals(c0766r.m1535i())) {
                return c0766r;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1564a(C0766r c0766r) {
        return m1562a(c0766r.m1533g());
    }

    /* JADX INFO: renamed from: a */
    public final void m1565a(C0770v c0770v) {
        int length = c0770v.f1677a.length;
        for (int i = 0; i < length; i++) {
            C0766r c0766rM1562a = c0770v.m1562a(i);
            if (c0766rM1562a != null) {
                m1572d(c0766rM1562a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1566a(C0770v c0770v, boolean z) {
        C0766r c0766rM1527a;
        m2004l();
        C0766r[] c0766rArr = c0770v.f1677a;
        int length = this.f1677a.length;
        int iMin = Math.min(length, c0766rArr.length);
        this.f1678b = -1;
        for (int i = 0; i < iMin; i++) {
            C0766r c0766r = this.f1677a[i];
            if (c0766r != null && (c0766rM1527a = c0766r.m1527a(c0766rArr[i], true)) != c0766r) {
                this.f1677a[i] = c0766rM1527a;
            }
        }
        while (iMin < length) {
            this.f1677a[iMin] = null;
            iMin++;
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m1567b() {
        return this.f1677a.length;
    }

    /* JADX INFO: renamed from: b */
    public final C0766r m1568b(C0766r c0766r) {
        int length = this.f1677a.length;
        for (int i = 0; i < length; i++) {
            C0766r c0766r2 = this.f1677a[i];
            if (c0766r2 != null && c0766r.m1531b(c0766r2)) {
                return c0766r2;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final C0770v m1569b(int i) {
        int length = this.f1677a.length;
        C0770v c0770v = new C0770v(length + i);
        for (int i2 = 0; i2 < length; i2++) {
            C0766r c0766r = this.f1677a[i2];
            if (c0766r != null) {
                c0770v.m1572d(c0766r.m1530b(i));
            }
        }
        c0770v.f1678b = this.f1678b;
        if (m2003k()) {
            c0770v.mo549b_();
        }
        return c0770v;
    }

    /* JADX INFO: renamed from: c */
    public final void m1570c(C0766r c0766r) {
        try {
            this.f1677a[c0766r.m1533g()] = null;
            this.f1678b = -1;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus reg");
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m1571d() {
        int i = this.f1678b;
        if (i < 0) {
            int length = this.f1677a.length;
            i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f1677a[i2] != null) {
                    i++;
                }
            }
            this.f1678b = i;
        }
        return i;
    }

    /* JADX INFO: renamed from: d */
    public final void m1572d(C0766r c0766r) {
        int i;
        C0766r c0766r2;
        m2004l();
        if (c0766r == null) {
            throw new NullPointerException("spec == null");
        }
        this.f1678b = -1;
        try {
            int iM1533g = c0766r.m1533g();
            this.f1677a[iM1533g] = c0766r;
            if (iM1533g > 0 && (c0766r2 = this.f1677a[iM1533g - 1]) != null && c0766r2.m1537k() == 2) {
                this.f1677a[i] = null;
            }
            if (c0766r.m1537k() == 2) {
                this.f1677a[iM1533g + 1] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("spec.getReg() out of range");
        }
    }

    /* JADX INFO: renamed from: e */
    public final C0770v m1573e() {
        int length = this.f1677a.length;
        C0770v c0770v = new C0770v(length);
        for (int i = 0; i < length; i++) {
            C0766r c0766r = this.f1677a[i];
            if (c0766r != null) {
                c0770v.m1572d(c0766r);
            }
        }
        c0770v.f1678b = this.f1678b;
        return c0770v;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0770v)) {
            return false;
        }
        C0770v c0770v = (C0770v) obj;
        C0766r[] c0766rArr = c0770v.f1677a;
        int length = this.f1677a.length;
        if (length != c0766rArr.length || m1571d() != c0770v.m1571d()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            C0766r c0766r = this.f1677a[i];
            Object obj2 = c0766rArr[i];
            if (c0766r != obj2 && (c0766r == null || !c0766r.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int length = this.f1677a.length;
        int iHashCode = 0;
        for (int i = 0; i < length; i++) {
            C0766r c0766r = this.f1677a[i];
            iHashCode = (iHashCode * 31) + (c0766r == null ? 0 : c0766r.hashCode());
        }
        return iHashCode;
    }

    public final String toString() {
        boolean z = false;
        int length = this.f1677a.length;
        StringBuffer stringBuffer = new StringBuffer(length * 25);
        stringBuffer.append('{');
        for (int i = 0; i < length; i++) {
            C0766r c0766r = this.f1677a[i];
            if (c0766r != null) {
                if (z) {
                    stringBuffer.append(", ");
                } else {
                    z = true;
                }
                stringBuffer.append(c0766r);
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
