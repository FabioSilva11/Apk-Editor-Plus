package com.p016a.p019b.p028c.p032c;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0658z extends AbstractC0605ac {
    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1045a;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1053a(C0650r c0650r, C0888r c0888r) {
        int iG = c0650r.m1225g().m1101g();
        AbstractC0622at abstractC0622atM1234p = c0650r.m1234p();
        AbstractC0622at abstractC0622atM1235q = c0650r.m1235q();
        int iM1101g = abstractC0622atM1234p.m1101g();
        int iM1101g2 = (abstractC0622atM1235q.m1101g() + abstractC0622atM1235q.mo1077f_()) - iM1101g;
        String strM2253c = C0985a.m2253c(c0650r.m1219b().f681b);
        if (c0888r.m2019b()) {
            c0888r.m2010a(8, "magic: " + new C0801y(strM2253c).m1648i());
            c0888r.m2010a(4, "checksum");
            c0888r.m2010a(20, "signature");
            c0888r.m2010a(4, "file_size:       " + C0985a.m2294t(c0650r.m1221c()));
            c0888r.m2010a(4, "header_size:     " + C0985a.m2294t(C0299R.styleable.AppCompatTheme_ratingBarStyleSmall));
            c0888r.m2010a(4, "endian_tag:      " + C0985a.m2294t(305419896));
            c0888r.m2010a(4, "link_size:       0");
            c0888r.m2010a(4, "link_off:        0");
            c0888r.m2010a(4, "map_off:         " + C0985a.m2294t(iG));
        }
        for (int i = 0; i < 8; i++) {
            c0888r.mo307d(strM2253c.charAt(i));
        }
        c0888r.m2025f(24);
        c0888r.m2020c(c0650r.m1221c());
        c0888r.m2020c(C0299R.styleable.AppCompatTheme_ratingBarStyleSmall);
        c0888r.m2020c(305419896);
        c0888r.m2025f(8);
        c0888r.m2020c(iG);
        c0650r.m1226h().m1115b(c0888r);
        c0650r.m1229k().m1121b(c0888r);
        c0650r.m1230l().m1094b(c0888r);
        c0650r.m1231m().m1251a(c0888r);
        c0650r.m1232n().m1068a(c0888r);
        c0650r.m1227i().m1187a(c0888r);
        if (c0888r.m2019b()) {
            c0888r.m2010a(4, "data_size:       " + C0985a.m2294t(iM1101g2));
            c0888r.m2010a(4, "data_off:        " + C0985a.m2294t(iM1101g));
        }
        c0888r.m2020c(iM1101g2);
        c0888r.m2020c(iM1101g);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: e_ */
    public final int mo1054e_() {
        return C0299R.styleable.AppCompatTheme_ratingBarStyleSmall;
    }
}
