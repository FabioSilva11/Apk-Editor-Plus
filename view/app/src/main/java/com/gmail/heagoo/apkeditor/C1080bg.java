package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Context;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.p067f.C1207d;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.p054a.C0974b;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p007c.C0057a;
import p000a.p010c.InterfaceC0064d;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bg */
/* JADX INFO: loaded from: classes.dex */
public final class C1080bg extends Thread {

    /* JADX INFO: renamed from: a */
    private static boolean f3071a = false;

    /* JADX INFO: renamed from: b */
    private WeakReference f3072b;

    /* JADX INFO: renamed from: c */
    private WeakReference f3073c;

    /* JADX INFO: renamed from: d */
    private String f3074d;

    /* JADX INFO: renamed from: e */
    private String f3075e;

    /* JADX INFO: renamed from: f */
    private C0031e f3076f;

    /* JADX INFO: renamed from: g */
    private C0985a f3077g;

    /* JADX INFO: renamed from: h */
    private String f3078h;

    /* JADX INFO: renamed from: i */
    private ApkDecoderMine f3079i;

    /* JADX INFO: renamed from: j */
    private C1207d f3080j;

    /* JADX INFO: renamed from: k */
    private boolean f3081k;

    /* JADX INFO: renamed from: l */
    private boolean f3082l;

    public C1080bg(Activity activity, InterfaceC1079bf interfaceC1079bf, String str, String str2, boolean z) {
        this.f3072b = new WeakReference(activity);
        this.f3073c = new WeakReference(interfaceC1079bf);
        this.f3074d = str;
        this.f3075e = str2;
        this.f3082l = z;
    }

