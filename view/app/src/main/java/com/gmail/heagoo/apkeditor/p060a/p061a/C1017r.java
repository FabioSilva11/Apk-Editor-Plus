package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.IOException;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1017r {

    /* JADX INFO: renamed from: a */
    public int[] f2878a;

    /* JADX INFO: renamed from: b */
    private int f2879b;

    /* JADX INFO: renamed from: c */
    private int f2880c;

    /* JADX INFO: renamed from: a */
    public final int m2701a() {
        if (this.f2878a != null) {
            return this.f2878a.length;
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m2702a(int i, int i2) {
        this.f2880c += 4;
        int[] iArr = new int[this.f2878a.length + 1];
        iArr[0] = 16843447;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            iArr[i3] = this.f2878a[i3 - 1];
        }
        this.f2878a = iArr;
    }

    /* JADX INFO: renamed from: a */
    public final void m2703a(C1011l c1011l) throws IOException {
        c1011l.m2680a(this.f2879b);
        c1011l.m2680a(this.f2880c);
        c1011l.m2684a(this.f2878a);
    }

    /* JADX INFO: renamed from: a */
    public final void m2704a(C1012m c1012m) {
        this.f2879b = c1012m.m2687a();
        this.f2880c = c1012m.m2687a();
        int i = (this.f2880c - 8) / 4;
        this.f2878a = new int[i];
        new StringBuilder("Attr Count: ").append(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f2878a[i2] = c1012m.m2687a();
            new StringBuilder("\t").append(this.f2878a[i2]);
        }
    }
}
