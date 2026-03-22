package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ey */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1201ey extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private WeakReference f3398a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1208fa f3399b;

    /* JADX INFO: renamed from: c */
    private int f3400c;

    @SuppressLint({"InflateParams"})
    public DialogC1201ey(Activity activity, InterfaceC1208fa interfaceC1208fa, int i) {
        super(activity);
        this.f3398a = new WeakReference(activity);
        this.f3399b = interfaceC1208fa;
        this.f3400c = i;
        requestWindowFeature(1);
        super.setContentView(LayoutInflater.from(activity).inflate(R.layout.dlg_processing, (ViewGroup) null));
        super.setCancelable(false);
        new C1209fb(this).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2996a() {
        try {
            dismiss();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m2999a(int i) {
        Activity activity;
        if (i == -1 || (activity = (Activity) this.f3398a.get()) == null) {
            return;
        }
        Toast.makeText(activity, i, 0).show();
    }

    /* JADX INFO: renamed from: a */
    protected final void m3000a(String str) {
        Activity activity = (Activity) this.f3398a.get();
        if (activity != null) {
            activity.runOnUiThread(new RunnableC1202ez(this, str));
        }
    }

    /* JADX INFO: renamed from: b */
    protected final void m3001b(String str) {
        Activity activity = (Activity) this.f3398a.get();
        if (activity != null) {
            Toast.makeText(activity, str, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.close_button) {
            m2996a();
        }
    }
}
