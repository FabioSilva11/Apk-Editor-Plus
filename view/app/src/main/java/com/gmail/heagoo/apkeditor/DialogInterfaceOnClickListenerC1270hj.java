package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hj */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1270hj implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ int f3622a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ TextEditBigActivity f3623b;

    DialogInterfaceOnClickListenerC1270hj(TextEditBigActivity textEditBigActivity, int i) {
        this.f3623b = textEditBigActivity;
        this.f3622a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3623b.f3578e += this.f3622a;
        new AsyncTaskC1278hr(this.f3623b, (byte) 0).execute(new Void[0]);
    }
}
