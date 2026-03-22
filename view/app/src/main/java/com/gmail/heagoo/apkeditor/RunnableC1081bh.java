package com.gmail.heagoo.apkeditor;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bh */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1081bh implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3083a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkSearchActivity f3084b;

    RunnableC1081bh(ApkSearchActivity apkSearchActivity, String str) {
        this.f3084b = apkSearchActivity;
        this.f3083a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3084b.f2650d.add(this.f3083a);
        this.f3084b.m2472a(this.f3084b.f2650d.size());
        C1076bc c1076bc = this.f3084b.f2653g;
        c1076bc.f3065a.add(this.f3083a);
        c1076bc.notifyDataSetChanged();
    }
}
