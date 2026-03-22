package com.gmail.heagoo.neweditor;

import android.widget.SlidingDrawer;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.h */
/* JADX INFO: loaded from: classes.dex */
final class C1514h implements SlidingDrawer.OnDrawerOpenListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditorActivity f4497a;

    C1514h(EditorActivity editorActivity) {
        this.f4497a = editorActivity;
    }

    @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
    public final void onDrawerOpened() {
        EditorActivity.m3583i(this.f4497a);
    }
}
