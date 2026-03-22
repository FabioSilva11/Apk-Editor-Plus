package com.gmail.heagoo.appdm;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.l */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1427l extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f4206a;

    /* JADX INFO: renamed from: b */
    private String f4207b;

    public HandlerC1427l(PrefDetailActivity prefDetailActivity) {
        this.f4206a = new WeakReference(prefDetailActivity);
    }

    /* JADX INFO: renamed from: a */
    public final void m3451a(String str) {
        this.f4207b = str;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                PrefDetailActivity prefDetailActivity = (PrefDetailActivity) this.f4206a.get();
                if (prefDetailActivity != null) {
                    PrefDetailActivity.m3384a(prefDetailActivity);
                }
                break;
            case 1:
                Toast.makeText((Context) this.f4206a.get(), "Error: " + this.f4207b, 1).show();
                break;
        }
    }
}
