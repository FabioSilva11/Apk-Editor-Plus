package com.gmail.heagoo.apkeditor.p069ui;

import android.content.Context;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ui.c */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnTouchListenerC1375c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private boolean f3972a = false;

    /* JADX INFO: renamed from: b */
    private float f3973b;

    /* JADX INFO: renamed from: c */
    private float f3974c;

    /* JADX INFO: renamed from: d */
    private long f3975d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ EditTextRememberCursor f3976e;

    ViewOnTouchListenerC1375c(EditTextRememberCursor editTextRememberCursor) {
        this.f3976e = editTextRememberCursor;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f3972a = false;
            int i = this.f3976e.f3952a;
            int i2 = this.f3976e.f3953b;
            if (i != i2) {
                Layout layout = ((EditText) view).getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) (motionEvent.getY() + this.f3976e.getScrollY())), motionEvent.getX() + this.f3976e.getScrollX());
                LayoutObListView layoutObListView = (LayoutObListView) this.f3976e.f3955d.get();
                boolean z = layoutObListView != null && layoutObListView.m3305b();
                if (offsetForHorizontal >= i && offsetForHorizontal < i2 && !z) {
                    this.f3972a = true;
                    this.f3973b = motionEvent.getX();
                    this.f3974c = motionEvent.getY();
                    this.f3975d = System.currentTimeMillis();
                    return true;
                }
            }
        } else if (motionEvent.getAction() != 2 && motionEvent.getAction() == 1) {
            if (this.f3972a) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (Math.abs(x - this.f3973b) < 32.0f && Math.abs(y - this.f3974c) < 32.0f && jCurrentTimeMillis - this.f3975d < 500) {
                    EditTextRememberCursor editTextRememberCursor = this.f3976e;
                    ((InputMethodManager) ((Context) editTextRememberCursor.f3954c.get()).getSystemService("input_method")).showSoftInput(editTextRememberCursor, 0);
                    return true;
                }
            }
            this.f3972a = false;
        }
        return false;
    }
}
