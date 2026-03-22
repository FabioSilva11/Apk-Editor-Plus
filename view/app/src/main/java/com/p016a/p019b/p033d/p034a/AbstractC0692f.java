package com.p016a.p019b.p033d.p034a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.C0420s;
import com.p016a.p019b.p033d.C0716e;
import java.io.EOFException;

/* JADX INFO: renamed from: com.a.b.d.a.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0692f {

    /* JADX INFO: renamed from: a */
    private final EnumC0696j f1235a;

    /* JADX INFO: renamed from: b */
    private final int f1236b;

    /* JADX INFO: renamed from: c */
    private final int f1237c;

    /* JADX INFO: renamed from: d */
    private final int f1238d;

    /* JADX INFO: renamed from: e */
    private final int f1239e;

    /* JADX INFO: renamed from: f */
    private final long f1240f;

    public AbstractC0692f(EnumC0696j enumC0696j, int i, int i2, int i3, int i4, long j) {
        if (enumC0696j == null) {
            throw new NullPointerException("format == null");
        }
        if (!C0985a.m2270e(i)) {
            throw new IllegalArgumentException("invalid opcode");
        }
        this.f1235a = enumC0696j;
        this.f1236b = i;
        this.f1237c = i2;
        this.f1238d = i3;
        this.f1239e = i4;
        this.f1240f = j;
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0692f m1290a(InterfaceC0690d interfaceC0690d) {
        int iMo1268c = interfaceC0690d.mo1268c();
        return C0716e.m1339b(C0985a.m2271f(iMo1268c)).mo1261a(iMo1268c, interfaceC0690d);
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0692f[] m1291a(short[] sArr) {
        AbstractC0692f[] abstractC0692fArr = new AbstractC0692f[sArr.length];
        C0682av c0682av = new C0682av(sArr);
        while (c0682av.m1271f()) {
            try {
                abstractC0692fArr[c0682av.mo1286a()] = m1290a(c0682av);
            } catch (EOFException e) {
                throw new C0420s(e);
            }
        }
        return abstractC0692fArr;
    }

    /* JADX INFO: renamed from: a */
    public final int m1292a(int i) {
        return this.f1239e - i;
    }

    /* JADX INFO: renamed from: a */
    public final EnumC0696j m1293a() {
        return this.f1235a;
    }

    /* JADX INFO: renamed from: a */
    public final void m1294a(InterfaceC0691e interfaceC0691e) {
        this.f1235a.mo1262a(this, interfaceC0691e);
    }

    /* JADX INFO: renamed from: b */
    public final int m1295b() {
        return this.f1236b;
    }

    /* JADX INFO: renamed from: b */
    public final short m1296b(int i) {
        int i2 = this.f1239e - i;
        if (i2 != ((short) i2)) {
            throw new C0420s("Target out of range: " + C0985a.m2300z(i2));
        }
        return (short) i2;
    }

    /* JADX INFO: renamed from: c */
    public final int m1297c(int i) {
        int i2 = this.f1239e - i;
        if (i2 != ((byte) i2)) {
            throw new C0420s("Target out of range: " + C0985a.m2300z(i2));
        }
        return i2 & 255;
    }

    /* JADX INFO: renamed from: c */
    public final short m1298c() {
        return (short) this.f1236b;
    }

    /* JADX INFO: renamed from: d */
    public final int m1299d() {
        return this.f1237c;
    }

    /* JADX INFO: renamed from: d */
    public abstract AbstractC0692f mo1263d(int i);

    /* JADX INFO: renamed from: e */
    public final short m1300e() {
        return (short) this.f1237c;
    }

    /* JADX INFO: renamed from: f */
    public final int m1301f() {
        return this.f1238d;
    }

    /* JADX INFO: renamed from: g */
    public final int m1302g() {
        return this.f1239e;
    }

    /* JADX INFO: renamed from: h */
    public final long m1303h() {
        return this.f1240f;
    }

    /* JADX INFO: renamed from: i */
    public final int m1304i() {
        if (this.f1240f != ((int) this.f1240f)) {
            throw new C0420s("Literal out of range: " + C0985a.m2193a(this.f1240f));
        }
        return (int) this.f1240f;
    }

    /* JADX INFO: renamed from: j */
    public final short m1305j() {
        if (this.f1240f != ((short) this.f1240f)) {
            throw new C0420s("Literal out of range: " + C0985a.m2193a(this.f1240f));
        }
        return (short) this.f1240f;
    }

    /* JADX INFO: renamed from: k */
    public final int m1306k() {
        if (this.f1240f != ((byte) this.f1240f)) {
            throw new C0420s("Literal out of range: " + C0985a.m2193a(this.f1240f));
        }
        return ((int) this.f1240f) & 255;
    }

    /* JADX INFO: renamed from: l */
    public final int m1307l() {
        if (this.f1240f < -8 || this.f1240f > 7) {
            throw new C0420s("Literal out of range: " + C0985a.m2193a(this.f1240f));
        }
        return ((int) this.f1240f) & 15;
    }

    /* JADX INFO: renamed from: m */
    public abstract int mo1264m();

    /* JADX INFO: renamed from: n */
    public int mo1265n() {
        return 0;
    }

    /* JADX INFO: renamed from: o */
    public int mo1284o() {
        return 0;
    }

    /* JADX INFO: renamed from: p */
    public int mo1285p() {
        return 0;
    }

    /* JADX INFO: renamed from: q */
    public int mo1308q() {
        return 0;
    }

    /* JADX INFO: renamed from: r */
    public int mo1309r() {
        return 0;
    }

    /* JADX INFO: renamed from: s */
    public final short m1310s() {
        int iMo1265n = mo1265n();
        if (((-65536) & iMo1265n) != 0) {
            throw new C0420s("Register A out of range: " + C0985a.m2193a(iMo1265n));
        }
        return (short) iMo1265n;
    }

    /* JADX INFO: renamed from: t */
    public final short m1311t() {
        int iMo1284o = mo1284o();
        if (((-65536) & iMo1284o) != 0) {
            throw new C0420s("Register B out of range: " + C0985a.m2193a(iMo1284o));
        }
        return (short) iMo1284o;
    }
}
