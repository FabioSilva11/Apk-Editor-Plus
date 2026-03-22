package com.gmail.heagoo.apkeditor.p063b;

import android.util.Log;
import com.gmail.heagoo.neweditor.Token;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.b.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1067e {

    /* JADX INFO: renamed from: a */
    private byte[] f3050a;

    /* JADX INFO: renamed from: b */
    private C1064b f3051b;

    /* JADX INFO: renamed from: c */
    private List f3052c;

    public C1067e(String str) {
        this(str, "classes.dex");
    }

    public C1067e(String str, String str2) throws Throwable {
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        ZipFile zipFile2 = null;
        this.f3052c = new ArrayList();
        try {
            zipFile = new ZipFile(str);
            try {
                ZipEntry entry = zipFile.getEntry(str2);
                int size = (int) entry.getSize();
                this.f3050a = new byte[size];
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                int i = 0;
                while (i < size) {
                    try {
                        i += bufferedInputStream.read(this.f3050a, i, size - i);
                    } catch (Exception e) {
                        e = e;
                        zipFile2 = zipFile;
                        try {
                            e.printStackTrace();
                            C0985a.m2212a((Closeable) bufferedInputStream);
                            C0985a.m2219a(zipFile2);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            zipFile = zipFile2;
                            bufferedInputStream2 = bufferedInputStream;
                            C0985a.m2212a((Closeable) bufferedInputStream2);
                            C0985a.m2219a(zipFile);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        C0985a.m2212a((Closeable) bufferedInputStream2);
                        C0985a.m2219a(zipFile);
                        throw th;
                    }
                }
                this.f3051b = new C1064b(this.f3050a);
                C0985a.m2212a((Closeable) bufferedInputStream);
                C0985a.m2219a(zipFile);
            } catch (Exception e2) {
                e = e2;
                bufferedInputStream = null;
                zipFile2 = zipFile;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m2788a(int i, int i2) {
        int i3 = 0;
        int i4 = i;
        while (i3 < i2) {
            while ((this.f3050a[i4] & 128) != 0) {
                i4++;
            }
            i3++;
            i4++;
        }
        return i4 - i;
    }

    /* JADX INFO: renamed from: a */
    private int m2789a(int i, int[] iArr) {
        int i2 = i;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = 0;
            int i5 = i2;
            int i6 = 0;
            while ((this.f3050a[i5] & 128) != 0) {
                i4 |= (this.f3050a[i5] & Token.END) << i6;
                i6 += 7;
                i5++;
            }
            int i7 = i4 | (this.f3050a[i5] << i6);
            i2 = i5 + 1;
            iArr[i3] = i7;
        }
        return i2 - i;
    }

    /* JADX INFO: renamed from: a */
    private static String m2790a(String str) {
        return "L" + str.replace('.', '/');
    }

    /* JADX INFO: renamed from: a */
    private static String m2791a(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            if (str.startsWith(str2)) {
                return ((String) entry.getValue()) + str.substring(str2.length());
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private void m2792a(int i, int i2, int i3) {
        int iM2771a = C1064b.m2771a(this.f3050a, i);
        if (iM2771a >= i2) {
            C1064b.m2772a(iM2771a + i3, this.f3050a, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2793a(List list) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            C1070h c1070h = (C1070h) list.get(0);
            messageDigest.update(c1070h.f3057a, 32, c1070h.f3059c - 32);
            for (int i = 1; i < list.size(); i++) {
                C1070h c1070h2 = (C1070h) list.get(i);
                messageDigest.update(c1070h2.f3057a, c1070h2.f3058b, c1070h2.f3059c);
            }
            byte[] bArrDigest = messageDigest.digest();
            System.arraycopy(bArrDigest, 0, c1070h.f3057a, 12, bArrDigest.length);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2794a(List list, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1070h c1070h = (C1070h) it.next();
            bufferedOutputStream.write(c1070h.f3057a, c1070h.f3058b, c1070h.f3059c);
        }
        bufferedOutputStream.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x037a  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m2795a(java.lang.String r26, java.util.List r27) {
        /*
            Method dump skipped, instruction units count: 901
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p063b.C1067e.m2795a(java.lang.String, java.util.List):boolean");
    }

    /* JADX INFO: renamed from: a */
    private boolean m2796a(String str, List list, String str2, String str3) {
        String strM2790a = m2790a(str2);
        String str4 = "[" + strM2790a;
        String strM2790a2 = m2790a(str3);
        String str5 = "[" + strM2790a2;
        String str6 = "content://" + str2;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            int i8 = i;
            if (i8 >= list.size()) {
                break;
            }
            C1069g c1069g = (C1069g) list.get(i8);
            if (c1069g.f3056d != null) {
                if (c1069g.f3056d.startsWith(strM2790a)) {
                    c1069g.m2805a(strM2790a2 + c1069g.f3056d.substring(strM2790a.length()));
                    if (i2 == -1) {
                        i2 = i8;
                    }
                    i3 = i8 + 1;
                } else if (c1069g.f3056d.startsWith(str2)) {
                    c1069g.m2805a(str3 + c1069g.f3056d.substring(str2.length()));
                    if (i4 == -1) {
                        i4 = i8;
                    }
                    i5 = i8 + 1;
                } else if (c1069g.f3056d.startsWith(str4)) {
                    c1069g.m2805a(str5 + c1069g.f3056d.substring(str4.length()));
                    if (i2 == -1) {
                        i6 = i8;
                    }
                    i7 = i8 + 1;
                } else if (c1069g.f3056d.startsWith(str6)) {
                    c1069g.m2805a("content://" + str3 + c1069g.f3056d.substring(str6.length()));
                }
            }
            i = i8 + 1;
        }
        if (i2 == -1) {
            return false;
        }
        if (m2797a(list, i2, i3)) {
            Log.e("DEBUG", "The string order is changed! (as the class name change)");
        }
        if (i4 != -1 && m2797a(list, i4, i5)) {
            Log.e("DEBUG", "The string order is changed! (as the pkg name change)");
        }
        if (i6 != -1 && m2797a(list, i6, i7)) {
            Log.e("DEBUG", "The string order is changed! (as the array class name change)");
        }
        return m2795a(str, list);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2797a(List list, int i, int i2) {
        int size = list.size();
        C1069g c1069g = i > 0 ? (C1069g) list.get(i - 1) : null;
        C1069g c1069g2 = i2 < size ? (C1069g) list.get(i2) : null;
        return (c1069g != null && ((C1069g) list.get(i)).m2804a(c1069g) < 0) || (c1069g2 != null && ((C1069g) list.get(i2 + (-1))).m2804a(c1069g2) > 0);
    }

    /* JADX INFO: renamed from: b */
    private static void m2798b(List list) {
        byte[] bArr = new byte[4];
        Adler32 adler32 = new Adler32();
        C1070h c1070h = (C1070h) list.get(0);
        adler32.update(c1070h.f3057a, 12, c1070h.f3059c - 12);
        for (int i = 1; i < list.size(); i++) {
            C1070h c1070h2 = (C1070h) list.get(i);
            adler32.update(c1070h2.f3057a, c1070h2.f3058b, c1070h2.f3059c);
        }
        long value = adler32.getValue();
        bArr[0] = (byte) (value & 255);
        bArr[1] = (byte) ((value >> 8) & 255);
        bArr[2] = (byte) ((value >> 16) & 255);
        bArr[3] = (byte) ((value >> 24) & 255);
        System.arraycopy(bArr, 0, c1070h.f3057a, 8, 4);
    }

    /* JADX INFO: renamed from: a */
    public final void m2799a(Map map, String str) throws Exception {
        int length = 0;
        byte[] bArr = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr[i] = 0;
        }
        Iterator it = map.entrySet().iterator();
        while (true) {
            byte[] bArr2 = bArr;
            int i2 = length;
            if (!it.hasNext()) {
                C1064b c1064b = new C1064b(this.f3050a);
                int i3 = 0;
                while (i3 < c1064b.m2778b()) {
                    int iM2776a = c1064b.m2776a(i3);
                    C1066d c1066d = new C1066d(this.f3050a, (this.f3050a[iM2776a + 3] << 24) | (this.f3050a[iM2776a] & 255) | ((this.f3050a[iM2776a + 1] & 255) << 8) | ((this.f3050a[iM2776a + 2] & 255) << 16));
                    c1066d.m2784a();
                    if (this.f3050a[c1066d.m2786b()] == 76) {
                        break;
                    } else {
                        i3++;
                    }
                }
                String strM2791a = "";
                while (true) {
                    int i4 = i3;
                    String str2 = strM2791a;
                    if (i4 >= c1064b.m2778b()) {
                        break;
                    }
                    int iM2776a2 = c1064b.m2776a(i4);
                    C1066d c1066d2 = new C1066d(this.f3050a, (this.f3050a[iM2776a2 + 3] << 24) | (this.f3050a[iM2776a2] & 255) | ((this.f3050a[iM2776a2 + 1] & 255) << 8) | ((this.f3050a[iM2776a2 + 2] & 255) << 16));
                    int iM2784a = c1066d2.m2784a();
                    if (this.f3050a[c1066d2.m2786b()] != 76) {
                        break;
                    }
                    int iM2786b = c1066d2.m2786b();
                    String strM2785a = c1066d2.m2785a(iM2784a);
                    strM2791a = m2791a(strM2785a, map);
                    if (strM2791a != null) {
                        System.arraycopy(strM2791a.getBytes(), 0, this.f3050a, iM2786b, strM2791a.length());
                    }
                    if (strM2791a == null) {
                        strM2791a = strM2785a;
                    }
                    if (strM2791a.compareTo(str2) <= 0) {
                        Log.e("ERROR", "Order break: " + strM2791a + ", " + str2);
                    }
                    i3 = i4 + 1;
                }
                byte[] bArr3 = this.f3050a;
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    messageDigest.update(bArr3, 32, bArr3.length - 32);
                    byte[] bArrDigest = messageDigest.digest();
                    System.arraycopy(bArrDigest, 0, bArr3, 12, bArrDigest.length);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                byte[] bArr4 = this.f3050a;
                Adler32 adler32 = new Adler32();
                adler32.update(bArr4, 12, bArr4.length - 12);
                long value = adler32.getValue();
                System.arraycopy(new byte[]{(byte) (255 & value), (byte) ((value >> 8) & 255), (byte) ((value >> 16) & 255), (byte) ((value >> 24) & 255)}, 0, bArr4, 8, 4);
                byte[] bArr5 = this.f3050a;
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                fileOutputStream.write(bArr5);
                fileOutputStream.close();
                return;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str3 = (String) entry.getKey();
            if (str3.length() != ((String) entry.getValue()).length()) {
                throw new Exception("Different class name length not supported.");
            }
            if (str3.length() >= bArr2.length) {
                bArr = new byte[str3.length() + 1];
                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            } else {
                bArr = bArr2;
            }
            bArr[str3.length()] = 1;
            length = str3.length() > i2 ? str3.length() : i2;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2800a(String str, String str2, String str3) throws C1071i {
        C1069g c1069g;
        int iM2778b = this.f3051b.m2778b();
        int[] iArr = new int[iM2778b];
        ArrayList arrayList = new ArrayList(iM2778b);
        for (int i = 0; i < iM2778b; i++) {
            int iM2776a = this.f3051b.m2776a(i);
            iArr[i] = (this.f3050a[iM2776a + 3] << 24) | (this.f3050a[iM2776a] & 255) | ((this.f3050a[iM2776a + 1] & 255) << 8) | ((this.f3050a[iM2776a + 2] & 255) << 16);
        }
        byte bCharAt = str.charAt(0);
        C1066d c1066d = new C1066d(this.f3050a, iArr[0]);
        for (int i2 = 0; i2 < iM2778b; i2++) {
            c1066d.m2787b(iArr[i2]);
            int iM2784a = c1066d.m2784a();
            int iM2786b = c1066d.m2786b();
            String strM2785a = (this.f3050a[iM2786b] == 76 || this.f3050a[iM2786b] == 91 || this.f3050a[iM2786b] == 99 || this.f3050a[iM2786b] == bCharAt) ? c1066d.m2785a(iM2784a) : null;
            if (i2 + 1 >= iM2778b || iArr[i2 + 1] <= iArr[i2]) {
                if (strM2785a == null) {
                    strM2785a = c1066d.m2785a(iM2784a);
                }
                c1069g = new C1069g(i2, strM2785a, this.f3050a, iArr[i2], new C1069g(i2, strM2785a).m2803a());
            } else {
                c1069g = new C1069g(i2, strM2785a, this.f3050a, iArr[i2], iArr[i2 + 1] - iArr[i2]);
            }
            arrayList.add(c1069g);
        }
        return m2796a(str3, arrayList, str, str2);
    }
}
