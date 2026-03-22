package ru.zeratul.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.internal.view.SupportMenu;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: ru.zeratul.preference.a */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1838a extends FrameLayout implements InterfaceC1839b, TextWatcher, SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private C1840c f4819a;

    /* JADX INFO: renamed from: b */
    private int f4820b;

    /* JADX INFO: renamed from: c */
    private int f4821c;

    /* JADX INFO: renamed from: d */
    private int f4822d;

    /* JADX INFO: renamed from: e */
    private int f4823e;

    /* JADX INFO: renamed from: f */
    private EditText f4824f;

    /* JADX INFO: renamed from: g */
    private SeekBar f4825g;

    /* JADX INFO: renamed from: h */
    private SeekBar f4826h;

    /* JADX INFO: renamed from: i */
    private SeekBar f4827i;

    /* JADX INFO: renamed from: j */
    private SeekBar f4828j;

    /* JADX INFO: renamed from: k */
    private TextView f4829k;

    /* JADX INFO: renamed from: l */
    private TextView f4830l;

    /* JADX INFO: renamed from: m */
    private View f4831m;

    public ViewOnClickListenerC1838a(Context context) {
        this(context, (AttributeSet) null);
    }

    public ViewOnClickListenerC1838a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4819a = new C1840c(0);
        LayoutInflater.from(context).inflate(R.layout.cpv, this);
        this.f4831m = findViewById(R.id.color_view);
        this.f4825g = (SeekBar) findViewById(R.id.alpha);
        this.f4826h = (SeekBar) findViewById(R.id.red);
        this.f4827i = (SeekBar) findViewById(R.id.green);
        this.f4828j = (SeekBar) findViewById(R.id.blue);
        m3945b(this.f4825g, -7829368);
        m3945b(this.f4826h, SupportMenu.CATEGORY_MASK);
        m3945b(this.f4827i, -16711936);
        m3945b(this.f4828j, -16776961);
        this.f4829k = (TextView) findViewById(R.id.textView1);
        this.f4829k.setOnClickListener(this);
        this.f4830l = (TextView) findViewById(R.id.textView2);
        this.f4830l.setOnClickListener(this);
        this.f4824f = (EditText) findViewById(R.id.color);
        this.f4824f.addTextChangedListener(this);
        this.f4819a.m3954a(this);
        this.f4824f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.f4824f.setText(this.f4824f.getText());
    }

    /* JADX INFO: renamed from: b */
    private void m3945b(SeekBar seekBar, int i) {
        seekBar.getThumb().setColorFilter(i, PorterDuff.Mode.SRC_IN);
        seekBar.getProgressDrawable().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        seekBar.setOnSeekBarChangeListener(this);
    }

    /* JADX INFO: renamed from: c */
    private static String m3946c(int i, int i2, int i3, int i4) {
        return String.format("%02x%02x%02x%02x", new Integer(m3947d(i)), new Integer(m3947d(i2)), new Integer(m3947d(i3)), new Integer(m3947d(i4)));
    }

    /* JADX INFO: renamed from: d */
    private static int m3947d(int i) {
        if (i < 0 || i > 255) {
            return 0;
        }
        return i;
    }

    /* JADX INFO: renamed from: f */
    static int m3948f(CharSequence charSequence) {
        try {
            return (int) (Long.parseLong(charSequence.toString(), 16) & 4294967295L);
        } catch (NumberFormatException e) {
            return -7829368;
        }
    }

    /* JADX INFO: renamed from: g */
    private void m3949g(TextView textView) {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("copied", textView.getText().toString()));
        Toast.makeText(getContext(), textView.getText().toString() + " " + getContext().getString(R.string.toast_clipboard).toLowerCase(), 0).show();
    }

    @Override // ru.zeratul.preference.InterfaceC1839b
    /* JADX INFO: renamed from: a */
    public void mo3950a(C1840c c1840c) {
        this.f4824f.setText(String.format("%08x", Integer.valueOf(c1840c.m3956c())));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: renamed from: e */
    public String m3951e(String str) {
        new String();
        if (str.length() == 6) {
            str = "ff" + str;
        }
        int color = Color.parseColor("#" + str);
        return Integer.parseInt(str.substring(0, 2), 16) >= 128 ? "-0x" + Integer.toHexString(color * (-1)) : "0x" + Integer.toHexString(color);
    }

    /* JADX INFO: renamed from: h */
    public void m3952h(int i) {
        this.f4819a.m3955b(i, (InterfaceC1839b) null);
    }

    /* JADX INFO: renamed from: i */
    public int m3953i() {
        return this.f4819a.m3956c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView1 /* 2131558467 */:
                m3949g(this.f4829k);
                break;
            case R.id.textView2 /* 2131558683 */:
                m3949g(this.f4830l);
                break;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (seekBar.getId() == R.id.alpha) {
            this.f4820b = i;
        } else if (seekBar.getId() == R.id.red) {
            this.f4821c = i;
        } else if (seekBar.getId() == R.id.green) {
            this.f4822d = i;
        } else if (seekBar.getId() == R.id.blue) {
            this.f4823e = i;
        }
        this.f4824f.setText(m3946c(this.f4820b, this.f4821c, this.f4822d, this.f4823e));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f4819a.m3955b(m3948f(charSequence), this);
        String string = charSequence.toString();
        try {
            if (string.length() == 8) {
                try {
                    int color = Color.parseColor(new StringBuffer().append('#').append(string).toString());
                    this.f4820b = Color.alpha(color);
                    this.f4821c = Color.red(color);
                    this.f4822d = Color.green(color);
                    this.f4823e = Color.blue(color);
                    this.f4831m.setBackgroundColor(m3953i());
                    this.f4829k.setText(m3951e(m3946c(this.f4820b, this.f4821c, this.f4822d, this.f4823e)));
                    this.f4830l.setText(String.valueOf(m3953i()));
                    this.f4825g.setProgress(this.f4820b);
                    this.f4826h.setProgress(this.f4821c);
                    this.f4827i.setProgress(this.f4822d);
                    this.f4828j.setProgress(this.f4823e);
                } catch (IllegalArgumentException e) {
                }
                this.f4824f.setSelection(this.f4824f.getText().length());
                this.f4824f.requestFocus();
            }
        } catch (Exception e2) {
        }
    }
}
