package p000a.p001a.p003b.p004a.p005a;

/* JADX INFO: renamed from: a.a.b.a.a.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0012i extends C0019p {

    /* JADX INFO: renamed from: a */
    private final String f12a;

    public C0012i(String str, int i) {
        super(i);
        this.f12a = str;
    }

    /* JADX INFO: renamed from: a */
    public final String m6a() {
        return this.f12a;
    }

    /* JADX INFO: renamed from: b */
    public final String m7b() {
        return this.f12a.startsWith("res/") ? this.f12a.substring(4) : (this.f12a.startsWith("r/") || this.f12a.startsWith("R/")) ? this.f12a.substring(2) : this.f12a;
    }

    public final String toString() {
        return this.f12a;
    }
}
