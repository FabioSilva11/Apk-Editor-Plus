package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p037a.C0742c;
import com.p016a.p019b.p036f.p037a.C0743d;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0780d;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0888r;
import jadx.core.codegen.CodeWriter;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.c.c.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0642j extends AbstractC0605ac {

    /* JADX INFO: renamed from: a */
    private final C0802z f1151a;

    /* JADX INFO: renamed from: b */
    private final int f1152b;

    /* JADX INFO: renamed from: c */
    private final C0802z f1153c;

    /* JADX INFO: renamed from: d */
    private C0631bb f1154d;

    /* JADX INFO: renamed from: e */
    private final C0801y f1155e;

    /* JADX INFO: renamed from: f */
    private final C0641i f1156f;

    /* JADX INFO: renamed from: g */
    private C0651s f1157g;

    /* JADX INFO: renamed from: h */
    private C0639g f1158h;

    public C0642j(C0802z c0802z, int i, C0802z c0802z2, InterfaceC0807e interfaceC0807e, C0801y c0801y) {
        if (c0802z == null) {
            throw new NullPointerException("thisClass == null");
        }
        if (interfaceC0807e == null) {
            throw new NullPointerException("interfaces == null");
        }
        this.f1151a = c0802z;
        this.f1152b = i;
        this.f1153c = c0802z2;
        this.f1154d = interfaceC0807e.mo759d_() == 0 ? null : new C0631bb(interfaceC0807e);
        this.f1155e = c0801y;
        this.f1156f = new C0641i(c0802z);
        this.f1157g = null;
        this.f1158h = new C0639g();
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1051g;
    }

    /* JADX INFO: renamed from: a */
    public final C0742c m1169a(C0798v c0798v) {
        return this.f1158h.m1143a(c0798v);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        C0630ba c0630baM1229k = c0650r.m1229k();
        C0614al c0614alM1233o = c0650r.m1233o();
        C0614al c0614alM1223e = c0650r.m1223e();
        C0614al c0614alM1224f = c0650r.m1224f();
        C0627ay c0627ayM1226h = c0650r.m1226h();
        c0630baM1229k.m1117a(this.f1151a);
        if (!this.f1156f.m1166c()) {
            c0650r.m1228j().m1071a((AbstractC0618ap) this.f1156f);
            C0780d c0780dM1168e = this.f1156f.m1168e();
            if (c0780dM1168e != null) {
                this.f1157g = (C0651s) c0614alM1233o.m1074b(new C0651s(c0780dM1168e));
            }
        }
        if (this.f1153c != null) {
            c0630baM1229k.m1117a(this.f1153c);
        }
        if (this.f1154d != null) {
            this.f1154d = (C0631bb) c0614alM1224f.m1074b(this.f1154d);
        }
        if (this.f1155e != null) {
            c0627ayM1226h.m1113a(this.f1155e);
        }
        if (this.f1158h.m1149c()) {
            return;
        }
        if (this.f1158h.m1150d()) {
            this.f1158h = (C0639g) c0614alM1223e.m1074b(this.f1158h);
        } else {
            c0614alM1223e.m1071a((AbstractC0618ap) this.f1158h);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1053a(C0650r c0650r, C0888r c0888r) {
        boolean zM2019b = c0888r.m2019b();
        C0630ba c0630baM1229k = c0650r.m1229k();
        int iM1119b = c0630baM1229k.m1119b(this.f1151a);
        int iM1119b2 = this.f1153c == null ? -1 : c0630baM1229k.m1119b(this.f1153c);
        int iM1079b = AbstractC0618ap.m1079b(this.f1154d);
        int iF = this.f1158h.m1149c() ? 0 : this.f1158h.m1083f();
        int iM1114b = this.f1155e == null ? -1 : c0650r.m1226h().m1114b(this.f1155e);
        int iF2 = this.f1156f.m1166c() ? 0 : this.f1156f.m1083f();
        int iM1079b2 = AbstractC0618ap.m1079b(this.f1157g);
        if (zM2019b) {
            c0888r.m2010a(0, m1052j() + ' ' + this.f1151a.mo657d());
            c0888r.m2010a(4, "  class_idx:           " + C0985a.m2294t(iM1119b));
            c0888r.m2010a(4, "  access_flags:        " + C0985a.m2274g(this.f1152b));
            c0888r.m2010a(4, "  superclass_idx:      " + C0985a.m2294t(iM1119b2) + " // " + (this.f1153c == null ? "<none>" : this.f1153c.mo657d()));
            c0888r.m2010a(4, "  interfaces_off:      " + C0985a.m2294t(iM1079b));
            if (iM1079b != 0) {
                InterfaceC0807e interfaceC0807eM1122c = this.f1154d.m1122c();
                int iMo759d_ = interfaceC0807eM1122c.mo759d_();
                for (int i = 0; i < iMo759d_; i++) {
                    c0888r.m2010a(0, CodeWriter.INDENT + interfaceC0807eM1122c.mo756a(i).mo657d());
                }
            }
            c0888r.m2010a(4, "  source_file_idx:     " + C0985a.m2294t(iM1114b) + " // " + (this.f1155e == null ? "<none>" : this.f1155e.mo657d()));
            c0888r.m2010a(4, "  annotations_off:     " + C0985a.m2294t(iF));
            c0888r.m2010a(4, "  class_data_off:      " + C0985a.m2294t(iF2));
            c0888r.m2010a(4, "  static_values_off:   " + C0985a.m2294t(iM1079b2));
        }
        c0888r.m2020c(iM1119b);
        c0888r.m2020c(this.f1152b);
        c0888r.m2020c(iM1119b2);
        c0888r.m2020c(iM1079b);
        c0888r.m2020c(iM1114b);
        c0888r.m2020c(iF);
        c0888r.m2020c(iF2);
        c0888r.m2020c(iM1079b2);
    }

    /* JADX INFO: renamed from: a */
    public final void m1170a(C0652t c0652t) {
        this.f1156f.m1162a(c0652t);
    }

    /* JADX INFO: renamed from: a */
    public final void m1171a(C0652t c0652t, AbstractC0775a abstractC0775a) {
        this.f1156f.m1163a(c0652t, abstractC0775a);
    }

    /* JADX INFO: renamed from: a */
    public final void m1172a(C0654v c0654v) {
        this.f1156f.m1164a(c0654v);
    }

    /* JADX INFO: renamed from: a */
    public final void m1173a(C0742c c0742c, C0650r c0650r) {
        this.f1158h.m1144a(c0742c, c0650r);
    }

    /* JADX INFO: renamed from: a */
    public final void m1174a(C0788l c0788l, C0742c c0742c, C0650r c0650r) {
        this.f1158h.m1145a(c0788l, c0742c, c0650r);
    }

    /* JADX INFO: renamed from: a */
    public final void m1175a(C0798v c0798v, C0742c c0742c, C0650r c0650r) {
        this.f1158h.m1146a(c0798v, c0742c, c0650r);
    }

    /* JADX INFO: renamed from: a */
    public final void m1176a(C0798v c0798v, C0743d c0743d, C0650r c0650r) {
        this.f1158h.m1147a(c0798v, c0743d, c0650r);
    }

    /* JADX INFO: renamed from: b */
    public final C0743d m1177b(C0798v c0798v) {
        return this.f1158h.m1148b(c0798v);
    }

    /* JADX INFO: renamed from: b */
    public final void m1178b(C0654v c0654v) {
        this.f1156f.m1165b(c0654v);
    }

    /* JADX INFO: renamed from: c */
    public final C0802z m1179c() {
        return this.f1151a;
    }

    /* JADX INFO: renamed from: d */
    public final C0802z m1180d() {
        return this.f1153c;
    }

    /* JADX INFO: renamed from: e */
    public final InterfaceC0807e m1181e() {
        return this.f1154d == null ? C0804b.f1974a : this.f1154d.m1122c();
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: e_ */
    public final int mo1054e_() {
        return 32;
    }

    /* JADX INFO: renamed from: f */
    public final C0801y m1182f() {
        return this.f1155e;
    }

    /* JADX INFO: renamed from: g */
    public final ArrayList m1183g() {
        return this.f1156f.m1167d();
    }
}
