package com.gmail.heagoo.apkeditor.p068se;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.r */
/* JADX INFO: loaded from: classes.dex */
final class C1362r extends Thread {

    /* JADX INFO: renamed from: a */
    String f3911a;

    /* JADX INFO: renamed from: b */
    private WeakReference f3912b;

    public C1362r(SimpleEditActivity simpleEditActivity) {
        this.f3912b = new WeakReference(simpleEditActivity);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        SimpleEditActivity simpleEditActivity = (SimpleEditActivity) this.f3912b.get();
        if (simpleEditActivity != null) {
            try {
                SimpleEditActivity.m3248a(simpleEditActivity);
                simpleEditActivity.f3849h.sendEmptyMessage(0);
            } catch (Exception e) {
                e.printStackTrace();
                this.f3911a = e.getMessage();
                simpleEditActivity.f3849h.sendEmptyMessage(1);
            }
        }
    }
}
