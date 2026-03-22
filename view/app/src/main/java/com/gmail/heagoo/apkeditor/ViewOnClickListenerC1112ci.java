package com.gmail.heagoo.apkeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ci */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1112ci implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ FileListActivity f3161a;

    ViewOnClickListenerC1112ci(FileListActivity fileListActivity) {
        this.f3161a = fileListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FileListActivity.m2506a(this.f3161a);
        } catch (Exception e) {
        }
    }
}
