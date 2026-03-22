package com.p016a.p019b.p035e;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.C0420s;
import com.p016a.p017a.C0423v;
import com.p016a.p017a.p018a.InterfaceC0399c;

/* JADX INFO: renamed from: com.a.b.e.n */
/* JADX INFO: loaded from: classes.dex */
final class C0731n {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0399c f1590a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0730m f1591b;

    public C0731n(C0730m c0730m, InterfaceC0399c interfaceC0399c) {
        this.f1591b = c0730m;
        this.f1590a = interfaceC0399c;
    }

    /* JADX INFO: renamed from: a */
    private void m1420a(int i, int i2) {
        this.f1590a.mo307d((i2 << 5) | i);
    }

    /* JADX INFO: renamed from: a */
    private void m1421a(C0423v c0423v) {
        switch (c0423v.m408a()) {
            case 0:
                C0985a.m2208a(this.f1590a, 0, c0423v.m413f());
                return;
            case 1:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            default:
                throw new C0420s("Unexpected type: " + Integer.toHexString(c0423v.m408a()));
            case 2:
                C0985a.m2208a(this.f1590a, 2, c0423v.m414g());
                return;
            case 3:
                C0985a.m2242b(this.f1590a, 3, c0423v.m415h());
                return;
            case 4:
                C0985a.m2208a(this.f1590a, 4, c0423v.m416i());
                return;
            case 6:
                C0985a.m2208a(this.f1590a, 6, c0423v.m417j());
                return;
            case 16:
                C0985a.m2258c(this.f1590a, 16, ((long) Float.floatToIntBits(c0423v.m418k())) << 32);
                return;
            case 17:
                C0985a.m2258c(this.f1590a, 17, Double.doubleToLongBits(c0423v.m419l()));
                return;
            case 23:
                C0985a.m2242b(this.f1590a, 23, this.f1591b.m1399a(c0423v.m420m()));
                return;
            case 24:
                C0985a.m2242b(this.f1590a, 24, this.f1591b.m1407b(c0423v.m421n()));
                return;
            case 25:
                C0985a.m2242b(this.f1590a, 25, this.f1591b.m1409c(c0423v.m422o()));
                return;
            case 26:
                C0985a.m2242b(this.f1590a, 26, this.f1591b.m1411d(c0423v.m424q()));
                return;
            case 27:
                C0985a.m2242b(this.f1590a, 27, this.f1591b.m1409c(c0423v.m423p()));
                return;
            case 28:
                m1420a(28, 0);
                m1425c(c0423v);
                return;
            case 29:
                m1420a(29, 0);
                m1423b(c0423v);
                return;
            case 30:
                c0423v.m425r();
                m1420a(30, 0);
                return;
            case 31:
                m1420a(31, c0423v.m426s() ? 1 : 0);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m1423b(C0423v c0423v) {
        int iM410c = c0423v.m410c();
        C0985a.m2207a(this.f1590a, this.f1591b.m1407b(c0423v.m411d()));
        C0985a.m2207a(this.f1590a, iM410c);
        for (int i = 0; i < iM410c; i++) {
            C0985a.m2207a(this.f1590a, this.f1591b.m1399a(c0423v.m412e()));
            m1421a(c0423v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m1425c(C0423v c0423v) {
        int iM409b = c0423v.m409b();
        C0985a.m2207a(this.f1590a, iM409b);
        for (int i = 0; i < iM409b; i++) {
            m1421a(c0423v);
        }
    }
}
