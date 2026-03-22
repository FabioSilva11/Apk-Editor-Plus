package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.p060a.C1029g;
import com.gmail.heagoo.apkeditor.p060a.C1031i;
import com.gmail.heagoo.apkeditor.p060a.C1032j;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1004e;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1013n;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1014o;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1015p;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1016q;
import com.gmail.heagoo.apkeditor.p068se.ApkCreateActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1470b;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipFile;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class CommonEditActivity extends Activity implements TextWatcher, View.OnClickListener, AdapterView.OnItemSelectedListener, InterfaceC1122cu {

    /* JADX INFO: renamed from: A */
    private String f2667A;

    /* JADX INFO: renamed from: B */
    private String f2668B;

    /* JADX INFO: renamed from: C */
    private int f2669C;

    /* JADX INFO: renamed from: D */
    private int f2670D;

    /* JADX INFO: renamed from: E */
    private String f2671E;

    /* JADX INFO: renamed from: a */
    private String f2672a;

    /* JADX INFO: renamed from: b */
    private C1470b f2673b;

    /* JADX INFO: renamed from: c */
    private ImageView f2674c;

    /* JADX INFO: renamed from: d */
    private ImageView f2675d;

    /* JADX INFO: renamed from: e */
    private TextView f2676e;

    /* JADX INFO: renamed from: f */
    private TextView f2677f;

    /* JADX INFO: renamed from: g */
    private TextView f2678g;

    /* JADX INFO: renamed from: h */
    private TextView f2679h;

    /* JADX INFO: renamed from: i */
    private EditText f2680i;

    /* JADX INFO: renamed from: j */
    private EditText f2681j;

    /* JADX INFO: renamed from: k */
    private EditText f2682k;

    /* JADX INFO: renamed from: l */
    private EditText f2683l;

    /* JADX INFO: renamed from: m */
    private EditText f2684m;

    /* JADX INFO: renamed from: n */
    private EditText f2685n;

    /* JADX INFO: renamed from: o */
    private EditText f2686o;

    /* JADX INFO: renamed from: p */
    private CheckBox f2687p;

    /* JADX INFO: renamed from: q */
    private CheckBox f2688q;

    /* JADX INFO: renamed from: r */
    private View f2689r;

    /* JADX INFO: renamed from: s */
    private C1031i f2690s;

    /* JADX INFO: renamed from: t */
    private C1029g f2691t;

    /* JADX INFO: renamed from: u */
    private HandlerC1098by f2692u = new HandlerC1098by(this);

    /* JADX INFO: renamed from: v */
    private Spinner f2693v;

    /* JADX INFO: renamed from: w */
    private Spinner f2694w;

    /* JADX INFO: renamed from: x */
    private String f2695x;

    /* JADX INFO: renamed from: y */
    private Map f2696y;

    /* JADX INFO: renamed from: z */
    private String f2697z;

    /* JADX INFO: renamed from: a */
    private void m2494a() throws Throwable {
        String absolutePath = getFilesDir().getAbsolutePath();
        String str = absolutePath + "/bin/_wrapper.apk";
        File file = new File(absolutePath + "/bin");
        if (!file.exists() && !file.mkdirs()) {
            Toast.makeText(this, "Cannot create bin directory", 1).show();
            return;
        }
        String strM3525a = C1487s.m3525a(4);
        try {
            this.f2695x = C0985a.m2263d(this, "tmp") + ".xml";
            String str2 = null;
            try {
                str2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
            }
            SharedPreferences sharedPreferences = getSharedPreferences("info", 0);
            String string = sharedPreferences.getString("wrapper_ver", "");
            if (!new File(str).exists() || !string.equals(str2)) {
                try {
                    InputStream inputStreamOpen = getAssets().open("_wrapper");
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    C0985a.m2244b(inputStreamOpen, fileOutputStream);
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    C0985a.m2279i(str);
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("wrapper_ver", str2);
                    editorEdit.apply();
                } catch (Exception e2) {
                }
            }
            ZipFile zipFile = new ZipFile(str);
            InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME));
            C1014o c1014o = new C1014o(inputStream, this.f2695x);
            c1014o.m2697a("com.example.droidpluginwrapper", this.f2697z);
            c1014o.m2697a("DroidPluginWrapper", this.f2667A);
            c1014o.m2697a("1.x.y", this.f2668B);
            for (int i = 0; i < 9; i++) {
                char c = (char) (i + 48);
                c1014o.m2697a("com.morgoo.droidplugin_stub_P0" + c, "com.morgoo.droidplugin_" + strM3525a + "_P0" + c);
            }
            c1014o.m2699b(this.f2669C);
            c1014o.m2696a(this.f2670D >= 0 ? this.f2670D : 0);
            if (!this.f2691t.f2968v.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f2691t.f2968v.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next());
                }
                c1014o.m2698a(arrayList);
            }
            c1014o.m2695a();
            inputStream.close();
            zipFile.close();
            HashMap map = new HashMap();
            map.put(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME, this.f2695x);
            map.put("assets/1.apk", this.f2672a);
            if (this.f2671E != null) {
                map.put("res/drawable/ic_launcher.png", this.f2671E);
            } else {
                String strM2498b = m2498b();
                if (strM2498b != null) {
                    map.put("res/drawable/ic_launcher.png", strM2498b);
                }
            }
            Intent intent = new Intent(this, (Class<?>) ApkCreateActivity.class);
            C0985a.m2180a(intent, "apkPath", str);
            C0985a.m2180a(intent, "packageName", this.f2691t.f2951e);
            C0985a.m2206a(intent, "otherReplaces", map);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new C1013n(strM3525a));
            intent.putExtra("interfaces", arrayList2);
            startActivity(intent);
        } catch (Exception e3) {
            Toast.makeText(this, e3.getMessage(), 1).show();
            e3.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2495a(TextView textView, EditText editText, int i) {
        if (i == -1) {
            textView.setVisibility(8);
            editText.setVisibility(8);
        } else {
            editText.setText(String.valueOf(i));
            textView.setVisibility(0);
            editText.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2496a(boolean z, boolean z2) {
        HashMap map = new HashMap();
        map.put(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME, this.f2695x);
        Intent intent = new Intent(this, (Class<?>) ApkCreateActivity.class);
        C0985a.m2180a(intent, "apkPath", this.f2672a);
        C0985a.m2180a(intent, "packageName", this.f2691t.f2951e);
        C0985a.m2206a(intent, "otherReplaces", map);
        if (!this.f2691t.f2951e.equals(this.f2697z) && this.f2687p.isChecked()) {
            C0985a.m2180a(intent, "newPackageNameInArsc", this.f2697z);
        }
        if (this.f2691t.f2956j < 0 && !this.f2667A.equals(this.f2691t.f2949c)) {
            C0985a.m2180a(intent, "oldAppNameInArsc", this.f2691t.f2949c);
            C0985a.m2180a(intent, "newAppNameInArsc", this.f2667A);
        }
        if (!this.f2696y.isEmpty()) {
            HashMap map2 = new HashMap();
            for (Map.Entry entry : this.f2696y.entrySet()) {
                map2.put("L" + ((String) entry.getKey()).replaceAll("\\.", "/"), "L" + ((String) entry.getValue()).replaceAll("\\.", "/"));
            }
            C0985a.m2206a(intent, "classRenames", map2);
        }
        ArrayList arrayList = new ArrayList();
        if (this.f2691t.f2959m != -1 && this.f2671E != null) {
            arrayList.add(new C1032j(this.f2691t.f2959m, this.f2671E));
        }
        if (z2) {
            arrayList.add(new C1015p(this.f2691t.f2951e, this.f2697z));
            arrayList.add(new C1016q(this.f2691t.f2951e, this.f2697z));
        }
        if (!arrayList.isEmpty()) {
            intent.putExtra("interfaces", arrayList);
        }
        startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049 A[Catch: Exception -> 0x0073, TryCatch #0 {Exception -> 0x0073, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0027, B:8:0x0031, B:9:0x0035, B:11:0x0049, B:13:0x004f, B:21:0x0079, B:16:0x005d, B:15:0x0055), top: B:23:0x0000 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m2498b() {
        /*
            r9 = this;
            com.gmail.heagoo.common.b r1 = r9.f2673b     // Catch: java.lang.Exception -> L73
            android.graphics.drawable.Drawable r1 = r1.f4292c     // Catch: java.lang.Exception -> L73
            if (r1 == 0) goto L77
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L73
            r1.<init>()     // Catch: java.lang.Exception -> L73
            java.lang.String r2 = "tmp"
            java.lang.String r2 = com.gmail.heagoo.p054a.p059c.C0985a.m2263d(r9, r2)     // Catch: java.lang.Exception -> L73
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L73
            java.lang.String r2 = "_launcher"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L73
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Exception -> L73
            com.gmail.heagoo.common.b r1 = r9.f2673b     // Catch: java.lang.Exception -> L73
            android.graphics.drawable.Drawable r2 = r1.f4292c     // Catch: java.lang.Exception -> L73
            boolean r1 = r2 instanceof android.graphics.drawable.BitmapDrawable     // Catch: java.lang.Exception -> L73
            if (r1 == 0) goto L49
            r0 = r2
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0     // Catch: java.lang.Exception -> L73
            r1 = r0
            android.graphics.Bitmap r4 = r1.getBitmap()     // Catch: java.lang.Exception -> L73
            if (r4 == 0) goto L49
            android.graphics.Bitmap r1 = r1.getBitmap()     // Catch: java.lang.Exception -> L73
        L35:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L73
            r2.<init>(r3)     // Catch: java.lang.Exception -> L73
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Exception -> L73
            r5 = 100
            r1.compress(r4, r5, r2)     // Catch: java.lang.Exception -> L73
            r2.flush()     // Catch: java.lang.Exception -> L73
            r2.close()     // Catch: java.lang.Exception -> L73
            r1 = r3
        L48:
            return r1
        L49:
            int r1 = r2.getIntrinsicWidth()     // Catch: java.lang.Exception -> L73
            if (r1 <= 0) goto L55
            int r1 = r2.getIntrinsicHeight()     // Catch: java.lang.Exception -> L73
            if (r1 > 0) goto L79
        L55:
            r1 = 1
            r4 = 1
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Exception -> L73
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r4, r5)     // Catch: java.lang.Exception -> L73
        L5d:
            android.graphics.Canvas r4 = new android.graphics.Canvas     // Catch: java.lang.Exception -> L73
            r4.<init>(r1)     // Catch: java.lang.Exception -> L73
            r5 = 0
            r6 = 0
            int r7 = r4.getWidth()     // Catch: java.lang.Exception -> L73
            int r8 = r4.getHeight()     // Catch: java.lang.Exception -> L73
            r2.setBounds(r5, r6, r7, r8)     // Catch: java.lang.Exception -> L73
            r2.draw(r4)     // Catch: java.lang.Exception -> L73
            goto L35
        L73:
            r1 = move-exception
            r1.printStackTrace()
        L77:
            r1 = 0
            goto L48
        L79:
            int r1 = r2.getIntrinsicWidth()     // Catch: java.lang.Exception -> L73
            int r4 = r2.getIntrinsicHeight()     // Catch: java.lang.Exception -> L73
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Exception -> L73
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r4, r5)     // Catch: java.lang.Exception -> L73
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.CommonEditActivity.m2498b():java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    public final void m2501a(String str) {
        if (str != null) {
            Toast.makeText(this, getResources().getString(R.string.cannot_parse_apk) + ": " + str, 1).show();
            finish();
            return;
        }
        this.f2691t = this.f2690s.m2759a();
        this.f2691t.f2949c = this.f2673b.f4290a;
        this.f2674c.setImageDrawable(this.f2673b.f4292c);
        this.f2676e.setText(this.f2673b.f4290a);
        this.f2680i.setText(this.f2673b.f4290a);
        this.f2681j.setText(this.f2691t.f2951e);
        if (this.f2691t.f2957k == -1) {
            this.f2683l.setVisibility(8);
            findViewById(R.id.tv_vername).setVisibility(8);
        } else {
            this.f2683l.setText(this.f2691t.f2950d);
        }
        this.f2682k.setText(String.valueOf(this.f2691t.f2947a));
        int i = this.f2691t.f2948b;
        if (i >= -1 && i < 3) {
            this.f2693v.setSelection(i + 1);
        }
        this.f2675d.setImageDrawable(this.f2673b.f4292c);
        if (this.f2691t.f2959m != -1) {
            this.f2675d.setOnClickListener(this);
        }
        m2495a(this.f2677f, this.f2684m, this.f2691t.f2953g);
        m2495a(this.f2678g, this.f2685n, this.f2691t.f2954h);
        m2495a(this.f2679h, this.f2686o, this.f2691t.f2955i);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        this.f2671E = str;
        try {
            this.f2675d.setImageBitmap(BitmapFactory.decodeFile(this.f2671E));
        } catch (Exception e) {
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return str.endsWith(".png");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = editable.toString();
        if (this.f2691t == null || !string.equals(this.f2691t.f2951e)) {
            this.f2689r.setVisibility(0);
        } else {
            this.f2689r.setVisibility(8);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        int i;
        int i2;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        boolean z;
        int id = view.getId();
        if (id == R.id.btn_close) {
            finish();
            return;
        }
        if (id != R.id.btn_save) {
            if (id == R.id.launcher_icon) {
                new DialogC1115cn(this, this, ".png", "launcher.png", null).show();
                return;
            }
            return;
        }
        String string = this.f2682k.getText().toString();
        this.f2669C = 0;
        try {
            this.f2669C = Integer.valueOf(string).intValue();
            this.f2667A = this.f2680i.getText().toString();
            this.f2697z = this.f2681j.getText().toString();
            this.f2697z = this.f2697z.trim();
            this.f2668B = this.f2683l.getText().toString();
            try {
                String string2 = this.f2684m.getText().toString();
                iIntValue = !"".equals(string2) ? Integer.valueOf(string2).intValue() : -1;
                try {
                    String string3 = this.f2685n.getText().toString();
                    iIntValue2 = !"".equals(string3) ? Integer.valueOf(string3).intValue() : -1;
                    try {
                        String string4 = this.f2686o.getText().toString();
                        iIntValue3 = !"".equals(string4) ? Integer.valueOf(string4).intValue() : -1;
                    } catch (Exception e) {
                        i = iIntValue2;
                        i2 = iIntValue;
                        iIntValue = i2;
                        iIntValue2 = i;
                        iIntValue3 = -1;
                    }
                } catch (Exception e2) {
                    i = -1;
                    i2 = iIntValue;
                }
            } catch (Exception e3) {
                i = -1;
                i2 = -1;
            }
            if (!this.f2697z.equals("")) {
                if (this.f2697z.length() < 128) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.f2697z.length()) {
                            z = true;
                            break;
                        } else {
                            if (this.f2697z.charAt(i3) > 127) {
                                Toast.makeText(this, "Invalid Package Name", 0).show();
                                z = false;
                                break;
                            }
                            i3++;
                        }
                    }
                } else {
                    Toast.makeText(this, "Package name is too long", 0).show();
                    z = false;
                }
            } else {
                Toast.makeText(this, "Invalid Package Name", 0).show();
                z = false;
            }
            if (z) {
                this.f2670D = this.f2693v.getSelectedItemPosition() - 1;
                boolean z2 = this.f2671E == null && this.f2691t.f2949c.equals(this.f2667A) && this.f2691t.f2951e.equals(this.f2697z) && this.f2691t.f2947a == this.f2669C && this.f2691t.f2948b == this.f2670D;
                if ((((this.f2691t.f2957k != -1 ? z2 && this.f2691t.f2950d.equals(this.f2668B) : z2) && this.f2691t.f2953g == iIntValue) && this.f2691t.f2954h == iIntValue2) && this.f2691t.f2955i == iIntValue3) {
                    Toast.makeText(this, R.string.no_change_detected, 1).show();
                    return;
                }
                int selectedItemPosition = this.f2694w.getSelectedItemPosition();
                if (!this.f2691t.f2951e.equals(this.f2697z) && selectedItemPosition == 1) {
                    m2494a();
                    return;
                }
                boolean z3 = this.f2688q.isChecked() && !this.f2691t.f2951e.equals(this.f2697z);
                try {
                    this.f2695x = C0985a.m2263d(this, "tmp") + ".xml";
                    ZipFile zipFile = new ZipFile(this.f2672a);
                    InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME));
                    C1029g c1029g = new C1029g();
                    c1029g.f2949c = this.f2667A;
                    c1029g.f2951e = this.f2697z;
                    c1029g.f2947a = this.f2669C;
                    c1029g.f2950d = this.f2668B;
                    c1029g.f2948b = this.f2670D;
                    c1029g.f2953g = iIntValue;
                    c1029g.f2954h = iIntValue2;
                    c1029g.f2955i = iIntValue3;
                    C1004e c1004e = new C1004e(inputStream, this.f2695x, z3);
                    c1004e.m2677a(this.f2691t, c1029g);
                    c1004e.m2676a();
                    this.f2696y = c1004e.m2678b();
                    new HashMap();
                    inputStream.close();
                    zipFile.close();
                    m2496a(false, z3);
                } catch (Exception e4) {
                    Toast.makeText(this, e4.getMessage(), 1).show();
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            Toast.makeText(this, R.string.invalid_ver_code, 1).show();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_commonedit);
        this.f2672a = C0985a.m2195a(getIntent(), "apkPath");
        new C1097bx(this).start();
        this.f2674c = (ImageView) findViewById(R.id.apk_icon);
        this.f2675d = (ImageView) findViewById(R.id.launcher_icon);
        this.f2676e = (TextView) findViewById(R.id.apk_label);
        this.f2677f = (TextView) findViewById(R.id.tv_minSdkVersion);
        this.f2678g = (TextView) findViewById(R.id.tv_targetSdkVersion);
        this.f2679h = (TextView) findViewById(R.id.tv_maxSdkVersion);
        this.f2680i = (EditText) findViewById(R.id.et_appname);
        this.f2681j = (EditText) findViewById(R.id.et_pkgname);
        this.f2682k = (EditText) findViewById(R.id.et_vercode);
        this.f2683l = (EditText) findViewById(R.id.et_vername);
        this.f2684m = (EditText) findViewById(R.id.et_minSdkVersion);
        this.f2685n = (EditText) findViewById(R.id.et_targetSdkVersion);
        this.f2686o = (EditText) findViewById(R.id.et_maxSdkVersion);
        this.f2687p = (CheckBox) findViewById(R.id.cb_rename_resource);
        this.f2688q = (CheckBox) findViewById(R.id.cb_rename_dex);
        this.f2689r = findViewById(R.id.layout_rename_extra);
        this.f2694w = (Spinner) findViewById(R.id.rename_method_spinner);
        if (getPackageName().endsWith("pro")) {
            this.f2681j.addTextChangedListener(this);
        } else {
            this.f2681j.setEnabled(false);
            this.f2694w.setEnabled(false);
            findViewById(R.id.cb_rename_resource).setEnabled(false);
        }
        this.f2693v = (Spinner) findViewById(R.id.location_spinner);
        Resources resources = getResources();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{resources.getString(R.string.location_0), resources.getString(R.string.location_1), resources.getString(R.string.location_2), resources.getString(R.string.location_3)});
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.f2693v.setAdapter((SpinnerAdapter) arrayAdapter);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{resources.getString(R.string.pkg_rename_direct), resources.getString(R.string.pkg_rename_as_plugin)});
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.f2694w.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.f2694w.setOnItemSelectedListener(this);
        findViewById(R.id.btn_close).setOnClickListener(this);
        findViewById(R.id.btn_save).setOnClickListener(this);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i == 1) {
            this.f2687p.setVisibility(8);
            this.f2688q.setVisibility(8);
        } else {
            this.f2687p.setVisibility(0);
            this.f2688q.setVisibility(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
