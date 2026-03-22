package com.gmail.heagoo.neweditor;

import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1526t {

    /* JADX INFO: renamed from: a */
    private boolean f4510a;

    /* JADX INFO: renamed from: b */
    private C1527u[] f4511b;

    /* JADX INFO: renamed from: c */
    private int f4512c;

    /* JADX INFO: renamed from: d */
    private StringBuilder f4513d;

    public C1526t(boolean z) {
        this(z, 52);
        this.f4510a = z;
        this.f4513d = new StringBuilder();
    }

    private C1526t(boolean z, int i) {
        this.f4512c = 52;
        this.f4510a = z;
        this.f4511b = new C1527u[52];
    }

    /* JADX INFO: renamed from: a */
    public final byte m3655a(C1532z c1532z, int i, int i2) {
        if (i2 == 0) {
            return (byte) 0;
        }
        C1527u c1527u = this.f4511b[(Character.toUpperCase(c1532z.f4545a[i]) + Character.toUpperCase(c1532z.f4545a[(i + i2) - 1])) % this.f4512c];
        while (c1527u != null) {
            if (i2 != c1527u.f4515b.length) {
                c1527u = c1527u.f4516c;
            } else {
                if (C0985a.m2226a(this.f4510a, c1532z, i, c1527u.f4515b)) {
                    return c1527u.f4514a;
                }
                c1527u = c1527u.f4516c;
            }
        }
        return (byte) 0;
    }

    /* JADX INFO: renamed from: a */
    public final String m3656a() {
        return this.f4513d.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m3657a(String str, byte b2) {
        char[] charArray = str.toCharArray();
        int upperCase = (Character.toUpperCase(charArray[0]) + Character.toUpperCase(charArray[charArray.length - 1])) % this.f4512c;
        for (char c : charArray) {
            if (!Character.isLetterOrDigit(c)) {
                for (int i = 0; i < this.f4513d.length() && this.f4513d.charAt(i) != c; i++) {
                }
                this.f4513d.append(c);
            }
        }
        this.f4511b[upperCase] = new C1527u(charArray, b2, this.f4511b[upperCase]);
    }
}
