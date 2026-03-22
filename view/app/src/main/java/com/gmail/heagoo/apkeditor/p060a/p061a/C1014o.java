package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1014o {

    /* JADX INFO: renamed from: a */
    private static int f2859a = 1048833;

    /* JADX INFO: renamed from: b */
    private static int f2860b = 1048834;

    /* JADX INFO: renamed from: c */
    private static int f2861c = 1048835;

    /* JADX INFO: renamed from: d */
    private static int f2862d = 1048832;

    /* JADX INFO: renamed from: e */
    private static int f2863e = 1048836;

    /* JADX INFO: renamed from: f */
    private C1012m f2864f;

    /* JADX INFO: renamed from: g */
    private C1011l f2865g;

    /* JADX INFO: renamed from: h */
    private int f2866h = 29;

    /* JADX INFO: renamed from: i */
    private List f2867i;

    /* JADX INFO: renamed from: j */
    private C1018s f2868j;

    /* JADX INFO: renamed from: k */
    private int f2869k;

    /* JADX INFO: renamed from: l */
    private int f2870l;

    /* JADX INFO: renamed from: m */
    private int f2871m;

    /* JADX INFO: renamed from: n */
    private byte[] f2872n;

    /* JADX INFO: renamed from: o */
    private int f2873o;

    public C1014o(InputStream inputStream, String str) throws IOException {
        this.f2864f = new C1012m(inputStream);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        randomAccessFile.setLength(0L);
        this.f2865g = new C1011l(randomAccessFile);
        int iM2687a = this.f2864f.m2687a();
        this.f2869k = this.f2864f.m2687a();
        this.f2865g.m2680a(iM2687a);
        this.f2865g.m2680a(this.f2869k);
        this.f2868j = new C1018s();
        this.f2868j.m2714a(this.f2864f);
        this.f2873o = this.f2868j.f2883a;
        new Object[1][0] = Integer.valueOf(this.f2868j.f2883a);
        new Object[1][0] = Integer.valueOf(this.f2868j.f2884b);
        new Object[1][0] = Integer.valueOf(this.f2868j.f2885c);
    }

    /* JADX INFO: renamed from: a */
    private int m2693a(int i, int i2) {
        int i3 = 0;
        List listM2711a = this.f2868j.m2711a();
        int size = listM2711a.size() - 1;
        while (size >= 0) {
            int i4 = i >= ((Integer) listM2711a.get(size)).intValue() ? i3 + 1 : i3;
            size--;
            i3 = i4;
        }
        if (i3 > 0) {
            C1004e.m2673a(this.f2872n, i2, i + i3);
        }
        return i + i3;
    }

    /* JADX INFO: renamed from: c */
    private static boolean m2694c(int i) {
        return i == 3;
    }

    /* JADX INFO: renamed from: a */
    public final void m2695a() {
        int iM2687a;
        boolean z;
        C1017r c1017r = new C1017r();
        c1017r.m2704a(this.f2864f);
        this.f2868j.m2713a(this.f2865g);
        this.f2869k += this.f2868j.f2883a - this.f2873o;
        c1017r.m2703a(this.f2865g);
        int iM2710a = this.f2868j.m2710a("uses-permission");
        byte[] bArr = new byte[56];
        byte[] bArr2 = new byte[24];
        do {
            C1012m c1012m = this.f2864f;
            iM2687a = c1012m.m2687a();
            int iM2687a2 = c1012m.m2687a();
            this.f2872n = new byte[iM2687a2];
            C1004e.m2673a(this.f2872n, 0, iM2687a);
            C1004e.m2673a(this.f2872n, 4, iM2687a2);
            if (iM2687a2 > 8) {
                c1012m.m2689a(this.f2872n, 8, iM2687a2 - 8);
            }
            if (iM2687a == f2860b) {
                m2693a(C1004e.m2667a(this.f2872n, 16), 16);
                int iM2693a = m2693a(C1004e.m2667a(this.f2872n, 20), 20);
                int iM2667a = C1004e.m2667a(this.f2872n, 28);
                if (this.f2868j.m2716b(iM2693a).equals("manifest")) {
                    for (int i = 0; i < iM2667a; i++) {
                        m2693a(C1004e.m2667a(this.f2872n, (i * 20) + 36), (i * 20) + 36);
                        int iM2693a2 = m2693a(C1004e.m2667a(this.f2872n, (i * 20) + 36 + 4), (i * 20) + 36 + 4);
                        int iM2693a3 = m2693a(C1004e.m2667a(this.f2872n, (i * 20) + 36 + 8), (i * 20) + 36 + 8);
                        int iM2667a2 = C1004e.m2667a(this.f2872n, ((i * 20) + 36) + 12) >> 16;
                        int i2 = ((iM2667a2 >> 8) & 255) | ((iM2667a2 & 255) << 8);
                        int iM2667a3 = C1004e.m2667a(this.f2872n, (i * 20) + 36 + 16);
                        if (m2694c(i2)) {
                            iM2667a3 = m2693a(iM2667a3, (i * 20) + 36 + 16);
                        }
                        String strM2716b = this.f2868j.m2716b(iM2693a2);
                        if ("versionCode".equals(strM2716b)) {
                            if (iM2667a3 != -1) {
                                C1004e.m2673a(this.f2872n, (i * 20) + 36 + 16, this.f2870l);
                            } else if (iM2693a3 != -1) {
                                C1004e.m2673a(this.f2872n, (i * 20) + 36 + 8, this.f2870l);
                            }
                        } else if ("installLocation".equals(strM2716b)) {
                            if (iM2667a3 != -1) {
                                C1004e.m2673a(this.f2872n, (i * 20) + 36 + 16, this.f2871m);
                            } else if (iM2693a3 != -1) {
                                C1004e.m2673a(this.f2872n, (i * 20) + 36 + 8, this.f2871m);
                            }
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < iM2667a; i3++) {
                        m2693a(C1004e.m2667a(this.f2872n, (i3 * 20) + 36), (i3 * 20) + 36);
                        m2693a(C1004e.m2667a(this.f2872n, (i3 * 20) + 36 + 4), (i3 * 20) + 36 + 4);
                        m2693a(C1004e.m2667a(this.f2872n, (i3 * 20) + 36 + 8), (i3 * 20) + 36 + 8);
                        int iM2667a4 = C1004e.m2667a(this.f2872n, ((i3 * 20) + 36) + 12) >> 16;
                        int i4 = ((iM2667a4 & 255) << 8) | ((iM2667a4 >> 8) & 255);
                        int iM2667a5 = C1004e.m2667a(this.f2872n, (i3 * 20) + 36 + 16);
                        if (m2694c(i4)) {
                            m2693a(iM2667a5, (i3 * 20) + 36 + 16);
                        }
                    }
                }
            } else if (iM2687a == f2861c || iM2687a == f2859a || iM2687a == f2862d) {
                m2693a(C1004e.m2667a(this.f2872n, 16), 16);
                m2693a(C1004e.m2667a(this.f2872n, 20), 20);
            }
            if (iM2687a == C1001b.f2827b) {
                if (C1004e.m2667a(this.f2872n, 20) == iM2710a) {
                    System.arraycopy(this.f2872n, 0, bArr, 0, 56);
                }
                z = false;
            } else if (iM2687a == C1001b.f2828c && C1004e.m2667a(this.f2872n, 20) == iM2710a) {
                System.arraycopy(this.f2872n, 0, bArr2, 0, 24);
                z = true;
            } else {
                z = false;
            }
            this.f2865g.m2682a(this.f2872n);
            if (z && this.f2867i != null) {
                for (int i5 = 1; i5 < this.f2867i.size(); i5++) {
                    C1004e.m2673a(bArr, 44, this.f2866h + i5);
                    C1004e.m2673a(bArr, 52, this.f2866h + i5);
                    this.f2865g.m2682a(bArr);
                    this.f2869k += 56;
                    this.f2865g.m2682a(bArr2);
                    this.f2869k += 24;
                }
            }
        } while (iM2687a != C1001b.f2826a);
        this.f2865g.m2681a(4, this.f2869k);
        this.f2865g.m2685b();
    }

    /* JADX INFO: renamed from: a */
    public final void m2696a(int i) {
        this.f2871m = i;
    }

    /* JADX INFO: renamed from: a */
    public final void m2697a(String str, String str2) {
        for (int i = 0; i < this.f2868j.f2884b; i++) {
            if (this.f2868j.m2716b(i).equals(str)) {
                this.f2868j.m2712a(i, str2);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2698a(List list) {
        this.f2867i = list;
        this.f2866h = this.f2868j.m2710a("aaaaaa.permission.READ_EXTERNAL_STORAGE");
        Collections.sort(list);
        this.f2868j.m2712a(this.f2866h, (String) list.get(0));
        for (int size = list.size() - 1; size > 0; size--) {
            this.f2868j.m2715a((String) list.get(size), this.f2866h + 1);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2699b(int i) {
        this.f2870l = i;
    }
}
