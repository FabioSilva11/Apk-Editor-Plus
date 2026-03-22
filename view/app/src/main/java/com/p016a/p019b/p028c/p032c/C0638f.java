package com.p016a.p019b.p028c.p032c;

import com.p016a.p019b.p036f.p037a.C0740a;
import com.p016a.p019b.p036f.p037a.C0744e;
import com.p016a.p019b.p036f.p037a.EnumC0741b;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0779c;
import com.p016a.p019b.p036f.p039c.C0780d;
import com.p016a.p019b.p036f.p039c.C0781e;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0792p;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.c.c.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0638f {

    /* JADX INFO: renamed from: a */
    private static final C0802z f1124a = C0802z.m1654b(C0805c.m1679a("Ldalvik/annotation/AnnotationDefault;"));

    /* JADX INFO: renamed from: b */
    private static final C0802z f1125b = C0802z.m1654b(C0805c.m1679a("Ldalvik/annotation/EnclosingClass;"));

    /* JADX INFO: renamed from: c */
    private static final C0802z f1126c = C0802z.m1654b(C0805c.m1679a("Ldalvik/annotation/EnclosingMethod;"));

    /* JADX INFO: renamed from: d */
    private static final C0802z f1127d = C0802z.m1654b(C0805c.m1679a("Ldalvik/annotation/InnerClass;"));

    /* JADX INFO: renamed from: e */
    private static final C0802z f1128e = C0802z.m1654b(C0805c.m1679a("Ldalvik/annotation/MemberClasses;"));

    /* JADX INFO: renamed from: f */
    private static final C0802z f1129f = C0802z.m1654b(C0805c.m1679a("Ldalvik/annotation/Signature;"));

    /* JADX INFO: renamed from: g */
    private static final C0802z f1130g = C0802z.m1654b(C0805c.m1679a("Ldalvik/annotation/Throws;"));

    /* JADX INFO: renamed from: h */
    private static final C0801y f1131h = new C0801y("accessFlags");

    /* JADX INFO: renamed from: i */
    private static final C0801y f1132i = new C0801y("name");

    /* JADX INFO: renamed from: j */
    private static final C0801y f1133j = new C0801y("value");

    /* JADX INFO: renamed from: a */
    public static C0740a m1134a(C0740a c0740a) {
        C0740a c0740a2 = new C0740a(f1124a, EnumC0741b.SYSTEM);
        c0740a2.m1438a(new C0744e(f1133j, new C0779c(c0740a)));
        c0740a2.mo549b_();
        return c0740a2;
    }

    /* JADX INFO: renamed from: a */
    public static C0740a m1135a(C0798v c0798v) {
        C0740a c0740a = new C0740a(f1126c, EnumC0741b.SYSTEM);
        c0740a.m1438a(new C0744e(f1133j, c0798v));
        c0740a.mo549b_();
        return c0740a;
    }

    /* JADX INFO: renamed from: a */
    public static C0740a m1136a(C0801y c0801y) {
        C0740a c0740a = new C0740a(f1129f, EnumC0741b.SYSTEM);
        String strM1649j = c0801y.m1649j();
        int length = strM1649j.length();
        ArrayList arrayList = new ArrayList(20);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (strM1649j.charAt(i) == 'L') {
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    char cCharAt = strM1649j.charAt(i2);
                    if (cCharAt == ';') {
                        i2++;
                        break;
                    }
                    if (cCharAt != '<') {
                        i2++;
                    }
                }
            } else {
                while (i2 < length && strM1649j.charAt(i2) != 'L') {
                    i2++;
                }
            }
            arrayList.add(strM1649j.substring(i, i2));
            i = i2;
        }
        int size = arrayList.size();
        C0781e c0781e = new C0781e(size);
        for (int i3 = 0; i3 < size; i3++) {
            c0781e.m1615a(i3, (AbstractC0775a) new C0801y((String) arrayList.get(i3)));
        }
        c0781e.mo549b_();
        c0740a.m1438a(new C0744e(f1133j, new C0780d(c0781e)));
        c0740a.mo549b_();
        return c0740a;
    }

    /* JADX INFO: renamed from: a */
    public static C0740a m1137a(C0801y c0801y, int i) {
        C0740a c0740a = new C0740a(f1127d, EnumC0741b.SYSTEM);
        AbstractC0775a abstractC0775a = c0801y;
        if (c0801y == null) {
            abstractC0775a = C0792p.f1925a;
        }
        c0740a.m1438a(new C0744e(f1132i, abstractC0775a));
        c0740a.m1438a(new C0744e(f1131h, C0790n.m1629a(i)));
        c0740a.mo549b_();
        return c0740a;
    }

    /* JADX INFO: renamed from: a */
    public static C0740a m1138a(C0802z c0802z) {
        C0740a c0740a = new C0740a(f1125b, EnumC0741b.SYSTEM);
        c0740a.m1438a(new C0744e(f1133j, c0802z));
        c0740a.mo549b_();
        return c0740a;
    }

    /* JADX INFO: renamed from: a */
    public static C0740a m1139a(InterfaceC0807e interfaceC0807e) {
        C0780d c0780dM1141c = m1141c(interfaceC0807e);
        C0740a c0740a = new C0740a(f1128e, EnumC0741b.SYSTEM);
        c0740a.m1438a(new C0744e(f1133j, c0780dM1141c));
        c0740a.mo549b_();
        return c0740a;
    }

    /* JADX INFO: renamed from: b */
    public static C0740a m1140b(InterfaceC0807e interfaceC0807e) {
        C0780d c0780dM1141c = m1141c(interfaceC0807e);
        C0740a c0740a = new C0740a(f1130g, EnumC0741b.SYSTEM);
        c0740a.m1438a(new C0744e(f1133j, c0780dM1141c));
        c0740a.mo549b_();
        return c0740a;
    }

    /* JADX INFO: renamed from: c */
    private static C0780d m1141c(InterfaceC0807e interfaceC0807e) {
        int iMo759d_ = interfaceC0807e.mo759d_();
        C0781e c0781e = new C0781e(iMo759d_);
        for (int i = 0; i < iMo759d_; i++) {
            c0781e.m1615a(i, (AbstractC0775a) C0802z.m1654b(interfaceC0807e.mo756a(i)));
        }
        c0781e.mo549b_();
        return new C0780d(c0781e);
    }
}
