package com.gmail.heagoo.apkeditor.p068se;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1470b;
import com.gmail.heagoo.common.DynamicExpandListView;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class SimpleEditActivity extends Activity implements View.OnClickListener, InterfaceC1352h {

    /* JADX INFO: renamed from: B */
    private C1370z f3842B;

    /* JADX INFO: renamed from: b */
    private String f3843b;

    /* JADX INFO: renamed from: c */
    private C1470b f3844c;

    /* JADX INFO: renamed from: d */
    private int f3845d;

    /* JADX INFO: renamed from: e */
    private ViewOnClickListenerC1365u f3846e;

    /* JADX INFO: renamed from: f */
    private ViewOnClickListenerC1353i f3847f;

    /* JADX INFO: renamed from: g */
    private ViewOnClickListenerC1347c f3848g;

    /* JADX INFO: renamed from: h */
    private HandlerC1360p f3849h;

    /* JADX INFO: renamed from: i */
    private C1362r f3850i;

    /* JADX INFO: renamed from: j */
    private ListView f3851j;

    /* JADX INFO: renamed from: k */
    private DynamicExpandListView f3852k;

    /* JADX INFO: renamed from: l */
    private ListView f3853l;

    /* JADX INFO: renamed from: m */
    private LinearLayout f3854m;

    /* JADX INFO: renamed from: o */
    private int f3856o;

    /* JADX INFO: renamed from: q */
    private ViewPager f3857q;

    /* JADX INFO: renamed from: r */
    private List f3858r;

    /* JADX INFO: renamed from: s */
    private View f3859s;

    /* JADX INFO: renamed from: t */
    private View f3860t;

    /* JADX INFO: renamed from: u */
    private View f3861u;

    /* JADX INFO: renamed from: v */
    private TextView f3862v;

    /* JADX INFO: renamed from: w */
    private TextView f3863w;

    /* JADX INFO: renamed from: x */
    private TextView f3864x;

    /* JADX INFO: renamed from: y */
    private Button f3865y;

    /* JADX INFO: renamed from: z */
    private TextView f3866z;

    /* JADX INFO: renamed from: n */
    private int f3855n = 0;

    /* JADX INFO: renamed from: A */
    private boolean f3841A = false;

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3248a(SimpleEditActivity simpleEditActivity) throws Throwable {
        C0985a.m2263d(simpleEditActivity, "tmp");
        simpleEditActivity.f3842B = new C1370z(simpleEditActivity.f3843b);
        simpleEditActivity.f3842B.m3293a();
    }

    /* JADX INFO: renamed from: f */
    static /* synthetic */ void m3252f(SimpleEditActivity simpleEditActivity) {
        if (simpleEditActivity.f3845d == 2) {
            simpleEditActivity.f3862v.setTextColor(-1);
            simpleEditActivity.f3863w.setTextColor(-1);
            simpleEditActivity.f3864x.setTextColor(-1);
        } else {
            simpleEditActivity.f3862v.setTextColor(simpleEditActivity.getResources().getColor(C0037k.mdNavNormal(C0037k.m89a(simpleEditActivity))));
            simpleEditActivity.f3862v.setBackgroundResource(R.drawable.mtrl_nav_bg_unchecked);
            simpleEditActivity.f3863w.setTextColor(simpleEditActivity.getResources().getColor(C0037k.mdNavNormal(C0037k.m89a(simpleEditActivity))));
            simpleEditActivity.f3863w.setBackgroundResource(R.drawable.mtrl_nav_bg_unchecked);
            simpleEditActivity.f3864x.setTextColor(simpleEditActivity.getResources().getColor(C0037k.mdNavNormal(C0037k.m89a(simpleEditActivity))));
            simpleEditActivity.f3864x.setBackgroundResource(R.drawable.mtrl_nav_bg_unchecked);
        }
        switch (simpleEditActivity.f3855n) {
            case 0:
                simpleEditActivity.f3862v.setTextColor(simpleEditActivity.getResources().getColor(C0037k.mdNavActivated(C0037k.m89a(simpleEditActivity))));
                simpleEditActivity.f3862v.setBackgroundResource(R.drawable.mtrl_nav_bg_checked);
                simpleEditActivity.f3866z.setText(simpleEditActivity.f3846e.m3285c());
                break;
            case 1:
                simpleEditActivity.f3863w.setTextColor(simpleEditActivity.getResources().getColor(C0037k.mdNavActivated(C0037k.m89a(simpleEditActivity))));
                simpleEditActivity.f3863w.setBackgroundResource(R.drawable.mtrl_nav_bg_checked);
                if (simpleEditActivity.f3842B != null) {
                    simpleEditActivity.f3866z.setText(String.format((String) simpleEditActivity.getResources().getText(R.string.image_summary), Integer.valueOf(simpleEditActivity.f3842B.f3942a.size())));
                }
                break;
            case 2:
                simpleEditActivity.f3864x.setTextColor(simpleEditActivity.getResources().getColor(C0037k.mdNavActivated(C0037k.m89a(simpleEditActivity))));
                simpleEditActivity.f3864x.setBackgroundResource(R.drawable.mtrl_nav_bg_checked);
                if (simpleEditActivity.f3842B != null) {
                    simpleEditActivity.f3866z.setText(String.format((String) simpleEditActivity.getResources().getText(R.string.audio_summary), Integer.valueOf(simpleEditActivity.f3842B.f3945d.size())));
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3253a() {
        if (this.f3841A) {
            return;
        }
        this.f3865y.setText(R.string.save);
        this.f3865y.setTextColor(getResources().getColor(C0037k.mdGoogleBtnText(C0037k.m89a(this))));
        this.f3865y.setBackgroundResource(R.drawable.mtrl_google_btn);
        this.f3841A = true;
    }

    @Override // com.gmail.heagoo.apkeditor.p068se.InterfaceC1352h
    /* JADX INFO: renamed from: a */
    public final void mo2486a(String str) {
        this.f3866z.setText(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m3254a(boolean z) {
        findViewById(R.id.progress_bar).setVisibility(8);
        if (!z) {
            Toast.makeText(this, this.f3850i.f3911a, 0).show();
            finish();
            return;
        }
        this.f3854m.setVisibility(0);
        this.f3851j = (ListView) this.f3859s.findViewById(R.id.files_list);
        this.f3852k = (DynamicExpandListView) this.f3860t.findViewById(R.id.images_list);
        this.f3853l = (ListView) this.f3861u.findViewById(R.id.audios_list);
        this.f3846e = new ViewOnClickListenerC1365u(this, this, this.f3842B);
        this.f3851j.setAdapter((ListAdapter) this.f3846e);
        this.f3851j.setOnItemClickListener(this.f3846e);
        this.f3851j.setOnItemLongClickListener(this.f3846e);
        this.f3847f = new ViewOnClickListenerC1353i(this.f3852k, this, this.f3842B);
        this.f3852k.setAdapter((ListAdapter) this.f3847f);
        this.f3852k.setOnItemClickListener(this.f3847f);
        this.f3852k.setOnItemLongClickListener(this.f3847f);
        this.f3848g = new ViewOnClickListenerC1347c(this, this.f3842B);
        this.f3853l.setAdapter((ListAdapter) this.f3848g);
        this.f3853l.setOnItemClickListener(this.f3848g);
        this.f3853l.setOnItemLongClickListener(this.f3848g);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.files_label) {
            this.f3855n = 0;
            this.f3857q.setCurrentItem(this.f3855n);
            return;
        }
        if (id == R.id.audio_label) {
            this.f3855n = 2;
            this.f3857q.setCurrentItem(this.f3855n);
            return;
        }
        if (id == R.id.images_label) {
            this.f3855n = 1;
            this.f3857q.setCurrentItem(this.f3855n);
            return;
        }
        if (id == R.id.btn_close) {
            if (this.f3841A) {
                Map mapM3281a = this.f3847f.m3281a();
                Map mapM3287d = this.f3846e.m3287d();
                Map mapM3271b = this.f3848g.m3271b();
                Intent intent = new Intent(this, (Class<?>) ApkCreateActivity.class);
                C0985a.m2180a(intent, "apkPath", this.f3843b);
                C0985a.m2180a(intent, "packageName", this.f3844c.f4291b);
                C0985a.m2206a(intent, "imageReplaces", mapM3281a);
                if (!mapM3287d.isEmpty() || !mapM3271b.isEmpty()) {
                    mapM3287d.putAll(mapM3271b);
                    C0985a.m2206a(intent, "otherReplaces", mapM3287d);
                }
                startActivity(intent);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_simpleedit);
        this.f3843b = C0985a.m2195a(getIntent(), "apkPath");
        try {
            new C1469a();
            this.f3844c = C1469a.m3488a(this, this.f3843b);
        } catch (Exception e) {
            Toast.makeText(this, getResources().getString(R.string.cannot_parse_apk) + ": " + e.getMessage(), 1).show();
        }
        if (this.f3844c == null) {
            finish();
            return;
        }
        this.f3849h = new HandlerC1360p(this);
        this.f3850i = new C1362r(this);
        this.f3850i.start();
        int width = BitmapFactory.decodeResource(getResources(), R.drawable.pager_focus).getWidth();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f3856o = displayMetrics.widthPixels;
        new Matrix().postTranslate(((this.f3856o / 3) - width) / 2, 0.0f);
        this.f3854m = (LinearLayout) findViewById(R.id.center_layout);
        this.f3866z = (TextView) findViewById(R.id.tv_summary);
        this.f3862v = (TextView) findViewById(R.id.files_label);
        this.f3863w = (TextView) findViewById(R.id.images_label);
        this.f3864x = (TextView) findViewById(R.id.audio_label);
        this.f3865y = (Button) findViewById(R.id.btn_close);
        this.f3854m.setVisibility(4);
        this.f3862v.setOnClickListener(this);
        this.f3863w.setOnClickListener(this);
        this.f3864x.setOnClickListener(this);
        this.f3865y.setOnClickListener(this);
        if (this.f3844c != null) {
            ((ImageView) findViewById(R.id.apk_icon)).setImageDrawable(this.f3844c.f4292c);
            ((TextView) findViewById(R.id.apk_label)).setText(this.f3844c.f4290a);
        }
        this.f3857q = (ViewPager) findViewById(R.id.pagerView);
        this.f3858r = new ArrayList();
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f3859s = layoutInflater.inflate(R.layout.pageitem_files, (ViewGroup) null);
        this.f3860t = layoutInflater.inflate(R.layout.pageitem_images, (ViewGroup) null);
        this.f3861u = layoutInflater.inflate(R.layout.pageitem_audios, (ViewGroup) null);
        this.f3858r.add(this.f3859s);
        this.f3858r.add(this.f3860t);
        this.f3858r.add(this.f3861u);
        this.f3857q.setAdapter(new C1363s(this, this.f3858r));
        this.f3857q.setCurrentItem(0);
        this.f3857q.setOnPageChangeListener(new C1361q(this));
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (this.f3846e != null) {
            this.f3846e.m3288e();
        }
        if (this.f3848g != null) {
            this.f3848g.m3270a();
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
        bundle.putString("apkPath", this.f3843b);
        super.onSaveInstanceState(bundle);
    }
}
