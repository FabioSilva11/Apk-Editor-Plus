package p000a.p001a.p003b.p004a;

/* JADX INFO: renamed from: a.a.b.a.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0030d {

    /* JADX INFO: renamed from: a */
    public final int f63a;

    /* JADX INFO: renamed from: b */
    public final int f64b;

    public C0030d(int i) {
        this(i >>> 24, (i >> 16) & 255, 65535 & i, i);
    }

    private C0030d(int i, int i2, int i3, int i4) {
        this.f63a = i == 0 ? 2 : i;
        this.f64b = i4;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.f64b == ((C0030d) obj).f64b;
    }

    public final int hashCode() {
        return this.f64b + 527;
    }

    public final String toString() {
        return String.format("0x%08x", Integer.valueOf(this.f64b));
    }
}
