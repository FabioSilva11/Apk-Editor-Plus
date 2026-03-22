package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0751c;
import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p036f.p038b.C0773y;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p043h.C0880j;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: renamed from: com.a.b.g.an */
/* JADX INFO: loaded from: classes.dex */
public final class C0838an {

    /* JADX INFO: renamed from: a */
    private ArrayList f2127a;

    /* JADX INFO: renamed from: b */
    private int f2128b;

    /* JADX INFO: renamed from: c */
    private int f2129c;

    /* JADX INFO: renamed from: d */
    private int f2130d;

    /* JADX INFO: renamed from: e */
    private int f2131e;

    /* JADX INFO: renamed from: f */
    private int f2132f;

    /* JADX INFO: renamed from: g */
    private int f2133g;

    /* JADX INFO: renamed from: h */
    private final int f2134h;

    /* JADX INFO: renamed from: i */
    private AbstractC0836al[] f2135i;

    /* JADX INFO: renamed from: j */
    private ArrayList[] f2136j;

    /* JADX INFO: renamed from: k */
    private List[] f2137k;

    /* JADX INFO: renamed from: l */
    private boolean f2138l = false;

    private C0838an(C0772x c0772x, int i, boolean z) {
        this.f2134h = i;
        this.f2133g = c0772x.m1582a().m2001j();
        this.f2130d = c0772x.m1582a().m1479e();
        this.f2131e = this.f2130d;
    }

    /* JADX INFO: renamed from: a */
    public static C0838an m1833a(C0772x c0772x, int i, boolean z) {
        C0838an c0838an = new C0838an(c0772x, i, z);
        int iD_ = c0772x.m1582a().m1977d_();
        c0838an.f2127a = new ArrayList(iD_ + 2);
        for (int i2 = 0; i2 < iD_; i2++) {
            c0838an.f2127a.add(C0833ai.m1782a(c0772x, i2, c0838an));
        }
        c0838an.f2128b = ((C0833ai) c0838an.f2127a.get(c0772x.m1582a().m2000c(c0772x.m1584b()))).m1817o().m1806e();
        c0838an.f2129c = -1;
        return c0838an;
    }

    /* JADX INFO: renamed from: a */
    static BitSet m1834a(C0751c c0751c, C0880j c0880j) {
        BitSet bitSet = new BitSet(c0751c.m1977d_());
        int iM1985b = c0880j.m1985b();
        for (int i = 0; i < iM1985b; i++) {
            bitSet.set(c0751c.m2000c(c0880j.m1986b(i)));
        }
        return bitSet;
    }

    /* JADX INFO: renamed from: b */
    private void m1836b(AbstractC0836al abstractC0836al, C0768t c0768t) {
        if (c0768t == null) {
            return;
        }
        int iD_ = c0768t.m1977d_();
        for (int i = 0; i < iD_; i++) {
            if (!this.f2136j[c0768t.m1553b(i).m1533g()].remove(abstractC0836al)) {
                throw new RuntimeException("use not found");
            }
        }
    }

