package com.gmail.heagoo.neweditor;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.n */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC1520n implements View.OnKeyListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditorActivity f4503a;

    ViewOnKeyListenerC1520n(EditorActivity editorActivity) {
        this.f4503a = editorActivity;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f4503a.f4397y.getVisibility() == 0 && keyEvent.getAction() == 1 && i == 4) {
            this.f4503a.f4397y.close();
            return true;
        }
        EditorActivity.m3586l(this.f4503a);
        return false;
    }
}
