package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ho */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1275ho implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ TextEditBigActivity f3630a;

    DialogInterfaceOnClickListenerC1275ho(TextEditBigActivity textEditBigActivity) {
        this.f3630a = textEditBigActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3630a.m2572a(new C1276hp(this));
    }
}
