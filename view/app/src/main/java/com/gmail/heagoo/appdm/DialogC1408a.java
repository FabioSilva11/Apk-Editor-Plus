package com.gmail.heagoo.appdm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.appdm.util.C1443i;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.a */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1408a extends Dialog {

    /* JADX INFO: renamed from: a */
    private View f4142a;

    /* JADX INFO: renamed from: b */
    private WeakReference f4143b;

    /* JADX INFO: renamed from: c */
    private String f4144c;

    /* JADX INFO: renamed from: d */
    private String f4145d;

    /* JADX INFO: renamed from: e */
    private String f4146e;

    @SuppressLint({"InflateParams"})
    public DialogC1408a(Activity activity, String str, String str2) {
        super(activity);
        requestWindowFeature(1);
        setCancelable(false);
        this.f4143b = new WeakReference(activity);
        this.f4144c = str;
        this.f4145d = str2;
        this.f4142a = LayoutInflater.from(activity).inflate(R.layout.appdm_dlg_saveapk, (ViewGroup) null);
        setContentView(this.f4142a);
    }

    /* JADX INFO: renamed from: b */
    private void m3430b(String str) {
        Activity activity = (Activity) this.f4143b.get();
        if (activity != null) {
            activity.runOnUiThread(new RunnableC1419d(this, activity, str));
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3431c() {
        Activity activity = (Activity) this.f4143b.get();
        if (activity != null) {
            activity.runOnUiThread(new RunnableC1418c(this));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3432a() {
        show();
        if (C1443i.m3464a()) {
            this.f4146e = C1443i.m3463a((Context) this.f4143b.get()) + "/" + this.f4145d + ".apk";
            new C1417b(this, this.f4144c, this.f4146e).start();
        } else {
            Activity activity = (Activity) this.f4143b.get();
            if (activity != null) {
                Toast.makeText(activity, "Cannot find SD card to save the APK.", 0).show();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m3433a(String str) {
        m3430b("Failed: " + str);
        m3431c();
    }

    /* JADX INFO: renamed from: b */
    protected final void m3434b() {
        m3430b(String.format(((Activity) this.f4143b.get()).getResources().getString(R.string.apk_saved_tip), this.f4146e));
        m3431c();
    }
}
