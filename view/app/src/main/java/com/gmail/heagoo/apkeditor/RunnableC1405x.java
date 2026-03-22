package com.gmail.heagoo.apkeditor;

import android.widget.Toast;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.x */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1405x implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f4082a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkInfoActivity f4083b;

    RunnableC1405x(ApkInfoActivity apkInfoActivity, String str) {
        this.f4083b = apkInfoActivity;
        this.f4082a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f4083b, this.f4082a, 1).show();
    }
}
