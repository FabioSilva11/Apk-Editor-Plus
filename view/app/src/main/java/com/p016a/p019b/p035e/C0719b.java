package com.p016a.p019b.p035e;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.C0401aa;
import com.p016a.p017a.C0403b;
import com.p016a.p017a.C0404c;
import com.p016a.p017a.C0405d;
import com.p016a.p017a.C0406e;
import com.p016a.p017a.C0407f;
import com.p016a.p017a.C0408g;
import com.p016a.p017a.C0409h;
import com.p016a.p017a.C0410i;
import com.p016a.p017a.C0416o;
import com.p016a.p017a.C0420s;
import com.p016a.p017a.C0422u;
import com.p016a.p017a.C0423v;
import com.p016a.p017a.C0427z;
import com.p016a.p019b.p043h.C0888r;
import java.util.Arrays;

/* JADX INFO: renamed from: com.a.b.e.b */
/* JADX INFO: loaded from: classes.dex */
public class C0719b {

    /* JADX INFO: renamed from: a */
    private final C0410i f1528a;

    /* JADX INFO: renamed from: b */
    private final C0410i f1529b;

    /* JADX INFO: renamed from: c */
    private final int f1530c;

    /* JADX INFO: renamed from: d */
    private final C0729l f1531d;

    /* JADX INFO: renamed from: e */
    private final C0410i f1532e;

    /* JADX INFO: renamed from: f */
    private final C0416o f1533f;

    /* JADX INFO: renamed from: g */
    private final C0416o f1534g;

    /* JADX INFO: renamed from: h */
    private final C0416o f1535h;

    /* JADX INFO: renamed from: i */
    private final C0416o f1536i;

    /* JADX INFO: renamed from: j */
    private final C0416o f1537j;

    /* JADX INFO: renamed from: k */
    private final C0416o f1538k;

    /* JADX INFO: renamed from: l */
    private final C0416o f1539l;

    /* JADX INFO: renamed from: m */
    private final C0416o f1540m;

    /* JADX INFO: renamed from: n */
    private final C0416o f1541n;

    /* JADX INFO: renamed from: o */
    private final C0416o f1542o;

    /* JADX INFO: renamed from: p */
    private final C0416o f1543p;

    /* JADX INFO: renamed from: q */
    private final C0416o f1544q;

    /* JADX INFO: renamed from: r */
    private final C0416o f1545r;

    /* JADX INFO: renamed from: s */
    private final C0427z f1546s;

    /* JADX INFO: renamed from: t */
    private final C0730m f1547t;

    /* JADX INFO: renamed from: u */
    private final C0730m f1548u;

    /* JADX INFO: renamed from: v */
    private final C0732o f1549v;

    /* JADX INFO: renamed from: w */
    private final C0732o f1550w;

    /* JADX INFO: renamed from: x */
    private int f1551x;

    public C0719b(C0410i c0410i, C0410i c0410i2, int i) {
        this(c0410i, c0410i2, i, new C0729l(c0410i, c0410i2));
    }

