package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.C0421t;
import com.p016a.p019b.p026b.p027a.C0523a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0888r;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.ba */
/* JADX INFO: loaded from: classes.dex */
public final class C0630ba extends AbstractC0632bc {

    /* JADX INFO: renamed from: a */
    private final TreeMap f1115a;

    public C0630ba(C0650r c0650r) {
        super("type_ids", c0650r, 4);
        this.f1115a = new TreeMap();
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0605ac m1116a(AbstractC0775a abstractC0775a) {
        if (abstractC0775a == null) {
            throw new NullPointerException("cst == null");
        }
        m1103i();
        AbstractC0605ac abstractC0605ac = (AbstractC0605ac) this.f1115a.get(((C0802z) abstractC0775a).m1655i());
        if (abstractC0605ac == null) {
            throw new IllegalArgumentException("not found: " + abstractC0775a);
        }
        return abstractC0605ac;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized C0628az m1117a(C0802z c0802z) {
        C0628az c0628az;
        if (c0802z == null) {
            throw new NullPointerException("type == null");
        }
        m1104j();
        C0805c c0805cM1655i = c0802z.m1655i();
        c0628az = (C0628az) this.f1115a.get(c0805cM1655i);
        if (c0628az == null) {
            c0628az = new C0628az(c0802z);
            this.f1115a.put(c0805cM1655i, c0628az);
        }
        return c0628az;
    }

    /* JADX INFO: renamed from: a */
    public final C0628az m1118a(C0805c c0805c) {
        if (c0805c == null) {
            throw new NullPointerException("type == null");
        }
        m1104j();
        C0628az c0628az = (C0628az) this.f1115a.get(c0805c);
        if (c0628az != null) {
            return c0628az;
        }
        C0628az c0628az2 = new C0628az(new C0802z(c0805c));
        this.f1115a.put(c0805c, c0628az2);
        return c0628az2;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final Collection mo1046a() {
        return this.f1115a.values();
    }

    /* JADX INFO: renamed from: b */
    public final int m1119b(C0802z c0802z) {
        if (c0802z == null) {
            throw new NullPointerException("type == null");
        }
        return m1120b(c0802z.m1655i());
    }

    /* JADX INFO: renamed from: b */
    public final int m1120b(C0805c c0805c) {
        if (c0805c == null) {
            throw new NullPointerException("type == null");
        }
        m1103i();
        C0628az c0628az = (C0628az) this.f1115a.get(c0805c);
        if (c0628az == null) {
            throw new IllegalArgumentException("not found: " + c0805c);
        }
        return c0628az.m1051i();
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0632bc
    /* JADX INFO: renamed from: b */
    protected final void mo1047b() {
        int i = 0;
        Iterator it = this.f1115a.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            ((C0628az) it.next()).m1049a(i2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1121b(C0888r c0888r) {
        m1103i();
        int size = this.f1115a.size();
        int iG = size == 0 ? 0 : m1101g();
        if (size > 65536) {
            throw new C0421t("Too many type references: " + size + "; max is 65536.\n" + C0523a.m800a());
        }
        if (c0888r.m2019b()) {
            c0888r.m2010a(4, "type_ids_size:   " + C0985a.m2294t(size));
            c0888r.m2010a(4, "type_ids_off:    " + C0985a.m2294t(iG));
        }
        c0888r.m2020c(size);
        c0888r.m2020c(iG);
    }
}
