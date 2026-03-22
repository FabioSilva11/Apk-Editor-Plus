package com.gmail.heagoo.apkeditor;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.au */
/* JADX INFO: loaded from: classes.dex */
final class ServiceConnectionC1056au implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private boolean f3017a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkInfoActivity f3018b;

    public ServiceConnectionC1056au(ApkInfoActivity apkInfoActivity, boolean z) {
        this.f3018b = apkInfoActivity;
        this.f3017a = z;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (((BinderC1318k) iBinder).m3192b()) {
            new AlertDialog.Builder(this.f3018b).setMessage(R.string.build_in_progress_tip).setTitle(R.string.please_note).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
        } else {
            this.f3018b.m2406e(this.f3017a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
