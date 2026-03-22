package com.gmail.heagoo.apkeditor;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.du */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1142du implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C1135dj f3231a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C1141dt f3232b;

    ViewOnClickListenerC1142du(C1141dt c1141dt, C1135dj c1135dj) {
        this.f3232b = c1141dt;
        this.f3231a = c1135dj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C1141dt.m2871a(this.f3232b, this.f3231a);
    }
}
