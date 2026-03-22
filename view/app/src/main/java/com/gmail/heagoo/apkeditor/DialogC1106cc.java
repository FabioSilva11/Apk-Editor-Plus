package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cc */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1106cc extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    private static Boolean f3138e;

    /* JADX INFO: renamed from: a */
    private View f3139a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1107cd f3140b;

    /* JADX INFO: renamed from: c */
    private String f3141c;

    /* JADX INFO: renamed from: d */
    private String f3142d;

    /* JADX INFO: renamed from: f */
    private boolean f3143f;

    public DialogC1106cc(Context context, InterfaceC1107cd interfaceC1107cd, String str) {
        this(context, interfaceC1107cd, str, null);
    }

    @SuppressLint({"InflateParams"})
    public DialogC1106cc(Context context, InterfaceC1107cd interfaceC1107cd, String str, String str2) {
        super(context);
        new WeakReference(context);
        this.f3140b = interfaceC1107cd;
        this.f3141c = str;
        this.f3142d = str2;
        this.f3143f = true;
        requestWindowFeature(1);
        this.f3139a = LayoutInflater.from(context).inflate(R.layout.dlg_editmode, (ViewGroup) null);
        setContentView(this.f3139a);
        TextView textView = (TextView) this.f3139a.findViewById(R.id.simple_edit);
        TextView textView2 = (TextView) this.f3139a.findViewById(R.id.full_edit);
        TextView textView3 = (TextView) this.f3139a.findViewById(R.id.common_edit);
        TextView textView4 = (TextView) this.f3139a.findViewById(R.id.xml_edit);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        if (this.f3142d != null && this.f3143f) {
            TextView textView5 = (TextView) this.f3139a.findViewById(R.id.data_edit);
            textView5.setVisibility(0);
            textView5.setOnClickListener(this);
        }
        if (f3138e == null) {
            f3138e = Boolean.valueOf(MainActivity.isX86() != 0);
        }
        if (f3138e.booleanValue() || Build.VERSION.SDK_INT < 21) {
            this.f3139a.findViewById(R.id.xml_edit_layout).setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        dismiss();
        if (id == R.id.simple_edit) {
            this.f3140b.mo2478a(1, this.f3141c);
            return;
        }
        if (id == R.id.full_edit) {
            this.f3140b.mo2478a(0, this.f3141c);
            return;
        }
        if (id == R.id.common_edit) {
            this.f3140b.mo2478a(2, this.f3141c);
        } else if (id == R.id.xml_edit) {
            this.f3140b.mo2478a(4, this.f3141c);
        } else if (id == R.id.data_edit) {
            this.f3140b.mo2478a(3, this.f3142d);
        }
    }
}
