package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ca */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1104ca extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private View f3135a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1105cb f3136b;

    /* JADX INFO: renamed from: c */
    private String f3137c;

    public DialogC1104ca(Context context, InterfaceC1105cb interfaceC1105cb, String str) {
        this(context, interfaceC1105cb, str, null);
    }

    @SuppressLint({"InflateParams"})
    private DialogC1104ca(Context context, InterfaceC1105cb interfaceC1105cb, String str, String str2) {
        super(context);
        new WeakReference(context);
        this.f3136b = interfaceC1105cb;
        this.f3137c = str;
        requestWindowFeature(1);
        this.f3135a = LayoutInflater.from(context).inflate(R.layout.dlg_decodemode, (ViewGroup) null);
        setContentView(this.f3135a);
        TextView textView = (TextView) this.f3135a.findViewById(R.id.decode_all_files);
        TextView textView2 = (TextView) this.f3135a.findViewById(R.id.decode_partial_files);
        Button button = (Button) this.f3135a.findViewById(R.id.cancel);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_all_files) {
            this.f3136b.mo2834a(0);
        } else if (id == R.id.decode_partial_files) {
            this.f3136b.mo2834a(1);
        }
        dismiss();
    }
}
