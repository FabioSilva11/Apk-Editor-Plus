package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ia */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1288ia implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ TextEditNormalActivity f3666a;

    DialogInterfaceOnClickListenerC1288ia(TextEditNormalActivity textEditNormalActivity) {
        this.f3666a = textEditNormalActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3666a.m2596a(new C1289ib(this));
    }
}
