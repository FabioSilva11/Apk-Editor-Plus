package com.gmail.heagoo.appdm;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.appdm.util.C1440e;
import com.gmail.heagoo.appdm.util.C1443i;
import com.gmail.heagoo.common.C1471c;
import com.gmail.heagoo.common.DialogC1484p;
import com.gmail.heagoo.common.ccc;
import com.gmail.heagoo.p054a.p059c.C0986ax;
import com.gmail.heagoo.p070b.C1450a;
import com.gmail.heagoo.sqliteutil.C1549c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class PrefOverallActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: A */
    private Drawable f4102A;

    /* JADX INFO: renamed from: B */
    private Drawable f4103B;

    /* JADX INFO: renamed from: C */
    private Drawable f4104C;

    /* JADX INFO: renamed from: D */
    private Drawable f4105D;

    /* JADX INFO: renamed from: G */
    private boolean f4107G;

    /* JADX INFO: renamed from: H */
    private boolean f4108H;

    /* JADX INFO: renamed from: K */
    private long f4110K;

    /* JADX INFO: renamed from: L */
    private long f4111L;

    /* JADX INFO: renamed from: M */
    private long f4112M;

    /* JADX INFO: renamed from: O */
    private int f4114O;

    /* JADX INFO: renamed from: P */
    private boolean f4115P;

    /* JADX INFO: renamed from: a */
    String f4116a;

    /* JADX INFO: renamed from: c */
    private String f4118c;

    /* JADX INFO: renamed from: d */
    private C1411ac f4119d;

    /* JADX INFO: renamed from: e */
    private ListView f4120e;

    /* JADX INFO: renamed from: f */
    private ListView f4121f;

    /* JADX INFO: renamed from: g */
    private ListView f4122g;

    /* JADX INFO: renamed from: h */
    private ListView f4123h;

    /* JADX INFO: renamed from: i */
    private LinearLayout f4124i;

    /* JADX INFO: renamed from: j */
    private ProgressBar f4125j;

    /* JADX INFO: renamed from: k */
    private TextView f4126k;

    /* JADX INFO: renamed from: l */
    private PackageManager f4127l;

    /* JADX INFO: renamed from: m */
    private ApplicationInfo f4128m;

    /* JADX INFO: renamed from: n */
    private PackageInfo f4129n;

    /* JADX INFO: renamed from: o */
    private String f4130o;

    /* JADX INFO: renamed from: p */
    private C1412ad f4131p;

    /* JADX INFO: renamed from: s */
    private RadioButton f4134s;

    /* JADX INFO: renamed from: t */
    private RadioButton f4135t;

    /* JADX INFO: renamed from: u */
    private RadioButton f4136u;

    /* JADX INFO: renamed from: v */
    private RadioButton f4137v;

    /* JADX INFO: renamed from: w */
    private Drawable f4138w;

    /* JADX INFO: renamed from: x */
    private Drawable f4139x;

    /* JADX INFO: renamed from: y */
    private Drawable f4140y;

    /* JADX INFO: renamed from: z */
    private Drawable f4141z;

    /* JADX INFO: renamed from: q */
    private List f4132q = new ArrayList();

    /* JADX INFO: renamed from: r */
    private List f4133r = new ArrayList();

    /* JADX INFO: renamed from: E */
    private int f4106E = -1;

    /* JADX INFO: renamed from: b */
    int f4117b = 0;

    /* JADX INFO: renamed from: J */
    private boolean f4109J = false;

    /* JADX INFO: renamed from: N */
    private int f4113N = 0;

    /* JADX INFO: renamed from: a */
    static /* synthetic */ String m3394a(PrefOverallActivity prefOverallActivity, String str) {
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = str.substring(iLastIndexOf);
            if (strSubstring.contains("/")) {
                strSubstring = null;
            }
        } else {
            strSubstring = null;
        }
        StringBuilder sbAppend = new StringBuilder().append(C1443i.m3465b(prefOverallActivity)).append("/_work");
        if (strSubstring == null) {
            strSubstring = "";
        }
        String string = sbAppend.append(strSubstring).toString();
        ccc cccVarM3429g = prefOverallActivity.m3429g();
        File file = new File(prefOverallActivity.getFilesDir(), "mycp");
        if (cccVarM3429g.mo3498a(String.format((file.exists() ? file.getPath() : "cp") + " \"%s\" %s", str, string), null, 5000, false)) {
            return string;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m3396a(String str, String str2) {
        new DialogC1484p(this, new C1434s(this, str, str2), -1).show();
    }

    /* JADX INFO: renamed from: a */
    private void m3397a(List list) {
        String[] strArr;
        Resources resources = getResources();
        this.f4130o = this.f4128m.loadLabel(this.f4127l).toString();
        list.add(new C1422g(resources.getString(R.string.appdm_app_name), this.f4130o));
        list.add(new C1422g(resources.getString(R.string.appdm_package_name), this.f4118c));
        File file = new File(this.f4128m.sourceDir);
        String string = "";
        long length = 0;
        if (Build.VERSION.SDK_INT >= 21 && (strArr = this.f4128m.splitSourceDirs) != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                sb.append("\n" + strArr[i]);
                length += new File(strArr[i]).length();
            }
            string = sb.toString();
        }
        list.add(new C1422g(resources.getString(R.string.appdm_app_size), C1443i.m3462a(length + file.length())));
        list.add(new C1422g(resources.getString(R.string.appdm_version), resources.getString(R.string.appdm_version_code) + ": " + this.f4129n.versionCode + "\n" + resources.getString(R.string.appdm_version_name) + ": " + this.f4129n.versionName));
        list.add(new C1422g(resources.getString(R.string.appdm_apk_file_path), this.f4128m.sourceDir + string, resources.getString(R.string.save), new ViewOnClickListenerC1429n(this)));
        try {
            ZipFile zipFile = new ZipFile(this.f4128m.sourceDir);
            ZipEntry entry = zipFile.getEntry(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
            ZipEntry entry2 = zipFile.getEntry("classes.dex");
            long time = entry != null ? entry.getTime() : Long.MIN_VALUE;
            long time2 = entry2 != null ? entry2.getTime() : Long.MIN_VALUE;
            if (time2 < time) {
                time2 = time;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time2);
            list.add(new C1422g(resources.getString(R.string.appdm_apk_build_time), calendar.getTime().toString()));
            zipFile.close();
        } catch (IOException e) {
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(file.lastModified());
        list.add(new C1422g(resources.getString(R.string.appdm_install_time), calendar2.getTime().toString()));
        list.add(new C1422g(resources.getString(R.string.appdm_signature), C0986ax.i_009(this.f4128m.sourceDir)));
    }

    /* JADX INFO: renamed from: d */
    static /* synthetic */ void m3400d(PrefOverallActivity prefOverallActivity) {
        prefOverallActivity.f4120e.setAdapter((ListAdapter) new C1425j(prefOverallActivity, prefOverallActivity.f4132q, prefOverallActivity.f4115P));
        prefOverallActivity.f4120e.setOnItemClickListener(new C1449z(prefOverallActivity));
    }

    /* JADX INFO: renamed from: e */
    static /* synthetic */ void m3401e(PrefOverallActivity prefOverallActivity) {
        prefOverallActivity.f4121f.setAdapter((ListAdapter) new C1425j(prefOverallActivity, prefOverallActivity.f4133r, prefOverallActivity.f4115P));
        prefOverallActivity.f4121f.setOnItemClickListener(new C1409aa(prefOverallActivity));
    }

    /* JADX INFO: renamed from: a */
    protected final void m3421a() {
        String[] strArr;
        new DialogC1408a(this, this.f4128m.sourceDir, this.f4130o).m3432a();
        if (Build.VERSION.SDK_INT < 21 || (strArr = this.f4128m.splitSourceDirs) == null || strArr.length <= 0) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            String name = new File(strArr[i]).getName();
            new DialogC1408a(this, strArr[i], this.f4130o + "_" + name.substring(0, name.lastIndexOf(".apk"))).m3432a();
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m3422a(int i) {
        String strSubstring;
        ArrayList arrayList = new ArrayList();
        String strM3445a = this.f4131p.m3445a(arrayList);
        if (i < arrayList.size()) {
            C1440e c1440e = (C1440e) arrayList.get(i);
            if (c1440e.f4245c) {
                String str = c1440e.f4243a;
                if ("..".equals(str)) {
                    int iLastIndexOf = strM3445a.lastIndexOf(47);
                    strSubstring = iLastIndexOf != -1 ? strM3445a.substring(0, iLastIndexOf) : strM3445a;
                } else {
                    strSubstring = strM3445a + "/" + str;
                }
                new DialogC1484p(this, new C1433r(this, strSubstring), -1).show();
                return;
            }
            String str2 = strM3445a + "/" + c1440e.f4243a;
            String str3 = c1440e.f4243a;
            String str4 = str3.endsWith(".xml") ? "xml.xml" : (str3.endsWith(".html") || str3.endsWith(".htm")) ? "html.xml" : str3.endsWith(".css") ? "css.xml" : str3.endsWith(".java") ? "java.xml" : str3.endsWith(".json") ? "json.xml" : str3.endsWith(".txt") ? "txt.xml" : str3.endsWith(".js") ? "js.xml" : null;
            if (str4 != null) {
                m3396a(str2, str4);
            } else {
                new DialogC1484p(this, new C1435t(this, str2), -1).show();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3423a(boolean z) {
        synchronized (this) {
            this.f4106E = z ? 1 : 0;
            this.f4116a = this.f4119d.m3437c();
        }
        runOnUiThread(new RunnableC1436u(this, z));
    }

    /* JADX INFO: renamed from: b */
    protected final void m3424b() {
        switch (this.f4117b) {
            case 0:
                m3425c();
                break;
            case 1:
                m3426d();
                break;
            case 2:
                m3427e();
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    protected final void m3425c() {
        this.f4122g.setVisibility(0);
        this.f4120e.setVisibility(4);
        this.f4121f.setVisibility(4);
        this.f4123h.setVisibility(4);
        this.f4124i.setVisibility(4);
    }

    /* JADX INFO: renamed from: d */
    protected final void m3426d() {
        synchronized (this) {
            switch (this.f4106E) {
                case -1:
                    this.f4120e.setVisibility(4);
                    this.f4124i.setVisibility(0);
                    break;
                case 0:
                    this.f4120e.setVisibility(4);
                    this.f4124i.setVisibility(0);
                    this.f4125j.setVisibility(8);
                    this.f4126k.setText(this.f4116a);
                    break;
                case 1:
                    this.f4124i.setVisibility(4);
                    this.f4120e.setVisibility(0);
                    break;
            }
        }
        this.f4122g.setVisibility(4);
        this.f4121f.setVisibility(4);
        this.f4123h.setVisibility(4);
    }

    /* JADX INFO: renamed from: e */
    protected final void m3427e() {
        synchronized (this) {
            switch (this.f4106E) {
                case -1:
                    this.f4121f.setVisibility(4);
                    this.f4124i.setVisibility(0);
                    break;
                case 0:
                    this.f4121f.setVisibility(4);
                    this.f4124i.setVisibility(0);
                    this.f4125j.setVisibility(8);
                    this.f4126k.setText(this.f4116a);
                    break;
                case 1:
                    this.f4124i.setVisibility(4);
                    this.f4121f.setVisibility(0);
                    break;
            }
        }
        this.f4122g.setVisibility(4);
        this.f4120e.setVisibility(4);
        this.f4123h.setVisibility(4);
    }

    /* JADX INFO: renamed from: f */
    protected final void m3428f() {
        this.f4124i.setVisibility(4);
        this.f4122g.setVisibility(4);
        this.f4120e.setVisibility(4);
        this.f4121f.setVisibility(4);
        this.f4123h.setVisibility(0);
    }

    /* JADX INFO: renamed from: g */
    protected final ccc m3429g() {
        return this.f4107G ? new C1549c() : new C1471c();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            this.f4111L = System.currentTimeMillis();
            if (i2 == 1) {
                this.f4109J = true;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_backup) {
            C0986ax.a_010("com.gmail.heagoo.appdm.free.a", "s", new Class[]{Activity.class, C1450a.class}, new Object[]{this, C1450a.a(this.f4127l, this.f4128m)});
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        this.f4114O = C0986ax.c_006(intent, "themeId");
        this.f4115P = this.f4114O != 0;
        setContentView(R.layout.appdm_activity_dataoverview);
        this.f4118c = C0986ax.a_008(intent, "packagePath");
        this.f4108H = C0986ax.b_007(intent, "backup");
        try {
            this.f4127l = getPackageManager();
            this.f4128m = this.f4127l.getApplicationInfo(this.f4118c, 0);
            this.f4129n = this.f4127l.getPackageInfo(this.f4118c, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.f4112M = System.currentTimeMillis();
        this.f4107G = true;
        try {
            if (this.f4129n.sharedUserId != null && this.f4129n.sharedUserId.equals(this.f4127l.getPackageInfo(getPackageName(), 0).sharedUserId)) {
                this.f4107G = false;
            }
        } catch (PackageManager.NameNotFoundException e2) {
        }
        ((ImageView) findViewById(R.id.app_icon)).setImageDrawable(this.f4128m.loadIcon(this.f4127l));
        ((TextView) findViewById(R.id.app_name)).setText(this.f4128m.loadLabel(this.f4127l));
        ((TextView) findViewById(R.id.app_pkgpath)).setText(this.f4128m.packageName);
        Button button = (Button) findViewById(R.id.button_backup);
        if (this.f4108H) {
            button.setOnClickListener(this);
        } else {
            button.setVisibility(8);
        }
        this.f4122g = (ListView) findViewById(R.id.appInfo_list);
        this.f4120e = (ListView) findViewById(R.id.preference_list);
        this.f4121f = (ListView) findViewById(R.id.database_list);
        this.f4123h = (ListView) findViewById(R.id.files_list);
        this.f4124i = (LinearLayout) findViewById(R.id.layout_scanning);
        this.f4125j = (ProgressBar) findViewById(R.id.progress_bar);
        this.f4126k = (TextView) findViewById(R.id.tv_tip);
        ArrayList arrayList = new ArrayList();
        m3397a(arrayList);
        this.f4122g.setAdapter((ListAdapter) new C1420e(this, arrayList, this.f4115P));
        String path = getFilesDir().getPath();
        this.f4131p = new C1412ad(this, path.substring(0, path.indexOf(getPackageName())) + this.f4118c + "/files", this.f4107G, this.f4115P);
        this.f4123h.setAdapter((ListAdapter) this.f4131p);
        this.f4123h.setOnItemClickListener(new C1410ab(this));
        this.f4123h.setOnItemLongClickListener(new C1430o(this));
        Resources resources = getResources();
        this.f4138w = resources.getDrawable(R.drawable.appdm_info);
        this.f4139x = resources.getDrawable(R.drawable.appdm_info_blue);
        this.f4140y = resources.getDrawable(R.drawable.appdm_config);
        this.f4141z = resources.getDrawable(R.drawable.appdm_config_blue);
        this.f4102A = resources.getDrawable(R.drawable.appdm_db);
        this.f4103B = resources.getDrawable(R.drawable.appdm_db_blue);
        this.f4104C = resources.getDrawable(R.drawable.appdm_files);
        this.f4105D = resources.getDrawable(R.drawable.appdm_files_blue);
        this.f4134s = (RadioButton) findViewById(R.id.tab_appinfo);
        this.f4135t = (RadioButton) findViewById(R.id.tab_preference);
        this.f4136u = (RadioButton) findViewById(R.id.tab_database);
        this.f4137v = (RadioButton) findViewById(R.id.tab_files);
        this.f4134s.setOnClickListener(new ViewOnClickListenerC1445v(this));
        this.f4135t.setOnClickListener(new ViewOnClickListenerC1446w(this));
        this.f4136u.setOnClickListener(new ViewOnClickListenerC1447x(this));
        this.f4137v.setOnClickListener(new ViewOnClickListenerC1448y(this));
        this.f4119d = new C1411ac(this);
        this.f4119d.start();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
