package com.gmail.heagoo.apkeditor.util;

import android.app.Activity;
import android.support.graphics.drawable.PathInterpolatorCompat;
import android.util.Log;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.common.C1488t;
import com.gmail.heagoo.common.C1491w;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1400x {

    /* JADX INFO: renamed from: a */
    public String f4065a;

    /* JADX INFO: renamed from: b */
    public String f4066b;

    /* JADX INFO: renamed from: c */
    private String f4067c;

    /* JADX INFO: renamed from: d */
    private int f4068d;

    /* JADX INFO: renamed from: e */
    private byte[] f4069e;

    /* JADX INFO: renamed from: f */
    private String f4070f;

    public C1400x(String str) {
        this.f4070f = str;
    }

    /* JADX INFO: renamed from: a */
    private String m3374a(Activity activity) {
        String str;
        try {
            List listM3536a = new C1491w("/proc/self/maps").m3536a();
            String packageName = activity.getPackageName();
            int i = 0;
            while (true) {
                if (i >= listM3536a.size()) {
                    str = null;
                    break;
                }
                String str2 = (String) listM3536a.get(i);
                if (str2.endsWith(".odex") && str2.contains("/" + packageName)) {
                    str = str2.split("\\s+")[r0.length - 1];
                    break;
                }
                i++;
            }
            if (str == null) {
                return null;
            }
            int iIndexOf = str.indexOf("/" + activity.getPackageName());
            String strSubstring = str.substring(0, iIndexOf);
            C1488t c1488t = new C1488t();
            c1488t.m3533a("ls " + strSubstring, null, Integer.valueOf(PathInterpolatorCompat.MAX_NUM_POINTS), true);
            String strM3530a = c1488t.m3530a();
            if (strM3530a == null || strM3530a.equals("")) {
                return null;
            }
            String strM3375a = m3375a(strM3530a);
            if (strM3375a == null) {
                return null;
            }
            return strSubstring + "/" + strM3375a + str.substring(str.indexOf(47, iIndexOf + 1));
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m3375a(String str) {
        char cCharAt;
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                if (line.equals(this.f4070f)) {
                    return line;
                }
                if (line.startsWith(this.f4070f) && (cCharAt = line.charAt(this.f4070f.length())) != '.') {
                    if (!((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                        return line;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3376a(Activity activity, String str, boolean z) {
        try {
            String str2 = activity.getPackageManager().getApplicationInfo(this.f4070f, 0).sourceDir;
            this.f4067c = str2.substring(str2.lastIndexOf(47) + 1);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[65536];
            int i = 0;
            while (i < 65536) {
                int i2 = fileInputStream.read(bArr, i, 65536 - i);
                if (i2 == -1) {
                    break;
                }
                i += i2;
            }
            fileInputStream.close();
            boolean zM3377a = m3377a(bArr, this.f4067c, z);
            return !zM3377a ? m3377a(bArr, str2, z) : zM3377a;
        } catch (Exception e) {
            Log.d("DEBUG", "Exception: " + e.getMessage() + ": " + e);
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3377a(byte[] bArr, String str, boolean z) {
        byte b2;
        int length = str.length();
        byte[] bArr2 = {(byte) length, (byte) (length >> 8), (byte) (length >> 16), (byte) (length >>> 24)};
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= (65536 - length) - 16) {
                return false;
            }
            if (bArr[i2] == bArr2[0] && bArr[i2 + 1] == bArr2[1] && bArr[i2 + 2] == bArr2[2] && bArr[i2 + 3] == bArr2[3]) {
                byte[] bytes = str.getBytes();
                int i3 = i2 + 4;
                int length2 = bytes.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        b2 = 0;
                        break;
                    }
                    if (bArr[i3 + i4] != bytes[i4 + 0]) {
                        if (bArr[i3 + i4] < bytes[i4 + 0]) {
                            b2 = -1;
                            break;
                        }
                        if (bArr[i3 + i4] > bytes[i4 + 0]) {
                            b2 = 1;
                            break;
                        }
                    }
                    i4++;
                }
                if (b2 == 0) {
                    this.f4068d = i2 + 4 + bytes.length;
                    if (z) {
                        this.f4069e = new byte[]{bArr[i2 + 4 + bytes.length], bArr[i2 + 5 + bytes.length], bArr[i2 + 6 + bytes.length], bArr[i2 + 7 + bytes.length]};
                    }
                    return true;
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3378b(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            randomAccessFile.seek(this.f4068d);
            randomAccessFile.write(this.f4069e);
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3379a(Activity activity, String str) throws Throwable {
        this.f4066b = m3374a(activity);
        if (this.f4066b == null) {
            this.f4065a = activity.getString(R.string.patch_err_odex_not_found1);
            return;
        }
        C1488t c1488t = new C1488t();
        c1488t.m3531a("ls " + this.f4066b, null, Integer.valueOf(PathInterpolatorCompat.MAX_NUM_POINTS));
        String strM3534b = c1488t.m3534b();
        if (strM3534b != null && !strM3534b.equals("")) {
            String strReplace = this.f4066b.contains("/arm64/") ? this.f4066b.replace("/arm64/", "/arm/") : this.f4066b.replace("/arm/", "/arm64/");
            c1488t.m3531a("ls " + strReplace, null, Integer.valueOf(PathInterpolatorCompat.MAX_NUM_POINTS));
            String strM3534b2 = c1488t.m3534b();
            if (strM3534b2 != null && !strM3534b2.equals("")) {
                this.f4065a = String.format(activity.getString(2131165627), this.f4066b, strReplace);
                return;
            }
            this.f4066b = strReplace;
        }
        m3376a(activity, this.f4066b, true);
        if (this.f4069e == null) {
            this.f4065a = "Cannot get the original checksum.";
            return;
        }
        try {
            String strM2263d = C0985a.m2263d(activity, "tmp");
            String str2 = strM2263d + this.f4067c;
            C1476h.m3510a(str, str2);
            String str3 = strM2263d + "odex";
            String str4 = "dex2oat --dex-file=" + this.f4067c + " --oat-file=" + str3 + (this.f4066b.contains("/arm64/") ? " --instruction-set=arm64" : "");
            C1488t c1488t2 = new C1488t();
            c1488t2.m3532a(str4, null, 10000, strM2263d, false);
            new File(str2).delete();
            if (m3376a(activity, str3, false)) {
                m3378b(str3);
                c1488t2.m3531a("cp " + str3 + " " + this.f4066b, null, 5000);
            } else {
                this.f4065a = "Cannot fix the checksum.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new C1488t().m3531a("am force-stop " + this.f4070f, null, 5000);
    }
}
