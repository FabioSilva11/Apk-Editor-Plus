package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hz */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1286hz implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditNormalActivity f3663a;

    DialogInterfaceOnClickListenerC1286hz(TextEditNormalActivity textEditNormalActivity) {
        this.f3663a = textEditNormalActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3663a.finish();
    }
}
