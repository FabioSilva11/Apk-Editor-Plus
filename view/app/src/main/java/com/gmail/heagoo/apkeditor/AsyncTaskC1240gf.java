package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gf */
/* JADX INFO: loaded from: classes.dex */
final class AsyncTaskC1240gf extends AsyncTask {

    /* JADX INFO: renamed from: a */
    private String f3525a;

    /* JADX INFO: renamed from: b */
    private List f3526b;

    /* JADX INFO: renamed from: c */
    private String f3527c;

    /* JADX INFO: renamed from: d */
    private String f3528d;

    /* JADX INFO: renamed from: e */
    private boolean f3529e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ DialogC1229fv f3530f;

    @SuppressLint({"DefaultLocale"})
    public AsyncTaskC1240gf(DialogC1229fv dialogC1229fv, String str, List list, String str2, boolean z) {
        this.f3530f = dialogC1229fv;
        this.f3525a = str;
        this.f3526b = list;
        this.f3527c = str2;
        this.f3528d = str2.toLowerCase();
        this.f3529e = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|45|3|44|4|(1:(1:(2:7|(2:47|9)(1:12))(0)))(2:(1:(2:15|(2:48|17)(1:13))(0))|11)|42|10|11|(1:(0))) */
    @android.annotation.SuppressLint({"DefaultLocale"})
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m3100a(java.io.File r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r3 = 1
            r0 = 0
            r2 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L4c
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L4c
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L4c
            r5.<init>(r7)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L4c
            r4.<init>(r5)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L4c
            r1.<init>(r4)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L4c
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            boolean r4 = r6.f3529e     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r4 == 0) goto L32
        L1a:
            if (r2 == 0) goto L25
            java.lang.String r4 = r6.f3527c     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r2 == 0) goto L29
            r0 = r3
        L25:
            r1.close()     // Catch: java.io.IOException -> L54
        L28:
            return r0
        L29:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            goto L1a
        L2e:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
        L32:
            if (r2 == 0) goto L25
            java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r4 = r6.f3528d     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r2 == 0) goto L2e
            r0 = r3
            goto L25
        L42:
            r1 = move-exception
            r1 = r2
        L44:
            if (r1 == 0) goto L28
            r1.close()     // Catch: java.io.IOException -> L4a
            goto L28
        L4a:
            r1 = move-exception
            goto L28
        L4c:
            r0 = move-exception
            r1 = r2
        L4e:
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.io.IOException -> L56
        L53:
            throw r0
        L54:
            r1 = move-exception
            goto L28
        L56:
            r1 = move-exception
            goto L53
        L58:
            r0 = move-exception
            goto L4e
        L5a:
            r2 = move-exception
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.AsyncTaskC1240gf.m3100a(java.io.File):boolean");
    }

    /* JADX INFO: renamed from: b */
    private void m3101b(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    m3101b(file2);
                } else if (m3102c(file2) && m3100a(file2)) {
                    this.f3530f.f3504k.add(file2.getPath());
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private static boolean m3102c(File file) {
        String name = file.getName();
        return name.endsWith(".xml") || name.endsWith(".smali") || name.endsWith(".txt");
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        File file = new File(this.f3525a);
        Iterator it = this.f3526b.iterator();
        while (it.hasNext()) {
            File file2 = new File(file, (String) it.next());
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    m3101b(file2);
                } else if (m3102c(file2) && m3100a(file2)) {
                    this.f3530f.f3504k.add(file2.getPath());
                }
            }
        }
        return this.f3530f.f3504k;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        DialogC1229fv.m3087b(this.f3530f);
    }
}
