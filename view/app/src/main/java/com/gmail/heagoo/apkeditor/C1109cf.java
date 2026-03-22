package com.gmail.heagoo.apkeditor;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cf */
/* JADX INFO: loaded from: classes.dex */
final class C1109cf extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1108ce f3155a;

    C1109cf(DialogC1108ce dialogC1108ce) {
        this.f3155a = dialogC1108ce;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        try {
            for (C1110cg c1110cg : this.f3155a.f3144a) {
                if (c1110cg.f3158c) {
                    this.f3155a.m2843a(c1110cg);
                } else {
                    this.f3155a.m2845b(c1110cg);
                }
            }
            this.f3155a.f3149f.sendEmptyMessage(0);
        } catch (Exception e) {
            this.f3155a.f3149f.m2846a(e.getMessage());
            this.f3155a.f3149f.sendEmptyMessage(1);
        }
    }
}
