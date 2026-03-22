package com.gmail.heagoo.httpserver;

import java.net.UnknownHostException;

/* JADX INFO: renamed from: com.gmail.heagoo.httpserver.c */
/* JADX INFO: loaded from: classes.dex */
final class C1494c extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String[] f4337a;

    C1494c(C1493b c1493b, String[] strArr) {
        this.f4337a = strArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f4337a[0] = C1493b.m3549m().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            notify();
        }
    }
}
