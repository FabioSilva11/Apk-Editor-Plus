package com.gmail.heagoo.apkeditor.p064c;

import com.gmail.heagoo.apkeditor.TextEditNormalActivity;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.c.b */
/* JADX INFO: loaded from: classes.dex */
final class C1102b extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3132a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ DialogC1101a f3133b;

    C1102b(DialogC1101a dialogC1101a, String str) {
        this.f3133b = dialogC1101a;
        this.f3132a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (TextEditNormalActivity.m3131e(this.f3132a) ? this.f3133b.m2830a(this.f3132a) : TextEditNormalActivity.m3126c(this.f3132a) ? this.f3133b.m2832b(this.f3132a) : false) {
            this.f3133b.f3130g.sendEmptyMessage(0);
        }
    }
}