    /* JADX INFO: renamed from: q */
    private void m1838q() {
        if (this.f2138l) {
            throw new RuntimeException("No use list in back mode");
        }
        this.f2136j = new ArrayList[this.f2130d];
        for (int i = 0; i < this.f2130d; i++) {
            this.f2136j[i] = new ArrayList();
        }
        m1847a(new C0840ap(this));
        this.f2137k = new List[this.f2130d];
        for (int i2 = 0; i2 < this.f2130d; i2++) {
            this.f2137k[i2] = Collections.unmodifiableList(this.f2136j[i2]);
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m1839a(int i) {
        if (i < 0) {
            return -1;
        }
        return ((C0833ai) this.f2127a.get(i)).m1808f();
    }

    /* JADX INFO: renamed from: a */
    final void m1840a() {
        if (this.f2129c >= 0) {
            throw new RuntimeException("must be called at most once");
        }
        this.f2129c = this.f2127a.size();
        int i = this.f2129c;
        int i2 = this.f2133g;
        this.f2133g = i2 + 1;
        C0833ai c0833ai = new C0833ai(i, i2, this);
        this.f2127a.add(c0833ai);
        Iterator it = this.f2127a.iterator();
        while (it.hasNext()) {
            ((C0833ai) it.next()).m1803c(c0833ai);
        }
        if (c0833ai.m1809g().cardinality() == 0) {
            this.f2127a.remove(this.f2129c);
            this.f2129c = -1;
            this.f2133g--;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1841a(AbstractC0831ag abstractC0831ag) {
        Iterator it = this.f2127a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((C0833ai) it.next()).m1801c().iterator();
            while (it2.hasNext()) {
                ((AbstractC0836al) it2.next()).m1825b(abstractC0831ag);
            }
        }
        this.f2130d = abstractC0831ag.mo1698a();
        this.f2131e = this.f2130d;
    }

    /* JADX INFO: renamed from: a */
    public final void m1842a(InterfaceC0835ak interfaceC0835ak) {
        BitSet bitSet = new BitSet(this.f2127a.size());
        Stack stack = new Stack();
        stack.add(m1856d());
        while (stack.size() > 0) {
            C0833ai c0833ai = (C0833ai) stack.pop();
            ArrayList arrayListM1788a = c0833ai.m1788a();
            if (!bitSet.get(c0833ai.m1806e())) {
                for (int size = arrayListM1788a.size() - 1; size >= 0; size--) {
                    stack.add((C0833ai) arrayListM1788a.get(size));
                }
                bitSet.set(c0833ai.m1806e());
                interfaceC0835ak.mo1748a(c0833ai, null);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final void m1843a(AbstractC0836al abstractC0836al) {
        m1846a(abstractC0836al, (C0768t) null);
        m1844a(abstractC0836al, (C0766r) null);
    }

    /* JADX INFO: renamed from: a */
    final void m1844a(AbstractC0836al abstractC0836al, C0766r c0766r) {
        if (this.f2135i == null) {
            return;
        }
        if (c0766r != null) {
            this.f2135i[c0766r.m1533g()] = null;
        }
        C0766r c0766rM1831n = abstractC0836al.m1831n();
        if (c0766rM1831n != null) {
            if (this.f2135i[c0766rM1831n.m1533g()] != null) {
                throw new RuntimeException("Duplicate add of insn");
            }
            this.f2135i[c0766rM1831n.m1533g()] = abstractC0836al;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m1845a(AbstractC0836al abstractC0836al, C0766r c0766r, C0766r c0766r2) {
        if (this.f2136j == null) {
            return;
        }
        if (c0766r != null) {
            this.f2136j[c0766r.m1533g()].remove(abstractC0836al);
        }
        int iM1533g = c0766r2.m1533g();
        if (this.f2136j.length <= iM1533g) {
            this.f2136j = null;
        } else {
            this.f2136j[iM1533g].add(abstractC0836al);
        }
    }

    /* JADX INFO: renamed from: a */
    final void m1846a(AbstractC0836al abstractC0836al, C0768t c0768t) {
        if (this.f2136j == null) {
            return;
        }
        if (c0768t != null) {
            m1836b(abstractC0836al, c0768t);
        }
        C0768t c0768tMo1756a = abstractC0836al.mo1756a();
        int iD_ = c0768tMo1756a.m1977d_();
        for (int i = 0; i < iD_; i++) {
            this.f2136j[c0768tMo1756a.m1553b(i).m1533g()].add(abstractC0836al);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1847a(InterfaceC0837am interfaceC0837am) {
        Iterator it = this.f2127a.iterator();
        while (it.hasNext()) {
            ((C0833ai) it.next()).m1796a(interfaceC0837am);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1848a(Set set) {
        for (C0833ai c0833ai : this.f2127a) {
            ArrayList arrayListM1801c = c0833ai.m1801c();
            for (int size = arrayListM1801c.size() - 1; size >= 0; size--) {
                AbstractC0836al abstractC0836al = (AbstractC0836al) arrayListM1801c.get(size);
                if (set.contains(abstractC0836al)) {
                    m1853b(abstractC0836al);
                    arrayListM1801c.remove(size);
                }
            }
            int size2 = arrayListM1801c.size();
            AbstractC0836al abstractC0836al2 = size2 == 0 ? null : (AbstractC0836al) arrayListM1801c.get(size2 - 1);
            if (c0833ai != m1860f() && (size2 == 0 || abstractC0836al2.mo1766e() == null || abstractC0836al2.mo1766e().m1490f().m1577d() == 1)) {
                arrayListM1801c.add(AbstractC0836al.m1822a(new C0765q(C0773y.f1889s, C0774z.f1897a, (C0766r) null, C0768t.f1671a), c0833ai));
                BitSet bitSetM1810h = c0833ai.m1810h();
                for (int iNextSetBit = bitSetM1810h.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSetM1810h.nextSetBit(iNextSetBit + 1)) {
                    if (iNextSetBit != c0833ai.m1812j()) {
                        c0833ai.m1799b(iNextSetBit);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1849a(boolean z, InterfaceC0835ak interfaceC0835ak) {
        BitSet bitSet = new BitSet(this.f2127a.size());
        Stack stack = new Stack();
        C0833ai c0833aiM1860f = z ? m1860f() : m1856d();
        if (c0833aiM1860f == null) {
            return;
        }
        stack.add(null);
        stack.add(c0833aiM1860f);
        while (stack.size() > 0) {
            C0833ai c0833ai = (C0833ai) stack.pop();
            C0833ai c0833ai2 = (C0833ai) stack.pop();
            if (!bitSet.get(c0833ai.m1806e())) {
                BitSet bitSetM1809g = z ? c0833ai.m1809g() : c0833ai.m1810h();
                for (int iNextSetBit = bitSetM1809g.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSetM1809g.nextSetBit(iNextSetBit + 1)) {
                    stack.add(c0833ai);
                    stack.add(this.f2127a.get(iNextSetBit));
                }
                bitSet.set(c0833ai.m1806e());
                interfaceC0835ak.mo1748a(c0833ai, c0833ai2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1850a(C0766r c0766r) {
        AbstractC0836al abstractC0836alM1855c = m1855c(c0766r.m1533g());
        if (abstractC0836alM1855c == null) {
            return false;
        }
        if (abstractC0836alM1855c.mo1828f() != null) {
            return true;
        }
        Iterator it = m1857d(c0766r.m1533g()).iterator();
        while (it.hasNext()) {
            AbstractC0757i abstractC0757iMo1766e = ((AbstractC0836al) it.next()).mo1766e();
            if (abstractC0757iMo1766e != null && abstractC0757iMo1766e.m1490f().m1574a() == 54) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public final int m1851b(int i) {
        int i2 = this.f2131e + this.f2132f;
        this.f2132f += i;
        this.f2130d = Math.max(this.f2130d, i2 + i);
        return i2;
    }

    /* JADX INFO: renamed from: b */
    public final C0833ai m1852b() {
        int size = this.f2127a.size();
        int i = this.f2133g;
        this.f2133g = i + 1;
        C0833ai c0833ai = new C0833ai(size, i, this);
        c0833ai.m1801c().add(new C0870z(new C0765q(C0773y.f1889s, C0774z.f1897a, (C0766r) null, C0768t.f1671a), c0833ai));
        this.f2127a.add(c0833ai);
        return c0833ai;
    }

    /* JADX INFO: renamed from: b */
    final void m1853b(AbstractC0836al abstractC0836al) {
        if (this.f2136j != null) {
            m1836b(abstractC0836al, abstractC0836al.mo1756a());
        }
        C0766r c0766rM1831n = abstractC0836al.m1831n();
        if (this.f2135i == null || c0766rM1831n == null) {
            return;
        }
        this.f2135i[c0766rM1831n.m1533g()] = null;
    }

    /* JADX INFO: renamed from: c */
    public final int m1854c() {
        return this.f2128b;
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC0836al m1855c(int i) {
        if (this.f2138l) {
            throw new RuntimeException("No def list in back mode");
        }
        if (this.f2135i != null) {
            return this.f2135i[i];
        }
        this.f2135i = new AbstractC0836al[this.f2130d];
        m1847a(new C0839ao(this));
        return this.f2135i[i];
    }

    /* JADX INFO: renamed from: d */
    public final C0833ai m1856d() {
        return (C0833ai) this.f2127a.get(this.f2128b);
    }

    /* JADX INFO: renamed from: d */
    public final List m1857d(int i) {
        if (this.f2137k == null) {
            m1838q();
        }
        return this.f2137k[i];
    }

    /* JADX INFO: renamed from: e */
    public final int m1858e() {
        return this.f2129c;
    }

    /* JADX INFO: renamed from: e */
    final void m1859e(int i) {
        this.f2130d = i;
        this.f2131e = this.f2130d;
        m1867m();
    }

    /* JADX INFO: renamed from: f */
    public final C0833ai m1860f() {
        if (this.f2129c < 0) {
            return null;
        }
        return (C0833ai) this.f2127a.get(this.f2129c);
    }

    /* JADX INFO: renamed from: g */
    public final int m1861g() {
        return this.f2130d;
    }

    /* JADX INFO: renamed from: h */
    public final int m1862h() {
        return this.f2134h;
    }

    /* JADX INFO: renamed from: i */
    public final void m1863i() {
        this.f2132f = 0;
    }

    /* JADX INFO: renamed from: j */
    public final ArrayList m1864j() {
        return this.f2127a;
    }

    /* JADX INFO: renamed from: k */
    public final int m1865k() {
        int i = 0;
        Iterator it = this.f2127a.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((C0833ai) it.next()).m1820r() ? i2 + 1 : i2;
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m1866l() {
        Iterator it = this.f2127a.iterator();
        while (it.hasNext()) {
            ((C0833ai) it.next()).m1807e(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(m1856d());
        while (!arrayList.isEmpty()) {
            C0833ai c0833ai = (C0833ai) arrayList.remove(0);
            if (!c0833ai.m1820r()) {
                c0833ai.m1807e(1);
                BitSet bitSetM1810h = c0833ai.m1810h();
                for (int iNextSetBit = bitSetM1810h.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSetM1810h.nextSetBit(iNextSetBit + 1)) {
                    arrayList.add(this.f2127a.get(iNextSetBit));
                }
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m1867m() {
        this.f2135i = null;
        this.f2136j = null;
        this.f2137k = null;
    }

    /* JADX INFO: renamed from: n */
    public final ArrayList[] m1868n() {
        if (this.f2136j == null) {
            m1838q();
        }
        ArrayList[] arrayListArr = new ArrayList[this.f2130d];
        for (int i = 0; i < this.f2130d; i++) {
            arrayListArr[i] = new ArrayList(this.f2136j[i]);
        }
        return arrayListArr;
    }

    /* JADX INFO: renamed from: o */
    public final int m1869o() {
        int i = this.f2130d;
        this.f2130d = i + 1;
        this.f2131e = this.f2130d;
        m1867m();
        return i;
    }

    /* JADX INFO: renamed from: p */
    public final void m1870p() {
        this.f2138l = true;
        this.f2136j = null;
        this.f2135i = null;
    }
}
