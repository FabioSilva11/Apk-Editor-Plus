package com.gmail.heagoo.apkeditor.p060a.p061a;

import android.R;
import android.util.SparseArray;
import com.gmail.heagoo.apkeditor.p060a.C1029g;
import com.gmail.heagoo.apkeditor.p060a.C1030h;
import jadx.core.deobf.Deobfuscator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1004e {

    /* JADX INFO: renamed from: a */
    private C1012m f2836a;

    /* JADX INFO: renamed from: b */
    private C1011l f2837b;

    /* JADX INFO: renamed from: c */
    private boolean f2838c;

    /* JADX INFO: renamed from: d */
    private String f2839d;

    /* JADX INFO: renamed from: e */
    private int f2840e;

    /* JADX INFO: renamed from: f */
    private int f2841f;

    /* JADX INFO: renamed from: g */
    private C1018s f2842g;

    /* JADX INFO: renamed from: h */
    private C1017r f2843h;

    /* JADX INFO: renamed from: i */
    private C1000a f2844i;

    /* JADX INFO: renamed from: j */
    private C1029g f2845j;

    /* JADX INFO: renamed from: k */
    private C1029g f2846k;

    /* JADX INFO: renamed from: l */
    private Map f2847l = new HashMap();

    public C1004e(InputStream inputStream, String str, boolean z) throws IOException {
        this.f2838c = z;
        this.f2836a = new C1012m(inputStream);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        randomAccessFile.setLength(0L);
        this.f2837b = new C1011l(randomAccessFile);
        try {
            this.f2840e = this.f2836a.m2687a();
            this.f2841f = this.f2836a.m2687a();
            this.f2842g = new C1018s();
            this.f2842g.m2714a(this.f2836a);
            this.f2843h = new C1017r();
            this.f2843h.m2704a(this.f2836a);
            this.f2844i = new C1000a(this.f2842g, this.f2843h);
            this.f2844i.m2660a(this.f2836a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    protected static int m2667a(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    /* JADX INFO: renamed from: a */
    private static String m2669a(String str, String str2) {
        return str2.startsWith(Deobfuscator.CLASS_NAME_SEPARATOR) ? str + str2 : !str2.contains(Deobfuscator.CLASS_NAME_SEPARATOR) ? str + Deobfuscator.CLASS_NAME_SEPARATOR + str2 : str2;
    }

    /* JADX INFO: renamed from: a */
    private static String m2670a(String str, String str2, String str3) {
        return str3.startsWith(new StringBuilder().append(str).append(Deobfuscator.CLASS_NAME_SEPARATOR).toString()) ? str2 + str3.substring(str.length()) : str3;
    }

    /* JADX INFO: renamed from: a */
    private static void m2671a(C1011l c1011l) {
        if (c1011l != null) {
            try {
                c1011l.m2685b();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2672a(boolean z, boolean z2) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            for (C1030h c1030h : this.f2845j.f2965s) {
                if (!arrayList.contains(Integer.valueOf(c1030h.f2971c))) {
                    arrayList.add(Integer.valueOf(c1030h.f2971c));
                    sparseArray.put(c1030h.f2971c, c1030h.f2970b);
                }
            }
            Collections.sort(arrayList);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int iIntValue = ((Integer) arrayList.get(size)).intValue();
                String str = (String) sparseArray.get(iIntValue);
                if (str.startsWith(this.f2845j.f2951e)) {
                    this.f2842g.m2715a(this.f2846k.f2951e + str.substring(this.f2845j.f2951e.length()), iIntValue + 1);
                } else {
                    this.f2842g.m2715a(str + this.f2839d, iIntValue + 1);
                }
            }
        }
        if (z2) {
            this.f2842g.m2715a("installLocation", 0);
        }
    }

    /* JADX INFO: renamed from: a */
    protected static void m2673a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >>> 24);
    }

    /* JADX INFO: renamed from: b */
    protected static void m2675b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
    }

    /* JADX INFO: renamed from: a */
    public final void m2676a() {
        try {
            this.f2837b.m2680a(this.f2840e);
            this.f2837b.m2680a(this.f2841f);
            int i = this.f2842g.f2883a;
            this.f2842g.m2713a(this.f2837b);
            this.f2843h.m2703a(this.f2837b);
            this.f2844i.m2659a(this.f2837b);
            new Object[1][0] = Integer.valueOf(this.f2837b.m2679a());
            this.f2837b.m2681a(4, this.f2837b.m2679a());
        } finally {
            m2671a(this.f2837b);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2677a(C1029g c1029g, C1029g c1029g2) {
        this.f2845j = c1029g;
        this.f2846k = c1029g2;
        boolean z = this.f2845j.f2948b == -1 && this.f2846k.f2948b != -1;
        boolean z2 = (this.f2845j.f2957k == -1 || this.f2846k.f2950d == null || this.f2846k.f2950d.equals(this.f2845j.f2950d)) ? false : true;
        boolean z3 = (this.f2846k.f2951e == null || this.f2846k.f2951e.equals(this.f2845j.f2951e)) ? false : true;
        boolean z4 = (this.f2845j.f2956j < 0 || this.f2846k.f2949c == null || this.f2846k.f2949c.equals(this.f2845j.f2949c)) ? false : true;
        boolean z5 = this.f2838c;
        HashSet hashSet = new HashSet();
        if (z3) {
            Random random = new Random(System.currentTimeMillis());
            this.f2839d = new StringBuilder().append((char) (random.nextInt(26) + 97)).append((char) (random.nextInt(26) + 97)).toString();
        }
        if (z3 && this.f2838c) {
            for (int i = 0; i < this.f2842g.f2886d.length; i++) {
                String strM2716b = this.f2842g.m2716b(i);
                if (strM2716b.startsWith(this.f2845j.f2951e)) {
                    this.f2842g.m2712a(i, this.f2846k.f2951e + strM2716b.substring(this.f2845j.f2951e.length()));
                    hashSet.add(Integer.valueOf(i));
                }
            }
        }
        if (z3) {
            for (Map.Entry entry : this.f2845j.f2964r.entrySet()) {
                int iIntValue = ((Integer) entry.getKey()).intValue();
                if (!hashSet.contains(Integer.valueOf(iIntValue))) {
                    this.f2842g.m2712a(iIntValue, ((String) entry.getValue()) + this.f2839d);
                }
            }
        }
        int i2 = this.f2845j.f2957k;
        if (z2 && i2 != -1) {
            this.f2842g.m2712a(i2, this.f2846k.f2950d);
        }
        int i3 = this.f2845j.f2958l;
        if (z3 && i3 != -1 && !hashSet.contains(Integer.valueOf(i3))) {
            this.f2842g.m2712a(i3, this.f2846k.f2951e);
        }
        if (z3) {
            if (this.f2845j.f2962p != null && !this.f2845j.f2962p.isEmpty()) {
                Collections.sort(this.f2845j.f2962p);
                Iterator it = this.f2845j.f2962p.iterator();
                int i4 = -1;
                while (it.hasNext()) {
                    int iIntValue2 = ((Integer) it.next()).intValue();
                    if (iIntValue2 != i4) {
                        if (!hashSet.contains(Integer.valueOf(iIntValue2))) {
                            String strM2716b2 = this.f2842g.m2716b(iIntValue2);
                            String strM2670a = z5 ? m2670a(this.f2845j.f2951e, this.f2846k.f2951e, strM2716b2) : m2669a(this.f2845j.f2951e, strM2716b2);
                            if (!strM2670a.equals(strM2716b2)) {
                                this.f2842g.m2712a(iIntValue2, strM2670a);
                            }
                        }
                    }
                    i4 = iIntValue2;
                }
            }
            if (!this.f2845j.f2967u.isEmpty()) {
                Iterator it2 = this.f2845j.f2967u.values().iterator();
                while (it2.hasNext()) {
                    int iIntValue3 = ((Integer) it2.next()).intValue();
                    if (!hashSet.contains(Integer.valueOf(iIntValue3))) {
                        String strM2716b3 = this.f2842g.m2716b(iIntValue3);
                        String strM2670a2 = z5 ? m2670a(this.f2845j.f2951e, this.f2846k.f2951e, strM2716b3) : m2669a(this.f2845j.f2951e, strM2716b3);
                        if (!strM2670a2.equals(strM2716b3)) {
                            this.f2842g.m2712a(iIntValue3, strM2670a2);
                        }
                    }
                }
            }
        }
        if (z4) {
            this.f2842g.m2712a(this.f2845j.f2956j, this.f2846k.f2949c);
        }
        m2672a(z3, z);
        if (z) {
            this.f2843h.m2702a(R.attr.installLocation, 0);
        }
        this.f2844i.m2658a();
        if (z) {
            this.f2844i.m2661a("manifest", 0, -1, 268435464, this.f2846k.f2948b);
        } else if (this.f2846k.f2948b != -1) {
            this.f2844i.m2662a("manifest", "installLocation", new C1005f(this));
        }
        if (z3 && !this.f2845j.f2965s.isEmpty()) {
            this.f2844i.m2662a("manifest/application/provider", "authorities", new C1006g(this));
        }
        if (this.f2846k.f2947a != this.f2845j.f2947a) {
            this.f2844i.m2662a("manifest", "versionCode", new C1007h(this));
        }
        if (this.f2845j.f2953g != -1 && this.f2846k.f2953g != this.f2845j.f2953g) {
            this.f2844i.m2662a("manifest/uses-sdk", "minSdkVersion", new C1008i(this));
        }
        if (this.f2845j.f2954h != -1 && this.f2846k.f2954h != this.f2845j.f2954h) {
            this.f2844i.m2662a("manifest/uses-sdk", "targetSdkVersion", new C1009j(this));
        }
        if (this.f2845j.f2955i == -1 || this.f2846k.f2955i == this.f2845j.f2955i) {
            return;
        }
        this.f2844i.m2662a("manifest/uses-sdk", "minSdkVersion", new C1010k(this));
    }

    /* JADX INFO: renamed from: b */
    public final Map m2678b() {
        return this.f2847l;
    }
}
