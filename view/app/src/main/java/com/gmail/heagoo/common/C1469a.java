package com.gmail.heagoo.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.InputFilter;

/* JADX INFO: renamed from: com.gmail.heagoo.common.a */
/* JADX INFO: loaded from: classes.dex */
public class C1469a {
    /* JADX INFO: renamed from: a */
    public static InputFilter m3487a() {
        return new C1482n();
    }

    /* JADX INFO: renamed from: a */
    public static C1470b m3488a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null) {
            return null;
        }
        C1470b c1470b = new C1470b();
        packageArchiveInfo.applicationInfo.sourceDir = str;
        packageArchiveInfo.applicationInfo.publicSourceDir = str;
        c1470b.f4290a = packageArchiveInfo.applicationInfo.loadLabel(packageManager).toString();
        c1470b.f4291b = packageArchiveInfo.packageName;
        c1470b.f4292c = packageArchiveInfo.applicationInfo.loadIcon(packageManager);
        return c1470b;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:89|11|12|(4:100|13|(2:15|(4:105|21|(3:107|23|(3:111|25|132)(3:108|35|(3:117|37|(1:130)(3:115|47|(4:116|49|50|125)(1:131)))(3:109|51|(3:118|53|(4:119|55|50|125)(1:124))(1:123))))(1:122)|120)(2:121|120))(1:106)|32)|64|(1:67)|94|68|32) */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List m3489b() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.common.C1469a.m3489b():java.util.List");
    }
}
