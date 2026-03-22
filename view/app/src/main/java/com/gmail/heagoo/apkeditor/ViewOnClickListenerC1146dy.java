package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dy */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1146dy implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1145dx f3240a;

    ViewOnClickListenerC1146dy(DialogC1145dx dialogC1145dx) {
        this.f3240a = dialogC1145dx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String strMo2427a = this.f3240a.f3239d.mo2427a(this.f3240a.f3238c);
        if (strMo2427a == null) {
            this.f3240a.dismiss();
        } else {
            if (strMo2427a.equals("")) {
                return;
            }
            Toast.makeText((Context) this.f3240a.f3236a.get(), strMo2427a, 0).show();
        }
    }
}
