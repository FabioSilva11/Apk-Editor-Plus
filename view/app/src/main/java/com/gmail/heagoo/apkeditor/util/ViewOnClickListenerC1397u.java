package com.gmail.heagoo.apkeditor.util;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.u */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1397u implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ int f4056a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C1396t f4057b;

    ViewOnClickListenerC1397u(C1396t c1396t, int i) {
        this.f4057b = c1396t;
        this.f4056a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        for (int i = 0; i < this.f4057b.f4054c.size(); i++) {
            if (i == this.f4056a) {
                ((C1398v) this.f4057b.f4054c.get(i)).f4059b = true;
            } else {
                ((C1398v) this.f4057b.f4054c.get(i)).f4059b = false;
            }
        }
        this.f4057b.f4052a.getDialog().dismiss();
    }
}
