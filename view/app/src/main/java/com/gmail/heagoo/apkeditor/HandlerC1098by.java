package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.by */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1098by extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3121a;

    /* JADX INFO: renamed from: b */
    private String f3122b;

    HandlerC1098by(CommonEditActivity commonEditActivity) {
        this.f3121a = new WeakReference(commonEditActivity);
    }

    /* JADX INFO: renamed from: a */
    final void m2821a(String str) {
        this.f3122b = str;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        CommonEditActivity commonEditActivity = (CommonEditActivity) this.f3121a.get();
        if (commonEditActivity == null) {
        }
        switch (message.what) {
            case 0:
                commonEditActivity.m2501a((String) null);
                break;
            case 1:
                commonEditActivity.m2501a(this.f3122b);
                break;
        }
    }
}
