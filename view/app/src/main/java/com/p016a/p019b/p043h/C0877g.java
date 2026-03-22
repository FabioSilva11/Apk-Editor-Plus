package com.p016a.p019b.p043h;

import java.util.Arrays;

/* JADX INFO: renamed from: com.a.b.h.g */
/* JADX INFO: loaded from: classes.dex */
public class C0877g extends C0886p implements InterfaceC0889s {

    /* JADX INFO: renamed from: a */
    private Object[] f2238a;

    public C0877g(int i) {
        super(i != 0);
        try {
            this.f2238a = new Object[i];
        } catch (NegativeArraySizeException e) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    /* JADX INFO: renamed from: a */
    private static Object m1972a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("n < 0");
        }
        throw new IndexOutOfBoundsException("n >= size()");
    }

    /* JADX INFO: renamed from: a */
    private String m1973a(String str, String str2, String str3, boolean z) {
        int length = this.f2238a.length;
        StringBuffer stringBuffer = new StringBuffer((length * 10) + 10);
        if (str != null) {
            stringBuffer.append(str);
        }
        for (int i = 0; i < length; i++) {
            if (i != 0 && str2 != null) {
                stringBuffer.append(str2);
            }
            if (z) {
                stringBuffer.append(((InterfaceC0889s) this.f2238a[i]).mo657d());
            } else {
                stringBuffer.append(this.f2238a[i]);
            }
        }
        if (str3 != null) {
            stringBuffer.append(str3);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public final String m1974a(String str, String str2, String str3) {
        return m1973a(str, str2, str3, false);
    }

    /* JADX INFO: renamed from: a */
    protected final void m1975a(int i, Object obj) {
        m2004l();
        try {
            this.f2238a[i] = obj;
        } catch (ArrayIndexOutOfBoundsException e) {
            m1972a(i);
        }
    }

    /* JADX INFO: renamed from: b */
    public final String m1976b(String str, String str2, String str3) {
        return m1973a(str, str2, str3, true);
    }

    /* JADX INFO: renamed from: d */
    public String mo657d() {
        String name = getClass().getName();
        return m1973a(name.substring(name.lastIndexOf(46) + 1) + '{', ", ", "}", true);
    }

    /* JADX INFO: renamed from: d_ */
    public final int m1977d_() {
        return this.f2238a.length;
    }

    /* JADX INFO: renamed from: e */
    protected final Object m1978e(int i) {
        try {
            Object obj = this.f2238a[i];
            if (obj == null) {
                throw new NullPointerException("unset: " + i);
            }
            return obj;
        } catch (ArrayIndexOutOfBoundsException e) {
            return m1972a(i);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f2238a, ((C0877g) obj).f2238a);
    }

    /* JADX INFO: renamed from: f */
    protected final Object m1979f(int i) {
        return this.f2238a[i];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f2238a);
    }

    /* JADX INFO: renamed from: i */
    public void mo1980i() {
        int i = 0;
        int length = this.f2238a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f2238a[i3] != null) {
                i2++;
            }
        }
        if (length == i2) {
            return;
        }
        m2004l();
        Object[] objArr = new Object[i2];
        for (int i4 = 0; i4 < length; i4++) {
            Object obj = this.f2238a[i4];
            if (obj != null) {
                objArr[i] = obj;
                i++;
            }
        }
        this.f2238a = objArr;
        if (i2 == 0) {
            mo549b_();
        }
    }

    public String toString() {
        String name = getClass().getName();
        return m1973a(name.substring(name.lastIndexOf(46) + 1) + '{', ", ", "}", false);
    }
}
