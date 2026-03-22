package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hk */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1271hk implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f3624a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ TextEditBigActivity f3625b;

    DialogInterfaceOnClickListenerC1271hk(TextEditBigActivity textEditBigActivity, int i) {
        this.f3625b = textEditBigActivity;
        this.f3624a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3625b.m2572a(new C1272hl(this));
    }
}
