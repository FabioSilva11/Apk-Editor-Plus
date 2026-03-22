package com.gmail.heagoo.apkeditor.p068se;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.z */
/* JADX INFO: loaded from: classes.dex */
public final class C1370z {

    /* JADX INFO: renamed from: f */
    private static final String[] f3941f = {"res/drawable", "res/mipmap"};

    /* JADX INFO: renamed from: a */
    List f3942a = new ArrayList();

    /* JADX INFO: renamed from: b */
    HashMap f3943b = new HashMap();

    /* JADX INFO: renamed from: c */
    Map f3944c = new HashMap();

    /* JADX INFO: renamed from: d */
    List f3945d = new ArrayList();

    /* JADX INFO: renamed from: e */
    private String f3946e;

    public C1370z(String str) {
        this.f3946e = str;
    }

    /* JADX INFO: renamed from: a */
    private void m3289a(String str, String str2, boolean z) {
        List arrayList = (List) this.f3944c.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f3944c.put(str, arrayList);
        }
        if (!z) {
            arrayList.add(new C1369y(str2, false));
        } else if (this.f3944c.get(str + str2 + "/") == null) {
            arrayList.add(new C1369y(str2, true));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3290a(ZipFile zipFile) {
        try {
            zipFile.close();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3291a(String str) {
        String[] strArr = {".wav", ".mp2", ".mp3", ".ogg", ".aac", ".mpg", ".mpeg", ".mid", ".midi", ".smf", ".jet", ".rtttl", ".imy", ".xmf", ".mp4", ".m4a", ".m4v", ".3gp", ".3gpp", ".3g2", ".3gpp2", ".amr", ".awb", ".wma", ".wmv"};
        for (int i = 0; i < 25; i++) {
            if (str.endsWith(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m3292b(String str) {
        String[] strArr = f3941f;
        for (int i = 0; i < 2; i++) {
            if (str.startsWith(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final void m3293a() throws Throwable {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(this.f3946e);
        } catch (Exception e) {
            e = e;
            zipFile = null;
        } catch (Throwable th) {
            th = th;
            zipFile = null;
            m3290a(zipFile);
            throw th;
        }
        try {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String name = zipEntryNextElement.getName();
                    if (!zipEntryNextElement.isDirectory()) {
                        String[] strArrSplit = name.split("/");
                        String str = "/";
                        for (int i = 0; i < strArrSplit.length - 1; i++) {
                            String str2 = strArrSplit[i];
                            m3289a(str, str2, true);
                            str = str + str2 + "/";
                        }
                        m3289a(str, strArrSplit[strArrSplit.length - 1], false);
                        if (m3292b(name)) {
                            int iIndexOf = name.indexOf(47, 11);
                            if (iIndexOf != -1 && name.indexOf(47, iIndexOf + 1) == -1 && (name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith("bmp"))) {
                                int iLastIndexOf = name.lastIndexOf(47);
                                String strSubstring = iLastIndexOf != -1 ? name.substring(iLastIndexOf + 1) : name;
                                int length = (name.length() - strSubstring.length()) - 1;
                                String strSubstring2 = length > 0 ? name.substring(0, length) : "";
                                C1351g c1351g = (C1351g) this.f3943b.get(strSubstring);
                                if (c1351g == null) {
                                    this.f3942a.add(strSubstring);
                                    this.f3943b.put(strSubstring, new C1351g(strSubstring, strSubstring2));
                                } else {
                                    c1351g.m3274a(strSubstring2);
                                }
                            }
                        } else if (m3291a(name)) {
                            this.f3945d.add(name);
                        }
                    }
                }
                m3290a(zipFile);
            } catch (Throwable th2) {
                th = th2;
                m3290a(zipFile);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            m3290a(zipFile);
        }
    }

    /* JADX INFO: renamed from: b */
    public final String m3294b() {
        return this.f3946e;
    }
}
