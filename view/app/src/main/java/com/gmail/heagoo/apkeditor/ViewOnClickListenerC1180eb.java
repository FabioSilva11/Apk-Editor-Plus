package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.eb */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1180eb implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ DialogC1145dx f3325a;

    ViewOnClickListenerC1180eb(DialogC1145dx dialogC1145dx) {
        this.f3325a = dialogC1145dx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!DialogC1145dx.m2883f(this.f3325a)) {
            C1141dt.m2870a((Context) this.f3325a.f3236a.get());
        } else {
            new DialogC1115cn((Context) this.f3325a.f3236a.get(), new C1181ec(this), ".xml", this.f3325a.f3237b, null, false, false, true, null).show();
            this.f3325a.dismiss();
        }
    }
}
