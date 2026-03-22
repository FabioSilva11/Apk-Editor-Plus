package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p036f.p038b.InterfaceC0749ad;
import com.p016a.p019b.p041g.p042a.C0822n;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.a.b.g.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C0825aa {

    /* JADX INFO: renamed from: a */
    private static boolean f2086a = true;

    /* JADX INFO: renamed from: b */
    private static InterfaceC0749ad f2087b;

    /* JADX INFO: renamed from: a */
    public static C0772x m1750a(C0772x c0772x, int i, boolean z, boolean z2, InterfaceC0749ad interfaceC0749ad) {
        EnumSet enumSetAllOf = EnumSet.allOf(EnumC0826ab.class);
        f2086a = z2;
        f2087b = interfaceC0749ad;
        C0838an c0838anM1891a = C0849e.m1891a(c0772x, i, z);
        m1751a(c0838anM1891a, enumSetAllOf);
        C0772x c0772xM1747a = C0822n.m1747a(c0838anM1891a, false);
        if (c0772xM1747a.m1582a().m1479e() <= 16) {
            return c0772xM1747a;
        }
        C0838an c0838anM1891a2 = C0849e.m1891a(c0772x, i, z);
        EnumSet enumSetClone = enumSetAllOf.clone();
        enumSetClone.remove(EnumC0826ab.f2091d);
        m1751a(c0838anM1891a2, enumSetClone);
        return C0822n.m1747a(c0838anM1891a2, true);
    }

    /* JADX INFO: renamed from: a */
    private static void m1751a(C0838an c0838an, EnumSet enumSet) {
        boolean z = false;
        boolean z2 = true;
        if (enumSet.contains(EnumC0826ab.f2088a)) {
            C0867w.m1938a(c0838an);
        }
        if (enumSet.contains(EnumC0826ab.f2089b)) {
            C0832ah.m1780a(c0838an);
            C0849e.m1893a(c0838an);
            z2 = false;
        }
        if (enumSet.contains(EnumC0826ab.f2090c)) {
            C0863s.m1924a(c0838an);
            C0849e.m1893a(c0838an);
            z2 = false;
        }
        enumSet.remove(EnumC0826ab.f2092e);
        if (enumSet.contains(EnumC0826ab.f2092e)) {
            C0856l.m1914a(c0838an);
            C0849e.m1893a(c0838an);
            z2 = false;
        }
        if (enumSet.contains(EnumC0826ab.f2091d)) {
            C0846b.m1889a(c0838an);
            C0849e.m1893a(c0838an);
        } else {
            z = z2;
        }
        if (z) {
            C0849e.m1893a(c0838an);
        }
        C0830af.m1772a(c0838an);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1752a() {
        return f2086a;
    }

    /* JADX INFO: renamed from: b */
    public static InterfaceC0749ad m1753b() {
        return f2087b;
    }
}
