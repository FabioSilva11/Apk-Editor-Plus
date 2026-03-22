package com.p016a.p019b.p035e;

import android.support.v7.appcompat.C0299R;
import com.p016a.p017a.C0410i;
import com.p016a.p017a.C0427z;

/* JADX INFO: renamed from: com.a.b.e.l */
/* JADX INFO: loaded from: classes.dex */
final class C0729l {

    /* JADX INFO: renamed from: a */
    private int f1565a;

    /* JADX INFO: renamed from: b */
    private int f1566b;

    /* JADX INFO: renamed from: c */
    private int f1567c;

    /* JADX INFO: renamed from: d */
    private int f1568d;

    /* JADX INFO: renamed from: e */
    private int f1569e;

    /* JADX INFO: renamed from: f */
    private int f1570f;

    /* JADX INFO: renamed from: g */
    private int f1571g;

    /* JADX INFO: renamed from: h */
    private int f1572h;

    /* JADX INFO: renamed from: i */
    private int f1573i;

    /* JADX INFO: renamed from: j */
    private int f1574j;

    /* JADX INFO: renamed from: k */
    private int f1575k;

    /* JADX INFO: renamed from: l */
    private int f1576l;

    /* JADX INFO: renamed from: m */
    private int f1577m;

    public C0729l(C0410i c0410i, C0410i c0410i2) {
        this.f1565a = C0299R.styleable.AppCompatTheme_ratingBarStyleSmall;
        m1383a(c0410i.m356a(), false);
        m1383a(c0410i2.m356a(), false);
        m1385b();
    }

    public C0729l(C0719b c0719b) {
        this.f1565a = C0299R.styleable.AppCompatTheme_ratingBarStyleSmall;
        this.f1565a = c0719b.f1533f.m402n();
        this.f1566b = c0719b.f1534g.m402n();
        this.f1567c = c0719b.f1535h.m402n();
        this.f1568d = c0719b.f1536i.m402n();
        this.f1569e = c0719b.f1537j.m402n();
        this.f1570f = c0719b.f1538k.m402n();
        this.f1571g = c0719b.f1539l.m402n();
        this.f1572h = c0719b.f1540m.m402n();
        this.f1573i = c0719b.f1541n.m402n();
        this.f1574j = c0719b.f1542o.m402n();
        this.f1575k = c0719b.f1543p.m402n();
        this.f1576l = c0719b.f1544q.m402n();
        this.f1577m = c0719b.f1545r.m402n();
        m1385b();
    }

    /* JADX INFO: renamed from: a */
    private void m1383a(C0427z c0427z, boolean z) {
        this.f1566b += (c0427z.f423b.f342b << 2) + (c0427z.f424c.f342b << 2) + (c0427z.f425d.f342b * 12) + (c0427z.f426e.f342b << 3) + (c0427z.f427f.f342b << 3) + (c0427z.f428g.f342b << 5);
        this.f1567c = 220;
        this.f1568d += (c0427z.f430i.f344d + 3) & (-4);
        this.f1571g += c0427z.f435n.f344d;
        this.f1574j += c0427z.f439r.f344d;
        this.f1575k += c0427z.f432k.f344d;
        this.f1576l += c0427z.f431j.f344d;
        this.f1570f += (int) Math.ceil(((double) c0427z.f434m.f344d) * 1.25d);
        this.f1569e += (int) Math.ceil(((double) c0427z.f433l.f344d) * 1.34d);
        this.f1573i += c0427z.f438q.f344d << 1;
        this.f1577m += (int) Math.ceil(c0427z.f437p.f344d << 1);
        this.f1572h += c0427z.f436o.f344d << 1;
    }

    /* JADX INFO: renamed from: b */
    private void m1385b() {
        this.f1565a = (this.f1565a + 3) & (-4);
        this.f1566b = (this.f1566b + 3) & (-4);
        this.f1567c = (this.f1567c + 3) & (-4);
        this.f1568d = (this.f1568d + 3) & (-4);
        this.f1569e = (this.f1569e + 3) & (-4);
        this.f1570f = (this.f1570f + 3) & (-4);
        this.f1571g = (this.f1571g + 3) & (-4);
        this.f1572h = (this.f1572h + 3) & (-4);
        this.f1573i = (this.f1573i + 3) & (-4);
        this.f1574j = (this.f1574j + 3) & (-4);
        this.f1575k = (this.f1575k + 3) & (-4);
        this.f1576l = (this.f1576l + 3) & (-4);
        this.f1577m = (this.f1577m + 3) & (-4);
    }

    /* JADX INFO: renamed from: a */
    public final int m1397a() {
        return this.f1565a + this.f1566b + this.f1567c + this.f1568d + this.f1569e + this.f1570f + this.f1571g + this.f1572h + this.f1573i + this.f1574j + this.f1575k + this.f1576l + this.f1577m;
    }
}
