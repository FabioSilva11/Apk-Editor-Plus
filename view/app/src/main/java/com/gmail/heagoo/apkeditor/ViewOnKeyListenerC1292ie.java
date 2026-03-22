package com.gmail.heagoo.apkeditor;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ie */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC1292ie implements View.OnKeyListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditNormalActivity f3670a;

    ViewOnKeyListenerC1292ie(TextEditNormalActivity textEditNormalActivity) {
        this.f3670a = textEditNormalActivity;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 66) {
            this.f3670a.m2602b(true);
            return true;
        }
        if (this.f3670a.f2766G.getVisibility() == 0 && keyEvent.getAction() == 1 && i == 4) {
            this.f3670a.f2766G.close();
            return true;
        }
        this.f3670a.m2615g();
        return false;
    }
}
