package com.gmail.heagoo.apkeditor;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fb */
/* JADX INFO: loaded from: classes.dex */
final class C1209fb extends Thread {

    /* JADX INFO: renamed from: a */
    private WeakReference f3412a;

    public C1209fb(DialogC1201ey dialogC1201ey) {
        this.f3412a = new WeakReference(dialogC1201ey);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String message = null;
        DialogC1201ey dialogC1201ey = (DialogC1201ey) this.f3412a.get();
        if (dialogC1201ey != null) {
            try {
                dialogC1201ey.f3399b.mo2530a();
            } catch (Exception e) {
                message = e.getMessage();
            }
            dialogC1201ey.m3000a(message);
        }
    }
}
