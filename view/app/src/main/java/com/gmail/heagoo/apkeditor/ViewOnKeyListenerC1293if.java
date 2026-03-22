package com.gmail.heagoo.apkeditor;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.if */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC1293if implements View.OnKeyListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditNormalActivity f3671a;

    ViewOnKeyListenerC1293if(TextEditNormalActivity textEditNormalActivity) {
        this.f3671a = textEditNormalActivity;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f3671a.f2766G.getVisibility() == 0 && keyEvent.getAction() == 1 && i == 4) {
            this.f3671a.f2766G.close();
            return true;
        }
        this.f3671a.m2615g();
        return false;
    }
}
