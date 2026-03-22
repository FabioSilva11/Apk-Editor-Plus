package com.gmail.heagoo.p070b;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: com.gmail.heagoo.b.l */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1461l implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditText f4281a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f4282b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1454e f4283c;

    DialogInterfaceOnClickListenerC1461l(C1454e c1454e, EditText editText, String str) {
        this.f4283c = c1454e;
        this.f4281a = editText;
        this.f4282b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean zCreateNewFile;
        String strTrim = this.f4281a.getText().toString().trim();
        if ("".equals(strTrim)) {
            Toast.makeText(this.f4283c.f4266a, R.string.empty_input_tip, 1).show();
            return;
        }
        String string = null;
        try {
            zCreateNewFile = new File(new File(this.f4282b), strTrim).createNewFile();
            try {
                if (zCreateNewFile) {
                    this.f4283c.f4270e.m3471a(this.f4282b);
                } else {
                    string = this.f4283c.f4266a.getString(R.string.failed_create_file);
                }
            } catch (IOException e) {
                e = e;
                string = String.format(this.f4283c.f4266a.getString(R.string.general_error), e.getMessage());
            }
        } catch (IOException e2) {
            e = e2;
            zCreateNewFile = false;
        }
        if (zCreateNewFile) {
            return;
        }
        Toast.makeText(this.f4283c.f4266a, string, 1).show();
    }
}
