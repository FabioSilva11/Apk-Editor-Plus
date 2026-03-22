package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1159g {

    /* JADX INFO: renamed from: a */
    protected int f3267a;

    /* JADX INFO: renamed from: b */
    private String f3268b;

    /* JADX INFO: renamed from: a */
    public static String m2916a(InterfaceC1154b interfaceC1154b, String str) {
        int i;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        int iIndexOf = str.indexOf("${", 0);
        while (iIndexOf != -1) {
            int i3 = iIndexOf + 2;
            int iIndexOf2 = str.indexOf("}", i3);
            if (iIndexOf2 == -1) {
                break;
            }
            String strMo2897a = interfaceC1154b.mo2897a(str.substring(i3, iIndexOf2));
            if (strMo2897a != null) {
                arrayList.add(new C1160h(i3 - 2, iIndexOf2 + 1, strMo2897a));
            }
            iIndexOf = str.indexOf("${", iIndexOf2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            C1160h c1160h = (C1160h) it.next();
            int i4 = c1160h.f3269a;
            if (i4 > i) {
                sb.append(str.substring(i, i4));
            }
            sb.append(c1160h.f3271c);
            i2 = c1160h.f3270b;
        }
        if (i < str.length()) {
            sb.append(str.substring(i));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    static String m2917a(BufferedReader bufferedReader, List list, boolean z, List list2) throws IOException {
        String line = bufferedReader.readLine();
        while (line != null) {
            if (z) {
                line = line.trim();
            }
            if (list2.contains(line)) {
                break;
            }
            list.add(line);
            line = bufferedReader.readLine();
        }
        return line;
    }

    /* JADX INFO: renamed from: a */
    protected static void m2918a(InterfaceC1154b interfaceC1154b, List list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            String strM2916a = m2916a(interfaceC1154b, (String) list.get(i2));
            if (strM2916a != null) {
                list.set(i2, strM2916a);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    protected static void m2919a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected static void m2920a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2921a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, ZipEntry zipEntry, String str, InterfaceC1154b interfaceC1154b) {
        InputStream inputStream;
        boolean z = false;
        String str2 = str + "/" + zipEntry.getName();
        String strM2923d = m2923d(str2);
        while (!apkInfoActivity.m2462j().m3059e(strM2923d)) {
            strM2923d = m2923d(strM2923d);
        }
        String[] strArrSplit = str2.substring(strM2923d.length() + 1).split("/");
        if (strArrSplit.length > 1) {
            String str3 = strM2923d;
            for (int i = 0; i < strArrSplit.length - 1; i++) {
                try {
                    apkInfoActivity.m2462j().m3043a(str3, strArrSplit[i], false);
                    str3 = str3 + "/" + strArrSplit[i];
                } catch (Exception e) {
                    interfaceC1154b.mo2900a(R.string.failed_create_dir, e.getMessage());
                }
            }
            inputStream = null;
            try {
                try {
                    inputStream = zipFile.getInputStream(zipEntry);
                    apkInfoActivity.m2462j().m3037a(str2, inputStream);
                    m2919a(inputStream);
                    z = true;
                } catch (Exception e2) {
                    interfaceC1154b.mo2900a(R.string.general_error, e2.getMessage());
                    m2919a(inputStream);
                }
            } catch (Throwable th) {
                m2919a(inputStream);
                throw th;
            }
        } else {
            inputStream = null;
            inputStream = zipFile.getInputStream(zipEntry);
            apkInfoActivity.m2462j().m3037a(str2, inputStream);
            m2919a(inputStream);
            z = true;
        }
        return z;
    }

    /* JADX INFO: renamed from: c */
    static boolean m2922c(String str) {
        int iLastIndexOf;
        if (str == null || (iLastIndexOf = str.lastIndexOf(47)) == -1) {
            return false;
        }
        String strSubstring = str.substring(0, iLastIndexOf);
        return "smali".equals(strSubstring) || strSubstring.startsWith("smali_");
    }

    /* JADX INFO: renamed from: d */
    private static String m2923d(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf > 0) {
            return str.substring(0, iLastIndexOf);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b);

    /* JADX INFO: renamed from: a */
    final String m2925a(String str) {
        File file = new File(str);
        StringBuilder sb = new StringBuilder(((int) file.length()) + 32);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
            }
            while (true) {
                String line2 = bufferedReader.readLine();
                if (line2 == null) {
                    return sb.toString();
                }
                sb.append("\n");
                sb.append(line2);
            }
        } finally {
            m2919a(bufferedReader);
        }
    }

    /* JADX INFO: renamed from: a */
    final void m2926a(ApkInfoActivity apkInfoActivity, String str, InterfaceC1149a interfaceC1149a, InterfaceC1154b interfaceC1154b) throws Throwable {
        ZipFile zipFile;
        String strM2460i = apkInfoActivity.m2460i();
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (!zipEntryNextElement.isDirectory()) {
                    if (!(interfaceC1149a != null ? interfaceC1149a.mo2884a(apkInfoActivity, zipFile, zipEntryNextElement) : false)) {
                        m2921a(apkInfoActivity, zipFile, zipEntryNextElement, strM2460i, interfaceC1154b);
                    }
                }
            }
            zipFile.close();
        } catch (Throwable th2) {
            th = th2;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo2928a();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo2929a(InterfaceC1154b interfaceC1154b);

    /* JADX INFO: renamed from: a */
    final boolean m2930a(String str, C1155c c1155c) {
        if (!"NAME:".equals(str)) {
            return false;
        }
        this.f3268b = c1155c.readLine();
        if (this.f3268b != null) {
            this.f3268b = this.f3268b.trim();
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final String m2931b() {
        return this.f3268b;
    }

    /* JADX INFO: renamed from: b */
    final List m2932b(String str) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return arrayList;
                }
                if (!"".equals(line.trim())) {
                    arrayList.add(line);
                }
            } finally {
                m2919a(bufferedReader);
            }
        }
    }
}
