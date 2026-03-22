package com.p016a.p019b.p020a.p023c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.C0514i;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0776aa;
import com.p016a.p019b.p036f.p039c.C0786j;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p036f.p039c.C0789m;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0791o;
import com.p016a.p019b.p036f.p039c.C0796t;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0873c;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.a.c.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0489a {

    /* JADX INFO: renamed from: a */
    private final C0873c f602a;

    /* JADX INFO: renamed from: b */
    private final C0776aa f603b;

    /* JADX INFO: renamed from: c */
    private final int[] f604c;

    /* JADX INFO: renamed from: d */
    private int f605d;

    /* JADX INFO: renamed from: e */
    private InterfaceC0515j f606e;

    public C0489a(C0873c c0873c) {
        int iM1966f = c0873c.m1966f(8);
        this.f602a = c0873c;
        this.f603b = new C0776aa(iM1966f);
        this.f604c = new int[iM1966f];
        this.f605d = -1;
    }

    /* JADX INFO: renamed from: a */
    private AbstractC0775a m704a(int i, BitSet bitSet) {
        AbstractC0775a abstractC0775aMo1610c = this.f603b.mo1610c(i);
        if (abstractC0775aMo1610c == null) {
            int i2 = this.f604c[i];
            try {
                int iM1965e = this.f602a.m1965e(i2);
                switch (iM1965e) {
                    case 1:
                        abstractC0775aMo1610c = m705a(i2);
                        bitSet.set(i);
                        break;
                    case 2:
                    case 13:
                    case 14:
                    case 17:
                    default:
                        throw new C0514i("unknown tag byte: " + C0985a.m2298x(iM1965e));
                    case 3:
                        abstractC0775aMo1610c = C0790n.m1629a(this.f602a.m1963c(i2 + 1));
                        break;
                    case 4:
                        abstractC0775aMo1610c = C0789m.m1628a(this.f602a.m1963c(i2 + 1));
                        break;
                    case 5:
                        abstractC0775aMo1610c = C0796t.m1635a(this.f602a.m1964d(i2 + 1));
                        break;
                    case 6:
                        abstractC0775aMo1610c = C0786j.m1625a(this.f602a.m1964d(i2 + 1));
                        break;
                    case 7:
                        abstractC0775aMo1610c = new C0802z(C0805c.m1682c(((C0801y) m704a(this.f602a.m1966f(i2 + 1), bitSet)).m1649j()));
                        break;
                    case 8:
                        abstractC0775aMo1610c = m704a(this.f602a.m1966f(i2 + 1), bitSet);
                        break;
                    case 9:
                        abstractC0775aMo1610c = new C0788l((C0802z) m704a(this.f602a.m1966f(i2 + 1), bitSet), (C0799w) m704a(this.f602a.m1966f(i2 + 3), bitSet));
                        break;
                    case 10:
                        abstractC0775aMo1610c = new C0798v((C0802z) m704a(this.f602a.m1966f(i2 + 1), bitSet), (C0799w) m704a(this.f602a.m1966f(i2 + 3), bitSet));
                        break;
                    case 11:
                        abstractC0775aMo1610c = new C0791o((C0802z) m704a(this.f602a.m1966f(i2 + 1), bitSet), (C0799w) m704a(this.f602a.m1966f(i2 + 3), bitSet));
                        break;
                    case 12:
                        abstractC0775aMo1610c = new C0799w((C0801y) m704a(this.f602a.m1966f(i2 + 1), bitSet), (C0801y) m704a(this.f602a.m1966f(i2 + 3), bitSet));
                        break;
                    case 15:
                        throw new C0514i("MethodHandle not supported");
                    case 16:
                        throw new C0514i("MethodType not supported");
                    case 18:
                        throw new C0514i("InvokeDynamic not supported");
                }
                this.f603b.m1608a(i, abstractC0775aMo1610c);
            } catch (C0514i e) {
                e.m311a("...while parsing cst " + C0985a.m2296v(i) + " at offset " + C0985a.m2294t(i2));
                throw e;
            } catch (RuntimeException e2) {
                C0514i c0514i = new C0514i(e2);
                c0514i.m311a("...while parsing cst " + C0985a.m2296v(i) + " at offset " + C0985a.m2294t(i2));
                throw c0514i;
            }
        }
        return abstractC0775aMo1610c;
    }

    /* JADX INFO: renamed from: a */
    private C0801y m705a(int i) {
        int i2 = i + 3;
        try {
            return new C0801y(this.f602a.m1959a(i2, this.f602a.m1966f(i + 1) + i2));
        } catch (IllegalArgumentException e) {
            throw new C0514i(e);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m706c() {
        if (this.f605d < 0) {
            m707d();
            if (this.f606e != null) {
                new StringBuilder("constant_pool_count: ").append(C0985a.m2296v(this.f604c.length));
            }
            BitSet bitSet = new BitSet(this.f604c.length);
            for (int i = 1; i < this.f604c.length; i++) {
                if (this.f604c[i] != 0 && this.f603b.mo1610c(i) == null) {
                    m704a(i, bitSet);
                }
            }
            if (this.f606e != null) {
                for (int i2 = 1; i2 < this.f604c.length; i2++) {
                    AbstractC0775a abstractC0775aMo1610c = this.f603b.mo1610c(i2);
                    if (abstractC0775aMo1610c != null) {
                        if (bitSet.get(i2)) {
                            new StringBuilder().append(C0985a.m2296v(i2)).append(": utf8{\"").append(abstractC0775aMo1610c.mo657d()).append("\"}");
                        } else {
                            new StringBuilder().append(C0985a.m2296v(i2)).append(": ").append(abstractC0775aMo1610c.toString());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m707d() {
        int i;
        int iM1966f = 10;
        int i2 = 1;
        while (i2 < this.f604c.length) {
            this.f604c[i2] = iM1966f;
            int iM1965e = this.f602a.m1965e(iM1966f);
            switch (iM1965e) {
                case 1:
                    try {
                        iM1966f += this.f602a.m1966f(iM1966f + 1) + 3;
                        i = 1;
                    } catch (C0514i e) {
                        e.m311a("...while preparsing cst " + C0985a.m2296v(i2) + " at offset " + C0985a.m2294t(iM1966f));
                        throw e;
                    }
                    break;
                case 2:
                case 13:
                case 14:
                case 17:
                default:
                    throw new C0514i("unknown tag byte: " + C0985a.m2298x(iM1965e));
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    iM1966f += 5;
                    i = 1;
                    break;
                case 5:
                case 6:
                    i = 2;
                    iM1966f += 9;
                    break;
                case 7:
                case 8:
                    iM1966f += 3;
                    i = 1;
                    break;
                case 15:
                    throw new C0514i("MethodHandle not supported");
                case 16:
                    throw new C0514i("MethodType not supported");
                case 18:
                    throw new C0514i("InvokeDynamic not supported");
            }
            i2 += i;
        }
        this.f605d = iM1966f;
    }

    /* JADX INFO: renamed from: a */
    public final int m708a() {
        m706c();
        return this.f605d;
    }

    /* JADX INFO: renamed from: a */
    public final void m709a(InterfaceC0515j interfaceC0515j) {
        this.f606e = interfaceC0515j;
    }

    /* JADX INFO: renamed from: b */
    public final C0776aa m710b() {
        m706c();
        return this.f603b;
    }
}
