package com.gmail.heagoo.apkeditor;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.is */
/* JADX INFO: loaded from: classes.dex */
final class C1306is extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ UserAppActivity f3698a;

    C1306is(UserAppActivity userAppActivity) {
        this.f3698a = userAppActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList arrayList = new ArrayList();
        this.f3698a.m2649b(arrayList);
        this.f3698a.f2810d.m3187a(arrayList);
        this.f3698a.f2810d.sendEmptyMessage(0);
    }
}
