package com.gmail.heagoo.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.InterfaceC1208fa;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.common.p */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1484p extends Dialog {

    /* JADX INFO: renamed from: a */
    private Activity f4312a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1208fa f4313b;

    /* JADX INFO: renamed from: c */
    private int f4314c;

    @SuppressLint({"InflateParams"})
    public DialogC1484p(Activity activity, InterfaceC1208fa interfaceC1208fa, int i) {
        super(activity);
        this.f4312a = activity;
        this.f4313b = interfaceC1208fa;
        this.f4314c = i;
        requestWindowFeature(1);
        super.setContentView(activity.getLayoutInflater().inflate(R.layout.dlg_processing, (ViewGroup) null));
        super.setCancelable(false);
        new C1486r(this).start();
    }

    /* JADX INFO: renamed from: a */
    protected final void m3522a(int i) {
        Toast.makeText(this.f4312a, i, 0).show();
    }

    /* JADX INFO: renamed from: a */
    protected final void m3523a(String str) {
        this.f4312a.runOnUiThread(new RunnableC1485q(this, str));
    }

    /* JADX INFO: renamed from: b */
    protected final void m3524b(String str) {
        Toast.makeText(this.f4312a, str, 0).show();
    }
}
