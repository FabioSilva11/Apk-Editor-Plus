package com.gmail.heagoo.apkeditor.p068se;

import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.a */
/* JADX INFO: loaded from: classes.dex */
final class C1344a extends Thread {

    /* JADX INFO: renamed from: a */
    private WeakReference f3867a;

    /* JADX INFO: renamed from: b */
    private String f3868b;

    /* JADX INFO: renamed from: c */
    private String f3869c;

    C1344a(ApkCreateActivity apkCreateActivity) {
        this.f3867a = new WeakReference(apkCreateActivity);
    }

    /* JADX INFO: renamed from: a */
    private static void m3256a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3257a(ZipFile zipFile) {
        try {
            zipFile.close();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m3258a() {
        return this.f3869c;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p068se.C1344a.run():void");
    }
}
