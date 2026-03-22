package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ii */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1296ii implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f3679a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ TextEditNormalActivity f3680b;

    DialogInterfaceOnClickListenerC1296ii(TextEditNormalActivity textEditNormalActivity, int i) {
        this.f3680b = textEditNormalActivity;
        this.f3679a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3680b.m2596a(new C1297ij(this));
    }
}
