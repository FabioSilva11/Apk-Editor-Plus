package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.iw */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1310iw extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3707a;

    /* JADX INFO: renamed from: b */
    private List f3708b;

    public HandlerC1310iw(UserAppActivity userAppActivity) {
        this.f3707a = new WeakReference(userAppActivity);
    }

    /* JADX INFO: renamed from: a */
    public final void m3187a(List list) {
        this.f3708b = list;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        UserAppActivity userAppActivity = (UserAppActivity) this.f3707a.get();
        if (userAppActivity == null) {
        }
        switch (message.what) {
            case 0:
                userAppActivity.f2811e.clear();
                userAppActivity.f2811e.addAll(this.f3708b);
                userAppActivity.m2648a(this.f3708b);
                break;
        }
    }
}
