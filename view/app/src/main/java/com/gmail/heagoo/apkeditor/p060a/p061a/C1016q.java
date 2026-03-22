package com.gmail.heagoo.apkeditor.p060a.p061a;

import android.content.Context;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1028f;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1016q implements InterfaceC1026d, Serializable {

    /* JADX INFO: renamed from: a */
    private String f2876a;

    /* JADX INFO: renamed from: b */
    private String f2877b;

    public C1016q(String str, String str2) {
        this.f2876a = str;
        this.f2877b = str2;
    }

    /* JADX INFO: renamed from: a */
    private static void m2700a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d
    /* JADX INFO: renamed from: a */
    public final void mo2692a(Context context, String str, Map map, InterfaceC1028f interfaceC1028f) throws Throwable {
        ZipFile zipFile;
        String strM2263d = C0985a.m2263d(context, "tmp");
        try {
            try {
                zipFile = new ZipFile(str);
            } catch (IOException e) {
                e = e;
                zipFile = null;
            } catch (Throwable th) {
                th = th;
                m2700a(null);
                throw th;
            }
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (!zipEntryNextElement.isDirectory()) {
                        String name = zipEntryNextElement.getName();
                        if (name.endsWith(".xml") && name.startsWith("res/layout")) {
                            InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                            String strM2665a = new C1002c(inputStream, strM2263d).m2665a(this.f2876a, this.f2877b);
                            if (strM2665a != null) {
                                map.put(name, strM2665a);
                            }
                            inputStream.close();
                        }
                    }
                }
                m2700a(zipFile);
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                m2700a(zipFile);
            }
        } catch (Throwable th2) {
            th = th2;
            m2700a(null);
            throw th;
        }
    }
}