    private C0719b(C0410i c0410i, C0410i c0410i2, int i, C0729l c0729l) {
        this.f1551x = 1048576;
        this.f1528a = c0410i;
        this.f1529b = c0410i2;
        this.f1530c = i;
        this.f1531d = c0729l;
        this.f1532e = new C0410i(c0729l.m1397a());
        C0427z c0427zM356a = c0410i.m356a();
        C0427z c0427zM356a2 = c0410i2.m356a();
        this.f1547t = new C0730m(this.f1532e, c0427zM356a);
        this.f1548u = new C0730m(this.f1532e, c0427zM356a2);
        this.f1549v = new C0732o(this.f1547t);
        this.f1550w = new C0732o(this.f1548u);
        this.f1533f = this.f1532e.m355a(c0729l.f1565a, "header");
        this.f1534g = this.f1532e.m355a(c0729l.f1566b, "ids defs");
        this.f1546s = this.f1532e.m356a();
        this.f1546s.f447z = this.f1532e.m360c();
        this.f1546s.f429h.f343c = this.f1532e.m360c();
        this.f1546s.f429h.f342b = 1;
        this.f1535h = this.f1532e.m355a(c0729l.f1567c, "map list");
        this.f1546s.f430i.f343c = this.f1532e.m360c();
        this.f1536i = this.f1532e.m355a(c0729l.f1568d, "type list");
        this.f1546s.f431j.f343c = this.f1532e.m360c();
        this.f1544q = this.f1532e.m355a(c0729l.f1576l, "annotation set ref list");
        this.f1546s.f432k.f343c = this.f1532e.m360c();
        this.f1543p = this.f1532e.m355a(c0729l.f1575k, "annotation sets");
        this.f1546s.f433l.f343c = this.f1532e.m360c();
        this.f1537j = this.f1532e.m355a(c0729l.f1569e, "class data");
        this.f1546s.f434m.f343c = this.f1532e.m360c();
        this.f1538k = this.f1532e.m355a(c0729l.f1570f, "code");
        this.f1546s.f435n.f343c = this.f1532e.m360c();
        this.f1539l = this.f1532e.m355a(c0729l.f1571g, "string data");
        this.f1546s.f436o.f343c = this.f1532e.m360c();
        this.f1540m = this.f1532e.m355a(c0729l.f1572h, "debug info");
        this.f1546s.f437p.f343c = this.f1532e.m360c();
        this.f1545r = this.f1532e.m355a(c0729l.f1577m, "annotation");
        this.f1546s.f438q.f343c = this.f1532e.m360c();
        this.f1541n = this.f1532e.m355a(c0729l.f1573i, "encoded array");
        this.f1546s.f439r.f343c = this.f1532e.m360c();
        this.f1542o = this.f1532e.m355a(c0729l.f1574j, "annotations directory");
        this.f1546s.f446y = this.f1532e.m360c() - this.f1546s.f447z;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C0730m m1347a(C0719b c0719b, C0410i c0410i) {
        if (c0410i == c0719b.f1528a) {
            return c0719b.f1547t;
        }
        if (c0410i == c0719b.f1529b) {
            return c0719b.f1548u;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: a */
    private void m1348a(C0410i c0410i, C0730m c0730m) {
        C0401aa c0401aa = c0410i.m356a().f432k;
        if (c0401aa.m312a()) {
            C0416o c0416oM354a = c0410i.m354a(c0401aa.f343c);
            for (int i = 0; i < c0401aa.f342b; i++) {
                this.f1546s.f432k.f342b++;
                this.f1543p.m401m();
                c0730m.m1410c(c0416oM354a.m378a(), this.f1543p.m378a());
                int iM385b = c0416oM354a.m385b();
                this.f1543p.m392f(iM385b);
                for (int i2 = 0; i2 < iM385b; i2++) {
                    this.f1543p.m392f(c0730m.m1413e(c0416oM354a.m385b()));
                }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x00fd. Please report as an issue. */
    /* JADX INFO: renamed from: a */
    private void m1349a(C0410i c0410i, C0730m c0730m, C0405d[] c0405dArr) {
        int length = c0405dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            C0405d c0405d = c0405dArr[i];
            int iM1411d = c0730m.m1411d(c0405d.m320a());
            this.f1537j.m394g(iM1411d - i2);
            this.f1537j.m394g(c0405d.m321b());
            if (c0405d.m322c() == 0) {
                this.f1537j.m394g(0);
            } else {
                this.f1538k.m400l();
                this.f1537j.m394g(this.f1538k.m378a());
                C0407f c0407fM353a = c0410i.m353a(c0405d);
                this.f1546s.f434m.f342b++;
                this.f1538k.m401m();
                this.f1538k.m390e(c0407fM353a.m333a());
                this.f1538k.m390e(c0407fM353a.m334b());
                this.f1538k.m390e(c0407fM353a.m335c());
                C0409h[] c0409hArrM338f = c0407fM353a.m338f();
                C0408g[] c0408gArrM339g = c0407fM353a.m339g();
                this.f1538k.m390e(c0409hArrM338f.length);
                int iM336d = c0407fM353a.m336d();
                if (iM336d != 0) {
                    this.f1538k.m392f(this.f1540m.m378a());
                    C0416o c0416oM354a = c0410i.m354a(iM336d);
                    this.f1546s.f436o.f342b++;
                    this.f1540m.m394g(C0985a.m2232b(c0416oM354a));
                    int iM2232b = C0985a.m2232b(c0416oM354a);
                    this.f1540m.m394g(iM2232b);
                    for (int i3 = 0; i3 < iM2232b; i3++) {
                        this.f1540m.m386b(c0730m.m1399a(C0985a.m2232b(c0416oM354a) - 1));
                    }
                    while (true) {
                        byte bMo306d = c0416oM354a.mo306d();
                        this.f1540m.mo307d(bMo306d);
                        switch (bMo306d) {
                            case 1:
                                this.f1540m.m394g(C0985a.m2232b(c0416oM354a));
                                break;
                            case 2:
                                this.f1540m.m396h(C0985a.m2171a(c0416oM354a));
                                break;
                            case 3:
                            case 4:
                                this.f1540m.m394g(C0985a.m2232b(c0416oM354a));
                                this.f1540m.m386b(c0730m.m1399a(C0985a.m2232b(c0416oM354a) - 1));
                                this.f1540m.m386b(c0730m.m1407b(C0985a.m2232b(c0416oM354a) - 1));
                                if (bMo306d == 4) {
                                    this.f1540m.m386b(c0730m.m1399a(C0985a.m2232b(c0416oM354a) - 1));
                                }
                                break;
                            case 5:
                            case 6:
                                this.f1540m.m394g(C0985a.m2232b(c0416oM354a));
                                break;
                            case 9:
                                this.f1540m.m386b(c0730m.m1399a(C0985a.m2232b(c0416oM354a) - 1));
                                break;
                        }
                    }
                } else {
                    this.f1538k.m392f(0);
                }
                short[] sArrM1430a = (c0410i == this.f1528a ? this.f1549v : this.f1550w).m1430a(c0407fM353a.m337e());
                this.f1538k.m392f(sArrM1430a.length);
                this.f1538k.m383a(sArrM1430a);
                if (c0409hArrM338f.length > 0) {
                    if (sArrM1430a.length % 2 == 1) {
                        this.f1538k.m381a((short) 0);
                    }
                    C0416o c0416oM354a2 = this.f1532e.m354a(this.f1538k.m378a());
                    this.f1538k.m388c(c0409hArrM338f.length << 3);
                    int iM378a = this.f1538k.m378a();
                    this.f1538k.m394g(c0408gArrM339g.length);
                    int[] iArr = new int[c0408gArrM339g.length];
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 < c0408gArrM339g.length) {
                            iArr[i5] = this.f1538k.m378a() - iM378a;
                            C0408g c0408g = c0408gArrM339g[i5];
                            int iM342c = c0408g.m342c();
                            int[] iArrM340a = c0408g.m340a();
                            int[] iArrM341b = c0408g.m341b();
                            if (iM342c != -1) {
                                this.f1538k.m396h(-iArrM340a.length);
                            } else {
                                this.f1538k.m396h(iArrM340a.length);
                            }
                            for (int i6 = 0; i6 < iArrM340a.length; i6++) {
                                this.f1538k.m394g(c0730m.m1407b(iArrM340a[i6]));
                                this.f1538k.m394g(iArrM341b[i6]);
                            }
                            if (iM342c != -1) {
                                this.f1538k.m394g(iM342c);
                            }
                            i4 = i5 + 1;
                        } else {
                            for (C0409h c0409h : c0409hArrM338f) {
                                c0416oM354a2.m392f(c0409h.m343a());
                                c0416oM354a2.m390e(c0409h.m344b());
                                c0416oM354a2.m390e(iArr[c0409h.m345c()]);
                            }
                        }
                    }
                }
            }
            i++;
            i2 = iM1411d;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1350a(C0730m c0730m, C0404c[] c0404cArr) {
        int i = 0;
        int length = c0404cArr.length;
        int i2 = 0;
        while (i < length) {
            C0404c c0404c = c0404cArr[i];
            int iM1409c = c0730m.m1409c(c0404c.m318a());
            this.f1537j.m394g(iM1409c - i2);
            this.f1537j.m394g(c0404c.m319b());
            i++;
            i2 = iM1409c;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1351a(C0738u[] c0738uArr, C0410i c0410i, C0730m c0730m) {
        for (C0406e c0406e : c0410i.m369k()) {
            C0738u c0738u = new C0738u(c0410i, c0406e);
            C0738u c0738u2 = new C0738u(c0738u.m1432a(), c0730m.m1402a(c0738u.m1434b()));
            int iM1435c = c0738u2.m1435c();
            if (c0738uArr[iM1435c] == null) {
                c0738uArr[iM1435c] = c0738u2;
            } else if (this.f1530c != C0718a.f1526a) {
                throw new C0420s("Multiple dex files define " + ((String) c0410i.m365g().get(c0406e.m324b())));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private C0410i m1352b() {
        boolean zM1433a;
        new C0720c(this, this.f1534g).m1379a();
        new C0721d(this, this.f1534g).m1379a();
        new C0722e(this, this.f1536i).m1380b();
        new C0723f(this, this.f1534g).m1379a();
        new C0724g(this, this.f1534g).m1379a();
        new C0725h(this, this.f1534g).m1379a();
        new C0726i(this, this.f1545r).m1380b();
        m1348a(this.f1528a, this.f1547t);
        m1348a(this.f1529b, this.f1548u);
        m1354b(this.f1528a, this.f1547t);
        m1354b(this.f1529b, this.f1548u);
        m1356c(this.f1528a, this.f1547t);
        m1356c(this.f1529b, this.f1548u);
        m1358d(this.f1528a, this.f1547t);
        m1358d(this.f1529b, this.f1548u);
        C0738u[] c0738uArr = new C0738u[this.f1546s.f424c.f342b];
        m1351a(c0738uArr, this.f1528a, this.f1547t);
        m1351a(c0738uArr, this.f1529b, this.f1548u);
        do {
            zM1433a = true;
            for (C0738u c0738u : c0738uArr) {
                if (c0738u != null && !c0738u.m1436d()) {
                    zM1433a &= c0738u.m1433a(c0738uArr);
                }
            }
        } while (!zM1433a);
        Arrays.sort(c0738uArr, C0738u.f1601a);
        int iIndexOf = Arrays.asList(c0738uArr).indexOf(null);
        C0738u[] c0738uArr2 = iIndexOf != -1 ? (C0738u[]) Arrays.copyOfRange(c0738uArr, 0, iIndexOf) : c0738uArr;
        this.f1546s.f428g.f343c = this.f1534g.m378a();
        this.f1546s.f428g.f342b = c0738uArr2.length;
        for (C0738u c0738u2 : c0738uArr2) {
            C0410i c0410iM1432a = c0738u2.m1432a();
            C0730m c0730m = c0410iM1432a == this.f1528a ? this.f1547t : this.f1548u;
            C0406e c0406eM1434b = c0738u2.m1434b();
            this.f1534g.m401m();
            this.f1534g.m392f(c0406eM1434b.m324b());
            this.f1534g.m392f(c0406eM1434b.m328f());
            this.f1534g.m392f(c0406eM1434b.m325c());
            this.f1534g.m392f(c0406eM1434b.m326d());
            this.f1534g.m392f(c0730m.m1399a(c0406eM1434b.m329g()));
            this.f1534g.m392f(c0730m.m1418h(c0406eM1434b.m330h()));
            if (c0406eM1434b.m331i() == 0) {
                this.f1534g.m392f(0);
            } else {
                this.f1534g.m392f(this.f1537j.m378a());
                C0403b c0403bM352a = c0410iM1432a.m352a(c0406eM1434b);
                this.f1546s.f433l.f342b++;
                C0404c[] c0404cArrM314a = c0403bM352a.m314a();
                C0404c[] c0404cArrM315b = c0403bM352a.m315b();
                C0405d[] c0405dArrM316c = c0403bM352a.m316c();
                C0405d[] c0405dArrM317d = c0403bM352a.m317d();
                this.f1537j.m394g(c0404cArrM314a.length);
                this.f1537j.m394g(c0404cArrM315b.length);
                this.f1537j.m394g(c0405dArrM316c.length);
                this.f1537j.m394g(c0405dArrM317d.length);
                m1350a(c0730m, c0404cArrM314a);
                m1350a(c0730m, c0404cArrM315b);
                m1349a(c0410iM1432a, c0730m, c0405dArrM316c);
                m1349a(c0410iM1432a, c0730m, c0405dArrM317d);
            }
            this.f1534g.m392f(c0730m.m1419i(c0406eM1434b.m332j()));
        }
        this.f1546s.f422a.f343c = 0;
        this.f1546s.f422a.f342b = 1;
        this.f1546s.f443v = this.f1532e.m358b();
        this.f1546s.m441a();
        C0427z c0427z = this.f1546s;
        C0416o c0416o = this.f1533f;
        c0416o.m382a(C0985a.m2253c(13).getBytes("UTF-8"));
        c0416o.m392f(c0427z.f441t);
        c0416o.m382a(c0427z.f442u);
        c0416o.m392f(c0427z.f443v);
        c0416o.m392f(C0299R.styleable.AppCompatTheme_ratingBarStyleSmall);
        c0416o.m392f(305419896);
        c0416o.m392f(c0427z.f444w);
        c0416o.m392f(c0427z.f445x);
        c0416o.m392f(c0427z.f429h.f343c);
        c0416o.m392f(c0427z.f423b.f342b);
        c0416o.m392f(c0427z.f423b.f343c);
        c0416o.m392f(c0427z.f424c.f342b);
        c0416o.m392f(c0427z.f424c.f343c);
        c0416o.m392f(c0427z.f425d.f342b);
        c0416o.m392f(c0427z.f425d.f343c);
        c0416o.m392f(c0427z.f426e.f342b);
        c0416o.m392f(c0427z.f426e.f343c);
        c0416o.m392f(c0427z.f427f.f342b);
        c0416o.m392f(c0427z.f427f.f343c);
        c0416o.m392f(c0427z.f428g.f342b);
        c0416o.m392f(c0427z.f428g.f343c);
        c0416o.m392f(c0427z.f446y);
        c0416o.m392f(c0427z.f447z);
        C0427z c0427z2 = this.f1546s;
        C0416o c0416o2 = this.f1535h;
        C0401aa[] c0401aaArr = c0427z2.f440s;
        int i = 0;
        for (int i2 = 0; i2 < 18; i2++) {
            if (c0401aaArr[i2].m312a()) {
                i++;
            }
        }
        c0416o2.m392f(i);
        C0401aa[] c0401aaArr2 = c0427z2.f440s;
        for (int i3 = 0; i3 < 18; i3++) {
            C0401aa c0401aa = c0401aaArr2[i3];
            if (c0401aa.m312a()) {
                c0416o2.m381a(c0401aa.f341a);
                c0416o2.m381a((short) 0);
                c0416o2.m392f(c0401aa.f342b);
                c0416o2.m392f(c0401aa.f343c);
            }
        }
        this.f1532e.m370l();
        return this.f1532e;
    }

    /* JADX INFO: renamed from: b */
    private void m1354b(C0410i c0410i, C0730m c0730m) {
        C0401aa c0401aa = c0410i.m356a().f431j;
        if (c0401aa.m312a()) {
            C0416o c0416oM354a = c0410i.m354a(c0401aa.f343c);
            for (int i = 0; i < c0401aa.f342b; i++) {
                this.f1546s.f431j.f342b++;
                this.f1544q.m401m();
                c0730m.m1412d(c0416oM354a.m378a(), this.f1544q.m378a());
                int iM385b = c0416oM354a.m385b();
                this.f1544q.m392f(iM385b);
                for (int i2 = 0; i2 < iM385b; i2++) {
                    this.f1544q.m392f(c0730m.m1415f(c0416oM354a.m385b()));
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1356c(C0410i c0410i, C0730m c0730m) {
        C0401aa c0401aa = c0410i.m356a().f439r;
        if (c0401aa.m312a()) {
            C0416o c0416oM354a = c0410i.m354a(c0401aa.f343c);
            for (int i = 0; i < c0401aa.f342b; i++) {
                this.f1546s.f439r.f342b++;
                this.f1542o.m401m();
                c0730m.m1414e(c0416oM354a.m378a(), this.f1542o.m378a());
                this.f1542o.m392f(c0730m.m1415f(c0416oM354a.m385b()));
                int iM385b = c0416oM354a.m385b();
                this.f1542o.m392f(iM385b);
                int iM385b2 = c0416oM354a.m385b();
                this.f1542o.m392f(iM385b2);
                int iM385b3 = c0416oM354a.m385b();
                this.f1542o.m392f(iM385b3);
                for (int i2 = 0; i2 < iM385b; i2++) {
                    this.f1542o.m392f(c0730m.m1409c(c0416oM354a.m385b()));
                    this.f1542o.m392f(c0730m.m1415f(c0416oM354a.m385b()));
                }
                for (int i3 = 0; i3 < iM385b2; i3++) {
                    this.f1542o.m392f(c0730m.m1411d(c0416oM354a.m385b()));
                    this.f1542o.m392f(c0730m.m1415f(c0416oM354a.m385b()));
                }
                for (int i4 = 0; i4 < iM385b3; i4++) {
                    this.f1542o.m392f(c0730m.m1411d(c0416oM354a.m385b()));
                    this.f1542o.m392f(c0730m.m1417g(c0416oM354a.m385b()));
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1358d(C0410i c0410i, C0730m c0730m) {
        C0401aa c0401aa = c0410i.m356a().f438q;
        if (c0401aa.m312a()) {
            C0416o c0416oM354a = c0410i.m354a(c0401aa.f343c);
            for (int i = 0; i < c0401aa.f342b; i++) {
                this.f1546s.f438q.f342b++;
                c0730m.m1416f(c0416oM354a.m378a(), this.f1541n.m378a());
                C0422u c0422uM399k = c0416oM354a.m399k();
                C0888r c0888r = new C0888r(32);
                new C0731n(c0730m, c0888r).m1425c(new C0423v(c0422uM399k, 28));
                new C0422u(c0888r.m2028g()).m406a(this.f1541n);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0410i m1373a() {
        long jNanoTime = System.nanoTime();
        C0410i c0410iM1352b = m1352b();
        C0729l c0729l = new C0729l(this);
        int iM1397a = this.f1531d.m1397a() - c0729l.m1397a();
        if (iM1397a > this.f1551x) {
            c0410iM1352b = new C0719b(this.f1532e, new C0410i(0), C0718a.f1527b, c0729l).m1352b();
            System.out.printf("Result compacted from %.1fKiB to %.1fKiB to save %.1fKiB%n", Float.valueOf(this.f1532e.m358b() / 1024.0f), Float.valueOf(c0410iM1352b.m358b() / 1024.0f), Float.valueOf(iM1397a / 1024.0f));
        }
        System.out.printf("Merged dex A (%d defs/%.1fKiB) with dex B (%d defs/%.1fKiB). Result is %d defs/%.1fKiB. Took %.1fs%n", Integer.valueOf(this.f1528a.m356a().f428g.f342b), Float.valueOf(this.f1528a.m358b() / 1024.0f), Integer.valueOf(this.f1529b.m356a().f428g.f342b), Float.valueOf(this.f1529b.m358b() / 1024.0f), Integer.valueOf(c0410iM1352b.m356a().f428g.f342b), Float.valueOf(c0410iM1352b.m358b() / 1024.0f), Float.valueOf((System.nanoTime() - jNanoTime) / 1.0E9f));
        return c0410iM1352b;
    }
}
