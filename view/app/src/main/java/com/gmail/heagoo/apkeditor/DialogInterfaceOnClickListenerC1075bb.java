package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bb */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1075bb implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3063a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ViewOnClickListenerC1057av f3064b;

    DialogInterfaceOnClickListenerC1075bb(ViewOnClickListenerC1057av viewOnClickListenerC1057av, String str) {
        this.f3064b = viewOnClickListenerC1057av;
        this.f3063a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ApkInfoExActivity apkInfoExActivity = this.f3064b.f3019a;
        C0985a.m2257c(apkInfoExActivity, this.f3063a);
        Toast.makeText(apkInfoExActivity, String.format(apkInfoExActivity.getString(R.string.copied_to_clipboard), this.f3063a), 0).show();
    }
}
