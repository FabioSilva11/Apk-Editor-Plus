package com.gmail.heagoo.apkeditor;

import jadx.core.codegen.CodeWriter;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dj */
/* JADX INFO: loaded from: classes.dex */
final class C1135dj {

    /* JADX INFO: renamed from: a */
    int f3209a;

    /* JADX INFO: renamed from: b */
    String f3210b;

    /* JADX INFO: renamed from: c */
    int f3211c;

    /* JADX INFO: renamed from: d */
    int f3212d;

    /* JADX INFO: renamed from: e */
    int f3213e;

    /* JADX INFO: renamed from: f */
    boolean f3214f = false;

    /* JADX INFO: renamed from: g */
    boolean f3215g = false;

    /* JADX INFO: renamed from: h */
    private String f3216h;

    C1135dj(int i, String str, String str2) {
        this.f3209a = i;
        this.f3210b = str;
        while (this.f3210b.startsWith(str2)) {
            this.f3211c++;
            this.f3210b = this.f3210b.substring(str2.length());
        }
        while (this.f3210b.startsWith(CodeWriter.INDENT)) {
            this.f3211c++;
            this.f3210b = this.f3210b.substring(4);
        }
        this.f3210b = this.f3210b.trim();
        this.f3212d = -1;
        this.f3213e = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c A[PHI: r0
  0x005c: PHI (r0v5 int) = (r0v3 int), (r0v21 int) binds: [B:14:0x0025, B:9:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.String m2865a() {
        /*
            r5 = this;
            r4 = -1
            java.lang.String r0 = r5.f3216h
            if (r0 == 0) goto L8
            java.lang.String r0 = r5.f3216h
        L7:
            return r0
        L8:
            java.lang.String r2 = r5.f3210b
            int r0 = r5.f3209a
            int r1 = r5.f3212d
            if (r0 == r1) goto L1f
            java.lang.String r0 = "</"
            int r0 = r2.indexOf(r0)
            if (r0 == r4) goto L5c
            int r0 = r0 + 2
            r1 = r0
        L1b:
            if (r1 != r4) goto L2b
            r0 = 0
            goto L7
        L1f:
            java.lang.String r0 = "<"
            int r0 = r2.indexOf(r0)
            if (r0 == r4) goto L5c
            int r0 = r0 + 1
            r1 = r0
            goto L1b
        L2b:
            java.lang.String r0 = " "
            int r0 = r2.indexOf(r0)
            if (r0 != r4) goto L43
            int r0 = r5.f3212d
            int r3 = r5.f3213e
            if (r0 != r3) goto L50
            java.lang.String r0 = "/>"
            int r0 = r2.indexOf(r0)
            if (r0 == r4) goto L43
            int r0 = r0 + (-1)
        L43:
            if (r0 == r4) goto L57
            java.lang.String r0 = r2.substring(r1, r0)
        L49:
            java.lang.String r0 = r0.trim()
            r5.f3216h = r0
            goto L7
        L50:
            java.lang.String r0 = ">"
            int r0 = r2.indexOf(r0)
            goto L43
        L57:
            java.lang.String r0 = r2.substring(r1)
            goto L49
        L5c:
            r1 = r0
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.C1135dj.m2865a():java.lang.String");
    }
}
