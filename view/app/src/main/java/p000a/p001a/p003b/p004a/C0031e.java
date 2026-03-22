package p000a.p001a.p003b.p004a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.p001a.C0000a;
import p000a.p001a.p002a.C0002b;
import p000a.p001a.p003b.p004a.p005a.C0012i;
import p000a.p001a.p003b.p004a.p005a.C0027x;
import p000a.p001a.p003b.p008d.InterfaceC0059a;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: a.a.b.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0031e {

    /* JADX INFO: renamed from: a */
    private final C0985a f65a;

    /* JADX INFO: renamed from: b */
    private final int f66b;

    /* JADX INFO: renamed from: c */
    private final String f67c;

    /* JADX INFO: renamed from: d */
    private final Map f68d = new LinkedHashMap();

    /* JADX INFO: renamed from: e */
    private final Map f69e = new LinkedHashMap();

    /* JADX INFO: renamed from: f */
    private final Map f70f = new LinkedHashMap();

    /* JADX INFO: renamed from: g */
    private final Set f71g = new HashSet();

    /* JADX INFO: renamed from: h */
    private C0027x f72h;

    public C0031e(C0985a c0985a, int i, String str) {
        this.f65a = c0985a;
        this.f66b = i;
        this.f67c = str;
    }

    /* JADX INFO: renamed from: a */
    public final C0034h m43a(C0029c c0029c) {
        C0034h c0034h = (C0034h) this.f69e.get(c0029c);
        if (c0034h != null) {
            return c0034h;
        }
        C0034h c0034h2 = new C0034h(c0029c);
        this.f69e.put(c0029c, c0034h2);
        return c0034h2;
    }

    /* JADX INFO: renamed from: a */
    public final List m44a() {
        return new ArrayList(this.f68d.values());
    }

    /* JADX INFO: renamed from: a */
    public final void m45a(int i) {
        this.f71g.add(new C0030d(i));
    }

    /* JADX INFO: renamed from: a */
    public final void m46a(C0032f c0032f) {
        this.f68d.remove(c0032f.m66e());
    }

    /* JADX INFO: renamed from: a */
    public final void m47a(C0035i c0035i) {
        if (this.f70f.containsKey(c0035i.m80a())) {
            return;
        }
        this.f70f.put(c0035i.m80a(), c0035i);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m48a(C0030d c0030d) {
        return this.f68d.containsKey(c0030d);
    }

    /* JADX INFO: renamed from: b */
    public final C0032f m49b(C0030d c0030d) throws C0002b {
        C0032f c0032f = (C0032f) this.f68d.get(c0030d);
        if (c0032f == null) {
            throw new C0002b("resource spec: " + c0030d.toString());
        }
        return c0032f;
    }

    /* JADX INFO: renamed from: b */
    public final Set m50b() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f68d.values().iterator();
        while (it.hasNext()) {
            for (C0033g c0033g : ((C0032f) it.next()).m60a()) {
                if (c0033g.m75d() instanceof C0012i) {
                    hashSet.add(c0033g);
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: b */
    public final void m51b(C0032f c0032f) throws C0000a {
        if (this.f68d.put(c0032f.m66e(), c0032f) != null) {
            throw new C0000a("Multiple resource specs: " + c0032f);
        }
    }

    /* JADX INFO: renamed from: c */
    public final Collection m52c() {
        HashMap map = new HashMap();
        Iterator it = this.f68d.values().iterator();
        while (it.hasNext()) {
            for (C0033g c0033g : ((C0032f) it.next()).m60a()) {
                if (c0033g.m75d() instanceof InterfaceC0059a) {
                    C0035i c0035iM69h = c0033g.m74c().m69h();
                    C0034h c0034hM73b = c0033g.m73b();
                    C0073e c0073e = new C0073e(c0035iM69h, c0034hM73b);
                    C0036j c0036j = (C0036j) map.get(c0073e);
                    if (c0036j == null) {
                        c0036j = new C0036j(this, c0035iM69h, c0034hM73b);
                        map.put(c0073e, c0036j);
                    }
                    c0036j.m88b(c0033g);
                }
            }
        }
        return map.values();
    }

    /* JADX INFO: renamed from: c */
    final boolean m53c(C0030d c0030d) {
        return this.f71g.contains(c0030d);
    }

    /* JADX INFO: renamed from: d */
    public final C0985a m54d() {
        return this.f65a;
    }

    /* JADX INFO: renamed from: e */
    public final int m55e() {
        return this.f66b;
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0031e c0031e = (C0031e) obj;
        return (this.f65a == c0031e.f65a || (this.f65a != null && this.f65a.equals(c0031e.f65a))) && this.f66b == c0031e.f66b;
    }

    /* JADX INFO: renamed from: f */
    public final String m56f() {
        return this.f67c;
    }

    /* JADX INFO: renamed from: g */
    public final C0027x m57g() {
        if (this.f72h == null) {
            this.f72h = new C0027x(this);
        }
        return this.f72h;
    }

    public final int getSize() {
        return this.f68d.size();
    }

    public final int hashCode() {
        return (((this.f65a != null ? this.f65a.hashCode() : 0) + 527) * 31) + this.f66b;
    }

    public final String toString() {
        return "package: " + this.f67c + ", " + super.toString();
    }
}
