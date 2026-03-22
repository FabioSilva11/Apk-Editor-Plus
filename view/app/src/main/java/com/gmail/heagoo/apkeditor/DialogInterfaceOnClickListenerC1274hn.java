package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hn */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1274hn implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditBigActivity f3629a;

    DialogInterfaceOnClickListenerC1274hn(TextEditBigActivity textEditBigActivity) {
        this.f3629a = textEditBigActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3629a.finish();
    }
}
