package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dl */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnShowListenerC1137dl implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C1136dk f3222a;

    DialogInterfaceOnShowListenerC1137dl(C1136dk c1136dk) {
        this.f3222a = c1136dk;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        this.f3222a.f3221e.getButton(-1).setOnClickListener(new ViewOnClickListenerC1138dm(this));
    }
}
