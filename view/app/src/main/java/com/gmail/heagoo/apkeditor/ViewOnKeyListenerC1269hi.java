package com.gmail.heagoo.apkeditor;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hi */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC1269hi implements View.OnKeyListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditBigActivity f3621a;

    ViewOnKeyListenerC1269hi(TextEditBigActivity textEditBigActivity) {
        this.f3621a = textEditBigActivity;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f3621a.f2743n.getVisibility() == 0 && keyEvent.getAction() == 1 && i == 4) {
            this.f3621a.f2743n.close();
            return true;
        }
        this.f3621a.m2581e();
        return false;
    }
}
