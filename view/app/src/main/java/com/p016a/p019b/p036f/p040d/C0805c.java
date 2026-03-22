package com.p016a.p019b.p036f.p040d;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import jadx.core.deobf.Deobfuscator;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.f.d.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0805c implements InterfaceC0806d, Comparable {

    /* JADX INFO: renamed from: A */
    public static final C0805c f2000A;

    /* JADX INFO: renamed from: B */
    public static final C0805c f2001B;

    /* JADX INFO: renamed from: C */
    public static final C0805c f2002C;

    /* JADX INFO: renamed from: D */
    public static final C0805c f2003D;

    /* JADX INFO: renamed from: E */
    public static final C0805c f2004E;

    /* JADX INFO: renamed from: F */
    public static final C0805c f2005F;

    /* JADX INFO: renamed from: G */
    public static final C0805c f2006G;

    /* JADX INFO: renamed from: H */
    public static final C0805c f2007H;

    /* JADX INFO: renamed from: I */
    public static final C0805c f2008I;

    /* JADX INFO: renamed from: J */
    private static final HashMap f2009J = new HashMap(500);

    /* JADX INFO: renamed from: a */
    public static final C0805c f2010a = new C0805c("Z", 1);

    /* JADX INFO: renamed from: b */
    public static final C0805c f2011b = new C0805c("B", 2);

    /* JADX INFO: renamed from: c */
    public static final C0805c f2012c = new C0805c("C", 3);

    /* JADX INFO: renamed from: d */
    public static final C0805c f2013d = new C0805c("D", 4);

    /* JADX INFO: renamed from: e */
    public static final C0805c f2014e = new C0805c("F", 5);

    /* JADX INFO: renamed from: f */
    public static final C0805c f2015f = new C0805c("I", 6);

    /* JADX INFO: renamed from: g */
    public static final C0805c f2016g = new C0805c("J", 7);

    /* JADX INFO: renamed from: h */
    public static final C0805c f2017h = new C0805c("S", 8);

    /* JADX INFO: renamed from: i */
    public static final C0805c f2018i = new C0805c("V", 0);

    /* JADX INFO: renamed from: j */
    public static final C0805c f2019j = new C0805c("<null>", 9);

    /* JADX INFO: renamed from: k */
    public static final C0805c f2020k = new C0805c("<addr>", 10);

    /* JADX INFO: renamed from: l */
    public static final C0805c f2021l;

    /* JADX INFO: renamed from: m */
    public static final C0805c f2022m;

    /* JADX INFO: renamed from: n */
    public static final C0805c f2023n;

    /* JADX INFO: renamed from: o */
    public static final C0805c f2024o;

    /* JADX INFO: renamed from: p */
    public static final C0805c f2025p;

    /* JADX INFO: renamed from: q */
    public static final C0805c f2026q;

    /* JADX INFO: renamed from: r */
    public static final C0805c f2027r;

    /* JADX INFO: renamed from: s */
    public static final C0805c f2028s;

    /* JADX INFO: renamed from: t */
    public static final C0805c f2029t;

    /* JADX INFO: renamed from: u */
    public static final C0805c f2030u;

    /* JADX INFO: renamed from: v */
    public static final C0805c f2031v;

    /* JADX INFO: renamed from: w */
    public static final C0805c f2032w;

    /* JADX INFO: renamed from: x */
    public static final C0805c f2033x;

    /* JADX INFO: renamed from: y */
    public static final C0805c f2034y;

    /* JADX INFO: renamed from: z */
    public static final C0805c f2035z;

    /* JADX INFO: renamed from: K */
    private final String f2036K;

    /* JADX INFO: renamed from: L */
    private final int f2037L;

    /* JADX INFO: renamed from: M */
    private final int f2038M;

    /* JADX INFO: renamed from: N */
    private String f2039N;

    /* JADX INFO: renamed from: O */
    private C0805c f2040O;

    /* JADX INFO: renamed from: P */
    private C0805c f2041P;

    /* JADX INFO: renamed from: Q */
    private C0805c f2042Q;

    static {
        m1680b(f2010a);
        m1680b(f2011b);
        m1680b(f2012c);
        m1680b(f2013d);
        m1680b(f2014e);
        m1680b(f2015f);
        m1680b(f2016g);
        m1680b(f2017h);
        m1679a("Ljava/lang/annotation/Annotation;");
        f2021l = m1679a("Ljava/lang/Class;");
        f2022m = m1679a("Ljava/lang/Cloneable;");
        f2023n = m1679a("Ljava/lang/Object;");
        f2024o = m1679a("Ljava/io/Serializable;");
        f2025p = m1679a("Ljava/lang/String;");
        f2026q = m1679a("Ljava/lang/Throwable;");
        f2027r = m1679a("Ljava/lang/Boolean;");
        f2028s = m1679a("Ljava/lang/Byte;");
        f2029t = m1679a("Ljava/lang/Character;");
        f2030u = m1679a("Ljava/lang/Double;");
        f2031v = m1679a("Ljava/lang/Float;");
        f2032w = m1679a("Ljava/lang/Integer;");
        f2033x = m1679a("Ljava/lang/Long;");
        f2034y = m1679a("Ljava/lang/Short;");
        f2035z = m1679a("Ljava/lang/Void;");
        f2000A = f2010a.m1696r();
        f2001B = f2011b.m1696r();
        f2002C = f2012c.m1696r();
        f2003D = f2013d.m1696r();
        f2004E = f2014e.m1696r();
        f2005F = f2015f.m1696r();
        f2006G = f2016g.m1696r();
        f2007H = f2023n.m1696r();
        f2008I = f2017h.m1696r();
    }

    private C0805c(String str, int i) {
        this(str, i, -1);
    }

    private C0805c(String str, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        if (i < 0 || i >= 11) {
            throw new IllegalArgumentException("bad basicType");
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("newAt < -1");
        }
        this.f2036K = str;
        this.f2037L = i;
        this.f2038M = i2;
        this.f2040O = null;
        this.f2041P = null;
        this.f2042Q = null;
    }

    /* JADX INFO: renamed from: a */
    public static C0805c m1679a(String str) {
        C0805c c0805c;
        synchronized (f2009J) {
            c0805c = (C0805c) f2009J.get(str);
        }
        if (c0805c != null) {
            return c0805c;
        }
        try {
            char cCharAt = str.charAt(0);
            if (cCharAt == '[') {
                return m1679a(str.substring(1)).m1696r();
            }
            int length = str.length();
            if (cCharAt != 'L' || str.charAt(length - 1) != ';') {
                throw new IllegalArgumentException("bad descriptor: " + str);
            }
            int i = length - 1;
            for (int i2 = 1; i2 < i; i2++) {
                switch (str.charAt(i2)) {
                    case '(':
                    case ')':
                    case '.':
                    case C0299R.styleable.AppCompatTheme_activityChooserViewStyle /* 59 */:
                    case C0299R.styleable.AppCompatTheme_colorButtonNormal /* 91 */:
                        throw new IllegalArgumentException("bad descriptor: " + str);
                    case '/':
                        if (i2 == 1 || i2 == i || str.charAt(i2 - 1) == '/') {
                            throw new IllegalArgumentException("bad descriptor: " + str);
                        }
                        break;
                }
            }
            return m1680b(new C0805c(str, 9));
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("descriptor is empty");
        } catch (NullPointerException e2) {
            throw new NullPointerException("descriptor == null");
        }
    }

    /* JADX INFO: renamed from: b */
    private static C0805c m1680b(C0805c c0805c) {
        synchronized (f2009J) {
            String str = c0805c.f2036K;
            C0805c c0805c2 = (C0805c) f2009J.get(str);
            if (c0805c2 != null) {
                return c0805c2;
            }
            f2009J.put(str, c0805c);
            return c0805c;
        }
    }

    /* JADX INFO: renamed from: b */
    public static C0805c m1681b(String str) {
        try {
            return str.equals("V") ? f2018i : m1679a(str);
        } catch (NullPointerException e) {
            throw new NullPointerException("descriptor == null");
        }
    }

    /* JADX INFO: renamed from: c */
    public static C0805c m1682c(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        return str.startsWith("[") ? m1679a(str) : m1679a("L" + str + ';');
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0805c c0805c) {
        return this.f2036K.compareTo(c0805c.f2036K);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final C0805c m1684a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("newAt < 0");
        }
        if (!m1692n()) {
            throw new IllegalArgumentException("not a reference type: " + this.f2036K);
        }
        if (m1694p()) {
            throw new IllegalArgumentException("already uninitialized: " + this.f2036K);
        }
        C0805c c0805c = new C0805c("N" + C0985a.m2296v(i) + this.f2036K, 9, i);
        c0805c.f2042Q = this;
        return m1680b(c0805c);
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ InterfaceC0806d mo664b() {
        switch (this.f2037L) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return f2015f;
            case 4:
            case 5:
            case 7:
            default:
                return this;
        }
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: c */
    public final int mo665c() {
        return this.f2037L;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        switch (this.f2037L) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "byte";
            case 3:
                return "char";
            case 4:
                return "double";
            case 5:
                return "float";
            case 6:
                return "int";
            case 7:
                return "long";
            case 8:
                return "short";
            case 9:
                return m1693o() ? m1697s().mo657d() + "[]" : m1686h().replace("/", Deobfuscator.CLASS_NAME_SEPARATOR);
            default:
                return this.f2036K;
        }
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: e */
    public final int mo666e() {
        switch (this.f2037L) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return 6;
            case 4:
            case 5:
            case 7:
            default:
                return this.f2037L;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0805c) {
            return this.f2036K.equals(((C0805c) obj).f2036K);
        }
        return false;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: f */
    public final boolean mo667f() {
        return false;
    }

    /* JADX INFO: renamed from: g */
    public final String m1685g() {
        return this.f2036K;
    }

    /* JADX INFO: renamed from: h */
    public final String m1686h() {
        if (this.f2039N == null) {
            if (!m1692n()) {
                throw new IllegalArgumentException("not an object type: " + this.f2036K);
            }
            if (this.f2036K.charAt(0) == '[') {
                this.f2039N = this.f2036K;
            } else {
                this.f2039N = this.f2036K.substring(1, this.f2036K.length() - 1);
            }
        }
        return this.f2039N;
    }

    public final int hashCode() {
        return this.f2036K.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final int m1687i() {
        switch (this.f2037L) {
            case 4:
            case 7:
                return 2;
            case 5:
            case 6:
            default:
                return 1;
        }
    }

    /* JADX INFO: renamed from: j */
    public final boolean m1688j() {
        switch (this.f2037L) {
            case 4:
            case 7:
                return false;
            case 5:
            case 6:
            default:
                return true;
        }
    }

    /* JADX INFO: renamed from: k */
    public final boolean m1689k() {
        switch (this.f2037L) {
            case 4:
            case 7:
                return true;
            case 5:
            case 6:
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: l */
    public final boolean m1690l() {
        switch (this.f2037L) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return true;
            case 4:
            case 5:
            case 7:
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: m */
    public final boolean m1691m() {
        switch (this.f2037L) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: n */
    public final boolean m1692n() {
        return this.f2037L == 9;
    }

    /* JADX INFO: renamed from: o */
    public final boolean m1693o() {
        return this.f2036K.charAt(0) == '[';
    }

    /* JADX INFO: renamed from: p */
    public final boolean m1694p() {
        return this.f2038M >= 0;
    }

    /* JADX INFO: renamed from: q */
    public final C0805c m1695q() {
        if (this.f2042Q == null) {
            throw new IllegalArgumentException("initialized type: " + this.f2036K);
        }
        return this.f2042Q;
    }

    /* JADX INFO: renamed from: r */
    public final C0805c m1696r() {
        if (this.f2040O == null) {
            this.f2040O = m1680b(new C0805c("[" + this.f2036K, 9));
        }
        return this.f2040O;
    }

    /* JADX INFO: renamed from: s */
    public final C0805c m1697s() {
        if (this.f2041P == null) {
            if (this.f2036K.charAt(0) != '[') {
                throw new IllegalArgumentException("not an array type: " + this.f2036K);
            }
            this.f2041P = m1679a(this.f2036K.substring(1));
        }
        return this.f2041P;
    }

    public final String toString() {
        return this.f2036K;
    }
}
