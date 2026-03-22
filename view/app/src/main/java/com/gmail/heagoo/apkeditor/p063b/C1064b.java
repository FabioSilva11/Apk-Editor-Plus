package com.gmail.heagoo.apkeditor.p063b;

import android.support.v7.appcompat.C0299R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.b.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1064b {

    /* JADX INFO: renamed from: a */
    private byte[] f3035a;

    /* JADX INFO: renamed from: b */
    private final int f3036b = m2774b(52);

    /* JADX INFO: renamed from: c */
    private final int f3037c = m2774b(56);

    /* JADX INFO: renamed from: d */
    private final int f3038d = m2774b(60);

    /* JADX INFO: renamed from: e */
    private final int f3039e;

    /* JADX INFO: renamed from: f */
    private final int f3040f;

    /* JADX INFO: renamed from: g */
    private final int f3041g;

    /* JADX INFO: renamed from: h */
    private final int f3042h;

    /* JADX INFO: renamed from: i */
    private final int f3043i;

    /* JADX INFO: renamed from: j */
    private final int f3044j;

    /* JADX INFO: renamed from: k */
    private final int f3045k;

    /* JADX INFO: renamed from: l */
    private final int f3046l;

    /* JADX INFO: renamed from: m */
    private final int f3047m;

    public C1064b(byte[] bArr) throws C1071i {
        this.f3035a = bArr;
        m2774b(64);
        this.f3039e = m2774b(68);
        this.f3040f = m2774b(72);
        this.f3041g = m2774b(76);
        m2774b(80);
        this.f3042h = m2774b(84);
        m2774b(88);
        this.f3043i = m2774b(92);
        this.f3044j = m2774b(96);
        this.f3045k = m2774b(100);
        this.f3046l = m2774b(C0299R.styleable.AppCompatTheme_buttonStyle);
        this.f3047m = m2774b(108);
    }

    /* JADX INFO: renamed from: a */
    public static int m2771a(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | (bArr[i + 3] << 24);
    }

    /* JADX INFO: renamed from: a */
    public static void m2772a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    /* JADX INFO: renamed from: a */
    private boolean m2773a(int i, int i2, int i3, int i4) {
        if (i < i2) {
            return false;
        }
        m2772a(i + i3, this.f3035a, i4);
        return true;
    }

    /* JADX INFO: renamed from: b */
    private int m2774b(int i) throws C1071i {
        byte[] bArr = this.f3035a;
        int i2 = (bArr[i + 3] << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        if (i2 < 0) {
            throw new C1071i("out of range when read int at offset 0x%x", Integer.valueOf(i));
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final int m2775a() {
        return this.f3044j;
    }

    /* JADX INFO: renamed from: a */
    public final int m2776a(int i) throws C1071i {
        if (i < 0 || i >= this.f3037c) {
            throw new C1071i("String index out of bounds: %d", Integer.valueOf(i));
        }
        return this.f3038d + (i << 2);
    }

    /* JADX INFO: renamed from: a */
    public final void m2777a(int i, int i2) {
        if (i2 != 0) {
            m2772a(m2771a(this.f3035a, 32) + i2, this.f3035a, 32);
            m2773a(this.f3036b, i, i2, 52);
            m2773a(this.f3038d, i, i2, 60);
            m2773a(this.f3039e, i, i2, 68);
            m2773a(this.f3041g, i, i2, 76);
            m2773a(this.f3042h, i, i2, 84);
            m2773a(this.f3043i, i, i2, 92);
            m2773a(this.f3045k, i, i2, 100);
            if (m2773a(this.f3047m, i, i2, 108)) {
                return;
            }
            m2772a(this.f3046l + i2, this.f3035a, C0299R.styleable.AppCompatTheme_buttonStyle);
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m2778b() {
        return this.f3037c;
    }

    /* JADX INFO: renamed from: c */
    public final int m2779c() {
        return this.f3040f;
    }

    /* JADX INFO: renamed from: d */
    public final int m2780d() {
        return this.f3041g;
    }

    /* JADX INFO: renamed from: e */
    public final int m2781e() {
        return this.f3045k;
    }

    /* JADX INFO: renamed from: f */
    public final List m2782f() throws C1071i {
        int iM2774b = m2774b(this.f3036b);
        ArrayList arrayList = new ArrayList(iM2774b);
        for (int i = 0; i < iM2774b; i++) {
            byte[] bArr = this.f3035a;
            int i2 = this.f3036b + 4 + (i * 12);
            C1063a c1063a = new C1063a();
            c1063a.f3032a = (short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8));
            c1063a.f3033b = m2771a(bArr, i2 + 4);
            c1063a.f3034c = m2771a(bArr, i2 + 8);
            arrayList.add(c1063a);
        }
        Collections.sort(arrayList, new C1065c(this));
        return arrayList;
    }

    /* JADX INFO: renamed from: g */
    public final int m2783g() {
        return this.f3036b;
    }
}
