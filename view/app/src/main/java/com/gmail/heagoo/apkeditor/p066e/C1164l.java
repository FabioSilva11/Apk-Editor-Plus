package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.l */
/* JADX INFO: loaded from: classes.dex */
final class C1164l extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private List f3282b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private List f3283c = new ArrayList();

    C1164l() {
        this.f3283c.add("[/FUNCTION_REPLACE]");
        this.f3283c.add("TARGET:");
        this.f3283c.add("FUNCTION:");
        this.f3283c.add("REPLACE:");
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) {
        interfaceC1154b.mo2900a(R.string.general_error, "Not supported yet.");
        return null;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b) {
        this.f3267a = c1155c.m2908a();
        String line = c1155c.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if ("[/FUNCTION_REPLACE]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("TARGET:".equals(strTrim)) {
                    c1155c.readLine().trim();
                } else if ("FUNCTION:".equals(strTrim)) {
                    c1155c.readLine().trim();
                } else if ("REPLACE:".equals(strTrim)) {
                    line = m2917a((BufferedReader) c1155c, this.f3282b, false, this.f3283c);
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
        return false;
    }
}
