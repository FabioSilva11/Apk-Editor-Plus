package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ch */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1111ch extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3159a;

    /* JADX INFO: renamed from: b */
    private String f3160b;

    public HandlerC1111ch(DialogC1108ce dialogC1108ce) {
        this.f3159a = new WeakReference(dialogC1108ce);
    }

    /* JADX INFO: renamed from: a */
    public final void m2846a(String str) {
        this.f3160b = str;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        DialogC1108ce dialogC1108ce = (DialogC1108ce) this.f3159a.get();
        if (dialogC1108ce == null) {
        }
        switch (message.what) {
            case 0:
                dialogC1108ce.m2842a();
                break;
            case 1:
                dialogC1108ce.m2844a(this.f3160b);
                break;
        }
    }
}
