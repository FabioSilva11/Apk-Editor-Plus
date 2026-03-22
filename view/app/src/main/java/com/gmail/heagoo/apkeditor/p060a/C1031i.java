package com.gmail.heagoo.apkeditor.p060a;

import android.R;
import android.support.v4.app.NotificationCompat;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1012m;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1017r;
import com.gmail.heagoo.apkeditor.p060a.p061a.C1018s;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1031i implements InterfaceC1027e {

    /* JADX INFO: renamed from: a */
    private C1012m f2972a;

    /* JADX INFO: renamed from: b */
    private int f2973b;

    /* JADX INFO: renamed from: c */
    private C1018s f2974c;

    /* JADX INFO: renamed from: d */
    private C1017r f2975d;

    /* JADX INFO: renamed from: g */
    private C1030h f2978g;

    /* JADX INFO: renamed from: f */
    private int f2977f = -1;

    /* JADX INFO: renamed from: e */
    private C1029g f2976e = new C1029g();

    public C1031i(InputStream inputStream) {
        this.f2972a = new C1012m(inputStream);
    }

    /* JADX INFO: renamed from: a */
    protected static int m2756a(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    /* JADX INFO: renamed from: a */
    public static String m2757a(int i) {
        switch (i) {
            case R.attr.theme:
                return "theme";
            case R.attr.label:
                return "label";
            case R.attr.icon:
                return "icon";
            case R.attr.name:
                return "name";
            case R.attr.authorities:
                return "authorities";
            case R.attr.versionCode:
                return "versionCode";
            case R.attr.versionName:
                return "versionName";
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    protected static void m2758a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >>> 24);
    }

    /* JADX INFO: renamed from: a */
    public final C1029g m2759a() {
        return this.f2976e;
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.InterfaceC1027e
    /* JADX INFO: renamed from: a */
    public final void mo2754a(String str, int i, int i2, int i3, int i4) {
        String strM2716b = this.f2974c.m2716b(i);
        if ((strM2716b == null || strM2716b.equals("")) && i < this.f2975d.m2701a()) {
            strM2716b = m2757a(this.f2975d.f2878a[i]);
        }
        if (i4 < 0) {
            i4 = i2;
        }
        if ("uses-permission".equals(str)) {
            if ("name".equals(strM2716b)) {
                this.f2976e.f2968v.add(this.f2974c.m2716b(i4));
                return;
            }
            return;
        }
        if ("manifest".equals(str)) {
            if ("versionCode".equals(strM2716b)) {
                this.f2976e.f2947a = i4;
                return;
            }
            if ("versionName".equals(strM2716b) && C1025c.m2752a(i3)) {
                this.f2976e.f2957k = i4;
                this.f2976e.f2950d = this.f2974c.m2716b(i4);
                return;
            } else if ("installLocation".equals(strM2716b)) {
                this.f2976e.f2948b = i4;
                return;
            } else {
                if ("package".equals(strM2716b) && C1025c.m2752a(i3)) {
                    this.f2976e.f2958l = i4;
                    this.f2976e.f2951e = this.f2974c.m2716b(i4);
                    return;
                }
                return;
            }
        }
        if ("application".equals(str)) {
            if ("label".equals(strM2716b)) {
                if (!C1025c.m2752a(i3)) {
                    this.f2976e.f2960n = i4;
                    return;
                }
                this.f2976e.f2956j = i4;
                this.f2976e.f2949c = this.f2974c.m2716b(i4);
                return;
            }
            if ("name".equals(strM2716b)) {
                this.f2976e.f2962p.add(Integer.valueOf(i4));
                this.f2976e.f2952f = this.f2974c.m2716b(i4);
                return;
            } else {
                if ("icon".equals(strM2716b)) {
                    this.f2976e.f2959m = i4;
                    return;
                }
                return;
            }
        }
        if ("activity".equals(str) || NotificationCompat.CATEGORY_SERVICE.equals(str) || "receiver".equals(str) || "provider".equals(str)) {
            if ("name".equals(strM2716b) && C1025c.m2752a(i3)) {
                this.f2976e.f2962p.add(Integer.valueOf(i4));
                if ("activity".equals(str)) {
                    this.f2976e.f2963q.put(Integer.valueOf(i4), 0);
                } else if (NotificationCompat.CATEGORY_SERVICE.equals(str)) {
                    this.f2976e.f2963q.put(Integer.valueOf(i4), 1);
                } else if ("receiver".equals(str)) {
                    this.f2976e.f2963q.put(Integer.valueOf(i4), 2);
                } else if ("provider".equals(str)) {
                    this.f2976e.f2963q.put(Integer.valueOf(i4), 3);
                }
            }
            if ("activity".equals(str) && "name".equals(strM2716b)) {
                this.f2977f = i4;
            }
            if ("provider".equals(str) && C1025c.m2752a(i3)) {
                if (this.f2978g == null) {
                    this.f2978g = new C1030h();
                }
                if ("authorities".equals(strM2716b)) {
                    this.f2978g.f2971c = i4;
                    this.f2978g.f2970b = this.f2974c.m2716b(i4);
                } else if ("name".equals(strM2716b)) {
                    this.f2978g.f2969a = this.f2974c.m2716b(i4);
                }
                if (this.f2978g.f2970b == null || this.f2978g.f2969a == null) {
                    return;
                }
                this.f2976e.f2965s.add(this.f2978g);
                this.f2978g = null;
                return;
            }
            return;
        }
        if ("activity-alias".equals(str)) {
            if ("name".equals(strM2716b)) {
                this.f2977f = i4;
                return;
            } else {
                if ("targetActivity".equals(strM2716b)) {
                    this.f2976e.f2967u.put(Integer.valueOf(this.f2977f), Integer.valueOf(i4));
                    return;
                }
                return;
            }
        }
        if ("category".equals(str)) {
            if ("name".equals(strM2716b) && "android.intent.category.LAUNCHER".equals(this.f2974c.m2716b(i4)) && this.f2977f != -1) {
                this.f2976e.f2966t.add(Integer.valueOf(this.f2977f));
                return;
            }
            return;
        }
        if ("permission".equals(str)) {
            if ("name".equals(strM2716b)) {
                this.f2976e.f2964r.put(Integer.valueOf(i4), this.f2974c.m2716b(i4));
            }
        } else if ("uses-sdk".equals(str)) {
            if ("minSdkVersion".equals(strM2716b)) {
                this.f2976e.f2953g = i4;
            } else if ("targetSdkVersion".equals(strM2716b)) {
                this.f2976e.f2954h = i4;
            } else if ("maxSdkVersion".equals(strM2716b)) {
                this.f2976e.f2955i = i4;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2760b() throws IOException {
        this.f2972a.m2687a();
        this.f2973b = this.f2972a.m2687a();
        this.f2974c = new C1018s();
        this.f2974c.m2714a(this.f2972a);
        new Object[1][0] = Integer.valueOf(this.f2974c.f2883a);
        new Object[1][0] = Integer.valueOf(this.f2974c.m2718c());
        for (int i = 0; i < this.f2974c.m2718c(); i++) {
            this.f2976e.f2961o.add(this.f2974c.m2716b(i));
        }
        this.f2975d = new C1017r();
        this.f2975d.m2704a(this.f2972a);
        while (new C1025c(this.f2974c).m2753a(this.f2972a, this) != C1025c.f2939a) {
        }
        this.f2973b += 20;
    }
}
