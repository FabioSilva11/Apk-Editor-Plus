package com.gmail.heagoo.apkeditor;

import android.widget.SlidingDrawer;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hf */
/* JADX INFO: loaded from: classes.dex */
final class C1266hf implements SlidingDrawer.OnDrawerOpenListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditBigActivity f3618a;

    C1266hf(TextEditBigActivity textEditBigActivity) {
        this.f3618a = textEditBigActivity;
    }

    @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
    public final void onDrawerOpened() {
        TextEditBigActivity.m2584g(this.f3618a);
    }
}
