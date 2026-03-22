package com.gmail.heagoo.neweditor;

import android.graphics.Rect;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.q */
/* JADX INFO: loaded from: classes.dex */
final class ViewTreeObserverOnGlobalLayoutListenerC1523q implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Rect f4506a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C1511e f4507b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1522p f4508c;

    ViewTreeObserverOnGlobalLayoutListenerC1523q(C1522p c1522p, Rect rect, C1511e c1511e) {
        this.f4508c = c1522p;
        this.f4506a = rect;
        this.f4507b = c1511e;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f4508c.f4505a.f4377a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (this.f4508c.f4505a.f4377a.getLocalVisibleRect(this.f4506a)) {
            this.f4508c.m3651a(this.f4507b, this.f4506a);
        }
    }
}
