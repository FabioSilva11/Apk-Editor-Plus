package com.p016a.p019b.p026b.p027a;

import com.p016a.p019b.p026b.C0532b;

/* JADX INFO: renamed from: com.a.b.b.a.d */
/* JADX INFO: loaded from: classes.dex */
final class C0526d {

    /* JADX INFO: renamed from: a */
    private final String[] f673a;

    /* JADX INFO: renamed from: b */
    private int f674b = 0;

    /* JADX INFO: renamed from: c */
    private String f675c;

    /* JADX INFO: renamed from: d */
    private String f676d;

    public C0526d(String[] strArr) {
        this.f673a = strArr;
    }

    /* JADX INFO: renamed from: a */
    public final String m822a() {
        return this.f675c;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m823a(String str) {
        boolean z = false;
        int length = str.length();
        if (length <= 0 || str.charAt(length - 1) != '=') {
            return this.f675c.equals(str);
        }
        if (this.f675c.startsWith(str)) {
            this.f676d = this.f675c.substring(length);
            return true;
        }
        String strSubstring = str.substring(0, length - 1);
        if (!this.f675c.equals(strSubstring)) {
            return false;
        }
        if (this.f674b < this.f673a.length) {
            this.f675c = this.f673a[this.f674b];
            this.f674b++;
            z = true;
        }
        if (z) {
            this.f676d = this.f675c;
            return true;
        }
        System.err.println("Missing value after parameter " + strSubstring);
        throw new C0532b();
    }

    /* JADX INFO: renamed from: b */
    public final String m824b() {
        return this.f676d;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m825c() {
        if (this.f674b >= this.f673a.length) {
            return false;
        }
        this.f675c = this.f673a[this.f674b];
        if (this.f675c.equals("--") || !this.f675c.startsWith("--")) {
            return false;
        }
        this.f674b++;
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final String[] m826d() {
        int length = this.f673a.length - this.f674b;
        String[] strArr = new String[length];
        if (length > 0) {
            System.arraycopy(this.f673a, this.f674b, strArr, 0, length);
        }
        return strArr;
    }
}
