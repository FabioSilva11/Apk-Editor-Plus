package com.p016a.p019b.p035e;

import com.p016a.p017a.C0396a;
import com.p016a.p017a.C0402ab;
import com.p016a.p017a.C0406e;
import com.p016a.p017a.C0410i;
import com.p016a.p017a.C0422u;
import com.p016a.p017a.C0424w;
import com.p016a.p017a.C0425x;
import com.p016a.p017a.C0426y;
import com.p016a.p017a.C0427z;
import com.p016a.p019b.p043h.C0888r;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.e.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0730m {

    /* JADX INFO: renamed from: a */
    public final int[] f1578a;

    /* JADX INFO: renamed from: b */
    public final short[] f1579b;

    /* JADX INFO: renamed from: c */
    public final short[] f1580c;

    /* JADX INFO: renamed from: d */
    public final short[] f1581d;

    /* JADX INFO: renamed from: e */
    public final short[] f1582e;

    /* JADX INFO: renamed from: f */
    private final C0410i f1583f;

    /* JADX INFO: renamed from: g */
    private final HashMap f1584g = new HashMap();

    /* JADX INFO: renamed from: h */
    private final HashMap f1585h = new HashMap();

    /* JADX INFO: renamed from: i */
    private final HashMap f1586i = new HashMap();

    /* JADX INFO: renamed from: j */
    private final HashMap f1587j = new HashMap();

    /* JADX INFO: renamed from: k */
    private final HashMap f1588k = new HashMap();

    /* JADX INFO: renamed from: l */
    private final HashMap f1589l = new HashMap();

    public C0730m(C0410i c0410i, C0427z c0427z) {
        this.f1583f = c0410i;
        this.f1578a = new int[c0427z.f423b.f342b];
        this.f1579b = new short[c0427z.f424c.f342b];
        this.f1580c = new short[c0427z.f425d.f342b];
        this.f1581d = new short[c0427z.f426e.f342b];
        this.f1582e = new short[c0427z.f427f.f342b];
        this.f1584g.put(0, 0);
        this.f1586i.put(0, 0);
        this.f1588k.put(0, 0);
        this.f1589l.put(0, 0);
    }

    /* JADX INFO: renamed from: j */
    private int m1398j(int i) {
        return ((Integer) this.f1584g.get(Integer.valueOf(i))).intValue();
    }

    /* JADX INFO: renamed from: a */
    public final int m1399a(int i) {
        if (i == -1) {
            return -1;
        }
        return this.f1578a[i];
    }

    /* JADX INFO: renamed from: a */
    public final C0396a m1400a(C0396a c0396a) {
        C0888r c0888r = new C0888r(32);
        new C0731n(this, c0888r).m1423b(c0396a.m305b());
        return new C0396a(this.f1583f, c0396a.m303a(), new C0422u(c0888r.m2028g()));
    }

    /* JADX INFO: renamed from: a */
    public final C0402ab m1401a(C0402ab c0402ab) {
        if (c0402ab == C0402ab.f345a) {
            return c0402ab;
        }
        short[] sArr = (short[]) c0402ab.m313a().clone();
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) m1407b(sArr[i]);
        }
        return new C0402ab(this.f1583f, sArr);
    }

    /* JADX INFO: renamed from: a */
    public final C0406e m1402a(C0406e c0406e) {
        return new C0406e(this.f1583f, c0406e.m323a(), m1407b(c0406e.m324b()), c0406e.m328f(), m1407b(c0406e.m325c()), m1398j(c0406e.m326d()), c0406e.m329g(), c0406e.m330h(), c0406e.m331i(), c0406e.m332j());
    }

    /* JADX INFO: renamed from: a */
    public final C0424w m1403a(C0424w c0424w) {
        return new C0424w(this.f1583f, m1407b(c0424w.m428a()), m1407b(c0424w.m430b()), m1399a(c0424w.m431c()));
    }

    /* JADX INFO: renamed from: a */
    public final C0425x m1404a(C0425x c0425x) {
        return new C0425x(this.f1583f, m1407b(c0425x.m432a()), this.f1580c[c0425x.m434b()] & 65535, m1399a(c0425x.m435c()));
    }

    /* JADX INFO: renamed from: a */
    public final C0426y m1405a(C0426y c0426y) {
        return new C0426y(this.f1583f, m1399a(c0426y.m436a()), m1407b(c0426y.m438b()), m1398j(c0426y.m439c()));
    }

    /* JADX INFO: renamed from: a */
    public final void m1406a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f1584g.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: b */
    public final int m1407b(int i) {
        if (i == -1) {
            return -1;
        }
        return this.f1579b[i] & 65535;
    }

    /* JADX INFO: renamed from: b */
    public final void m1408b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f1585h.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: c */
    public final int m1409c(int i) {
        return this.f1581d[i] & 65535;
    }

    /* JADX INFO: renamed from: c */
    public final void m1410c(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f1586i.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: d */
    public final int m1411d(int i) {
        return this.f1582e[i] & 65535;
    }

    /* JADX INFO: renamed from: d */
    public final void m1412d(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f1587j.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: e */
    public final int m1413e(int i) {
        return ((Integer) this.f1585h.get(Integer.valueOf(i))).intValue();
    }

    /* JADX INFO: renamed from: e */
    public final void m1414e(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f1588k.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: f */
    public final int m1415f(int i) {
        return ((Integer) this.f1586i.get(Integer.valueOf(i))).intValue();
    }

    /* JADX INFO: renamed from: f */
    public final void m1416f(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f1589l.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: g */
    public final int m1417g(int i) {
        return ((Integer) this.f1587j.get(Integer.valueOf(i))).intValue();
    }

    /* JADX INFO: renamed from: h */
    public final int m1418h(int i) {
        return ((Integer) this.f1588k.get(Integer.valueOf(i))).intValue();
    }

    /* JADX INFO: renamed from: i */
    public final int m1419i(int i) {
        return ((Integer) this.f1589l.get(Integer.valueOf(i))).intValue();
    }
}
