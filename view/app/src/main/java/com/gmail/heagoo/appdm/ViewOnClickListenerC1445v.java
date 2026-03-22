package com.gmail.heagoo.appdm;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.v */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1445v implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PrefOverallActivity f4250a;

    ViewOnClickListenerC1445v(PrefOverallActivity prefOverallActivity) {
        this.f4250a = prefOverallActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4250a.f4117b = 0;
        this.f4250a.m3425c();
        this.f4250a.f4134s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4250a.f4139x, (Drawable) null, (Drawable) null);
        this.f4250a.f4135t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4250a.f4140y, (Drawable) null, (Drawable) null);
        this.f4250a.f4136u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4250a.f4102A, (Drawable) null, (Drawable) null);
        this.f4250a.f4137v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4250a.f4104C, (Drawable) null, (Drawable) null);
    }
}
