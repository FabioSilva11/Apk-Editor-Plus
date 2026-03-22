package com.gmail.heagoo.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.common.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1488t {

    /* JADX INFO: renamed from: b */
    private static String[] f4320b = {"/data/bin/su", "/system/bin/su", "/system/xbin/su"};

    /* JADX INFO: renamed from: a */
    private String[] f4321a = new String[2];

    /* JADX INFO: renamed from: a */
    private static Process m3526a(String str, String[] strArr) {
        int i = 0;
        Map<String, String> map = System.getenv();
        String[] strArr2 = new String[(strArr != null ? strArr.length : 0) + map.size()];
        int i2 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr2[i2] = entry.getKey() + "=" + entry.getValue();
            i2++;
        }
        if (strArr != null) {
            int length = strArr.length;
            while (i < length) {
                strArr2[i2] = strArr[i];
                i++;
                i2++;
            }
        }
        return Runtime.getRuntime().exec(str, strArr2);
    }

    /* JADX INFO: renamed from: a */
    private static String m3527a(InputStream inputStream) throws IOException {
        int i;
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        do {
            i = inputStreamReader.read(cArr, 0, 8192);
            if (i > 0) {
                sb.append(cArr, 0, i);
            }
        } while (i >= 0);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3528a(Process process) {
        try {
            process.exitValue();
            return false;
        } catch (IllegalThreadStateException e) {
            return true;
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m3529b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m3530a() {
        return this.f4321a[0];
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3531a(String str, String[] strArr, Integer num) {
        return m3533a(str, strArr, num, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3532a(java.lang.String r11, java.lang.String[] r12, java.lang.Integer r13, java.lang.String r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.common.C1488t.m3532a(java.lang.String, java.lang.String[], java.lang.Integer, java.lang.String, boolean):boolean");
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3533a(String str, String[] strArr, Integer num, boolean z) {
        return m3532a(str, strArr, num, null, z);
    }

    /* JADX INFO: renamed from: b */
    public final String m3534b() {
        return this.f4321a[1];
    }
}
