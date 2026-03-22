package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ed */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1182ed implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1145dx f3327a;

    ViewOnClickListenerC1182ed(DialogC1145dx dialogC1145dx) {
        this.f3327a = dialogC1145dx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!DialogC1145dx.m2883f(this.f3327a)) {
            C1141dt.m2870a((Context) this.f3327a.f3236a.get());
            return;
        }
        ((Activity) this.f3327a.f3236a.get()).startActivityForResult(C0985a.m2177a(((Activity) this.f3327a.f3236a.get()).getApplicationContext(), this.f3327a.f3237b, (String) null), 2);
        this.f3327a.dismiss();
    }
}
