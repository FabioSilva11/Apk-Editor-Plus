package com.gmail.heagoo.appdm;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.ae */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1413ae implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f4161a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C1412ad f4162b;

    RunnableC1413ae(C1412ad c1412ad, String str) {
        this.f4162b = c1412ad;
        this.f4161a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText((Context) this.f4162b.f4154a.get(), this.f4161a, 0).show();
    }
}
