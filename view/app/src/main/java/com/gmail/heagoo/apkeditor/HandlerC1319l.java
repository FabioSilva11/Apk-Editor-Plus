package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.l */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1319l extends Handler {

    /* JADX INFO: renamed from: a */
    private String f3732a;

    /* JADX INFO: renamed from: b */
    private String f3733b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ ApkComposeService f3734c;

    private HandlerC1319l(ApkComposeService apkComposeService) {
        this.f3734c = apkComposeService;
    }

    /* synthetic */ HandlerC1319l(ApkComposeService apkComposeService, byte b2) {
        this(apkComposeService);
    }

    /* JADX INFO: renamed from: a */
    public final void m3193a(String str, String str2) {
        this.f3732a = str;
        this.f3733b = str2;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (this.f3732a != null) {
                    this.f3734c.f2540q.setContentTitle(this.f3732a);
                }
                if (this.f3733b != null) {
                    this.f3734c.f2540q.setContentText(this.f3733b);
                }
                if (this.f3734c.f2541r) {
                    this.f3734c.f2539p.notify(8001, this.f3734c.f2540q.build());
                } else {
                    this.f3734c.startForeground(8001, this.f3734c.f2540q.build());
                    this.f3734c.f2541r = true;
                }
                this.f3734c.f2545v = System.currentTimeMillis();
                break;
        }
    }
}
