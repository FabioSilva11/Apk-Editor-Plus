package com.gmail.heagoo.pngeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.f */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1541f implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PngEditActivity f4585a;

    ViewOnClickListenerC1541f(PngEditActivity pngEditActivity) {
        this.f4585a = pngEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4585a.f4571w.dismiss();
    }
}
