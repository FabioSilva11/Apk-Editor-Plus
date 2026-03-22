package com.gmail.heagoo.neweditor;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.m */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC1519m implements View.OnKeyListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditorActivity f4502a;

    ViewOnKeyListenerC1519m(EditorActivity editorActivity) {
        this.f4502a = editorActivity;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 66) {
            this.f4502a.m3575c(true);
            return true;
        }
        if (this.f4502a.f4397y.getVisibility() == 0 && keyEvent.getAction() == 1 && i == 4) {
            this.f4502a.f4397y.close();
            return true;
        }
        EditorActivity.m3586l(this.f4502a);
        return false;
    }
}
