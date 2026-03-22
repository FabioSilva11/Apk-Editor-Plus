package com.gmail.heagoo.pngeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.c */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1538c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PngEditActivity f4582a;

    DialogInterfaceOnClickListenerC1538c(PngEditActivity pngEditActivity) {
        this.f4582a = pngEditActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f4582a.m3703b();
        this.f4582a.finish();
    }
}
