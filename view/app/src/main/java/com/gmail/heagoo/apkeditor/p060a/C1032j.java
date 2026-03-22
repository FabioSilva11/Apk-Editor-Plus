package com.gmail.heagoo.apkeditor.p060a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.gmail.heagoo.common.C1480l;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipFile;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0032f;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p004a.p005a.C0012i;
import p000a.p001a.p003b.p004a.p005a.C0024u;
import p000a.p001a.p003b.p004a.p005a.C0026w;
import p000a.p001a.p003b.p006b.C0043a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1032j implements InterfaceC1026d, Serializable {

    /* JADX INFO: renamed from: a */
    private int f2979a;

    /* JADX INFO: renamed from: b */
    private String f2980b;

    public C1032j(int i, String str) {
        this.f2979a = i;
        this.f2980b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
    private com.gmail.heagoo.apkeditor.p060a.C1033k m2761a(java.util.zip.ZipFile r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r5 = this;
            r1 = 0
            java.util.zip.ZipEntry r0 = r6.getEntry(r7)
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options
            r3.<init>()
            r2 = 1
            r3.inJustDecodeBounds = r2
            java.io.InputStream r2 = r6.getInputStream(r0)     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L34
            r0 = 0
            android.graphics.BitmapFactory.decodeStream(r2, r0, r3)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            com.gmail.heagoo.apkeditor.a.k r0 = new com.gmail.heagoo.apkeditor.a.k     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            int r4 = r3.outHeight     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            r0.f2982b = r4     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            int r3 = r3.outWidth     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            r0.f2981a = r3     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            if (r2 == 0) goto L27
            r2.close()     // Catch: java.io.IOException -> L3c
        L27:
            return r0
        L28:
            r0 = move-exception
            r2 = r1
        L2a:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L32
            r2.close()     // Catch: java.io.IOException -> L3e
        L32:
            r0 = r1
            goto L27
        L34:
            r0 = move-exception
            r2 = r1
        L36:
            if (r2 == 0) goto L3b
            r2.close()     // Catch: java.io.IOException -> L40
        L3b:
            throw r0
        L3c:
            r1 = move-exception
            goto L27
        L3e:
            r0 = move-exception
            goto L32
        L40:
            r1 = move-exception
            goto L3b
        L42:
            r0 = move-exception
            goto L36
        L44:
            r0 = move-exception
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p060a.C1032j.m2761a(java.util.zip.ZipFile, java.lang.String):com.gmail.heagoo.apkeditor.a.k");
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d
    /* JADX INFO: renamed from: a */
    public final void mo2692a(Context context, String str, Map map, InterfaceC1028f interfaceC1028f) throws Throwable {
        ZipFile zipFile;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        ZipFile zipFile2 = null;
        InputStream inputStream3 = null;
        try {
            zipFile = new ZipFile(str);
        } catch (Exception e) {
        } catch (Throwable th2) {
            zipFile = null;
            inputStream = null;
            th = th2;
        }
        try {
            try {
                inputStream2 = zipFile.getInputStream(zipFile.getEntry("resources.arsc"));
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
            try {
                for (C0031e c0031e : C0043a.m101a(inputStream2, false, false, new C0985a(context.getApplicationContext(), false), null, false).m113a()) {
                    Iterator it = c0031e.m44a().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            C0032f c0032f = (C0032f) it.next();
                            if (this.f2979a == c0032f.m66e().f64b) {
                                Map mapM63b = c0032f.m63b();
                                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.f2980b);
                                int i = 0;
                                for (C0033g c0033g : mapM63b.values()) {
                                    String str2 = C0985a.m2263d(context, "tmp") + ".launcher" + i + ".png";
                                    C0026w c0026wM75d = c0033g.m75d();
                                    String strM6a = c0026wM75d instanceof C0012i ? ((C0012i) c0026wM75d).m6a() : c0026wM75d instanceof C0024u ? c0026wM75d.toString() : "res/" + c0033g.m71a() + ".png";
                                    C1033k c1033kM2761a = m2761a(zipFile, strM6a);
                                    if (c1033kM2761a != null) {
                                        new C1480l().m3516a(bitmapDecodeFile, c1033kM2761a.f2981a, c1033kM2761a.f2982b, str2);
                                        map.put(strM6a, str2);
                                    } else {
                                        map.put(strM6a, this.f2980b);
                                    }
                                    i++;
                                }
                            }
                        }
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException e3) {
                }
            } catch (Throwable th4) {
                inputStream = inputStream2;
                th = th4;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                if (zipFile == null) {
                    throw th;
                }
                try {
                    zipFile.close();
                    throw th;
                } catch (IOException e5) {
                    throw th;
                }
            }
        } catch (Exception e6) {
            zipFile2 = zipFile;
            if (0 != 0) {
                try {
                    inputStream3.close();
                } catch (IOException e7) {
                }
            }
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e8) {
                }
            }
        }
    }
}
