package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bs */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1092bs extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3105a;

    public HandlerC1092bs(AxmlEditActivity axmlEditActivity) {
        this.f3105a = new WeakReference(axmlEditActivity);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        AxmlEditActivity axmlEditActivity = (AxmlEditActivity) this.f3105a.get();
        if (axmlEditActivity == null) {
        }
        switch (message.what) {
            case 0:
                axmlEditActivity.m2487a(true);
                break;
            case 1:
                axmlEditActivity.m2487a(false);
                break;
        }
    }
}
