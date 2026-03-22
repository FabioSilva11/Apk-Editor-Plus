package com.p050c.p051a;

/* JADX INFO: renamed from: com.c.a.l */
/* JADX INFO: loaded from: classes.dex */
final class C0946l implements InterfaceC0952r {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnTouchListenerC0944j f2390a;

    C0946l(ViewOnTouchListenerC0944j viewOnTouchListenerC0944j) {
        this.f2390a = viewOnTouchListenerC0944j;
    }

    @Override // com.p050c.p051a.InterfaceC0952r
    /* JADX INFO: renamed from: a */
    public final void mo2091a() {
        ViewOnTouchListenerC0944j.m2081a(this.f2390a, false);
        this.f2390a.m2086a();
    }

    @Override // com.p050c.p051a.InterfaceC0952r
    /* JADX INFO: renamed from: a */
    public final void mo2092a(float f, float f2, float f3) {
        if (f > this.f2390a.f2379q || f < this.f2390a.f2380r) {
            return;
        }
        this.f2390a.m2088a(f, f2, f3);
    }
}
