package com.gmail.heagoo.apkeditor;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cq */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1118cq implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditText f3179a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f3180b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ DialogC1115cn f3181c;

    DialogInterfaceOnClickListenerC1118cq(DialogC1115cn dialogC1115cn, EditText editText, String str) {
        this.f3181c = dialogC1115cn;
        this.f3179a = editText;
        this.f3180b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        String strTrim = this.f3179a.getText().toString().trim();
        if ("".equals(strTrim)) {
            Toast.makeText(this.f3181c.f3176j, R.string.empty_input_tip, 1).show();
        } else {
            this.f3181c.f3167a.m3047b(this.f3180b, strTrim);
        }
    }
}
