package com.gmail.heagoo.apkeditor;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.io.File;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bk */
/* JADX INFO: loaded from: classes.dex */
public final class C1084bk {

    /* JADX INFO: renamed from: a */
    public ApplicationInfo f3088a;

    /* JADX INFO: renamed from: b */
    public String f3089b;

    /* JADX INFO: renamed from: c */
    public String f3090c;

    /* JADX INFO: renamed from: d */
    public long f3091d;

    /* JADX INFO: renamed from: a */
    public static C1084bk m2815a(PackageManager packageManager, ApplicationInfo applicationInfo) {
        C1084bk c1084bk = new C1084bk();
        c1084bk.f3088a = applicationInfo;
        c1084bk.f3090c = (String) applicationInfo.loadLabel(packageManager);
        c1084bk.f3089b = applicationInfo.packageName;
        try {
            c1084bk.f3091d = packageManager.getPackageInfo(applicationInfo.packageName, 0).lastUpdateTime;
            new File(applicationInfo.sourceDir).length();
        } catch (Throwable th) {
            c1084bk.f3091d = 0L;
        }
        return c1084bk;
    }
}
