package com.p016a.p019b.p028c.p030b;

import android.support.v7.widget.ActivityChooserView;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0770v;
import com.p016a.p019b.p036f.p040d.C0805c;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.a.b.c.b.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0597v {

    /* JADX INFO: renamed from: a */
    private final ArrayList f1029a;

    /* JADX INFO: renamed from: b */
    private int f1030b = 0;

    /* JADX INFO: renamed from: c */
    private C0770v f1031c = null;

    /* JADX INFO: renamed from: d */
    private int[] f1032d = null;

    /* JADX INFO: renamed from: e */
    private int f1033e = 0;

    public C0597v(int i) {
        this.f1029a = new ArrayList(i);
    }

    /* JADX INFO: renamed from: a */
    private static C0766r m1020a(C0766r c0766r) {
        return (c0766r == null || c0766r.mo663a() != C0805c.f2019j) ? c0766r : c0766r.m1528a(C0805c.f2023n);
    }

    /* JADX INFO: renamed from: a */
    private void m1021a(int i, int i2) {
        boolean z = this.f1032d == null;
        if (i != 0 || z) {
            if (i < 0) {
                throw new RuntimeException("shouldn't happen");
            }
            if (z || i2 >= this.f1032d.length) {
                int i3 = i2 + 1;
                C0770v c0770v = new C0770v(i3);
                int[] iArr = new int[i3];
                Arrays.fill(iArr, -1);
                if (!z) {
                    c0770v.m1565a(this.f1031c);
                    System.arraycopy(this.f1032d, 0, iArr, 0, this.f1032d.length);
                }
                this.f1031c = c0770v;
                this.f1032d = iArr;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1022a(int i, EnumC0595t enumC0595t, C0766r c0766r) {
        int iM1533g = c0766r.m1533g();
        this.f1029a.add(new C0596u(i, enumC0595t, c0766r));
        if (enumC0595t == EnumC0595t.f1019a) {
            this.f1031c.m1572d(c0766r);
            this.f1032d[iM1533g] = -1;
        } else {
            this.f1031c.m1570c(c0766r);
            this.f1032d[iM1533g] = this.f1029a.size() - 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1023a(int i, C0766r c0766r, EnumC0595t enumC0595t) {
        boolean z;
        boolean z2 = false;
        int iM1533g = c0766r.m1533g();
        C0766r c0766rM1020a = m1020a(c0766r);
        m1021a(i, iM1533g);
        if (this.f1032d[iM1533g] >= 0) {
            return;
        }
        int size = this.f1029a.size() - 1;
        while (size >= 0) {
            C0596u c0596u = (C0596u) this.f1029a.get(size);
            if (c0596u != null) {
                if (c0596u.m1009a() == i) {
                    if (c0596u.m1012a(c0766rM1020a)) {
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            size--;
        }
        this.f1031c.m1570c(c0766rM1020a);
        this.f1029a.set(size, null);
        this.f1030b++;
        int iM1533g2 = c0766rM1020a.m1533g();
        int i2 = size - 1;
        C0596u c0596u2 = null;
        while (true) {
            if (i2 >= 0) {
                c0596u2 = (C0596u) this.f1029a.get(i2);
                if (c0596u2 != null && c0596u2.m1019h().m1533g() == iM1533g2) {
                    z2 = true;
                    break;
                }
                i2--;
            } else {
                break;
            }
        }
        if (z2) {
            this.f1032d[iM1533g2] = i2;
            if (c0596u2.m1009a() == i) {
                this.f1029a.set(i2, c0596u2.m1010a(EnumC0595t.f1020b));
            }
        }
        z = true;
        if (z) {
            return;
        }
        m1022a(i, enumC0595t, c0766rM1020a);
    }

    /* JADX INFO: renamed from: b */
    private void m1024b(int i, EnumC0595t enumC0595t, C0766r c0766r) {
        if (enumC0595t == EnumC0595t.f1019a) {
            throw new RuntimeException("shouldn't happen");
        }
        int i2 = this.f1032d[c0766r.m1533g()];
        if (i2 >= 0) {
            C0596u c0596u = (C0596u) this.f1029a.get(i2);
            if (c0596u.m1009a() == i && c0596u.m1019h().equals(c0766r)) {
                this.f1029a.set(i2, c0596u.m1010a(enumC0595t));
                this.f1031c.m1570c(c0766r);
                return;
            }
        }
        m1023a(i, c0766r, enumC0595t);
    }

    /* JADX INFO: renamed from: b */
    private void m1025b(int i, C0766r c0766r) {
        m1023a(i, c0766r, EnumC0595t.f1020b);
    }

    /* JADX INFO: renamed from: a */
    public final C0594s m1026a() {
        int i;
        m1021a(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
        int size = this.f1029a.size();
        int i2 = size - this.f1030b;
        if (i2 == 0) {
            return C0594s.f1018a;
        }
        C0596u[] c0596uArr = new C0596u[i2];
        if (size == i2) {
            this.f1029a.toArray(c0596uArr);
        } else {
            int i3 = 0;
            for (C0596u c0596u : this.f1029a) {
                if (c0596u != null) {
                    c0596uArr[i3] = c0596u;
                    i = i3 + 1;
                } else {
                    i = i3;
                }
                i3 = i;
            }
        }
        Arrays.sort(c0596uArr);
        C0594s c0594s = new C0594s(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            c0594s.m1007a(i4, c0596uArr[i4]);
        }
        c0594s.mo549b_();
        return c0594s;
    }

    /* JADX INFO: renamed from: a */
    public final void m1027a(int i, C0766r c0766r) {
        C0766r c0766rM1562a;
        C0766r c0766rM1562a2;
        int iM1533g = c0766r.m1533g();
        C0766r c0766rM1020a = m1020a(c0766r);
        m1021a(i, iM1533g);
        C0766r c0766rM1562a3 = this.f1031c.m1562a(iM1533g);
        if (c0766rM1020a.m1529a(c0766rM1562a3)) {
            return;
        }
        C0766r c0766rM1568b = this.f1031c.m1568b(c0766rM1020a);
        if (c0766rM1568b != null) {
            m1024b(i, EnumC0595t.f1022d, c0766rM1568b);
        }
        int i2 = this.f1032d[iM1533g];
        if (c0766rM1562a3 != null) {
            m1022a(i, EnumC0595t.f1021c, c0766rM1562a3);
        } else if (i2 >= 0) {
            C0596u c0596u = (C0596u) this.f1029a.get(i2);
            if (c0596u.m1009a() == i) {
                if (c0596u.m1012a(c0766rM1020a)) {
                    this.f1029a.set(i2, null);
                    this.f1030b++;
                    this.f1031c.m1572d(c0766rM1020a);
                    this.f1032d[iM1533g] = -1;
                    return;
                }
                this.f1029a.set(i2, c0596u.m1010a(EnumC0595t.f1021c));
            }
        }
        if (iM1533g > 0 && (c0766rM1562a2 = this.f1031c.m1562a(iM1533g - 1)) != null && c0766rM1562a2.m1538l()) {
            m1024b(i, EnumC0595t.f1024f, c0766rM1562a2);
        }
        if (c0766rM1020a.m1538l() && (c0766rM1562a = this.f1031c.m1562a(iM1533g + 1)) != null) {
            m1024b(i, EnumC0595t.f1023e, c0766rM1562a);
        }
        m1022a(i, EnumC0595t.f1019a, c0766rM1020a);
    }

    /* JADX INFO: renamed from: a */
    public final void m1028a(int i, C0770v c0770v) {
        int iM1567b = c0770v.m1567b();
        m1021a(i, iM1567b - 1);
        for (int i2 = 0; i2 < iM1567b; i2++) {
            C0766r c0766rM1562a = this.f1031c.m1562a(i2);
            C0766r c0766rM1020a = m1020a(c0770v.m1562a(i2));
            if (c0766rM1562a == null) {
                if (c0766rM1020a != null) {
                    m1027a(i, c0766rM1020a);
                }
            } else if (c0766rM1020a == null) {
                m1025b(i, c0766rM1562a);
            } else if (!c0766rM1020a.m1529a(c0766rM1562a)) {
                m1025b(i, c0766rM1562a);
                m1027a(i, c0766rM1020a);
            }
        }
    }
}
