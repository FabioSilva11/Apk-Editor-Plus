package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.apkeditor.util.C1379c;
import com.gmail.heagoo.apkeditor.util.C1380d;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1470b;
import com.gmail.heagoo.common.C1479k;
import com.gmail.heagoo.common.InterfaceC1478j;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import java.io.File;
import java.util.Map;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class ApkComposeActivity extends Activity implements View.OnClickListener, InterfaceC1478j {

    /* JADX INFO: renamed from: A */
    private BinderC1318k f2493A;

    /* JADX INFO: renamed from: B */
    private C1380d f2494B;

    /* JADX INFO: renamed from: C */
    private boolean f2495C;

    /* JADX INFO: renamed from: E */
    private String f2497E;

    /* JADX INFO: renamed from: a */
    protected String f2498a;

    /* JADX INFO: renamed from: b */
    private LinearLayout f2499b;

    /* JADX INFO: renamed from: c */
    private LinearLayout f2500c;

    /* JADX INFO: renamed from: d */
    private TextView f2501d;

    /* JADX INFO: renamed from: e */
    private TextView f2502e;

    /* JADX INFO: renamed from: f */
    private ListView f2503f;

    /* JADX INFO: renamed from: g */
    private ImageView f2504g;

    /* JADX INFO: renamed from: h */
    private Button f2505h;

    /* JADX INFO: renamed from: i */
    private Button f2506i;

    /* JADX INFO: renamed from: j */
    private LinearLayout f2507j;

    /* JADX INFO: renamed from: k */
    private TextView f2508k;

    /* JADX INFO: renamed from: l */
    private TextView f2509l;

    /* JADX INFO: renamed from: m */
    private Button f2510m;

    /* JADX INFO: renamed from: n */
    private Button f2511n;

    /* JADX INFO: renamed from: o */
    private Button f2512o;

    /* JADX INFO: renamed from: p */
    private Button f2513p;

    /* JADX INFO: renamed from: r */
    private HandlerC1203f f2515r;

    /* JADX INFO: renamed from: s */
    private C1479k f2516s;

    /* JADX INFO: renamed from: t */
    private String f2517t;

    /* JADX INFO: renamed from: u */
    private long f2518u;

    /* JADX INFO: renamed from: v */
    private String f2519v;

    /* JADX INFO: renamed from: w */
    private String f2520w;

    /* JADX INFO: renamed from: x */
    private String f2521x;

    /* JADX INFO: renamed from: y */
    private boolean f2522y;

    /* JADX INFO: renamed from: z */
    private boolean f2523z;

    /* JADX INFO: renamed from: q */
    private boolean f2514q = false;

    /* JADX INFO: renamed from: D */
    private ServiceConnection f2496D = new ServiceConnectionC1100c(this);

    /* JADX INFO: renamed from: b */
    private boolean m2322b(String str) {
        try {
            getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ boolean m2324c(ApkComposeActivity apkComposeActivity, boolean z) {
        apkComposeActivity.f2514q = true;
        return true;
    }

    /* JADX INFO: renamed from: d */
    private String m2325d() {
        try {
            new C1469a();
            C1470b c1470bM3488a = C1469a.m3488a(this, this.f2519v);
            if (c1470bM3488a != null) {
                return c1470bM3488a.f4291b;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    static /* synthetic */ InterfaceC0515j m2327e(ApkComposeActivity apkComposeActivity) {
        return null;
    }

    @Override // com.gmail.heagoo.common.InterfaceC1478j
    /* JADX INFO: renamed from: a */
    public final void mo2333a() {
        this.f2515r.sendEmptyMessage(2);
    }

    @Override // com.gmail.heagoo.common.InterfaceC1478j
    /* JADX INFO: renamed from: a */
    public final void mo2334a(C1479k c1479k) {
        this.f2516s = c1479k;
        this.f2515r.sendEmptyMessage(1);
    }

    @Override // com.gmail.heagoo.common.InterfaceC1478j
    /* JADX INFO: renamed from: a */
    public final void mo2335a(String str) {
        this.f2517t = str;
        this.f2515r.sendEmptyMessage(3);
    }

    /* JADX INFO: renamed from: a */
    public final void m2336a(boolean z) {
        int i = -1;
        this.f2499b.setVisibility(4);
        this.f2500c.setVisibility(0);
        if (this.f2493A != null && this.f2495C) {
            this.f2493A.m3191a();
        }
        Button button = (Button) findViewById(R.id.btn_install);
        if (!z) {
            setResult(-1);
            findViewById(R.id.succeeded_view).setVisibility(8);
            findViewById(R.id.failed_view).setVisibility(0);
            this.f2503f.setDivider(null);
            this.f2503f.setAdapter((ListAdapter) new C1234g(this, this.f2517t));
            this.f2504g.setImageResource(R.drawable.ic_close);
            if (this.f2517t.contains("warning:")) {
                this.f2505h.setVisibility(0);
            } else {
                this.f2505h.setVisibility(8);
            }
            this.f2494B.m3324a(this.f2517t);
            if (this.f2494B.m3325a()) {
                switch (this.f2494B.m3326b()) {
                    case 0:
                        i = R.string.fix_invalid_name_tip;
                        break;
                    case 1:
                        i = R.string.fix_invalid_token_tip;
                        break;
                    case 2:
                        i = R.string.fix_invalid_attr_tip;
                        break;
                    case 3:
                        i = R.string.fix_invalid_symbol_tip;
                        break;
                    case 4:
                        i = R.string.fix_error_equivalent;
                        break;
                }
                this.f2508k.setText(i);
                this.f2507j.setVisibility(0);
            }
            button.setVisibility(8);
            this.f2506i.setVisibility(8);
            this.f2512o.setVisibility(0);
            return;
        }
        setResult(10005);
        button.setOnClickListener(this);
        findViewById(R.id.succeeded_view).setVisibility(0);
        findViewById(R.id.failed_view).setVisibility(8);
        this.f2504g.setImageResource(R.drawable.ic_select);
        String str = getResources().getString(R.string.carlos) + "" + String.format(getResources().getString(R.string.apk_savedas_1), this.f2519v) + "\n\n";
        if (this.f2523z) {
            this.f2520w = m2325d();
            if (m2322b(this.f2520w)) {
                String str2 = str + getResources().getString(R.string.remove_tip);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(12, true);
                int length = str.length();
                int length2 = str2.length();
                spannableStringBuilder.setSpan(absoluteSizeSpan, length, length2, 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, C0037k.mdTextSmall(C0037k.m89a(this)))), length, length2, 33);
                this.f2502e.setText(spannableStringBuilder);
                this.f2506i.setVisibility(0);
            } else {
                this.f2502e.setText(str);
                this.f2506i.setVisibility(8);
            }
            this.f2512o.setVisibility(8);
            button.setVisibility(0);
        } else {
            String str3 = str + getResources().getString(R.string.not_signed_tip);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str3);
            AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(12, true);
            int length3 = str.length();
            int length4 = str3.length();
            spannableStringBuilder2.setSpan(absoluteSizeSpan2, length3, length4, 18);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, C0037k.mdProgress(C0037k.m89a(this)))), length3, length4, 18);
            this.f2502e.setText(spannableStringBuilder2);
            this.f2512o.setVisibility(8);
            this.f2506i.setVisibility(8);
            button.setVisibility(8);
        }
        if (this.f2522y) {
            String property = System.getProperty("java.vm.version");
            if (property != null && property.charAt(0) > '1') {
                this.f2509l = (TextView) findViewById(R.id.tv_patch_tip);
                findViewById(R.id.patch_dex_layout).setVisibility(0);
                this.f2510m = (Button) findViewById(R.id.btn_patch);
                this.f2510m.setOnClickListener(this);
                return;
            }
        }
        findViewById(R.id.patch_dex_layout).setVisibility(8);
    }

    /* JADX INFO: renamed from: b */
    public final void m2337b() {
        this.f2501d.setText(String.format(getResources().getString(R.string.step) + " %d/%d: %s", Integer.valueOf(this.f2516s.f4305a), Integer.valueOf(this.f2516s.f4306b), this.f2516s.f4307c));
    }

    /* JADX INFO: renamed from: c */
    public final void m2338c() {
        if (this.f2493A != null) {
            Map mapM3327c = this.f2494B.m3327c();
            if (this.f2493A != null && !mapM3327c.isEmpty()) {
                this.f2493A.f3731a.f2538o = new C1379c(this.f2521x, mapM3327c);
            }
            this.f2501d.setText("");
            this.f2499b.setVisibility(0);
            this.f2500c.setVisibility(8);
            BinderC1318k binderC1318k = this.f2493A;
            binderC1318k.f3731a.m2350c();
            binderC1318k.f3731a.m2347b();
            binderC1318k.f3731a.m2352d();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f2493A == null || !this.f2493A.m3192b()) {
            finish();
            return;
        }
        if (C0985a.m2224a((Context) this, "donot_show_compose_tip", false)) {
            finish();
            return;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dlg_tip, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_message)).setText(R.string.build_still_running_tip);
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this).setTitle(R.string.tip).setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1148e(this, (CheckBox) viewInflate.findViewById(R.id.cb_show_once)));
        positiveButton.setView(viewInflate);
        positiveButton.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        int iLastIndexOf;
        File file;
        int id = view.getId();
        if (id == R.id.btn_close) {
            finish();
            return;
        }
        if (id == R.id.btn_install) {
            C0985a.m2204a(this, this.f2519v);
            return;
        }
        if (id == R.id.btn_remove) {
            if (this.f2520w != null) {
                startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + this.f2520w)));
                return;
            }
            return;
        }
        if (id == R.id.btn_copy_errmsg) {
            C0985a.m2257c(this, this.f2517t);
            Toast.makeText(this, R.string.errmsg_copied, 0).show();
            return;
        }
        if (id == R.id.btn_fix) {
            if (this.f2494B != null) {
                this.f2507j.setVisibility(8);
                this.f2494B.m3323a(this);
                return;
            }
            return;
        }
        if (id == R.id.btn_patch) {
            if (!this.f2514q) {
                new DialogC1201ey(this, new C1127d(this), -1).show();
                return;
            }
            try {
                Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.f2520w);
                if (launchIntentForPackage != null) {
                    startActivity(launchIntentForPackage);
                    return;
                }
                return;
            } catch (ActivityNotFoundException e) {
                return;
            }
        }
        if (id == R.id.btn_hide_warning) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.f2517t.split("\n")) {
                if (!str.startsWith("warning:")) {
                    sb.append(str);
                    sb.append("\n");
                }
            }
            C1234g c1234g = (C1234g) this.f2503f.getAdapter();
            c1234g.m3098a(sb.toString());
            c1234g.notifyDataSetChanged();
            this.f2505h.setVisibility(8);
            return;
        }
        if (id == R.id.btn_bg) {
            finish();
            return;
        }
        if (id != R.id.result || this.f2519v == null) {
            return;
        }
        String str2 = this.f2519v;
        if (!new File(str2).exists() || (iLastIndexOf = str2.lastIndexOf("/")) == -1 || (file = new File(str2.substring(0, iLastIndexOf + 1))) == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(file), "text/csv");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel("default", "default", 3);
            notificationChannel.setLightColor(0);
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            notificationChannel.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        this.f2497E = getIntent().getAction();
        getWindow().setFlags(128, 128);
        setContentView(R.layout.activity_apkcompose);
        this.f2515r = new HandlerC1203f(this);
        this.f2499b = (LinearLayout) findViewById(R.id.layout_apk_composing);
        this.f2500c = (LinearLayout) findViewById(R.id.layout_apk_composed);
        this.f2501d = (TextView) findViewById(R.id.progress_tip);
        this.f2502e = (TextView) findViewById(R.id.result);
        this.f2503f = (ListView) findViewById(R.id.failed_view);
        this.f2504g = (ImageView) findViewById(R.id.result_image);
        this.f2507j = (LinearLayout) findViewById(R.id.fix_layout);
        this.f2508k = (TextView) findViewById(R.id.tv_fix_tip);
        this.f2502e.setOnClickListener(this);
        this.f2500c.setVisibility(4);
        ((Button) findViewById(R.id.btn_close)).setOnClickListener(this);
        this.f2506i = (Button) findViewById(R.id.btn_remove);
        this.f2506i.setOnClickListener(this);
        this.f2511n = (Button) findViewById(R.id.btn_fix);
        this.f2511n.setOnClickListener(this);
        this.f2512o = (Button) findViewById(R.id.btn_copy_errmsg);
        this.f2512o.setOnClickListener(this);
        this.f2505h = (Button) findViewById(R.id.btn_hide_warning);
        this.f2505h.setOnClickListener(this);
        this.f2513p = (Button) findViewById(R.id.btn_bg);
        this.f2513p.setOnClickListener(this);
        bindService(new Intent(this, (Class<?>) ApkComposeService.class), this.f2496D, 1);
        this.f2518u = System.currentTimeMillis();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f2496D != null) {
            unbindService(this.f2496D);
            this.f2496D = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        this.f2497E = intent.getAction();
        if (this.f2497E == null || !"com.gmail.heagoo.action.apkcompose".equals(this.f2497E) || this.f2493A == null || this.f2493A.m3192b()) {
            return;
        }
        this.f2493A.m3191a();
    }

    @Override // android.app.Activity
    public void onPause() {
        this.f2495C = false;
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f2495C = true;
    }
}
