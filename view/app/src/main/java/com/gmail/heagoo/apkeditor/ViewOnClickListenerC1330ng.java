package com.gmail.heagoo.apkeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ng */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1330ng implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final FileListActivity f3764a;

    public ViewOnClickListenerC1330ng(FileListActivity fileListActivity) {
        this.f3764a = fileListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3764a.finish();
    }
}
