package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fd */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1211fd implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C1210fc f3430a;

    DialogInterfaceOnClickListenerC1211fd(C1210fc c1210fc) {
        this.f3430a = c1210fc;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ((ApkInfoActivity) this.f3430a.f3413a).m2446b(this.f3430a.f3416d.isChecked());
    }
}
