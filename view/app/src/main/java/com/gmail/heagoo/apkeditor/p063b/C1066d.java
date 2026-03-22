package com.gmail.heagoo.apkeditor.p063b;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.b.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1066d {

    /* JADX INFO: renamed from: a */
    private byte[] f3048a;

    /* JADX INFO: renamed from: b */
    private int f3049b;

    public C1066d(byte[] bArr, int i) {
        this.f3048a = bArr;
        this.f3049b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0076 A[PHI: r0 r2
  0x0076: PHI (r0v6 int) = (r0v5 int), (r0v8 int) binds: [B:5:0x001f, B:9:0x003d] A[DONT_GENERATE, DONT_INLINE]
  0x0076: PHI (r2v2 int) = (r2v1 int), (r2v5 int) binds: [B:5:0x001f, B:9:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m2784a() throws com.gmail.heagoo.apkeditor.p063b.C1071i {
        /*
            r7 = this;
            r6 = 1
            r5 = 0
            r4 = 127(0x7f, float:1.78E-43)
            int r0 = r7.f3049b
            byte[] r2 = r7.f3048a
            int r1 = r0 + 1
            r0 = r2[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 <= r4) goto L73
            byte[] r3 = r7.f3048a
            int r2 = r1 + 1
            r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 & 127(0x7f, float:1.78E-43)
            r3 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r3 << 7
            r0 = r0 | r3
            if (r1 <= r4) goto L76
            byte[] r3 = r7.f3048a
            int r1 = r2 + 1
            r2 = r3[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r3 = r3 << 14
            r0 = r0 | r3
            if (r2 <= r4) goto L73
            byte[] r3 = r7.f3048a
            int r2 = r1 + 1
            r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r3 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r3 << 21
            r0 = r0 | r3
            if (r1 <= r4) goto L76
            byte[] r3 = r7.f3048a
            int r1 = r2 + 1
            r2 = r3[r2]
            if (r2 >= 0) goto L59
            com.gmail.heagoo.apkeditor.b.i r0 = new com.gmail.heagoo.apkeditor.b.i
            java.lang.String r1 = "Invalid uleb128 at offset 0x%x"
            java.lang.Object[] r2 = new java.lang.Object[r6]
            int r3 = r7.f3049b
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r5] = r3
            r0.<init>(r1, r2)
            throw r0
        L59:
            r3 = r2 & 15
            r4 = 7
            if (r3 <= r4) goto L70
            com.gmail.heagoo.apkeditor.b.i r0 = new com.gmail.heagoo.apkeditor.b.i
            java.lang.String r1 = "uleb128 is out of range at offset 0x%x"
            java.lang.Object[] r2 = new java.lang.Object[r6]
            int r3 = r7.f3049b
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r5] = r3
            r0.<init>(r1, r2)
            throw r0
        L70:
            int r2 = r2 << 28
            r0 = r0 | r2
        L73:
            r7.f3049b = r1
            return r0
        L76:
            r1 = r2
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p063b.C1066d.m2784a():int");
    }

    /* JADX INFO: renamed from: a */
    public final String m2785a(int i) {
        int[] iArr = new int[1];
        String strM2807a = C1072j.m2807a(this.f3048a, this.f3049b, i, iArr);
        this.f3049b = iArr[0] + this.f3049b;
        return strM2807a;
    }

    /* JADX INFO: renamed from: b */
    public final int m2786b() {
        return this.f3049b;
    }

    /* JADX INFO: renamed from: b */
    public final void m2787b(int i) {
        this.f3049b = i;
    }
}
