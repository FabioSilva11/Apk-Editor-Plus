package com.p016a.p019b.p036f.p039c;

import android.support.v4.app.FrameMetricsAggregator;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0790n extends AbstractC0793q {

    /* JADX INFO: renamed from: h */
    private static final C0790n[] f1923h = new C0790n[FrameMetricsAggregator.EVERY_DURATION];

    /* JADX INFO: renamed from: a */
    public static final C0790n f1916a = m1629a(-1);

    /* JADX INFO: renamed from: b */
    public static final C0790n f1917b = m1629a(0);

    /* JADX INFO: renamed from: c */
    public static final C0790n f1918c = m1629a(1);

    /* JADX INFO: renamed from: d */
    public static final C0790n f1919d = m1629a(2);

    /* JADX INFO: renamed from: e */
    public static final C0790n f1920e = m1629a(3);

    /* JADX INFO: renamed from: f */
    public static final C0790n f1921f = m1629a(4);

    /* JADX INFO: renamed from: g */
    public static final C0790n f1922g = m1629a(5);

    private C0790n(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0790n m1629a(int i) {
        int i2 = (Integer.MAX_VALUE & i) % FrameMetricsAggregator.EVERY_DURATION;
        C0790n c0790n = f1923h[i2];
        if (c0790n != null && c0790n.mo1632j() == i) {
            return c0790n;
        }
        C0790n c0790n2 = new C0790n(i);
        f1923h[i2] = c0790n2;
        return c0790n2;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2015f;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return Integer.toString(mo1632j());
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "int";
    }

    public final String toString() {
        int iJ = mo1632j();
        return "int{0x" + C0985a.m2294t(iJ) + " / " + iJ + '}';
    }
}
