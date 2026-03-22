package com.gmail.heagoo.apkeditor;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.prj.ProjectListActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1471c;
import com.gmail.heagoo.common.C1473e;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.httpserver.C1496e;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;
import p000a.p001a.p003b.p004a.C0037k;
import p000a.p001a.p003b.p004a.C0040n;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends Activity implements View.OnClickListener, View.OnLongClickListener, DialogInterface.OnClickListener, InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private static int f2709a;

    /* JADX INFO: renamed from: b */
    private static int f2710b;

    /* JADX INFO: renamed from: d */
    SharedPreferences f2712d;

    /* JADX INFO: renamed from: e */
    View f2713e;

    /* JADX INFO: renamed from: f */
    View f2714f;

    /* JADX INFO: renamed from: g */
    View f2715g;

    /* JADX INFO: renamed from: h */
    View f2716h;

    /* JADX INFO: renamed from: j */
    View f2718j;

    /* JADX INFO: renamed from: k */
    View f2719k;

    /* JADX INFO: renamed from: l */
    View f2720l;

    /* JADX INFO: renamed from: i */
    private int f2717i = 1;

    /* JADX INFO: renamed from: c */
    private MainActivity f2711c = this;

    static {
        System.loadLibrary("syscheck");
    }

    /* JADX INFO: renamed from: AB */
    private void m2521AB() {
        ActionBar actionBar = getActionBar();
        View viewInflate = getLayoutInflater().inflate(R.layout.mtrl_toolbar, (ViewGroup) null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -1, 17);
        TextView textView = (TextView) viewInflate.findViewById(android.R.id.title);
        textView.setText(R.string.app_name);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.gmail.heagoo.apkeditor.la
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.m2526lc(view);
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.gmail.heagoo.apkeditor.lb
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f3736a.llc(view);
            }
        });
        actionBar.setCustomView(viewInflate, layoutParams);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_theme);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2522a(Context context) {
        return true;
    }

    /* JADX INFO: renamed from: c */
    private void m2523c() {
        try {
            File file = new File(getFilesDir(), "work.xml");
            if (!file.exists()) {
                file.createNewFile();
                file.setWritable(true);
            }
            File file2 = new File(getFilesDir(), "work.db");
            if (!file2.exists()) {
                file2.createNewFile();
                file2.setWritable(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File file3 = new File(getFilesDir(), "mycp");
            if (!file3.exists() && Build.VERSION.SDK_INT >= 20) {
                InputStream inputStreamOpen = getAssets().open("mycp");
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                C0985a.m2215a(inputStreamOpen, fileOutputStream);
                inputStreamOpen.close();
                fileOutputStream.close();
                file3.setExecutable(true);
            }
            File file4 = new File(getFilesDir().getAbsolutePath() + "/bin", "aaptz");
            File parentFile = file4.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file4.exists()) {
                return;
            }
            InputStream inputStreamOpen2 = getAssets().open("aaptz");
            FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
            C0985a.m2215a(inputStreamOpen2, fileOutputStream2);
            inputStreamOpen2.close();
            fileOutputStream2.close();
            file4.setExecutable(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void clean() {
        cleanStorage();
        String absolutePath = getFilesDir().getAbsolutePath();
        new C1471c().mo3495a("rm -rf " + absolutePath + "/decoded\nrm -rf " + absolutePath + "/temp", (String[]) null, (Integer) 8000);
        Toast.makeText(this, R.string.temp_file_cleaned, 0).show();
    }

    private void cleanStorage() {
        boolean z;
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/ApkEditor");
        if (file.exists() && file.isDirectory()) {
            String[] strArr = {"backups", ".projects"};
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        String name = file2.getName();
                        int i = 0;
                        while (true) {
                            if (i >= 2) {
                                z = false;
                                break;
                            } else {
                                if (name.equals(strArr[i])) {
                                    z = true;
                                    break;
                                }
                                i++;
                            }
                        }
                        if (!z) {
                            cleanWork(file2);
                            file2.delete();
                        }
                    } else {
                        file2.delete();
                    }
                }
            }
        }
    }

    private void cleanWork(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    cleanWork(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    /* JADX INFO: renamed from: fd */
    private void m2524fd() {
        SharedPreferences.Editor editorEdit = getSharedPreferences("fd", 0).edit();
        editorEdit.putBoolean("FD", false);
        editorEdit.apply();
        float f = getResources().getDisplayMetrics().density;
        int i = (int) ((6.0f * f) + 0.5f);
        int i2 = (int) ((f * 24.0f) + 0.5f);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.action_changelogs);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        layoutParams2.setMargins(0, i, 0, 0);
        scrollView.setLayoutParams(layoutParams2);
        linearLayout.addView(scrollView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        TextView textView = new TextView(this);
        textView.setText(R.string.changelogs);
        textView.setTextColor(ContextCompat.getColor(this, C0037k.mdTextSmall(C0037k.m89a(this))));
        textView.setTextSize(1, 14.0f);
        textView.setPadding(0, i, 0, i);
        layoutParams3.setMargins(i2, 0, i2, 0);
        textView.setLayoutParams(layoutParams3);
        scrollView.addView(textView);
        builder.setView(linearLayout);
        builder.setPositiveButton(R.string.got_it, (DialogInterface.OnClickListener) null);
        builder.setNeutralButton("by Zeratul", (DialogInterface.OnClickListener) null);
        builder.setCancelable(false);
        builder.show().getButton(-3).setEnabled(false);
    }

    public static native int isX86();

    /* JADX INFO: renamed from: it */
    public static native void m2525it(Object obj, String str, String str2, String str3);

    public static void lang(MainActivity mainActivity) {
        C1473e.m3500l(mainActivity);
    }

    /* JADX INFO: renamed from: lc */
    static /* synthetic */ void m2526lc(View view) {
        f2709a++;
    }

    /* JADX INFO: renamed from: md */
    public static native void m2527md(String str, String str2, String str3, int i, String str4, int i2, String str5, int i3);

    /* JADX INFO: renamed from: mg */
    public static native void m2528mg(String str, String str2, String str3, int i, String str4, int i2);

    private void resetTools() {
        SharedPreferences.Editor editorEdit = getSharedPreferences("info", 0).edit();
        editorEdit.putBoolean("initialized", false);
        editorEdit.commit();
        Toast.makeText(this, R.string.toast_reset_tools, 1).show();
    }

    private void showDialogClean() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_title);
        builder.setMessage(R.string.confirm_message_clean);
        builder.setNegativeButton(R.string.no, this);
        builder.setPositiveButton(R.string.yes, this);
        builder.create().show();
    }

    /* JADX INFO: renamed from: vc */
    public static native int m2529vc(Object obj, int i);

    private void visibilityButtons() {
        if (new Boolean(this.f2712d.getBoolean("hide_prj", false)).equals(new Boolean(true))) {
            this.f2713e.setVisibility(8);
        } else {
            this.f2713e.setVisibility(0);
        }
        if (new Boolean(this.f2712d.getBoolean("show_odex", false)).equals(new Boolean(true))) {
            this.f2714f.setVisibility(0);
        } else {
            this.f2714f.setVisibility(8);
        }
        if (new Boolean(this.f2712d.getBoolean("show_info", false)).equals(new Boolean(true))) {
            this.f2715g.setVisibility(0);
        } else {
            this.f2715g.setVisibility(8);
        }
        if (new Boolean(this.f2712d.getBoolean("hide_exit", false)).equals(new Boolean(true))) {
            this.f2716h.setVisibility(8);
        } else {
            this.f2716h.setVisibility(0);
        }
        if (new Boolean(this.f2712d.getBoolean("show_verify", false)).equals(new Boolean(true))) {
            this.f2718j.setVisibility(0);
        } else {
            this.f2718j.setVisibility(8);
        }
        if (new Boolean(this.f2712d.getBoolean("show_sign", false)).equals(new Boolean(true))) {
            this.f2719k.setVisibility(0);
        } else {
            this.f2719k.setVisibility(8);
        }
        if (new Boolean(this.f2712d.getBoolean("show_db", false)).equals(new Boolean(true))) {
            this.f2720l.setVisibility(0);
        } else {
            this.f2720l.setVisibility(8);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        try {
            stopService(new Intent(this, (Class<?>) ApkComposeService.class));
            C1496e.m3554a();
            C1496e.m3557b(this);
            C1476h.m3508a(new File(getFilesDir().getAbsolutePath() + "/decoded"));
        } catch (Throwable th) {
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        Process.killProcess(Process.myPid());
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkingInstruments() {
        /*
            r9 = this;
            java.lang.String r0 = "info"
            r1 = 0
            android.content.SharedPreferences r0 = r9.getSharedPreferences(r0, r1)
            java.lang.String r2 = "initialized"
            boolean r0 = r0.getBoolean(r2, r1)
            if (r0 == 0) goto L6a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r2 = r9.getFilesDir()
            java.lang.String r2 = r2.getAbsolutePath()
            r0.append(r2)
            java.lang.String r2 = "/bin"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            java.lang.String r3 = "aapt"
            r2.<init>(r0, r3)
            long r3 = r9.fileSize(r2)
            r5 = 819960(0xc82f8, double:4.05114E-318)
            r7 = 1
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L3d
        L3b:
            r2 = 1
            goto L54
        L3d:
            r3 = 0
            long r3 = org.apache.commons.p074io.FileUtils.checksumCRC32(r2)     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r2 = move-exception
            r2.printStackTrace()
        L48:
            java.lang.String r2 = "assets/aapt"
            long r5 = r9.getCrc(r2)
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L53
            goto L3b
        L53:
            r2 = 0
        L54:
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "android.jar"
            r3.<init>(r0, r4)
            long r3 = r9.fileSize(r3)
            r5 = 2269471(0x22a11f, double:1.1212677E-317)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L67
            goto L68
        L67:
            r7 = r2
        L68:
            if (r7 == 0) goto L6a
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.MainActivity.checkingInstruments():void");
    }

    public final long fileSize(File file) {
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    public final long getCrc(String str) {
        long crc = 0;
        try {
            ZipFile zipFile = new ZipFile(getPackageCodePath());
            crc = zipFile.getEntry(str).getCrc();
            zipFile.close();
            return crc;
        } catch (IOException e) {
            e.printStackTrace();
            return crc;
        }
    }

    public boolean llc(View view) {
        if (f2709a >= 5) {
            Toast.makeText(this, "by Zeratul", 0).show();
        }
        return f2709a >= 5;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -2:
                dialogInterface.dismiss();
                break;
            case -1:
                clean();
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_apk /* 2131558984 */:
                startActivity(new Intent(this, (Class<?>) FileListActivity.class));
                break;
            case R.id.btn_app /* 2131558985 */:
                startActivity(new Intent(this, (Class<?>) UserAppActivity.class));
                break;
            case R.id.btn_prj /* 2131558986 */:
                startActivity(new Intent(this, (Class<?>) ProjectListActivity.class));
                break;
            case R.id.btn_odex /* 2131558987 */:
                startActivity(new Intent(this, (Class<?>) OdexPatchActivity.class));
                break;
            case R.id.btn_info /* 2131558988 */:
                startActivity(new Intent(this, (Class<?>) InfoActivity.class));
                break;
            case R.id.btn_settings /* 2131558989 */:
                startActivity(new Intent(this, (Class<?>) SettingActivity.class));
                break;
            case R.id.btn_exit /* 2131558990 */:
                new DialogC1201ey(this.f2711c, this.f2711c, -1).show();
                break;
            case R.id.btn_sign /* 2131559001 */:
                startActivity(new Intent(this, (Class<?>) SelectFileActivity.class));
                break;
            case R.id.btn_verify /* 2131559003 */:
                startActivity(new Intent(this, (Class<?>) VerifyActivity.class));
                break;
            case R.id.btn_db /* 2131559020 */:
                startActivity(new Intent(this, (Class<?>) SelectDbActivity.class));
                break;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.m91md(C0037k.m89a(this)));
        super.onCreate(bundle);
        lang(this);
        App.setContext(this);
        this.f2712d = PreferenceManager.getDefaultSharedPreferences(this);
        setContentView(C0040n.m94b(C0040n.m96d(this)));
        if (getSharedPreferences("fd", 0).getBoolean("FD", true)) {
            m2524fd();
        }
        m2521AB();
        findViewById(R.id.btn_apk).setOnClickListener(this);
        findViewById(R.id.btn_app).setOnClickListener(this);
        this.f2713e = findViewById(R.id.btn_prj);
        this.f2713e.setOnClickListener(this);
        this.f2714f = findViewById(R.id.btn_odex);
        this.f2714f.setOnClickListener(this);
        this.f2715g = findViewById(R.id.btn_info);
        this.f2715g.setOnClickListener(this);
        findViewById(R.id.btn_settings).setOnClickListener(this);
        this.f2716h = findViewById(R.id.btn_exit);
        this.f2716h.setOnClickListener(this);
        this.f2718j = findViewById(R.id.btn_verify);
        this.f2718j.setOnClickListener(this);
        this.f2719k = findViewById(R.id.btn_sign);
        this.f2719k.setOnClickListener(this);
        this.f2720l = findViewById(R.id.btn_db);
        this.f2720l.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.f2717i);
        } else {
            m2523c();
            checkingInstruments();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                new C0037k().m92f(this, R.string.theme_title, new C1315ja(this));
                break;
            case R.id.action_prj /* 2131558991 */:
                startActivity(new Intent(this, (Class<?>) ProjectListActivity.class));
                break;
            case R.id.action_odex /* 2131558992 */:
                startActivity(new Intent(this, (Class<?>) OdexPatchActivity.class));
                break;
            case R.id.action_edit /* 2131558993 */:
                startActivity(new Intent(this, (Class<?>) SettingEditorActivity.class));
                break;
            case R.id.action_info /* 2131558994 */:
                startActivity(new Intent(this, (Class<?>) InfoActivity.class));
                break;
            case R.id.action_mod /* 2131558995 */:
                startActivity(new Intent(this, (Class<?>) AboutModActivity.class));
                break;
            case R.id.action_exit /* 2131558996 */:
                new DialogC1201ey(this.f2711c, this.f2711c, -1).show();
                break;
            case R.id.action_db /* 2131558997 */:
                startActivity(new Intent(this, (Class<?>) SelectDbActivity.class));
                break;
            case R.id.action_tools /* 2131558998 */:
                resetTools();
                break;
            case R.id.action_changelogs /* 2131558999 */:
                m2524fd();
                break;
            case R.id.action_sign /* 2131559000 */:
                startActivity(new Intent(this, (Class<?>) SelectFileActivity.class));
                break;
            case R.id.action_verify /* 2131559002 */:
                startActivity(new Intent(this, (Class<?>) VerifyActivity.class));
                break;
            case R.id.action_clean /* 2131559021 */:
                showDialogClean();
                break;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.action_prj);
        if (new Boolean(this.f2712d.getBoolean("hide_prj", false)).equals(new Boolean(true))) {
            menuItemFindItem.setVisible(true);
        } else {
            menuItemFindItem.setVisible(false);
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.action_odex);
        if (new Boolean(this.f2712d.getBoolean("show_odex", false)).equals(new Boolean(true))) {
            menuItemFindItem2.setVisible(false);
        } else {
            menuItemFindItem2.setVisible(true);
        }
        menu.findItem(R.id.action_edit).setVisible(true);
        MenuItem menuItemFindItem3 = menu.findItem(R.id.action_info);
        if (new Boolean(this.f2712d.getBoolean("show_info", false)).equals(new Boolean(true))) {
            menuItemFindItem3.setVisible(false);
        } else {
            menuItemFindItem3.setVisible(true);
        }
        MenuItem menuItemFindItem4 = menu.findItem(R.id.action_mod);
        if (new Boolean(this.f2712d.getBoolean("hide_mod", false)).equals(new Boolean(true))) {
            menuItemFindItem4.setVisible(false);
        } else {
            menuItemFindItem4.setVisible(true);
        }
        MenuItem menuItemFindItem5 = menu.findItem(R.id.action_exit);
        if (new Boolean(this.f2712d.getBoolean("hide_exit", false)).equals(new Boolean(true))) {
            menuItemFindItem5.setVisible(true);
        } else {
            menuItemFindItem5.setVisible(false);
        }
        MenuItem menuItemFindItem6 = menu.findItem(R.id.action_verify);
        if (new Boolean(this.f2712d.getBoolean("show_verify", false)).equals(new Boolean(true))) {
            menuItemFindItem6.setVisible(false);
        } else {
            menuItemFindItem6.setVisible(true);
        }
        MenuItem menuItemFindItem7 = menu.findItem(R.id.action_sign);
        if (new Boolean(this.f2712d.getBoolean("show_sign", false)).equals(new Boolean(true))) {
            menuItemFindItem7.setVisible(false);
        } else {
            menuItemFindItem7.setVisible(true);
        }
        MenuItem menuItemFindItem8 = menu.findItem(R.id.action_changelogs);
        if (new Boolean(this.f2712d.getBoolean("hide_changelogs", false)).equals(new Boolean(true))) {
            menuItemFindItem8.setVisible(false);
        } else {
            menuItemFindItem8.setVisible(true);
        }
        MenuItem menuItemFindItem9 = menu.findItem(R.id.action_tools);
        if (new Boolean(this.f2712d.getBoolean("hide_tools", false)).equals(new Boolean(true))) {
            menuItemFindItem9.setVisible(false);
        } else {
            menuItemFindItem9.setVisible(true);
        }
        MenuItem menuItemFindItem10 = menu.findItem(R.id.action_db);
        if (new Boolean(this.f2712d.getBoolean("show_db", false)).equals(new Boolean(true))) {
            menuItemFindItem10.setVisible(false);
        } else {
            menuItemFindItem10.setVisible(true);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        m2523c();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C0037k.f92md) {
            C0037k.f92md = false;
            recreate();
        }
        visibilityButtons();
    }
}
