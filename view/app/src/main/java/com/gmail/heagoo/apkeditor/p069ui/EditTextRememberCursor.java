package com.gmail.heagoo.apkeditor.p069ui;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import com.gmail.heagoo.InterfaceC0968a;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class EditTextRememberCursor extends AppCompatEditText {

    /* JADX INFO: renamed from: a */
    private int f3952a;

    /* JADX INFO: renamed from: b */
    private int f3953b;

    /* JADX INFO: renamed from: c */
    private WeakReference f3954c;

    /* JADX INFO: renamed from: d */
    private WeakReference f3955d;

    /* JADX INFO: renamed from: e */
    private WeakReference f3956e;

    public EditTextRememberCursor(Context context) {
        super(context);
    }

    public EditTextRememberCursor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditTextRememberCursor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    public final void m3299a() {
        setOnTouchListener(new ViewOnTouchListenerC1375c(this));
    }

    /* JADX INFO: renamed from: a */
    public final void m3300a(Context context, WeakReference weakReference) {
        this.f3954c = new WeakReference(context);
        this.f3955d = weakReference;
    }

    /* JADX INFO: renamed from: a */
    public final void m3301a(WeakReference weakReference) {
        this.f3956e = weakReference;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        LayoutObListView layoutObListView;
        if (i != 4 || (layoutObListView = (LayoutObListView) this.f3955d.get()) == null || !layoutObListView.m3305b()) {
            return false;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return true;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        InterfaceC0968a interfaceC0968a;
        if (i != i2 || this.f3955d == null || this.f3955d.get() == null || !((LayoutObListView) this.f3955d.get()).m3304a()) {
            this.f3952a = i;
            this.f3953b = i2;
            Integer num = (Integer) getTag(R.id.text);
            if (num != null) {
                if (this.f3956e != null && (interfaceC0968a = (InterfaceC0968a) this.f3956e.get()) != null) {
                    String strSubstring = "";
                    if (i < i2) {
                        try {
                            strSubstring = getText().toString().substring(i, i2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    num.intValue();
                    interfaceC0968a.mo2116a(i, i2, strSubstring);
                }
                LayoutObListView layoutObListView = (LayoutObListView) this.f3955d.get();
                if (layoutObListView != null) {
                    layoutObListView.m3302a(num.intValue(), i, i2);
                }
            }
        }
    }
}
