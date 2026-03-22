package com.gmail.heagoo.apkeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ha */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1261ha implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AbstractActivityC1258gy f3604a;

    ViewOnClickListenerC1261ha(AbstractActivityC1258gy abstractActivityC1258gy) {
        this.f3604a = abstractActivityC1258gy;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3604a.mo2590c(((Integer) view.getTag()).intValue());
    }
}
