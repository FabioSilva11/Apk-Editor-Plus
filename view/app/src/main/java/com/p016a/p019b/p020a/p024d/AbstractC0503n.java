package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.C0514i;
import com.p016a.p019b.p020a.p025e.C0516k;
import com.p016a.p019b.p020a.p025e.InterfaceC0507b;
import com.p016a.p019b.p020a.p025e.InterfaceC0511f;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p039c.InterfaceC0778b;
import com.p016a.p019b.p043h.C0873c;

/* JADX INFO: renamed from: com.a.b.a.d.n */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0503n {

    /* JADX INFO: renamed from: a */
    private final C0500k f642a;

    /* JADX INFO: renamed from: b */
    private final C0802z f643b;

    /* JADX INFO: renamed from: c */
    private final int f644c;

    /* JADX INFO: renamed from: d */
    private final C0491b f645d;

    /* JADX INFO: renamed from: e */
    private int f646e;

    /* JADX INFO: renamed from: f */
    private InterfaceC0515j f647f;

    public AbstractC0503n(C0500k c0500k, C0802z c0802z, int i, C0491b c0491b) {
        if (c0500k == null) {
            throw new NullPointerException("cf == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (c0491b == null) {
            throw new NullPointerException("attributeFactory == null");
        }
        this.f642a = c0500k;
        this.f643b = c0802z;
        this.f644c = i;
        this.f645d = c0491b;
        this.f646e = -1;
    }

    /* JADX INFO: renamed from: a */
    protected abstract InterfaceC0511f mo760a(int i, int i2, C0799w c0799w, InterfaceC0507b interfaceC0507b);

    /* JADX INFO: renamed from: a */
    protected abstract String mo762a(int i);

    /* JADX INFO: renamed from: a */
    public final void m765a(InterfaceC0515j interfaceC0515j) {
        this.f647f = interfaceC0515j;
    }

    /* JADX INFO: renamed from: b */
    protected abstract String mo763b();

    /* JADX INFO: renamed from: c */
    protected abstract int mo764c();

    /* JADX INFO: renamed from: d */
    public final int m766d() {
        m767e();
        return this.f646e;
    }

    /* JADX INFO: renamed from: e */
    protected final void m767e() {
        if (this.f646e < 0) {
            int iMo764c = mo764c();
            int iM768f = m768f();
            int i = this.f644c + 2;
            C0873c c0873cM745b = this.f642a.m745b();
            InterfaceC0778b interfaceC0778bM750g = this.f642a.m750g();
            if (this.f647f != null) {
                new StringBuilder().append(mo763b()).append("s_count: ").append(C0985a.m2296v(iM768f));
            }
            int iM723a = i;
            for (int i2 = 0; i2 < iM768f; i2++) {
                try {
                    int iM1966f = c0873cM745b.m1966f(iM723a);
                    int iM1966f2 = c0873cM745b.m1966f(iM723a + 2);
                    int iM1966f3 = c0873cM745b.m1966f(iM723a + 4);
                    C0801y c0801y = (C0801y) interfaceC0778bM750g.mo1607a(iM1966f2);
                    C0801y c0801y2 = (C0801y) interfaceC0778bM750g.mo1607a(iM1966f3);
                    if (this.f647f != null) {
                        c0801y.m1649j();
                        c0801y2.m1649j();
                        new StringBuilder("\n").append(mo763b()).append("s[").append(i2).append("]:\n");
                        new StringBuilder("access_flags: ").append(mo762a(iM1966f));
                        new StringBuilder("name: ").append(c0801y.mo657d());
                        new StringBuilder("descriptor: ").append(c0801y2.mo657d());
                    }
                    C0492c c0492c = new C0492c(this.f642a, iMo764c, iM723a + 6, this.f645d);
                    c0492c.m724a(this.f647f);
                    iM723a = c0492c.m723a();
                    C0516k c0516kM725b = c0492c.m725b();
                    c0516kM725b.mo549b_();
                    mo760a(i2, iM1966f, new C0799w(c0801y, c0801y2), c0516kM725b);
                    if (this.f647f != null) {
                        new StringBuilder("end ").append(mo763b()).append("s[").append(i2).append("]\n");
                        c0801y.m1649j();
                        c0801y2.m1649j();
                    }
                } catch (C0514i e) {
                    e.m311a("...while parsing " + mo763b() + "s[" + i2 + "]");
                    throw e;
                } catch (RuntimeException e2) {
                    C0514i c0514i = new C0514i(e2);
                    c0514i.m311a("...while parsing " + mo763b() + "s[" + i2 + "]");
                    throw c0514i;
                }
            }
            this.f646e = iM723a;
        }
    }

    /* JADX INFO: renamed from: f */
    protected final int m768f() {
        return this.f642a.m745b().m1966f(this.f644c);
    }

    /* JADX INFO: renamed from: g */
    protected final C0802z m769g() {
        return this.f643b;
    }
}
