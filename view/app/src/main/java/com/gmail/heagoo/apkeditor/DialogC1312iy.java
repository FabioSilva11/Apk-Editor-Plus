package com.gmail.heagoo.apkeditor;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.iy */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1312iy extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private InterfaceC1313iz f3712a;

    /* JADX INFO: renamed from: b */
    private int f3713b;

    /* JADX INFO: renamed from: c */
    private String f3714c;

    /* JADX INFO: renamed from: d */
    private LinkedHashMap f3715d;

    /* JADX INFO: renamed from: e */
    private boolean f3716e;

    /* JADX INFO: renamed from: f */
    private List f3717f;

    /* JADX INFO: renamed from: g */
    private String f3718g;

    /* JADX INFO: renamed from: h */
    private Context f3719h;

    /* JADX INFO: renamed from: i */
    private Dialog f3720i;

    /* JADX INFO: renamed from: j */
    private View f3721j;

    /* JADX INFO: renamed from: k */
    private LinearLayout f3722k;

    /* JADX INFO: renamed from: l */
    private int f3723l;

    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DialogC1312iy(android.content.Context r10, com.gmail.heagoo.apkeditor.InterfaceC1313iz r11, int r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.DialogC1312iy.<init>(android.content.Context, com.gmail.heagoo.apkeditor.iz, int, java.lang.String):void");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = 0;
        int id = view.getId();
        if (id == R.id.btn_dlgclose) {
            dismiss();
            return;
        }
        if (id == R.id.btn_dlgsave) {
            if (this.f3712a != null) {
                InterfaceC1313iz interfaceC1313iz = this.f3712a;
                int i2 = this.f3713b;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("<" + this.f3714c);
                Iterator it = this.f3715d.entrySet().iterator();
                while (it.hasNext()) {
                    stringBuffer.append(" " + ((String) ((Map.Entry) it.next()).getKey()) + "=\"" + ((EditText) this.f3717f.get(i)).getText().toString() + "\"");
                    i++;
                }
                if (this.f3716e) {
                    stringBuffer.append(" />");
                } else {
                    stringBuffer.append(">");
                }
                stringBuffer.append(this.f3718g);
                interfaceC1313iz.mo2877a(i2, stringBuffer.toString());
            }
            dismiss();
            return;
        }
        if (id == R.id.hidden_image) {
            this.f3720i = new Dialog(this.f3719h);
            View viewInflate = LayoutInflater.from(this.f3719h).inflate(R.layout.dlg_addkeyvalue, (ViewGroup) null);
            ((Button) viewInflate.findViewById(R.id.btn_addkeyvalue_ok)).setOnClickListener(this);
            ((Button) viewInflate.findViewById(R.id.btn_addkeyvalue_cancel)).setOnClickListener(this);
            this.f3721j = viewInflate;
            this.f3720i.requestWindowFeature(1);
            this.f3720i.setContentView(viewInflate);
            this.f3720i.show();
            return;
        }
        if (id != R.id.btn_addkeyvalue_ok) {
            if (id == R.id.btn_addkeyvalue_cancel) {
                this.f3720i.dismiss();
                return;
            }
            return;
        }
        EditText editText = (EditText) this.f3721j.findViewById(R.id.key);
        EditText editText2 = (EditText) this.f3721j.findViewById(R.id.value);
        String strTrim = editText.getText().toString().trim();
        String strTrim2 = editText2.getText().toString().trim();
        if (strTrim.equals("")) {
            Toast.makeText(this.f3719h, R.string.empty_key_tip, 0).show();
            return;
        }
        this.f3715d.put(strTrim, strTrim2);
        View viewInflate2 = LayoutInflater.from(this.f3719h).inflate(this.f3723l, (ViewGroup) null);
        ((TextView) viewInflate2.findViewById(R.id.string_name)).setText(strTrim);
        EditText editText3 = (EditText) viewInflate2.findViewById(R.id.string_value);
        this.f3717f.add(editText3);
        editText3.setText(strTrim2);
        this.f3722k.addView(viewInflate2, this.f3715d.size() - 1);
        this.f3720i.dismiss();
    }
}
