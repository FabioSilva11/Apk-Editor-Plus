package com.gmail.heagoo.apkeditor;

import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.iv */
/* JADX INFO: loaded from: classes.dex */
final class C1309iv implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private String f3702a;

    /* JADX INFO: renamed from: b */
    private boolean f3703b = false;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f3704c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ String f3705d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ UserAppActivity f3706e;

    C1309iv(UserAppActivity userAppActivity, String str, String str2) {
        this.f3706e = userAppActivity;
        this.f3704c = str;
        this.f3705d = str2;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        this.f3702a = C0985a.m2263d(this.f3706e, "backup") + this.f3704c + ".apk";
        try {
            FileInputStream fileInputStream2 = new FileInputStream(this.f3705d);
            try {
                fileOutputStream = new FileOutputStream(this.f3702a);
                try {
                    C0985a.m2244b(fileInputStream2, fileOutputStream);
                    this.f3703b = true;
                    C0985a.m2212a((Closeable) fileInputStream2);
                    C0985a.m2212a(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    C0985a.m2212a((Closeable) fileInputStream);
                    C0985a.m2212a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f3703b) {
            Toast.makeText(this.f3706e, String.format(this.f3706e.getString(R.string.apk_saved_tip), this.f3702a), 1).show();
        }
    }
}
