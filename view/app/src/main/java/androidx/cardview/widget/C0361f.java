package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: renamed from: androidx.cardview.widget.f */
/* JADX INFO: loaded from: classes.dex */
class C0361f implements InterfaceC0366k {
    final /* synthetic */ C0360e this$0;

    C0361f(C0360e c0360e) {
        this.this$0 = c0360e;
    }

    @Override // androidx.cardview.widget.InterfaceC0366k
    public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
        float f2 = 2.0f * f;
        float fWidth = (rectF.width() - f2) - 1.0f;
        float fHeight = (rectF.height() - f2) - 1.0f;
        if (f >= 1.0f) {
            float f3 = f + 0.5f;
            float f4 = -f3;
            this.this$0.mCornerRect.set(f4, f4, f3, f3);
            int iSave = canvas.save();
            canvas.translate(rectF.left + f3, rectF.top + f3);
            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
            canvas.translate(fHeight, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
            canvas.restoreToCount(iSave);
            canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, (rectF.right - f3) + 1.0f, rectF.top + f3, paint);
            canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, (rectF.right - f3) + 1.0f, rectF.bottom, paint);
        }
        canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
    }
}
