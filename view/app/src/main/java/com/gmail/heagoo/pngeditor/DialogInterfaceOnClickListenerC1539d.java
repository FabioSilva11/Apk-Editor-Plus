package com.gmail.heagoo.pngeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.d */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1539d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PngEditActivity f4583a;

    DialogInterfaceOnClickListenerC1539d(PngEditActivity pngEditActivity) {
        this.f4583a = pngEditActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f4583a.f4555g.setImageBitmap(this.f4583a.f4566r);
        this.f4583a.m3705c();
    }
}
