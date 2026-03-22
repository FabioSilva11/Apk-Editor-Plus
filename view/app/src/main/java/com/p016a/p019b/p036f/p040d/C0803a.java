package com.p016a.p019b.p036f.p040d;

import android.support.v7.widget.ActivityChooserView;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.f.d.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0803a implements Comparable {

    /* JADX INFO: renamed from: a */
    private static final HashMap f1959a = new HashMap(500);

    /* JADX INFO: renamed from: b */
    private final String f1960b;

    /* JADX INFO: renamed from: c */
    private final C0805c f1961c;

    /* JADX INFO: renamed from: d */
    private final C0804b f1962d;

    /* JADX INFO: renamed from: e */
    private C0804b f1963e;

    private C0803a(String str, C0805c c0805c, C0804b c0804b) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        if (c0805c == null) {
            throw new NullPointerException("returnType == null");
        }
        if (c0804b == null) {
            throw new NullPointerException("parameterTypes == null");
        }
        this.f1960b = str;
        this.f1961c = c0805c;
        this.f1962d = c0804b;
        this.f1963e = null;
    }

    /* JADX INFO: renamed from: a */
    public static C0803a m1657a(C0805c c0805c, int i) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('(');
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append('I');
        }
        stringBuffer.append(')');
        stringBuffer.append(c0805c.m1685g());
        return m1658a(stringBuffer.toString());
    }

    /* JADX INFO: renamed from: a */
    public static C0803a m1658a(String str) {
        C0803a c0803a;
        int i;
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        synchronized (f1959a) {
            c0803a = (C0803a) f1959a.get(str);
        }
        if (c0803a != null) {
            return c0803a;
        }
        C0805c[] c0805cArrM1661b = m1661b(str);
        int i2 = 1;
        int i3 = 0;
        while (true) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ')') {
                C0805c c0805cM1681b = C0805c.m1681b(str.substring(i2 + 1));
                C0804b c0804b = new C0804b(i3);
                for (int i4 = 0; i4 < i3; i4++) {
                    c0804b.m1675a(i4, c0805cArrM1661b[i4]);
                }
                return m1660b(new C0803a(str, c0805cM1681b, c0804b));
            }
            int i5 = i2;
            while (cCharAt == '[') {
                i5++;
                cCharAt = str.charAt(i5);
            }
            if (cCharAt == 'L') {
                int iIndexOf = str.indexOf(59, i5);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("bad descriptor");
                }
                i = iIndexOf + 1;
            } else {
                i = i5 + 1;
            }
            c0805cArrM1661b[i3] = C0805c.m1679a(str.substring(i2, i));
            i3++;
            i2 = i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0803a m1659a(String str, C0805c c0805c, boolean z, boolean z2) {
        C0803a c0803aM1658a = m1658a(str);
        if (z) {
            return c0803aM1658a;
        }
        if (z2) {
            c0805c = c0805c.m1684a(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
        return c0803aM1658a.m1663a(c0805c);
    }

    /* JADX INFO: renamed from: b */
    private static C0803a m1660b(C0803a c0803a) {
        synchronized (f1959a) {
            String str = c0803a.f1960b;
            C0803a c0803a2 = (C0803a) f1959a.get(str);
            if (c0803a2 != null) {
                return c0803a2;
            }
            f1959a.put(str, c0803a);
            return c0803a;
        }
    }

    /* JADX INFO: renamed from: b */
    private static C0805c[] m1661b(String str) {
        int length = str.length();
        if (str.charAt(0) != '(') {
            throw new IllegalArgumentException("bad descriptor");
        }
        int i = 1;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = 0;
                break;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == ')') {
                break;
            }
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                i2++;
            }
            i++;
        }
        if (i == 0 || i == length - 1) {
            throw new IllegalArgumentException("bad descriptor");
        }
        if (str.indexOf(41, i + 1) != -1) {
            throw new IllegalArgumentException("bad descriptor");
        }
        return new C0805c[i2];
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0803a c0803a) {
        if (this == c0803a) {
            return 0;
        }
        int iM1683a = this.f1961c.compareTo(c0803a.f1961c);
        if (iM1683a != 0) {
            return iM1683a;
        }
        int iD_ = this.f1962d.m1977d_();
        int iD_2 = c0803a.f1962d.m1977d_();
        int iMin = Math.min(iD_, iD_2);
        for (int i = 0; i < iMin; i++) {
            int iM1683a2 = this.f1962d.m1676b(i).compareTo(c0803a.f1962d.m1676b(i));
            if (iM1683a2 != 0) {
                return iM1683a2;
            }
        }
        if (iD_ < iD_2) {
            return -1;
        }
        return iD_ > iD_2 ? 1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public final C0803a m1663a(C0805c c0805c) {
        String str = "(" + c0805c.m1685g() + this.f1960b.substring(1);
        C0804b c0804bM1677c = this.f1962d.m1677c(c0805c);
        c0804bM1677c.mo549b_();
        return m1660b(new C0803a(str, this.f1961c, c0804bM1677c));
    }

    /* JADX INFO: renamed from: a */
    public final C0805c m1664a() {
        return this.f1961c;
    }

    /* JADX INFO: renamed from: b */
    public final C0804b m1665b() {
        return this.f1962d;
    }

    /* JADX INFO: renamed from: c */
    public final C0804b m1666c() {
        if (this.f1963e == null) {
            int iD_ = this.f1962d.m1977d_();
            C0804b c0804b = new C0804b(iD_);
            boolean z = false;
            for (int i = 0; i < iD_; i++) {
                C0805c c0805cM1676b = this.f1962d.m1676b(i);
                if (c0805cM1676b.m1690l()) {
                    z = true;
                    c0805cM1676b = C0805c.f2015f;
                }
                c0804b.m1675a(i, c0805cM1676b);
            }
            this.f1963e = z ? c0804b : this.f1962d;
        }
        return this.f1963e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0803a) {
            return this.f1960b.equals(((C0803a) obj).f1960b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1960b.hashCode();
    }

    public final String toString() {
        return this.f1960b;
    }
}
