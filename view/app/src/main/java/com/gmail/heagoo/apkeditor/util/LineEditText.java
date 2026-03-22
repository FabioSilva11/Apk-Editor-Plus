package com.gmail.heagoo.apkeditor.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class LineEditText extends EditText {

    /* JADX INFO: renamed from: a */
    private Rect f3987a;

    /* JADX INFO: renamed from: b */
    private Paint f3988b;

    /* JADX INFO: renamed from: c */
    private float f3989c;

    /* JADX INFO: renamed from: d */
    private int f3990d;

    /* JADX INFO: renamed from: e */
    private int f3991e;

    /* JADX INFO: renamed from: f */
    private int f3992f;

    /* JADX INFO: renamed from: g */
    private int f3993g;

    public LineEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3989c = context.getResources().getDisplayMetrics().density;
        this.f3990d = getPaddingLeft();
        this.f3991e = getPaddingRight();
        this.f3992f = getPaddingBottom();
        this.f3993g = getPaddingTop();
        this.f3987a = new Rect();
        this.f3988b = new Paint();
        this.f3988b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f3988b.setColor(-8882056);
        this.f3988b.setTextSize((int) ((14.0f * this.f3989c) + 0.5f));
        this.f3990d = (int) this.f3988b.measureText("4455");
        setPadding((int) (this.f3990d + (2.0f * this.f3989c)), this.f3993g, this.f3991e, this.f3992f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int lineBounds;
        int lineHeight = getLineHeight();
        int lineCount = getLineCount();
        Rect rect = this.f3987a;
        Paint paint = this.f3988b;
        String string = getText().toString();
        int length = string.length();
        Layout layout = getLayout();
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (i3 < lineCount) {
            int lineEnd = layout.getLineEnd(i3);
            if (i2 != i5) {
                String str = i2 < 1000 ? String.format("%03d", Integer.valueOf(i2)) : String.format("%4d", Integer.valueOf(i2));
                lineBounds = getLineBounds(i3, rect);
                canvas.drawText(str, rect.left - getPaddingLeft(), lineBounds + 1, paint);
                i = i2;
            } else {
                i = i5;
                lineBounds = i4;
            }
            i3++;
            i2 = (length < lineEnd || string.charAt(lineEnd + (-1)) != '\n') ? i2 : i2 + 1;
            i4 = lineBounds;
            i5 = i;
        }
        canvas.drawLine(this.f3990d, this.f3993g + (lineHeight / 3), this.f3990d, i4 + 1, paint);
        super.onDraw(canvas);
    }
}
