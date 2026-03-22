package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.v */
/* JADX INFO: loaded from: classes.dex */
final class C1403v extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Map f4078a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkInfoActivity f4079b;

    C1403v(ApkInfoActivity apkInfoActivity, Map map) {
        this.f4079b = apkInfoActivity;
        this.f4078a = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            String strM2263d = C0985a.m2263d(this.f4079b, "tmp");
            C0985a.m2225a(strM2263d + "allStringValues", this.f4079b.f2616d);
            C0985a.m2225a(strM2263d + "fileEntry2ZipEntry", this.f4078a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
