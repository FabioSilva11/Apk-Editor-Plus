package com.gmail.heagoo.httpserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class HttpService extends Service {

    /* JADX INFO: renamed from: a */
    private String f4329a;

    /* JADX INFO: renamed from: b */
    private String f4330b;

    /* JADX INFO: renamed from: c */
    private C1493b f4331c = null;

    /* JADX INFO: renamed from: d */
    private BinderC1495d f4332d = new BinderC1495d(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f4332d;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f4331c != null && this.f4331c.m257d()) {
            this.f4331c.m258e();
        }
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onStartCommand(android.content.Intent r4, int r5, int r6) {
        /*
            r3 = this;
            if (r4 != 0) goto L7
            int r0 = super.onStartCommand(r4, r5, r6)
        L6:
            return r0
        L7:
            java.lang.String r0 = "projectDirectory"
            java.lang.String r0 = com.gmail.heagoo.p054a.p059c.C0985a.m2195a(r4, r0)
            r3.f4330b = r0
            java.lang.String r0 = "httpDirectory"
            java.lang.String r0 = com.gmail.heagoo.p054a.p059c.C0985a.m2195a(r4, r0)
            r3.f4329a = r0
            com.gmail.heagoo.httpserver.b r0 = r3.f4331c
            if (r0 != 0) goto L2e
            java.lang.String r0 = r3.f4329a
            if (r0 == 0) goto L40
            java.lang.String r0 = r3.f4330b
            if (r0 == 0) goto L40
            com.gmail.heagoo.httpserver.b r0 = new com.gmail.heagoo.httpserver.b
            java.lang.String r1 = r3.f4329a
            java.lang.String r2 = r3.f4330b
            r0.<init>(r1, r2)
            r3.f4331c = r0
        L2e:
            com.gmail.heagoo.httpserver.b r0 = r3.f4331c     // Catch: java.lang.Exception -> L4a
            boolean r0 = r0.m257d()     // Catch: java.lang.Exception -> L4a
            if (r0 != 0) goto L40
            r0 = 0
            r1 = r0
        L38:
            r0 = 5
            if (r1 >= r0) goto L40
            com.gmail.heagoo.httpserver.b r0 = r3.f4331c     // Catch: java.lang.Exception -> L42
            r0.m3551a(r1)     // Catch: java.lang.Exception -> L42
        L40:
            r0 = 1
            goto L6
        L42:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Exception -> L4a
            int r0 = r1 + 1
            r1 = r0
            goto L38
        L4a:
            r0 = move-exception
            com.gmail.heagoo.httpserver.b r0 = r3.f4331c
            r0.m258e()
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.httpserver.HttpService.onStartCommand(android.content.Intent, int, int):int");
    }
}
