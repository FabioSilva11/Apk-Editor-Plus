package com.p050c.p051a;

import android.graphics.PointF;

/* JADX INFO: renamed from: com.c.a.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0950p {

    /* JADX INFO: renamed from: a */
    public float f2398a;

    /* JADX INFO: renamed from: b */
    public final PointF f2399b = new PointF();

    /* JADX INFO: renamed from: c */
    public final PointF f2400c = new PointF();

    /* JADX INFO: renamed from: d */
    private float f2401d;

    /* JADX INFO: renamed from: a */
    public final void m2095a() {
        this.f2400c.x = (((float) Math.cos(this.f2401d)) * this.f2398a) + this.f2399b.x;
        this.f2400c.y = (((float) Math.sin(this.f2401d)) * this.f2398a) + this.f2399b.y;
    }

    /* JADX INFO: renamed from: a */
    public final void m2096a(PointF pointF) {
        this.f2399b.x = pointF.x;
        this.f2399b.y = pointF.y;
    }

    /* JADX INFO: renamed from: b */
    public final float m2097b() {
        PointF pointF = this.f2399b;
        PointF pointF2 = this.f2400c;
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        this.f2398a = (float) Math.sqrt((f2 * f2) + (f * f));
        return this.f2398a;
    }

    /* JADX INFO: renamed from: b */
    public final void m2098b(PointF pointF) {
        this.f2400c.x = pointF.x;
        this.f2400c.y = pointF.y;
    }

    /* JADX INFO: renamed from: c */
    public final float m2099c() {
        PointF pointF = this.f2399b;
        PointF pointF2 = this.f2400c;
        float f = pointF.x;
        this.f2401d = (float) Math.atan2(pointF2.y - pointF.y, pointF2.x - f);
        return this.f2401d;
    }
}
