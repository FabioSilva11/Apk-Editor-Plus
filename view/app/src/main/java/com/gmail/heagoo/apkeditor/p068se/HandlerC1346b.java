package com.gmail.heagoo.apkeditor.p068se;

import android.os.Handler;
import android.os.Message;
import android.support.v7.appcompat.C0299R;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.b */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1346b extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3873a;

    /* JADX INFO: renamed from: b */
    private String f3874b;

    HandlerC1346b(ApkCreateActivity apkCreateActivity) {
        this.f3873a = new WeakReference(apkCreateActivity);
    }

    /* JADX INFO: renamed from: a */
    final void m3263a(String str) {
        this.f3874b = str;
        sendEmptyMessage(100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        ApkCreateActivity apkCreateActivity = (ApkCreateActivity) this.f3873a.get();
        switch (message.what) {
            case 0:
                if (apkCreateActivity != null) {
                    apkCreateActivity.m3246a(true);
                }
                break;
            case 1:
                if (apkCreateActivity != null) {
                    apkCreateActivity.m3246a(false);
                }
                break;
            case C0299R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /* 100 */:
                if (apkCreateActivity != null) {
                    apkCreateActivity.f3830p.setText(this.f3874b);
                }
                break;
        }
    }
}
