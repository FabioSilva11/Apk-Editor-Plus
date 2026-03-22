package com.gmail.heagoo.appdm;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.w */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1446w implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PrefOverallActivity f4251a;

    ViewOnClickListenerC1446w(PrefOverallActivity prefOverallActivity) {
        this.f4251a = prefOverallActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4251a.f4117b = 1;
        this.f4251a.m3426d();
        this.f4251a.f4134s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4251a.f4138w, (Drawable) null, (Drawable) null);
        this.f4251a.f4135t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4251a.f4141z, (Drawable) null, (Drawable) null);
        this.f4251a.f4136u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4251a.f4102A, (Drawable) null, (Drawable) null);
        this.f4251a.f4137v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4251a.f4104C, (Drawable) null, (Drawable) null);
    }
}
