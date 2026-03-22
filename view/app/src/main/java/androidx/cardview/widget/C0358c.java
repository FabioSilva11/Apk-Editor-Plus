package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: renamed from: androidx.cardview.widget.c */
/* JADX INFO: loaded from: classes.dex */
class C0358c implements InterfaceC0366k {
    final /* synthetic */ C0357b this$0;

    C0358c(C0357b c0357b) {
        this.this$0 = c0357b;
    }

    @Override // androidx.cardview.widget.InterfaceC0366k
    public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
