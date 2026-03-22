package com.p016a.p019b.p041g.p042a;

import com.p016a.p019b.p036f.p038b.AbstractC0753e;
import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p041g.AbstractC0831ag;
import com.p016a.p019b.p041g.AbstractC0836al;
import com.p016a.p019b.p041g.C0827ac;
import com.p016a.p019b.p041g.C0833ai;
import com.p016a.p019b.p041g.C0838an;
import com.p016a.p019b.p041g.C0862r;
import com.p016a.p019b.p041g.C0870z;
import com.p016a.p019b.p043h.InterfaceC0879i;
import com.p016a.p019b.p043h.InterfaceC0881k;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.g.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0809a extends AbstractC0821m {

    /* JADX INFO: renamed from: b */
    private final Map f2045b;

    /* JADX INFO: renamed from: c */
    private final ArrayList f2046c;

    /* JADX INFO: renamed from: d */
    private final ArrayList f2047d;

    /* JADX INFO: renamed from: e */
    private final ArrayList f2048e;

    /* JADX INFO: renamed from: f */
    private final BitSet f2049f;

    /* JADX INFO: renamed from: g */
    private final C0862r f2050g;

    /* JADX INFO: renamed from: h */
    private final int f2051h;

    /* JADX INFO: renamed from: i */
    private final BitSet f2052i;

    /* JADX INFO: renamed from: j */
    private final BitSet f2053j;

    public C0809a(C0838an c0838an, C0817i c0817i, boolean z) {
        super(c0838an, c0817i);
        this.f2049f = new BitSet(c0838an.m1861g());
        this.f2050g = new C0862r(c0817i, c0838an.m1861g());
        this.f2051h = c0838an.m1862h();
        this.f2052i = new BitSet(this.f2051h << 1);
        this.f2052i.set(0, this.f2051h);
        this.f2053j = new BitSet(this.f2051h << 1);
        this.f2045b = new TreeMap();
        this.f2046c = new ArrayList();
        this.f2047d = new ArrayList();
        this.f2048e = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    private int m1702a(int i, int i2, EnumC0811c enumC0811c) {
        int iMo1731a = enumC0811c.mo1731a(this.f2052i, i);
        while (true) {
            int i3 = 1;
            while (i3 < i2 && !this.f2052i.get(iMo1731a + i3)) {
                i3++;
            }
            if (i3 == i2) {
                return iMo1731a;
            }
            iMo1731a = enumC0811c.mo1731a(this.f2052i, iMo1731a + i3);
        }
    }

    /* JADX INFO: renamed from: a */
    private int m1703a(int i, C0870z c0870z, int[] iArr, BitSet bitSet) {
        C0768t c0768tMo1756a = c0870z.mo1756a();
        int iD_ = c0768tMo1756a.m1977d_();
        InterfaceC0881k interfaceC0881kM1818p = c0870z.m1832o().m1818p();
        C0768t c0768t = new C0768t(interfaceC0881kM1818p.mo1943a());
        InterfaceC0879i interfaceC0879iMo1946b = interfaceC0881kM1818p.mo1946b();
        int i2 = 0;
        while (interfaceC0879iMo1946b.mo1948a()) {
            c0768t.m1552a(i2, m1744b(interfaceC0879iMo1946b.mo1949b()));
            i2++;
        }
        BitSet bitSet2 = new BitSet(this.f2079a.m1861g());
        int i3 = 0;
        int i4 = i;
        for (int i5 = 0; i5 < iD_; i5++) {
            C0766r c0766rM1553b = c0768tMo1756a.m1553b(i5);
            int iM1533g = c0766rM1553b.m1533g();
            int i6 = iArr[i5];
            if (i5 != 0) {
                i4 += iArr[i5 - 1];
            }
            if (this.f2049f.get(iM1533g) && this.f2050g.m1699a(iM1533g) == i4) {
                i3 += i6;
            } else {
                if (m1714b(i4, i6)) {
                    return -1;
                }
                if (this.f2049f.get(iM1533g) || !m1708a(c0766rM1553b, i4) || bitSet2.get(iM1533g)) {
                    if (this.f2050g.m1923a(c0768t, i4, i6) || this.f2050g.m1923a(c0768tMo1756a, i4, i6)) {
                        return -1;
                    }
                    bitSet.set(i5);
                } else {
                    i3 += i6;
                }
            }
            bitSet2.set(iM1533g);
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m1704a(com.p016a.p019b.p041g.C0870z r9, int r10, int[] r11, java.util.BitSet r12) {
        /*
            r8 = this;
            r0 = 0
            com.a.b.g.a.c r3 = com.p016a.p019b.p041g.p042a.EnumC0811c.f2057c
            int r5 = r11.length
            r4 = r0
            r1 = r0
            r2 = r0
        L7:
            if (r4 >= r5) goto L21
            r6 = r11[r4]
            r7 = 2
            if (r6 != r7) goto L1e
            boolean r6 = m1725f(r2)
            if (r6 == 0) goto L1b
            int r1 = r1 + 1
        L16:
            int r2 = r2 + 2
        L18:
            int r4 = r4 + 1
            goto L7
        L1b:
            int r0 = r0 + 1
            goto L16
        L1e:
            int r2 = r2 + 1
            goto L18
        L21:
            if (r0 <= r1) goto L3f
            int r0 = r8.f2051h
            boolean r0 = m1725f(r0)
            if (r0 != 0) goto L4c
            com.a.b.g.a.c r0 = com.p016a.p019b.p041g.p042a.EnumC0811c.f2055a
        L2d:
            int r1 = r8.f2051h
        L2f:
            int r1 = r8.m1702a(r1, r10, r0)
            int r2 = r8.m1703a(r1, r9, r11, r12)
            if (r2 >= 0) goto L4f
            int r1 = r1 + 1
            r12.clear()
            goto L2f
        L3f:
            if (r1 <= 0) goto L50
            int r0 = r8.f2051h
            boolean r0 = m1725f(r0)
            if (r0 == 0) goto L4c
            com.a.b.g.a.c r0 = com.p016a.p019b.p041g.p042a.EnumC0811c.f2055a
            goto L2d
        L4c:
            com.a.b.g.a.c r0 = com.p016a.p019b.p041g.p042a.EnumC0811c.f2056b
            goto L2d
        L4f:
            return r1
        L50:
            r0 = r3
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p019b.p041g.p042a.C0809a.m1704a(com.a.b.g.z, int, int[], java.util.BitSet):int");
    }

    /* JADX INFO: renamed from: a */
    private void m1706a(int i, int i2) {
        this.f2052i.set(i, i + i2, true);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1708a(C0766r c0766r, int i) {
        return (m1722d(i, c0766r.m1537k()) || this.f2050g.m1922a(c0766r, i)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1709a(C0766r c0766r, int i, int i2) {
        if (c0766r.m1537k() > i2 || this.f2049f.get(c0766r.m1533g()) || !m1708a(c0766r, i)) {
            return false;
        }
        m1713b(c0766r, i);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1710a(ArrayList arrayList, int i, int i2, boolean z) {
        Iterator it = arrayList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            C0766r c0766r = (C0766r) it.next();
            if (!this.f2049f.get(c0766r.m1533g())) {
                boolean zM1709a = m1709a(c0766r, i, i2);
                z2 = !zM1709a || z2;
                if (zM1709a && z) {
                    m1706a(i, c0766r.m1537k());
                }
            }
        }
        return !z2;
    }

    /* JADX INFO: renamed from: b */
    private void m1712b() {
        int i;
        boolean z;
        for (ArrayList arrayList : this.f2045b.values()) {
            boolean z2 = false;
            int i2 = this.f2051h;
            while (true) {
                int size = arrayList.size();
                int i3 = 0;
                int i4 = 1;
                while (i3 < size) {
                    C0766r c0766r = (C0766r) arrayList.get(i3);
                    int iM1537k = c0766r.m1537k();
                    i3++;
                    i4 = (this.f2049f.get(c0766r.m1533g()) || iM1537k <= i4) ? i4 : iM1537k;
                }
                EnumC0811c enumC0811cM1719d = m1719d(i4);
                int iMo1731a = enumC0811cM1719d.mo1731a(this.f2053j, i2);
                while (true) {
                    i = iMo1731a;
                    int i5 = 1;
                    while (i5 < i4 && !this.f2053j.get(i + i5)) {
                        i5++;
                    }
                    if (i5 == i4) {
                        break;
                    } else {
                        iMo1731a = enumC0811cM1719d.mo1731a(this.f2053j, i5 + i);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    C0766r c0766r2 = (C0766r) it.next();
                    if (!this.f2049f.get(c0766r2.m1533g()) && !m1708a(c0766r2, i)) {
                        z = false;
                        break;
                    }
                }
                boolean zM1710a = z ? m1710a(arrayList, i, i4, true) : z2;
                int i6 = i + 1;
                if (!zM1710a) {
                    i2 = i6;
                    z2 = zM1710a;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1713b(C0766r c0766r, int i) {
        int iM1533g = c0766r.m1533g();
        if (this.f2049f.get(iM1533g) || !m1708a(c0766r, i)) {
            throw new RuntimeException("attempt to add invalid register mapping");
        }
        int iM1537k = c0766r.m1537k();
        this.f2050g.mo1701a(c0766r.m1533g(), i, iM1537k);
        this.f2049f.set(iM1533g);
        this.f2053j.set(i, iM1537k + i);
    }

    /* JADX INFO: renamed from: b */
    private boolean m1714b(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (this.f2052i.get(i3)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private int m1715c(int i) {
        C0771w c0771wMo1765c;
        AbstractC0836al abstractC0836alM1855c = this.f2079a.m1855c(i);
        if (abstractC0836alM1855c == null || (c0771wMo1765c = abstractC0836alM1855c.mo1765c()) == null || c0771wMo1765c.m1574a() != 3) {
            return -1;
        }
        return ((C0790n) ((AbstractC0753e) abstractC0836alM1855c.mo1766e()).m1486g_()).mo1632j();
    }

    /* JADX INFO: renamed from: c */
    private int m1716c(int i, int i2) {
        return m1702a(i, i2, m1719d(i2));
    }

    /* JADX INFO: renamed from: c */
    private void m1718c() {
        for (C0870z c0870z : this.f2046c) {
            C0766r c0766rN = c0870z.m1831n();
            int iM1533g = c0766rN.m1533g();
            BitSet bitSetM1809g = c0870z.m1832o().m1809g();
            if (bitSetM1809g.cardinality() == 1) {
                AbstractC0836al abstractC0836al = (AbstractC0836al) ((C0833ai) this.f2079a.m1864j().get(bitSetM1809g.nextSetBit(0))).m1801c().get(r0.size() - 1);
                if (abstractC0836al.mo1765c().m1574a() == 43) {
                    C0766r c0766rM1553b = abstractC0836al.mo1756a().m1553b(0);
                    int iM1533g2 = c0766rM1553b.m1533g();
                    int iM1537k = c0766rM1553b.m1537k();
                    boolean zM1709a = this.f2049f.get(iM1533g);
                    boolean z = this.f2049f.get(iM1533g2);
                    boolean zM1709a2 = (!z) & zM1709a ? m1709a(c0766rM1553b, this.f2050g.m1699a(iM1533g), iM1537k) : z;
                    if ((!zM1709a) & zM1709a2) {
                        zM1709a = m1709a(c0766rN, this.f2050g.m1699a(iM1533g2), iM1537k);
                    }
                    if (!zM1709a || !zM1709a2) {
                        int iM1716c = m1716c(this.f2051h, iM1537k);
                        ArrayList arrayList = new ArrayList(2);
                        arrayList.add(c0766rN);
                        arrayList.add(c0766rM1553b);
                        while (!m1710a(arrayList, iM1716c, iM1537k, false)) {
                            iM1716c = m1716c(iM1716c + 1, iM1537k);
                        }
                    }
                    boolean z2 = abstractC0836al.mo1766e().mo1470b().mo759d_() != 0;
                    int iA = this.f2050g.m1699a(iM1533g);
                    if (iA != this.f2050g.m1699a(iM1533g2) && !z2) {
                        ((C0870z) abstractC0836al).m1939a(0, m1743a(abstractC0836al, c0766rM1553b));
                        m1713b(abstractC0836al.mo1756a().m1553b(0), iA);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private EnumC0811c m1719d(int i) {
        return i == 2 ? m1725f(this.f2051h) ? EnumC0811c.f2055a : EnumC0811c.f2056b : EnumC0811c.f2057c;
    }

    /* JADX INFO: renamed from: d */
    private void m1721d() {
        for (C0827ac c0827ac : this.f2048e) {
            C0766r c0766rN = c0827ac.m1831n();
            int iM1533g = c0766rN.m1533g();
            int iM1537k = c0766rN.m1537k();
            C0768t c0768tMo1756a = c0827ac.mo1756a();
            int iD_ = c0768tMo1756a.m1977d_();
            ArrayList arrayList = new ArrayList();
            C0815g c0815g = new C0815g(iD_ + 1);
            if (this.f2049f.get(iM1533g)) {
                c0815g.m1733a(this.f2050g.m1699a(iM1533g));
            } else {
                arrayList.add(c0766rN);
            }
            for (int i = 0; i < iD_; i++) {
                C0766r c0766rM1831n = this.f2079a.m1855c(c0768tMo1756a.m1553b(i).m1533g()).m1831n();
                int iM1533g2 = c0766rM1831n.m1533g();
                if (this.f2049f.get(iM1533g2)) {
                    c0815g.m1733a(this.f2050g.m1699a(iM1533g2));
                } else {
                    arrayList.add(c0766rM1831n);
                }
            }
            for (int i2 = 0; i2 < c0815g.m1734b(); i2++) {
                m1710a(arrayList, c0815g.m1732a(), iM1537k, false);
            }
            int iM1716c = m1716c(this.f2051h, iM1537k);
            while (!m1710a(arrayList, iM1716c, iM1537k, false)) {
                iM1716c = m1716c(iM1716c + 1, iM1537k);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m1722d(int i, int i2) {
        return i < this.f2051h && i + i2 > this.f2051h;
    }

    /* JADX INFO: renamed from: e */
    private C0761m m1723e(int i) {
        for (Map.Entry entry : this.f2045b.entrySet()) {
            Iterator it = ((ArrayList) entry.getValue()).iterator();
            while (it.hasNext()) {
                if (((C0766r) it.next()).m1533g() == i) {
                    return (C0761m) entry.getKey();
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    private void m1724e() {
        C0766r c0766rB;
        int iM1861g = this.f2079a.m1861g();
        for (int i = 0; i < iM1861g; i++) {
            if (!this.f2049f.get(i) && (c0766rB = m1744b(i)) != null) {
                int iM1537k = c0766rB.m1537k();
                int iM1716c = m1716c(this.f2051h, iM1537k);
                while (!m1708a(c0766rB, iM1716c)) {
                    iM1716c = m1716c(iM1716c + 1, iM1537k);
                }
                m1713b(c0766rB, iM1716c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public static boolean m1725f(int i) {
        return (i & 1) == 0;
    }

    @Override // com.p016a.p019b.p041g.p042a.AbstractC0821m
    /* JADX INFO: renamed from: a */
    public final AbstractC0831ag mo1726a() {
        int iA;
        BitSet bitSet;
        int iM1703a;
        int i;
        int i2;
        this.f2079a.m1847a(new C0810b(this));
        for (ArrayList arrayList : this.f2045b.values()) {
            int size = arrayList.size();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                if (i3 >= size) {
                    i = i4;
                    i2 = 0;
                    break;
                }
                C0766r c0766r = (C0766r) arrayList.get(i3);
                int iM1715c = m1715c(c0766r.m1533g());
                if (iM1715c >= 0) {
                    int iM1537k = c0766r.m1537k();
                    m1713b(c0766r, iM1715c);
                    i2 = iM1537k;
                    i = iM1715c;
                    break;
                }
                i3++;
                i4 = iM1715c;
            }
            if (i >= 0) {
                m1710a(arrayList, i, i2, true);
            }
        }
        int iM1861g = this.f2079a.m1861g();
        for (int i5 = 0; i5 < iM1861g; i5++) {
            if (!this.f2049f.get(i5)) {
                int iM1715c2 = m1715c(i5);
                C0766r c0766rB = m1744b(i5);
                if (iM1715c2 >= 0) {
                    m1713b(c0766rB, iM1715c2);
                }
            }
        }
        for (C0870z c0870z : this.f2047d) {
            C0768t c0768tMo1756a = c0870z.mo1756a();
            int iD_ = c0768tMo1756a.m1977d_();
            int[] iArr = new int[iD_];
            int i6 = 0;
            int i7 = 0;
            while (i6 < iD_) {
                iArr[i6] = c0768tMo1756a.m1553b(i6).m1537k();
                int i8 = iArr[i6] + i7;
                i6++;
                i7 = i8;
            }
            int i9 = 0;
            BitSet bitSet2 = null;
            int iM1704a = -1;
            int i10 = Integer.MIN_VALUE;
            for (int i11 = 0; i11 < iD_; i11++) {
                int iM1533g = c0768tMo1756a.m1553b(i11).m1533g();
                if (i11 != 0) {
                    i9 -= iArr[i11 - 1];
                }
                if (this.f2049f.get(iM1533g) && (iA = this.f2050g.m1699a(iM1533g) + i9) >= 0 && !m1722d(iA, i7) && (iM1703a = m1703a(iA, c0870z, iArr, (bitSet = new BitSet(iD_)))) >= 0) {
                    int iCardinality = iM1703a - bitSet.cardinality();
                    if (iCardinality > i10) {
                        bitSet2 = bitSet;
                        iM1704a = iA;
                        i10 = iCardinality;
                    }
                    if (iM1703a == i7) {
                        break;
                    }
                }
            }
            if (iM1704a == -1) {
                bitSet2 = new BitSet(iD_);
                iM1704a = m1704a(c0870z, i7, iArr, bitSet2);
            }
            for (int iNextSetBit = bitSet2.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSet2.nextSetBit(iNextSetBit + 1)) {
                c0870z.m1939a(iNextSetBit, m1743a(c0870z, c0768tMo1756a.m1553b(iNextSetBit)));
            }
            C0768t c0768tMo1756a2 = c0870z.mo1756a();
            int iD_2 = c0768tMo1756a2.m1977d_();
            for (int i12 = 0; i12 < iD_2; i12++) {
                C0766r c0766rM1553b = c0768tMo1756a2.m1553b(i12);
                int iM1533g2 = c0766rM1553b.m1533g();
                int iM1537k2 = c0766rM1553b.m1537k();
                int i13 = iM1704a + iM1537k2;
                if (!this.f2049f.get(iM1533g2)) {
                    C0761m c0761mM1723e = m1723e(iM1533g2);
                    m1713b(c0766rM1553b, iM1704a);
                    if (c0761mM1723e != null) {
                        m1706a(iM1704a, iM1537k2);
                        ArrayList arrayList2 = (ArrayList) this.f2045b.get(c0761mM1723e);
                        int size2 = arrayList2.size();
                        for (int i14 = 0; i14 < size2; i14++) {
                            C0766r c0766r2 = (C0766r) arrayList2.get(i14);
                            if (-1 == c0768tMo1756a2.m1555c(c0766r2.m1533g())) {
                                m1709a(c0766r2, iM1704a, iM1537k2);
                            }
                        }
                    }
                }
                iM1704a = i13;
            }
        }
        m1712b();
        m1718c();
        m1721d();
        m1724e();
        return this.f2050g;
    }
}
