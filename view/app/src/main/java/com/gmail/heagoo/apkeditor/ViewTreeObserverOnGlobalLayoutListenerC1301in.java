package com.gmail.heagoo.apkeditor;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.gmail.heagoo.neweditor.C1511e;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.in */
/* JADX INFO: loaded from: classes.dex */
final class ViewTreeObserverOnGlobalLayoutListenerC1301in implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Rect f3687a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C1511e f3688b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1300im f3689c;

    ViewTreeObserverOnGlobalLayoutListenerC1301in(C1300im c1300im, Rect rect, C1511e c1511e) {
        this.f3689c = c1300im;
        this.f3687a = rect;
        this.f3688b = c1511e;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f3689c.f3686a.f2796l.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (this.f3689c.f3686a.f2796l.getLocalVisibleRect(this.f3687a)) {
            this.f3689c.m3182a(this.f3688b, this.f3687a);
        }
    }
}
