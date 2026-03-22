package com.p016a.p019b.p028c.p030b;

import com.p016a.p017a.C0420s;
import com.p016a.p019b.p028c.C0533a;
import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0770v;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0797u;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p041g.C0808a;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.c.b.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C0563aa {

    /* JADX INFO: renamed from: a */
    private final C0533a f728a;

    /* JADX INFO: renamed from: b */
    private final int f729b;

    /* JADX INFO: renamed from: c */
    private ArrayList f730c;

    /* JADX INFO: renamed from: g */
    private int f734g;

    /* JADX INFO: renamed from: h */
    private final int f735h;

    /* JADX INFO: renamed from: f */
    private int f733f = -1;

    /* JADX INFO: renamed from: d */
    private boolean f731d = false;

    /* JADX INFO: renamed from: e */
    private boolean f732e = false;

    public C0563aa(C0533a c0533a, int i, int i2, int i3) {
        this.f728a = c0533a;
        this.f729b = i2;
        this.f730c = new ArrayList(i);
        this.f735h = i3;
    }

    /* JADX INFO: renamed from: a */
    private C0589n m854a(AbstractC0587l abstractC0587l, C0589n c0589n) {
        while (c0589n != null && (!c0589n.m976c().mo850b(abstractC0587l) || (this.f728a.f682c && c0589n.m974a() == 26))) {
            c0589n = C0590o.m982a(c0589n);
        }
        return c0589n;
    }

    /* JADX INFO: renamed from: a */
    private void m855a(int i) {
        int size = this.f730c.size();
        int i2 = this.f734g + this.f729b + this.f733f;
        int i3 = i2 - this.f735h;
        C0808a c0808a = new C0808a(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 >= i3) {
                c0808a.mo1701a(i4, i4 + 1, 1);
            } else {
                c0808a.mo1701a(i4, i4, 1);
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            AbstractC0587l abstractC0587l = (AbstractC0587l) this.f730c.get(i5);
            if (!(abstractC0587l instanceof C0583h)) {
                this.f730c.set(i5, abstractC0587l.mo953a(c0808a));
            }
        }
        this.f734g++;
    }

    /* JADX INFO: renamed from: a */
    private static void m856a(HashSet hashSet, AbstractC0587l abstractC0587l) {
        if (abstractC0587l instanceof C0584i) {
            hashSet.add(((C0584i) abstractC0587l).m937c());
            return;
        }
        if (!(abstractC0587l instanceof C0598w)) {
            if (abstractC0587l instanceof C0599x) {
                m857a(hashSet, ((C0599x) abstractC0587l).m1031c());
            }
        } else {
            C0770v c0770vM1029c = ((C0598w) abstractC0587l).m1029c();
            int iM1571d = c0770vM1029c.m1571d();
            for (int i = 0; i < iM1571d; i++) {
                m857a(hashSet, c0770vM1029c.m1562a(i));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m857a(HashSet hashSet, C0766r c0766r) {
        if (c0766r == null) {
            return;
        }
        C0761m c0761mM1535i = c0766r.m1535i();
        C0801y c0801yM1505a = c0761mM1535i.m1505a();
        C0801y c0801yM1506b = c0761mM1535i.m1506b();
        C0805c c0805cMo663a = c0766r.mo663a();
        if (c0805cMo663a != C0805c.f2019j) {
            hashSet.add(C0802z.m1654b(c0805cMo663a));
        }
        if (c0801yM1505a != null) {
            hashSet.add(c0801yM1505a);
        }
        if (c0801yM1506b != null) {
            hashSet.add(c0801yM1506b);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m858a(C0766r c0766r) {
        return (c0766r == null || c0766r.m1535i().m1505a() == null) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m859a(C0589n[] c0589nArr) {
        int i;
        boolean z;
        if (this.f733f < 0) {
            i = 0;
            z = false;
        } else {
            i = this.f733f;
            z = false;
        }
        while (true) {
            int size = this.f730c.size();
            int i2 = this.f733f;
            for (int i3 = 0; i3 < size; i3++) {
                AbstractC0587l abstractC0587l = (AbstractC0587l) this.f730c.get(i3);
                C0589n c0589n = c0589nArr[i3];
                C0589n c0589nM854a = m854a(abstractC0587l, c0589n);
                if (c0589nM854a == null) {
                    int iM952a = abstractC0587l.m952a(m860b(abstractC0587l).m976c().mo851c(abstractC0587l));
                    if (iM952a > i2) {
                        i2 = iM952a;
                    }
                } else {
                    if (c0589n != c0589nM854a) {
                    }
                }
                c0589nArr[i3] = c0589nM854a;
            }
            if (i >= i2) {
                this.f733f = i;
                return z;
            }
            z = true;
            int i4 = i2 - i;
            int size2 = this.f730c.size();
            for (int i5 = 0; i5 < size2; i5++) {
                AbstractC0587l abstractC0587l2 = (AbstractC0587l) this.f730c.get(i5);
                if (!(abstractC0587l2 instanceof C0583h)) {
                    this.f730c.set(i5, abstractC0587l2.mo914d(i4));
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: renamed from: b */
    private C0589n m860b(AbstractC0587l abstractC0587l) {
        C0589n c0589nM854a = m854a(abstractC0587l.m964k(), abstractC0587l.m961h());
        if (c0589nM854a == null) {
            throw new C0420s("No expanded opcode for " + abstractC0587l);
        }
        return c0589nM854a;
    }

    /* JADX INFO: renamed from: b */
    private void m861b(int i) {
        int size = this.f730c.size();
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC0587l abstractC0587l = (AbstractC0587l) this.f730c.get(i2);
            if (!(abstractC0587l instanceof C0583h)) {
                this.f730c.set(i2, abstractC0587l.mo914d(1));
            }
        }
        this.f733f++;
    }

    /* JADX INFO: renamed from: b */
    private void m862b(C0589n[] c0589nArr) {
        C0589n c0589n;
        AbstractC0587l abstractC0587l;
        AbstractC0587l abstractC0587l2;
        AbstractC0587l abstractC0587lMo900a;
        if (this.f733f == 0) {
            int size = this.f730c.size();
            for (int i = 0; i < size; i++) {
                AbstractC0587l abstractC0587l3 = (AbstractC0587l) this.f730c.get(i);
                C0589n c0589nM961h = abstractC0587l3.m961h();
                C0589n c0589n2 = c0589nArr[i];
                if (c0589nM961h != c0589n2) {
                    this.f730c.set(i, abstractC0587l3.mo900a(c0589n2));
                }
            }
            return;
        }
        int size2 = this.f730c.size();
        ArrayList arrayList = new ArrayList(size2 << 1);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < size2; i2++) {
            AbstractC0587l abstractC0587l4 = (AbstractC0587l) this.f730c.get(i2);
            C0589n c0589nM961h2 = abstractC0587l4.m961h();
            C0589n c0589n3 = c0589nArr[i2];
            if (c0589n3 != null) {
                abstractC0587l2 = null;
                abstractC0587l = null;
                c0589n = c0589n3;
                abstractC0587lMo900a = abstractC0587l4;
            } else {
                C0589n c0589nM860b = m860b(abstractC0587l4);
                BitSet bitSetMo851c = c0589nM860b.m976c().mo851c(abstractC0587l4);
                AbstractC0587l abstractC0587lM955b = abstractC0587l4.m955b(bitSetMo851c);
                AbstractC0587l abstractC0587lM956c = abstractC0587l4.m956c(bitSetMo851c);
                AbstractC0587l abstractC0587lM958d = abstractC0587l4.m958d(bitSetMo851c);
                c0589n = c0589nM860b;
                abstractC0587l = abstractC0587lM955b;
                abstractC0587l2 = abstractC0587lM956c;
                abstractC0587lMo900a = abstractC0587lM958d;
            }
            if ((abstractC0587lMo900a instanceof C0583h) && ((C0583h) abstractC0587lMo900a).m934c()) {
                arrayList2.add((C0583h) abstractC0587lMo900a);
            } else {
                if (abstractC0587l != null) {
                    arrayList.add(abstractC0587l);
                }
                if (!(abstractC0587lMo900a instanceof AbstractC0576an) && arrayList2.size() > 0) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add((C0583h) it.next());
                    }
                    arrayList2.clear();
                }
                if (c0589n != c0589nM961h2) {
                    abstractC0587lMo900a = abstractC0587lMo900a.mo900a(c0589n);
                }
                arrayList.add(abstractC0587lMo900a);
                if (abstractC0587l2 != null) {
                    arrayList.add(abstractC0587l2);
                }
            }
        }
        this.f730c = arrayList;
    }

    /* JADX INFO: renamed from: c */
    private void m863c(C0589n[] c0589nArr) {
        do {
            int i = ((this.f729b + this.f733f) + this.f734g) - this.f735h;
            Iterator it = this.f730c.iterator();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (it.hasNext()) {
                C0768t c0768tM963j = ((AbstractC0587l) it.next()).m963j();
                int i6 = i2;
                int i7 = i3;
                int i8 = i4;
                int i9 = i5;
                int i10 = 0;
                while (i10 < c0768tM963j.m1977d_()) {
                    C0766r c0766rM1553b = c0768tM963j.m1553b(i10);
                    if (c0766rM1553b.m1538l()) {
                        boolean z = c0766rM1553b.m1533g() >= i;
                        if ((c0766rM1553b.m1533g() & 1) == 0) {
                            if (z) {
                                i6++;
                            } else {
                                i8++;
                            }
                        } else if (z) {
                            i7++;
                        } else {
                            i9++;
                        }
                    }
                    int i11 = i9;
                    i10++;
                    i6 = i6;
                    i7 = i7;
                    i8 = i8;
                    i9 = i11;
                }
                i5 = i9;
                i4 = i8;
                i3 = i7;
                i2 = i6;
            }
            if (i3 > i2 && i5 > i4) {
                m861b(1);
            } else if (i3 > i2) {
                m855a(1);
            } else {
                if (i5 <= i4) {
                    return;
                }
                m861b(1);
                if (this.f735h != 0 && i2 > i3) {
                    m855a(1);
                }
            }
        } while (m859a(c0589nArr));
    }

    /* JADX INFO: renamed from: e */
    private C0589n[] m864e() {
        int size = this.f730c.size();
        C0589n[] c0589nArr = new C0589n[size];
        for (int i = 0; i < size; i++) {
            c0589nArr[i] = ((AbstractC0587l) this.f730c.get(i)).m961h();
        }
        return c0589nArr;
    }

    /* JADX INFO: renamed from: f */
    private void m865f() {
        do {
            int size = this.f730c.size();
            int iMo840a = 0;
            for (int i = 0; i < size; i++) {
                AbstractC0587l abstractC0587l = (AbstractC0587l) this.f730c.get(i);
                abstractC0587l.m957c(iMo840a);
                iMo840a += abstractC0587l.mo840a();
            }
        } while (m866g());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m866g() {
        /*
            r10 = this;
            r2 = 0
            java.util.ArrayList r0 = r10.f730c
            int r3 = r0.size()
            r4 = r2
        L8:
            if (r2 >= r3) goto L91
            java.util.ArrayList r0 = r10.f730c
            java.lang.Object r0 = r0.get(r2)
            com.a.b.c.b.l r0 = (com.p016a.p019b.p028c.p030b.AbstractC0587l) r0
            boolean r1 = r0 instanceof com.p016a.p019b.p028c.p030b.C0574al
            if (r1 == 0) goto L92
            com.a.b.c.b.n r5 = r0.m961h()
            r1 = r0
            com.a.b.c.b.al r1 = (com.p016a.p019b.p028c.p030b.C0574al) r1
            com.a.b.c.b.r r6 = r5.m976c()
            boolean r6 = r6.mo849a(r1)
            if (r6 != 0) goto L92
            int r4 = r5.m975b()
            r6 = 40
            if (r4 != r6) goto L51
            com.a.b.c.b.n r1 = r10.m854a(r0, r5)
            if (r1 != 0) goto L3d
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "method too long"
            r0.<init>(r1)
            throw r0
        L3d:
            java.util.ArrayList r4 = r10.f730c
            com.a.b.c.b.l r0 = r0.mo900a(r1)
            r4.set(r2, r0)
            r0 = r2
            r1 = r3
        L48:
            r2 = 1
            r3 = r1
            r9 = r2
            r2 = r0
            r0 = r9
        L4d:
            int r2 = r2 + 1
            r4 = r0
            goto L8
        L51:
            java.util.ArrayList r0 = r10.f730c     // Catch: java.lang.IndexOutOfBoundsException -> L7f java.lang.ClassCastException -> L88
            int r4 = r2 + 1
            java.lang.Object r0 = r0.get(r4)     // Catch: java.lang.IndexOutOfBoundsException -> L7f java.lang.ClassCastException -> L88
            com.a.b.c.b.h r0 = (com.p016a.p019b.p028c.p030b.C0583h) r0     // Catch: java.lang.IndexOutOfBoundsException -> L7f java.lang.ClassCastException -> L88
            com.a.b.c.b.al r4 = new com.a.b.c.b.al
            com.a.b.c.b.n r5 = com.p016a.p019b.p028c.p030b.C0590o.f804H
            com.a.b.f.b.z r6 = r1.m962i()
            com.a.b.f.b.t r7 = com.p016a.p019b.p036f.p038b.C0768t.f1671a
            com.a.b.c.b.h r8 = r1.m910c()
            r4.<init>(r5, r6, r7, r8)
            java.util.ArrayList r5 = r10.f730c
            r5.set(r2, r4)
            java.util.ArrayList r4 = r10.f730c
            com.a.b.c.b.al r0 = r1.m909a(r0)
            r4.add(r2, r0)
            int r1 = r3 + 1
            int r0 = r2 + 1
            goto L48
        L7f:
            r0 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unpaired TargetInsn (dangling)"
            r0.<init>(r1)
            throw r0
        L88:
            r0 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unpaired TargetInsn"
            r0.<init>(r1)
            throw r0
        L91:
            return r4
        L92:
            r0 = r4
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p019b.p028c.p030b.C0563aa.m866g():boolean");
    }

    /* JADX INFO: renamed from: a */
    public final void m867a(int i, C0583h c0583h) {
        int size = (this.f730c.size() - i) - 1;
        try {
            this.f730c.set(size, ((C0574al) this.f730c.get(size)).m909a(c0583h));
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("non-reversible instruction");
        } catch (IndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("too few instructions");
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m868a(InterfaceC0586k interfaceC0586k) {
        int iMo835a;
        for (AbstractC0587l abstractC0587l : this.f730c) {
            if (abstractC0587l instanceof C0584i) {
                C0584i c0584i = (C0584i) abstractC0587l;
                AbstractC0775a abstractC0775aM937c = c0584i.m937c();
                int iMo835a2 = interfaceC0586k.mo835a(abstractC0775aM937c);
                if (iMo835a2 >= 0) {
                    c0584i.m935a(iMo835a2);
                }
                if ((abstractC0775aM937c instanceof AbstractC0797u) && (iMo835a = interfaceC0586k.mo835a(((AbstractC0797u) abstractC0775aM937c).m1636k())) >= 0) {
                    c0584i.m936b(iMo835a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m869a(AbstractC0587l abstractC0587l) {
        boolean z = false;
        this.f730c.add(abstractC0587l);
        if (!this.f731d && abstractC0587l.m962i().m1599a() >= 0) {
            this.f731d = true;
        }
        if (this.f732e) {
            return;
        }
        if (abstractC0587l instanceof C0598w) {
            C0770v c0770vM1029c = ((C0598w) abstractC0587l).m1029c();
            int iM1571d = c0770vM1029c.m1571d();
            int i = 0;
            while (true) {
                if (i >= iM1571d) {
                    break;
                }
                if (m858a(c0770vM1029c.m1562a(i))) {
                    z = true;
                    break;
                }
                i++;
            }
        } else if ((abstractC0587l instanceof C0599x) && m858a(((C0599x) abstractC0587l).m1031c())) {
            z = true;
        }
        if (z) {
            this.f732e = true;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m870a() {
        return this.f731d;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m871b() {
        return this.f732e;
    }

    /* JADX INFO: renamed from: c */
    public final HashSet m872c() {
        HashSet hashSet = new HashSet(20);
        Iterator it = this.f730c.iterator();
        while (it.hasNext()) {
            m856a(hashSet, (AbstractC0587l) it.next());
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: d */
    public final C0588m m873d() {
        if (this.f733f >= 0) {
            throw new UnsupportedOperationException("already processed");
        }
        C0589n[] c0589nArrM864e = m864e();
        m859a(c0589nArrM864e);
        if (this.f728a.f680a) {
            m863c(c0589nArrM864e);
        }
        m862b(c0589nArrM864e);
        m865f();
        return C0588m.m967a(this.f730c, this.f733f + this.f729b + this.f734g);
    }
}