    /* JADX INFO: renamed from: a */
    private static void m2809a(Context context, String str, byte[] bArr) throws IOException {
        int i;
        InputStream inputStreamOpen = context.getAssets().open(str);
        int i2 = inputStreamOpen.read(bArr);
        while (i2 < bArr.length && (i = inputStreamOpen.read(bArr, i2, bArr.length - i2)) != -1) {
            i2 += i;
        }
        inputStreamOpen.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private p000a.p001a.p003b.p004a.C0031e[] m2810a(p000a.p001a.p003b.p007c.C0057a r9, com.gmail.heagoo.p054a.p059c.C0985a r10, boolean r11) throws java.lang.Throwable {
        /*
            r8 = this;
            r1 = 0
            java.util.zip.ZipFile r6 = new java.util.zip.ZipFile     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L69
            r6.<init>(r9)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L69
            java.lang.String r0 = "resources.arsc"
            java.util.zip.ZipEntry r0 = r6.getEntry(r0)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L73
            if (r0 == 0) goto L38
            long r2 = r0.getSize()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L73
            int r2 = (int) r2     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L73
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L73
            java.io.InputStream r0 = r6.getInputStream(r0)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L73
            com.gmail.heagoo.p054a.p059c.C0985a.m2216a(r0, r2)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L73
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L73
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L73
            r1 = 0
            com.gmail.heagoo.apkeditor.f.d r4 = r8.f3080j     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L76
            boolean r5 = r8.f3081k     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L76
            r2 = r11
            r3 = r10
            a.a.b.b.b r1 = p000a.p001a.p003b.p006b.C0043a.m101a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L76
            a.a.b.a.e[] r1 = r1.m113a()     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L76
            r6.close()     // Catch: java.io.IOException -> L5f
        L33:
            r0.close()     // Catch: java.io.IOException -> L61
        L36:
            r0 = r1
        L37:
            return r0
        L38:
            r6.close()     // Catch: java.io.IOException -> L63
        L3b:
            r0 = r1
            goto L37
        L3d:
            r0 = move-exception
            r2 = r1
        L3f:
            a.a.a r3 = new a.a.a     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            java.lang.String r5 = "Could not read resources.arsc from file: "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch: java.lang.Throwable -> L54
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L54
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L54
            throw r3     // Catch: java.lang.Throwable -> L54
        L54:
            r0 = move-exception
            r6 = r2
        L56:
            r6.close()     // Catch: java.io.IOException -> L65
        L59:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.io.IOException -> L67
        L5e:
            throw r0
        L5f:
            r2 = move-exception
            goto L33
        L61:
            r0 = move-exception
            goto L36
        L63:
            r0 = move-exception
            goto L3b
        L65:
            r2 = move-exception
            goto L59
        L67:
            r1 = move-exception
            goto L5e
        L69:
            r0 = move-exception
            r6 = r1
            goto L56
        L6c:
            r0 = move-exception
            goto L56
        L6e:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L56
        L73:
            r0 = move-exception
            r2 = r6
            goto L3f
        L76:
            r1 = move-exception
            r2 = r6
            r7 = r0
            r0 = r1
            r1 = r7
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.C1080bg.m2810a(a.a.b.c.a, com.gmail.heagoo.a.c.a, boolean):a.a.b.a.e[]");
    }

    /* JADX INFO: renamed from: c */
    private boolean m2811c() throws Throwable {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        try {
            Activity activity = (Activity) this.f3072b.get();
            if (this.f3082l) {
                bArr = null;
                bArr2 = null;
                bArr3 = null;
            } else {
                byte[] bArr4 = new byte[68];
                m2809a(activity, "carlos_png.png", bArr4);
                byte[] bArr5 = new byte[667];
                m2809a(activity, "carlos_jpg.jpg", bArr5);
                byte[] bArr6 = new byte[97];
                m2809a(activity, "carlos.9.png", bArr6);
                bArr3 = bArr4;
                bArr2 = bArr5;
                bArr = bArr6;
            }
            C0057a c0057a = new C0057a(new File(this.f3074d));
            InterfaceC0064d interfaceC0064dM158a = c0057a.m158a();
            this.f3081k = !interfaceC0064dM158a.mo168a("res");
            if (this.f3081k && (interfaceC0064dM158a.mo168a("r") || interfaceC0064dM158a.mo168a("R"))) {
                try {
                    InputStream inputStreamMo169b = interfaceC0064dM158a.mo169b(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
                    C0974b c0974b = new C0974b();
                    c0974b.m2157a(inputStreamMo169b, "manifest", "package");
                    String strM2156a = c0974b.m2156a();
                    inputStreamMo169b.close();
                    InputStream inputStreamMo169b2 = interfaceC0064dM158a.mo169b("classes.dex");
                    String strM2263d = C0985a.m2263d(activity, "tmp");
                    String str = strM2263d + "classes.dex";
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    C0985a.m2244b(inputStreamMo169b2, fileOutputStream);
                    inputStreamMo169b2.close();
                    fileOutputStream.close();
                    C0985a.m2190a("com.gmail.heagoo.apkeditor.pro.ResourceDecoder", "decodeResources", new Class[]{String.class, String.class}, new Object[]{str, strM2263d});
                    this.f3080j = new C1207d(strM2263d, strM2156a);
                } catch (Exception e) {
                }
            }
            C0985a c0985a = new C0985a(((Activity) this.f3072b.get()).getApplicationContext(), this.f3081k);
            C0031e[] c0031eArrM2810a = m2810a(c0057a, c0985a, false);
            if (c0031eArrM2810a != null) {
                switch (c0031eArrM2810a.length) {
                    case 1:
                        this.f3076f = c0031eArrM2810a[0];
                        break;
                    case 2:
                        if (c0031eArrM2810a[0].m56f().equals("android") || c0031eArrM2810a[0].m56f().equals("com.htc")) {
                            this.f3076f = c0031eArrM2810a[1];
                            break;
                        }
                    default:
                        this.f3076f = selectPkgWithMostResSpecs(c0031eArrM2810a);
                        break;
                }
                if (this.f3076f == null) {
                    throw new C0000a("Arsc files with zero packages");
                }
                c0985a.m2305a(this.f3076f, true);
                C0031e c0031e = this.f3076f;
            }
            this.f3077g = c0985a;
            if (this.f3073c.get() != null) {
                ((InterfaceC1079bf) this.f3073c.get()).mo2449c(true);
            }
            this.f3079i = new ApkDecoderMine(this.f3077g, bArr3, bArr2, bArr);
            C1476h.m3508a(new File(this.f3075e));
            C1322m.m3196a((Context) this.f3072b.get());
            File file = new File(this.f3075e);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f3079i.m2372a(c0057a, file);
            if (this.f3073c.get() != null) {
                ((InterfaceC1079bf) this.f3073c.get()).mo2438a(this.f3079i.m2371a());
            }
            return true;
        } catch (Exception e2) {
            this.f3078h = e2.getMessage();
            e2.printStackTrace();
            return false;
        }
    }

    private C0031e selectPkgWithMostResSpecs(C0031e[] c0031eArr) {
        int iM55e = 0;
        int size = 0;
        int i = 0;
        for (int i2 = 0; i2 < c0031eArr.length; i2++) {
            C0031e c0031e = c0031eArr[i2];
            if (c0031e.getSize() > size) {
                size = c0031e.getSize();
                iM55e = c0031e.m55e();
                i = i2;
            }
        }
        return iM55e == 0 ? c0031eArr[0] : c0031eArr[i];
    }

    /* JADX INFO: renamed from: a */
    public final C0031e m2812a() {
        return this.f3076f;
    }

    /* JADX INFO: renamed from: b */
    public final void m2813b() {
        if (this.f3079i != null) {
            this.f3079i.m2373b();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        C1322m c1322m = new C1322m((Context) this.f3072b.get(), null, null, null);
        if (!c1322m.m3206a()) {
            ((InterfaceC1079bf) this.f3073c.get()).mo2453e(c1322m.m3207c());
        } else {
            if (m2811c() || this.f3073c.get() == null) {
                return;
            }
            ((InterfaceC1079bf) this.f3073c.get()).mo2453e(this.f3078h);
        }
    }
}
