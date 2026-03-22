package com.gmail.heagoo.sqliteutil;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.b */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1548b implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C1544a f4652a;

    RunnableC1548b(C1544a c1544a) {
        this.f4652a = c1544a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4652a.f4631l.clearAnimation();
        this.f4652a.f4631l.layout(C1544a.m3750b(this.f4652a).left, C1544a.m3750b(this.f4652a).top, C1544a.m3750b(this.f4652a).right, C1544a.m3750b(this.f4652a).bottom);
        C1544a.m3750b(this.f4652a).setEmpty();
    }
}
