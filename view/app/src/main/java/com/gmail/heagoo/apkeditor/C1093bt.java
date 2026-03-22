package com.gmail.heagoo.apkeditor;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bt */
/* JADX INFO: loaded from: classes.dex */
final class C1093bt extends Thread {

    /* JADX INFO: renamed from: a */
    String f3106a;

    /* JADX INFO: renamed from: b */
    private WeakReference f3107b;

    public C1093bt(AxmlEditActivity axmlEditActivity) {
        this.f3107b = new WeakReference(axmlEditActivity);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        AxmlEditActivity axmlEditActivity = (AxmlEditActivity) this.f3107b.get();
        if (axmlEditActivity != null) {
            try {
                AxmlEditActivity.m2480a(axmlEditActivity);
                axmlEditActivity.f2657f.sendEmptyMessage(0);
            } catch (Exception e) {
                e.printStackTrace();
                this.f3106a = e.getMessage();
                axmlEditActivity.f2657f.sendEmptyMessage(1);
            }
        }
    }
}
