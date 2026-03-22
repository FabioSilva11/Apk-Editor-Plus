package com.p016a.p017a;

/* JADX INFO: renamed from: com.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0396a implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0410i f335a;

    /* JADX INFO: renamed from: b */
    private final byte f336b;

    /* JADX INFO: renamed from: c */
    private final C0422u f337c;

    public C0396a(C0410i c0410i, byte b2, C0422u c0422u) {
        this.f335a = c0410i;
        this.f336b = b2;
        this.f337c = c0422u;
    }

    /* JADX INFO: renamed from: c */
    private int m302c() {
        C0423v c0423vM305b = m305b();
        c0423vM305b.m410c();
        return c0423vM305b.m411d();
    }

    /* JADX INFO: renamed from: a */
    public final byte m303a() {
        return this.f336b;
    }

    /* JADX INFO: renamed from: a */
    public final void m304a(C0416o c0416o) {
        c0416o.mo307d(this.f336b);
        this.f337c.m406a(c0416o);
    }

    /* JADX INFO: renamed from: b */
    public final C0423v m305b() {
        return new C0423v(this.f337c, 29);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.f337c.compareTo(((C0396a) obj).f337c);
    }

    public final String toString() {
        return this.f335a == null ? ((int) this.f336b) + " " + m302c() : ((int) this.f336b) + " " + ((String) this.f335a.m365g().get(m302c()));
    }
}
