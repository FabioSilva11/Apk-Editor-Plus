package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewAnimator;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.InterfaceC1477i;
import com.gmail.heagoo.neweditor.C1509c;
import com.gmail.heagoo.neweditor.C1511e;
import com.gmail.heagoo.neweditor.InterfaceC1502ad;
import com.gmail.heagoo.neweditor.InterfaceC1525s;
import com.gmail.heagoo.neweditor.ObEditText;
import com.gmail.heagoo.neweditor.ObScrollView;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class TextEditNormalActivity extends AbstractActivityC1258gy implements View.OnClickListener, InterfaceC1502ad {

    /* JADX INFO: renamed from: n */
    private static int f2756n = 300;

    /* JADX INFO: renamed from: o */
    private static int f2757o = 300;

    /* JADX INFO: renamed from: p */
    private static int f2758p = 400;

    /* JADX INFO: renamed from: q */
    private static int f2759q = 100;

    /* JADX INFO: renamed from: A */
    private FrameLayout f2760A;

    /* JADX INFO: renamed from: B */
    private EditText f2761B;

    /* JADX INFO: renamed from: C */
    private HorizontalScrollView f2762C;

    /* JADX INFO: renamed from: D */
    private View f2763D;

    /* JADX INFO: renamed from: E */
    private ObScrollView f2764E;

    /* JADX INFO: renamed from: F */
    private ViewAnimator f2765F;

    /* JADX INFO: renamed from: G */
    private SlidingDrawer f2766G;

    /* JADX INFO: renamed from: H */
    private EditText f2767H;

    /* JADX INFO: renamed from: I */
    private EditText f2768I;

    /* JADX INFO: renamed from: J */
    private ImageButton f2769J;

    /* JADX INFO: renamed from: K */
    private ImageButton f2770K;

    /* JADX INFO: renamed from: L */
    private ImageButton f2771L;

    /* JADX INFO: renamed from: M */
    private ImageButton f2772M;

    /* JADX INFO: renamed from: N */
    private EditText f2773N;

    /* JADX INFO: renamed from: O */
    private ImageView f2774O;

    /* JADX INFO: renamed from: P */
    private ImageView f2775P;

    /* JADX INFO: renamed from: Q */
    private ImageView f2776Q;

    /* JADX INFO: renamed from: R */
    private ImageView f2777R;

    /* JADX INFO: renamed from: S */
    private ImageView f2778S;

    /* JADX INFO: renamed from: T */
    private ToggleButton f2779T;

    /* JADX INFO: renamed from: U */
    private ToggleButton f2780U;

    /* JADX INFO: renamed from: V */
    private LinearLayout f2781V;

    /* JADX INFO: renamed from: W */
    private ImageView f2782W;

    /* JADX INFO: renamed from: X */
    private C1302io f2783X;

    /* JADX INFO: renamed from: Y */
    private boolean f2784Y;

    /* JADX INFO: renamed from: Z */
    private int f2785Z;

    /* JADX INFO: renamed from: aa */
    private boolean f2786aa;

    /* JADX INFO: renamed from: ab */
    private boolean f2787ab;

    /* JADX INFO: renamed from: ac */
    private TextView f2788ac;

    /* JADX INFO: renamed from: ad */
    private View f2789ad;

    /* JADX INFO: renamed from: ae */
    private View f2790ae;

    /* JADX INFO: renamed from: af */
    private View f2791af;

    /* JADX INFO: renamed from: ag */
    private int f2792ag;

    /* JADX INFO: renamed from: ah */
    private boolean f2793ah;

    /* JADX INFO: renamed from: ai */
    private boolean f2794ai;

    /* JADX INFO: renamed from: k */
    C1304iq f2795k;

    /* JADX INFO: renamed from: l */
    protected ObEditText f2796l;

    /* JADX INFO: renamed from: m */
    public int f2797m;

    /* JADX INFO: renamed from: r */
    private boolean f2798r;

    /* JADX INFO: renamed from: s */
    private boolean f2799s;

    /* JADX INFO: renamed from: t */
    private int f2800t;

    /* JADX INFO: renamed from: u */
    private int f2801u;

    /* JADX INFO: renamed from: v */
    private int f2802v;

    /* JADX INFO: renamed from: w */
    private int f2803w;

    /* JADX INFO: renamed from: x */
    private Handler f2804x;

    /* JADX INFO: renamed from: y */
    private C1300im f2805y;

    /* JADX INFO: renamed from: z */
    private LinearLayout f2806z;

    public TextEditNormalActivity() {
        super(false, true);
        this.f2798r = true;
        this.f2799s = false;
        this.f2800t = -1;
        this.f2801u = -1;
        this.f2803w = 20;
        this.f2804x = new Handler();
        this.f2795k = new C1304iq(this);
        this.f2805y = new C1300im(this);
        this.f2784Y = true;
        this.f2786aa = false;
        this.f2787ab = false;
        this.f2793ah = true;
        this.f2794ai = false;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ int m2592a(TextEditNormalActivity textEditNormalActivity, int i) {
        textEditNormalActivity.f2801u = -1;
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private static void m2593a(ImageView imageView, boolean z) {
        if (z) {
            imageView.getDrawable().setAlpha(255);
            imageView.setClickable(true);
        } else {
            imageView.getDrawable().setAlpha(80);
            imageView.setClickable(false);
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2595a(TextEditNormalActivity textEditNormalActivity, boolean z, int i) {
        if (z && i == textEditNormalActivity.f2785Z) {
            return;
        }
        textEditNormalActivity.f2784Y = z;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textEditNormalActivity.f2761B.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textEditNormalActivity.f2763D.getLayoutParams();
        if (z) {
            if (SettingEditorActivity.m2565e(textEditNormalActivity)) {
                textEditNormalActivity.f2761B.setVisibility(0);
                textEditNormalActivity.f2763D.setVisibility(0);
            }
            String str = "";
            for (int i2 = 0; i2 < i; i2++) {
                str = str + "9";
            }
            textEditNormalActivity.f2785Z = i;
            layoutParams.width = ((int) textEditNormalActivity.f2796l.getPaint().measureText(str)) + ((int) TypedValue.applyDimension(1, 6.0f, textEditNormalActivity.getResources().getDisplayMetrics()));
            layoutParams2.width = 1;
        } else {
            textEditNormalActivity.f2761B.setVisibility(8);
            textEditNormalActivity.f2763D.setVisibility(8);
            layoutParams.width = 0;
            layoutParams2.width = 0;
            textEditNormalActivity.f2785Z = 0;
        }
        textEditNormalActivity.f2761B.requestLayout();
        textEditNormalActivity.f2763D.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2596a(InterfaceC1477i interfaceC1477i) {
        new DialogC1201ey(this, new C1298ik(this, interfaceC1477i), R.string.file_saved).show();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m2598a(TextEditNormalActivity textEditNormalActivity, boolean z) {
        textEditNormalActivity.f2799s = false;
        return false;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ int m2599b(TextEditNormalActivity textEditNormalActivity, int i) {
        textEditNormalActivity.f2800t = -1;
        return -1;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ boolean m2601b(TextEditNormalActivity textEditNormalActivity, boolean z) {
        textEditNormalActivity.f2793ah = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public boolean m2602b(boolean z) {
        if (this.f2767H.getText().toString().equals("")) {
            return false;
        }
        if (m2612f()) {
            this.f2796l.requestFocus();
            return true;
        }
        int selectionStart = this.f2796l.getSelectionStart();
        int selectionEnd = this.f2796l.getSelectionEnd();
        this.f2796l.setSelection(0);
        if (m2612f()) {
            this.f2796l.requestFocus();
            return true;
        }
        this.f2796l.setSelection(selectionStart, selectionEnd);
        if (!z) {
            return false;
        }
        Toast.makeText(getApplicationContext(), getString(R.string.not_found), 0).show();
        return false;
    }

    /* JADX INFO: renamed from: c */
    private void m2604c(boolean z) {
        if (!z) {
            this.f2796l.setMaxWidth(((this.f2806z.getWidth() - this.f2761B.getWidth()) - this.f2763D.getWidth()) - this.f2766G.getWidth());
            return;
        }
        int width = this.f2806z.getWidth();
        int width2 = this.f2761B.getWidth();
        this.f2796l.setMaxWidth(((width - width2) - this.f2763D.getWidth()) - this.f2782W.getWidth());
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ boolean m2606c(TextEditNormalActivity textEditNormalActivity, boolean z) {
        textEditNormalActivity.f2794ai = true;
        return true;
    }

    /* JADX INFO: renamed from: d */
    private void m2608d(int i) {
        byte b2 = 0;
        if (this.f3583j.m3650b()) {
            new AlertDialog.Builder(this).setMessage(R.string.save_changes_tip).setPositiveButton(R.string.save, new DialogInterfaceOnClickListenerC1296ii(this, i)).setNegativeButton(R.string.donot_save, new DialogInterfaceOnClickListenerC1295ih(this, i)).setNeutralButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
        } else {
            this.f3578e += i;
            new AsyncTaskC1303ip(this, b2).execute(new Void[0]);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2611e(int i) {
        int i2 = i <= 40 ? i : 40;
        int i3 = i2 >= 4 ? i2 : 4;
        this.f2796l.setTextSize(2, i3);
        this.f2761B.setTextSize(2, i3);
        this.f2785Z = 0;
    }

    /* JADX INFO: renamed from: f */
    private boolean m2612f() {
        int i = this.f2779T.isChecked() ? 10 : 8;
        if (this.f2780U != null && !this.f2780U.isChecked()) {
            i |= 16;
        }
        try {
            Matcher matcher = Pattern.compile(this.f2767H.getText().toString(), i).matcher(this.f3583j.m3642a());
            if (matcher.find(this.f2796l.getSelectionEnd())) {
                this.f2796l.setSelection(matcher.start(), matcher.end());
                return true;
            }
            this.f2796l.setSelection(this.f2796l.getSelectionEnd());
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m2615g() {
        try {
            int iMin = Math.min(this.f2796l.getSelectionStart(), this.f2796l.getSelectionEnd());
            int iMax = Math.max(this.f2796l.getSelectionStart(), this.f2796l.getSelectionEnd());
            if (iMin != iMax) {
                String string = this.f2796l.getText().subSequence(iMin, iMax).toString();
                String string2 = this.f2767H.getText().toString();
                if ((this.f2779T.isChecked() ? Pattern.compile(string2, 10) : Pattern.compile(string2)).matcher(string).matches()) {
                    this.f2770K.setEnabled(true);
                    this.f2771L.setEnabled(true);
                    return;
                }
            }
        } catch (Exception e) {
        }
        this.f2770K.setEnabled(false);
        this.f2771L.setEnabled(false);
    }

    /* JADX INFO: renamed from: g */
    public static boolean m2616g(String str) {
        String[] strArrSplit = str.split("/");
        return strArrSplit.length > 2 && strArrSplit[strArrSplit.length + (-2)].startsWith("values");
    }

    /* JADX INFO: renamed from: m */
    static /* synthetic */ boolean m2622m(TextEditNormalActivity textEditNormalActivity) {
        return false;
    }

    /* JADX INFO: renamed from: n */
    static /* synthetic */ void m2623n(TextEditNormalActivity textEditNormalActivity) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textEditNormalActivity.f2781V.getLayoutParams();
        layoutParams.setMargins(0, 0, textEditNormalActivity.f2766G.getWidth(), layoutParams.bottomMargin);
        textEditNormalActivity.f2781V.requestLayout();
        if (textEditNormalActivity.f3579f) {
            textEditNormalActivity.m2604c(true);
            textEditNormalActivity.m2629a(false);
        }
        textEditNormalActivity.f2782W.setImageResource(R.drawable.edit_slide_right);
    }

    /* JADX INFO: renamed from: o */
    static /* synthetic */ void m2624o(TextEditNormalActivity textEditNormalActivity) {
        textEditNormalActivity.f2766G.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textEditNormalActivity.f2781V.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, layoutParams.bottomMargin);
        textEditNormalActivity.f2781V.requestLayout();
        if (textEditNormalActivity.f3579f) {
            textEditNormalActivity.m2604c(false);
            textEditNormalActivity.m2629a(false);
        }
        textEditNormalActivity.f2782W.setImageResource(R.drawable.edit_slide_left);
        textEditNormalActivity.f2765F.setDisplayedChild(0);
    }

    /* JADX INFO: renamed from: r */
    static /* synthetic */ void m2627r(TextEditNormalActivity textEditNormalActivity) {
        View currentFocus = textEditNormalActivity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) textEditNormalActivity.getSystemService("input_method")).showSoftInput(currentFocus, 0);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractActivityC1258gy, com.gmail.heagoo.apkeditor.InterfaceC1139dn
    /* JADX INFO: renamed from: a */
    public final void mo2588a(int i, int i2) {
        boolean z = false;
        if (this.f3582i == 2) {
            String[] strArrSplit = this.f2796l.getText().toString().split("\n");
            if (i <= 0) {
                i = 1;
            }
            if (i2 > strArrSplit.length) {
                i2 = strArrSplit.length;
            }
            if (i <= i2) {
                int length = 0;
                for (int i3 = 1; i3 < i; i3++) {
                    length += strArrSplit[i3 - 1].length() + 1;
                }
                int length2 = length;
                for (int i4 = i; i4 <= i2; i4++) {
                    length2 += strArrSplit[i4 - 1].length() + 1;
                }
                this.f2796l.getText().replace(length, length2, "");
                Toast.makeText(this, String.format(getString(R.string.n_lines_deleted), Integer.valueOf((i2 - i) + 1)), 1).show();
                z = true;
            }
        } else if (this.f3582i == 5) {
            String[] strArrSplit2 = this.f2796l.getText().toString().split("\n");
            if (i <= 0) {
                i = 1;
            }
            if (i2 > strArrSplit2.length) {
                i2 = strArrSplit2.length;
            }
            if (i <= i2) {
                StringBuilder sb = new StringBuilder();
                int length3 = 0;
                for (int i5 = 1; i5 < i; i5++) {
                    length3 += strArrSplit2[i5 - 1].length() + 1;
                }
                int length4 = length3;
                for (int i6 = i; i6 <= i2; i6++) {
                    length4 += strArrSplit2[i6 - 1].length() + 1;
                }
                boolean zA = m3122a(strArrSplit2, i, i2, "#");
                if (zA) {
                    for (int i7 = i; i7 <= i2; i7++) {
                        int iIndexOf = strArrSplit2[i7 - 1].indexOf(35);
                        if (iIndexOf > 0) {
                            sb.append(strArrSplit2[i7 - 1].substring(0, iIndexOf));
                        }
                        sb.append(strArrSplit2[i7 - 1].substring(iIndexOf + 1));
                        sb.append("\n");
                    }
                } else {
                    for (int i8 = i; i8 <= i2; i8++) {
                        sb.append("#");
                        sb.append(strArrSplit2[i8 - 1]);
                        sb.append("\n");
                    }
                }
                this.f2796l.getText().replace(length3, length4, sb.toString());
                Toast.makeText(this, String.format(zA ? getString(R.string.n_lines_uncommented) : getString(R.string.n_lines_commented), Integer.valueOf((i2 - i) + 1)), 1).show();
                z = true;
            }
        }
        if (z) {
            this.f3583j.m3649a(true);
            m2631d();
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m2628a(int i, int i2, boolean z) {
        if (this.f2798r) {
            if (this.f2801u == -1 || i < this.f2801u) {
                this.f2801u = i;
            }
            if (this.f2800t == -1 || i2 > this.f2800t) {
                this.f2800t = i2;
            }
            this.f2799s = z;
            this.f2804x.removeCallbacks(this.f2805y);
            if (z) {
                this.f2804x.postDelayed(this.f2805y, f2758p);
            } else {
                this.f2804x.postDelayed(this.f2805y, f2759q);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m2629a(boolean z) {
        if (this.f2792ag > 0) {
            String[] strArrSplit = this.f2796l.getText().toString().split("\n");
            int length = this.f2792ag > strArrSplit.length ? strArrSplit.length : this.f2792ag;
            int length2 = 0;
            for (int i = 0; i < length - 1; i++) {
                length2 += strArrSplit[i].length() + 1;
            }
            this.f2796l.setSelection(length2);
            this.f2796l.requestFocus();
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            this.f2792ag = -1;
        }
        if (!this.f2784Y) {
            if (this.f2762C != null && String.valueOf(this.f2797m).length() != String.valueOf(this.f2796l.getLineCount()).length()) {
                this.f2762C.requestLayout();
            }
            this.f2797m = this.f2796l.getLineCount();
            return;
        }
        this.f2804x.removeCallbacks(this.f2795k);
        if (z) {
            this.f2804x.postDelayed(this.f2795k, f2757o);
        } else {
            this.f2804x.postDelayed(this.f2795k, 0L);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1251gr
    /* JADX INFO: renamed from: b */
    public final void mo2589b(int i) {
        if (i > 0) {
            String[] strArrSplit = this.f2796l.getText().toString().split("\n");
            if (i > strArrSplit.length) {
                i = strArrSplit.length;
            }
            int length = 0;
            for (int i2 = 0; i2 < i - 1; i2++) {
                length += strArrSplit[i2].length() + 1;
            }
            this.f2773N.setText("");
            this.f2796l.setSelection(length);
            this.f2796l.requestFocus();
        }
    }

    @Override // com.gmail.heagoo.neweditor.InterfaceC1502ad
    /* JADX INFO: renamed from: b */
    public final void mo2630b(int i, int i2) {
        if (i == i2) {
            m2593a(this.f2776Q, false);
        } else {
            m2593a(this.f2776Q, true);
        }
        if (this.f2766G.isOpened()) {
            m2615g();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractActivityC1258gy
    /* JADX INFO: renamed from: c */
    protected final void mo2590c(int i) {
        if (this.f2796l != null) {
            this.f2796l.getText().replace(this.f2796l.getSelectionStart(), this.f2796l.getSelectionEnd(), new StringBuilder().append(m3139b((String) null).charAt(i)).toString());
            this.f2796l.requestFocus();
        }
    }

    /* JADX INFO: renamed from: d */
    protected final synchronized void m2631d() {
        boolean zM3650b;
        C1511e c1511e = this.f3583j;
        if (c1511e != null && this.f2787ab != (zM3650b = c1511e.m3650b())) {
            if (zM3650b) {
                m2593a(this.f2775P, true);
            } else {
                m2593a(this.f2775P, false);
            }
            this.f2775P.invalidate();
            this.f2787ab = zM3650b;
        }
    }

    /* JADX INFO: renamed from: e */
    protected final synchronized void m2632e() {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f3583j == null || this.f3583j.m3650b()) {
            new AlertDialog.Builder(this).setMessage(R.string.save_changes_tip).setPositiveButton(R.string.save, new DialogInterfaceOnClickListenerC1288ia(this)).setNegativeButton(R.string.donot_save, new DialogInterfaceOnClickListenerC1286hz(this)).setNeutralButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int length = 0;
        int id = view.getId();
        if (id == R.id.menu_next) {
            m2608d(1);
            return;
        }
        if (id == R.id.menu_previous) {
            m2608d(-1);
            return;
        }
        if (id == R.id.moreBtn) {
            m3136a(view);
            return;
        }
        if (id == R.id.openFindBtn) {
            if (this.f2766G.getVisibility() == 8) {
                this.f2766G.animateOpen();
                this.f2766G.setVisibility(0);
            } else {
                this.f2766G.close();
                this.f2766G.setVisibility(8);
                this.f2796l.requestFocus();
            }
            int iMin = Math.min(this.f2796l.getSelectionStart(), this.f2796l.getSelectionEnd());
            int iMax = Math.max(this.f2796l.getSelectionStart(), this.f2796l.getSelectionEnd());
            if (iMin < iMax) {
                String string = this.f2796l.getText().subSequence(iMin, iMax).toString();
                if (!string.contains("\n")) {
                    this.f2767H.setText(string);
                }
            } else if (this.f3574a != null && "".equals(this.f2767H.getText().toString())) {
                this.f2767H.setText(this.f3574a);
            }
            this.f2767H.requestFocus();
            return;
        }
        if (id == R.id.findBtn) {
            m2602b(true);
            return;
        }
        if (id == R.id.replaceBtn) {
            this.f2796l.getEditableText().replace(this.f2796l.getSelectionStart(), this.f2796l.getSelectionEnd(), this.f2768I.getText());
            m2602b(true);
            return;
        }
        if (id == R.id.replaceAllBtn) {
            int i = this.f2779T.isChecked() ? 10 : 8;
            if (this.f2780U != null && !this.f2780U.isChecked()) {
                i |= 16;
            }
            try {
                Matcher matcher = Pattern.compile(this.f2767H.getText().toString(), i).matcher(this.f3583j.m3642a());
                ArrayList arrayList = new ArrayList();
                int iEnd = 0;
                while (matcher.find(iEnd)) {
                    int iStart = matcher.start();
                    iEnd = matcher.end();
                    arrayList.add(new C1299il(iStart, iEnd, (byte) 0));
                }
                if (arrayList.isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.not_found), 0).show();
                    return;
                }
                String string2 = this.f2768I.getText().toString();
                int i2 = 0;
                while (i2 < arrayList.size()) {
                    C1299il c1299il = (C1299il) arrayList.get(i2);
                    this.f2796l.getEditableText().replace(c1299il.f3684a + length, c1299il.f3685b + length, string2);
                    i2++;
                    length = (string2.length() - (c1299il.f3685b - c1299il.f3684a)) + length;
                }
                Toast.makeText(getApplicationContext(), String.format(getString(R.string.replace_all_ret), Integer.valueOf(arrayList.size())), 0).show();
                return;
            } catch (Exception e) {
                return;
            }
        }
        if (id == R.id.goBtn) {
            String strTrim = this.f2773N.getText().toString().trim();
            if (strTrim.equals("")) {
                this.f2796l.getText().insert(this.f2796l.getSelectionStart(), "\n");
                this.f2796l.requestFocus();
                return;
            } else {
                try {
                    mo2589b(Integer.valueOf(strTrim).intValue());
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
        }
        if (id == R.id.saveBtn) {
            m2596a((InterfaceC1477i) null);
            return;
        }
        if (id == R.id.copyBtn) {
            String strSubstring = this.f2796l.getText().toString().substring(this.f2796l.getSelectionStart(), this.f2796l.getSelectionEnd());
            if (strSubstring == null || strSubstring.equals("")) {
                return;
            }
            C0985a.m2257c(this, strSubstring);
            if (strSubstring.contains("\n")) {
                Toast.makeText(this, R.string.selected_str_copied, 0).show();
                return;
            } else {
                Toast.makeText(this, String.format(getString(R.string.copied_to_clipboard), strSubstring), 0).show();
                return;
            }
        }
        if (id != R.id.pasteBtn) {
            if (id == R.id.menu_methods) {
                m3141b(view);
            }
        } else {
            String strM2238b = C0985a.m2238b(this);
            if (strM2238b == null) {
                Toast.makeText(this, R.string.clipboard_no_text, 0).show();
            } else {
                this.f2796l.getText().replace(this.f2796l.getSelectionStart(), this.f2796l.getSelectionEnd(), strM2238b);
                this.f2796l.requestFocus();
            }
        }
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractActivityC1258gy, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        byte b2 = 0;
        super.onCreate(bundle);
        this.f2788ac = (TextView) findViewById(R.id.filename);
        this.f2789ad = findViewById(R.id.menu_previous);
        this.f2790ae = findViewById(R.id.menu_next);
        this.f2791af = findViewById(R.id.menu_methods);
        this.f2789ad.setOnClickListener(this);
        this.f2790ae.setOnClickListener(this);
        this.f2791af.setOnClickListener(this);
        this.f2806z = (LinearLayout) findViewById(R.id.editorLayout);
        this.f2760A = (FrameLayout) findViewById(R.id.center_layout);
        this.f2761B = (EditText) findViewById(R.id.lineNumbers);
        this.f2761B.setFilters(new InputFilter[0]);
        this.f2796l = (ObEditText) findViewById(R.id.editor);
        this.f2796l.setFilters(new InputFilter[0]);
        this.f2763D = findViewById(R.id.divider);
        this.f2764E = (ObScrollView) findViewById(R.id.editorScrollview);
        this.f2762C = (HorizontalScrollView) findViewById(R.id.hScrollView);
        this.f2765F = (ViewAnimator) findViewById(R.id.searchAnimator);
        this.f2766G = (SlidingDrawer) findViewById(R.id.sliding_drawer);
        this.f2767H = (EditText) findViewById(R.id.findEdit);
        this.f2768I = (EditText) findViewById(R.id.replaceEdit);
        this.f2769J = (ImageButton) findViewById(R.id.findBtn);
        this.f2770K = (ImageButton) findViewById(R.id.replaceBtn);
        this.f2771L = (ImageButton) findViewById(R.id.replaceAllBtn);
        this.f2774O = (ImageView) findViewById(R.id.openFindBtn);
        this.f2779T = (ToggleButton) findViewById(R.id.checkBoxIgnoreCase);
        this.f2780U = (ToggleButton) findViewById(R.id.checkBoxRegexp);
        this.f2775P = (ImageView) findViewById(R.id.saveBtn);
        this.f2776Q = (ImageView) findViewById(R.id.copyBtn);
        this.f2777R = (ImageView) findViewById(R.id.pasteBtn);
        this.f2778S = (ImageView) findViewById(R.id.moreBtn);
        this.f2772M = (ImageButton) findViewById(R.id.goBtn);
        this.f2773N = (EditText) findViewById(R.id.lineNumEdit);
        this.f2781V = this.f2806z;
        this.f2782W = (ImageView) findViewById(R.id.panel_button);
        m2593a(this.f2776Q, false);
        this.f2796l.m3603b(this.f3579f);
        this.f2796l.setInputType(720897);
        this.f2802v = SettingEditorActivity.m2561b(this);
        m2611e(this.f2802v);
        this.f2774O.setOnClickListener(this);
        this.f2769J.setOnClickListener(this);
        this.f2770K.setOnClickListener(this);
        this.f2771L.setOnClickListener(this);
        this.f2775P.setOnClickListener(this);
        this.f2772M.setOnClickListener(this);
        this.f2776Q.setOnClickListener(this);
        this.f2777R.setOnClickListener(this);
        this.f2778S.setOnClickListener(this);
        this.f2775P.getDrawable().setAlpha(80);
        this.f2775P.setClickable(false);
        this.f2770K.setEnabled(false);
        this.f2771L.setEnabled(false);
        C1509c c1509c = new C1509c(this);
        this.f2806z.setBackgroundColor(c1509c.m3632a());
        this.f2760A.setBackgroundColor(c1509c.m3632a());
        this.f2761B.setBackgroundColor(c1509c.m3632a());
        this.f2796l.setBackgroundColor(c1509c.m3632a());
        this.f2796l.setTextColor(c1509c.m3634b());
        this.f2761B.setTextColor(c1509c.m3634b());
        this.f2763D.setBackgroundColor(c1509c.m3634b());
        ObEditText obEditText = this.f2796l;
        int iM3632a = c1509c.m3632a();
        obEditText.m3598a(Color.argb(128, 255 - Color.red(iM3632a), 255 - Color.green(iM3632a), 255 - Color.blue(iM3632a)));
        this.f2761B.setOnLongClickListener(null);
        this.f2766G.setOnDrawerOpenListener(new C1285hy(this));
        this.f2766G.setOnDrawerCloseListener(new C1290ic(this));
        this.f2796l.m3600a(this);
        this.f2783X = new C1302io(this, b2);
        this.f2796l.addTextChangedListener(this.f2783X);
        this.f2764E.m3604a(new C1291id(this));
        this.f2767H.setOnKeyListener(new ViewOnKeyListenerC1292ie(this));
        this.f2768I.setOnKeyListener(new ViewOnKeyListenerC1293if(this));
        this.f2796l.setOnTouchListener(new ViewOnTouchListenerC1294ig(this));
        super.m3137a((InterfaceC1525s) this.f2796l);
        new AsyncTaskC1303ip(this, b2).execute(new Void[0]);
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
        if (this.f2802v != iM2561b) {
            this.f2802v = iM2561b;
            m2611e(iM2561b);
            m2629a(true);
            m2628a(-1, -1, false);
            m2631d();
        }
        if (!SettingEditorActivity.m2565e(this)) {
            this.f2761B.setVisibility(8);
            this.f2763D.setVisibility(8);
            return;
        }
        this.f2761B.setVisibility(0);
        this.f2763D.setVisibility(0);
        if (this.f2794ai) {
            m2629a(false);
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
}
