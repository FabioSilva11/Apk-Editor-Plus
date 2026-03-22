package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.apkeditor.p065d.InterfaceC1128a;
import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.he */
/* JADX INFO: loaded from: classes.dex */
final class C1265he implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private boolean f3612a = false;

    /* JADX INFO: renamed from: b */
    private String f3613b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f3614c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ String f3615d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ String f3616e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ AbstractActivityC1258gy f3617f;

    C1265he(AbstractActivityC1258gy abstractActivityC1258gy, String str, String str2, String str3) {
        this.f3617f = abstractActivityC1258gy;
        this.f3614c = str;
        this.f3615d = str2;
        this.f3616e = str3;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        InterfaceC1128a interfaceC1128a = (InterfaceC1128a) C0985a.m2191a("com.gmail.heagoo.apkeditor.pro.JavaExtractor", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{this.f3617f.f3586m, this.f3614c, this.f3615d, this.f3616e});
        if (interfaceC1128a != null) {
            this.f3612a = interfaceC1128a.extract();
            if (this.f3612a) {
                return;
            }
            this.f3613b = interfaceC1128a.getErrorMessage();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b1 A[PHI: r1 r2
  0x00b1: PHI (r1v7 boolean) = (r1v6 boolean), (r1v24 boolean) binds: [B:5:0x002d, B:9:0x005f] A[DONT_GENERATE, DONT_INLINE]
  0x00b1: PHI (r2v3 java.lang.String) = (r2v2 java.lang.String), (r2v11 java.lang.String) binds: [B:5:0x002d, B:9:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo2531b() {
        /*
            r4 = this;
            r3 = 1
            boolean r0 = r4.f3612a
            if (r0 == 0) goto La5
            java.lang.String r0 = r4.f3615d
            java.lang.String r0 = r0.substring(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r4.f3616e
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = ".java"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r1.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            boolean r1 = r1.exists()
            if (r1 != 0) goto Lb1
            r1 = 36
            int r1 = r0.lastIndexOf(r1)
            r2 = -1
            if (r1 == r2) goto L61
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r4.f3616e
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = ".java"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r1.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            boolean r1 = r1.exists()
            if (r1 != 0) goto Lb1
        L61:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r4.f3616e
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "defpackage/"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = ".java"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            boolean r0 = r0.exists()
        L89:
            if (r0 != 0) goto L98
            com.gmail.heagoo.apkeditor.gy r0 = r4.f3617f
            r1 = 2131165684(0x7f0701f4, float:1.7945592E38)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r3)
            r0.show()
        L97:
            return
        L98:
            com.gmail.heagoo.apkeditor.gy r0 = r4.f3617f
            r2 = 0
            android.content.Intent r0 = com.gmail.heagoo.p054a.p059c.C0985a.m2177a(r0, r1, r2)
            com.gmail.heagoo.apkeditor.gy r1 = r4.f3617f
            r1.startActivity(r0)
            goto L97
        La5:
            com.gmail.heagoo.apkeditor.gy r0 = r4.f3617f
            java.lang.String r1 = r4.f3613b
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r3)
            r0.show()
            goto L97
        Lb1:
            r0 = r1
            r1 = r2
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.C1265he.mo2531b():void");
    }
}
