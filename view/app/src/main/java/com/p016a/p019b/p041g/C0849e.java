package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p043h.C0871a;
import com.p016a.p019b.p043h.C0884n;
import com.p016a.p019b.p043h.InterfaceC0879i;
import com.p016a.p019b.p043h.InterfaceC0881k;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.g.e */
/* JADX INFO: loaded from: classes.dex */
public class C0849e {

    /* JADX INFO: renamed from: a */
    private final C0838an f2163a;

    /* JADX INFO: renamed from: b */
    private final int f2164b;

    /* JADX INFO: renamed from: c */
    private final BitSet f2165c;

    /* JADX INFO: renamed from: d */
    private final ArrayList[] f2166d;

    private C0849e(C0838an c0838an) {
        this.f2163a = c0838an;
        this.f2164b = c0838an.m1861g();
        this.f2165c = new BitSet(this.f2164b);
        this.f2166d = this.f2163a.m1868n();
    }

    /* JADX INFO: renamed from: a */
    public static C0838an m1891a(C0772x c0772x, int i, boolean z) {
        C0838an c0838anM1833a = C0838an.m1833a(c0772x, i, z);
        ArrayList arrayListM1864j = c0838anM1833a.m1864j();
        for (int size = arrayListM1864j.size() - 1; size >= 0; size--) {
            C0833ai c0833ai = (C0833ai) arrayListM1864j.get(size);
            if (c0833ai.m1809g().cardinality() > 1 && c0833ai.m1810h().cardinality() > 1) {
                c0833ai.m1817o();
            }
        }
        ArrayList arrayListM1864j2 = c0838anM1833a.m1864j();
        for (int size2 = arrayListM1864j2.size() - 1; size2 >= 0; size2--) {
            C0833ai c0833ai2 = (C0833ai) arrayListM1864j2.get(size2);
            if (!c0833ai2.m1819q() && c0833ai2.m1809g().cardinality() > 1 && ((AbstractC0836al) c0833ai2.m1801c().get(0)).mo1830i()) {
                BitSet bitSet = (BitSet) c0833ai2.m1809g().clone();
                for (int iNextSetBit = bitSet.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1)) {
                    ((C0833ai) arrayListM1864j2.get(iNextSetBit)).m1797b(c0833ai2).m1801c().add(0, ((AbstractC0836al) c0833ai2.m1801c().get(0)).clone());
                }
                c0833ai2.m1801c().remove(0);
            }
        }
        ArrayList arrayListM1864j3 = c0838anM1833a.m1864j();
        for (int size3 = arrayListM1864j3.size() - 1; size3 >= 0; size3--) {
            C0833ai c0833ai3 = (C0833ai) arrayListM1864j3.get(size3);
            BitSet bitSet2 = (BitSet) c0833ai3.m1810h().clone();
            for (int iNextSetBit2 = bitSet2.nextSetBit(0); iNextSetBit2 >= 0; iNextSetBit2 = bitSet2.nextSetBit(iNextSetBit2 + 1)) {
                C0833ai c0833ai4 = (C0833ai) arrayListM1864j3.get(iNextSetBit2);
                AbstractC0836al abstractC0836al = (AbstractC0836al) c0833ai3.m1801c().get(r0.size() - 1);
                if ((abstractC0836al.m1831n() != null || abstractC0836al.mo1756a().m1977d_() > 0) && c0833ai4.m1809g().cardinality() > 1) {
                    c0833ai3.m1797b(c0833ai4);
                }
            }
        }
        m1895a(c0838anM1833a, C0865u.m1929a(c0838anM1833a), 0);
        new RunnableC0841aq(c0838anM1833a).run();
        c0838anM1833a.m1840a();
        return c0838anM1833a;
    }

    /* JADX INFO: renamed from: a */
    public static InterfaceC0881k m1892a(int i) {
        return i <= 3072 ? new C0871a(i) : new C0884n();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    public static void m1893a(C0838an c0838an) {
        C0849e c0849e = new C0849e(c0838an);
        HashSet hashSet = new HashSet();
        c0849e.f2163a.m1866l();
        for (C0833ai c0833ai : c0849e.f2163a.m1864j()) {
            if (!c0833ai.m1820r()) {
                for (int i = 0; i < c0833ai.m1801c().size(); i++) {
                    AbstractC0836al abstractC0836al = (AbstractC0836al) c0833ai.m1801c().get(i);
                    C0768t c0768tMo1756a = abstractC0836al.mo1756a();
                    int iD_ = c0768tMo1756a.m1977d_();
                    if (iD_ != 0) {
                        hashSet.add(abstractC0836al);
                    }
                    for (int i2 = 0; i2 < iD_; i2++) {
                        c0849e.f2166d[c0768tMo1756a.m1553b(i2).m1533g()].remove(abstractC0836al);
                    }
                    C0766r c0766rM1831n = abstractC0836al.m1831n();
                    if (c0766rM1831n != null) {
                        for (AbstractC0836al abstractC0836al2 : c0849e.f2166d[c0766rM1831n.m1533g()]) {
                            if (abstractC0836al2 instanceof C0827ac) {
                                ((C0827ac) abstractC0836al2).m1758a(c0766rM1831n);
                            }
                        }
                    }
                }
            }
        }
        c0849e.f2163a.m1848a(hashSet);
        HashSet hashSet2 = new HashSet();
        c0849e.f2163a.m1847a(new C0850f(c0849e.f2165c));
        while (true) {
            int iNextSetBit = c0849e.f2165c.nextSetBit(0);
            if (iNextSetBit < 0) {
                c0849e.f2163a.m1848a(hashSet2);
                return;
            }
            c0849e.f2165c.clear(iNextSetBit);
            if (c0849e.f2166d[iNextSetBit].size() == 0 || c0849e.m1896a(iNextSetBit, (BitSet) null)) {
                AbstractC0836al abstractC0836alM1855c = c0849e.f2163a.m1855c(iNextSetBit);
                if (!hashSet2.contains(abstractC0836alM1855c)) {
                    C0768t c0768tMo1756a2 = abstractC0836alM1855c.mo1756a();
                    int iD_2 = c0768tMo1756a2.m1977d_();
                    for (int i3 = 0; i3 < iD_2; i3++) {
                        C0766r c0766rM1553b = c0768tMo1756a2.m1553b(i3);
                        c0849e.f2166d[c0766rM1553b.m1533g()].remove(abstractC0836alM1855c);
                        if (!m1899b(c0849e.f2163a.m1855c(c0766rM1553b.m1533g()))) {
                            c0849e.f2165c.set(c0766rM1553b.m1533g());
                        }
                    }
                    hashSet2.add(abstractC0836alM1855c);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1894a(C0838an c0838an, int i) {
        m1895a(c0838an, C0865u.m1929a(c0838an), i);
        new RunnableC0841aq(c0838an, i).run();
    }

    /* JADX INFO: renamed from: a */
    private static void m1895a(C0838an c0838an, C0866v c0866v, int i) {
        ArrayList arrayListM1864j = c0838an.m1864j();
        int size = arrayListM1864j.size();
        int iM1861g = c0838an.m1861g() - i;
        C0852h[] c0852hArrM1900a = new C0851g(c0838an).m1900a();
        BitSet[] bitSetArr = new BitSet[iM1861g];
        BitSet[] bitSetArr2 = new BitSet[iM1861g];
        for (int i2 = 0; i2 < iM1861g; i2++) {
            bitSetArr[i2] = new BitSet(size);
            bitSetArr2[i2] = new BitSet(size);
        }
        int size2 = arrayListM1864j.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Iterator it = ((C0833ai) arrayListM1864j.get(i3)).m1801c().iterator();
            while (it.hasNext()) {
                C0766r c0766rM1831n = ((AbstractC0836al) it.next()).m1831n();
                if (c0766rM1831n != null && c0766rM1831n.m1533g() - i >= 0) {
                    bitSetArr[c0766rM1831n.m1533g() - i].set(i3);
                }
            }
        }
        for (int i4 = 0; i4 < iM1861g; i4++) {
            BitSet bitSet = (BitSet) bitSetArr[i4].clone();
            while (true) {
                int iNextSetBit = bitSet.nextSetBit(0);
                if (iNextSetBit >= 0) {
                    bitSet.clear(iNextSetBit);
                    InterfaceC0879i interfaceC0879iMo1946b = c0852hArrM1900a[iNextSetBit].f2172a.mo1946b();
                    while (interfaceC0879iMo1946b.mo1948a()) {
                        int iMo1949b = interfaceC0879iMo1946b.mo1949b();
                        if (!bitSetArr2[i4].get(iMo1949b)) {
                            bitSetArr2[i4].set(iMo1949b);
                            int i5 = i4 + i;
                            C0766r c0766rM1562a = c0866v.m1932a(iMo1949b).m1562a(i5);
                            if (c0766rM1562a == null) {
                                ((C0833ai) arrayListM1864j.get(iMo1949b)).m1789a(i5);
                            } else {
                                ((C0833ai) arrayListM1864j.get(iMo1949b)).m1792a(c0766rM1562a);
                            }
                            if (!bitSetArr[i4].get(iMo1949b)) {
                                bitSet.set(iMo1949b);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1896a(int i, BitSet bitSet) {
        if (bitSet != null && bitSet.get(i)) {
            return true;
        }
        Iterator it = this.f2166d[i].iterator();
        while (it.hasNext()) {
            if (m1899b((AbstractC0836al) it.next())) {
                return false;
            }
        }
        if (bitSet == null) {
            bitSet = new BitSet(this.f2164b);
        }
        bitSet.set(i);
        Iterator it2 = this.f2166d[i].iterator();
        while (it2.hasNext()) {
            C0766r c0766rM1831n = ((AbstractC0836al) it2.next()).m1831n();
            if (c0766rM1831n == null || !m1896a(c0766rM1831n.m1533g(), bitSet)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    static InterfaceC0881k m1898b(int i) {
        return i <= 3072 ? new C0871a(i) : new C0884n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static boolean m1899b(AbstractC0836al abstractC0836al) {
        if (abstractC0836al == null) {
            return true;
        }
        return abstractC0836al.mo1770l();
    }
}
