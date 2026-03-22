package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gx */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1257gx extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private WeakReference f3567a;

    /* JADX INFO: renamed from: b */
    private C1255gv f3568b;

    /* JADX INFO: renamed from: c */
    private int f3569c;

    /* JADX INFO: renamed from: d */
    private View f3570d;

    /* JADX INFO: renamed from: e */
    private TextView f3571e;

    /* JADX INFO: renamed from: f */
    private EditText f3572f;

    @SuppressLint({"InflateParams"})
    public DialogC1257gx(Context context, C1255gv c1255gv, int i) {
        super(context);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(4);
        this.f3567a = new WeakReference(context);
        this.f3568b = c1255gv;
        this.f3569c = i;
        this.f3570d = LayoutInflater.from(context).inflate(R.layout.dlg_stringvalue, (ViewGroup) null);
        setContentView(this.f3570d);
        TextView textView = (TextView) this.f3570d.findViewById(R.id.key);
        textView.setOnClickListener(this);
        this.f3571e = textView;
        this.f3572f = (EditText) this.f3570d.findViewById(R.id.value);
        ((Button) this.f3570d.findViewById(R.id.btn_editstring_ok)).setOnClickListener(this);
        ((Button) this.f3570d.findViewById(R.id.btn_editstring_cancel)).setOnClickListener(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m3119a(String str, String str2) {
        this.f3571e.setText(str);
        this.f3572f.setText(str2);
        this.f3572f.setSelection(str2 != null ? str2.length() : 0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_editstring_ok) {
            this.f3568b.m3116a(this.f3569c, this.f3572f.getText().toString());
            dismiss();
        } else if (id == R.id.btn_editstring_cancel) {
            cancel();
        } else if (id == R.id.key) {
            Context context = (Context) this.f3567a.get();
            String string = this.f3571e.getText().toString();
            C0985a.m2257c(context, string);
            Toast.makeText(context, String.format(context.getString(R.string.copied_to_clipboard), string), 0).show();
        }
    }
}
