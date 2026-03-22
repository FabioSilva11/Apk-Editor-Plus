package com.gmail.heagoo.pngeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.b */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1537b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PngEditActivity f4581a;

    DialogInterfaceOnClickListenerC1537b(PngEditActivity pngEditActivity) {
        this.f4581a = pngEditActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f4581a.finish();
    }
}
