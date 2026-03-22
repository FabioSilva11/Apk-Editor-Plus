package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p000a.p001a.p003b.p004a.C0003a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.i */
/* JADX INFO: loaded from: classes.dex */
final class C1161i extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private String f3272b;

    /* JADX INFO: renamed from: c */
    private String f3273c;

    /* JADX INFO: renamed from: d */
    private boolean f3274d;

    C1161i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) throws Throwable {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        C0003a c0003a = 0;
        c0003a = 0;
        ZipEntry entry = zipFile.getEntry(this.f3272b);
        try {
            if (entry == null) {
                interfaceC1154b.mo2900a(R.string.patch_error_no_entry, this.f3272b);
            } else {
                try {
                    inputStream = zipFile.getInputStream(entry);
                    try {
                        if (this.f3274d) {
                            String str = C0985a.m2263d(apkInfoActivity, "tmp") + C1487s.m3525a(6);
                            fileOutputStream = new FileOutputStream(str);
                            try {
                                C0985a.m2244b(inputStream, fileOutputStream);
                                fileOutputStream.close();
                                m2926a(apkInfoActivity, str, (InterfaceC1149a) null, interfaceC1154b);
                            } catch (Exception e) {
                                e = e;
                                interfaceC1154b.mo2900a(R.string.general_error, e.getMessage());
                                m2919a(inputStream);
                                m2919a(fileOutputStream);
                            }
                        } else {
                            apkInfoActivity.m2462j().m3037a(apkInfoActivity.m2460i() + "/" + this.f3273c, inputStream);
                        }
                        m2919a(inputStream);
                        m2919a((Closeable) null);
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        m2919a(inputStream);
                        m2919a(c0003a);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            c0003a = 1;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b) {
        this.f3267a = c1155c.m2908a();
        String line = c1155c.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if ("[/ADD_FILES]".equals(strTrim)) {
                break;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("SOURCE:".equals(strTrim)) {
                    this.f3272b = c1155c.readLine().trim();
                } else if ("TARGET:".equals(strTrim)) {
                    this.f3273c = c1155c.readLine().trim();
                } else if ("EXTRACT:".equals(strTrim)) {
                    this.f3274d = Boolean.valueOf(c1155c.readLine().trim()).booleanValue();
                } else {
                    interfaceC1154b.mo2900a(R.string.patch_error_cannot_parse, Integer.valueOf(c1155c.m2908a()), strTrim);
                }
                line = c1155c.readLine();
            }
        }
        if (this.f3273c == null || !this.f3273c.endsWith("/")) {
            return;
        }
        this.f3273c = this.f3273c.substring(0, this.f3273c.length() - 1);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2928a() {
        return AbstractC1159g.m2922c(this.f3273c);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        if (this.f3272b == null) {
            interfaceC1154b.mo2900a(R.string.patch_error_no_source_file, new Object[0]);
            return false;
        }
        if (this.f3273c != null) {
            return true;
        }
        interfaceC1154b.mo2900a(R.string.patch_error_no_target_file, new Object[0]);
        return false;
    }
}
