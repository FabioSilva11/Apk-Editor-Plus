package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.de */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1130de implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ KeyListPreference f3195a;

    DialogInterfaceOnClickListenerC1130de(KeyListPreference keyListPreference) {
        this.f3195a = keyListPreference;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (2 == i) {
            new ViewOnClickListenerC1131df(this.f3195a).m2862a(this.f3195a.f2708a);
        } else {
            this.f3195a.setValue(new StringBuilder().append((Object) this.f3195a.getEntryValues()[i]).toString());
        }
        dialogInterface.dismiss();
    }
}
