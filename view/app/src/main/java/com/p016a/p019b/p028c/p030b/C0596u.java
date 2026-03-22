package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;

/* JADX INFO: renamed from: com.a.b.c.b.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0596u implements Comparable {

    /* JADX INFO: renamed from: a */
    private final int f1025a;

    /* JADX INFO: renamed from: b */
    private final EnumC0595t f1026b;

    /* JADX INFO: renamed from: c */
    private final C0766r f1027c;

    /* JADX INFO: renamed from: d */
    private final C0802z f1028d;

    public C0596u(int i, EnumC0595t enumC0595t, C0766r c0766r) {
        if (i < 0) {
            throw new IllegalArgumentException("address < 0");
        }
        if (enumC0595t == null) {
            throw new NullPointerException("disposition == null");
        }
        try {
            if (c0766r.m1535i() == null) {
                throw new NullPointerException("spec.getLocalItem() == null");
            }
            this.f1025a = i;
            this.f1026b = enumC0595t;
            this.f1027c = c0766r;
            this.f1028d = C0802z.m1654b(c0766r.mo663a());
        } catch (NullPointerException e) {
            throw new NullPointerException("spec == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0596u c0596u) {
        if (this.f1025a < c0596u.f1025a) {
            return -1;
        }
        if (this.f1025a > c0596u.f1025a) {
            return 1;
        }
        boolean zM1014c = m1014c();
        return zM1014c != c0596u.m1014c() ? zM1014c ? 1 : -1 : this.f1027c.compareTo(c0596u.f1027c);
    }

    /* JADX INFO: renamed from: a */
    public final int m1009a() {
        return this.f1025a;
    }

    /* JADX INFO: renamed from: a */
    public final C0596u m1010a(EnumC0595t enumC0595t) {
        return enumC0595t == this.f1026b ? this : new C0596u(this.f1025a, enumC0595t, this.f1027c);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1011a(C0596u c0596u) {
        return m1012a(c0596u.f1027c);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1012a(C0766r c0766r) {
        return this.f1027c.m1529a(c0766r);
    }

    /* JADX INFO: renamed from: b */
    public final EnumC0595t m1013b() {
        return this.f1026b;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1014c() {
        return this.f1026b == EnumC0595t.f1019a;
    }

    /* JADX INFO: renamed from: d */
    public final C0801y m1015d() {
        return this.f1027c.m1535i().m1505a();
    }

    /* JADX INFO: renamed from: e */
    public final C0801y m1016e() {
        return this.f1027c.m1535i().m1506b();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0596u) && compareTo((C0596u) obj) == 0;
    }

    /* JADX INFO: renamed from: f */
    public final C0802z m1017f() {
        return this.f1028d;
    }

    /* JADX INFO: renamed from: g */
    public final int m1018g() {
        return this.f1027c.m1533g();
    }

    /* JADX INFO: renamed from: h */
    public final C0766r m1019h() {
        return this.f1027c;
    }

    public final String toString() {
        return Integer.toHexString(this.f1025a) + " " + this.f1026b + " " + this.f1027c;
    }
}
