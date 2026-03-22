package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.C1213ff;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.u */
/* JADX INFO: loaded from: classes.dex */
final class C1173u extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private List f3312b = new ArrayList();

    C1173u() {
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) {
        String strM2460i = apkInfoActivity.m2460i();
        C1213ff c1213ffM2462j = apkInfoActivity.m2462j();
        for (int i = 0; i < this.f3312b.size(); i++) {
            String str = strM2460i + "/" + ((String) this.f3312b.get(i));
            int iLastIndexOf = str.lastIndexOf(47);
            String strSubstring = str.substring(0, iLastIndexOf);
            String strSubstring2 = str.substring(iLastIndexOf + 1);
            if (new File(str).exists()) {
                c1213ffM2462j.m3049b(strSubstring, strSubstring2, false);
            } else {
                c1213ffM2462j.m3049b(strSubstring, strSubstring2, true);
            }
        }
        return null;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b) {
        this.f3267a = c1155c.m2908a();
        String line = c1155c.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if ("[/REMOVE_FILES]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else if ("TARGET:".equals(strTrim)) {
                while (true) {
                    line = c1155c.readLine();
                    if (line != null) {
                        line = line.trim();
                        if (!line.startsWith("[")) {
                            if (!"".equals(line)) {
                                this.f3312b.add(line);
                            }
                        }
                    }
                }
            } else {
                interfaceC1154b.mo2900a(R.string.patch_error_cannot_parse, Integer.valueOf(c1155c.m2908a()), strTrim);
                line = c1155c.readLine();
            }
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2928a() {
        Iterator it = this.f3312b.iterator();
        while (it.hasNext()) {
            if (AbstractC1159g.m2922c((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        if (!this.f3312b.isEmpty()) {
            return true;
        }
        interfaceC1154b.mo2900a(R.string.patch_error_no_target_file, new Object[0]);
        return false;
    }
}
