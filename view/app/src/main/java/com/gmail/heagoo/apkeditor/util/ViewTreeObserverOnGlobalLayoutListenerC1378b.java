package com.gmail.heagoo.apkeditor.util;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.b */
/* JADX INFO: loaded from: classes.dex */
final class ViewTreeObserverOnGlobalLayoutListenerC1378b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C1376a f4000a;

    ViewTreeObserverOnGlobalLayoutListenerC1378b(C1376a c1376a) {
        this.f4000a = c1376a;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        C1376a.m3311a(this.f4000a);
    }
}
