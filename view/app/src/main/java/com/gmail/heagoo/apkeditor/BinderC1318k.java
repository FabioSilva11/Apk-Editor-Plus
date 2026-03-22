package com.gmail.heagoo.apkeditor;

import android.app.NotificationManager;
import android.os.Binder;
import android.util.Log;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.k */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1318k extends Binder {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ApkComposeService f3731a;

    public BinderC1318k(ApkComposeService apkComposeService) {
        this.f3731a = apkComposeService;
    }

    /* JADX INFO: renamed from: a */
    public final void m3191a() {
        if (this.f3731a.f2539p != null) {
            this.f3731a.f2539p.cancel(8001);
            if (this.f3731a.f2541r) {
                this.f3731a.stopForeground(true);
                this.f3731a.f2541r = false;
            }
            ApkComposeService.m2340a(this.f3731a, (NotificationManager) null);
            Log.e("DEBUG", "notification hided.");
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3192b() {
        return this.f3731a.f2535l != null && this.f3731a.f2535l.isAlive();
    }
}
