package com.gmail.heagoo.apkeditor;

import android.os.Handler;
import android.os.Message;
import android.widget.EditText;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hx */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1284hx extends Handler {

    /* JADX INFO: renamed from: a */
    private int f3658a;

    /* JADX INFO: renamed from: b */
    private int f3659b;

    /* JADX INFO: renamed from: c */
    private int f3660c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ C1283hw f3661d;

    HandlerC1284hx(C1283hw c1283hw) {
        this.f3661d = c1283hw;
    }

    /* JADX INFO: renamed from: a */
    public final void m3179a(int i, int i2, int i3) {
        this.f3658a = i;
        this.f3659b = i2;
        this.f3660c = i3;
        sendEmptyMessageDelayed(1000, 100L);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                EditText editTextM3172d = this.f3661d.m3172d(this.f3658a);
                if (editTextM3172d != null) {
                    editTextM3172d.requestFocus();
                    editTextM3172d.setSelection(this.f3659b, this.f3660c);
                }
                break;
        }
    }
}
