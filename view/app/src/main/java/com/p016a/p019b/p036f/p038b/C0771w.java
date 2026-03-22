package com.p016a.p019b.p036f.p038b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;

/* JADX INFO: renamed from: com.a.b.f.b.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0771w {

    /* JADX INFO: renamed from: a */
    private final int f1679a;

    /* JADX INFO: renamed from: b */
    private final C0805c f1680b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC0807e f1681c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC0807e f1682d;

    /* JADX INFO: renamed from: e */
    private final int f1683e;

    /* JADX INFO: renamed from: f */
    private final boolean f1684f;

    /* JADX INFO: renamed from: g */
    private final String f1685g;

    public C0771w(int i, C0805c c0805c, InterfaceC0807e interfaceC0807e, int i2, String str) {
        this(i, c0805c, interfaceC0807e, C0804b.f1974a, i2, false, str);
    }

    private C0771w(int i, C0805c c0805c, InterfaceC0807e interfaceC0807e, InterfaceC0807e interfaceC0807e2, int i2, boolean z, String str) {
        if (c0805c == null) {
            throw new NullPointerException("result == null");
        }
        if (interfaceC0807e == null) {
            throw new NullPointerException("sources == null");
        }
        if (interfaceC0807e2 == null) {
            throw new NullPointerException("exceptions == null");
        }
        if (i2 <= 0 || i2 > 6) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        if (interfaceC0807e2.mo759d_() != 0 && i2 != 6) {
            throw new IllegalArgumentException("exceptions / branchingness mismatch");
        }
        this.f1679a = i;
        this.f1680b = c0805c;
        this.f1681c = interfaceC0807e;
        this.f1682d = interfaceC0807e2;
        this.f1683e = i2;
        this.f1684f = z;
        this.f1685g = str;
    }

    public C0771w(int i, C0805c c0805c, InterfaceC0807e interfaceC0807e, InterfaceC0807e interfaceC0807e2, String str) {
        this(i, c0805c, interfaceC0807e, interfaceC0807e2, 6, false, str);
    }

    public C0771w(int i, C0805c c0805c, InterfaceC0807e interfaceC0807e, String str) {
        this(i, c0805c, interfaceC0807e, C0804b.f1974a, 1, false, str);
    }

    public C0771w(int i, InterfaceC0807e interfaceC0807e, InterfaceC0807e interfaceC0807e2) {
        this(i, C0805c.f2018i, interfaceC0807e, interfaceC0807e2, 6, true, null);
    }

    /* JADX INFO: renamed from: a */
    public final int m1574a() {
        return this.f1679a;
    }

    /* JADX INFO: renamed from: b */
    public final C0805c m1575b() {
        return this.f1680b;
    }

    /* JADX INFO: renamed from: c */
    public final InterfaceC0807e m1576c() {
        return this.f1681c;
    }

    /* JADX INFO: renamed from: d */
    public final int m1577d() {
        return this.f1683e;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m1578e() {
        return this.f1684f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0771w)) {
            return false;
        }
        C0771w c0771w = (C0771w) obj;
        return this.f1679a == c0771w.f1679a && this.f1683e == c0771w.f1683e && this.f1680b == c0771w.f1680b && this.f1681c.equals(c0771w.f1681c) && this.f1682d.equals(c0771w.f1682d);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m1579f() {
        switch (this.f1679a) {
            case 14:
            case 16:
            case 20:
            case 21:
            case 22:
                return true;
            case 15:
            case 17:
            case 18:
            case 19:
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: g */
    public final String m1580g() {
        return this.f1685g != null ? this.f1685g : toString();
    }

    /* JADX INFO: renamed from: h */
    public final boolean m1581h() {
        return this.f1682d.mo759d_() != 0;
    }

    public final int hashCode() {
        return (((((((this.f1679a * 31) + this.f1683e) * 31) + this.f1680b.hashCode()) * 31) + this.f1681c.hashCode()) * 31) + this.f1682d.hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append("Rop{");
        stringBuffer.append(C0985a.m2291q(this.f1679a));
        if (this.f1680b != C0805c.f2018i) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f1680b);
        } else {
            stringBuffer.append(" .");
        }
        stringBuffer.append(" <-");
        int iMo759d_ = this.f1681c.mo759d_();
        if (iMo759d_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < iMo759d_; i++) {
                stringBuffer.append(' ');
                stringBuffer.append(this.f1681c.mo756a(i));
            }
        }
        if (this.f1684f) {
            stringBuffer.append(" call");
        }
        int iMo759d_2 = this.f1682d.mo759d_();
        if (iMo759d_2 == 0) {
            switch (this.f1683e) {
                case 1:
                    stringBuffer.append(" flows");
                    break;
                case 2:
                    stringBuffer.append(" returns");
                    break;
                case 3:
                    stringBuffer.append(" gotos");
                    break;
                case 4:
                    stringBuffer.append(" ifs");
                    break;
                case 5:
                    stringBuffer.append(" switches");
                    break;
                default:
                    stringBuffer.append(" " + C0985a.m2298x(this.f1683e));
                    break;
            }
        } else {
            stringBuffer.append(" throws");
            for (int i2 = 0; i2 < iMo759d_2; i2++) {
                stringBuffer.append(' ');
                if (this.f1682d.mo756a(i2) == C0805c.f2026q) {
                    stringBuffer.append("<any>");
                } else {
                    stringBuffer.append(this.f1682d.mo756a(i2));
                }
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
