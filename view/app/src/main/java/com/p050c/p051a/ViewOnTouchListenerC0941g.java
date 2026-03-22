package com.p050c.p051a;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.c.a.g */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnTouchListenerC0941g implements View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0940f f2353a;

    ViewOnTouchListenerC0941g(C0940f c0940f) {
        this.f2353a = c0940f;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f2353a.f2325F != null) {
            this.f2353a.f2325F.onTouch(view, motionEvent);
        }
        return this.f2353a.f2324E.onTouch(view, motionEvent);
    }
}
