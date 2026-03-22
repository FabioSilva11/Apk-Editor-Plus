package com.gmail.heagoo.apkeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.z */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1407z implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ApkInfoActivity f4085a;

    ViewOnClickListenerC1407z(ApkInfoActivity apkInfoActivity) {
        this.f4085a = apkInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new DialogC1062b(this.f4085a).show();
    }
}
