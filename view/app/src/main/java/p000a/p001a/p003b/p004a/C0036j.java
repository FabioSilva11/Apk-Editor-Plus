package p000a.p001a.p003b.p004a;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: renamed from: a.a.b.a.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0036j {

    /* JADX INFO: renamed from: a */
    private final C0031e f86a;

    /* JADX INFO: renamed from: b */
    private final C0035i f87b;

    /* JADX INFO: renamed from: c */
    private final C0034h f88c;

    /* JADX INFO: renamed from: d */
    private final Set f89d = new LinkedHashSet();

    public C0036j(C0031e c0031e, C0035i c0035i, C0034h c0034h) {
        this.f86a = c0031e;
        this.f87b = c0035i;
        this.f88c = c0034h;
    }

    /* JADX INFO: renamed from: a */
    public final String m85a() {
        return "values" + this.f88c.m76a().m42a() + "/" + this.f87b.m80a() + (this.f87b.m80a().endsWith("s") ? "" : "s") + ".xml";
    }

    /* JADX INFO: renamed from: a */
    public final boolean m86a(C0033g c0033g) {
        return this.f86a.m53c(c0033g.m74c().m66e());
    }

    /* JADX INFO: renamed from: b */
    public final Set m87b() {
        return this.f89d;
    }

    /* JADX INFO: renamed from: b */
    public final void m88b(C0033g c0033g) {
        this.f89d.add(c0033g);
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0036j c0036j = (C0036j) obj;
        if (this.f87b == c0036j.f87b || (this.f87b != null && this.f87b.equals(c0036j.f87b))) {
            return this.f88c == c0036j.f88c || (this.f88c != null && this.f88c.equals(c0036j.f88c));
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f87b != null ? this.f87b.hashCode() : 0) + 527) * 31) + (this.f88c != null ? this.f88c.hashCode() : 0);
    }
}
