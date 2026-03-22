package com.gmail.heagoo.apkeditor;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gmail.heagoo.apkeditor.util.C1380d;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.c */
/* JADX INFO: loaded from: classes.dex */
final class ServiceConnectionC1100c implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ApkComposeActivity f3123a;

    ServiceConnectionC1100c(ApkComposeActivity apkComposeActivity) {
        this.f3123a = apkComposeActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z = false;
        this.f3123a.f2493A = (BinderC1318k) iBinder;
        if (this.f3123a.f2497E != null && "com.gmail.heagoo.action.apkcompose".equals(this.f3123a.f2497E)) {
            if (!this.f3123a.f2493A.m3192b()) {
                this.f3123a.f2493A.m3191a();
            }
            this.f3123a.f2513p.setVisibility(0);
        }
        BinderC1318k binderC1318k = this.f3123a.f2493A;
        ApkComposeActivity apkComposeActivity = this.f3123a;
        binderC1318k.f3731a.f2537n = new WeakReference(apkComposeActivity);
        synchronized (binderC1318k.f3731a.f2536m) {
            if (binderC1318k.f3731a.f2536m.f3724a) {
                if (binderC1318k.f3731a.f2536m.f3725b) {
                    apkComposeActivity.mo2333a();
                } else {
                    apkComposeActivity.mo2335a(binderC1318k.f3731a.f2536m.f3726c);
                }
            } else if (binderC1318k.f3731a.f2536m.f3727d != null) {
                apkComposeActivity.mo2334a(binderC1318k.f3731a.f2536m.f3727d);
            }
        }
        BinderC1318k binderC1318k2 = this.f3123a.f2493A;
        HashMap map = new HashMap();
        map.put("srcApkPath", binderC1318k2.f3731a.f2525b);
        map.put("targetApkPath", binderC1318k2.f3731a.f2534k);
        map.put("decodeRootPath", binderC1318k2.f3731a.f2524a);
        if (binderC1318k2.f3731a.f2529f != null && !binderC1318k2.f3731a.f2529f.isEmpty()) {
            z = true;
        }
        map.put("codeModified", Boolean.valueOf(z));
        map.put("signAPK", Boolean.valueOf(binderC1318k2.f3731a.f2544u));
        this.f3123a.f2498a = (String) map.get("srcApkPath");
        this.f3123a.f2519v = (String) map.get("targetApkPath");
        this.f3123a.f2521x = (String) map.get("decodeRootPath");
        this.f3123a.f2522y = ((Boolean) map.get("codeModified")).booleanValue();
        this.f3123a.f2523z = ((Boolean) map.get("signAPK")).booleanValue();
        this.f3123a.f2494B = new C1380d(this.f3123a.f2521x);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
