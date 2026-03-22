package com.gmail.heagoo.apkeditor.p068se;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C1345aa {

    /* JADX INFO: renamed from: a */
    private ZipFile f3870a;

    /* JADX INFO: renamed from: b */
    private int f3871b;

    /* JADX INFO: renamed from: c */
    private int f3872c;

    public C1345aa(ZipFile zipFile) {
        this.f3870a = zipFile;
    }

    /* JADX INFO: renamed from: a */
    private static void m3259a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m3260a() {
        return this.f3871b;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap m3261a(java.lang.String r7, int r8, int r9) throws java.lang.Throwable {
        /*
            r6 = this;
            r1 = 0
            r4 = 1
            java.util.zip.ZipFile r0 = r6.f3870a     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            java.util.zip.ZipEntry r0 = r0.getEntry(r7)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            java.util.zip.ZipFile r2 = r6.f3870a     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            java.io.InputStream r2 = r2.getInputStream(r0)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            int r3 = r0.getWidth()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            r6.f3871b = r3     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            int r3 = r0.getHeight()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            r6.f3872c = r3     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            int r3 = r6.f3871b     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            int r3 = r3 / r8
            int r5 = r6.f3872c     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            int r5 = r5 / r9
            if (r3 >= r5) goto L36
        L26:
            if (r3 > 0) goto L29
            r3 = r4
        L29:
            if (r3 <= r4) goto L30
            r3 = 2
            android.graphics.Bitmap r0 = android.media.ThumbnailUtils.extractThumbnail(r0, r8, r9, r3)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
        L30:
            if (r2 == 0) goto L35
            m3259a(r2)
        L35:
            return r0
        L36:
            r3 = r5
            goto L26
        L38:
            r0 = move-exception
            r2 = r1
        L3a:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L4c
            if (r2 == 0) goto L42
            m3259a(r2)
        L42:
            r0 = r1
            goto L35
        L44:
            r0 = move-exception
            r2 = r1
        L46:
            if (r2 == 0) goto L4b
            m3259a(r2)
        L4b:
            throw r0
        L4c:
            r0 = move-exception
            goto L46
        L4e:
            r0 = move-exception
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p068se.C1345aa.m3261a(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /* JADX INFO: renamed from: b */
    public final int m3262b() {
        return this.f3872c;
    }
}
