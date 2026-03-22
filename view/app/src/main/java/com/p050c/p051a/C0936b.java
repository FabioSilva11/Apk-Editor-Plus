package com.p050c.p051a;

/* JADX INFO: renamed from: com.c.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0936b extends Thread {

    /* JADX INFO: renamed from: a */
    private C0940f f2308a;

    /* JADX INFO: renamed from: b */
    private InterfaceC0935a f2309b;

    /* JADX INFO: renamed from: c */
    private boolean f2310c;

    /* JADX INFO: renamed from: d */
    private boolean f2311d;

    /* JADX INFO: renamed from: e */
    private long f2312e;

    public C0936b(C0940f c0940f, String str) {
        super(str);
        this.f2310c = false;
        this.f2311d = false;
        this.f2312e = -1L;
        this.f2308a = c0940f;
    }

    /* JADX INFO: renamed from: c */
    private synchronized void m2049c() {
        this.f2312e = System.currentTimeMillis();
        this.f2311d = true;
        notifyAll();
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m2050a() {
        this.f2310c = false;
        this.f2311d = false;
        notifyAll();
    }

    /* JADX INFO: renamed from: a */
    public final void m2051a(InterfaceC0935a interfaceC0935a) {
        if (this.f2311d) {
            this.f2311d = false;
        }
        this.f2309b = interfaceC0935a;
        m2049c();
    }

    /* JADX INFO: renamed from: b */
    public final void m2052b() {
        this.f2311d = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        this.f2310c = true;
        while (this.f2310c) {
            while (this.f2311d && this.f2309b != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f2311d = this.f2309b.mo2048a(this.f2308a, jCurrentTimeMillis - this.f2312e);
                this.f2308a.postInvalidate();
                this.f2312e = jCurrentTimeMillis;
                while (this.f2311d) {
                    try {
                    } catch (InterruptedException e) {
                        this.f2311d = false;
                    }
                    if (this.f2308a.m2067a(32L)) {
                        break;
                    }
                }
            }
            synchronized (this) {
                if (this.f2310c) {
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                    }
                }
            }
        }
    }
}
