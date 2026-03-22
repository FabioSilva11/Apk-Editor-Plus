package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.p064c.DialogC1101a;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1474f;
import com.gmail.heagoo.neweditor.C1511e;
import com.gmail.heagoo.neweditor.InterfaceC1525s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p048b.p049a.InterfaceC0930e;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gy */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC1258gy extends Activity implements InterfaceC0930e, InterfaceC1139dn, InterfaceC1251gr {

    /* JADX INFO: renamed from: z */
    public static boolean f3573z = false;

    /* JADX INFO: renamed from: a */
    protected String f3574a;

    /* JADX INFO: renamed from: b */
    protected List f3575b;

    /* JADX INFO: renamed from: c */
    protected List f3576c;

    /* JADX INFO: renamed from: d */
    protected List f3577d;

    /* JADX INFO: renamed from: h */
    protected String f3581h;

    /* JADX INFO: renamed from: i */
    protected int f3582i;

    /* JADX INFO: renamed from: j */
    protected C1511e f3583j;

    /* JADX INFO: renamed from: k */
    private boolean f3584k;

    /* JADX INFO: renamed from: l */
    private boolean f3585l;

    /* JADX INFO: renamed from: m */
    private String f3586m;

    /* JADX INFO: renamed from: n */
    private boolean f3587n;

    /* JADX INFO: renamed from: o */
    private String f3588o;

    /* JADX INFO: renamed from: p */
    private List f3589p;

    /* JADX INFO: renamed from: q */
    private String f3590q;

    /* JADX INFO: renamed from: s */
    private boolean f3592s;

    /* JADX INFO: renamed from: w */
    private View f3596w;

    /* JADX INFO: renamed from: x */
    private LinearLayout f3597x;

    /* JADX INFO: renamed from: y */
    private DialogC1101a f3598y;

    /* JADX INFO: renamed from: e */
    protected int f3578e = 0;

    /* JADX INFO: renamed from: f */
    protected boolean f3579f = true;

    /* JADX INFO: renamed from: g */
    protected boolean f3580g = false;

    /* JADX INFO: renamed from: r */
    private ArrayList f3591r = new ArrayList();

    /* JADX INFO: renamed from: t */
    private C1249gp f3593t = new C1249gp(this);

    /* JADX INFO: renamed from: u */
    private String[] f3594u = {",.?!:;~-_=\"'/@*+()<>{}[]%&$|\\#^", "<>\":=/@+.-?#_()[]{}\\;!$%^&*|~',", "(){};.=\"'|&![]@<>+-*/?:,_\\^%#~$"};

    /* JADX INFO: renamed from: v */
    private int f3595v = -1;

    public AbstractActivityC1258gy(boolean z, boolean z2) {
        this.f3584k = z;
        this.f3585l = z2;
    }

    /* JADX INFO: renamed from: a */
    protected static boolean m3122a(String[] strArr, int i, int i2, String str) {
        while (i <= i2) {
            if (!strArr[i - 1].trim().startsWith(str)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m3124b(AbstractActivityC1258gy abstractActivityC1258gy, boolean z) {
        if (SettingEditorActivity.m2563c(abstractActivityC1258gy)) {
            if (z) {
                abstractActivityC1258gy.f3596w.setVisibility(0);
                abstractActivityC1258gy.f3597x.setVisibility(4);
            } else {
                abstractActivityC1258gy.f3597x.setVisibility(0);
                abstractActivityC1258gy.f3596w.setVisibility(4);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m3126c(String str) {
        return str != null && str.endsWith(".smali");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m3127d() {
        if (this.f3586m == null) {
            Toast.makeText(this, "Internal error: cannot find apk path to decode java code, please contact the author.", 1).show();
            return;
        }
        try {
            String strM2263d = C0985a.m2263d(this, "tmp");
            String str = "classes.dex";
            String[] strArrSplit = this.f3590q.split("/");
            int i = 0;
            while (true) {
                if (i >= strArrSplit.length || "smali".equals(strArrSplit[i])) {
                    break;
                }
                if (strArrSplit[i].startsWith("smali_")) {
                    str = strArrSplit[i].substring(6) + ".dex";
                    break;
                }
                i++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            while (true) {
                i++;
                if (i >= strArrSplit.length) {
                    break;
                }
                String str2 = strArrSplit[i];
                if (i != strArrSplit.length - 1) {
                    sb.append(str2);
                    sb.append('/');
                } else if (str2.length() > 6 && str2.endsWith(".smali")) {
                    sb.append(str2.substring(0, str2.length() - 6));
                }
            }
            String[] strArr = sb.length() == 0 ? null : new String[]{str, sb.toString()};
            String str3 = strArr[0];
            String str4 = strArr[1];
            if (str4 == null) {
                Toast.makeText(this, "Internal error: Cannot get class name, please contact the author.", 1).show();
            } else {
                new DialogC1201ey(this, new C1265he(this, str3, str4, strM2263d), -1).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Cannot make working directory.", 0).show();
        }
    }

    /* JADX INFO: renamed from: d */
    static /* synthetic */ void m3128d(AbstractActivityC1258gy abstractActivityC1258gy) {
        if (abstractActivityC1258gy.f3598y == null) {
            abstractActivityC1258gy.f3598y = new DialogC1101a(abstractActivityC1258gy);
        }
        abstractActivityC1258gy.f3598y.m2833a(abstractActivityC1258gy.f3590q, abstractActivityC1258gy.m3143f(abstractActivityC1258gy.f3590q));
    }

    /* JADX INFO: renamed from: d */
    public static boolean m3129d(String str) {
        return str != null && str.endsWith(".java");
    }

    /* JADX INFO: renamed from: e */
    public static boolean m3131e(String str) {
        return str.endsWith(".xml");
    }

    /* JADX INFO: renamed from: f */
    static /* synthetic */ void m3132f(AbstractActivityC1258gy abstractActivityC1258gy) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(abstractActivityC1258gy);
        if (defaultSharedPreferences.getBoolean("java_edit_tip_shown", false)) {
            abstractActivityC1258gy.m3127d();
            return;
        }
        new AlertDialog.Builder(abstractActivityC1258gy).setTitle(R.string.please_note).setMessage(R.string.java_code_edit_tip).setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1264hd(abstractActivityC1258gy)).show();
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putBoolean("java_edit_tip_shown", true);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a */
    protected final String m3135a() {
        return this.f3590q;
    }

    @Override // com.p048b.p049a.InterfaceC0930e
    /* JADX INFO: renamed from: a */
    public final void mo2045a(int i) {
        String str = String.format("#%08x", Integer.valueOf(i));
        C0985a.m2257c(this, str);
        Toast.makeText(this, String.format(getString(R.string.copied_to_clipboard), str), 0).show();
    }

    /* JADX INFO: renamed from: a */
    public void mo2588a(int i, int i2) {
        Toast.makeText(this, "Not implemented.", 0).show();
    }

    /* JADX INFO: renamed from: a */
    protected final void m3136a(View view) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.popup_list, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.lvGroup);
        C1194er c1194er = new C1194er(this, this.f3590q);
        listView.setAdapter((ListAdapter) c1194er);
        PopupWindow popupWindow = new PopupWindow(viewInflate, C1474f.m3501a(this) / 2, C1474f.m3502a(this, (c1194er.m2981a() * 48) + 32));
        listView.setOnItemClickListener(new C1263hc(this, c1194er, popupWindow));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAsDropDown(view, (((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() / 2) - (popupWindow.getWidth() / 2), 0);
    }

    /* JADX INFO: renamed from: a */
    protected final void m3137a(InterfaceC1525s interfaceC1525s) {
        View viewFindViewById = findViewById(android.R.id.content);
        viewFindViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1262hb(this, viewFindViewById, interfaceC1525s));
    }

    /* JADX INFO: renamed from: a */
    protected final void m3138a(String str) {
        this.f3590q = str;
        int i = str == null ? this.f3595v : str.endsWith(".xml") ? 1 : str.endsWith(".java") ? 2 : 0;
        if (i != this.f3595v) {
            this.f3595v = i;
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.special_char_container);
            linearLayout.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(C1474f.m3501a(this) / 11, -1);
            String str2 = this.f3594u[this.f3595v];
            for (int i2 = 0; i2 < str2.length(); i2++) {
                TextView textView = new TextView(this);
                textView.setTextSize(2, 24.0f);
                textView.setBackgroundResource(R.drawable.mtrl_selectable);
                textView.setText(new StringBuilder().append(str2.charAt(i2)).toString());
                textView.setTextColor(ContextCompat.getColor(this, C0037k.mdTextMedium(C0037k.m89a(this))));
                textView.setGravity(17);
                textView.setTag(Integer.valueOf(i2));
                textView.setOnClickListener(new ViewOnClickListenerC1261ha(this));
                linearLayout.addView(textView, layoutParams);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    protected final String m3139b(String str) {
        return this.f3595v >= 0 ? this.f3594u[this.f3595v] : "";
    }

    /* JADX INFO: renamed from: b */
    protected final void m3140b() {
        Intent intent = new Intent();
        if (this.f3587n) {
            if (!this.f3591r.contains(this.f3590q)) {
                this.f3591r.add(this.f3590q);
            }
            intent.putStringArrayListExtra("modifiedFiles", this.f3591r);
        } else {
            intent.putExtra("xmlPath", this.f3590q);
            intent.putExtra("extraString", (String) this.f3589p.get(0));
        }
        setResult(1, intent);
    }

    /* JADX INFO: renamed from: b */
    protected final void m3141b(View view) {
        if (this.f3593t == null || !this.f3590q.equals(this.f3593t.m3110a())) {
            this.f3593t.m3111a(this, this.f3590q, this.f3583j.m3642a(), view);
        } else {
            this.f3593t.m3112a(view);
        }
    }

    /* JADX INFO: renamed from: c */
    protected abstract void mo2590c(int i);

    /* JADX INFO: renamed from: c */
    protected final boolean m3142c() {
        return this.f3592s;
    }

    /* JADX INFO: renamed from: f */
    public final String m3143f(String str) {
        if (!this.f3587n && this.f3588o != null) {
            return this.f3588o;
        }
        int iLastIndexOf = str.lastIndexOf(47);
        return iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    @Override // android.app.Activity
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r9) {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.AbstractActivityC1258gy.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (f3573z) {
            f3573z = false;
            recreate();
        }
    }
}
