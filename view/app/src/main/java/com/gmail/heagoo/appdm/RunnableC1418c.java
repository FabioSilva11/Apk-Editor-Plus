package com.gmail.heagoo.appdm;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.c */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1418c implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1408a f4174a;

    RunnableC1418c(DialogC1408a dialogC1408a) {
        this.f4174a = dialogC1408a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4174a.cancel();
    }
}
