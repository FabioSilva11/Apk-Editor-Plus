package com.gmail.heagoo.common;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.common.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1476h {

    /* JADX INFO: renamed from: a */
    private static final char[] f4304a = {'\"', '/', '\\', ':', '*', '?', '<', '>', '|'};

    /* JADX INFO: renamed from: a */
    public static long m3506a(File[] fileArr) {
        long j = 0;
        int i = 0;
        while (i < 2) {
            long jM3513b = m3513b(fileArr[i]);
            if (jM3513b <= j) {
                jM3513b = j;
            }
            i++;
            j = jM3513b;
        }
        return j;
    }

    /* JADX INFO: renamed from: a */
    public static String m3507a(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (m3512a(cCharAt)) {
                sb.append('_');
                z = true;
            } else {
                sb.append(cCharAt);
            }
        }
        return z ? sb.toString() : str;
    }

    /* JADX INFO: renamed from: a */
    public static void m3508a(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m3508a(file2);
            }
        }
        file.delete();
    }

    /* JADX INFO: renamed from: a */
    public static void m3509a(File file, File file2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            C0985a.m2244b(bufferedInputStream, bufferedOutputStream);
            bufferedInputStream.close();
            bufferedOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3510a(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    C0985a.m2244b(fileInputStream2, fileOutputStream);
                    fileInputStream2.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m3511a(java.lang.String r3, java.util.List r4) {
        /*
            r2 = 0
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L42
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L42
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L42
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L42
            java.util.Iterator r2 = r4.iterator()     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L40
        Lf:
            boolean r0 = r2.hasNext()     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L40
            if (r0 == 0) goto L2e
            java.lang.Object r0 = r2.next()     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L40
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L40
            r1.write(r0)     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L40
            java.lang.String r0 = "\n"
            r1.write(r0)     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L40
            goto Lf
        L24:
            r0 = move-exception
        L25:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L2d
            r1.close()     // Catch: java.io.IOException -> L3c
        L2d:
            return
        L2e:
            r1.close()     // Catch: java.io.IOException -> L32
            goto L2d
        L32:
            r0 = move-exception
            goto L2d
        L34:
            r0 = move-exception
            r1 = r2
        L36:
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.io.IOException -> L3e
        L3b:
            throw r0
        L3c:
            r0 = move-exception
            goto L2d
        L3e:
            r1 = move-exception
            goto L3b
        L40:
            r0 = move-exception
            goto L36
        L42:
            r0 = move-exception
            r1 = r2
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.common.C1476h.m3511a(java.lang.String, java.util.List):void");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3512a(char c) {
        char[] cArr = f4304a;
        for (int i = 0; i < 9; i++) {
            if (c == cArr[i]) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static long m3513b(File file) {
        long jLastModified = file.lastModified();
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                long jM3513b = m3513b(file2);
                if (jM3513b > jLastModified) {
                    jLastModified = jM3513b;
                }
            }
        }
        return jLastModified;
    }
}
