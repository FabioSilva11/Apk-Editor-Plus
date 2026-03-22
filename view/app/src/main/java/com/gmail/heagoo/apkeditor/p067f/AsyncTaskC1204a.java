package com.gmail.heagoo.apkeditor.p067f;

import android.content.Context;
import android.os.AsyncTask;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.f.a */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncTaskC1204a extends AsyncTask {

    /* JADX INFO: renamed from: a */
    private Context f3404a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1205b f3405b;

    /* JADX INFO: renamed from: c */
    private String f3406c;

    /* JADX INFO: renamed from: d */
    private String f3407d;

    /* JADX INFO: renamed from: e */
    private List f3408e = new ArrayList();

    /* JADX INFO: renamed from: f */
    private String f3409f;

    /* JADX INFO: renamed from: g */
    private String f3410g;

    public AsyncTaskC1204a(Context context, String str, String str2, InterfaceC1205b interfaceC1205b) {
        this.f3404a = context;
        this.f3405b = interfaceC1205b;
        this.f3407d = str;
        this.f3406c = str2;
    }

    /* JADX INFO: renamed from: a */
    private void m3002a(ZipFile zipFile, ZipEntry zipEntry, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    C0985a.m2244b(inputStream2, fileOutputStream);
                    this.f3408e.add(str);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e) {
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (Exception e4) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream = inputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3003b() throws java.lang.Throwable {
        /*
            r6 = this;
            android.content.Context r0 = r6.f3404a
            java.lang.String r1 = "tmp"
            java.lang.String r3 = com.gmail.heagoo.p054a.p059c.C0985a.m2263d(r0, r1)
            r2 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L67
            java.lang.String r0 = r6.f3407d     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L67
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L67
            java.util.Enumeration r2 = r1.entries()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
        L14:
            boolean r0 = r2.hasMoreElements()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            if (r0 == 0) goto L53
            java.lang.Object r0 = r2.nextElement()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            java.util.zip.ZipEntry r0 = (java.util.zip.ZipEntry) r0     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            java.lang.String r4 = r0.getName()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            java.lang.String r5 = ".dex"
            boolean r5 = r4.endsWith(r5)     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            if (r5 == 0) goto L14
            java.lang.String r5 = "/"
            boolean r5 = r4.contains(r5)     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            if (r5 != 0) goto L14
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            r5.<init>()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            java.lang.String r4 = r4.toString()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            r6.m3002a(r1, r0, r4)     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L65
            goto L14
        L49:
            r0 = move-exception
        L4a:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.lang.Exception -> L61
        L52:
            return
        L53:
            r1.close()     // Catch: java.lang.Exception -> L57
            goto L52
        L57:
            r0 = move-exception
            goto L52
        L59:
            r0 = move-exception
            r1 = r2
        L5b:
            if (r1 == 0) goto L60
            r1.close()     // Catch: java.lang.Exception -> L63
        L60:
            throw r0
        L61:
            r0 = move-exception
            goto L52
        L63:
            r1 = move-exception
            goto L60
        L65:
            r0 = move-exception
            goto L5b
        L67:
            r0 = move-exception
            r1 = r2
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p067f.AsyncTaskC1204a.m3003b():void");
    }

    /* JADX INFO: renamed from: c */
    private Boolean m3004c() throws Throwable {
        try {
            m3003b();
            m3006e();
            m3005d();
            return true;
        } catch (Exception e) {
            this.f3409f = e.getMessage();
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3005d() {
        Iterator it = this.f3408e.iterator();
        while (it.hasNext()) {
            new File((String) it.next()).delete();
        }
    }

    /* JADX INFO: renamed from: e */
    private void m3006e() {
        for (String str : this.f3408e) {
            Object objM2191a = C0985a.m2191a("com.gmail.heagoo.apkeditor.pro.DexDecoder", new Class[]{String.class}, new Object[]{str});
            String str2 = !str.endsWith("/classes.dex") ? this.f3406c + "/smali_" + str.substring(str.lastIndexOf("/") + 1, str.length() - 4) : this.f3406c + "/smali";
            File file = new File(str2);
            if (file.exists()) {
                file.mkdir();
            }
            C0985a.m2189a("com.gmail.heagoo.apkeditor.pro.DexDecoder", "dex2smali", objM2191a, new Class[]{String.class}, new Object[]{str2});
            if (this.f3410g == null) {
                this.f3410g = (String) C0985a.m2189a("com.gmail.heagoo.apkeditor.pro.DexDecoder", "getWarning", objM2191a, null, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3007a() throws java.lang.Throwable {
        /*
            r5 = this;
            android.content.Context r0 = r5.f3404a
            java.lang.String r1 = "tmp"
            java.lang.String r0 = com.gmail.heagoo.p054a.p059c.C0985a.m2263d(r0, r1)
            r2 = 0
            java.lang.String r3 = "classes.dex"
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L41
            java.lang.String r4 = r5.f3407d     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L41
            r1.<init>(r4)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L41
            java.util.zip.ZipEntry r2 = r1.getEntry(r3)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r4.<init>()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r5.m3002a(r1, r2, r0)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r1.close()     // Catch: java.lang.Exception -> L49
        L2d:
            r5.m3006e()
            r5.m3005d()
            return
        L34:
            r0 = move-exception
            r1 = r2
        L36:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L2d
            r1.close()     // Catch: java.lang.Exception -> L3f
            goto L2d
        L3f:
            r0 = move-exception
            goto L2d
        L41:
            r0 = move-exception
            r1 = r2
        L43:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L4b
        L48:
            throw r0
        L49:
            r0 = move-exception
            goto L2d
        L4b:
            r1 = move-exception
            goto L48
        L4d:
            r0 = move-exception
            goto L43
        L4f:
            r0 = move-exception
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p067f.AsyncTaskC1204a.m3007a():void");
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3004c();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        if (this.f3405b != null) {
            if (bool.booleanValue()) {
                this.f3405b.mo2440a(true, null, this.f3410g);
            } else {
                this.f3405b.mo2440a(false, this.f3409f, null);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        if (this.f3405b != null) {
            this.f3405b.mo2458h();
        }
    }
}
