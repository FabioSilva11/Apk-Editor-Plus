package com.gmail.heagoo.apkeditor;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bj */
/* JADX INFO: loaded from: classes.dex */
final class C1083bj extends Thread {

    /* JADX INFO: renamed from: a */
    private String f3086a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkSearchActivity f3087b;

    C1083bj(ApkSearchActivity apkSearchActivity) {
        this.f3087b = apkSearchActivity;
        this.f3086a = apkSearchActivity.f2648b.toLowerCase();
    }

    /* JADX INFO: renamed from: a */
    private void m2814a(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    if (name.endsWith(".apk") && name.toLowerCase().contains(this.f3086a)) {
                        ApkSearchActivity apkSearchActivity = this.f3087b;
                        apkSearchActivity.runOnUiThread(new RunnableC1081bh(apkSearchActivity, file2.getAbsolutePath()));
                    }
                } else {
                    arrayList.add(file2);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m2814a((File) it.next());
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        m2814a(new File(this.f3087b.f2649c));
        ApkSearchActivity apkSearchActivity = this.f3087b;
        apkSearchActivity.runOnUiThread(new RunnableC1082bi(apkSearchActivity));
    }
}
