package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;
import java.util.Locale;
import p000a.p011d.C0077i;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dh */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1133dh extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private WeakReference f3202a;

    /* JADX INFO: renamed from: b */
    private String[] f3203b;

    /* JADX INFO: renamed from: c */
    private String[] f3204c;

    /* JADX INFO: renamed from: d */
    private View f3205d;

    /* JADX INFO: renamed from: e */
    private EditText f3206e;

    /* JADX INFO: renamed from: f */
    private boolean f3207f;

    @SuppressLint({"InflateParams"})
    public DialogC1133dh(ApkInfoActivity apkInfoActivity, String[] strArr, String[] strArr2) {
        super(apkInfoActivity);
        requestWindowFeature(1);
        this.f3204c = strArr;
        this.f3203b = strArr2;
        this.f3207f = this.f3204c != null;
        this.f3202a = new WeakReference(apkInfoActivity);
        this.f3205d = apkInfoActivity.getLayoutInflater().inflate(R.layout.dlg_selectlanguage, (ViewGroup) null, false);
        setContentView(this.f3205d);
        this.f3206e = (EditText) this.f3205d.findViewById(R.id.language_code);
        if (this.f3207f) {
            this.f3206e.setEnabled(false);
        }
        int iM199a = C0077i.m199a();
        if (this.f3203b == null || this.f3204c == null) {
            this.f3203b = new String[iM199a];
            this.f3204c = new String[iM199a];
            C0077i.m201a(this.f3203b, this.f3204c);
        }
        Spinner spinner = (Spinner) findViewById(R.id.language_spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this.f3202a.get(), android.R.layout.simple_spinner_item, this.f3204c);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        int iM2863a = m2863a("-" + Locale.getDefault().getLanguage());
        if (iM2863a != -1) {
            spinner.setSelection(iM2863a);
        }
        spinner.setOnItemSelectedListener(new C1134di(this));
        ((Button) this.f3205d.findViewById(R.id.btn_addlang_ok)).setOnClickListener(this);
        ((Button) this.f3205d.findViewById(R.id.btn_addlang_cancel)).setOnClickListener(this);
    }

    /* JADX INFO: renamed from: a */
    private int m2863a(String str) {
        for (int i = 0; i < this.f3203b.length; i++) {
            if (this.f3203b[i].startsWith(str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    protected final void m2864a(int i) {
        this.f3206e.setText(this.f3203b[i]);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        int id = view.getId();
        if (id != R.id.btn_addlang_ok) {
            if (id == R.id.btn_addlang_cancel) {
                dismiss();
                return;
            }
            return;
        }
        String string = this.f3206e.getText().toString();
        if (this.f3207f) {
            ((ApkInfoActivity) this.f3202a.get()).m2455f(string);
            dismiss();
            return;
        }
        ApkInfoActivity apkInfoActivity = (ApkInfoActivity) this.f3202a.get();
        String strM2456g = apkInfoActivity.m2456g(string);
        if (strM2456g == null) {
            z = true;
        } else {
            Toast.makeText(apkInfoActivity, strM2456g, 0).show();
            z = false;
        }
        if (z) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        ((TextView) this.f3205d.findViewById(R.id.tv_title)).setText(i);
    }
}
