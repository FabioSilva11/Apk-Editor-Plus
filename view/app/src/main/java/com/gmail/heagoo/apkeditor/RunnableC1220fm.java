package com.gmail.heagoo.apkeditor;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fm */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1220fm implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnClickListenerC1219fl f3466a;

    RunnableC1220fm(ViewOnClickListenerC1219fl viewOnClickListenerC1219fl) {
        this.f3466a = viewOnClickListenerC1219fl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3466a.f3464d.fullScroll(66);
    }
}
