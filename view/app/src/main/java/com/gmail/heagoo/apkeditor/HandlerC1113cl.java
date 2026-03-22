package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cl */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1113cl extends Handler {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ FileListActivity f3162a;

    HandlerC1113cl(FileListActivity fileListActivity) {
        this.f3162a = fileListActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f3162a.f2701d.m3483a().notifyDataSetChanged();
                break;
        }
    }
}
