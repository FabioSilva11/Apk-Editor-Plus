package com.gmail.heagoo.apkeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gz */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1259gz implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AbstractActivityC1258gy f3599a;

    ViewOnClickListenerC1259gz(AbstractActivityC1258gy abstractActivityC1258gy) {
        this.f3599a = abstractActivityC1258gy;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3599a.f3597x.getVisibility() == 0) {
            this.f3599a.f3596w.setVisibility(0);
            this.f3599a.f3597x.setVisibility(4);
        } else {
            this.f3599a.f3597x.setVisibility(0);
            this.f3599a.f3596w.setVisibility(4);
        }
    }
}
