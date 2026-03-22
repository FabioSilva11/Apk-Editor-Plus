package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hu */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1281hu extends Handler {

    /* JADX INFO: renamed from: a */
    View f3652a;

    HandlerC1281hu(C1279hs c1279hs) {
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f3652a.requestFocus();
                break;
        }
    }
}
