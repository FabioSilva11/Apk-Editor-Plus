package com.gmail.heagoo.apkeditor.p069ui;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.DialogC1115cn;
import com.gmail.heagoo.apkeditor.InterfaceC1122cu;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1469a;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ui.a */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1373a extends Dialog implements View.OnClickListener, InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private final InterfaceC1374b f3962a;

    /* JADX INFO: renamed from: b */
    private final WeakReference f3963b;

    /* JADX INFO: renamed from: c */
    private boolean f3964c;

    /* JADX INFO: renamed from: d */
    private View f3965d;

    /* JADX INFO: renamed from: e */
    private View f3966e;

    /* JADX INFO: renamed from: f */
    private View f3967f;

    /* JADX INFO: renamed from: g */
    private View f3968g;

    /* JADX INFO: renamed from: h */
    private EditText f3969h;

    /* JADX INFO: renamed from: i */
    private EditText f3970i;

    /* JADX INFO: renamed from: j */
    private boolean f3971j;

    public DialogC1373a(@NonNull Context context, InterfaceC1374b interfaceC1374b, boolean z) {
        super(context);
        this.f3971j = true;
        this.f3963b = new WeakReference(context);
        this.f3962a = interfaceC1374b;
        this.f3964c = z;
        setContentView(R.layout.dlg_add_folder);
        TextView textView = (TextView) findViewById(R.id.tv_new_folder);
        TextView textView2 = (TextView) findViewById(R.id.tv_import_folder);
        if (!this.f3964c) {
            textView2.setVisibility(8);
        }
        this.f3965d = findViewById(R.id.divider1);
        this.f3966e = findViewById(R.id.divider2);
        this.f3967f = findViewById(R.id.layout_new);
        this.f3968g = findViewById(R.id.layout_import);
        this.f3969h = (EditText) findViewById(R.id.et_folder_name);
        this.f3970i = (EditText) findViewById(R.id.et_folder_path);
        this.f3969h.setFilters(new InputFilter[]{C1469a.m3487a()});
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        findViewById(R.id.btn_browse).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_confirm).setOnClickListener(this);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        this.f3970i.setText(str);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return false;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_new_folder) {
            this.f3971j = true;
            this.f3965d.setVisibility(0);
            this.f3966e.setVisibility(4);
            this.f3967f.setVisibility(0);
            this.f3968g.setVisibility(4);
            return;
        }
        if (id == R.id.tv_import_folder) {
            this.f3971j = false;
            this.f3965d.setVisibility(4);
            this.f3966e.setVisibility(0);
            this.f3967f.setVisibility(4);
            this.f3968g.setVisibility(0);
            return;
        }
        if (id == R.id.btn_cancel) {
            dismiss();
            return;
        }
        if (id != R.id.btn_confirm) {
            if (id == R.id.btn_browse) {
                Context context = (Context) this.f3963b.get();
                new DialogC1115cn(context, this, "", "", context.getString(R.string.select_imported_folder), true, false, false, "import_folder").show();
                return;
            }
            return;
        }
        if (this.f3971j) {
            String strTrim = this.f3969h.getText().toString().trim();
            if ("".equals(strTrim)) {
                Toast.makeText((Context) this.f3963b.get(), R.string.empty_input_tip, 1).show();
                return;
            } else {
                this.f3962a.mo2448c(strTrim);
                dismiss();
                return;
            }
        }
        String strTrim2 = this.f3970i.getText().toString().trim();
        if ("".equals(strTrim2)) {
            Toast.makeText((Context) this.f3963b.get(), R.string.empty_input_tip, 1).show();
        } else if (!new File(strTrim2).exists()) {
            Toast.makeText((Context) this.f3963b.get(), String.format(((Context) this.f3963b.get()).getString(R.string.error_path_xxx_not_exist), strTrim2), 1).show();
        } else {
            this.f3962a.mo2451d(strTrim2);
            dismiss();
        }
    }
}
