package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ao */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1051ao implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ApkInfoActivity f3008a;

    DialogInterfaceOnClickListenerC1051ao(ApkInfoActivity apkInfoActivity) {
        this.f3008a = apkInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ApkInfoActivity apkInfoActivity = this.f3008a;
        new DialogC1201ey(apkInfoActivity, new C1052ap(apkInfoActivity), -1).show();
    }
}
