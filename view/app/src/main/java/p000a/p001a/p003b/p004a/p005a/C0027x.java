package p000a.p001a.p003b.p004a.p005a;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0035i;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: a.a.b.a.a.x */
/* JADX INFO: loaded from: classes.dex */
public class C0027x {

    /* JADX INFO: renamed from: a */
    private final C0031e f33a;

    public C0027x(C0031e c0031e) {
        this.f33a = c0031e;
    }

    /* JADX INFO: renamed from: a */
    private static int m24a(String str) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(47, i);
            if (iIndexOf == -1) {
                return i2;
            }
            i2++;
            i = iIndexOf + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private C0022s m25a(int i, String str, boolean z) {
        return new C0022s(this.f33a, i, str, z);
    }

    /* JADX INFO: renamed from: a */
    public static String m26a(int i) {
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[7 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: a */
    private static void m27a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m28a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m29a(String str, String str2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ZipFile zipFile;
        String str3;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                byte[] bArr = new byte[4096];
                BufferedInputStream bufferedInputStream2 = null;
                while (enumerationEntries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement.isDirectory()) {
                            if (str2.endsWith("/")) {
                                str3 = str2;
                            } else {
                                str3 = (str2 + "/") + zipEntryNextElement.getName();
                            }
                            new File(str3).mkdirs();
                        } else {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(m36d(str2, zipEntryNextElement.getName())));
                            try {
                                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(zipFile2.getInputStream(zipEntryNextElement));
                                while (true) {
                                    try {
                                        int i = bufferedInputStream3.read(bArr, 0, 4096);
                                        if (i == -1) {
                                            break;
                                        } else {
                                            bufferedOutputStream2.write(bArr, 0, i);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        zipFile = zipFile2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        bufferedInputStream = bufferedInputStream3;
                                        m27a(bufferedInputStream);
                                        m28a(bufferedOutputStream);
                                        if (zipFile != null) {
                                            try {
                                                zipFile.close();
                                            } catch (IOException e) {
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                m27a(bufferedInputStream3);
                                m28a(bufferedOutputStream2);
                                bufferedInputStream2 = bufferedInputStream3;
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = bufferedOutputStream2;
                                bufferedInputStream = bufferedInputStream2;
                                zipFile = zipFile2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = bufferedInputStream2;
                        zipFile = zipFile2;
                    }
                }
                zipFile2.close();
                m27a(bufferedInputStream2);
                m28a(bufferedOutputStream);
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                zipFile = zipFile2;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            zipFile = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m30a(String str, String str2, String str3) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ZipFile zipFile;
        BufferedOutputStream bufferedOutputStream = null;
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                byte[] bArr = new byte[4096];
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement.getName().startsWith(str2)) {
                        String strSubstring = zipEntryNextElement.getName().substring(str2.length());
                        if (zipEntryNextElement.isDirectory()) {
                            new File(str3 + "/" + strSubstring).mkdirs();
                        } else {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(m36d(str3, strSubstring)));
                            try {
                                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile2.getInputStream(zipEntryNextElement));
                                while (true) {
                                    try {
                                        int i = bufferedInputStream2.read(bArr, 0, 4096);
                                        if (i == -1) {
                                            break;
                                        } else {
                                            bufferedOutputStream2.write(bArr, 0, i);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        bufferedInputStream = bufferedInputStream2;
                                        zipFile = zipFile2;
                                        m27a(bufferedInputStream);
                                        m28a(bufferedOutputStream);
                                        m31a(zipFile);
                                        throw th;
                                    }
                                }
                                m27a(bufferedInputStream2);
                                m28a(bufferedOutputStream2);
                            } catch (Throwable th2) {
                                th = th2;
                                zipFile = zipFile2;
                                bufferedOutputStream = bufferedOutputStream2;
                                bufferedInputStream = null;
                            }
                        }
                    }
                }
                m27a((InputStream) null);
                m28a((OutputStream) null);
                m31a(zipFile2);
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                zipFile = zipFile2;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
            zipFile = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m31a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m32b(int i) {
        char[] cArr = new char[2];
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[1 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m33b(java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p003b.p004a.p005a.C0027x.m33b(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: renamed from: b */
    public static void m34b(String str, String str2, String str3) {
        BufferedOutputStream bufferedOutputStream;
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                ZipEntry entry = zipFile2.getEntry(str2);
                byte[] bArr = new byte[4096];
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile2.getInputStream(entry));
                    while (true) {
                        try {
                            int i = bufferedInputStream2.read(bArr, 0, 4096);
                            if (i == -1) {
                                m27a(bufferedInputStream2);
                                m28a(bufferedOutputStream);
                                m31a(zipFile2);
                                return;
                            }
                            bufferedOutputStream.write(bArr, 0, i);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            zipFile = zipFile2;
                            m27a(bufferedInputStream);
                            m28a(bufferedOutputStream);
                            m31a(zipFile);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zipFile = zipFile2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                zipFile = zipFile2;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            zipFile = null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static List m35c(String str, String str2) throws Throwable {
        ZipFile zipFile;
        ArrayList arrayList = new ArrayList();
        int iM24a = m24a(str2);
        try {
            zipFile = new ZipFile(str);
        } catch (IOException e) {
            e = e;
            zipFile = null;
        } catch (Throwable th) {
            th = th;
            zipFile = null;
            m31a(zipFile);
            throw th;
        }
        try {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (!zipEntryNextElement.isDirectory()) {
                        String name = zipEntryNextElement.getName();
                        if (name.startsWith(str2) && m24a(name) == iM24a) {
                            arrayList.add(name);
                        }
                    }
                }
                m31a(zipFile);
            } catch (Throwable th2) {
                th = th2;
                m31a(zipFile);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            m31a(zipFile);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    private static File m36d(String str, String str2) {
        String[] strArrSplit = str2.split("/");
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (strArrSplit.length > 1) {
            int i = 0;
            while (i < strArrSplit.length - 1) {
                File file2 = new File(file, strArrSplit[i]);
                i++;
                file = file2;
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return new File(file, strArrSplit[strArrSplit.length - 1]);
    }

    /* JADX INFO: renamed from: a */
    public final C0006c m37a(int i, C0073e[] c0073eArr, C0035i c0035i) throws C0000a {
        C0022s c0022sM25a = m25a(i, (String) null, false);
        if (c0073eArr.length == 0) {
            return new C0006c(c0022sM25a);
        }
        int iIntValue = ((Integer) c0073eArr[0].f190a).intValue();
        if (iIntValue == 16777216) {
            return C0005b.m2a(c0022sM25a, c0073eArr, this, this.f33a);
        }
        String strM80a = c0035i.m80a();
        if ("array".equals(strM80a) || iIntValue == 33554432 || iIntValue == 0) {
            return new C0004a(c0022sM25a, c0073eArr);
        }
        if ("plurals".equals(strM80a) || (iIntValue >= 16777220 && iIntValue <= 16777225)) {
            return new C0021r(c0022sM25a, c0073eArr);
        }
        if ("style".equals(strM80a)) {
            return new C0025v(c0022sM25a, c0073eArr, this);
        }
        throw new C0000a("unsupported res type name for bags. Found: " + strM80a);
    }

    /* JADX INFO: renamed from: a */
    public final C0022s m38a(int i, String str) {
        return m25a(i, str, false);
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0023t m39a(int i, int i2, String str) throws C0000a {
        switch (i) {
            case 0:
                return i2 == 0 ? new C0024u(null, i2) : i2 == 1 ? new C0010g(i2, str, i) : new C0022s(this.f33a, 0, null);
            case 1:
                return m25a(i2, str, false);
            case 2:
                return m25a(i2, str, true);
            case 3:
                return new C0024u(str, i2);
            case 4:
                return new C0016m(Float.intBitsToFloat(i2), i2, str);
            case 5:
                return new C0009f(i2, str);
            case 6:
                return new C0017n(i2, str);
            case 7:
                return m25a(i2, str, false);
            case 8:
                return m25a(i2, str, true);
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            default:
                if (i >= 28 && i <= 31) {
                    return new C0008e(i2, str);
                }
                if (i < 16 || i > 31) {
                    throw new C0000a("Invalid value type: " + i + ", value: " + i2);
                }
                return new C0020q(i2, str, i);
            case 18:
                return new C0007d(i2 != 0, i2, str);
        }
    }
}
