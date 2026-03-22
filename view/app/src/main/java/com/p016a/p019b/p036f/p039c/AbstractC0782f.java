package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p036f.p040d.C0803a;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.c.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0782f extends AbstractC0797u {

    /* JADX INFO: renamed from: a */
    private final C0803a f1904a;

    /* JADX INFO: renamed from: b */
    private C0803a f1905b;

    AbstractC0782f(C0802z c0802z, C0799w c0799w) {
        super(c0802z, c0799w);
        this.f1904a = C0803a.m1658a(m1637l().m1639b().m1649j());
        this.f1905b = null;
    }

    /* JADX INFO: renamed from: a */
    public final C0803a m1616a(boolean z) {
        if (z) {
            return this.f1904a;
        }
        if (this.f1905b == null) {
            this.f1905b = this.f1904a.m1663a(m1636k().m1655i());
        }
        return this.f1905b;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return this.f1904a.m1664a();
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0797u, com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        int iMo1602b = super.mo1602b(abstractC0775a);
        return iMo1602b != 0 ? iMo1602b : this.f1904a.compareTo(((AbstractC0782f) abstractC0775a).f1904a);
    }

    /* JADX INFO: renamed from: b */
    public final int m1617b(boolean z) {
        return m1616a(z).m1665b().m1678e();
    }

    /* JADX INFO: renamed from: i */
    public final C0803a m1618i() {
        return this.f1904a;
    }
}
