package com.gmail.heagoo.appdm;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.x */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1447x implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PrefOverallActivity f4252a;

    ViewOnClickListenerC1447x(PrefOverallActivity prefOverallActivity) {
        this.f4252a = prefOverallActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4252a.f4117b = 2;
        this.f4252a.m3427e();
        this.f4252a.f4134s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4252a.f4138w, (Drawable) null, (Drawable) null);
        this.f4252a.f4135t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4252a.f4140y, (Drawable) null, (Drawable) null);
        this.f4252a.f4136u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4252a.f4103B, (Drawable) null, (Drawable) null);
        this.f4252a.f4137v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4252a.f4104C, (Drawable) null, (Drawable) null);
    }
}
