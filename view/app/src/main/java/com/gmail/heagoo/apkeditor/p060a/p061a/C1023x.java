package com.gmail.heagoo.apkeditor.p060a.p061a;

import com.gmail.heagoo.apkeditor.p060a.C1031i;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1023x {

    /* JADX INFO: renamed from: a */
    public int f2930a;

    /* JADX INFO: renamed from: b */
    public String f2931b;

    /* JADX INFO: renamed from: c */
    private byte[] f2932c;

    /* JADX INFO: renamed from: d */
    private String f2933d;

    /* JADX INFO: renamed from: e */
    private int f2934e;

    /* JADX INFO: renamed from: f */
    private int f2935f;

    /* JADX INFO: renamed from: g */
    private int f2936g;

    C1023x(C1022w c1022w, byte[] bArr, int i) {
        this.f2932c = bArr;
        this.f2930a = i;
        int iM2667a = C1004e.m2667a(bArr, i + 4);
        this.f2934e = C1004e.m2667a(bArr, i + 8);
        int iM2667a2 = C1004e.m2667a(bArr, i + 12) >> 16;
        this.f2935f = ((iM2667a2 & 255) << 8) | ((iM2667a2 >> 8) & 255);
        this.f2936g = C1004e.m2667a(bArr, i + 16);
        this.f2931b = c1022w.f2928g.m2716b(iM2667a);
        if ((this.f2931b == null || this.f2931b.equals("")) && iM2667a < c1022w.f2929h.m2701a()) {
            this.f2931b = C1031i.m2757a(c1022w.f2929h.f2878a[iM2667a]);
        }
        if (this.f2935f == 3) {
            this.f2933d = c1022w.f2928g.m2716b(this.f2936g >= 0 ? this.f2936g : this.f2934e);
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2748a(C1023x c1023x, int[] iArr) {
        C1022w.m2737b(iArr, c1023x.f2932c, c1023x.f2930a);
        C1022w.m2737b(iArr, c1023x.f2932c, c1023x.f2930a + 4);
        C1022w.m2737b(iArr, c1023x.f2932c, c1023x.f2930a + 8);
        if (c1023x.f2935f == 3) {
            C1022w.m2737b(iArr, c1023x.f2932c, c1023x.f2930a + 16);
        }
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m2749a() {
        return this.f2932c;
    }

    /* JADX INFO: renamed from: b */
    public final int m2750b() {
        return this.f2935f;
    }

    /* JADX INFO: renamed from: c */
    public final int m2751c() {
        return this.f2936g;
    }

    public final String toString() {
        return this.f2933d != null ? this.f2931b + "=\"" + this.f2933d + "\"" : this.f2931b + "=valueType:" + this.f2935f + ",valueData:" + this.f2936g;
    }
}
