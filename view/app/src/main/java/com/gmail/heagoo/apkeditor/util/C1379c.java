package com.gmail.heagoo.apkeditor.util;

import android.content.Context;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1028f;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1011l;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1012m;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1018s;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1379c implements InterfaceC1026d {

    /* JADX INFO: renamed from: a */
    private String f4001a;

    /* JADX INFO: renamed from: b */
    private Map f4002b;

    public C1379c(String str, Map map) {
        this.f4001a = str.endsWith("/") ? str : str + "/";
        this.f4002b = map;
    }

    /* JADX INFO: renamed from: a */
    private static void m3317a(C1011l c1011l) {
        if (c1011l != null) {
            try {
                c1011l.m2685b();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3318a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3319a(InputStream inputStream, String str, Map map) throws Throwable {
        C1011l c1011l;
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }
        C1012m c1012m = new C1012m(inputStream);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            randomAccessFile.setLength(0L);
            c1011l = new C1011l(randomAccessFile);
        } catch (Throwable th) {
            th = th;
            c1011l = null;
        }
        try {
            int iM2687a = c1012m.m2687a();
            int iM2687a2 = c1012m.m2687a();
            c1011l.m2680a(iM2687a);
            c1011l.m2680a(iM2687a2);
            C1018s c1018s = new C1018s();
            c1018s.m2714a(c1012m);
            int iM2718c = c1018s.m2718c();
            for (int i = 0; i < iM2718c; i++) {
                String str2 = (String) map2.get(c1018s.m2716b(i));
                if (str2 != null) {
                    c1018s.m2712a(i, str2);
                }
            }
            int i2 = c1018s.f2883a;
            c1018s.m2713a(c1011l);
            int i3 = c1018s.f2883a;
            byte[] bArr = new byte[4096];
            while (true) {
                int iM2691b = c1012m.m2691b(bArr, 0, 4096);
                if (iM2691b == -1) {
                    c1011l.m2681a(4, c1011l.m2679a());
                    m3317a(c1011l);
                    return false;
                }
                c1011l.m2683a(bArr, 0, iM2691b);
            }
        } catch (Throwable th2) {
            th = th2;
            m3317a(c1011l);
            throw th;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d
    /* JADX INFO: renamed from: a */
    public final void mo2692a(Context context, String str, Map map, InterfaceC1028f interfaceC1028f) throws Throwable {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (Map.Entry entry : this.f4002b.entrySet()) {
                String str2 = (String) entry.getKey();
                Map map2 = (Map) entry.getValue();
                if (str2.startsWith(this.f4001a)) {
                    String strSubstring = str2.substring(this.f4001a.length());
                    InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(strSubstring));
                    String str3 = str2 + ".bin";
                    m3319a(inputStream, str3, map2);
                    map.put(strSubstring, str3);
                    inputStream.close();
                }
            }
            zipFile.close();
            m3318a(zipFile);
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            m3318a(zipFile2);
            throw th;
        }
    }
}
