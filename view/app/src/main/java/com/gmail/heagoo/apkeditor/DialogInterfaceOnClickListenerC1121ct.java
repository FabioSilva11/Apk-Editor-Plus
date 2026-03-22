package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ct */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1121ct implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3183a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ DialogC1115cn f3184b;

    DialogInterfaceOnClickListenerC1121ct(DialogC1115cn dialogC1115cn, String str) {
        this.f3184b = dialogC1115cn;
        this.f3183a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3184b.f3175i.mo2502a(this.f3183a, this.f3184b.f3168b, this.f3184b.f3174h.isChecked());
        this.f3184b.m2854b(this.f3183a);
        this.f3184b.dismiss();
    }
}
