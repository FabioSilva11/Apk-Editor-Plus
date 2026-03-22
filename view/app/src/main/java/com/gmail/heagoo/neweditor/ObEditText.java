package com.gmail.heagoo.neweditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.support.v4.view.InputDeviceCompat;
import android.text.DynamicLayout;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class ObEditText extends EditText implements InterfaceC1525s {

    /* JADX INFO: renamed from: a */
    private boolean f4399a;

    /* JADX INFO: renamed from: b */
    private int f4400b;

    /* JADX INFO: renamed from: c */
    private boolean f4401c;

    /* JADX INFO: renamed from: d */
    private int f4402d;

    /* JADX INFO: renamed from: e */
    private boolean f4403e;

    /* JADX INFO: renamed from: f */
    private boolean f4404f;

    /* JADX INFO: renamed from: g */
    private WeakReference f4405g;

    /* JADX INFO: renamed from: h */
    private boolean f4406h;

    public ObEditText(Context context) {
        super(context);
        new BackgroundColorSpan(InputDeviceCompat.SOURCE_ANY);
        this.f4399a = true;
        new Rect();
        new BackgroundColorSpan(InputDeviceCompat.SOURCE_ANY);
        this.f4404f = false;
        this.f4405g = null;
    }

    public ObEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new BackgroundColorSpan(InputDeviceCompat.SOURCE_ANY);
        this.f4399a = true;
        new Rect();
        new BackgroundColorSpan(InputDeviceCompat.SOURCE_ANY);
        this.f4404f = false;
        this.f4405g = null;
    }

    public ObEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new BackgroundColorSpan(InputDeviceCompat.SOURCE_ANY);
        this.f4399a = true;
        new Rect();
        new BackgroundColorSpan(InputDeviceCompat.SOURCE_ANY);
        this.f4404f = false;
        this.f4405g = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m3598a(int i) {
        new BackgroundColorSpan(i);
        new BackgroundColorSpan(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m3599a(int i, int i2) {
        boolean z = this.f4404f;
        this.f4404f = false;
        try {
            setSelection(i, i2);
        } catch (Exception e) {
        }
        this.f4404f = z;
    }

    /* JADX INFO: renamed from: a */
    public final void m3600a(InterfaceC1502ad interfaceC1502ad) {
        this.f4405g = new WeakReference(interfaceC1502ad);
    }

    @Override // com.gmail.heagoo.neweditor.InterfaceC1525s
    /* JADX INFO: renamed from: a */
    public final void mo3303a(boolean z) {
        this.f4406h = z;
    }

    /* JADX INFO: renamed from: b */
    public final int m3601b(int i) {
        if (getLayout() != null) {
            return ((DynamicLayout) getLayout()).getLineForOffset(i);
        }
        return 0;
    }

    @SuppressLint({"WrongCall"})
    /* JADX INFO: renamed from: b */
    public final void m3602b(int i, int i2) {
        onMeasure(i, i2);
    }

    /* JADX INFO: renamed from: b */
    public final void m3603b(boolean z) {
        this.f4403e = z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onCheckIsTextEditor() {
        return this.f4399a;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!PreferenceManager.getDefaultSharedPreferences(getContext()).getBoolean("rawKeys", false)) {
            return super.onCreateInputConnection(editorInfo);
        }
        C1528v c1528v = new C1528v(this, this, false);
        editorInfo.actionLabel = null;
        editorInfo.inputType = 0;
        editorInfo.imeOptions = 1342177280;
        return c1528v;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f4406h) {
            return false;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f4403e) {
            super.onMeasure(i, i2);
            return;
        }
        float fMeasureText = getPaint().measureText("X");
        int lineHeight = getLineHeight();
        String[] strArrSplit = getText().toString().split("\\n");
        int i3 = this.f4400b;
        this.f4400b = 0;
        this.f4402d = strArrSplit.length;
        for (String str : strArrSplit) {
            this.f4400b = Math.max(this.f4400b, str.length());
        }
        if (this.f4402d == 0) {
            this.f4402d = 1;
        }
        this.f4401c = i3 != this.f4400b;
        setMeasuredDimension(Math.max(((int) ((String.valueOf(this.f4402d).length() + this.f4400b) * fMeasureText)) + 10, View.MeasureSpec.getSize(i)), Math.max((this.f4402d * lineHeight) + 10, View.MeasureSpec.getSize(i2)));
        if (this.f4401c) {
            setPaintFlags(getPaintFlags() + 1);
            setPaintFlags(getPaintFlags() - 1);
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        InterfaceC1502ad interfaceC1502ad;
        super.onSelectionChanged(i, i2);
        if (this.f4405g == null || (interfaceC1502ad = (InterfaceC1502ad) this.f4405g.get()) == null) {
            return;
        }
        interfaceC1502ad.mo2630b(i, i2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (getSelectionStart() == getSelectionEnd()) {
            getSelectionStart();
        }
    }

    @Override // android.widget.TextView
    public void setWidth(int i) {
        if (i != 0) {
            super.setWidth(i);
        }
    }
}
