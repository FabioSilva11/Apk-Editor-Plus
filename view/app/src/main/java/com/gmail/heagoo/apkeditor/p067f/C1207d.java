package com.gmail.heagoo.apkeditor.p067f;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p003b.p006b.InterfaceC0055m;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.f.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1207d implements InterfaceC0055m {

    /* JADX INFO: renamed from: a */
    private Map f3411a = new HashMap();

    public C1207d(String str, String str2) throws Throwable {
        String[] strArrSplit = str2.split("\\.");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (String str3 : strArrSplit) {
            sb.append(str3);
            sb.append("/");
        }
        File[] fileArrListFiles = new File(sb.toString()).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.getName().startsWith("R$")) {
                m3009a(file);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3009a(java.io.File r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r2 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L5e
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L5e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L5e
            r3.<init>(r5)     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L5e
            r0.<init>(r3)     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L5e
            r1.<init>(r0)     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L5e
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
        L14:
            if (r0 == 0) goto L4d
            java.lang.String r2 = ".field "
            boolean r2 = r0.startsWith(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            if (r2 == 0) goto L48
            java.lang.String r2 = ":I"
            int r2 = r0.indexOf(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r3 = -1
            if (r2 == r3) goto L48
            java.lang.String r3 = " "
            int r3 = r0.lastIndexOf(r3, r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            int r3 = r3 + 1
            java.lang.String r3 = r0.substring(r3, r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            int r2 = r2 + 7
            java.lang.String r0 = r0.substring(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
            r2 = 16
            int r0 = java.lang.Integer.parseInt(r0, r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
            java.util.Map r2 = r4.f3411a     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
            r2.put(r0, r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
        L48:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            goto L14
        L4d:
            r1.close()     // Catch: java.io.IOException -> L66
        L50:
            return
        L51:
            r0 = move-exception
            r1 = r2
        L53:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6a
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L5c
            goto L50
        L5c:
            r0 = move-exception
            goto L50
        L5e:
            r0 = move-exception
            r1 = r2
        L60:
            if (r1 == 0) goto L65
            r1.close()     // Catch: java.io.IOException -> L68
        L65:
            throw r0
        L66:
            r0 = move-exception
            goto L50
        L68:
            r1 = move-exception
            goto L65
        L6a:
            r0 = move-exception
            goto L60
        L6c:
            r0 = move-exception
            goto L53
        L6e:
            r0 = move-exception
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p067f.C1207d.m3009a(java.io.File):void");
    }

    @Override // p000a.p001a.p003b.p006b.InterfaceC0055m
    /* JADX INFO: renamed from: a */
    public final String mo144a(int i) {
        return (String) this.f3411a.get(Integer.valueOf(i));
    }
}
