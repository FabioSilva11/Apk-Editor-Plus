package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fw */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1230fw implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3506a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ DialogC1229fv f3507b;

    DialogInterfaceOnClickListenerC1230fw(DialogC1229fv dialogC1229fv, String str) {
        this.f3507b = dialogC1229fv;
        this.f3506a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!"".equals(this.f3506a.trim())) {
            this.f3507b.f3505l.m2764a(this.f3506a);
        }
        this.f3507b.m3095a(this.f3506a);
    }
}
