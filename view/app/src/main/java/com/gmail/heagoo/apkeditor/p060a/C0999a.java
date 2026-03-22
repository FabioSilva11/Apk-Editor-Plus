package com.gmail.heagoo.apkeditor.p060a;

import android.content.Context;
import android.graphics.Bitmap;
import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.p068se.C1345aa;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.ZipFile;
import p000a.p001a.p003b.p004a.C0030d;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0032f;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p004a.p005a.C0012i;
import p000a.p001a.p003b.p004a.p005a.C0024u;
import p000a.p001a.p003b.p004a.p005a.C0026w;
import p000a.p001a.p003b.p006b.C0043a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0999a {

    /* JADX INFO: renamed from: a */
    private Context f2818a;

    /* JADX INFO: renamed from: b */
    private String f2819b;

    /* JADX INFO: renamed from: c */
    private String f2820c;

    /* JADX INFO: renamed from: d */
    private Bitmap f2821d;

    public C0999a(Context context, String str) {
        this.f2818a = context;
        this.f2819b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.gmail.heagoo.apkeditor.p060a.C1024b m2650a(java.util.zip.ZipFile r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r1 = 0
            java.util.zip.ZipEntry r0 = r5.getEntry(r6)
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options
            r3.<init>()
            r2 = 1
            r3.inJustDecodeBounds = r2
            java.io.InputStream r2 = r5.getInputStream(r0)     // Catch: java.io.IOException -> L29 java.lang.Throwable -> L35
            r0 = 0
            android.graphics.BitmapFactory.decodeStream(r2, r0, r3)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            com.gmail.heagoo.apkeditor.a.b r0 = new com.gmail.heagoo.apkeditor.a.b     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            r4 = 0
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            int r4 = r3.outHeight     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            r0.f2938b = r4     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            int r3 = r3.outWidth     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            r0.f2937a = r3     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            if (r2 == 0) goto L28
            r2.close()     // Catch: java.io.IOException -> L3d
        L28:
            return r0
        L29:
            r0 = move-exception
            r2 = r1
        L2b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L33
            r2.close()     // Catch: java.io.IOException -> L3f
        L33:
            r0 = r1
            goto L28
        L35:
            r0 = move-exception
            r2 = r1
        L37:
            if (r2 == 0) goto L3c
            r2.close()     // Catch: java.io.IOException -> L41
        L3c:
            throw r0
        L3d:
            r1 = move-exception
            goto L28
        L3f:
            r0 = move-exception
            goto L33
        L41:
            r1 = move-exception
            goto L3c
        L43:
            r0 = move-exception
            goto L37
        L45:
            r0 = move-exception
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p060a.C0999a.m2650a(java.util.zip.ZipFile, java.lang.String):com.gmail.heagoo.apkeditor.a.b");
    }

    /* JADX INFO: renamed from: a */
    private static void m2651a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2652a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2653a(ZipFile zipFile, C0031e c0031e, int i) throws Throwable {
        try {
            Map mapM63b = c0031e.m49b(new C0030d(i)).m63b();
            C1345aa c1345aa = new C1345aa(zipFile);
            for (C0033g c0033g : mapM63b.values()) {
                C0026w c0026wM75d = c0033g.m75d();
                String strM6a = c0026wM75d instanceof C0012i ? ((C0012i) c0026wM75d).m6a() : c0026wM75d instanceof C0024u ? c0026wM75d.toString() : "res/" + c0033g.m71a() + ".png";
                C1024b c1024bM2650a = m2650a(zipFile, strM6a);
                if (c1024bM2650a.f2937a > 0) {
                    this.f2821d = c1345aa.m3261a(strM6a, c1024bM2650a.f2937a, c1024bM2650a.f2938b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m2654a() {
        return this.f2820c;
    }

    /* JADX INFO: renamed from: a */
    public final void m2655a(int i, int i2) throws Throwable {
        ZipFile zipFile;
        Throwable th;
        InputStream inputStream;
        ZipFile zipFile2;
        try {
            zipFile = new ZipFile(this.f2819b);
            try {
                try {
                    InputStream inputStream2 = zipFile.getInputStream(zipFile.getEntry("resources.arsc"));
                    try {
                        for (C0031e c0031e : C0043a.m101a(inputStream2, false, false, new C0985a(this.f2818a.getApplicationContext(), false), null, false).m113a()) {
                            if (i != -1) {
                                try {
                                    C0032f c0032fM49b = c0031e.m49b(new C0030d(i));
                                    C0026w c0026wM75d = c0032fM49b.m58a(ApkInfoActivity.m2374a(c0032fM49b.m63b().keySet())).m75d();
                                    if (c0026wM75d instanceof C0024u) {
                                        this.f2820c = c0026wM75d.toString();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (i2 != -1) {
                                m2653a(zipFile, c0031e, i2);
                            }
                        }
                        m2651a(inputStream2);
                        m2652a(zipFile);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        m2651a(inputStream);
                        m2652a(zipFile);
                        throw th;
                    }
                } catch (Exception e2) {
                    zipFile2 = zipFile;
                    m2651a((InputStream) null);
                    m2652a(zipFile2);
                }
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        } catch (Exception e3) {
            zipFile2 = null;
        } catch (Throwable th4) {
            zipFile = null;
            th = th4;
            inputStream = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public final Bitmap m2656b() {
        return this.f2821d;
    }
}
