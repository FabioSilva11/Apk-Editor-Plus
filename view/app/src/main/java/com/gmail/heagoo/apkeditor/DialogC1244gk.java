package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gk */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1244gk extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    private static int[] f3533e = {R.string.show_a_toast, R.string.log_a_message, R.string.dump_a_value, R.string.print_stack_trace};

    /* JADX INFO: renamed from: f */
    private static String[] f3534f = {"    const-string v0, \"This is a toast.\"\n    # p0 (this object) must be an object of Context\n    invoke-static {p0, v0}, Lapkeditor/Utils;->showToast(Landroid/content/Context;Ljava/lang/String;)V", "    # use 'adb logcat APKEDITOR:* *:S' to view the log\n    const-string v0, \"I am here.\"\n    invoke-static {v0}, Lapkeditor/Utils;->log(Ljava/lang/String;)V", "    # use 'adb logcat APKEDITOR:* *:S' to view the value\n    invoke-static {v0}, Lapkeditor/Utils;->dumpValue(Ljava/lang/Object;)V", "    # use 'adb logcat APKEDITOR:* *:S' to view the stack trace\n    invoke-static {}, Lapkeditor/Utils;->printCallStack()V"};

    /* JADX INFO: renamed from: a */
    private WeakReference f3535a;

    /* JADX INFO: renamed from: b */
    private String f3536b;

    /* JADX INFO: renamed from: c */
    private Spinner f3537c;

    /* JADX INFO: renamed from: d */
    private EditText f3538d;

    public DialogC1244gk(Activity activity, String str) {
        super(activity);
        requestWindowFeature(1);
        this.f3535a = new WeakReference(activity);
        this.f3536b = m3103a(str);
        m3104a(activity);
        getWindow().setLayout((activity.getResources().getDisplayMetrics().widthPixels * 6) / 7, -2);
    }

    /* JADX INFO: renamed from: a */
    private static String m3103a(String str) {
        String str2 = "";
        for (String str3 : str.split("/")) {
            str2 = str2 + str3 + "/";
            if ("smali".equals(str3) || str3.startsWith("smali_")) {
                break;
            }
        }
        return str2;
    }

    @SuppressLint({"InflateParams"})
    /* JADX INFO: renamed from: a */
    private void m3104a(Activity activity) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.dlg_smalicode, (ViewGroup) null);
        this.f3537c = (Spinner) viewInflate.findViewById(R.id.spinner_codename);
        String[] strArr = new String[f3533e.length];
        for (int i = 0; i < f3533e.length; i++) {
            strArr[i] = activity.getString(f3533e[i]);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, strArr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.f3537c.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f3537c.setOnItemSelectedListener(new C1245gl(this));
        this.f3538d = (EditText) viewInflate.findViewById(R.id.et_samplecode);
        ((Button) viewInflate.findViewById(R.id.btn_copy)).setOnClickListener(this);
        ((Button) viewInflate.findViewById(R.id.btn_close)).setOnClickListener(this);
        setContentView(viewInflate);
    }

    /* JADX INFO: renamed from: a */
    private static void m3105a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m3106a(int i) {
        if (i < f3534f.length) {
            this.f3538d.setText(f3534f[i]);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen = null;
        int id = view.getId();
        if (id == R.id.btn_close) {
            dismiss();
            return;
        }
        if (id == R.id.btn_copy) {
            Activity activity = (Activity) this.f3535a.get();
            ((ClipboardManager) activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("code", this.f3538d.getText().toString()));
            String str = this.f3536b + "apkeditor";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(str + "/Utils.smali");
            if (!file2.exists()) {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                    m3105a(fileOutputStream);
                    m3105a(inputStreamOpen);
                    throw th;
                }
                try {
                    try {
                        inputStreamOpen = ((Activity) this.f3535a.get()).getAssets().open("smali_patch/Utils.smali");
                        C0985a.m2244b(inputStreamOpen, fileOutputStream);
                        m3105a(fileOutputStream);
                        m3105a(inputStreamOpen);
                    } catch (Throwable th2) {
                        th = th2;
                        m3105a(fileOutputStream);
                        m3105a(inputStreamOpen);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    m3105a(fileOutputStream);
                    m3105a(inputStreamOpen);
                }
            }
            Toast.makeText(activity, R.string.smali_copied, 0).show();
        }
    }
}
