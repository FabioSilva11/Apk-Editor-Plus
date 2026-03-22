package com.gmail.heagoo.apkeditor.util;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.gmail.heagoo.common.C1474f;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.a */
/* JADX INFO: loaded from: classes.dex */
public class C1376a {

    /* JADX INFO: renamed from: a */
    private WeakReference f3994a;

    /* JADX INFO: renamed from: b */
    private int f3995b;

    /* JADX INFO: renamed from: c */
    private int f3996c;

    /* JADX INFO: renamed from: d */
    private View f3997d;

    /* JADX INFO: renamed from: e */
    private int f3998e;

    private C1376a(Activity activity) {
        this.f3994a = new WeakReference(activity);
        this.f3995b = C1474f.m3503b(activity);
        this.f3996c = C1474f.m3501a(activity);
        this.f3997d = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        this.f3997d.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1378b(this));
        this.f3997d.getLayoutParams();
    }

    /* JADX INFO: renamed from: a */
    public static void m3310a(Activity activity) {
        new C1376a(activity);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3311a(C1376a c1376a) {
        Rect rect = new Rect();
        c1376a.f3997d.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        if (i != c1376a.f3998e) {
            if (i >= ((((Activity) c1376a.f3994a.get()).getResources().getConfiguration().orientation == 1 ? c1376a.f3995b : c1376a.f3996c) * 85) / 100) {
                Window window = ((Activity) c1376a.f3994a.get()).getWindow();
                window.addFlags(1024);
                window.clearFlags(2048);
            } else {
                Window window2 = ((Activity) c1376a.f3994a.get()).getWindow();
                window2.addFlags(2048);
                window2.clearFlags(1024);
            }
            c1376a.f3998e = i;
        }
    }
}
