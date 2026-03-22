package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.gmail.heagoo.apkeditor.p062ac.C1037a;
import com.gmail.heagoo.apkeditor.p062ac.EditTextWithTip;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ej */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1188ej implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditTextWithTip f3354a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ CheckBox f3355b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1037a f3356c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ int f3357d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ ViewOnClickListenerC1187ei f3358e;

    DialogInterfaceOnClickListenerC1188ej(ViewOnClickListenerC1187ei viewOnClickListenerC1187ei, EditTextWithTip editTextWithTip, CheckBox checkBox, C1037a c1037a, int i) {
        this.f3358e = viewOnClickListenerC1187ei;
        this.f3354a = editTextWithTip;
        this.f3355b = checkBox;
        this.f3356c = c1037a;
        this.f3357d = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        this.f3358e.f3353n = this.f3354a.getText().toString();
        if (this.f3355b.isChecked()) {
            ViewOnClickListenerC1187ei.m2971a(this.f3358e, true);
        }
        if (!"".equals(this.f3358e.f3353n.trim())) {
            this.f3356c.m2764a(this.f3358e.f3353n);
        }
        this.f3358e.m2972d(this.f3357d);
    }
}
