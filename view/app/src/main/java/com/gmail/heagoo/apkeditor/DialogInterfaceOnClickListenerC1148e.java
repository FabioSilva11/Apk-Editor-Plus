package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.CheckBox;
import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1148e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ CheckBox f3242a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkComposeActivity f3243b;

    DialogInterfaceOnClickListenerC1148e(ApkComposeActivity apkComposeActivity, CheckBox checkBox) {
        this.f3243b = apkComposeActivity;
        this.f3242a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3243b.f2493A != null && this.f3243b.f2493A.m3192b()) {
            this.f3243b.finish();
        }
        if (this.f3242a.isChecked()) {
            C0985a.m2240b((Context) this.f3243b, "donot_show_compose_tip", true);
        }
    }
}
