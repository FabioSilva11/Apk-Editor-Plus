package com.gmail.heagoo.apkeditor;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.gmail.heagoo.neweditor.InterfaceC1525s;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hb */
/* JADX INFO: loaded from: classes.dex */
final class ViewTreeObserverOnGlobalLayoutListenerC1262hb implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ View f3605a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ InterfaceC1525s f3606b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ AbstractActivityC1258gy f3607c;

    ViewTreeObserverOnGlobalLayoutListenerC1262hb(AbstractActivityC1258gy abstractActivityC1258gy, View view, InterfaceC1525s interfaceC1525s) {
        this.f3607c = abstractActivityC1258gy;
        this.f3605a = view;
        this.f3606b = interfaceC1525s;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Rect rect = new Rect();
        this.f3605a.getWindowVisibleDisplayFrame(rect);
        int height = this.f3605a.getRootView().getHeight();
        int i = height - rect.bottom;
        this.f3607c.f3592s = ((double) i) > ((double) height) * 0.15d;
        this.f3606b.mo3303a(this.f3607c.f3592s);
        AbstractActivityC1258gy.m3124b(this.f3607c, this.f3607c.f3592s);
    }
}
