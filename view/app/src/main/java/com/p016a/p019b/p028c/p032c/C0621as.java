package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0803a;
import com.p016a.p019b.p043h.C0888r;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.as */
/* JADX INFO: loaded from: classes.dex */
public final class C0621as extends AbstractC0632bc {

    /* JADX INFO: renamed from: a */
    private final TreeMap f1098a;

    public C0621as(C0650r c0650r) {
        super("proto_ids", c0650r, 4);
        this.f1098a = new TreeMap();
    }

    /* JADX INFO: renamed from: a */
    public final C0620ar m1092a(C0803a c0803a) {
        if (c0803a == null) {
            throw new NullPointerException("prototype == null");
        }
        m1104j();
        C0620ar c0620ar = (C0620ar) this.f1098a.get(c0803a);
        if (c0620ar != null) {
            return c0620ar;
        }
        C0620ar c0620ar2 = new C0620ar(c0803a);
        this.f1098a.put(c0803a, c0620ar2);
        return c0620ar2;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final Collection mo1046a() {
        return this.f1098a.values();
    }

    /* JADX INFO: renamed from: b */
    public final int m1093b(C0803a c0803a) {
        if (c0803a == null) {
            throw new NullPointerException("prototype == null");
        }
        m1103i();
        C0620ar c0620ar = (C0620ar) this.f1098a.get(c0803a);
        if (c0620ar == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0620ar.m1051i();
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0632bc
    /* JADX INFO: renamed from: b */
    protected final void mo1047b() {
        int i = 0;
        Iterator it = this.f1098a.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            ((C0620ar) it.next()).m1049a(i2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1094b(C0888r c0888r) {
        m1103i();
        int size = this.f1098a.size();
        int iG = size == 0 ? 0 : m1101g();
        if (size > 65536) {
            throw new UnsupportedOperationException("too many proto ids");
        }
        if (c0888r.m2019b()) {
            c0888r.m2010a(4, "proto_ids_size:  " + C0985a.m2294t(size));
            c0888r.m2010a(4, "proto_ids_off:   " + C0985a.m2294t(iG));
        }
        c0888r.m2020c(size);
        c0888r.m2020c(iG);
    }
}
