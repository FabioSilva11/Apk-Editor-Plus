package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0888r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0643k extends AbstractC0632bc {

    /* JADX INFO: renamed from: a */
    private final TreeMap f1159a;

    /* JADX INFO: renamed from: b */
    private ArrayList f1160b;

    public C0643k(C0650r c0650r) {
        super("class_defs", c0650r, 4);
        this.f1159a = new TreeMap();
        this.f1160b = null;
    }

    /* JADX INFO: renamed from: a */
    private int m1184a(C0805c c0805c, int i, int i2) {
        C0642j c0642j = (C0642j) this.f1159a.get(c0805c);
        if (c0642j == null || c0642j.m1050h()) {
            return i;
        }
        if (i2 < 0) {
            throw new RuntimeException("class circularity with " + c0805c);
        }
        int i3 = i2 - 1;
        C0802z c0802zM1180d = c0642j.m1180d();
        if (c0802zM1180d != null) {
            i = m1184a(c0802zM1180d.m1655i(), i, i3);
        }
        InterfaceC0807e interfaceC0807eM1181e = c0642j.m1181e();
        int iMo759d_ = interfaceC0807eM1181e.mo759d_();
        for (int i4 = 0; i4 < iMo759d_; i4++) {
            i = m1184a(interfaceC0807eM1181e.mo756a(i4), i, i3);
        }
        c0642j.m1049a(i);
        this.f1160b.add(c0642j);
        return i + 1;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0605ac m1185a(AbstractC0775a abstractC0775a) {
        m1103i();
        AbstractC0605ac abstractC0605ac = (AbstractC0605ac) this.f1159a.get(((C0802z) abstractC0775a).m1655i());
        if (abstractC0605ac == null) {
            throw new IllegalArgumentException("not found");
        }
        return abstractC0605ac;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final Collection mo1046a() {
        return this.f1160b != null ? this.f1160b : this.f1159a.values();
    }

    /* JADX INFO: renamed from: a */
    public final void m1186a(C0642j c0642j) {
        try {
            C0805c c0805cM1655i = c0642j.m1179c().m1655i();
            m1104j();
            if (this.f1159a.get(c0805cM1655i) != null) {
                throw new IllegalArgumentException("already added: " + c0805cM1655i);
            }
            this.f1159a.put(c0805cM1655i, c0642j);
        } catch (NullPointerException e) {
            throw new NullPointerException("clazz == null");
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1187a(C0888r c0888r) {
        m1103i();
        int size = this.f1159a.size();
        int iG = size == 0 ? 0 : m1101g();
        if (c0888r.m2019b()) {
            c0888r.m2010a(4, "class_defs_size: " + C0985a.m2294t(size));
            c0888r.m2010a(4, "class_defs_off:  " + C0985a.m2294t(iG));
        }
        c0888r.m2020c(size);
        c0888r.m2020c(iG);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0632bc
    /* JADX INFO: renamed from: b */
    protected final void mo1047b() {
        int size = this.f1159a.size();
        int iM1184a = 0;
        this.f1160b = new ArrayList(size);
        Iterator it = this.f1159a.keySet().iterator();
        while (true) {
            int i = iM1184a;
            if (!it.hasNext()) {
                return;
            } else {
                iM1184a = m1184a((C0805c) it.next(), i, size - i);
            }
        }
    }
}
