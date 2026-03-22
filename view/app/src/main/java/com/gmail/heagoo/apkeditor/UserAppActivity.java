package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.p068se.SimpleEditActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1474f;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class UserAppActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener, InterfaceC1107cd {

    /* JADX INFO: renamed from: c */
    private ListView f2809c;

    /* JADX INFO: renamed from: g */
    private PopupWindow f2813g;

    /* JADX INFO: renamed from: h */
    private C1123cw f2814h;

    /* JADX INFO: renamed from: j */
    private EditText f2815j;

    /* JADX INFO: renamed from: k */
    private View f2816k;

    /* JADX INFO: renamed from: l */
    private ProgressBar f2817l;

    /* JADX INFO: renamed from: a */
    private int f2807a = 0;

    /* JADX INFO: renamed from: b */
    private int f2808b = 0;

    /* JADX INFO: renamed from: d */
    private HandlerC1310iw f2810d = new HandlerC1310iw(this);

    /* JADX INFO: renamed from: e */
    private List f2811e = new ArrayList();

    /* JADX INFO: renamed from: f */
    private final List f2812f = new ArrayList();

    /* JADX INFO: renamed from: a */
    private C1084bk m2633a(int i) {
        C1084bk c1084bk;
        synchronized (this.f2812f) {
            try {
                c1084bk = (C1084bk) this.f2812f.get(i);
            } catch (Throwable th) {
                c1084bk = null;
            }
        }
        return c1084bk;
    }

    /* JADX INFO: renamed from: a */
    private void m2635a() {
        new C1306is(this).start();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2637a(UserAppActivity userAppActivity, int i, int i2) {
        userAppActivity.f2807a = i;
        userAppActivity.f2808b = i2;
        userAppActivity.m2635a();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2638a(Context context, String str) {
        String strM2552i = SettingActivity.m2552i(context);
        if ("2".equals(strM2552i)) {
            new DialogC1104ca(context, new C1307it(context, str), str).show();
            return false;
        }
        m2641b(context, str, strM2552i);
        return true;
    }

    @SuppressLint({"DefaultLocale"})
    /* JADX INFO: renamed from: b */
    private void m2640b() {
        String lowerCase = this.f2815j.getText().toString().toLowerCase();
        ArrayList arrayList = new ArrayList();
        for (C1084bk c1084bk : this.f2811e) {
            if (c1084bk.f3090c.toLowerCase().contains(lowerCase)) {
                arrayList.add(c1084bk);
            }
        }
        m2648a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m2641b(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) ApkInfoExActivity.class);
        C0985a.m2180a(intent, "apkPath", str);
        C0985a.m2236b(intent, "isFullDecoding", "0".equals(str2));
        context.startActivity(intent);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m2642b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1107cd
    /* JADX INFO: renamed from: a */
    public final void mo2478a(int i, String str) {
        Intent intent = null;
        switch (i) {
            case 0:
                if (m2638a(this, str)) {
                    finish();
                    return;
                }
                return;
            case 1:
                intent = new Intent(this, (Class<?>) SimpleEditActivity.class);
                break;
            case 2:
                intent = new Intent(this, (Class<?>) CommonEditActivity.class);
                break;
            case 3:
                try {
                    C0985a.m2190a("com.gmail.heagoo.apkeditor.pro.appdm", "de", new Class[]{Context.class, String.class}, new Object[]{this, str});
                } catch (Exception e) {
                }
                break;
            case 4:
                intent = new Intent(this, (Class<?>) AxmlEditActivity.class);
                break;
        }
        if (intent != null) {
            C0985a.m2180a(intent, "apkPath", str);
            startActivity(intent);
            finish();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2648a(List list) {
        this.f2817l.setVisibility(8);
        this.f2809c.setVisibility(0);
        C1085bl c1085bl = (C1085bl) this.f2809c.getAdapter();
        String[] stringArray = getResources().getStringArray(R.array.order_value);
        c1085bl.m2816a(list, this.f2808b < stringArray.length ? stringArray[this.f2808b] : "");
        c1085bl.notifyDataSetChanged();
        synchronized (this.f2812f) {
            this.f2812f.clear();
            this.f2812f.addAll(list);
        }
        this.f2815j.setEnabled(true);
        this.f2816k.setVisibility(0);
    }

    /* JADX INFO: renamed from: b */
    protected final void m2649b(List list) {
        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        if (this.f2807a == 0) {
            for (ApplicationInfo applicationInfo : installedApplications) {
                if ((applicationInfo.flags & 1) == 0) {
                    list.add(C1084bk.m2815a(packageManager, applicationInfo));
                }
            }
            return;
        }
        for (ApplicationInfo applicationInfo2 : installedApplications) {
            if ((applicationInfo2.flags & 1) != 0) {
                list.add(C1084bk.m2815a(packageManager, applicationInfo2));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.menu_more) {
            if (id == R.id.btn_close) {
                finish();
                return;
            } else {
                if (id == R.id.btn_search) {
                    m2640b();
                    return;
                }
                return;
            }
        }
        if (this.f2813g == null) {
            View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.popup_list, (ViewGroup) null);
            ListView listView = (ListView) viewInflate.findViewById(R.id.lvGroup);
            ArrayList arrayList = new ArrayList();
            Resources resources = getResources();
            arrayList.add(resources.getString(R.string.user_apps));
            arrayList.add(resources.getString(R.string.system_apps));
            String[] stringArray = resources.getStringArray(R.array.order_value);
            for (String str : stringArray) {
                arrayList.add(str);
            }
            this.f2814h = new C1123cw(this, arrayList);
            listView.setAdapter((ListAdapter) this.f2814h);
            this.f2813g = new PopupWindow(viewInflate, C1474f.m3501a(this) / 2, C1474f.m3502a(this, 224.0f));
            listView.setOnItemClickListener(new C1308iu(this));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(this.f2807a));
        arrayList2.add(Integer.valueOf(this.f2808b + 2));
        this.f2814h.m2859a(arrayList2);
        this.f2813g.setFocusable(true);
        this.f2813g.setOutsideTouchable(true);
        this.f2813g.setBackgroundDrawable(new BitmapDrawable());
        this.f2813g.showAsDropDown(view, (((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() / 2) - (this.f2813g.getWidth() / 2), 0);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        int i = ((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        switch (menuItem.getItemId()) {
            case 2:
                try {
                    C1084bk c1084bkM2633a = m2633a(i);
                    if (c1084bkM2633a != null) {
                        String str = c1084bkM2633a.f3089b;
                        try {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.parse("package:" + str));
                            startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }
                    break;
                } catch (Exception e2) {
                }
                return true;
            case 3:
                try {
                    C1084bk c1084bkM2633a2 = m2633a(i);
                    if (c1084bkM2633a2 != null) {
                        new DialogC1201ey(this, new C1309iv(this, c1084bkM2633a2.f3090c, getPackageManager().getApplicationInfo(c1084bkM2633a2.f3089b, 0).publicSourceDir), -1).show();
                    }
                    break;
                } catch (Exception e3) {
                }
                return true;
            case 4:
                try {
                    C1084bk c1084bkM2633a3 = m2633a(i);
                    if (c1084bkM2633a3 != null && !m2642b(this, c1084bkM2633a3.f3089b)) {
                        Toast.makeText(this, String.format(getString(R.string.cannot_launch), c1084bkM2633a3.f3090c), 0).show();
                    }
                    break;
                } catch (Exception e4) {
                }
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_applist);
        String strM2542a = SettingActivity.m2542a(this);
        String[] stringArray = getResources().getStringArray(R.array.order_value);
        int i = 0;
        while (true) {
            if (i >= stringArray.length) {
                i = 0;
                break;
            } else if (strM2542a.equals(stringArray[i])) {
                break;
            } else {
                i++;
            }
        }
        this.f2808b = i;
        this.f2817l = (ProgressBar) findViewById(R.id.progress_bar);
        ((TextView) findViewById(R.id.apptype)).setText(R.string.select_apk_from_app);
        findViewById(R.id.menu_more).setOnClickListener(this);
        this.f2809c = (ListView) findViewById(R.id.application_list);
        C1085bl c1085bl = new C1085bl(this);
        c1085bl.m2816a(this.f2812f, SettingActivity.m2542a(this));
        this.f2809c.setAdapter((ListAdapter) c1085bl);
        this.f2809c.setOnItemClickListener(this);
        registerForContextMenu(this.f2809c);
        this.f2815j = (EditText) findViewById(R.id.et_keyword);
        this.f2816k = findViewById(R.id.btn_search);
        this.f2816k.setOnClickListener(this);
        findViewById(R.id.btn_close).setOnClickListener(this);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        C1084bk c1084bkM2633a;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        if (adapterContextMenuInfo == null || (c1084bkM2633a = m2633a(adapterContextMenuInfo.position)) == null) {
            return;
        }
        contextMenu.setHeaderTitle(c1084bkM2633a.f3090c);
        contextMenu.add(0, 2, 0, R.string.app_info);
        contextMenu.add(0, 3, 0, R.string.backup);
        contextMenu.add(0, 4, 0, R.string.launch);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1084bk c1084bkM2633a = m2633a(i);
        if (c1084bkM2633a != null) {
            try {
                ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(c1084bkM2633a.f3089b, 0);
                String str = applicationInfo.sourceDir;
                if (MainActivity.m2522a(this)) {
                    new DialogC1106cc(this, this, str, applicationInfo.packageName).show();
                } else {
                    m2638a(this, str);
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        m2635a();
    }
}
