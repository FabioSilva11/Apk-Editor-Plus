package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ba */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1074ba implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3061a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ViewOnClickListenerC1061az f3062b;

    DialogInterfaceOnClickListenerC1074ba(ViewOnClickListenerC1061az viewOnClickListenerC1061az, String str) {
        this.f3062b = viewOnClickListenerC1061az;
        this.f3061a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3062b.f3030e.m2768a(this.f3062b.f3027b, this.f3062b.f3026a, this.f3062b.f3028c, this.f3061a, this.f3062b.f3029d);
    }
}
