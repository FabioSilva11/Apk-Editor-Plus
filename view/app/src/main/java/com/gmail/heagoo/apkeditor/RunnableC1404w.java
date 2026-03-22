package com.gmail.heagoo.apkeditor;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.w */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1404w implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f4080a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkInfoActivity f4081b;

    RunnableC1404w(ApkInfoActivity apkInfoActivity, boolean z) {
        this.f4081b = apkInfoActivity;
        this.f4080a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4080a) {
            this.f4081b.m2421s();
            this.f4081b.m2428a();
        }
        this.f4081b.m2426x();
        this.f4081b.f2575S.setVisibility(0);
        if (ApkInfoActivity.m2411j(this.f4081b)) {
            this.f4081b.f2576U.setVisibility(0);
        } else {
            this.f4081b.f2576U.setVisibility(8);
        }
        this.f4081b.f2577V.setVisibility(0);
    }
}
