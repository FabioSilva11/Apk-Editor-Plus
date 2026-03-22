package com.gmail.heagoo.appdm.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.util.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1443i {

    /* JADX INFO: renamed from: a */
    private static String f4247a = null;

    @SuppressLint({"DefaultLocale"})
    /* JADX INFO: renamed from: a */
    public static String m3462a(long j) {
        return j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED ? String.format("%.2f M", Float.valueOf(((j * 1.0f) / 1024.0f) / 1024.0f)) : j >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID ? String.format("%.2f K", Float.valueOf((j * 1.0f) / 1024.0f)) : j + " B";
    }

    /* JADX INFO: renamed from: a */
    public static String m3463a(Context context) {
        m3466c(context);
        String str = Environment.getExternalStorageDirectory().getPath() + "/" + f4247a + "/backups";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3464a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* JADX INFO: renamed from: b */
    public static String m3465b(Context context) {
        m3466c(context);
        String str = Environment.getExternalStorageDirectory().getPath() + "/" + f4247a + "/temp";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    /* JADX INFO: renamed from: c */
    private static void m3466c(Context context) {
        if (f4247a != null) {
            return;
        }
        try {
            f4247a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("heagoo.sdcard_folder");
        } catch (PackageManager.NameNotFoundException e) {
        }
    }
}
