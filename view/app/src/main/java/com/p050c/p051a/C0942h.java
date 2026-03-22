package com.p050c.p051a;

import android.widget.ImageView;

/* JADX INFO: renamed from: com.c.a.h */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class C0942h {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ int[] f2354a = new int[ImageView.ScaleType.values().length];

    static {
        try {
            f2354a[ImageView.ScaleType.CENTER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2354a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2354a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
