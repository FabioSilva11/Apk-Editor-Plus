package com.gmail.heagoo.apkeditor;

import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.t */
/* JADX INFO: loaded from: classes.dex */
final class C1371t implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private String f3947a = null;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f3948b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f3949c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ ApkInfoActivity f3950d;

    C1371t(ApkInfoActivity apkInfoActivity, String str, String str2) {
        this.f3950d = apkInfoActivity;
        this.f3948b = str;
        this.f3949c = str2;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() throws Throwable {
        File file = new File(this.f3948b);
        String name = file.getName();
        File file2 = new File(new File(this.f3949c), name);
        if (file2.exists()) {
            this.f3947a = String.format(this.f3950d.getString(R.string.file_already_exist), name);
        } else {
            file2.mkdir();
            C0985a.m2214a(file2, file);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f3947a != null) {
            Toast.makeText(this.f3950d, this.f3947a, 1).show();
        } else {
            this.f3950d.f2617e.m3039a();
        }
    }
}
