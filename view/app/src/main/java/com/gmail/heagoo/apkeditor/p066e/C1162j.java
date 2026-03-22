package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.j */
/* JADX INFO: loaded from: classes.dex */
final class C1162j extends AbstractC1159g {
    C1162j() {
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) {
        return null;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b) {
        this.f3267a = c1155c.m2908a();
        String line = c1155c.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if ("[/CARLOS]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                interfaceC1154b.mo2900a(R.string.patch_error_cannot_parse, Integer.valueOf(c1155c.m2908a()), strTrim);
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
        return true;
    }
}
