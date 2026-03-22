package com.gmail.heagoo.pngeditor;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.g */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1542g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditText f4586a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ EditText f4587b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ PngEditActivity f4588c;

    DialogInterfaceOnClickListenerC1542g(PngEditActivity pngEditActivity, EditText editText, EditText editText2) {
        this.f4588c = pngEditActivity;
        this.f4586a = editText;
        this.f4587b = editText2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = false;
        String string = this.f4586a.getText().toString();
        String string2 = this.f4587b.getText().toString();
        try {
            int iIntValue = Integer.valueOf(string).intValue();
            int iIntValue2 = Integer.valueOf(string2).intValue();
            if (iIntValue > 0 && iIntValue2 > 0 && iIntValue < 32768 && iIntValue2 < 32768) {
                z = true;
            }
        } catch (Exception e) {
        }
        if (!z) {
            Toast.makeText(this.f4588c, R.string.invalid_input, 1).show();
        } else {
            this.f4588c.f4564p.setText(string);
            this.f4588c.f4565q.setText(string2);
        }
    }
}
