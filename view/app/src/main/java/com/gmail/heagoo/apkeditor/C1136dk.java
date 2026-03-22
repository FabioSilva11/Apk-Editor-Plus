package com.gmail.heagoo.apkeditor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dk */
/* JADX INFO: loaded from: classes.dex */
public final class C1136dk {

    /* JADX INFO: renamed from: a */
    private Context f3217a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1139dn f3218b;

    /* JADX INFO: renamed from: c */
    private EditText f3219c;

    /* JADX INFO: renamed from: d */
    private EditText f3220d;

    /* JADX INFO: renamed from: e */
    private AlertDialog f3221e;

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m2867b(C1136dk c1136dk) {
        String string = c1136dk.f3219c.getText().toString();
        String string2 = c1136dk.f3220d.getText().toString();
        if ("".equals(string)) {
            Toast.makeText(c1136dk.f3217a, R.string.empty_input_tip, 1).show();
            c1136dk.f3219c.requestFocus();
            return;
        }
        if ("".equals(string2)) {
            Toast.makeText(c1136dk.f3217a, R.string.empty_input_tip, 1).show();
            c1136dk.f3220d.requestFocus();
            return;
        }
        try {
            int iIntValue = Integer.valueOf(string).intValue();
            int iIntValue2 = Integer.valueOf(string2).intValue();
            if (iIntValue > iIntValue2) {
                Toast.makeText(c1136dk.f3217a, R.string.err_from_greater_than_to, 1).show();
                c1136dk.f3219c.requestFocus();
            } else if (c1136dk.f3218b != null) {
                c1136dk.f3218b.mo2588a(iIntValue, iIntValue2);
                c1136dk.f3221e.dismiss();
            }
        } catch (Exception e) {
            Toast.makeText(c1136dk.f3217a, R.string.unknown_error, 1).show();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2868a(Context context, int i, InterfaceC1139dn interfaceC1139dn) {
        this.f3217a = context;
        this.f3218b = interfaceC1139dn;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.dlg_lines_op, (ViewGroup) null);
        this.f3219c = (EditText) viewInflate.findViewById(R.id.et_from);
        this.f3220d = (EditText) viewInflate.findViewById(R.id.et_to);
        this.f3221e = new AlertDialog.Builder(context).setView(viewInflate).setTitle(i).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).create();
        this.f3221e.setOnShowListener(new DialogInterfaceOnShowListenerC1137dl(this));
        this.f3221e.show();
    }
}
