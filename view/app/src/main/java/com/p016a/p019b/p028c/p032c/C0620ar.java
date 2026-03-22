package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p040d.C0803a;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.ar */
/* JADX INFO: loaded from: classes.dex */
public final class C0620ar extends AbstractC0605ac {

    /* JADX INFO: renamed from: a */
    private final C0803a f1095a;

    /* JADX INFO: renamed from: b */
    private final C0801y f1096b;

    /* JADX INFO: renamed from: c */
    private C0631bb f1097c;

    public C0620ar(C0803a c0803a) {
        if (c0803a == null) {
            throw new NullPointerException("prototype == null");
        }
        this.f1095a = c0803a;
        this.f1096b = m1091a(c0803a);
        C0804b c0804bM1665b = c0803a.m1665b();
        this.f1097c = c0804bM1665b.m1977d_() == 0 ? null : new C0631bb(c0804bM1665b);
    }

    /* JADX INFO: renamed from: a */
    private static char m1090a(C0805c c0805c) {
        char cCharAt = c0805c.m1685g().charAt(0);
        if (cCharAt == '[') {
            return 'L';
        }
        return cCharAt;
    }

    /* JADX INFO: renamed from: a */
    private static C0801y m1091a(C0803a c0803a) {
        C0804b c0804bM1665b = c0803a.m1665b();
        int iD_ = c0804bM1665b.m1977d_();
        StringBuilder sb = new StringBuilder(iD_ + 1);
        sb.append(m1090a(c0803a.m1664a()));
        for (int i = 0; i < iD_; i++) {
            sb.append(m1090a(c0804bM1665b.mo756a(i)));
        }
        return new C0801y(sb.toString());
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1048d;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        C0627ay c0627ayM1226h = c0650r.m1226h();
        C0630ba c0630baM1229k = c0650r.m1229k();
        C0614al c0614alM1224f = c0650r.m1224f();
        c0630baM1229k.m1118a(this.f1095a.m1664a());
        c0627ayM1226h.m1113a(this.f1096b);
        if (this.f1097c != null) {
            this.f1097c = (C0631bb) c0614alM1224f.m1074b(this.f1097c);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1053a(C0650r c0650r, C0888r c0888r) {
        int iM1114b = c0650r.m1226h().m1114b(this.f1096b);
        int iM1120b = c0650r.m1229k().m1120b(this.f1095a.m1664a());
        int iM1079b = AbstractC0618ap.m1079b(this.f1097c);
        if (c0888r.m2019b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1095a.m1664a().mo657d());
            sb.append(" proto(");
            C0804b c0804bM1665b = this.f1095a.m1665b();
            int iD_ = c0804bM1665b.m1977d_();
            for (int i = 0; i < iD_; i++) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(c0804bM1665b.mo756a(i).mo657d());
            }
            sb.append(")");
            c0888r.m2010a(0, m1052j() + ' ' + sb.toString());
            c0888r.m2010a(4, "  shorty_idx:      " + C0985a.m2294t(iM1114b) + " // " + this.f1096b.m1648i());
            c0888r.m2010a(4, "  return_type_idx: " + C0985a.m2294t(iM1120b) + " // " + this.f1095a.m1664a().mo657d());
            c0888r.m2010a(4, "  parameters_off:  " + C0985a.m2294t(iM1079b));
        }
        c0888r.m2020c(iM1114b);
        c0888r.m2020c(iM1120b);
        c0888r.m2020c(iM1079b);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: e_ */
    public final int mo1054e_() {
        return 12;
    }
}
