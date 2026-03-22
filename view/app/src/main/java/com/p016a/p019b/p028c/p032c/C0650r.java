package com.p016a.p019b.p028c.p032c;

import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p028c.C0533a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0782f;
import com.p016a.p019b.p036f.p039c.C0787k;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0888r;
import java.io.Writer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.zip.Adler32;

/* JADX INFO: renamed from: com.a.b.c.c.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0650r {

    /* JADX INFO: renamed from: a */
    private C0533a f1187a;

    /* JADX INFO: renamed from: n */
    private final C0603aa f1200n = new C0603aa(this);

    /* JADX INFO: renamed from: c */
    private final C0614al f1189c = new C0614al(null, this, 4, C0617ao.f1084a);

    /* JADX INFO: renamed from: b */
    private final C0614al f1188b = new C0614al("word_data", this, 4, C0617ao.f1085b);

    /* JADX INFO: renamed from: e */
    private final C0614al f1191e = new C0614al("string_data", this, 1, C0617ao.f1086c);

    /* JADX INFO: renamed from: l */
    private final C0614al f1198l = new C0614al(null, this, 1, C0617ao.f1084a);

    /* JADX INFO: renamed from: m */
    private final C0614al f1199m = new C0614al("byte_data", this, 1, C0617ao.f1085b);

    /* JADX INFO: renamed from: f */
    private final C0627ay f1192f = new C0627ay(this);

    /* JADX INFO: renamed from: g */
    private final C0630ba f1193g = new C0630ba(this);

    /* JADX INFO: renamed from: h */
    private final C0621as f1194h = new C0621as(this);

    /* JADX INFO: renamed from: i */
    private final C0657y f1195i = new C0657y(this);

    /* JADX INFO: renamed from: j */
    private final C0613ak f1196j = new C0613ak(this);

    /* JADX INFO: renamed from: k */
    private final C0643k f1197k = new C0643k(this);

    /* JADX INFO: renamed from: d */
    private final C0614al f1190d = new C0614al("map", this, 4, C0617ao.f1084a);

    /* JADX INFO: renamed from: o */
    private final AbstractC0622at[] f1201o = {this.f1200n, this.f1192f, this.f1193g, this.f1194h, this.f1195i, this.f1196j, this.f1197k, this.f1188b, this.f1189c, this.f1191e, this.f1199m, this.f1198l, this.f1190d};

    /* JADX INFO: renamed from: p */
    private int f1202p = -1;

    /* JADX INFO: renamed from: q */
    private int f1203q = 79;

    public C0650r(C0533a c0533a) {
        this.f1187a = c0533a;
    }

    /* JADX INFO: renamed from: a */
    private C0888r m1212a(boolean z, boolean z2) {
        this.f1197k.m1102h();
        this.f1198l.m1102h();
        this.f1188b.m1102h();
        this.f1199m.m1102h();
        this.f1196j.m1102h();
        this.f1195i.m1102h();
        this.f1194h.m1102h();
        this.f1189c.m1102h();
        this.f1193g.m1102h();
        this.f1192f.m1102h();
        this.f1191e.m1102h();
        this.f1200n.m1102h();
        int i = 0;
        int iMo1077f_ = 0;
        while (i < 13) {
            AbstractC0622at abstractC0622at = this.f1201o[i];
            int iM1096b = abstractC0622at.m1096b(iMo1077f_);
            if (iM1096b < iMo1077f_) {
                throw new RuntimeException("bogus placement for section " + i);
            }
            try {
                if (abstractC0622at == this.f1190d) {
                    C0608af.m1057a(this.f1201o, this.f1190d);
                    this.f1190d.m1102h();
                }
                if (abstractC0622at instanceof C0614al) {
                    ((C0614al) abstractC0622at).m1076d();
                }
                i++;
                iMo1077f_ = iM1096b + abstractC0622at.mo1077f_();
            } catch (RuntimeException e) {
                throw C0400d.m308a(e, "...while writing section " + i);
            }
        }
        this.f1202p = iMo1077f_;
        byte[] bArr = new byte[this.f1202p];
        C0888r c0888r = new C0888r(bArr);
        if (z) {
            c0888r.m2011a(this.f1203q, z2);
        }
        for (int i2 = 0; i2 < 13; i2++) {
            try {
                AbstractC0622at abstractC0622at2 = this.f1201o[i2];
                int iM1101g = abstractC0622at2.m1101g() - c0888r.m2008a();
                if (iM1101g < 0) {
                    throw new C0400d("excess write of " + (-iM1101g));
                }
                c0888r.m2025f(abstractC0622at2.m1101g() - c0888r.m2008a());
                abstractC0622at2.m1098c(c0888r);
            } catch (RuntimeException e2) {
                C0400d c0400d = e2 instanceof C0400d ? (C0400d) e2 : new C0400d(e2);
                c0400d.m311a("...while writing section " + i2);
                throw c0400d;
            }
        }
        if (c0888r.m2008a() != this.f1202p) {
            throw new RuntimeException("foreshortened write");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr, 32, bArr.length - 32);
            try {
                int iDigest = messageDigest.digest(bArr, 12, 20);
                if (iDigest != 20) {
                    throw new RuntimeException("unexpected digest write: " + iDigest + " bytes");
                }
                Adler32 adler32 = new Adler32();
                adler32.update(bArr, 12, bArr.length - 12);
                int value = (int) adler32.getValue();
                bArr[8] = (byte) value;
                bArr[9] = (byte) (value >> 8);
                bArr[10] = (byte) (value >> 16);
                bArr[11] = value >> 24;
                if (z) {
                    this.f1188b.m1072a(c0888r, EnumC0607ae.f1057m, "\nmethod code index:\n\n");
                    m1236r().m1107a(c0888r);
                    c0888r.m2030h();
                }
                return c0888r;
            } catch (DigestException e3) {
                throw new RuntimeException(e3);
            }
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0642j m1213a(String str) {
        try {
            return (C0642j) this.f1197k.m1185a(new C0802z(C0805c.m1682c(str)));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1214a(int i) {
        if (i < 40) {
            throw new IllegalArgumentException("dumpWidth < 40");
        }
        this.f1203q = i;
    }

    /* JADX INFO: renamed from: a */
    public final void m1215a(C0642j c0642j) {
        this.f1197k.m1186a(c0642j);
    }

    /* JADX INFO: renamed from: a */
    final void m1216a(AbstractC0775a abstractC0775a) {
        if (abstractC0775a instanceof C0801y) {
            this.f1192f.m1113a((C0801y) abstractC0775a);
            return;
        }
        if (abstractC0775a instanceof C0802z) {
            this.f1193g.m1117a((C0802z) abstractC0775a);
            return;
        }
        if (abstractC0775a instanceof AbstractC0782f) {
            this.f1196j.m1067a((AbstractC0782f) abstractC0775a);
            return;
        }
        if (abstractC0775a instanceof C0788l) {
            this.f1195i.m1250a((C0788l) abstractC0775a);
        } else if (abstractC0775a instanceof C0787k) {
            this.f1195i.m1250a(((C0787k) abstractC0775a).m1626i());
        } else if (abstractC0775a == null) {
            throw new NullPointerException("cst == null");
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1217a() {
        return this.f1197k.mo1046a().isEmpty();
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m1218a(Writer writer, boolean z) {
        boolean z2 = writer != null;
        C0888r c0888rM1212a = m1212a(z2, z);
        if (z2) {
            c0888rM1212a.m2014a(writer);
        }
        return c0888rM1212a.m2026f();
    }

    /* JADX INFO: renamed from: b */
    public final C0533a m1219b() {
        return this.f1187a;
    }

    /* JADX INFO: renamed from: b */
    final AbstractC0605ac m1220b(AbstractC0775a abstractC0775a) {
        if (abstractC0775a instanceof C0801y) {
            return this.f1192f.m1112a(abstractC0775a);
        }
        if (abstractC0775a instanceof C0802z) {
            return this.f1193g.m1116a(abstractC0775a);
        }
        if (abstractC0775a instanceof AbstractC0782f) {
            return this.f1196j.m1066a(abstractC0775a);
        }
        if (abstractC0775a instanceof C0788l) {
            return this.f1195i.m1249a(abstractC0775a);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final int m1221c() {
        if (this.f1202p < 0) {
            throw new RuntimeException("file size not yet known");
        }
        return this.f1202p;
    }

    /* JADX INFO: renamed from: d */
    final C0614al m1222d() {
        return this.f1191e;
    }

    /* JADX INFO: renamed from: e */
    final C0614al m1223e() {
        return this.f1188b;
    }

    /* JADX INFO: renamed from: f */
    final C0614al m1224f() {
        return this.f1189c;
    }

    /* JADX INFO: renamed from: g */
    final C0614al m1225g() {
        return this.f1190d;
    }

    /* JADX INFO: renamed from: h */
    final C0627ay m1226h() {
        return this.f1192f;
    }

    /* JADX INFO: renamed from: i */
    public final C0643k m1227i() {
        return this.f1197k;
    }

    /* JADX INFO: renamed from: j */
    final C0614al m1228j() {
        return this.f1198l;
    }

    /* JADX INFO: renamed from: k */
    public final C0630ba m1229k() {
        return this.f1193g;
    }

    /* JADX INFO: renamed from: l */
    final C0621as m1230l() {
        return this.f1194h;
    }

    /* JADX INFO: renamed from: m */
    public final C0657y m1231m() {
        return this.f1195i;
    }

    /* JADX INFO: renamed from: n */
    public final C0613ak m1232n() {
        return this.f1196j;
    }

    /* JADX INFO: renamed from: o */
    final C0614al m1233o() {
        return this.f1199m;
    }

    /* JADX INFO: renamed from: p */
    final AbstractC0622at m1234p() {
        return this.f1188b;
    }

    /* JADX INFO: renamed from: q */
    final AbstractC0622at m1235q() {
        return this.f1190d;
    }

    /* JADX INFO: renamed from: r */
    public final C0623au m1236r() {
        C0623au c0623au = new C0623au();
        AbstractC0622at[] abstractC0622atArr = this.f1201o;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 13) {
                return c0623au;
            }
            Iterator it = abstractC0622atArr[i2].mo1046a().iterator();
            while (it.hasNext()) {
                c0623au.m1106a((AbstractC0606ad) it.next());
            }
            i = i2 + 1;
        }
    }
}
