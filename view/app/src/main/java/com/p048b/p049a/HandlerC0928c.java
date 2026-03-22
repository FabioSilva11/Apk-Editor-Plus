package com.p048b.p049a;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: com.b.a.c */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC0928c extends Handler {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0926a f2294a;

    HandlerC0928c(C0926a c0926a) {
        this.f2294a = c0926a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                int iM2043a = this.f2294a.m2043a();
                if (iM2043a != this.f2294a.f2291i) {
                    C0926a.m2040a(this.f2294a, iM2043a);
                }
                this.f2294a.f2284b.setBackgroundColor(iM2043a);
                if (C0926a.m2042c(this.f2294a) != null) {
                    C0926a.m2042c(this.f2294a).mo2045a(iM2043a);
                }
                break;
        }
    }
}
