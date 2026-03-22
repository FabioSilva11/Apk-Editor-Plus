package com.gmail.heagoo.apkeditor;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ez */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1202ez implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3401a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ DialogC1201ey f3402b;

    RunnableC1202ez(DialogC1201ey dialogC1201ey, String str) {
        this.f3402b = dialogC1201ey;
        this.f3401a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3402b.f3399b.mo2531b();
        if (this.f3401a != null) {
            this.f3402b.m3001b("Failed: " + this.f3401a);
        } else {
            this.f3402b.m2999a(this.f3402b.f3400c);
        }
        if (this.f3402b.isShowing()) {
            this.f3402b.m2996a();
        }
    }
}
