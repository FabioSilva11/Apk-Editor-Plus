package com.gmail.heagoo.apkeditor.p063b;

import com.gmail.heagoo.apkeditor.p060a.p061a.C1018s;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.b.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1069g {

    /* JADX INFO: renamed from: a */
    byte[] f3053a;

    /* JADX INFO: renamed from: b */
    int f3054b;

    /* JADX INFO: renamed from: c */
    int f3055c;

    /* JADX INFO: renamed from: d */
    String f3056d;

    public C1069g(int i, String str) {
        this.f3056d = str;
    }

    public C1069g(int i, String str, byte[] bArr, int i2, int i3) {
        this.f3056d = str;
        this.f3053a = bArr;
        this.f3054b = i2;
        this.f3055c = i3;
    }

    /* JADX INFO: renamed from: b */
    private void m2801b() {
        int[] iArr = new int[1];
        C1066d c1066d = new C1066d(this.f3053a, this.f3054b);
        int iM2784a = 0;
        try {
            iM2784a = c1066d.m2784a();
        } catch (C1071i e) {
            e.printStackTrace();
        }
        this.f3056d = C1072j.m2807a(this.f3053a, c1066d.m2786b(), iM2784a, iArr);
    }

    /* JADX INFO: renamed from: c */
    private void m2802c() {
        byte[] bArrM2706a = C1018s.m2706a(this.f3056d.length());
        byte[] bArrM2808a = C1072j.m2808a(this.f3056d);
        this.f3053a = new byte[bArrM2706a.length + bArrM2808a.length + 1];
        System.arraycopy(bArrM2706a, 0, this.f3053a, 0, bArrM2706a.length);
        System.arraycopy(bArrM2808a, 0, this.f3053a, bArrM2706a.length, bArrM2808a.length);
        this.f3054b = 0;
        this.f3055c = bArrM2706a.length + bArrM2808a.length + 1;
    }

    /* JADX INFO: renamed from: a */
    public final int m2803a() {
        if (this.f3053a != null && this.f3055c > 0) {
            return this.f3055c;
        }
        m2802c();
        return this.f3055c;
    }

    /* JADX INFO: renamed from: a */
    public final int m2804a(C1069g c1069g) {
        if (this.f3056d == null) {
            m2801b();
        }
        if (c1069g.f3056d == null) {
            c1069g.m2801b();
        }
        return this.f3056d.compareTo(c1069g.f3056d);
    }

    /* JADX INFO: renamed from: a */
    public final void m2805a(String str) {
        this.f3056d = str;
        m2802c();
    }
}
