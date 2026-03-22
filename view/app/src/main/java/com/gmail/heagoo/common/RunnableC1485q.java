package com.gmail.heagoo.common;

/* JADX INFO: renamed from: com.gmail.heagoo.common.q */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1485q implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f4315a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ DialogC1484p f4316b;

    RunnableC1485q(DialogC1484p dialogC1484p, String str) {
        this.f4316b = dialogC1484p;
        this.f4315a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4316b.f4313b.mo2531b();
        if (this.f4315a != null) {
            this.f4316b.m3524b("Failed: " + this.f4315a);
        } else if (this.f4316b.f4314c > 0) {
            this.f4316b.m3522a(this.f4316b.f4314c);
        }
        this.f4316b.dismiss();
    }
}
