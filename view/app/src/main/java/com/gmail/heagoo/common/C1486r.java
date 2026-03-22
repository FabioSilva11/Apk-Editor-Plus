package com.gmail.heagoo.common;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.common.r */
/* JADX INFO: loaded from: classes.dex */
final class C1486r extends Thread {

    /* JADX INFO: renamed from: a */
    private WeakReference f4317a;

    public C1486r(DialogC1484p dialogC1484p) {
        this.f4317a = new WeakReference(dialogC1484p);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String message = null;
        DialogC1484p dialogC1484p = (DialogC1484p) this.f4317a.get();
        if (dialogC1484p != null) {
            try {
                dialogC1484p.f4313b.mo2530a();
            } catch (Exception e) {
                message = e.getMessage();
            }
            dialogC1484p.m3523a(message);
        }
    }
}
