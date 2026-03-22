package com.gmail.heagoo.apkeditor.prj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.DialogC1201ey;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import common.types.ProjectInfo_V1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class ProjectListActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private C1336d f3782a;

    /* JADX INFO: renamed from: b */
    private String f3783b;

    /* JADX INFO: renamed from: c */
    private List f3784c;

    /* JADX INFO: renamed from: d */
    private C1334b f3785d;

    /* JADX INFO: renamed from: e */
    private HandlerC1335c f3786e = new HandlerC1335c(this);

    /* JADX INFO: renamed from: a */
    private static File m3218a(File[] fileArr) {
        if (fileArr == null) {
            return null;
        }
        for (File file : fileArr) {
            if (file.isFile() && file.getName().equals("ae.prj")) {
                return file;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private List m3219a(String str) {
        File fileM3218a;
        ProjectInfo_V1 projectInfo_V1M2378a;
        File file = new File(str);
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (!file2.isFile() && (fileM3218a = m3218a(file2.listFiles())) != null && (projectInfo_V1M2378a = ApkInfoActivity.m2378a(file2.getPath())) != null) {
                    arrayList.add(new C1338f(file2.getName(), projectInfo_V1M2378a.apkPath, projectInfo_V1M2378a.decodeRootPath, fileM3218a.lastModified()));
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, new C1333a(this));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    final void m3222a() {
        this.f3784c = m3219a(this.f3783b);
        this.f3782a.m3227a(this.f3784c);
        this.f3782a.notifyDataSetChanged();
        ((TextView) findViewById(R.id.tv_title)).setText(String.format(getString(R.string.project_num), Integer.valueOf(this.f3782a.m3226a())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue;
        int id = view.getId();
        if (id == R.id.btn_close) {
            finish();
        } else {
            if (id != R.id.menu_delete || (iIntValue = ((Integer) view.getTag()).intValue()) >= this.f3784c.size()) {
                return;
            }
            new DialogC1201ey(this, new C1339g(this, (C1338f) this.f3784c.get(iIntValue)), -1).show();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_projectlist);
        ListView listView = (ListView) findViewById(R.id.project_list);
        try {
            this.f3783b = C0985a.m2263d(this, ".projects");
            this.f3784c = m3219a(this.f3783b);
            this.f3782a = new C1336d(this, this.f3784c);
            listView.setAdapter((ListAdapter) this.f3782a);
            listView.setOnItemClickListener(this.f3782a);
            this.f3785d = new C1334b(this);
            this.f3785d.start();
            ((TextView) findViewById(R.id.tv_title)).setText(String.format(getString(R.string.project_num), Integer.valueOf(this.f3782a.m3226a())));
            findViewById(R.id.btn_close).setOnClickListener(this);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (this.f3785d != null && this.f3785d.isAlive()) {
            this.f3785d.m3223a();
        }
        super.onDestroy();
    }
}
