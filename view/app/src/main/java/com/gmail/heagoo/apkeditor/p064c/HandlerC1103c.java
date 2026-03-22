package com.gmail.heagoo.apkeditor.p064c;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.c.c */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1103c extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3134a;

    HandlerC1103c(DialogC1101a dialogC1101a) {
        this.f3134a = new WeakReference(dialogC1101a);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (this.f3134a.get() != null) {
                    ((DialogC1101a) this.f3134a.get()).m2827a(-1);
                }
                break;
        }
    }
}
