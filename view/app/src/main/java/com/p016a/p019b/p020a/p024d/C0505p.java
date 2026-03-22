package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p021a.C0428a;
import com.p016a.p019b.p020a.p021a.C0429b;
import com.p016a.p019b.p020a.p021a.C0430c;
import com.p016a.p019b.p020a.p021a.C0431d;
import com.p016a.p019b.p020a.p021a.C0432e;
import com.p016a.p019b.p020a.p021a.C0433f;
import com.p016a.p019b.p020a.p021a.C0434g;
import com.p016a.p019b.p020a.p021a.C0435h;
import com.p016a.p019b.p020a.p021a.C0436i;
import com.p016a.p019b.p020a.p021a.C0437j;
import com.p016a.p019b.p020a.p021a.C0438k;
import com.p016a.p019b.p020a.p021a.C0439l;
import com.p016a.p019b.p020a.p021a.C0440m;
import com.p016a.p019b.p020a.p021a.C0441n;
import com.p016a.p019b.p020a.p021a.C0442o;
import com.p016a.p019b.p020a.p021a.C0443p;
import com.p016a.p019b.p020a.p021a.C0444q;
import com.p016a.p019b.p020a.p021a.C0448u;
import com.p016a.p019b.p020a.p022b.C0467e;
import com.p016a.p019b.p020a.p022b.C0470h;
import com.p016a.p019b.p020a.p022b.C0477o;
import com.p016a.p019b.p020a.p022b.C0479q;
import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p020a.p025e.C0514i;
import com.p016a.p019b.p020a.p025e.C0516k;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p036f.p037a.EnumC0741b;
import com.p016a.p019b.p036f.p039c.AbstractC0777ab;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p039c.InterfaceC0778b;
import com.p016a.p019b.p043h.C0873c;
import com.p016a.p019b.p043h.C0874d;
import java.io.IOException;

