package p000a.p001a.p003b.p004a;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import p000a.p001a.p002a.C0002b;

/* JADX INFO: renamed from: a.a.b.a.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0032f {

    /* JADX INFO: renamed from: a */
    private final C0030d f73a;

    /* JADX INFO: renamed from: b */
    private final String f74b;

    /* JADX INFO: renamed from: c */
    private final C0031e f75c;

    /* JADX INFO: renamed from: d */
    private final C0035i f76d;

    /* JADX INFO: renamed from: e */
    private final Map f77e = new LinkedHashMap();

    public C0032f(C0030d c0030d, String str, C0031e c0031e, C0035i c0035i, boolean z) {
        this.f73a = c0030d;
        if (c0035i.unsafe(str) != null) {
            str = "dup_" + c0030d.toString();
        } else if (str == null || str.isEmpty()) {
            str = "noname_" + c0030d.toString();
        }
        this.f74b = str;
        this.f75c = c0031e;
        this.f76d = c0035i;
    }

    /* JADX INFO: renamed from: a */
    public final C0033g m58a(C0029c c0029c) throws C0002b {
        C0033g c0033g = (C0033g) this.f77e.get(c0029c);
        if (c0033g == null) {
            throw new C0002b(String.format("resource: spec=%s, config=%s", this, c0029c));
        }
        return c0033g;
    }

    /* JADX INFO: renamed from: a */
    public final String m59a(C0031e c0031e, boolean z) {
        return (this.f75c.equals(c0031e) ? "" : this.f75c.m56f() + ":") + (z ? "" : this.f76d.m80a() + "/") + m67f();
    }

    /* JADX INFO: renamed from: a */
    public final Set m60a() {
        return new LinkedHashSet(this.f77e.values());
    }

    /* JADX INFO: renamed from: a */
    public final void m61a(C0033g c0033g) {
        m62a(c0033g, true);
    }

    /* JADX INFO: renamed from: a */
    public final void m62a(C0033g c0033g, boolean z) {
        this.f77e.put(c0033g.m73b().m76a(), c0033g);
    }

    /* JADX INFO: renamed from: b */
    public final Map m63b() {
        return this.f77e;
    }

    /* JADX INFO: renamed from: c */
    public final C0033g m64c() {
        return m58a(new C0029c());
    }

    /* JADX INFO: renamed from: d */
    public final boolean m65d() {
        return this.f77e.containsKey(new C0029c());
    }

    /* JADX INFO: renamed from: e */
    public final C0030d m66e() {
        return this.f73a;
    }

    /* JADX INFO: renamed from: f */
    public final String m67f() {
        return this.f74b.replaceAll("\"", "q");
    }

    /* JADX INFO: renamed from: g */
    public final C0031e m68g() {
        return this.f75c;
    }

    /* JADX INFO: renamed from: h */
    public final C0035i m69h() {
        return this.f76d;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m70i() {
        return this.f74b.startsWith("carlos_ae_");
    }

    public final String toString() {
        return this.f73a.toString() + " " + this.f76d.toString() + "/" + this.f74b;
    }
}
