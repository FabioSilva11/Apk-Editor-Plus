package com.p048b.p049a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.b.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0926a extends RelativeLayout implements TextWatcher {

    /* JADX INFO: renamed from: a */
    Handler f2283a;

    /* JADX INFO: renamed from: b */
    private View f2284b;

    /* JADX INFO: renamed from: c */
    private SeekBar f2285c;

    /* JADX INFO: renamed from: d */
    private SeekBar f2286d;

    /* JADX INFO: renamed from: e */
    private SeekBar f2287e;

    /* JADX INFO: renamed from: f */
    private SeekBar f2288f;

    /* JADX INFO: renamed from: g */
    private EditText f2289g;

    /* JADX INFO: renamed from: h */
    private InterfaceC0930e f2290h;

    /* JADX INFO: renamed from: i */
    private int f2291i;

    /* JADX INFO: renamed from: j */
    private int f2292j;

    /* JADX INFO: renamed from: k */
    private SeekBar.OnSeekBarChangeListener f2293k;

    public C0926a(Context context) {
        super(context);
        this.f2284b = null;
        this.f2285c = null;
        this.f2286d = null;
        this.f2287e = null;
        this.f2288f = null;
        this.f2289g = null;
        this.f2290h = null;
        this.f2283a = new HandlerC0928c(this);
        this.f2293k = new C0929d(this);
        if (isInEditMode()) {
            return;
        }
        (getContext() instanceof Activity ? ((Activity) getContext()).getLayoutInflater() : LayoutInflater.from(getContext())).inflate(R.layout.dlg_colormixer, (ViewGroup) this, true);
        this.f2284b = findViewById(R.id.swatch);
        this.f2289g = (EditText) findViewById(R.id.color);
        this.f2289g.addTextChangedListener(this);
        this.f2289g.setFilters(new InputFilter[]{new C0927b(this), new InputFilter.LengthFilter(8)});
        this.f2285c = (SeekBar) findViewById(R.id.red);
        this.f2285c.setMax(255);
        this.f2285c.setOnSeekBarChangeListener(this.f2293k);
        this.f2287e = (SeekBar) findViewById(R.id.green);
        this.f2287e.setMax(255);
        this.f2287e.setOnSeekBarChangeListener(this.f2293k);
        this.f2286d = (SeekBar) findViewById(R.id.blue);
        this.f2286d.setMax(255);
        this.f2286d.setOnSeekBarChangeListener(this.f2293k);
        this.f2288f = (SeekBar) findViewById(R.id.alpha);
        this.f2288f.setMax(255);
        this.f2288f.setOnSeekBarChangeListener(this.f2293k);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2040a(C0926a c0926a, int i) {
        c0926a.f2292j = i;
        String hexString = Integer.toHexString(i);
        c0926a.f2289g.setText(hexString);
        c0926a.f2289g.setSelection(hexString.length());
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ InterfaceC0930e m2042c(C0926a c0926a) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final int m2043a() {
        return Color.argb(this.f2288f.getProgress(), this.f2285c.getProgress(), this.f2287e.getProgress(), this.f2286d.getProgress());
    }

    /* JADX INFO: renamed from: a */
    public final void m2044a(int i) {
        this.f2285c.setProgress(Color.red(i));
        this.f2287e.setProgress(Color.green(i));
        this.f2286d.setProgress(Color.blue(i));
        this.f2288f.setProgress(Color.alpha(i));
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        try {
            String string = this.f2289g.getText().toString();
            Long lValueOf = Long.valueOf(Long.parseLong(string, 16));
            if (lValueOf.intValue() != this.f2292j) {
                if (string.length() <= 6) {
                    lValueOf = Long.valueOf(lValueOf.longValue() | (-16777216));
                }
                int iIntValue = lValueOf.intValue();
                this.f2291i = iIntValue;
                m2044a(iIntValue);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("superState"));
        m2044a(bundle.getInt("color"));
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("color", m2043a());
        return bundle;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
