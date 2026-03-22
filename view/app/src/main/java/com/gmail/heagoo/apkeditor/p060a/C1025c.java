package com.gmail.heagoo.apkeditor.p060a;

import android.support.v4.app.NotificationCompat;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1012m;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1018s;
import java.io.IOException;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.c */
/* JADX INFO: loaded from: classes.dex */
final class C1025c {

    /* JADX INFO: renamed from: a */
    public static int f2939a = 1048833;

    /* JADX INFO: renamed from: b */
    private static int f2940b = 1048834;

    /* JADX INFO: renamed from: c */
    private static int f2941c = 1048835;

    /* JADX INFO: renamed from: d */
    private static int f2942d = 1048832;

    /* JADX INFO: renamed from: e */
    private static int f2943e = 1048836;

    /* JADX INFO: renamed from: f */
    private byte[] f2944f;

    /* JADX INFO: renamed from: g */
    private int f2945g;

    /* JADX INFO: renamed from: h */
    private C1018s f2946h;

    public C1025c(C1018s c1018s) {
        this.f2945g = c1018s.m2718c();
        this.f2946h = c1018s;
        for (int i = 0; i < this.f2945g; i++) {
            "android".equals(c1018s.m2716b(i));
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2752a(int i) {
        if (i == 3) {
            return true;
        }
        if (i != 2 && i != 1 && i != 4 && i != 17 && i != 18 && i != 5 && i != 6) {
            if (i < 28 || i > 31) {
                return (i < 16 || i > 31) ? false : false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final int m2753a(C1012m c1012m, InterfaceC1027e interfaceC1027e) throws IOException {
        int iM2687a = c1012m.m2687a();
        int iM2687a2 = c1012m.m2687a();
        this.f2944f = new byte[iM2687a2];
        C1031i.m2758a(this.f2944f, 0, iM2687a);
        C1031i.m2758a(this.f2944f, 4, iM2687a2);
        if (iM2687a2 > 8) {
            c1012m.m2689a(this.f2944f, 8, iM2687a2 - 8);
        }
        if (iM2687a == f2940b) {
            int iM2756a = C1031i.m2756a(this.f2944f, 20);
            int iM2756a2 = C1031i.m2756a(this.f2944f, 28);
            String strM2716b = this.f2946h.m2716b(iM2756a);
            if ("uses-permission".equals(strM2716b) || "manifest".equals(strM2716b) || "application".equals(strM2716b) || "activity".equals(strM2716b) || NotificationCompat.CATEGORY_SERVICE.equals(strM2716b) || "receiver".equals(strM2716b) || "provider".equals(strM2716b) || "activity-alias".equals(strM2716b) || "category".equals(strM2716b) || "permission".equals(strM2716b) || "uses-sdk".equals(strM2716b)) {
                for (int i = 0; i < iM2756a2; i++) {
                    int iM2756a3 = C1031i.m2756a(this.f2944f, (i * 20) + 36 + 4);
                    int iM2756a4 = C1031i.m2756a(this.f2944f, (i * 20) + 36 + 8);
                    int iM2756a5 = C1031i.m2756a(this.f2944f, ((i * 20) + 36) + 12) >> 16;
                    int i2 = ((iM2756a5 >> 8) & 255) | ((iM2756a5 & 255) << 8);
                    int iM2756a6 = C1031i.m2756a(this.f2944f, (i * 20) + 36 + 16);
                    Object[] objArr = {this.f2946h.m2716b(iM2756a3), this.f2946h.m2716b(iM2756a4), Integer.valueOf(i2), Integer.valueOf(iM2756a4), Integer.valueOf(iM2756a6)};
                    interfaceC1027e.mo2754a(this.f2946h.m2716b(iM2756a), iM2756a3, iM2756a4, i2, iM2756a6);
                }
            }
        }
        return iM2687a;
    }
}
