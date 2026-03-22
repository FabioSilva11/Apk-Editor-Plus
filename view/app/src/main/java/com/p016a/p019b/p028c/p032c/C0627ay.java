package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p043h.C0888r;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.ay */
/* JADX INFO: loaded from: classes.dex */
public final class C0627ay extends AbstractC0632bc {

    /* JADX INFO: renamed from: a */
    private final TreeMap f1113a;

    public C0627ay(C0650r c0650r) {
        super("string_ids", c0650r, 4);
        this.f1113a = new TreeMap();
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0605ac m1112a(AbstractC0775a abstractC0775a) {
        if (abstractC0775a == null) {
            throw new NullPointerException("cst == null");
        }
        m1103i();
        AbstractC0605ac abstractC0605ac = (AbstractC0605ac) this.f1113a.get((C0801y) abstractC0775a);
        if (abstractC0605ac == null) {
            throw new IllegalArgumentException("not found");
        }
        return abstractC0605ac;
    }

    /* JADX INFO: renamed from: a */
    public final C0626ax m1113a(C0801y c0801y) {
        C0626ax c0626ax = new C0626ax(c0801y);
        m1104j();
        C0801y c0801yM1111c = c0626ax.m1111c();
        C0626ax c0626ax2 = (C0626ax) this.f1113a.get(c0801yM1111c);
        if (c0626ax2 != null) {
            return c0626ax2;
        }
        this.f1113a.put(c0801yM1111c, c0626ax);
        return c0626ax;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final Collection mo1046a() {
        return this.f1113a.values();
    }

    /* JADX INFO: renamed from: b */
    public final int m1114b(C0801y c0801y) {
        if (c0801y == null) {
            throw new NullPointerException("string == null");
        }
        m1103i();
        C0626ax c0626ax = (C0626ax) this.f1113a.get(c0801y);
        if (c0626ax == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0626ax.m1051i();
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0632bc
    /* JADX INFO: renamed from: b */
    protected final void mo1047b() {
        int i = 0;
        Iterator it = this.f1113a.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            ((C0626ax) it.next()).m1049a(i2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1115b(C0888r c0888r) {
        m1103i();
        int size = this.f1113a.size();
        int iG = size == 0 ? 0 : m1101g();
        if (c0888r.m2019b()) {
            c0888r.m2010a(4, "string_ids_size: " + C0985a.m2294t(size));
            c0888r.m2010a(4, "string_ids_off:  " + C0985a.m2294t(iG));
        }
        c0888r.m2020c(size);
        c0888r.m2020c(iG);
    }
}
