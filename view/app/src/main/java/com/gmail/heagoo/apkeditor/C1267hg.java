package com.gmail.heagoo.apkeditor;

import android.widget.SlidingDrawer;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hg */
/* JADX INFO: loaded from: classes.dex */
final class C1267hg implements SlidingDrawer.OnDrawerCloseListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditBigActivity f3619a;

    C1267hg(TextEditBigActivity textEditBigActivity) {
        this.f3619a = textEditBigActivity;
    }

    @Override // android.widget.SlidingDrawer.OnDrawerCloseListener
    public final void onDrawerClosed() {
        TextEditBigActivity.m2585h(this.f3619a);
    }
}
