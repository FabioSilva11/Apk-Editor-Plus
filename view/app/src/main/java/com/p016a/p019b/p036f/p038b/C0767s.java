package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p040d.InterfaceC0806d;

/* JADX INFO: renamed from: com.a.b.f.b.s */
/* JADX INFO: loaded from: classes.dex */
final class C0767s {

    /* JADX INFO: renamed from: a */
    private int f1668a;

    /* JADX INFO: renamed from: b */
    private InterfaceC0806d f1669b;

    /* JADX INFO: renamed from: c */
    private C0761m f1670c;

    private C0767s() {
    }

    /* synthetic */ C0767s(byte b2) {
        this();
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1544a() {
        return new C0766r(this.f1668a, this.f1669b, this.f1670c, (byte) 0);
    }

    /* JADX INFO: renamed from: a */
    public final void m1545a(int i, InterfaceC0806d interfaceC0806d, C0761m c0761m) {
        this.f1668a = i;
        this.f1669b = interfaceC0806d;
        this.f1670c = c0761m;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0766r) {
            return ((C0766r) obj).m1523e(this.f1668a, this.f1669b, this.f1670c);
        }
        return false;
    }

    public final int hashCode() {
        return C0766r.m1524f(this.f1668a, this.f1669b, this.f1670c);
    }
}
