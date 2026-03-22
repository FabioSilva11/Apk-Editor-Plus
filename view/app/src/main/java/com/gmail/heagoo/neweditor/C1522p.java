package com.gmail.heagoo.neweditor;

import android.graphics.Rect;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.p */
/* JADX INFO: loaded from: classes.dex */
final class C1522p extends TimerTask {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ EditorActivity f4505a;

    C1522p(EditorActivity editorActivity) {
        this.f4505a = editorActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m3651a(C1511e c1511e, Rect rect) {
        int i;
        int i2;
        try {
            int lineHeight = rect.top / this.f4505a.f4377a.getLineHeight();
            int height = (rect.top + this.f4505a.getWindowManager().getDefaultDisplay().getHeight()) / this.f4505a.f4377a.getLineHeight();
            if (this.f4505a.f4384l) {
                String[] strArrSplit = this.f4505a.f4377a.getText().toString().split("\\n");
                int length = 0;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < strArrSplit.length; i5++) {
                    int iM3601b = this.f4505a.f4377a.m3601b(length);
                    length += strArrSplit[i5].length() + 1;
                    if (iM3601b <= lineHeight) {
                        i4 = i5;
                    }
                    if (iM3601b <= height) {
                        i3 = i5;
                    }
                }
                i2 = i3;
                i = i4;
            } else {
                i = lineHeight;
                i2 = height;
            }
            int i6 = i - this.f4505a.f4386n;
            int i7 = i2 + this.f4505a.f4386n;
            ObEditText obEditText = this.f4505a.f4377a;
            int i8 = this.f4505a.f4383k;
            int i9 = this.f4505a.f4382j;
            boolean z = this.f4505a.f4381i;
            this.f4505a.getApplicationContext();
            c1511e.m3646a(obEditText, i8, i9, i6, i7, z);
        } catch (Exception e) {
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        C1511e c1511e = this.f4505a.f4369P;
        Rect rect = new Rect();
        if (this.f4505a.f4377a.getLocalVisibleRect(rect)) {
            m3651a(c1511e, rect);
        } else {
            ObEditText obEditText = this.f4505a.f4377a;
            int i = this.f4505a.f4383k;
            int i2 = this.f4505a.f4382j;
            boolean z = this.f4505a.f4381i;
            this.f4505a.getApplicationContext();
            c1511e.m3646a(obEditText, i, i2, -1, -1, z);
            this.f4505a.f4377a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1523q(this, rect, c1511e));
        }
        EditorActivity.m3565a(this.f4505a, -1);
        EditorActivity.m3571b(this.f4505a, -1);
        EditorActivity.m3570a(this.f4505a, false);
    }
}
