package com.gmail.heagoo.apkeditor;

import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import common.types.ActivityState_V1;
import common.types.ProjectInfo_V1;
import java.io.File;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ap */
/* JADX INFO: loaded from: classes.dex */
final class C1052ap implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private ActivityState_V1 f3009a;

    /* JADX INFO: renamed from: b */
    private File f3010b;

    /* JADX INFO: renamed from: c */
    private File f3011c;

    /* JADX INFO: renamed from: d */
    private String f3012d = null;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ ApkInfoActivity f3013e;

    C1052ap(ApkInfoActivity apkInfoActivity) {
        this.f3013e = apkInfoActivity;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        String str = this.f3013e.f2615c != null ? this.f3013e.f2615c.f4290a : "UNKNOWN";
        try {
            String str2 = C0985a.m2263d(this.f3013e, ".projects") + str;
            this.f3011c = new File(str2);
            if (this.f3011c.exists()) {
                this.f3011c = DialogC1108ce.m2835a(str2, true);
            }
            if (!this.f3011c.mkdirs()) {
                this.f3012d = this.f3013e.getString(R.string.cannot_save_project);
                return;
            }
            String str3 = this.f3013e.f2614b;
            String str4 = str3 != null ? str3.substring(0, str3.lastIndexOf(47) + 1) + str : null;
            this.f3010b = new File(str4);
            if (this.f3010b.exists()) {
                this.f3010b = DialogC1108ce.m2835a(str4, true);
            }
            if (!new File(this.f3013e.f2614b).renameTo(this.f3010b)) {
                this.f3012d = this.f3013e.getString(R.string.cannot_rename_decode_folder);
                return;
            }
            this.f3013e.f2617e.m3060f(this.f3013e.f2614b + "/", this.f3010b.getPath() + "/");
            this.f3009a = this.f3013e.m2377a(this.f3011c.getPath() + "/", true, this.f3011c);
            if (this.f3009a == null) {
                this.f3012d = "Cannot save project state.";
            }
        } catch (Exception e) {
            this.f3012d = String.format(this.f3013e.getString(R.string.general_error), e.getMessage());
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f3012d != null) {
            Toast.makeText(this.f3013e, this.f3012d, 1).show();
            return;
        }
        ProjectInfo_V1 projectInfo_V1 = new ProjectInfo_V1();
        projectInfo_V1.state = this.f3009a;
        projectInfo_V1.apkPath = this.f3013e.f2582a;
        projectInfo_V1.decodeRootPath = this.f3010b.getPath();
        ApkInfoActivity apkInfoActivity = this.f3013e;
        if (ApkInfoActivity.m2393a(this.f3011c.getPath(), projectInfo_V1)) {
            this.f3013e.finish();
        } else {
            Toast.makeText(this.f3013e, R.string.cannot_save_project, 1).show();
        }
    }
}
