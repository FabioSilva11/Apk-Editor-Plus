package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;
import android.widget.CheckBox;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.p062ac.EditTextWithTip;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.aw */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1058aw implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditTextWithTip f3020a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ CheckBox f3021b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ CheckBox f3022c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ ViewOnClickListenerC1057av f3023d;

    DialogInterfaceOnClickListenerC1058aw(ViewOnClickListenerC1057av viewOnClickListenerC1057av, EditTextWithTip editTextWithTip, CheckBox checkBox, CheckBox checkBox2) {
        this.f3023d = viewOnClickListenerC1057av;
        this.f3020a = editTextWithTip;
        this.f3021b = checkBox;
        this.f3022c = checkBox2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        String strTrim = this.f3020a.getText().toString().trim();
        if ("".equals(strTrim)) {
            Toast.makeText(this.f3023d.f3019a, R.string.empty_input_tip, 1).show();
            return;
        }
        this.f3023d.m2769a(strTrim, this.f3021b.isChecked(), this.f3022c.isChecked());
    }
}
