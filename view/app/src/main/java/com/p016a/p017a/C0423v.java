package com.p016a.p017a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.p018a.InterfaceC0398b;

/* JADX INFO: renamed from: com.a.a.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0423v {

    /* JADX INFO: renamed from: a */
    private InterfaceC0398b f406a;

    /* JADX INFO: renamed from: b */
    private int f407b;

    /* JADX INFO: renamed from: c */
    private int f408c;

    /* JADX INFO: renamed from: d */
    private int f409d;

    public C0423v(InterfaceC0398b interfaceC0398b, int i) {
        this.f407b = -1;
        this.f406a = interfaceC0398b;
        this.f407b = i;
    }

    public C0423v(C0422u c0422u, int i) {
        this(c0422u.m405a(), i);
    }

    /* JADX INFO: renamed from: a */
    private void m407a(int i) {
        if (m408a() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", Integer.valueOf(i), Integer.valueOf(m408a())));
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m408a() {
        if (this.f407b == -1) {
            int iMo306d = this.f406a.mo306d() & 255;
            this.f407b = iMo306d & 31;
            this.f409d = (iMo306d & 224) >> 5;
        }
        return this.f407b;
    }

    /* JADX INFO: renamed from: b */
    public final int m409b() {
        m407a(28);
        this.f407b = -1;
        return C0985a.m2232b(this.f406a);
    }

    /* JADX INFO: renamed from: c */
    public final int m410c() {
        m407a(29);
        this.f407b = -1;
        this.f408c = C0985a.m2232b(this.f406a);
        return C0985a.m2232b(this.f406a);
    }

    /* JADX INFO: renamed from: d */
    public final int m411d() {
        return this.f408c;
    }

    /* JADX INFO: renamed from: e */
    public final int m412e() {
        return C0985a.m2232b(this.f406a);
    }

    /* JADX INFO: renamed from: f */
    public final byte m413f() {
        m407a(0);
        this.f407b = -1;
        return (byte) C0985a.m2172a(this.f406a, this.f409d);
    }

    /* JADX INFO: renamed from: g */
    public final short m414g() {
        m407a(2);
        this.f407b = -1;
        return (short) C0985a.m2172a(this.f406a, this.f409d);
    }

    /* JADX INFO: renamed from: h */
    public final char m415h() {
        m407a(3);
        this.f407b = -1;
        return (char) C0985a.m2173a(this.f406a, this.f409d, false);
    }

    /* JADX INFO: renamed from: i */
    public final int m416i() {
        m407a(4);
        this.f407b = -1;
        return C0985a.m2172a(this.f406a, this.f409d);
    }

    /* JADX INFO: renamed from: j */
    public final long m417j() {
        m407a(6);
        this.f407b = -1;
        return C0985a.m2234b(this.f406a, this.f409d);
    }

    /* JADX INFO: renamed from: k */
    public final float m418k() {
        m407a(16);
        this.f407b = -1;
        return Float.intBitsToFloat(C0985a.m2173a(this.f406a, this.f409d, true));
    }

    /* JADX INFO: renamed from: l */
    public final double m419l() {
        m407a(17);
        this.f407b = -1;
        return Double.longBitsToDouble(C0985a.m2235b(this.f406a, this.f409d, true));
    }

    /* JADX INFO: renamed from: m */
    public final int m420m() {
        m407a(23);
        this.f407b = -1;
        return C0985a.m2173a(this.f406a, this.f409d, false);
    }

    /* JADX INFO: renamed from: n */
    public final int m421n() {
        m407a(24);
        this.f407b = -1;
        return C0985a.m2173a(this.f406a, this.f409d, false);
    }

    /* JADX INFO: renamed from: o */
    public final int m422o() {
        m407a(25);
        this.f407b = -1;
        return C0985a.m2173a(this.f406a, this.f409d, false);
    }

    /* JADX INFO: renamed from: p */
    public final int m423p() {
        m407a(27);
        this.f407b = -1;
        return C0985a.m2173a(this.f406a, this.f409d, false);
    }

    /* JADX INFO: renamed from: q */
    public final int m424q() {
        m407a(26);
        this.f407b = -1;
        return C0985a.m2173a(this.f406a, this.f409d, false);
    }

    /* JADX INFO: renamed from: r */
    public final void m425r() {
        m407a(30);
        this.f407b = -1;
    }

    /* JADX INFO: renamed from: s */
    public final boolean m426s() {
        m407a(31);
        this.f407b = -1;
        return this.f409d != 0;
    }

    /* JADX INFO: renamed from: t */
    public final void m427t() {
        int i = 0;
        switch (m408a()) {
            case 0:
                m413f();
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
                throw new C0420s("Unexpected type: " + Integer.toHexString(this.f407b));
            case 2:
                m414g();
                return;
            case 3:
                m415h();
                return;
            case 4:
                m416i();
                return;
            case 6:
                m417j();
                return;
            case 16:
                m418k();
                return;
            case 17:
                m419l();
                return;
            case 23:
                m420m();
                return;
            case 24:
                m421n();
                return;
            case 25:
                m422o();
                return;
            case 26:
                m424q();
                return;
            case 27:
                m423p();
                return;
            case 28:
                int iM409b = m409b();
                while (i < iM409b) {
                    m427t();
                    i++;
                }
                return;
            case 29:
                int iM410c = m410c();
                while (i < iM410c) {
                    C0985a.m2232b(this.f406a);
                    m427t();
                    i++;
                }
                return;
            case 30:
                m425r();
                return;
            case 31:
                m426s();
                return;
        }
    }
}
