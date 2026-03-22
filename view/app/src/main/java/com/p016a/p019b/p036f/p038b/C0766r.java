package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import com.p016a.p019b.p043h.InterfaceC0889s;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.f.b.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0766r implements InterfaceC0806d, InterfaceC0889s, Comparable {

    /* JADX INFO: renamed from: a */
    private static final HashMap f1663a = new HashMap(1000);

    /* JADX INFO: renamed from: b */
    private static final C0767s f1664b = new C0767s(0);

    /* JADX INFO: renamed from: c */
    private final int f1665c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC0806d f1666d;

    /* JADX INFO: renamed from: e */
    private final C0761m f1667e;

    private C0766r(int i, InterfaceC0806d interfaceC0806d, C0761m c0761m) {
        if (i < 0) {
            throw new IllegalArgumentException("reg < 0");
        }
        if (interfaceC0806d == null) {
            throw new NullPointerException("type == null");
        }
        this.f1665c = i;
        this.f1666d = interfaceC0806d;
        this.f1667e = c0761m;
    }

    /* synthetic */ C0766r(int i, InterfaceC0806d interfaceC0806d, C0761m c0761m, byte b2) {
        this(i, interfaceC0806d, c0761m);
    }

    /* JADX INFO: renamed from: a */
    public static C0766r m1516a(int i, InterfaceC0806d interfaceC0806d) {
        return m1522d(i, interfaceC0806d, null);
    }

    /* JADX INFO: renamed from: a */
    public static C0766r m1517a(int i, InterfaceC0806d interfaceC0806d, C0761m c0761m) {
        if (c0761m == null) {
            throw new NullPointerException("local  == null");
        }
        return m1522d(i, interfaceC0806d, c0761m);
    }

    /* JADX INFO: renamed from: a */
    private String m1518a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append(m1539m());
        stringBuffer.append(":");
        if (this.f1667e != null) {
            stringBuffer.append(this.f1667e.toString());
        }
        C0805c c0805cMo663a = this.f1666d.mo663a();
        stringBuffer.append(c0805cMo663a);
        if (c0805cMo663a != this.f1666d) {
            stringBuffer.append("=");
            if (z && (this.f1666d instanceof C0801y)) {
                stringBuffer.append(((C0801y) this.f1666d).m1648i());
            } else if (z && (this.f1666d instanceof AbstractC0775a)) {
                stringBuffer.append(this.f1666d.mo657d());
            } else {
                stringBuffer.append(this.f1666d);
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: b */
    public static C0766r m1520b(int i, InterfaceC0806d interfaceC0806d, C0761m c0761m) {
        return m1522d(i, interfaceC0806d, c0761m);
    }

    /* JADX INFO: renamed from: d */
    private static C0766r m1522d(int i, InterfaceC0806d interfaceC0806d, C0761m c0761m) {
        C0766r c0766rM1544a;
        synchronized (f1663a) {
            f1664b.m1545a(i, interfaceC0806d, c0761m);
            c0766rM1544a = (C0766r) f1663a.get(f1664b);
            if (c0766rM1544a == null) {
                c0766rM1544a = f1664b.m1544a();
                f1663a.put(c0766rM1544a, c0766rM1544a);
            }
        }
        return c0766rM1544a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public boolean m1523e(int i, InterfaceC0806d interfaceC0806d, C0761m c0761m) {
        return this.f1665c == i && this.f1666d.equals(interfaceC0806d) && (this.f1667e == c0761m || (this.f1667e != null && this.f1667e.equals(c0761m)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public static int m1524f(int i, InterfaceC0806d interfaceC0806d, C0761m c0761m) {
        return ((((c0761m != null ? c0761m.hashCode() : 0) * 31) + interfaceC0806d.hashCode()) * 31) + i;
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1525a(int i) {
        return this.f1665c == i ? this : m1522d(i, this.f1666d, this.f1667e);
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1526a(C0761m c0761m) {
        return this.f1667e != c0761m ? (this.f1667e == null || !this.f1667e.equals(c0761m)) ? m1522d(this.f1665c, this.f1666d, c0761m) : this : this;
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1527a(C0766r c0766r, boolean z) {
        InterfaceC0806d interfaceC0806dMo663a;
        if (this == c0766r) {
            return this;
        }
        if (c0766r == null || this.f1665c != c0766r.f1665c) {
            return null;
        }
        C0761m c0761m = (this.f1667e == null || !this.f1667e.equals(c0766r.f1667e)) ? null : this.f1667e;
        boolean z2 = c0761m == this.f1667e;
        if ((z && !z2) || (interfaceC0806dMo663a = mo663a()) != c0766r.mo663a()) {
            return null;
        }
        if (this.f1666d.equals(c0766r.f1666d)) {
            interfaceC0806dMo663a = this.f1666d;
        }
        return (interfaceC0806dMo663a == this.f1666d && z2) ? this : c0761m == null ? m1522d(this.f1665c, interfaceC0806dMo663a, null) : m1517a(this.f1665c, interfaceC0806dMo663a, c0761m);
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1528a(InterfaceC0806d interfaceC0806d) {
        return m1522d(this.f1665c, interfaceC0806d, this.f1667e);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return this.f1666d.mo663a();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1529a(C0766r c0766r) {
        return m1531b(c0766r) && this.f1665c == c0766r.f1665c;
    }

    /* JADX INFO: renamed from: b */
    public final C0766r m1530b(int i) {
        return i == 0 ? this : m1525a(this.f1665c + i);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: b */
    public final InterfaceC0806d mo664b() {
        return this.f1666d.mo664b();
    }

    /* JADX INFO: renamed from: b */
    public final boolean m1531b(C0766r c0766r) {
        if (c0766r != null && this.f1666d.mo663a().equals(c0766r.f1666d.mo663a())) {
            return this.f1667e == c0766r.f1667e || (this.f1667e != null && this.f1667e.equals(c0766r.f1667e));
        }
        return false;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: c */
    public final int mo665c() {
        return this.f1666d.mo665c();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0766r c0766r) {
        if (this.f1665c < c0766r.f1665c) {
            return -1;
        }
        if (this.f1665c > c0766r.f1665c) {
            return 1;
        }
        int iCompareTo = this.f1666d.mo663a().compareTo(c0766r.f1666d.mo663a());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (this.f1667e == null) {
            return c0766r.f1667e == null ? 0 : -1;
        }
        if (c0766r.f1667e == null) {
            return 1;
        }
        return this.f1667e.compareTo(c0766r.f1667e);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return m1518a(true);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: e */
    public final int mo666e() {
        return this.f1666d.mo666e();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0766r) {
            C0766r c0766r = (C0766r) obj;
            return m1523e(c0766r.f1665c, c0766r.f1666d, c0766r.f1667e);
        }
        if (!(obj instanceof C0767s)) {
            return false;
        }
        C0767s c0767s = (C0767s) obj;
        return m1523e(c0767s.f1668a, c0767s.f1669b, c0767s.f1670c);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: f */
    public final boolean mo667f() {
        return false;
    }

    /* JADX INFO: renamed from: g */
    public final int m1533g() {
        return this.f1665c;
    }

    /* JADX INFO: renamed from: h */
    public final InterfaceC0806d m1534h() {
        return this.f1666d;
    }

    public final int hashCode() {
        return m1524f(this.f1665c, this.f1666d, this.f1667e);
    }

    /* JADX INFO: renamed from: i */
    public final C0761m m1535i() {
        return this.f1667e;
    }

    /* JADX INFO: renamed from: j */
    public final int m1536j() {
        return this.f1665c + m1537k();
    }

    /* JADX INFO: renamed from: k */
    public final int m1537k() {
        return this.f1666d.mo663a().m1687i();
    }

    /* JADX INFO: renamed from: l */
    public final boolean m1538l() {
        return this.f1666d.mo663a().m1689k();
    }

    /* JADX INFO: renamed from: m */
    public final String m1539m() {
        return "v" + this.f1665c;
    }

    /* JADX INFO: renamed from: n */
    public final C0766r m1540n() {
        InterfaceC0806d interfaceC0806d = this.f1666d;
        C0805c c0805cMo663a = interfaceC0806d instanceof C0805c ? (C0805c) interfaceC0806d : interfaceC0806d.mo663a();
        if (c0805cMo663a.m1694p()) {
            c0805cMo663a = c0805cMo663a.m1695q();
        }
        return c0805cMo663a == interfaceC0806d ? this : m1522d(this.f1665c, c0805cMo663a, this.f1667e);
    }

    public final String toString() {
        return m1518a(false);
    }
}
