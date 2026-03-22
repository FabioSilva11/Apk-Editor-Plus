package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ih */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1295ih implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ int f3677a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ TextEditNormalActivity f3678b;

    DialogInterfaceOnClickListenerC1295ih(TextEditNormalActivity textEditNormalActivity, int i) {
        this.f3678b = textEditNormalActivity;
        this.f3677a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3678b.f3578e += this.f3677a;
        new AsyncTaskC1303ip(this.f3678b, (byte) 0).execute(new Void[0]);
    }
}
