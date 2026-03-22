package com.gmail.heagoo.appdm;

import android.app.Activity;
import android.widget.Toast;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.d */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1419d implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Activity f4175a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f4176b;

    RunnableC1419d(DialogC1408a dialogC1408a, Activity activity, String str) {
        this.f4175a = activity;
        this.f4176b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f4175a, this.f4176b, 0).show();
    }
}
