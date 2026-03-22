package com.gmail.heagoo.apkeditor;

import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ig */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnTouchListenerC1294ig implements View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private boolean f3672a = false;

    /* JADX INFO: renamed from: b */
    private float f3673b;

    /* JADX INFO: renamed from: c */
    private float f3674c;

    /* JADX INFO: renamed from: d */
    private long f3675d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ TextEditNormalActivity f3676e;

    ViewOnTouchListenerC1294ig(TextEditNormalActivity textEditNormalActivity) {
        this.f3676e = textEditNormalActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f3672a = false;
            int selectionStart = this.f3676e.f2796l.getSelectionStart();
            int selectionEnd = this.f3676e.f2796l.getSelectionEnd();
            if (selectionStart != selectionEnd) {
                Layout layout = ((EditText) view).getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) (motionEvent.getY() + this.f3676e.f2796l.getScrollY())), motionEvent.getX() + this.f3676e.f2796l.getScrollX());
                if (offsetForHorizontal >= selectionStart && offsetForHorizontal < selectionEnd && !this.f3676e.m3142c()) {
                    this.f3672a = true;
                    this.f3673b = motionEvent.getX();
                    this.f3674c = motionEvent.getY();
                    this.f3675d = System.currentTimeMillis();
                    return true;
                }
            }
        } else if (motionEvent.getAction() != 2 && motionEvent.getAction() == 1) {
            if (this.f3672a) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (Math.abs(x - this.f3673b) < 32.0f && Math.abs(y - this.f3674c) < 32.0f && jCurrentTimeMillis - this.f3675d < 500) {
                    TextEditNormalActivity.m2627r(this.f3676e);
                    return true;
                }
            }
            this.f3672a = false;
        }
        return false;
    }
}
