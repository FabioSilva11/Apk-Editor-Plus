package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p043h.C0888r;
import java.util.Collection;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0657y extends AbstractC0610ah {

    /* JADX INFO: renamed from: a */
    private final TreeMap f1212a;

    public C0657y(C0650r c0650r) {
        super("field_ids", c0650r);
        this.f1212a = new TreeMap();
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0605ac m1249a(AbstractC0775a abstractC0775a) {
        if (abstractC0775a == null) {
            throw new NullPointerException("cst == null");
        }
        m1103i();
        AbstractC0605ac abstractC0605ac = (AbstractC0605ac) this.f1212a.get((C0788l) abstractC0775a);
        if (abstractC0605ac == null) {
            throw new IllegalArgumentException("not found");
        }
        return abstractC0605ac;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized C0656x m1250a(C0788l c0788l) {
        C0656x c0656x;
        if (c0788l == null) {
            throw new NullPointerException("field == null");
        }
        m1104j();
        c0656x = (C0656x) this.f1212a.get(c0788l);
        if (c0656x == null) {
            c0656x = new C0656x(c0788l);
            this.f1212a.put(c0788l, c0656x);
        }
        return c0656x;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final Collection mo1046a() {
        return this.f1212a.values();
    }

    /* JADX INFO: renamed from: a */
    public final void m1251a(C0888r c0888r) {
        m1103i();
        int size = this.f1212a.size();
        int iG = size == 0 ? 0 : m1101g();
        if (c0888r.m2019b()) {
            c0888r.m2010a(4, "field_ids_size:  " + C0985a.m2294t(size));
            c0888r.m2010a(4, "field_ids_off:   " + C0985a.m2294t(iG));
        }
        c0888r.m2020c(size);
        c0888r.m2020c(iG);
    }

    /* JADX INFO: renamed from: b */
    public final int m1252b(C0788l c0788l) {
        if (c0788l == null) {
            throw new NullPointerException("ref == null");
        }
        m1103i();
        C0656x c0656x = (C0656x) this.f1212a.get(c0788l);
        if (c0656x == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0656x.m1051i();
    }
}
