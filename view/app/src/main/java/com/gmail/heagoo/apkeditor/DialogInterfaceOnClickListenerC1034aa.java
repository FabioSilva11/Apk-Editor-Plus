package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.aa */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1034aa implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ApkInfoActivity f2983a;

    DialogInterfaceOnClickListenerC1034aa(ApkInfoActivity apkInfoActivity) {
        this.f2983a = apkInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2983a.f2578W != null && this.f2983a.f2578W.isAlive()) {
            this.f2983a.f2578W.m2813b();
            ApkInfoActivity.m2375a(this.f2983a, (C1080bg) null);
        }
        this.f2983a.finish();
    }
}
