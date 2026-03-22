package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dz */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1147dz implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ DialogC1145dx f3241a;

    ViewOnClickListenerC1147dz(DialogC1145dx dialogC1145dx) {
        this.f3241a = dialogC1145dx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String string = ((Activity) this.f3241a.f3236a.get()).getString(R.string.select_folder);
        new DialogC1115cn((Context) this.f3241a.f3236a.get(), new C1179ea(this), null, null, string, true, false, false, null).show();
        this.f3241a.dismiss();
    }
}
