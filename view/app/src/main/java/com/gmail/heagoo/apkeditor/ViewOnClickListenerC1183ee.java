package com.gmail.heagoo.apkeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ee */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1183ee implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1145dx f3328a;

    ViewOnClickListenerC1183ee(DialogC1145dx dialogC1145dx) {
        this.f3328a = dialogC1145dx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3328a.dismiss();
    }
}
