package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p037a.C0740a;
import com.p016a.p019b.p036f.p037a.C0744e;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0795s;
import com.p016a.p019b.p036f.p039c.C0779c;
import com.p016a.p019b.p036f.p039c.C0780d;
import com.p016a.p019b.p036f.p039c.C0781e;
import com.p016a.p019b.p036f.p039c.C0783g;
import com.p016a.p019b.p036f.p039c.C0784h;
import com.p016a.p019b.p036f.p039c.C0785i;
import com.p016a.p019b.p036f.p039c.C0786j;
import com.p016a.p019b.p036f.p039c.C0787k;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p036f.p039c.C0789m;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0792p;
import com.p016a.p019b.p036f.p039c.C0796t;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0800x;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0888r;
import java.util.Collection;

/* JADX INFO: renamed from: com.a.b.c.c.be */
/* JADX INFO: loaded from: classes.dex */
public final class C0634be {

    /* JADX INFO: renamed from: a */
    private final C0650r f1119a;

    /* JADX INFO: renamed from: b */
    private final C0888r f1120b;

    public C0634be(C0650r c0650r, C0888r c0888r) {
        if (c0650r == null) {
            throw new NullPointerException("file == null");
        }
        if (c0888r == null) {
            throw new NullPointerException("out == null");
        }
        this.f1119a = c0650r;
        this.f1120b = c0888r;
    }

    /* JADX INFO: renamed from: a */
    public static String m1125a(AbstractC0775a abstractC0775a) {
        if (m1129c(abstractC0775a) == 30) {
            return "null";
        }
        return abstractC0775a.mo1604h() + ' ' + abstractC0775a.mo657d();
    }

