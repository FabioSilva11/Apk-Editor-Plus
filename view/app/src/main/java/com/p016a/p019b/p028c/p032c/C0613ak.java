package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0782f;
import com.p016a.p019b.p043h.C0888r;
import java.util.Collection;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.ak */
/* JADX INFO: loaded from: classes.dex */
public final class C0613ak extends AbstractC0610ah {

    /* JADX INFO: renamed from: a */
    private final TreeMap f1077a;

    public C0613ak(C0650r c0650r) {
        super("method_ids", c0650r);
        this.f1077a = new TreeMap();
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0605ac m1066a(AbstractC0775a abstractC0775a) {
        if (abstractC0775a == null) {
            throw new NullPointerException("cst == null");
        }
        m1103i();
        AbstractC0605ac abstractC0605ac = (AbstractC0605ac) this.f1077a.get((AbstractC0782f) abstractC0775a);
        if (abstractC0605ac == null) {
            throw new IllegalArgumentException("not found");
        }
        return abstractC0605ac;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized C0612aj m1067a(AbstractC0782f abstractC0782f) {
        C0612aj c0612aj;
        if (abstractC0782f == null) {
            throw new NullPointerException("method == null");
        }
        m1104j();
        c0612aj = (C0612aj) this.f1077a.get(abstractC0782f);
        if (c0612aj == null) {
            c0612aj = new C0612aj(abstractC0782f);
            this.f1077a.put(abstractC0782f, c0612aj);
        }
        return c0612aj;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final Collection mo1046a() {
        return this.f1077a.values();
    }

    /* JADX INFO: renamed from: a */
    public final void m1068a(C0888r c0888r) {
        m1103i();
        int size = this.f1077a.size();
        int iG = size == 0 ? 0 : m1101g();
        if (c0888r.m2019b()) {
            c0888r.m2010a(4, "method_ids_size: " + C0985a.m2294t(size));
            c0888r.m2010a(4, "method_ids_off:  " + C0985a.m2294t(iG));
        }
        c0888r.m2020c(size);
        c0888r.m2020c(iG);
    }

    /* JADX INFO: renamed from: b */
    public final int m1069b(AbstractC0782f abstractC0782f) {
        if (abstractC0782f == null) {
            throw new NullPointerException("ref == null");
        }
        m1103i();
        C0612aj c0612aj = (C0612aj) this.f1077a.get(abstractC0782f);
        if (c0612aj == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0612aj.m1051i();
    }
}
