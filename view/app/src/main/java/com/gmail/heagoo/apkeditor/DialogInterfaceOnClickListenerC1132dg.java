package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dg */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1132dg implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnClickListenerC1131df f3201a;

    DialogInterfaceOnClickListenerC1132dg(ViewOnClickListenerC1131df viewOnClickListenerC1131df) {
        this.f3201a = viewOnClickListenerC1131df;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3201a.m2861a();
    }
}
