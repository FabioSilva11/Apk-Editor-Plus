package com.p016a.p019b.p028c.p030b;

import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p043h.C0877g;
import com.p016a.p019b.p043h.C0878h;
import com.p016a.p019b.p043h.C0888r;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.c.b.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0588m extends C0877g {

    /* JADX INFO: renamed from: a */
    private final int f791a;

    private C0588m(int i, int i2) {
        super(i);
        this.f791a = i2;
    }

    /* JADX INFO: renamed from: a */
    public static C0588m m967a(ArrayList arrayList, int i) {
        int size = arrayList.size();
        C0588m c0588m = new C0588m(size, i);
        for (int i2 = 0; i2 < size; i2++) {
            c0588m.m1975a(i2, (AbstractC0587l) arrayList.get(i2));
        }
        c0588m.mo549b_();
        return c0588m;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0587l m968a(int i) {
        return (AbstractC0587l) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m969a(C0888r c0888r) {
        int iM2008a = c0888r.m2008a();
        int iD_ = m1977d_();
        if (c0888r.m2019b()) {
            boolean zM2021c = c0888r.m2021c();
            for (int i = 0; i < iD_; i++) {
                AbstractC0587l abstractC0587l = (AbstractC0587l) m1978e(i);
                int iMo840a = abstractC0587l.mo840a() << 1;
                String strM954a = (iMo840a != 0 || zM2021c) ? abstractC0587l.m954a("  ", c0888r.m2023e(), true) : null;
                if (strM954a != null) {
                    c0888r.m2010a(iMo840a, strM954a);
                } else if (iMo840a != 0) {
                    c0888r.m2010a(iMo840a, "");
                }
            }
        }
        for (int i2 = 0; i2 < iD_; i2++) {
            AbstractC0587l abstractC0587l2 = (AbstractC0587l) m1978e(i2);
            try {
                abstractC0587l2.mo843a(c0888r);
            } catch (RuntimeException e) {
                throw C0400d.m308a(e, "...while writing " + abstractC0587l2);
            }
        }
        int iM2008a2 = (c0888r.m2008a() - iM2008a) / 2;
        if (iM2008a2 != m971e()) {
            throw new RuntimeException("write length mismatch; expected " + m971e() + " but actually wrote " + iM2008a2);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m970a(Writer writer, String str, boolean z) {
        C0878h c0878h = new C0878h(writer, 0, str);
        int iD_ = m1977d_();
        for (int i = 0; i < iD_; i++) {
            try {
                AbstractC0587l abstractC0587l = (AbstractC0587l) m1978e(i);
                String strM954a = (abstractC0587l.mo840a() != 0 || z) ? abstractC0587l.m954a("", 0, z) : null;
                if (strM954a != null) {
                    c0878h.write(strM954a);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        c0878h.flush();
    }

    /* JADX INFO: renamed from: e */
    public final int m971e() {
        int iD_ = m1977d_();
        if (iD_ == 0) {
            return 0;
        }
        return m968a(iD_ - 1).m966m();
    }

    /* JADX INFO: renamed from: f */
    public final int m972f() {
        return this.f791a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m973g() {
        /*
            r7 = this;
            r3 = 0
            int r6 = r7.m1977d_()
            r5 = r3
            r4 = r3
        L7:
            if (r5 >= r6) goto L3c
            java.lang.Object r0 = r7.m1978e(r5)
            com.a.b.c.b.l r0 = (com.p016a.p019b.p028c.p030b.AbstractC0587l) r0
            boolean r1 = r0 instanceof com.p016a.p019b.p028c.p030b.C0584i
            if (r1 == 0) goto L3d
            r1 = r0
            com.a.b.c.b.i r1 = (com.p016a.p019b.p028c.p030b.C0584i) r1
            com.a.b.f.c.a r1 = r1.m937c()
            boolean r2 = r1 instanceof com.p016a.p019b.p036f.p039c.AbstractC0782f
            if (r2 == 0) goto L3d
            com.a.b.c.b.n r0 = r0.m961h()
            int r0 = r0.m975b()
            r2 = 113(0x71, float:1.58E-43)
            if (r0 != r2) goto L3a
            r0 = 1
            r2 = r0
        L2c:
            r0 = r1
            com.a.b.f.c.f r0 = (com.p016a.p019b.p036f.p039c.AbstractC0782f) r0
            int r0 = r0.m1617b(r2)
            if (r0 <= r4) goto L3d
        L35:
            int r1 = r5 + 1
            r5 = r1
            r4 = r0
            goto L7
        L3a:
            r2 = r3
            goto L2c
        L3c:
            return r4
        L3d:
            r0 = r4
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p019b.p028c.p030b.C0588m.m973g():int");
    }
}
