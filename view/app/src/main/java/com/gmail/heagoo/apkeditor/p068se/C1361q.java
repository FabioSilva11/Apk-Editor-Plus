package com.gmail.heagoo.apkeditor.p068se;

import android.support.v4.view.ViewPager;
import android.view.animation.TranslateAnimation;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1361q implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a */
    private int f3909a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ SimpleEditActivity f3910b;

    public C1361q(SimpleEditActivity simpleEditActivity) {
        this.f3910b = simpleEditActivity;
        this.f3909a = this.f3910b.f3856o / 3;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f3909a * this.f3910b.f3855n, this.f3909a * i, 0.0f, 0.0f);
        this.f3910b.f3855n = i;
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200L);
        SimpleEditActivity.m3252f(this.f3910b);
    }
}
