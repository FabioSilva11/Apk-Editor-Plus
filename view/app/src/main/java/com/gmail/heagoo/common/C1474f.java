package com.gmail.heagoo.common;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: renamed from: com.gmail.heagoo.common.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1474f {

    /* JADX INFO: renamed from: a */
    private static int f4297a = 0;

    /* JADX INFO: renamed from: b */
    private static int f4298b = 0;

    /* JADX INFO: renamed from: a */
    public static int m3501a(Activity activity) {
        if (f4297a <= 0) {
            m3504c(activity);
        }
        return f4297a;
    }

    /* JADX INFO: renamed from: a */
    public static int m3502a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    /* JADX INFO: renamed from: b */
    public static int m3503b(Activity activity) {
        if (f4298b <= 0) {
            m3504c(activity);
        }
        return f4298b;
    }

    /* JADX INFO: renamed from: c */
    private static void m3504c(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        f4297a = displayMetrics.widthPixels;
        f4298b = displayMetrics.heightPixels;
    }
}
