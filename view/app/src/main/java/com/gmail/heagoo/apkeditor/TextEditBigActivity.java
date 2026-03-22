package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewAnimator;
import com.gmail.heagoo.InterfaceC0968a;
import com.gmail.heagoo.apkeditor.p069ui.LayoutObListView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.InterfaceC1477i;
import com.gmail.heagoo.neweditor.C1509c;
import com.gmail.heagoo.neweditor.C1511e;
import com.gmail.heagoo.neweditor.InterfaceC1525s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class TextEditBigActivity extends AbstractActivityC1258gy implements TextWatcher, View.OnClickListener, InterfaceC0968a {

    /* JADX INFO: renamed from: A */
    private ToggleButton f2728A;

    /* JADX INFO: renamed from: B */
    private ToggleButton f2729B;

    /* JADX INFO: renamed from: C */
    private ImageView f2730C;

    /* JADX INFO: renamed from: D */
    private boolean f2731D;

    /* JADX INFO: renamed from: E */
    private boolean f2732E;

    /* JADX INFO: renamed from: F */
    private TextView f2733F;

    /* JADX INFO: renamed from: G */
    private View f2734G;

    /* JADX INFO: renamed from: H */
    private View f2735H;

    /* JADX INFO: renamed from: I */
    private View f2736I;

    /* JADX INFO: renamed from: J */
    private int f2737J;

    /* JADX INFO: renamed from: K */
    private C1283hw f2738K;

    /* JADX INFO: renamed from: L */
    private String f2739L;

    /* JADX INFO: renamed from: k */
    private int f2740k;

    /* JADX INFO: renamed from: l */
    private FrameLayout f2741l;

    /* JADX INFO: renamed from: m */
    private ViewAnimator f2742m;

    /* JADX INFO: renamed from: n */
    private SlidingDrawer f2743n;

    /* JADX INFO: renamed from: o */
    private EditText f2744o;

    /* JADX INFO: renamed from: p */
    private EditText f2745p;

    /* JADX INFO: renamed from: q */
    private ImageButton f2746q;

    /* JADX INFO: renamed from: r */
    private ImageButton f2747r;

    /* JADX INFO: renamed from: s */
    private ImageButton f2748s;

    /* JADX INFO: renamed from: t */
    private ImageButton f2749t;

    /* JADX INFO: renamed from: u */
    private EditText f2750u;

    /* JADX INFO: renamed from: v */
    private ImageView f2751v;

    /* JADX INFO: renamed from: w */
    private ImageView f2752w;

    /* JADX INFO: renamed from: x */
    private ImageView f2753x;

    /* JADX INFO: renamed from: y */
    private ImageView f2754y;

    /* JADX INFO: renamed from: z */
    private ImageView f2755z;

    public TextEditBigActivity() {
        super(true, false);
        this.f2731D = false;
        this.f2732E = false;
        this.f2739L = "";
    }

    /* JADX INFO: renamed from: a */
    private void m2569a(int i, int i2, int i3) {
        this.f2738K.m3161a(i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    private static void m2570a(ImageView imageView, boolean z) {
        if (z) {
            imageView.getDrawable().setAlpha(255);
            imageView.setClickable(true);
        } else {
            imageView.getDrawable().setAlpha(80);
            imageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2572a(InterfaceC1477i interfaceC1477i) {
        new DialogC1201ey(this, new C1273hm(this, interfaceC1477i), R.string.file_saved).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m2574a(boolean z) {
        if (this.f2744o.getText().toString().equals("")) {
            return false;
        }
        if (!m2576b(this.f2738K.m3158a(), this.f2738K.m3170c()) && !m2576b(0, 0)) {
            if (!z) {
                return false;
            }
            Toast.makeText(getApplicationContext(), getString(R.string.not_found), 0).show();
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    private boolean m2576b(int i, int i2) {
        Matcher matcher;
        if (i < 0) {
            i = 0;
        }
        int i3 = this.f2728A.isChecked() ? 10 : 8;
        int i4 = (this.f2729B == null || this.f2729B.isChecked()) ? i3 : i3 | 16;
        try {
            List listM3174e = this.f2738K.m3174e();
            String str = (String) listM3174e.get(i);
            Pattern patternCompile = Pattern.compile(this.f2744o.getText().toString(), i4);
            Matcher matcher2 = patternCompile.matcher(str);
            if (matcher2.find(i2)) {
                m2569a(i, matcher2.start(), matcher2.end());
                return true;
            }
            do {
                i++;
                if (i >= listM3174e.size()) {
                    return false;
                }
                matcher = patternCompile.matcher((CharSequence) listM3174e.get(i));
            } while (!matcher.find());
            m2569a(i, matcher.start(), matcher.end());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2579d(int i) {
        byte b2 = 0;
        if (this.f3583j.m3650b()) {
            new AlertDialog.Builder(this).setMessage(R.string.save_changes_tip).setPositiveButton(R.string.save, new DialogInterfaceOnClickListenerC1271hk(this, i)).setNegativeButton(R.string.donot_save, new DialogInterfaceOnClickListenerC1270hj(this, i)).setNeutralButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
        } else {
            this.f3578e += i;
            new AsyncTaskC1278hr(this, b2).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m2581e() {
        try {
            String str = this.f2739L;
            if (str != null && !"".equals(str)) {
                String string = this.f2744o.getText().toString();
                if ((this.f2728A.isChecked() ? Pattern.compile(string, 10) : Pattern.compile(string)).matcher(str).matches()) {
                    this.f2747r.setEnabled(true);
                    this.f2748s.setEnabled(true);
                    return;
                }
            }
        } catch (Exception e) {
        }
        this.f2747r.setEnabled(false);
        this.f2748s.setEnabled(false);
    }

    /* JADX INFO: renamed from: e */
    private void m2582e(int i) {
        this.f2738K.m3160a(2, (i <= 40 ? i : 40) >= 4 ? r1 : 4);
    }

    /* JADX INFO: renamed from: f */
    static /* synthetic */ void m2583f(TextEditBigActivity textEditBigActivity) {
        if (textEditBigActivity.f2737J > 0) {
            textEditBigActivity.f2738K.m3171c(textEditBigActivity.f2737J - 1);
        }
    }

    /* JADX INFO: renamed from: g */
    static /* synthetic */ void m2584g(TextEditBigActivity textEditBigActivity) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textEditBigActivity.f2738K.m3177h();
        layoutParams.setMargins(0, 0, textEditBigActivity.f2743n.getWidth(), layoutParams.bottomMargin);
        textEditBigActivity.f2738K.m3176g();
        textEditBigActivity.f2730C.setImageResource(R.drawable.edit_slide_right);
    }

    /* JADX INFO: renamed from: h */
    static /* synthetic */ void m2585h(TextEditBigActivity textEditBigActivity) {
        textEditBigActivity.f2743n.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textEditBigActivity.f2738K.m3177h();
        layoutParams.setMargins(0, 0, 0, layoutParams.bottomMargin);
        textEditBigActivity.f2738K.m3176g();
        textEditBigActivity.f2730C.setImageResource(R.drawable.edit_slide_left);
        textEditBigActivity.f2742m.setDisplayedChild(0);
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractActivityC1258gy, com.gmail.heagoo.apkeditor.InterfaceC1139dn
    /* JADX INFO: renamed from: a */
    public final void mo2588a(int i, int i2) {
        boolean z;
        boolean z2 = false;
        if (this.f3582i == 2) {
            String[] strArrSplit = this.f2738K.m3173d().toString().split("\n");
            if (i <= 0) {
                i = 1;
            }
            if (i2 > strArrSplit.length) {
                i2 = strArrSplit.length;
            }
            if (i <= i2) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 1; i3 < i; i3++) {
                    arrayList.add(strArrSplit[i3 - 1]);
                }
                for (int i4 = i2 + 1; i4 <= strArrSplit.length; i4++) {
                    arrayList.add(strArrSplit[i4 - 1]);
                }
                this.f2738K.m3166a(arrayList);
                Toast.makeText(this, String.format(getString(R.string.n_lines_deleted), Integer.valueOf((i2 - i) + 1)), 1).show();
                z = true;
            } else {
                z = false;
            }
            z2 = z;
        } else if (this.f3582i == 5) {
            String[] strArrSplit2 = this.f2738K.m3173d().toString().split("\n");
            if (i <= 0) {
                i = 1;
            }
            if (i2 > strArrSplit2.length) {
                i2 = strArrSplit2.length;
            }
            if (i <= i2) {
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 1; i5 < i; i5++) {
                    arrayList2.add(strArrSplit2[i5 - 1]);
                }
                boolean zA = m3122a(strArrSplit2, i, i2, "#");
                if (zA) {
                    for (int i6 = i; i6 <= i2; i6++) {
                        int iIndexOf = strArrSplit2[i6 - 1].indexOf(35);
                        if (iIndexOf > 0) {
                            arrayList2.add(strArrSplit2[i6 - 1].substring(0, iIndexOf) + strArrSplit2[i6 - 1].substring(iIndexOf + 1));
                        } else {
                            arrayList2.add(strArrSplit2[i6 - 1].substring(iIndexOf + 1));
                        }
                    }
                } else {
                    for (int i7 = i; i7 <= i2; i7++) {
                        arrayList2.add("#" + strArrSplit2[i7 - 1]);
                    }
                }
                for (int i8 = i2 + 1; i8 <= strArrSplit2.length; i8++) {
                    arrayList2.add(strArrSplit2[i8 - 1]);
                }
                this.f2738K.m3166a(arrayList2);
                Toast.makeText(this, String.format(zA ? getString(R.string.n_lines_uncommented) : getString(R.string.n_lines_commented), Integer.valueOf((i2 - i) + 1)), 1).show();
                z2 = true;
            }
        }
        if (z2) {
            this.f3583j.m3649a(true);
            m2591d();
        }
    }

    @Override // com.gmail.heagoo.InterfaceC0968a
    /* JADX INFO: renamed from: a */
    public final void mo2116a(int i, int i2, String str) {
        this.f2739L = str;
        if (i == i2) {
            m2570a(this.f2753x, false);
        } else {
            m2570a(this.f2753x, true);
        }
        if (this.f2743n.isOpened()) {
            m2581e();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f3583j.m3649a(true);
        m2591d();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1251gr
    /* JADX INFO: renamed from: b */
    public final void mo2589b(int i) {
        if (i > 0) {
            this.f2750u.setText("");
            this.f2738K.m3171c(i - 1);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractActivityC1258gy
    /* JADX INFO: renamed from: c */
    protected final void mo2590c(int i) {
        Editable editableM3175f;
        if (this.f2738K == null || (editableM3175f = this.f2738K.m3175f()) == null) {
            return;
        }
        editableM3175f.replace(this.f2738K.m3168b(), this.f2738K.m3170c(), new StringBuilder().append(m3139b((String) null).charAt(i)).toString());
    }

    /* JADX INFO: renamed from: d */
    protected final synchronized void m2591d() {
        boolean zM3650b;
        C1511e c1511e = this.f3583j;
        if (c1511e != null && this.f2732E != (zM3650b = c1511e.m3650b())) {
            if (zM3650b) {
                m2570a(this.f2752w, true);
            } else {
                m2570a(this.f2752w, false);
            }
            this.f2752w.invalidate();
            this.f2732E = zM3650b;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f3583j.m3650b()) {
            new AlertDialog.Builder(this).setMessage(R.string.save_changes_tip).setPositiveButton(R.string.save, new DialogInterfaceOnClickListenerC1275ho(this)).setNegativeButton(R.string.donot_save, new DialogInterfaceOnClickListenerC1274hn(this)).setNeutralButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int size;
        int iM3168b;
        int iM3170c;
        EditText editTextM3172d;
        int id = view.getId();
        if (id == R.id.menu_next) {
            m2579d(1);
            return;
        }
        if (id == R.id.menu_previous) {
            m2579d(-1);
            return;
        }
        if (id == R.id.moreBtn) {
            m3136a(view);
            return;
        }
        if (id == R.id.openFindBtn) {
            if (this.f2743n.getVisibility() == 8) {
                this.f2743n.animateOpen();
                this.f2743n.setVisibility(0);
            } else {
                this.f2743n.close();
                this.f2743n.setVisibility(8);
            }
            String str = this.f2739L;
            if (str == null || "".equals(str)) {
                if (this.f3574a != null && "".equals(this.f2744o.getText().toString())) {
                    this.f2744o.setText(this.f3574a);
                }
            } else if (!str.contains("\n")) {
                this.f2744o.setText(str);
            }
            this.f2744o.requestFocus();
            return;
        }
        if (id == R.id.findBtn) {
            m2574a(true);
            return;
        }
        if (id == R.id.replaceBtn) {
            C1283hw c1283hw = this.f2738K;
            String string = this.f2745p.getText().toString();
            int iM3158a = c1283hw.m3158a();
            if (iM3158a >= 0 && (iM3168b = c1283hw.m3168b()) != (iM3170c = c1283hw.m3170c()) && (editTextM3172d = c1283hw.m3172d(iM3158a)) != null) {
                editTextM3172d.getEditableText().replace(iM3168b, iM3170c, string);
            }
            m2574a(true);
            return;
        }
        if (id != R.id.replaceAllBtn) {
            if (id == R.id.goBtn) {
                String strTrim = this.f2750u.getText().toString().trim();
                if (!strTrim.equals("")) {
                    try {
                        mo2589b(Integer.valueOf(strTrim).intValue());
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                C1283hw c1283hw2 = this.f2738K;
                EditText editTextM3172d2 = c1283hw2.m3172d(c1283hw2.m3158a());
                if (editTextM3172d2 != null) {
                    editTextM3172d2.getText().insert(editTextM3172d2.getSelectionStart(), "\n");
                    return;
                }
                return;
            }
            if (id == R.id.saveBtn) {
                m2572a((InterfaceC1477i) null);
                return;
            }
            if (id == R.id.copyBtn) {
                String str2 = this.f2739L;
                if (str2 == null || str2.equals("")) {
                    return;
                }
                C0985a.m2257c(this, str2);
                if (str2.contains("\n")) {
                    Toast.makeText(this, R.string.selected_str_copied, 0).show();
                    return;
                } else {
                    Toast.makeText(this, String.format(getString(R.string.copied_to_clipboard), str2), 0).show();
                    return;
                }
            }
            if (id != R.id.pasteBtn) {
                if (id == R.id.menu_methods) {
                    m3141b(view);
                    return;
                }
                return;
            }
            String strM2238b = C0985a.m2238b(this);
            if (strM2238b == null) {
                Toast.makeText(this, R.string.clipboard_no_text, 0).show();
                return;
            }
            Editable editableM3175f = this.f2738K.m3175f();
            if (editableM3175f != null) {
                editableM3175f.replace(this.f2738K.m3168b(), this.f2738K.m3170c(), strM2238b);
                return;
            }
            return;
        }
        int i = this.f2728A.isChecked() ? 10 : 8;
        if (this.f2729B != null && !this.f2729B.isChecked()) {
            i |= 16;
        }
        try {
            String string2 = this.f2745p.getText().toString();
            List listM3174e = this.f2738K.m3174e();
            Pattern patternCompile = Pattern.compile(this.f2744o.getText().toString(), i);
            ArrayList<C1277hq> arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            while (i2 < listM3174e.size()) {
                String str3 = (String) listM3174e.get(i2);
                Matcher matcher = patternCompile.matcher(str3);
                int iEnd = 0;
                while (matcher.find(iEnd)) {
                    int iStart = matcher.start();
                    iEnd = matcher.end();
                    arrayList.add(new C1277hq(iStart, iEnd, (byte) 0));
                }
                if (arrayList.isEmpty()) {
                    size = i3;
                } else {
                    StringBuilder sb = new StringBuilder();
                    int i4 = 0;
                    for (C1277hq c1277hq : arrayList) {
                        sb.append(str3.substring(i4, c1277hq.f3632a));
                        sb.append(string2);
                        i4 = c1277hq.f3633b;
                    }
                    sb.append(str3.substring(i4));
                    listM3174e.set(i2, sb.toString());
                    size = arrayList.size() + i3;
                    arrayList.clear();
                }
                i2++;
                i3 = size;
            }
            this.f2738K.m3178i();
            if (i3 > 0) {
                Toast.makeText(getApplicationContext(), String.format(getString(R.string.replace_all_ret), Integer.valueOf(i3)), 0).show();
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.not_found), 0).show();
            }
        } catch (Exception e2) {
        }
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractActivityC1258gy, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2733F = (TextView) findViewById(R.id.filename);
        this.f2734G = findViewById(R.id.menu_previous);
        this.f2735H = findViewById(R.id.menu_next);
        this.f2736I = findViewById(R.id.menu_methods);
        this.f2734G.setOnClickListener(this);
        this.f2735H.setOnClickListener(this);
        this.f2736I.setOnClickListener(this);
        this.f2741l = (FrameLayout) findViewById(R.id.center_layout);
        this.f2738K = new C1283hw(this, (LayoutObListView) findViewById(R.id.text_list));
        this.f2742m = (ViewAnimator) findViewById(R.id.searchAnimator);
        this.f2743n = (SlidingDrawer) findViewById(R.id.sliding_drawer);
        this.f2744o = (EditText) findViewById(R.id.findEdit);
        this.f2745p = (EditText) findViewById(R.id.replaceEdit);
        this.f2746q = (ImageButton) findViewById(R.id.findBtn);
        this.f2747r = (ImageButton) findViewById(R.id.replaceBtn);
        this.f2748s = (ImageButton) findViewById(R.id.replaceAllBtn);
        this.f2751v = (ImageView) findViewById(R.id.openFindBtn);
        this.f2728A = (ToggleButton) findViewById(R.id.checkBoxIgnoreCase);
        this.f2729B = (ToggleButton) findViewById(R.id.checkBoxRegexp);
        this.f2752w = (ImageView) findViewById(R.id.saveBtn);
        this.f2753x = (ImageView) findViewById(R.id.copyBtn);
        this.f2754y = (ImageView) findViewById(R.id.pasteBtn);
        this.f2755z = (ImageView) findViewById(R.id.moreBtn);
        this.f2749t = (ImageButton) findViewById(R.id.goBtn);
        this.f2750u = (EditText) findViewById(R.id.lineNumEdit);
        this.f2730C = (ImageView) findViewById(R.id.panel_button);
        m2570a(this.f2753x, false);
        this.f2740k = SettingEditorActivity.m2561b(this);
        m2582e(this.f2740k);
        this.f2751v.setOnClickListener(this);
        this.f2746q.setOnClickListener(this);
        this.f2747r.setOnClickListener(this);
        this.f2748s.setOnClickListener(this);
        this.f2752w.setOnClickListener(this);
        this.f2749t.setOnClickListener(this);
        this.f2753x.setOnClickListener(this);
        this.f2754y.setOnClickListener(this);
        this.f2755z.setOnClickListener(this);
        this.f2752w.getDrawable().setAlpha(80);
        this.f2752w.setClickable(false);
        this.f2747r.setEnabled(false);
        this.f2748s.setEnabled(false);
        C1509c c1509c = new C1509c(this);
        this.f2741l.setBackgroundColor(c1509c.m3632a());
        this.f2738K.m3159a(c1509c.m3632a());
        this.f2738K.m3169b(c1509c.m3634b());
        int iM3632a = c1509c.m3632a();
        Color.argb(128, 255 - Color.red(iM3632a), 255 - Color.green(iM3632a), 255 - Color.blue(iM3632a));
        this.f2738K.m3162a((TextWatcher) this);
        this.f2743n.setOnDrawerOpenListener(new C1266hf(this));
        this.f2743n.setOnDrawerCloseListener(new C1267hg(this));
        this.f2738K.m3163a((InterfaceC0968a) this);
        this.f2744o.setOnKeyListener(new ViewOnKeyListenerC1268hh(this));
        this.f2745p.setOnKeyListener(new ViewOnKeyListenerC1269hi(this));
        super.m3137a((InterfaceC1525s) findViewById(R.id.text_list));
        new AsyncTaskC1278hr(this, (byte) 0).execute(new Void[0]);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractActivityC1258gy, android.app.Activity
    protected void onResume() {
        super.onResume();
        int iM2561b = SettingEditorActivity.m2561b(this);
        if (this.f2740k != iM2561b) {
            this.f2740k = iM2561b;
            m2582e(iM2561b);
            m2591d();
        }
        if (SettingEditorActivity.m2565e(this)) {
            this.f2738K.m3167a(true);
        } else {
            this.f2738K.m3167a(false);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        String str;
        super.onSaveInstanceState(bundle);
        bundle.putInt("curFileIndex", this.f3578e);
        bundle.putBoolean("modifySaved", this.f3580g);
        if (this.f3583j == null || !this.f3583j.m3650b()) {
            return;
        }
        bundle.putBoolean("docChanged", true);
        try {
            str = C0985a.m2263d(this, "tmp") + C0985a.m2284l(m3135a()) + ".tmp";
        } catch (Exception e) {
            str = m3135a() + ".tmp";
        }
        try {
            this.f3583j.m3648a(str);
            bundle.putString("unsavedFilePath", str);
        } catch (IOException e2) {
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
