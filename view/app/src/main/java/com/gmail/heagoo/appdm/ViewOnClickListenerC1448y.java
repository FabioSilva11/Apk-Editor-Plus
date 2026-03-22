package com.gmail.heagoo.appdm;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.y */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1448y implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PrefOverallActivity f4253a;

    ViewOnClickListenerC1448y(PrefOverallActivity prefOverallActivity) {
        this.f4253a = prefOverallActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4253a.f4117b = 3;
        this.f4253a.m3428f();
        this.f4253a.f4134s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4253a.f4138w, (Drawable) null, (Drawable) null);
        this.f4253a.f4135t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4253a.f4140y, (Drawable) null, (Drawable) null);
        this.f4253a.f4136u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4253a.f4102A, (Drawable) null, (Drawable) null);
        this.f4253a.f4137v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f4253a.f4105D, (Drawable) null, (Drawable) null);
    }
}
