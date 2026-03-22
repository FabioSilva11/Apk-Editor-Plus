package com.gmail.heagoo.apkeditor;

import android.widget.SlidingDrawer;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hy */
/* JADX INFO: loaded from: classes.dex */
final class C1285hy implements SlidingDrawer.OnDrawerOpenListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditNormalActivity f3662a;

    C1285hy(TextEditNormalActivity textEditNormalActivity) {
        this.f3662a = textEditNormalActivity;
    }

    @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
    public final void onDrawerOpened() {
        TextEditNormalActivity.m2623n(this.f3662a);
    }
}
