package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.List;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.m */
/* JADX INFO: loaded from: classes.dex */
final class C1165m extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private String f3284b;

    C1165m() {
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) {
        return this.f3284b;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b) {
        this.f3267a = c1155c.m2908a();
        String line = c1155c.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if ("[/GOTO]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("GOTO:".equals(strTrim)) {
                    this.f3284b = c1155c.readLine().trim();
                } else {
                    interfaceC1154b.mo2900a(R.string.patch_error_cannot_parse, Integer.valueOf(c1155c.m2908a()), strTrim);
                }
                line = c1155c.readLine();
            }
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2928a() {
        return false;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        if (this.f3284b == null) {
            interfaceC1154b.mo2900a(R.string.patch_error_no_goto_target, new Object[0]);
            return false;
        }
        List listMo2907f = interfaceC1154b.mo2907f();
        if (listMo2907f != null && listMo2907f.contains(this.f3284b)) {
            return true;
        }
        interfaceC1154b.mo2900a(R.string.patch_error_goto_target_notfound, this.f3284b);
        return false;
    }
}
