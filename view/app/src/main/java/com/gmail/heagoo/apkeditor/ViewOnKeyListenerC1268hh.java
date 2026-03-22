package com.gmail.heagoo.apkeditor;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hh */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC1268hh implements View.OnKeyListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditBigActivity f3620a;

    ViewOnKeyListenerC1268hh(TextEditBigActivity textEditBigActivity) {
        this.f3620a = textEditBigActivity;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 66) {
            this.f3620a.m2574a(true);
            return true;
        }
        if (this.f3620a.f2743n.getVisibility() == 0 && keyEvent.getAction() == 1 && i == 4) {
            this.f3620a.f2743n.close();
            return true;
        }
        this.f3620a.m2581e();
        return false;
    }
}
