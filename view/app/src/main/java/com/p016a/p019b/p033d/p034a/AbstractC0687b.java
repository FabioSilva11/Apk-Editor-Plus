package com.p016a.p019b.p033d.p034a;

/* JADX INFO: renamed from: com.a.b.d.a.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0687b implements InterfaceC0689c {

    /* JADX INFO: renamed from: a */
    private final C0660a f1233a = new C0660a();

    /* JADX INFO: renamed from: b */
    private int f1234b = 0;

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0689c
    /* JADX INFO: renamed from: a */
    public final int mo1286a() {
        return this.f1234b;
    }

    /* JADX INFO: renamed from: a */
    protected final void m1287a(int i) {
        this.f1234b++;
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0689c
    /* JADX INFO: renamed from: a */
    public final void mo1288a(int i, int i2) {
        this.f1233a.m1260a(i, i2);
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0689c
    /* JADX INFO: renamed from: b */
    public final int mo1289b() {
        int iM1259a = this.f1233a.m1259a(this.f1234b);
        return iM1259a >= 0 ? iM1259a : this.f1234b;
    }
}
