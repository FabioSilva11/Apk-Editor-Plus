package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import java.io.File;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fu */
/* JADX INFO: loaded from: classes.dex */
final class AsyncTaskC1228fu extends AsyncTask {

    /* JADX INFO: renamed from: a */
    private String f3489a;

    /* JADX INFO: renamed from: b */
    private List f3490b;

    /* JADX INFO: renamed from: c */
    private String f3491c;

    /* JADX INFO: renamed from: d */
    private String f3492d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ DialogC1222fo f3493e;

    @SuppressLint({"DefaultLocale"})
    public AsyncTaskC1228fu(DialogC1222fo dialogC1222fo, String str, List list, String str2) {
        this.f3493e = dialogC1222fo;
        this.f3489a = str;
        this.f3490b = list;
        this.f3491c = str2;
        this.f3492d = str2.toLowerCase();
    }

    /* JADX INFO: renamed from: a */
    private void m3083a(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    m3083a(file2);
                } else if (m3084a(file2.getName())) {
                    this.f3493e.f3482p.add(file2.getPath());
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3084a(String str) {
        return this.f3493e.f3481o ? str.contains(this.f3491c) : str.toLowerCase().contains(this.f3492d);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        File file = new File(this.f3489a);
        for (String str : this.f3490b) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    m3083a(file2);
                } else if (m3084a(str)) {
                    this.f3493e.f3482p.add(file2.getPath());
                }
            }
        }
        return this.f3493e.f3482p;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        DialogC1222fo.m3079c(this.f3493e);
    }
}
