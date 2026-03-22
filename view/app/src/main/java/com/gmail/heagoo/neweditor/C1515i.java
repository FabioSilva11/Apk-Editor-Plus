package com.gmail.heagoo.neweditor;

import android.widget.SlidingDrawer;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.i */
/* JADX INFO: loaded from: classes.dex */
final class C1515i implements SlidingDrawer.OnDrawerCloseListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditorActivity f4498a;

    C1515i(EditorActivity editorActivity) {
        this.f4498a = editorActivity;
    }

    @Override // android.widget.SlidingDrawer.OnDrawerCloseListener
    public final void onDrawerClosed() {
        EditorActivity.m3584j(this.f4498a);
    }
}