    /* JADX INFO: renamed from: a */
    public static void m1126a(C0650r c0650r, C0740a c0740a) {
        C0630ba c0630baM1229k = c0650r.m1229k();
        C0627ay c0627ayM1226h = c0650r.m1226h();
        c0630baM1229k.m1117a(c0740a.m1439b());
        for (C0744e c0744e : c0740a.m1442f()) {
            c0627ayM1226h.m1113a(c0744e.m1455a());
            m1127a(c0650r, c0744e.m1456b());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1127a(C0650r c0650r, AbstractC0775a abstractC0775a) {
        if (abstractC0775a instanceof C0779c) {
            m1126a(c0650r, ((C0779c) abstractC0775a).m1611a());
            return;
        }
        if (!(abstractC0775a instanceof C0780d)) {
            c0650r.m1216a(abstractC0775a);
            return;
        }
        C0781e c0781eM1612a = ((C0780d) abstractC0775a).m1612a();
        int iD_ = c0781eM1612a.m1977d_();
        for (int i = 0; i < iD_; i++) {
            m1127a(c0650r, c0781eM1612a.m1614a(i));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1128b(AbstractC0775a abstractC0775a) {
        int iM1129c = m1129c(abstractC0775a);
        switch (iM1129c) {
            case 0:
            case 2:
            case 4:
            case 6:
                C0985a.m2208a(this.f1120b, iM1129c, ((AbstractC0795s) abstractC0775a).mo1633k());
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
                throw new RuntimeException("Shouldn't happen");
            case 3:
                C0985a.m2242b(this.f1120b, iM1129c, ((AbstractC0795s) abstractC0775a).mo1633k());
                return;
            case 16:
                C0985a.m2258c(this.f1120b, iM1129c, ((C0789m) abstractC0775a).mo1633k() << 32);
                return;
            case 17:
                C0985a.m2258c(this.f1120b, iM1129c, ((C0786j) abstractC0775a).mo1633k());
                return;
            case 23:
                C0985a.m2242b(this.f1120b, iM1129c, this.f1119a.m1226h().m1114b((C0801y) abstractC0775a));
                return;
            case 24:
                C0985a.m2242b(this.f1120b, iM1129c, this.f1119a.m1229k().m1119b((C0802z) abstractC0775a));
                return;
            case 25:
                C0985a.m2242b(this.f1120b, iM1129c, this.f1119a.m1231m().m1252b((C0788l) abstractC0775a));
                return;
            case 26:
                C0985a.m2242b(this.f1120b, iM1129c, this.f1119a.m1232n().m1069b((C0798v) abstractC0775a));
                return;
            case 27:
                C0985a.m2242b(this.f1120b, iM1129c, this.f1119a.m1231m().m1252b(((C0787k) abstractC0775a).m1626i()));
                return;
            case 28:
                this.f1120b.mo307d(iM1129c);
                m1131a((C0780d) abstractC0775a, false);
                return;
            case 29:
                this.f1120b.mo307d(iM1129c);
                m1130a(((C0779c) abstractC0775a).m1611a(), false);
                return;
            case 30:
                this.f1120b.mo307d(iM1129c);
                return;
            case 31:
                this.f1120b.mo307d(iM1129c | (((C0783g) abstractC0775a).mo1632j() << 5));
                return;
        }
    }

    /* JADX INFO: renamed from: c */
    private static int m1129c(AbstractC0775a abstractC0775a) {
        if (abstractC0775a instanceof C0784h) {
            return 0;
        }
        if (abstractC0775a instanceof C0800x) {
            return 2;
        }
        if (abstractC0775a instanceof C0785i) {
            return 3;
        }
        if (abstractC0775a instanceof C0790n) {
            return 4;
        }
        if (abstractC0775a instanceof C0796t) {
            return 6;
        }
        if (abstractC0775a instanceof C0789m) {
            return 16;
        }
        if (abstractC0775a instanceof C0786j) {
            return 17;
        }
        if (abstractC0775a instanceof C0801y) {
            return 23;
        }
        if (abstractC0775a instanceof C0802z) {
            return 24;
        }
        if (abstractC0775a instanceof C0788l) {
            return 25;
        }
        if (abstractC0775a instanceof C0798v) {
            return 26;
        }
        if (abstractC0775a instanceof C0787k) {
            return 27;
        }
        if (abstractC0775a instanceof C0780d) {
            return 28;
        }
        if (abstractC0775a instanceof C0779c) {
            return 29;
        }
        if (abstractC0775a instanceof C0792p) {
            return 30;
        }
        if (abstractC0775a instanceof C0783g) {
            return 31;
        }
        throw new RuntimeException("Shouldn't happen");
    }

    /* JADX INFO: renamed from: a */
    public final void m1130a(C0740a c0740a, boolean z) {
        int i;
        boolean z2 = z && this.f1120b.m2019b();
        C0627ay c0627ayM1226h = this.f1119a.m1226h();
        C0630ba c0630baM1229k = this.f1119a.m1229k();
        C0802z c0802zM1439b = c0740a.m1439b();
        int iM1119b = c0630baM1229k.m1119b(c0802zM1439b);
        if (z2) {
            this.f1120b.m2015a("  type_idx: " + C0985a.m2294t(iM1119b) + " // " + c0802zM1439b.mo657d());
        }
        this.f1120b.m2024e(c0630baM1229k.m1119b(c0740a.m1439b()));
        Collection<C0744e> collectionM1442f = c0740a.m1442f();
        int size = collectionM1442f.size();
        if (z2) {
            this.f1120b.m2015a("  size: " + C0985a.m2294t(size));
        }
        this.f1120b.m2024e(size);
        int i2 = 0;
        for (C0744e c0744e : collectionM1442f) {
            C0801y c0801yM1455a = c0744e.m1455a();
            int iM1114b = c0627ayM1226h.m1114b(c0801yM1455a);
            AbstractC0775a abstractC0775aM1456b = c0744e.m1456b();
            if (z2) {
                this.f1120b.m2010a(0, "  elements[" + i2 + "]:");
                i = i2 + 1;
                this.f1120b.m2015a("    name_idx: " + C0985a.m2294t(iM1114b) + " // " + c0801yM1455a.mo657d());
            } else {
                i = i2;
            }
            this.f1120b.m2024e(iM1114b);
            if (z2) {
                this.f1120b.m2015a("    value: " + m1125a(abstractC0775aM1456b));
            }
            m1128b(abstractC0775aM1456b);
            i2 = i;
        }
        if (z2) {
            this.f1120b.m2022d();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1131a(C0780d c0780d, boolean z) {
        boolean z2 = z && this.f1120b.m2019b();
        C0781e c0781eM1612a = c0780d.m1612a();
        int iD_ = c0781eM1612a.m1977d_();
        if (z2) {
            this.f1120b.m2015a("  size: " + C0985a.m2294t(iD_));
        }
        this.f1120b.m2024e(iD_);
        for (int i = 0; i < iD_; i++) {
            AbstractC0775a abstractC0775aM1614a = c0781eM1612a.m1614a(i);
            if (z2) {
                this.f1120b.m2015a("  [" + Integer.toHexString(i) + "] " + m1125a(abstractC0775aM1614a));
            }
            m1128b(abstractC0775aM1614a);
        }
        if (z2) {
            this.f1120b.m2022d();
        }
    }
}
