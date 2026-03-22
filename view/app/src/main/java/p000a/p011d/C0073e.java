package p000a.p011d;

import java.io.Serializable;

/* JADX INFO: renamed from: a.d.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0073e implements Serializable {

    /* JADX INFO: renamed from: a */
    public final Object f190a;

    /* JADX INFO: renamed from: b */
    public Object f191b;

    public C0073e(Object obj, Object obj2) {
        this.f190a = obj;
        this.f191b = obj2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0073e c0073e = (C0073e) obj;
        if (this.f190a == c0073e.f190a || (this.f190a != null && this.f190a.equals(c0073e.f190a))) {
            return this.f191b == c0073e.f191b || (this.f191b != null && this.f191b.equals(c0073e.f191b));
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f190a != null ? this.f190a.hashCode() : 0) + 213) * 71) + (this.f191b != null ? this.f191b.hashCode() : 0);
    }
}