/* JADX INFO: renamed from: com.a.b.a.d.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0505p extends C0491b {

    /* JADX INFO: renamed from: a */
    public static final C0505p f649a = new C0505p();

    /* JADX INFO: renamed from: a */
    private static C0479q m771a(C0873c c0873c, InterfaceC0778b interfaceC0778b, InterfaceC0515j interfaceC0515j, int i, boolean z) {
        C0801y c0801y;
        C0801y c0801y2;
        if (c0873c.m1957a() != i * 10) {
            m777c((i * 10) + 2);
        }
        C0874d c0874dM1962b = c0873c.m1962b();
        C0479q c0479q = new C0479q(i);
        for (int i2 = 0; i2 < i; i2++) {
            try {
                int unsignedShort = c0874dM1962b.readUnsignedShort();
                int unsignedShort2 = c0874dM1962b.readUnsignedShort();
                int unsignedShort3 = c0874dM1962b.readUnsignedShort();
                int unsignedShort4 = c0874dM1962b.readUnsignedShort();
                int unsignedShort5 = c0874dM1962b.readUnsignedShort();
                C0801y c0801y3 = (C0801y) interfaceC0778b.mo1607a(unsignedShort3);
                C0801y c0801y4 = (C0801y) interfaceC0778b.mo1607a(unsignedShort4);
                if (z) {
                    c0801y = c0801y4;
                    c0801y2 = null;
                } else {
                    c0801y = null;
                    c0801y2 = c0801y4;
                }
                c0479q.m636a(i2, unsignedShort, unsignedShort2, c0801y3, c0801y2, c0801y, unsignedShort5);
                if (interfaceC0515j != null) {
                    new StringBuilder().append(C0985a.m2296v(unsignedShort)).append("..").append(C0985a.m2296v(unsignedShort + unsignedShort2)).append(" ").append(C0985a.m2296v(unsignedShort5)).append(" ").append(c0801y3.mo657d()).append(" ").append(c0801y4.mo657d());
                }
            } catch (IOException e) {
                throw new RuntimeException("shouldn't happen", e);
            }
        }
        c0479q.mo549b_();
        return c0479q;
    }

    /* JADX INFO: renamed from: a */
    private static AbstractC0506a m772a() {
        throw new C0514i("severely truncated attribute");
    }

    /* JADX INFO: renamed from: a */
    private static AbstractC0506a m773a(int i) {
        return i != 0 ? m777c(0) : new C0431d();
    }

    /* JADX INFO: renamed from: b */
    private static AbstractC0506a m774b() {
        throw new C0514i("truncated attribute");
    }

    /* JADX INFO: renamed from: b */
    private static AbstractC0506a m775b(int i) {
        return i != 0 ? m777c(0) : new C0444q();
    }

    /* JADX INFO: renamed from: b */
    private AbstractC0506a m776b(C0500k c0500k, int i, int i2, InterfaceC0515j interfaceC0515j) {
        if (i2 < 12) {
            return m772a();
        }
        C0873c c0873cM745b = c0500k.m745b();
        InterfaceC0778b interfaceC0778bM750g = c0500k.m750g();
        int iM1966f = c0873cM745b.m1966f(i);
        int iM1966f2 = c0873cM745b.m1966f(i + 2);
        int iM1963c = c0873cM745b.m1963c(i + 4);
        if (interfaceC0515j != null) {
            new StringBuilder("max_stack: ").append(C0985a.m2296v(iM1966f));
            new StringBuilder("max_locals: ").append(C0985a.m2296v(iM1966f2));
            new StringBuilder("code_length: ").append(C0985a.m2294t(iM1963c));
        }
        int i3 = i + 8;
        int i4 = i2 - 8;
        if (i4 < iM1963c + 4) {
            return m774b();
        }
        int i5 = i3 + iM1963c;
        int i6 = i4 - iM1963c;
        C0470h c0470h = new C0470h(c0873cM745b.m1959a(i3, iM1963c + i3), interfaceC0778bM750g);
        if (interfaceC0515j != null) {
            c0470h.m579a(new C0499j(c0470h.m578a(), interfaceC0515j));
        }
        int iM1966f3 = c0873cM745b.m1966f(i5);
        C0467e c0467e = iM1966f3 == 0 ? C0467e.f545a : new C0467e(iM1966f3);
        if (interfaceC0515j != null) {
            new StringBuilder("exception_table_length: ").append(C0985a.m2296v(iM1966f3));
        }
        int i7 = i5 + 2;
        int i8 = i6 - 2;
        if (i8 < (iM1966f3 << 3) + 2) {
            return m774b();
        }
        int i9 = 0;
        int i10 = i8;
        int i11 = i7;
        while (i9 < iM1966f3) {
            int iM1966f4 = c0873cM745b.m1966f(i11);
            int iM1966f5 = c0873cM745b.m1966f(i11 + 2);
            int iM1966f6 = c0873cM745b.m1966f(i11 + 4);
            C0802z c0802z = (C0802z) interfaceC0778bM750g.mo1609b(c0873cM745b.m1966f(i11 + 6));
            c0467e.m567a(i9, iM1966f4, iM1966f5, iM1966f6, c0802z);
            if (interfaceC0515j != null) {
                new StringBuilder().append(C0985a.m2296v(iM1966f4)).append("..").append(C0985a.m2296v(iM1966f5)).append(" -> ").append(C0985a.m2296v(iM1966f6)).append(" ").append(c0802z == null ? "<any>" : c0802z.mo657d());
            }
            i9++;
            i10 -= 8;
            i11 += 8;
        }
        c0467e.mo549b_();
        C0492c c0492c = new C0492c(c0500k, 3, i11, this);
        c0492c.m724a(interfaceC0515j);
        C0516k c0516kM725b = c0492c.m725b();
        c0516kM725b.mo549b_();
        int iM723a = c0492c.m723a() - i11;
        return iM723a != i10 ? m777c((i11 - i) + iM723a) : new C0429b(iM1966f, iM1966f2, c0470h, c0467e, c0516kM725b);
    }

    /* JADX INFO: renamed from: c */
    private static AbstractC0506a m777c(int i) {
        throw new C0514i("bad attribute length; expected length " + C0985a.m2294t(i));
    }

    /* JADX INFO: renamed from: c */
    private static AbstractC0506a m778c(C0500k c0500k, int i, int i2, InterfaceC0515j interfaceC0515j) {
        if (i2 < 2) {
            return m772a();
        }
        C0873c c0873cM745b = c0500k.m745b();
        InterfaceC0778b interfaceC0778bM750g = c0500k.m750g();
        int iM1966f = c0873cM745b.m1966f(i);
        if (interfaceC0515j != null) {
            new StringBuilder("number_of_classes: ").append(C0985a.m2296v(iM1966f));
        }
        int i3 = i + 2;
        if (i2 - 2 != (iM1966f << 3)) {
            m777c((iM1966f << 3) + 2);
        }
        C0448u c0448u = new C0448u(iM1966f);
        int i4 = 0;
        int i5 = i3;
        while (i4 < iM1966f) {
            int iM1966f2 = c0873cM745b.m1966f(i5);
            int iM1966f3 = c0873cM745b.m1966f(i5 + 2);
            int iM1966f4 = c0873cM745b.m1966f(i5 + 4);
            int iM1966f5 = c0873cM745b.m1966f(i5 + 6);
            C0802z c0802z = (C0802z) interfaceC0778bM750g.mo1607a(iM1966f2);
            C0802z c0802z2 = (C0802z) interfaceC0778bM750g.mo1609b(iM1966f3);
            C0801y c0801y = (C0801y) interfaceC0778bM750g.mo1609b(iM1966f4);
            c0448u.m462a(i4, c0802z, c0802z2, c0801y, iM1966f5);
            if (interfaceC0515j != null) {
                new StringBuilder("inner_class: ").append(C0500k.m735a(c0802z));
                new StringBuilder("  outer_class: ").append(C0500k.m735a(c0802z2));
                new StringBuilder("  name: ").append(C0500k.m735a(c0801y));
                new StringBuilder("  access_flags: ").append(C0985a.m2276h(iM1966f5));
            }
            i4++;
            i5 += 8;
        }
        c0448u.mo549b_();
        return new C0434g(c0448u);
    }

    /* JADX INFO: renamed from: d */
    private static AbstractC0506a m779d(C0500k c0500k, int i, int i2, InterfaceC0515j interfaceC0515j) {
        if (i2 < 2) {
            return m772a();
        }
        C0873c c0873cM745b = c0500k.m745b();
        int iM1966f = c0873cM745b.m1966f(i);
        if (interfaceC0515j != null) {
            new StringBuilder("line_number_table_length: ").append(C0985a.m2296v(iM1966f));
        }
        int i3 = i + 2;
        if (i2 - 2 != (iM1966f << 2)) {
            m777c((iM1966f << 2) + 2);
        }
        C0477o c0477o = new C0477o(iM1966f);
        for (int i4 = 0; i4 < iM1966f; i4++) {
            int iM1966f2 = c0873cM745b.m1966f(i3);
            int iM1966f3 = c0873cM745b.m1966f(i3 + 2);
            c0477o.m628a(i4, iM1966f2, iM1966f3);
            if (interfaceC0515j != null) {
                new StringBuilder().append(C0985a.m2296v(iM1966f2)).append(" ").append(iM1966f3);
            }
            i3 += 4;
        }
        c0477o.mo549b_();
        return new C0435h(c0477o);
    }

    /* JADX INFO: renamed from: e */
    private static AbstractC0506a m780e(C0500k c0500k, int i, int i2, InterfaceC0515j interfaceC0515j) {
        if (i2 < 2) {
            m772a();
        }
        return new C0438k(new C0490a(c0500k, i, i2, interfaceC0515j).m719b(EnumC0741b.BUILD), i2);
    }

    /* JADX INFO: renamed from: f */
    private static AbstractC0506a m781f(C0500k c0500k, int i, int i2, InterfaceC0515j interfaceC0515j) {
        if (i2 < 2) {
            m772a();
        }
        return new C0440m(new C0490a(c0500k, i, i2, interfaceC0515j).m719b(EnumC0741b.RUNTIME), i2);
    }

    /* JADX INFO: renamed from: g */
    private static AbstractC0506a m782g(C0500k c0500k, int i, int i2, InterfaceC0515j interfaceC0515j) {
        if (i2 != 2) {
            m777c(2);
        }
        C0801y c0801y = (C0801y) c0500k.m750g().mo1607a(c0500k.m745b().m1966f(i));
        C0442o c0442o = new C0442o(c0801y);
        if (interfaceC0515j != null) {
            new StringBuilder("signature: ").append(c0801y);
        }
        return c0442o;
    }

    @Override // com.p016a.p019b.p020a.p024d.C0491b
    /* JADX INFO: renamed from: a */
    protected final AbstractC0506a mo721a(C0500k c0500k, int i, String str, int i2, int i3, InterfaceC0515j interfaceC0515j) {
        switch (i) {
            case 0:
                if (str == "Deprecated") {
                    return m773a(i3);
                }
                if (str == "EnclosingMethod") {
                    if (i3 != 4) {
                        m777c(4);
                    }
                    C0873c c0873cM745b = c0500k.m745b();
                    InterfaceC0778b interfaceC0778bM750g = c0500k.m750g();
                    C0802z c0802z = (C0802z) interfaceC0778bM750g.mo1607a(c0873cM745b.m1966f(i2));
                    C0799w c0799w = (C0799w) interfaceC0778bM750g.mo1609b(c0873cM745b.m1966f(i2 + 2));
                    C0432e c0432e = new C0432e(c0802z, c0799w);
                    if (interfaceC0515j != null) {
                        new StringBuilder("class: ").append(c0802z);
                        new StringBuilder("method: ").append(C0500k.m735a(c0799w));
                    }
                    return c0432e;
                }
                if (str == "InnerClasses") {
                    return m778c(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return m780e(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return m781f(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "Synthetic") {
                    return m775b(i3);
                }
                if (str == "Signature") {
                    return m782g(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "SourceFile") {
                    if (i3 != 2) {
                        m777c(2);
                    }
                    C0801y c0801y = (C0801y) c0500k.m750g().mo1607a(c0500k.m745b().m1966f(i2));
                    C0443p c0443p = new C0443p(c0801y);
                    if (interfaceC0515j != null) {
                        new StringBuilder("source: ").append(c0801y);
                    }
                    return c0443p;
                }
                break;
            case 1:
                if (str == "ConstantValue") {
                    if (i3 != 2) {
                        return m777c(2);
                    }
                    AbstractC0777ab abstractC0777ab = (AbstractC0777ab) c0500k.m750g().mo1607a(c0500k.m745b().m1966f(i2));
                    C0430c c0430c = new C0430c(abstractC0777ab);
                    if (interfaceC0515j != null) {
                        new StringBuilder("value: ").append(abstractC0777ab);
                    }
                    return c0430c;
                }
                if (str == "Deprecated") {
                    return m773a(i3);
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return m780e(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return m781f(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "Signature") {
                    return m782g(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "Synthetic") {
                    return m775b(i3);
                }
                break;
            case 2:
                if (str == "AnnotationDefault") {
                    if (i3 < 2) {
                        m772a();
                    }
                    return new C0428a(new C0490a(c0500k, i2, i3, interfaceC0515j).m718a(), i3);
                }
                if (str == "Code") {
                    return m776b(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "Deprecated") {
                    return m773a(i3);
                }
                if (str == "Exceptions") {
                    if (i3 < 2) {
                        return m772a();
                    }
                    int iM1966f = c0500k.m745b().m1966f(i2);
                    if (interfaceC0515j != null) {
                        new StringBuilder("number_of_exceptions: ").append(C0985a.m2296v(iM1966f));
                    }
                    int i4 = i2 + 2;
                    if (i3 - 2 != (iM1966f << 1)) {
                        m777c((iM1966f << 1) + 2);
                    }
                    return new C0433f(c0500k.m742a(i4, iM1966f));
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return m780e(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return m781f(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "RuntimeInvisibleParameterAnnotations") {
                    if (i3 < 2) {
                        m772a();
                    }
                    return new C0439l(new C0490a(c0500k, i2, i3, interfaceC0515j).m717a(EnumC0741b.BUILD), i3);
                }
                if (str == "RuntimeVisibleParameterAnnotations") {
                    if (i3 < 2) {
                        m772a();
                    }
                    return new C0441n(new C0490a(c0500k, i2, i3, interfaceC0515j).m717a(EnumC0741b.RUNTIME), i3);
                }
                if (str == "Signature") {
                    return m782g(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "Synthetic") {
                    return m775b(i3);
                }
                break;
            case 3:
                if (str == "LineNumberTable") {
                    return m779d(c0500k, i2, i3, interfaceC0515j);
                }
                if (str == "LocalVariableTable") {
                    if (i3 < 2) {
                        return m772a();
                    }
                    C0873c c0873cM745b2 = c0500k.m745b();
                    int iM1966f2 = c0873cM745b2.m1966f(i2);
                    if (interfaceC0515j != null) {
                        new StringBuilder("local_variable_table_length: ").append(C0985a.m2296v(iM1966f2));
                    }
                    return new C0436i(m771a(c0873cM745b2.m1959a(i2 + 2, i2 + i3), c0500k.m750g(), interfaceC0515j, iM1966f2, false));
                }
                if (str == "LocalVariableTypeTable") {
                    if (i3 < 2) {
                        return m772a();
                    }
                    C0873c c0873cM745b3 = c0500k.m745b();
                    int iM1966f3 = c0873cM745b3.m1966f(i2);
                    if (interfaceC0515j != null) {
                        new StringBuilder("local_variable_type_table_length: ").append(C0985a.m2296v(iM1966f3));
                    }
                    return new C0437j(m771a(c0873cM745b3.m1959a(i2 + 2, i2 + i3), c0500k.m750g(), interfaceC0515j, iM1966f3, true));
                }
                break;
        }
        return super.mo721a(c0500k, i, str, i2, i3, interfaceC0515j);
    }
}
