package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.f */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1203f extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3403a;

    public HandlerC1203f(ApkComposeActivity apkComposeActivity) {
        this.f3403a = new WeakReference(apkComposeActivity);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ApkComposeActivity apkComposeActivity = (ApkComposeActivity) this.f3403a.get();
        if (apkComposeActivity != null) {
            switch (message.what) {
                case 1:
                    apkComposeActivity.m2337b();
                    return;
                case 2:
                    apkComposeActivity.m2336a(true);
                    return;
                case 3:
                    apkComposeActivity.m2336a(false);
                    return;
                case 4:
                    Toast.makeText(apkComposeActivity, (CharSequence) null, 1).show();
                    return;
                case 5:
                    if (!ApkComposeActivity.m2327e(apkComposeActivity).m793a() && System.currentTimeMillis() - apkComposeActivity.f2518u < 10000) {
                        sendEmptyMessageDelayed(5, 300L);
                        return;
                    }
                    break;
                case 6:
                    break;
                default:
                    return;
            }
            apkComposeActivity.f2513p.setVisibility(0);
        }
    }
}
