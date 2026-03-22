package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.p068se.ApkCreateActivity;
import com.gmail.heagoo.apkeditor.p068se.C1370z;
import com.gmail.heagoo.apkeditor.p068se.InterfaceC1352h;
import com.gmail.heagoo.apkeditor.p068se.ViewOnClickListenerC1365u;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1470b;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.Map;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class AxmlEditActivity extends Activity implements View.OnClickListener, InterfaceC1352h {

    /* JADX INFO: renamed from: b */
    private String f2654b;

    /* JADX INFO: renamed from: c */
    private C1470b f2655c;

    /* JADX INFO: renamed from: e */
    private ViewOnClickListenerC1365u f2656e;

    /* JADX INFO: renamed from: f */
    private HandlerC1092bs f2657f;

    /* JADX INFO: renamed from: g */
    private C1093bt f2658g;

    /* JADX INFO: renamed from: h */
    private ListView f2659h;

    /* JADX INFO: renamed from: i */
    private Button f2660i;

    /* JADX INFO: renamed from: j */
    private TextView f2661j;

    /* JADX INFO: renamed from: k */
    private C1370z f2662k;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public String m2479a() {
        try {
            return getPackageManager().getApplicationInfo("com.gmail.heagoo.apkeditor.pro", 0).publicSourceDir;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2480a(AxmlEditActivity axmlEditActivity) throws Throwable {
        axmlEditActivity.f2662k = new C1370z(axmlEditActivity.f2654b);
        axmlEditActivity.f2662k.m3293a();
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ String m2482c(AxmlEditActivity axmlEditActivity) {
        new C1322m(axmlEditActivity, null, null, null).m3206a();
        return axmlEditActivity.getFilesDir().getAbsolutePath() + "/bin/";
    }

    @Override // com.gmail.heagoo.apkeditor.p068se.InterfaceC1352h
    /* JADX INFO: renamed from: a */
    public final void mo2486a(String str) {
        this.f2661j.setText(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m2487a(boolean z) {
        findViewById(R.id.progress_bar).setVisibility(8);
        if (!z) {
            Toast.makeText(this, this.f2658g.f3106a, 0).show();
            finish();
            return;
        }
        this.f2659h.setVisibility(0);
        this.f2656e = new ViewOnClickListenerC1365u(this, this, this.f2662k, true);
        this.f2659h.setAdapter((ListAdapter) this.f2656e);
        this.f2659h.setOnItemClickListener(this.f2656e);
        this.f2659h.setOnItemLongClickListener(this.f2656e);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == 1) {
            new DialogC1201ey(this, new C1094bu(this, intent.getStringExtra("xmlPath"), intent.getStringExtra("extraString")), -1).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_close) {
            finish();
            return;
        }
        if (id == R.id.btn_save) {
            Map mapM3287d = this.f2656e.m3287d();
            Intent intent = new Intent(this, (Class<?>) ApkCreateActivity.class);
            C0985a.m2180a(intent, "apkPath", this.f2654b);
            C0985a.m2180a(intent, "packageName", this.f2655c.f4291b);
            if (!mapM3287d.isEmpty()) {
                C0985a.m2206a(intent, "otherReplaces", mapM3287d);
            }
            startActivity(intent);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_axmledit);
        this.f2654b = C0985a.m2195a(getIntent(), "apkPath");
        try {
            new C1469a();
            this.f2655c = C1469a.m3488a(this, this.f2654b);
        } catch (Exception e) {
            Toast.makeText(this, getResources().getString(R.string.cannot_parse_apk) + ": " + e.getMessage(), 1).show();
        }
        if (this.f2655c == null) {
            finish();
            return;
        }
        this.f2657f = new HandlerC1092bs(this);
        this.f2658g = new C1093bt(this);
        this.f2658g.start();
        this.f2659h = (ListView) findViewById(R.id.files_list);
        this.f2661j = (TextView) findViewById(R.id.tv_summary);
        this.f2660i = (Button) findViewById(R.id.btn_save);
        Button button = (Button) findViewById(R.id.btn_close);
        this.f2659h.setVisibility(4);
        this.f2660i.setOnClickListener(this);
        button.setOnClickListener(this);
        if (this.f2655c != null) {
            ((ImageView) findViewById(R.id.apk_icon)).setImageDrawable(this.f2655c.f4292c);
            ((TextView) findViewById(R.id.apk_label)).setText(this.f2655c.f4290a);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (this.f2656e != null) {
            this.f2656e.m3288e();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("apkPath", this.f2654b);
        super.onSaveInstanceState(bundle);
    }
}
