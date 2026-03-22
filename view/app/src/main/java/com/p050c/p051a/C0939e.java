package com.p050c.p051a;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: renamed from: com.c.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0939e extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a */
    private float f2318a;

    /* JADX INFO: renamed from: b */
    private float f2319b;

    /* JADX INFO: renamed from: a */
    public final float m2057a() {
        return this.f2318a;
    }

    /* JADX INFO: renamed from: b */
    public final float m2058b() {
        return this.f2319b;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f2318a = f;
        this.f2319b = f2;
        return true;
    }
}
