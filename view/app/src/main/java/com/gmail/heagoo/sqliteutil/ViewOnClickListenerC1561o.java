package com.gmail.heagoo.sqliteutil;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.o */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1561o implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1557k f4683a;

    ViewOnClickListenerC1561o(DialogC1557k dialogC1557k) {
        this.f4683a = dialogC1557k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4683a.cancel();
    }
}
