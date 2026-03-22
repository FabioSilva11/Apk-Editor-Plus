package com.gmail.heagoo.appdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.appdm.util.FileCopyUtil;
import com.gmail.heagoo.common.C1471c;
import com.gmail.heagoo.common.ccc;
import com.gmail.heagoo.neweditor.EditorActivity;
import com.gmail.heagoo.p054a.p059c.C0986ax;
import com.gmail.heagoo.sqliteutil.C1549c;
import com.gmail.heagoo.sqliteutil.p072a.InterfaceC1547c;
import com.gmail.heagoo.sqliteutil.p072a.ViewOnClickListenerC1546b;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PrefDetailActivity extends Activity implements View.OnClickListener, InterfaceC1547c {

    /* JADX INFO: renamed from: a */
    protected String f4086a;

    /* JADX INFO: renamed from: b */
    protected String f4087b;

    /* JADX INFO: renamed from: c */
    private String f4088c;

    /* JADX INFO: renamed from: d */
    private C1428m f4089d;

    /* JADX INFO: renamed from: e */
    private ScrollView f4090e;

    /* JADX INFO: renamed from: f */
    private ProgressBar f4091f;

    /* JADX INFO: renamed from: g */
    private TableLayout f4092g;

    /* JADX INFO: renamed from: h */
    private LinkedHashMap f4093h;

    /* JADX INFO: renamed from: i */
    private LinkedHashMap f4094i;

    /* JADX INFO: renamed from: j */
    private ArrayList f4095j;

    /* JADX INFO: renamed from: l */
    private boolean f4096l;

    /* JADX INFO: renamed from: m */
    private ViewOnClickListenerC1546b f4097m;

    /* JADX INFO: renamed from: n */
    private HandlerC1427l f4098n = new HandlerC1427l(this);

    /* JADX INFO: renamed from: o */
    private Button f4099o;

    /* JADX INFO: renamed from: p */
    private int f4100p;

    /* JADX INFO: renamed from: q */
    private boolean f4101q;

    /* JADX INFO: renamed from: a */
    static /* synthetic */ ccc m3383a(boolean z) {
        return z ? new C1549c() : new C1471c();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3384a(PrefDetailActivity prefDetailActivity) {
        prefDetailActivity.f4097m.m3760b();
        prefDetailActivity.f4090e.setVisibility(0);
        prefDetailActivity.f4099o.setVisibility(0);
        prefDetailActivity.f4091f.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3385a(PrefDetailActivity prefDetailActivity, LinkedHashMap linkedHashMap) {
        if (linkedHashMap != null) {
            prefDetailActivity.f4093h = linkedHashMap;
            prefDetailActivity.f4095j = new ArrayList();
            for (String str : linkedHashMap.keySet()) {
                ArrayList arrayList = new ArrayList();
                Object obj = linkedHashMap.get(str);
                String string = "";
                if (obj != null) {
                    string = obj.toString();
                }
                arrayList.add(str);
                arrayList.add(string);
                prefDetailActivity.f4095j.add(arrayList);
            }
            if (prefDetailActivity.f4097m == null) {
                prefDetailActivity.f4097m = new ViewOnClickListenerC1546b(prefDetailActivity, null, prefDetailActivity.f4092g, prefDetailActivity, prefDetailActivity.f4101q);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("Key");
            arrayList2.add("Value");
            prefDetailActivity.f4097m.m3758a(arrayList2);
            prefDetailActivity.f4097m.m3759a((List) prefDetailActivity.f4095j);
            prefDetailActivity.f4097m.m3757a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3387a() {
        this.f4089d = new C1428m(this);
        this.f4089d.start();
    }

    @Override // com.gmail.heagoo.sqliteutil.p072a.InterfaceC1547c
    /* JADX INFO: renamed from: a */
    public final void mo3388a(int i, boolean z) {
        if (z) {
            new DialogC1423h(this, this.f4093h, i, true, this.f4100p).show();
        } else {
            new DialogC1423h(this, this.f4094i, i, true, this.f4100p).show();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3389a(String str) {
        if (str == null) {
            this.f4098n.sendEmptyMessage(0);
        } else {
            this.f4098n.m3451a(str);
            this.f4098n.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3390a(String str, Object obj) {
        this.f4093h.put(str, obj);
        if (this.f4096l) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f4087b);
            C0986ax.a_005(this.f4093h, fileOutputStream);
            fileOutputStream.close();
            FileCopyUtil.copyBack(this, this.f4087b, this.f4086a, this.f4096l);
        } else {
            FileOutputStream fileOutputStream2 = new FileOutputStream(this.f4086a);
            C0986ax.a_005(this.f4093h, fileOutputStream2);
            fileOutputStream2.close();
        }
        setResult(1);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1000:
                if (i2 != 0) {
                    setResult(1);
                    m3387a();
                }
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_close) {
            finish();
            return;
        }
        if (id != R.id.button_search) {
            if (id == R.id.btn_raw_file) {
                Intent intent = new Intent(this, (Class<?>) EditorActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("filePath", this.f4087b);
                bundle.putString("realFilePath", this.f4086a);
                bundle.putBoolean("isRootMode", this.f4096l);
                bundle.putIntArray("resourceIds", new int[]{R.string.appdm_apk_file_path, R.string.appdm_apk_build_time, R.string.appdm_basic_info});
                intent.putExtras(bundle);
                startActivityForResult(intent, 1000);
                return;
            }
            return;
        }
        String strTrim = ((EditText) findViewById(R.id.tv_keyword)).getText().toString().trim();
        if (strTrim.equals("")) {
            Toast.makeText(this, R.string.warning_keyword_empty, 0).show();
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f4093h.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            boolean z = str.toLowerCase().contains(strTrim);
            if (!z && value != null && value.toString().toLowerCase().contains(strTrim)) {
                z = true;
            }
            if (z) {
                linkedHashMap.put(str, value);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                if (value != null) {
                    arrayList2.add(value.toString());
                } else {
                    arrayList2.add("");
                }
                arrayList.add(arrayList2);
            }
        }
        if (linkedHashMap.isEmpty()) {
            Toast.makeText(this, "No record found.", 0).show();
        } else {
            this.f4094i = linkedHashMap;
            this.f4097m.m3761b(arrayList);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f4100p = C0986ax.c_006(getIntent(), "themeId");
        this.f4101q = this.f4100p != 0;
        setContentView(R.layout.appdm_activity_prefdetail);
        try {
            "gplay".equals(getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getString("com.gmail.heagoo.publish_channel"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f4096l = C0986ax.b_007(getIntent(), "isRootMode");
        this.f4088c = C0986ax.a_008(getIntent(), "appName");
        this.f4086a = C0986ax.a_008(getIntent(), "xmlFilePath");
        this.f4090e = (ScrollView) findViewById(R.id.scroll_view);
        this.f4091f = (ProgressBar) findViewById(R.id.progress_bar);
        this.f4092g = (TableLayout) findViewById(R.id.valueTable);
        ((TextView) findViewById(R.id.tv_appname)).setText(this.f4088c);
        TextView textView = (TextView) findViewById(R.id.tv_prefname);
        String str = this.f4086a;
        textView.setText(str.substring(str.lastIndexOf("/") + 1).substring(0, r2.length() - 4));
        findViewById(R.id.button_close).setOnClickListener(this);
        this.f4099o = (Button) findViewById(R.id.button_search);
        this.f4099o.setVisibility(8);
        this.f4099o.setOnClickListener(this);
        findViewById(R.id.btn_raw_file).setOnClickListener(this);
        m3387a();
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
