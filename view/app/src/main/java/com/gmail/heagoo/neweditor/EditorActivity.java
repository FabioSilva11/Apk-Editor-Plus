package com.gmail.heagoo.neweditor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewAnimator;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.DialogC1484p;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class EditorActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: d */
    private static int f4350d = 300;

    /* JADX INFO: renamed from: e */
    private static int f4351e = 300;

    /* JADX INFO: renamed from: f */
    private static int f4352f = 400;

    /* JADX INFO: renamed from: g */
    private static int f4353g = 100;

    /* JADX INFO: renamed from: A */
    private EditText f4354A;

    /* JADX INFO: renamed from: B */
    private ImageButton f4355B;

    /* JADX INFO: renamed from: C */
    private ImageButton f4356C;

    /* JADX INFO: renamed from: D */
    private ImageView f4357D;

    /* JADX INFO: renamed from: E */
    private ImageView f4358E;

    /* JADX INFO: renamed from: F */
    private ImageView f4359F;

    /* JADX INFO: renamed from: G */
    private ToggleButton f4360G;

    /* JADX INFO: renamed from: H */
    private ToggleButton f4361H;

    /* JADX INFO: renamed from: I */
    private LinearLayout f4362I;

    /* JADX INFO: renamed from: J */
    private ImageView f4363J;

    /* JADX INFO: renamed from: K */
    private ScrollView f4364K;

    /* JADX INFO: renamed from: L */
    private String f4365L;

    /* JADX INFO: renamed from: M */
    private String f4366M;

    /* JADX INFO: renamed from: N */
    private String f4367N;

    /* JADX INFO: renamed from: O */
    private boolean f4368O;

    /* JADX INFO: renamed from: P */
    private C1511e f4369P;

    /* JADX INFO: renamed from: R */
    private int f4371R;

    /* JADX INFO: renamed from: U */
    private int f4374U;

    /* JADX INFO: renamed from: V */
    private int f4375V;

    /* JADX INFO: renamed from: W */
    private int f4376W;

    /* JADX INFO: renamed from: a */
    protected ObEditText f4377a;

    /* JADX INFO: renamed from: b */
    public int f4378b;

    /* JADX INFO: renamed from: m */
    private int f4385m;

    /* JADX INFO: renamed from: r */
    private boolean f4390r;

    /* JADX INFO: renamed from: s */
    private LinearLayout f4391s;

    /* JADX INFO: renamed from: t */
    private FrameLayout f4392t;

    /* JADX INFO: renamed from: u */
    private EditText f4393u;

    /* JADX INFO: renamed from: v */
    private View f4394v;

    /* JADX INFO: renamed from: w */
    private ObScrollView f4395w;

    /* JADX INFO: renamed from: x */
    private ViewAnimator f4396x;

    /* JADX INFO: renamed from: y */
    private SlidingDrawer f4397y;

    /* JADX INFO: renamed from: z */
    private EditText f4398z;

    /* JADX INFO: renamed from: h */
    private boolean f4380h = true;

    /* JADX INFO: renamed from: i */
    private boolean f4381i = false;

    /* JADX INFO: renamed from: j */
    private int f4382j = -1;

    /* JADX INFO: renamed from: k */
    private int f4383k = -1;

    /* JADX INFO: renamed from: l */
    private boolean f4384l = true;

    /* JADX INFO: renamed from: n */
    private int f4386n = 50;

    /* JADX INFO: renamed from: o */
    private Handler f4387o = new Handler();

    /* JADX INFO: renamed from: p */
    private C1524r f4388p = new C1524r(this);

    /* JADX INFO: renamed from: q */
    private C1522p f4389q = new C1522p(this);

    /* JADX INFO: renamed from: Q */
    private boolean f4370Q = true;

    /* JADX INFO: renamed from: S */
    private boolean f4372S = false;

    /* JADX INFO: renamed from: T */
    private boolean f4373T = false;

    /* JADX INFO: renamed from: c */
    protected boolean f4379c = false;

    /* JADX INFO: renamed from: a */
    static /* synthetic */ int m3565a(EditorActivity editorActivity, int i) {
        editorActivity.f4383k = -1;
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private void m3566a(int i) {
        int i2 = i <= 40 ? i : 40;
        int i3 = i2 >= 4 ? i2 : 4;
        this.f4377a.setTextSize(2, i3);
        this.f4393u.setTextSize(2, i3);
        this.f4371R = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m3568a(boolean z, int i) {
        if (z && i == this.f4371R) {
            return;
        }
        this.f4370Q = z;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4393u.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f4394v.getLayoutParams();
        if (z) {
            this.f4393u.setVisibility(0);
            this.f4394v.setVisibility(0);
            String str = "";
            for (int i2 = 0; i2 < i; i2++) {
                str = String.valueOf(str) + "9";
            }
            this.f4371R = i;
            layoutParams.width = ((int) this.f4377a.getPaint().measureText(str)) + ((int) TypedValue.applyDimension(1, 6.0f, getResources().getDisplayMetrics()));
            layoutParams2.width = 1;
        } else {
            this.f4393u.setVisibility(8);
            this.f4394v.setVisibility(8);
            layoutParams.width = 0;
            layoutParams2.width = 0;
            this.f4371R = 0;
        }
        this.f4393u.requestLayout();
        this.f4394v.requestLayout();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m3570a(EditorActivity editorActivity, boolean z) {
        editorActivity.f4381i = false;
        return false;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ int m3571b(EditorActivity editorActivity, int i) {
        editorActivity.f4382j = -1;
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public boolean m3575c(boolean z) {
        if (this.f4398z.getText().toString().equals("")) {
            return false;
        }
        if (m3579e()) {
            this.f4377a.requestFocus();
            return true;
        }
        int selectionStart = this.f4377a.getSelectionStart();
        int selectionEnd = this.f4377a.getSelectionEnd();
        this.f4377a.setSelection(0);
        if (m3579e()) {
            this.f4377a.requestFocus();
            return true;
        }
        this.f4377a.setSelection(selectionStart, selectionEnd);
        if (!z) {
            return false;
        }
        Toast.makeText(getApplicationContext(), getString(this.f4376W), 0).show();
        return false;
    }

    /* JADX INFO: renamed from: d */
    private void m3577d(boolean z) {
        if (!z) {
            this.f4377a.setMaxWidth(((this.f4391s.getWidth() - this.f4393u.getWidth()) - this.f4394v.getWidth()) - this.f4397y.getWidth());
            return;
        }
        int width = this.f4391s.getWidth();
        int width2 = this.f4393u.getWidth();
        int width3 = this.f4394v.getWidth();
        this.f4377a.setMaxWidth(((width - width2) - width3) - this.f4363J.getWidth());
    }

    /* JADX INFO: renamed from: e */
    private boolean m3579e() {
        int i = this.f4360G.isChecked() ? 10 : 8;
        if (this.f4361H != null && !this.f4361H.isChecked()) {
            i |= 16;
        }
        try {
            Matcher matcher = Pattern.compile(this.f4398z.getText().toString(), i).matcher(this.f4369P.m3642a().toString());
            if (matcher.find(this.f4377a.getSelectionEnd())) {
                this.f4377a.setSelection(matcher.start(), matcher.end());
                return true;
            }
            this.f4377a.setSelection(this.f4377a.getSelectionEnd());
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: i */
    static /* synthetic */ void m3583i(EditorActivity editorActivity) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) editorActivity.f4362I.getLayoutParams();
        layoutParams.setMargins(0, 0, editorActivity.f4397y.getWidth(), layoutParams.bottomMargin);
        editorActivity.f4362I.requestLayout();
        if (editorActivity.f4384l) {
            editorActivity.m3577d(true);
            editorActivity.m3593a(false);
        }
        editorActivity.f4363J.setImageResource(R.drawable.edit_slide_right);
    }

    /* JADX INFO: renamed from: j */
    static /* synthetic */ void m3584j(EditorActivity editorActivity) {
        editorActivity.f4397y.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) editorActivity.f4362I.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, layoutParams.bottomMargin);
        editorActivity.f4362I.requestLayout();
        if (editorActivity.f4384l) {
            editorActivity.m3577d(false);
            editorActivity.m3593a(false);
        }
        editorActivity.f4363J.setImageResource(R.drawable.edit_slide_left);
        editorActivity.f4396x.setDisplayedChild(0);
    }

    /* JADX INFO: renamed from: l */
    static /* synthetic */ void m3586l(EditorActivity editorActivity) {
        try {
            int iMin = Math.min(editorActivity.f4377a.getSelectionStart(), editorActivity.f4377a.getSelectionEnd());
            int iMax = Math.max(editorActivity.f4377a.getSelectionStart(), editorActivity.f4377a.getSelectionEnd());
            if (iMin != iMax) {
                String string = editorActivity.f4377a.getText().subSequence(iMin, iMax).toString();
                String string2 = editorActivity.f4398z.getText().toString();
                if ((editorActivity.f4360G.isChecked() ? Pattern.compile(string2, 10) : Pattern.compile(string2)).matcher(string).matches()) {
                    editorActivity.f4356C.setEnabled(true);
                    return;
                }
            }
        } catch (Exception e) {
        }
        editorActivity.f4356C.setEnabled(false);
    }

    /* JADX INFO: renamed from: a */
    protected final synchronized void m3591a() {
        boolean zM3650b = this.f4369P.m3650b();
        if (this.f4373T != zM3650b) {
            if (zM3650b) {
                this.f4358E.getDrawable().setAlpha(255);
                this.f4358E.setClickable(true);
            } else {
                this.f4358E.getDrawable().setAlpha(80);
                this.f4358E.setClickable(false);
            }
            this.f4358E.invalidate();
            this.f4373T = zM3650b;
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m3592a(int i, int i2, boolean z) {
        if (this.f4380h) {
            if (this.f4383k == -1 || i < this.f4383k) {
                this.f4383k = i;
            }
            if (this.f4382j == -1 || i2 > this.f4382j) {
                this.f4382j = i2;
            }
            this.f4381i = z;
            this.f4387o.removeCallbacks(this.f4389q);
            if (this.f4390r) {
                this.f4387o.postDelayed(this.f4389q, f4350d);
            } else if (z) {
                this.f4387o.postDelayed(this.f4389q, f4352f);
            } else {
                this.f4387o.postDelayed(this.f4389q, f4353g);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m3593a(boolean z) {
        if (!this.f4370Q) {
            this.f4378b = this.f4377a.getLineCount();
            return;
        }
        this.f4387o.removeCallbacks(this.f4388p);
        if (z) {
            this.f4387o.postDelayed(this.f4388p, f4351e);
        } else {
            this.f4387o.postDelayed(this.f4388p, 0L);
        }
    }

    /* JADX INFO: renamed from: b */
    protected final synchronized void m3594b() {
    }

    /* JADX INFO: renamed from: b */
    protected final void m3595b(boolean z) {
        C1511e c1511e = this.f4369P;
        this.f4390r = true;
        this.f4377a.setText(c1511e.m3642a());
        this.f4390r = false;
        Handler handler = new Handler();
        this.f4377a.m3599a(0, 0);
        handler.postDelayed(new RunnableC1513g(this, c1511e), 400L);
        m3593a(true);
        m3594b();
        m3591a();
    }

    /* JADX INFO: renamed from: c */
    protected final void m3596c() {
        C0985a.m2190a("com.gmail.heagoo.appdm.util.FileCopyUtil", "copyBack", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}, new Object[]{this, this.f4365L, this.f4366M, Boolean.valueOf(this.f4368O)});
    }

    /* JADX INFO: renamed from: d */
    protected final void m3597d() {
        Intent intent = new Intent();
        intent.putExtra("xmlPath", this.f4365L);
        setResult(1, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.openFindBtn) {
            if (id == R.id.findBtn) {
                m3575c(true);
                return;
            }
            if (id == R.id.replaceBtn) {
                this.f4377a.getEditableText().replace(this.f4377a.getSelectionStart(), this.f4377a.getSelectionEnd(), this.f4354A.getText());
                m3575c(true);
                return;
            } else {
                if (id == R.id.saveBtn) {
                    new DialogC1484p(this, new C1521o(this), this.f4375V).show();
                    return;
                }
                return;
            }
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (Build.VERSION.SDK_INT >= 11) {
            defaultSharedPreferences.getBoolean("hideDocumentList", false);
        }
        if (this.f4397y.getVisibility() == 8) {
            this.f4397y.animateOpen();
            this.f4397y.setVisibility(0);
        } else {
            this.f4397y.close();
            this.f4397y.setVisibility(8);
            this.f4377a.requestFocus();
        }
        int iMin = Math.min(this.f4377a.getSelectionStart(), this.f4377a.getSelectionEnd());
        int iMax = Math.max(this.f4377a.getSelectionStart(), this.f4377a.getSelectionEnd());
        if (iMin < iMax) {
            String string = this.f4377a.getText().subSequence(iMin, iMax).toString();
            if (!string.contains("\n")) {
                this.f4398z.setText(string);
            }
        }
        this.f4398z.requestFocus();
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        String strSubstring;
        int iLastIndexOf;
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        this.f4384l = true;
        if (this.f4384l) {
            setContentView(R.layout.editorutil_main);
        } else {
            setContentView(R.layout.editorutil_main);
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.f4365L = extras.getString("filePath");
            this.f4366M = extras.getString("realFilePath");
            this.f4367N = extras.getString("syntaxFileName");
            this.f4368O = extras.getBoolean("isRootMode");
            int[] intArray = extras.getIntArray("resourceIds");
            this.f4374U = intArray[0];
            this.f4375V = intArray[1];
            this.f4376W = intArray[2];
            if (bundle != null) {
                this.f4379c = bundle.getBoolean("modifySaved", false);
                if (this.f4379c) {
                    m3597d();
                }
            }
            this.f4369P = new C1511e(this, new File(this.f4365L), this.f4367N);
            try {
                this.f4369P.m3644a(this, this.f4365L, this.f4374U);
            } catch (IOException e) {
                Toast.makeText(this, "Failed to open " + this.f4365L, 1).show();
                e.printStackTrace();
            }
            TextView textView = (TextView) findViewById(R.id.filename);
            if (this.f4366M == null || (iLastIndexOf = this.f4366M.lastIndexOf(47)) == -1) {
                int iLastIndexOf2 = this.f4365L.lastIndexOf(47);
                strSubstring = iLastIndexOf2 != -1 ? this.f4365L.substring(iLastIndexOf2 + 1) : this.f4365L;
            } else {
                strSubstring = this.f4366M.substring(iLastIndexOf + 1);
            }
            textView.setText(strSubstring);
            findViewById(R.id.editorView);
            this.f4391s = (LinearLayout) findViewById(R.id.editorLayout);
            this.f4392t = (FrameLayout) findViewById(R.id.center_layout);
            this.f4393u = (EditText) findViewById(R.id.lineNumbers);
            this.f4377a = (ObEditText) findViewById(R.id.editor);
            this.f4394v = findViewById(R.id.divider);
            this.f4395w = (ObScrollView) findViewById(R.id.editorScrollview);
            this.f4396x = (ViewAnimator) findViewById(R.id.searchAnimator);
            this.f4397y = (SlidingDrawer) findViewById(R.id.sliding_drawer);
            this.f4398z = (EditText) findViewById(R.id.findEdit);
            this.f4354A = (EditText) findViewById(R.id.replaceEdit);
            this.f4355B = (ImageButton) findViewById(R.id.findBtn);
            this.f4356C = (ImageButton) findViewById(R.id.replaceBtn);
            this.f4357D = (ImageView) findViewById(R.id.openFindBtn);
            this.f4360G = (ToggleButton) findViewById(R.id.checkBoxIgnoreCase);
            this.f4361H = (ToggleButton) findViewById(R.id.checkBoxRegexp);
            this.f4358E = (ImageView) findViewById(R.id.saveBtn);
            this.f4359F = (ImageView) findViewById(R.id.configBtn);
            this.f4362I = this.f4391s;
            this.f4363J = (ImageView) findViewById(R.id.panel_button);
            this.f4356C = (ImageButton) findViewById(R.id.replaceBtn);
            this.f4364K = this.f4395w;
            this.f4377a.m3603b(this.f4384l);
            this.f4377a.setInputType(721041);
            this.f4385m = 12;
            m3566a(this.f4385m);
            String strM3642a = this.f4369P.m3642a();
            if (strM3642a != null) {
                this.f4377a.setText(strM3642a);
                m3592a(0, strM3642a.length(), true);
            }
            this.f4357D.setOnClickListener(this);
            this.f4355B.setOnClickListener(this);
            this.f4356C.setOnClickListener(this);
            this.f4358E.setOnClickListener(this);
            this.f4359F.setOnClickListener(this);
            this.f4358E.getDrawable().setAlpha(80);
            this.f4358E.setClickable(false);
            this.f4356C.setEnabled(false);
            C1509c c1509c = new C1509c(this);
            this.f4391s.setBackgroundColor(c1509c.m3632a());
            this.f4392t.setBackgroundColor(c1509c.m3632a());
            this.f4393u.setBackgroundColor(c1509c.m3632a());
            this.f4377a.setBackgroundColor(c1509c.m3632a());
            this.f4377a.setTextColor(c1509c.m3634b());
            this.f4393u.setTextColor(c1509c.m3634b());
            this.f4394v.setBackgroundColor(c1509c.m3634b());
            ObEditText obEditText = this.f4377a;
            int iM3632a = c1509c.m3632a();
            obEditText.m3598a(Color.argb(128, 255 - Color.red(iM3632a), 255 - Color.green(iM3632a), 255 - Color.blue(iM3632a)));
            this.f4393u.setOnLongClickListener(null);
        } catch (Exception e2) {
            Toast.makeText(this, "failed", 0).show();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f4397y.setOnDrawerOpenListener(new C1514h(this));
        this.f4397y.setOnDrawerCloseListener(new C1515i(this));
        this.f4377a.m3600a(new C1516j(this));
        this.f4377a.addTextChangedListener(new C1517k(this));
        this.f4395w.m3604a(new C1518l(this));
        this.f4398z.setOnKeyListener(new ViewOnKeyListenerC1519m(this));
        this.f4354A.setOnKeyListener(new ViewOnKeyListenerC1520n(this));
        if (this.f4385m != 12) {
            this.f4385m = 12;
            m3566a(12);
        }
        m3568a(true, C1524r.m3653a(this.f4369P.m3642a().split("\n").length + 1));
        new Handler().postDelayed(new RunnableC1512f(this), 400L);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("modifySaved", this.f4379c);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
