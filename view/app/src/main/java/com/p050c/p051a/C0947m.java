package com.p050c.p051a;

/* JADX INFO: renamed from: com.c.a.m */
/* JADX INFO: loaded from: classes.dex */
final class C0947m implements InterfaceC0949o {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0940f f2391a;

    C0947m(ViewOnTouchListenerC0944j viewOnTouchListenerC0944j, C0940f c0940f) {
        this.f2391a = c0940f;
    }

    @Override // com.p050c.p051a.InterfaceC0949o
    /* JADX INFO: renamed from: a */
    public final void mo2093a(float f, float f2) {
        this.f2391a.m2064a(f, f2);
        this.f2391a.postInvalidate();
    }
}
