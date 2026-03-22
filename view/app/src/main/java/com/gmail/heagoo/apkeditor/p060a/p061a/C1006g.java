package com.gmail.heagoo.apkeditor.p060a.p061a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.g */
/* JADX INFO: loaded from: classes.dex */
final class C1006g implements InterfaceC1003d {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C1004e f2849a;

    C1006g(C1004e c1004e) {
        this.f2849a = c1004e;
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.p061a.InterfaceC1003d
    /* JADX INFO: renamed from: a */
    public final void mo2666a(C1023x c1023x) {
        if (c1023x.m2750b() == 3) {
            int[] iArrM2717b = this.f2849a.f2842g.m2717b();
            int iM2751c = c1023x.m2751c();
            if (iM2751c < 0 || iM2751c >= iArrM2717b.length) {
                return;
            }
            int i = iArrM2717b[iM2751c] + 1;
            C1004e.m2673a(c1023x.m2749a(), c1023x.f2930a + 8, i);
            C1004e.m2673a(c1023x.m2749a(), c1023x.f2930a + 16, i);
        }
    }
}
