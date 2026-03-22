package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0795s;
import com.p016a.p019b.p036f.p039c.C0780d;
import com.p016a.p019b.p036f.p039c.C0781e;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0888r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.c.c.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0641i extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final C0802z f1143a;

    /* JADX INFO: renamed from: b */
    private final ArrayList f1144b;

    /* JADX INFO: renamed from: c */
    private final HashMap f1145c;

    /* JADX INFO: renamed from: d */
    private final ArrayList f1146d;

    /* JADX INFO: renamed from: e */
    private final ArrayList f1147e;

    /* JADX INFO: renamed from: f */
    private final ArrayList f1148f;

    /* JADX INFO: renamed from: g */
    private C0780d f1149g;

    /* JADX INFO: renamed from: h */
    private byte[] f1150h;

    public C0641i(C0802z c0802z) {
        super(1, -1);
        if (c0802z == null) {
            throw new NullPointerException("thisClass == null");
        }
        this.f1143a = c0802z;
        this.f1144b = new ArrayList(20);
        this.f1145c = new HashMap(40);
        this.f1146d = new ArrayList(20);
        this.f1147e = new ArrayList(20);
        this.f1148f = new ArrayList(20);
        this.f1149g = null;
    }

    /* JADX INFO: renamed from: a */
    private static void m1159a(C0650r c0650r, C0888r c0888r, String str, ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, "  " + str + ":");
        }
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            int iMo1238a = ((AbstractC0653u) arrayList.get(i2)).mo1238a(c0650r, c0888r, i, i2);
            i2++;
            i = iMo1238a;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1160a(C0888r c0888r, String str, int i) {
        if (c0888r.m2019b()) {
            c0888r.m2015a(String.format("  %-21s %08x", str + "_size:", Integer.valueOf(i)));
        }
        c0888r.m2024e(i);
    }

    /* JADX INFO: renamed from: b */
    private void m1161b(C0650r c0650r, C0888r c0888r) {
        boolean zM2019b = c0888r.m2019b();
        if (zM2019b) {
            c0888r.m2010a(0, m1085h() + " class data for " + this.f1143a.mo657d());
        }
        m1160a(c0888r, "static_fields", this.f1144b.size());
        m1160a(c0888r, "instance_fields", this.f1146d.size());
        m1160a(c0888r, "direct_methods", this.f1147e.size());
        m1160a(c0888r, "virtual_methods", this.f1148f.size());
        m1159a(c0650r, c0888r, "static_fields", this.f1144b);
        m1159a(c0650r, c0888r, "instance_fields", this.f1146d);
        m1159a(c0650r, c0888r, "direct_methods", this.f1147e);
        m1159a(c0650r, c0888r, "virtual_methods", this.f1148f);
        if (zM2019b) {
            c0888r.m2022d();
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1056l;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final void mo1041a(AbstractC0622at abstractC0622at, int i) {
        C0888r c0888r = new C0888r();
        m1161b(abstractC0622at.m1099e(), c0888r);
        this.f1150h = c0888r.m2028g();
        m1080a(this.f1150h.length);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        if (!this.f1144b.isEmpty()) {
            m1168e();
            Iterator it = this.f1144b.iterator();
            while (it.hasNext()) {
                ((C0652t) it.next()).m1240a(c0650r);
            }
        }
        if (!this.f1146d.isEmpty()) {
            Collections.sort(this.f1146d);
            Iterator it2 = this.f1146d.iterator();
            while (it2.hasNext()) {
                ((C0652t) it2.next()).m1240a(c0650r);
            }
        }
        if (!this.f1147e.isEmpty()) {
            Collections.sort(this.f1147e);
            Iterator it3 = this.f1147e.iterator();
            while (it3.hasNext()) {
                ((C0654v) it3.next()).m1244a(c0650r);
            }
        }
        if (this.f1148f.isEmpty()) {
            return;
        }
        Collections.sort(this.f1148f);
        Iterator it4 = this.f1148f.iterator();
        while (it4.hasNext()) {
            ((C0654v) it4.next()).m1244a(c0650r);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1162a(C0652t c0652t) {
        if (c0652t == null) {
            throw new NullPointerException("field == null");
        }
        this.f1146d.add(c0652t);
    }

    /* JADX INFO: renamed from: a */
    public final void m1163a(C0652t c0652t, AbstractC0775a abstractC0775a) {
        if (c0652t == null) {
            throw new NullPointerException("field == null");
        }
        if (this.f1149g != null) {
            throw new UnsupportedOperationException("static fields already sorted");
        }
        this.f1144b.add(c0652t);
        this.f1145c.put(c0652t, abstractC0775a);
    }

    /* JADX INFO: renamed from: a */
    public final void m1164a(C0654v c0654v) {
        if (c0654v == null) {
            throw new NullPointerException("method == null");
        }
        this.f1147e.add(c0654v);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    public final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        if (c0888r.m2019b()) {
            m1161b(c0650r, c0888r);
        } else {
            c0888r.m2016a(this.f1150h);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        return toString();
    }

    /* JADX INFO: renamed from: b */
    public final void m1165b(C0654v c0654v) {
        if (c0654v == null) {
            throw new NullPointerException("method == null");
        }
        this.f1148f.add(c0654v);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1166c() {
        return this.f1144b.isEmpty() && this.f1146d.isEmpty() && this.f1147e.isEmpty() && this.f1148f.isEmpty();
    }

    /* JADX INFO: renamed from: d */
    public final ArrayList m1167d() {
        ArrayList arrayList = new ArrayList(this.f1147e.size() + this.f1148f.size());
        arrayList.addAll(this.f1147e);
        arrayList.addAll(this.f1148f);
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    public final C0780d m1168e() {
        C0780d c0780d;
        if (this.f1149g == null && this.f1144b.size() != 0) {
            Collections.sort(this.f1144b);
            int size = this.f1144b.size();
            while (size > 0) {
                AbstractC0775a abstractC0775a = (AbstractC0775a) this.f1145c.get((C0652t) this.f1144b.get(size - 1));
                if (!(abstractC0775a instanceof AbstractC0795s)) {
                    if (abstractC0775a != null) {
                        break;
                    }
                    size--;
                } else {
                    if (((AbstractC0795s) abstractC0775a).mo1633k() != 0) {
                        break;
                    }
                    size--;
                }
            }
            if (size == 0) {
                c0780d = null;
            } else {
                C0781e c0781e = new C0781e(size);
                for (int i = 0; i < size; i++) {
                    C0652t c0652t = (C0652t) this.f1144b.get(i);
                    AbstractC0775a abstractC0775aM2185a = (AbstractC0775a) this.f1145c.get(c0652t);
                    if (abstractC0775aM2185a == null) {
                        abstractC0775aM2185a = C0985a.m2185a(c0652t.m1239a().mo663a());
                    }
                    c0781e.m1615a(i, abstractC0775aM2185a);
                }
                c0781e.mo549b_();
                c0780d = new C0780d(c0781e);
            }
            this.f1149g = c0780d;
        }
        return this.f1149g;
    }
}
