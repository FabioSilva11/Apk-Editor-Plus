package com.gmail.heagoo.apkeditor;

import android.widget.SlidingDrawer;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ic */
/* JADX INFO: loaded from: classes.dex */
final class C1290ic implements SlidingDrawer.OnDrawerCloseListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditNormalActivity f3668a;

    C1290ic(TextEditNormalActivity textEditNormalActivity) {
        this.f3668a = textEditNormalActivity;
    }

    @Override // android.widget.SlidingDrawer.OnDrawerCloseListener
    public final void onDrawerClosed() {
        TextEditNormalActivity.m2624o(this.f3668a);
    }
}
