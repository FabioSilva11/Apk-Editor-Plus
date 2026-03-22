package com.gmail.heagoo.apkeditor.p068se;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1028f;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1470b;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class ApkCreateActivity extends Activity implements View.OnClickListener, InterfaceC1028f {

    /* JADX INFO: renamed from: a */
    HandlerC1346b f3815a;

    /* JADX INFO: renamed from: b */
    private String f3816b;

    /* JADX INFO: renamed from: c */
    private String f3817c;

    /* JADX INFO: renamed from: d */
    private Map f3818d;

    /* JADX INFO: renamed from: e */
    private Map f3819e;

    /* JADX INFO: renamed from: f */
    private Map f3820f;

    /* JADX INFO: renamed from: g */
    private String f3821g;

    /* JADX INFO: renamed from: h */
    private String f3822h;

    /* JADX INFO: renamed from: i */
    private String f3823i;

    /* JADX INFO: renamed from: j */
    private LinearLayout f3824j;

    /* JADX INFO: renamed from: k */
    private LinearLayout f3825k;

    /* JADX INFO: renamed from: l */
    private ImageView f3826l;

    /* JADX INFO: renamed from: m */
    private TextView f3827m;

    /* JADX INFO: renamed from: n */
    private Button f3828n;

    /* JADX INFO: renamed from: o */
    private Button f3829o;

    /* JADX INFO: renamed from: p */
    private TextView f3830p;

    /* JADX INFO: renamed from: q */
    private C1344a f3831q;

    /* JADX INFO: renamed from: r */
    private String f3832r;

    /* JADX INFO: renamed from: s */
    private String f3833s;

    /* JADX INFO: renamed from: t */
    private boolean f3834t = false;

    /* JADX INFO: renamed from: u */
    private boolean f3835u;

    /* JADX INFO: renamed from: v */
    private C1470b f3836v;

    /* JADX INFO: renamed from: w */
    private String f3837w;

    /* JADX INFO: renamed from: x */
    private InterfaceC0515j f3838x;

    /* JADX INFO: renamed from: y */
    private long f3839y;

    /* JADX INFO: renamed from: z */
    private ArrayList f3840z;

    /* JADX INFO: renamed from: a */
    private boolean m3231a() {
        try {
            new C1469a();
            C1470b c1470bM3488a = C1469a.m3488a(this, this.f3832r);
            if (c1470bM3488a == null) {
                return false;
            }
            getPackageManager().getPackageInfo(c1470bM3488a.f4291b, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3233b() {
        if (!this.f3835u) {
            this.f3826l.setImageResource(R.drawable.ic_close);
            this.f3827m.setText(this.f3833s);
            this.f3828n.setVisibility(8);
            this.f3829o.setVisibility(8);
            return;
        }
        String str = getResources().getString(R.string.carlos) + "" + String.format(getResources().getString(R.string.apk_savedas_1), this.f3832r) + "\n\n";
        if (m3231a()) {
            String str2 = str + getResources().getString(R.string.remove_tip);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(12, true);
            int length = str.length();
            int length2 = str2.length();
            spannableStringBuilder.setSpan(absoluteSizeSpan, length, length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, C0037k.mdTextSmall(C0037k.m89a(this)))), length, length2, 33);
            this.f3827m.setText(spannableStringBuilder);
            this.f3828n.setVisibility(0);
        } else {
            this.f3827m.setText(str);
            this.f3828n.setVisibility(8);
        }
        this.f3826l.setImageResource(R.drawable.ic_select);
    }

    /* JADX INFO: renamed from: b */
    private void m3234b(boolean z) {
        this.f3826l = (ImageView) findViewById(R.id.result_image);
        this.f3827m = (TextView) findViewById(R.id.result);
        this.f3830p = (TextView) findViewById(R.id.tv_detail);
        this.f3828n = (Button) findViewById(R.id.button_uninstall);
        this.f3829o = (Button) findViewById(R.id.button_reinstall);
        Button button = (Button) findViewById(R.id.button_close);
        this.f3828n.setOnClickListener(this);
        this.f3829o.setOnClickListener(this);
        button.setOnClickListener(this);
        this.f3824j = (LinearLayout) findViewById(R.id.layout_apk_generating);
        this.f3825k = (LinearLayout) findViewById(R.id.layout_apk_reinstall);
        if (z) {
            this.f3824j.setVisibility(4);
            this.f3825k.setVisibility(0);
        } else {
            this.f3824j.setVisibility(0);
            this.f3825k.setVisibility(4);
        }
        if (this.f3834t) {
            m3233b();
        }
    }

    /* JADX INFO: renamed from: c */
    private long m3235c() {
        long j = PreferenceManager.getDefaultSharedPreferences(this).getLong("LastPopAdTime", 0L);
        if (j < System.currentTimeMillis()) {
            return j;
        }
        return 0L;
    }

    /* JADX INFO: renamed from: g */
    static /* synthetic */ void m3240g(ApkCreateActivity apkCreateActivity) throws IOException {
        if (apkCreateActivity.f3818d == null || apkCreateActivity.f3818d.isEmpty()) {
            return;
        }
        ZipFile zipFile = new ZipFile(apkCreateActivity.f3816b);
        HashMap map = new HashMap();
        for (Map.Entry entry : apkCreateActivity.f3818d.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            List arrayList = (List) map.get(str2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(str2, arrayList);
            }
            arrayList.add(str);
        }
        for (String str3 : map.keySet()) {
            List<String> list = (List) map.get(str3);
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str3);
            for (String str4 : list) {
                InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(str4));
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, null, options);
                int i = options.outWidth;
                int i2 = options.outHeight;
                int width = bitmapDecodeFile.getWidth();
                int height = bitmapDecodeFile.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(i / width, i2 / height);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, width, height, matrix, true);
                String str5 = apkCreateActivity.f3837w + str4.replaceAll("/", "_");
                FileOutputStream fileOutputStream = new FileOutputStream(str5);
                if (str5.endsWith(".png")) {
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
                } else {
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                }
                fileOutputStream.close();
                apkCreateActivity.f3819e.put(str4, str5);
            }
        }
        zipFile.close();
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.InterfaceC1028f
    /* JADX INFO: renamed from: a */
    public final void mo2755a(String str) {
        this.f3815a.m3263a(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m3246a(boolean z) {
        this.f3835u = z;
        if (z) {
            this.f3832r = this.f3831q.f3868b;
            if (this.f3838x != null && this.f3838x.m794b()) {
                Toast.makeText(this, R.string.show_ad_tip, 0).show();
            }
        } else {
            this.f3833s = this.f3831q.m3258a();
            System.currentTimeMillis();
            m3235c();
        }
        m3233b();
        this.f3824j.setVisibility(4);
        this.f3825k.setVisibility(0);
        this.f3834t = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        int id = view.getId();
        if (id == R.id.button_uninstall) {
            if (this.f3836v != null) {
                startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + this.f3836v.f4291b)));
            }
        } else if (id == R.id.button_reinstall) {
            C0985a.m2204a(this, this.f3832r);
        } else if (id == R.id.button_close) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.activity_simpleedit_making);
        if (bundle != null) {
            this.f3816b = bundle.getString("apkPath");
            this.f3817c = bundle.getString("packageName");
            this.f3834t = bundle.getBoolean("modifyFinished");
            this.f3835u = bundle.getBoolean("succeed");
            this.f3832r = bundle.getString("outApkPath");
            this.f3833s = bundle.getString("errorMessage");
        } else {
            Intent intent = getIntent();
            this.f3816b = C0985a.m2195a(intent, "apkPath");
            this.f3817c = C0985a.m2195a(intent, "packageName");
            this.f3818d = C0985a.m2265d(intent, "imageReplaces");
            Map mapM2265d = C0985a.m2265d(intent, "otherReplaces");
            this.f3840z = (ArrayList) intent.getExtras().getSerializable("interfaces");
            this.f3819e = new HashMap();
            if (mapM2265d != null) {
                this.f3819e.putAll(mapM2265d);
            }
            try {
                this.f3837w = C0985a.m2263d(this, "tmp");
            } catch (Exception e) {
            }
            this.f3822h = C0985a.m2195a(intent, "oldAppNameInArsc");
            this.f3823i = C0985a.m2195a(intent, "newAppNameInArsc");
            this.f3821g = C0985a.m2195a(intent, "newPackageNameInArsc");
            this.f3820f = C0985a.m2265d(intent, "classRenames");
        }
        try {
            new C1469a();
            this.f3836v = C1469a.m3488a(this, this.f3816b);
        } catch (Exception e2) {
            Toast.makeText(this, getResources().getString(R.string.cannot_parse_apk) + ": " + e2.getMessage(), 1).show();
        }
        this.f3815a = new HandlerC1346b(this);
        if (this.f3834t) {
            m3234b(true);
            return;
        }
        this.f3831q = new C1344a(this);
        this.f3831q.start();
        m3234b(false);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("apkPath", this.f3816b);
        bundle.putString("packageName", this.f3817c);
        bundle.putString("outApkPath", this.f3832r);
        bundle.putString("errorMessage", this.f3833s);
        bundle.putBoolean("modifyFinished", this.f3834t);
        bundle.putBoolean("succeed", this.f3835u);
        super.onSaveInstanceState(bundle);
    }
}
