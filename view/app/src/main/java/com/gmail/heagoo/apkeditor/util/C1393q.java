package com.gmail.heagoo.apkeditor.util;

import com.gmail.heagoo.common.C1487s;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.q */
/* JADX INFO: loaded from: classes.dex */
final class C1393q {

    /* JADX INFO: renamed from: a */
    int f4043a;

    /* JADX INFO: renamed from: b */
    String f4044b;

    /* JADX INFO: renamed from: c */
    String f4045c;

    /* JADX INFO: renamed from: d */
    private String f4046d;

    private C1393q(C1392p c1392p, int i, String str) {
        this.f4043a = i;
        this.f4045c = str;
    }

    /* synthetic */ C1393q(C1392p c1392p, int i, String str, byte b2) {
        this(c1392p, i, str);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m3363a(C1393q c1393q) {
        return c1393q.f4046d != null;
    }

    /* JADX INFO: renamed from: a */
    public final String m3364a() {
        if (this.f4046d == null) {
            this.f4046d = this.f4045c + "_" + C1487s.m3525a(4);
        }
        return this.f4046d;
    }
}
