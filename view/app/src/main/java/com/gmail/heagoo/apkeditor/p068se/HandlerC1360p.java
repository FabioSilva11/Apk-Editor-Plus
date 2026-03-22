package com.gmail.heagoo.apkeditor.p068se;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.p */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1360p extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3908a;

    public HandlerC1360p(SimpleEditActivity simpleEditActivity) {
        this.f3908a = new WeakReference(simpleEditActivity);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        SimpleEditActivity simpleEditActivity = (SimpleEditActivity) this.f3908a.get();
        if (simpleEditActivity == null) {
        }
        switch (message.what) {
            case 0:
                simpleEditActivity.m3254a(true);
                break;
            case 1:
                simpleEditActivity.m3254a(false);
                break;
        }
    }
}
