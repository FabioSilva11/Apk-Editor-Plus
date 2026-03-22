package com.gmail.heagoo.apkeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.y */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1406y implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ApkInfoActivity f4084a;

    ViewOnClickListenerC1406y(ApkInfoActivity apkInfoActivity) {
        this.f4084a = apkInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new DialogC1133dh(this.f4084a, null, null).show();
    }
}
