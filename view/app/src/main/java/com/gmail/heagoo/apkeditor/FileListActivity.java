package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.LruCache;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.p068se.SimpleEditActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1470b;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.gmail.heagoo.p070b.C1450a;
import com.gmail.heagoo.p070b.C1454e;
import com.gmail.heagoo.p070b.InterfaceC1463n;
import com.gmail.heagoo.p070b.InterfaceC1464o;
import java.io.File;
import java.util.List;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class FileListActivity extends Activity implements View.OnClickListener, InterfaceC1107cd, InterfaceC1463n, InterfaceC1464o {

    /* JADX INFO: renamed from: a */
    private TextView f2699a;

    /* JADX INFO: renamed from: b */
    private ListView f2700b;

    /* JADX INFO: renamed from: d */
    private C1454e f2701d;

    /* JADX INFO: renamed from: e */
    private ImageView f2702e;

    /* JADX INFO: renamed from: g */
    private boolean f2703g = false;

    /* JADX INFO: renamed from: i */
    private C1114cm f2704i = null;

    /* JADX INFO: renamed from: k */
    private LruCache f2705k = new LruCache(64);

    /* JADX INFO: renamed from: l */
    private int f2706l = 1;

    /* JADX INFO: renamed from: m */
    private Handler f2707m = new HandlerC1113cl(this);

    /* JADX INFO: renamed from: a */
    private void m2505a() {
        String path = Environment.getExternalStorageDirectory().getPath();
        String string = getSharedPreferences("config", 0).getString("apkDirectory", path);
        if (!new File(string).exists()) {
            string = path;
        }
        this.f2699a = (TextView) findViewById(R.id.dirPath);
        this.f2699a.setText(string);
        this.f2700b = (ListView) findViewById(R.id.file_list);
        this.f2701d = new C1454e(this, this.f2700b, string, "/", this, this);
        this.f2702e = (ImageView) findViewById(R.id.imageView_extsdcard);
        findViewById(R.id.menu_switch_card).setOnClickListener(new ViewOnClickListenerC1112ci(this));
        findViewById(R.id.search_button).setOnClickListener(this);
        findViewById(R.id.menu_home).setOnClickListener(new ViewOnClickListenerC1328ne(this));
        findViewById(R.id.files_list).setOnClickListener(new ViewOnClickListenerC1329nf(this));
        findViewById(R.id.btn_close).setOnClickListener(new ViewOnClickListenerC1330ng(this));
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2506a(FileListActivity fileListActivity) {
        boolean z;
        if (fileListActivity.f2703g) {
            fileListActivity.m2509c();
            fileListActivity.f2702e.setImageResource(R.drawable.ic_sdcard_ext);
            z = true;
        } else if (fileListActivity.m2508b()) {
            fileListActivity.f2702e.setImageResource(R.drawable.ic_sdcard_int);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            fileListActivity.f2703g = !fileListActivity.f2703g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e A[SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m2508b() {
        /*
            r9 = this;
            r2 = 0
            r1 = 0
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r0 < r3) goto L64
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = r0.getPath()
            java.io.File[] r5 = r9.getExternalFilesDirs(r2)
            if (r5 == 0) goto L64
            int r3 = r5.length
            r0 = r1
        L18:
            if (r0 >= r3) goto L90
            r6 = r5[r0]
            java.lang.String r6 = r6.getPath()
            boolean r7 = r6.startsWith(r4)
            if (r7 == 0) goto L5e
            int r0 = r6.length()
            int r3 = r4.length()
            int r0 = r0 - r3
        L2f:
            int r6 = r5.length
            r3 = r1
        L31:
            if (r3 >= r6) goto L64
            r7 = r5[r3]
            java.lang.String r7 = r7.getPath()
            boolean r8 = r7.startsWith(r4)
            if (r8 != 0) goto L61
            int r2 = r7.length()
            int r0 = r2 - r0
            java.lang.String r0 = r7.substring(r1, r0)
        L49:
            if (r0 == 0) goto L83
            java.lang.String r2 = ""
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L83
            com.gmail.heagoo.b.e r2 = r9.f2701d
            if (r2 == 0) goto L5d
            com.gmail.heagoo.b.e r1 = r9.f2701d
            r1.m3484a(r0)
            r1 = 1
        L5d:
            return r1
        L5e:
            int r0 = r0 + 1
            goto L18
        L61:
            int r3 = r3 + 1
            goto L31
        L64:
            java.util.List r0 = com.gmail.heagoo.common.C1469a.m3489b()
            java.util.Iterator r3 = r0.iterator()
        L6c:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L8e
            java.lang.Object r0 = r3.next()
            com.gmail.heagoo.common.v r0 = (com.gmail.heagoo.common.C1490v) r0
            boolean r4 = r0.f4326b
            if (r4 != 0) goto L6c
            boolean r4 = r0.f4327c
            if (r4 != 0) goto L6c
            java.lang.String r0 = r0.f4325a
            goto L49
        L83:
            r0 = 2131165256(0x7f070048, float:1.7944724E38)
            android.widget.Toast r0 = android.widget.Toast.makeText(r9, r0, r1)
            r0.show()
            goto L5d
        L8e:
            r0 = r2
            goto L49
        L90:
            r0 = r1
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.FileListActivity.m2508b():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m2509c() {
        String path = Environment.getExternalStorageDirectory().getPath();
        if (path == null || path.equals("") || this.f2701d == null) {
            return;
        }
        this.f2701d.m3484a(path);
    }

    /* JADX INFO: renamed from: d */
    static /* synthetic */ boolean m2511d(FileListActivity fileListActivity) {
        File filesDir = fileListActivity.getFilesDir();
        if (fileListActivity.f2701d == null) {
            return false;
        }
        fileListActivity.f2701d.m3484a(filesDir.getPath());
        return true;
    }

    /* JADX INFO: renamed from: g */
    static /* synthetic */ void m2513g(FileListActivity fileListActivity) {
        fileListActivity.f2707m.removeMessages(0);
        fileListActivity.f2707m.sendEmptyMessageDelayed(0, 300L);
    }

    @Override // com.gmail.heagoo.p070b.InterfaceC1464o
    /* JADX INFO: renamed from: a */
    public final Drawable mo2515a(String str, C1450a c1450a) {
        if (c1450a == null || c1450a.f4256b || !c1450a.f4255a.endsWith(".apk")) {
            return null;
        }
        String str2 = str + "/" + c1450a.f4255a;
        C1470b c1470b = (C1470b) this.f2705k.get(str2);
        if (c1470b != null) {
            return c1470b.f4292c;
        }
        this.f2704i.m2848a(str2);
        return getResources().getDrawable(R.drawable.apk_icon);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1107cd
    /* JADX INFO: renamed from: a */
    public final void mo2478a(int i, String str) {
        Intent intent = null;
        switch (i) {
            case 0:
                UserAppActivity.m2638a(this, str);
                return;
            case 1:
                intent = new Intent(this, (Class<?>) SimpleEditActivity.class);
                break;
            case 2:
                intent = new Intent(this, (Class<?>) CommonEditActivity.class);
                break;
            case 4:
                intent = new Intent(this, (Class<?>) AxmlEditActivity.class);
                break;
        }
        if (intent != null) {
            C0985a.m2180a(intent, "apkPath", str);
            startActivity(intent);
        }
    }

    @Override // com.gmail.heagoo.p070b.InterfaceC1463n
    /* JADX INFO: renamed from: a */
    public final void mo2516a(String str) {
        if (this.f2699a != null) {
            this.f2699a.setText(str);
        }
    }

    @Override // com.gmail.heagoo.p070b.InterfaceC1464o
    /* JADX INFO: renamed from: b */
    public final String mo2517b(String str, C1450a c1450a) {
        if (c1450a.f4256b || !c1450a.f4255a.endsWith(".apk")) {
            return null;
        }
        C1470b c1470b = (C1470b) this.f2705k.get(str + "/" + c1450a.f4255a);
        return c1470b != null ? c1470b.f4290a : "";
    }

    @Override // com.gmail.heagoo.p070b.InterfaceC1463n
    /* JADX INFO: renamed from: b */
    public final boolean mo2518b(String str) {
        if (!str.endsWith(".apk")) {
            return false;
        }
        String strSubstring = str.substring(0, str.lastIndexOf(47));
        SharedPreferences.Editor editorEdit = getSharedPreferences("config", 0).edit();
        editorEdit.putString("apkDirectory", strSubstring);
        editorEdit.commit();
        if (MainActivity.m2522a(this)) {
            new DialogC1106cc(this, this, str).show();
        } else {
            UserAppActivity.m2638a(this, str);
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.search_button || this.f2701d == null) {
            return;
        }
        String string = ((EditText) findViewById(R.id.keyword_edit)).getText().toString();
        String strM3470a = this.f2701d.m3483a().m3470a((List) null);
        Intent intent = new Intent(this, (Class<?>) ApkSearchActivity.class);
        C0985a.m2180a(intent, "Keyword", string);
        C0985a.m2180a(intent, "Path", strM3470a);
        startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_listfile);
        if (this.f2704i == null) {
            this.f2704i = new C1114cm(this);
            this.f2704i.start();
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.f2706l);
        } else {
            m2505a();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.f2704i.m2847a();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length <= 0 || iArr[0] != 0) {
            return;
        }
        m2505a();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
