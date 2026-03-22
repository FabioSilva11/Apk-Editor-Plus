package com.p016a.p019b.p041g.p042a;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p041g.AbstractC0836al;
import com.p016a.p019b.p041g.C0827ac;
import com.p016a.p019b.p041g.C0833ai;
import com.p016a.p019b.p041g.C0838an;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.a.b.g.a.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0818j {

    /* JADX INFO: renamed from: a */
    private final BitSet f2065a;

    /* JADX INFO: renamed from: b */
    private final BitSet f2066b;

    /* JADX INFO: renamed from: c */
    private final int f2067c;

    /* JADX INFO: renamed from: d */
    private final C0838an f2068d;

    /* JADX INFO: renamed from: e */
    private final C0817i f2069e;

    /* JADX INFO: renamed from: f */
    private C0833ai f2070f;

    /* JADX INFO: renamed from: g */
    private int f2071g;

    /* JADX INFO: renamed from: h */
    private int f2072h;

    private C0818j(C0838an c0838an, int i, C0817i c0817i) {
        int size = c0838an.m1864j().size();
        this.f2068d = c0838an;
        this.f2067c = i;
        this.f2065a = new BitSet(size);
        this.f2066b = new BitSet(size);
        this.f2069e = c0817i;
    }

    /* JADX INFO: renamed from: a */
    public static C0817i m1739a(C0838an c0838an) {
        int iM1861g = c0838an.m1861g();
        C0817i c0817i = new C0817i(iM1861g);
        for (int i = 0; i < iM1861g; i++) {
            C0818j c0818j = new C0818j(c0838an, i, c0817i);
            for (AbstractC0836al abstractC0836al : c0818j.f2068d.m1857d(c0818j.f2067c)) {
                c0818j.f2072h = C0820l.f2077d;
                if (abstractC0836al instanceof C0827ac) {
                    Iterator it = ((C0827ac) abstractC0836al).m1757a(c0818j.f2067c, c0818j.f2068d).iterator();
                    while (it.hasNext()) {
                        c0818j.f2070f = (C0833ai) it.next();
                        c0818j.f2072h = C0820l.f2076c;
                        c0818j.m1740a();
                    }
                } else {
                    c0818j.f2070f = abstractC0836al.m1832o();
                    c0818j.f2071g = c0818j.f2070f.m1801c().indexOf(abstractC0836al);
                    if (c0818j.f2071g < 0) {
                        throw new RuntimeException("insn not found in it's own block");
                    }
                    c0818j.f2072h = C0820l.f2074a;
                    c0818j.m1740a();
                }
            }
            while (true) {
                int iNextSetBit = c0818j.f2066b.nextSetBit(0);
                if (iNextSetBit >= 0) {
                    c0818j.f2070f = (C0833ai) c0818j.f2068d.m1864j().get(iNextSetBit);
                    c0818j.f2066b.clear(iNextSetBit);
                    c0818j.f2072h = C0820l.f2076c;
                    c0818j.m1740a();
                }
            }
        }
        m1741a(c0838an, c0817i);
        return c0817i;
    }

    /* JADX INFO: renamed from: a */
    private void m1740a() {
        while (this.f2072h != C0820l.f2077d) {
            switch (C0819k.f2073a[this.f2072h - 1]) {
                case 1:
                    this.f2072h = C0820l.f2077d;
                    if (this.f2071g != 0) {
                        this.f2071g--;
                        this.f2072h = C0820l.f2075b;
                    } else {
                        this.f2070f.m1805d(this.f2067c);
                        this.f2066b.or(this.f2070f.m1809g());
                    }
                    break;
                case 2:
                    this.f2072h = C0820l.f2077d;
                    AbstractC0836al abstractC0836al = (AbstractC0836al) this.f2070f.m1801c().get(this.f2071g);
                    C0766r c0766rM1831n = abstractC0836al.m1831n();
                    if (!abstractC0836al.m1826b(this.f2067c)) {
                        if (c0766rM1831n != null) {
                            this.f2069e.m1737a(this.f2067c, c0766rM1831n.m1533g());
                        }
                        this.f2072h = C0820l.f2074a;
                    }
                    break;
                case 3:
                    this.f2072h = C0820l.f2077d;
                    if (!this.f2065a.get(this.f2070f.m1806e())) {
                        this.f2065a.set(this.f2070f.m1806e());
                        this.f2070f.m1802c(this.f2067c);
                        this.f2071g = this.f2070f.m1801c().size() - 1;
                        this.f2072h = C0820l.f2075b;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1741a(C0838an c0838an, C0817i c0817i) {
        Iterator it = c0838an.m1864j().iterator();
        while (it.hasNext()) {
            List listM1804d = ((C0833ai) it.next()).m1804d();
            int size = listM1804d.size();
            for (int i = 0; i < size; i++) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (i != i2) {
                        c0817i.m1737a(((AbstractC0836al) listM1804d.get(i)).m1831n().m1533g(), ((AbstractC0836al) listM1804d.get(i2)).m1831n().m1533g());
                    }
                }
            }
        }
    }
}
