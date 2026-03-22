package ru.zeratul.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
class SeekBar extends android.widget.SeekBar {

    /* JADX INFO: renamed from: a */
    private int[] f4835a;

    /* JADX INFO: renamed from: b */
    private int f4836b;

    /* JADX INFO: renamed from: c */
    private int f4837c;

    /* JADX INFO: renamed from: d */
    private int f4838d;

    /* JADX INFO: renamed from: e */
    private int f4839e;

    /* JADX INFO: renamed from: f */
    private float f4840f;

    /* JADX INFO: renamed from: g */
    private Paint f4841g;

    /* JADX INFO: renamed from: h */
    private Rect f4842h;

    /* JADX INFO: renamed from: i */
    private String f4843i;

    public SeekBar(Context context) {
        super(context);
        this.f4835a = new int[]{R.attr.textSize, R.attr.textColor, R.attr.text};
        this.f4836b = 0;
        this.f4837c = 1;
        this.f4838d = 2;
        init((AttributeSet) null);
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4835a = new int[]{R.attr.textSize, R.attr.textColor, R.attr.text};
        this.f4836b = 0;
        this.f4837c = 1;
        this.f4838d = 2;
        init(attributeSet);
    }

    public SeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4835a = new int[]{R.attr.textSize, R.attr.textColor, R.attr.text};
        this.f4836b = 0;
        this.f4837c = 1;
        this.f4838d = 2;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.f4841g = new Paint(65);
        this.f4842h = new Rect();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, this.f4835a);
            try {
                this.f4839e = typedArrayObtainStyledAttributes.getColor(this.f4837c, ViewCompat.MEASURED_STATE_MASK);
                this.f4840f = typedArrayObtainStyledAttributes.getDimension(this.f4836b, TypedValue.applyDimension(2, 16, getResources().getDisplayMetrics()));
                this.f4843i = typedArrayObtainStyledAttributes.getString(this.f4838d);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f4841g.setColor(this.f4839e);
        this.f4841g.setTypeface(Typeface.DEFAULT_BOLD);
        this.f4841g.setTextSize(this.f4840f);
        this.f4841g.setTextAlign(Paint.Align.CENTER);
        this.f4841g.getTextBounds("255", 0, 3, this.f4842h);
        setPadding(getPaddingLeft(), (int) TypedValue.applyDimension(1, (float) (0.6d * ((double) this.f4842h.height())), getResources().getDisplayMetrics()), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(this.f4843i == null ? String.valueOf(getProgress()) : this.f4843i, getThumb().getBounds().left + getPaddingLeft(), this.f4842h.height() + (getPaddingTop() >> 4), this.f4841g);
    }
}
