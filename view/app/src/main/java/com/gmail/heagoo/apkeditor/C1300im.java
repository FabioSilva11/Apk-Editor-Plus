package com.gmail.heagoo.apkeditor;

import android.graphics.Rect;
import com.gmail.heagoo.neweditor.C1511e;
import com.gmail.heagoo.neweditor.ObEditText;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.im */
/* JADX INFO: loaded from: classes.dex */
final class C1300im extends TimerTask {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ TextEditNormalActivity f3686a;

    C1300im(TextEditNormalActivity textEditNormalActivity) {
        this.f3686a = textEditNormalActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m3182a(C1511e c1511e, Rect rect) {
        int i;
        int i2 = 0;
        if (this.f3686a.f2793ah) {
            try {
                int lineHeight = this.f3686a.f2796l.getLineHeight();
                int i3 = rect.top / lineHeight;
                int i4 = rect.bottom / lineHeight;
                if (this.f3686a.f3579f) {
                    String[] strArrSplit = this.f3686a.f2796l.getText().toString().split("\\n");
                    int length = 0;
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < strArrSplit.length) {
                        int iM3601b = this.f3686a.f2796l.m3601b(length);
                        length += strArrSplit[i6].length() + 1;
                        if (iM3601b <= i3) {
                            i2 = i6;
                        }
                        if (iM3601b > i4) {
                            break;
                        }
                        int i7 = i6;
                        i6++;
                        i5 = i7;
                    }
                    i = i5;
                } else {
                    i2 = i3;
                    i = i4;
                }
                int i8 = i2 - this.f3686a.f2803w;
                int i9 = i + this.f3686a.f2803w;
                long jCurrentTimeMillis = System.currentTimeMillis();
                ObEditText obEditText = this.f3686a.f2796l;
                int i10 = this.f3686a.f2801u;
                int i11 = this.f3686a.f2800t;
                boolean z = this.f3686a.f2799s;
                this.f3686a.getApplicationContext();
                c1511e.m3646a(obEditText, i10, i11, i8, i9, z);
                if (System.currentTimeMillis() - jCurrentTimeMillis > 2000) {
                    TextEditNormalActivity.m2601b(this.f3686a, false);
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f3686a.f2793ah) {
            C1511e c1511e = this.f3686a.f3583j;
            Rect rect = new Rect();
            if (this.f3686a.f2796l.getLocalVisibleRect(rect)) {
                m3182a(c1511e, rect);
            } else if (this.f3686a.f2793ah) {
                ObEditText obEditText = this.f3686a.f2796l;
                int i = this.f3686a.f2801u;
                int i2 = this.f3686a.f2800t;
                boolean z = this.f3686a.f2799s;
                this.f3686a.getApplicationContext();
                c1511e.m3646a(obEditText, i, i2, -1, -1, z);
                this.f3686a.f2796l.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1301in(this, rect, c1511e));
            }
            TextEditNormalActivity.m2592a(this.f3686a, -1);
            TextEditNormalActivity.m2599b(this.f3686a, -1);
            TextEditNormalActivity.m2598a(this.f3686a, false);
        }
    }
}
