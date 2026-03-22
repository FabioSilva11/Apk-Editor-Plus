package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.v */
/* JADX INFO: loaded from: classes.dex */
final class C1174v extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private List f3313b = new ArrayList();

    C1174v() {
    }

    /* JADX INFO: renamed from: d */
    private String m2956d(String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ZipFile zipFile;
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (!zipEntryNextElement.isDirectory()) {
                        String name = zipEntryNextElement.getName();
                        if (name.endsWith(".RSA") || name.endsWith(".rsa") || name.endsWith(".DSA") || name.endsWith(".dsa")) {
                            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntryNextElement));
                            try {
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                            } catch (IOException e) {
                                e = e;
                                bufferedInputStream2 = bufferedInputStream;
                                byteArrayOutputStream = null;
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                C0985a.m2244b(bufferedInputStream, byteArrayOutputStream2);
                                break;
                            } catch (IOException e2) {
                                bufferedInputStream2 = bufferedInputStream;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                e = e2;
                                try {
                                    e.printStackTrace();
                                    m2919a(bufferedInputStream2);
                                    m2919a(byteArrayOutputStream);
                                    m2920a(zipFile);
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream3 = byteArrayOutputStream;
                                    bufferedInputStream = bufferedInputStream2;
                                    m2919a(bufferedInputStream);
                                    m2919a(byteArrayOutputStream3);
                                    m2920a(zipFile);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                byteArrayOutputStream3 = byteArrayOutputStream2;
                                th = th3;
                                m2919a(bufferedInputStream);
                                m2919a(byteArrayOutputStream3);
                                m2920a(zipFile);
                                throw th;
                            }
                        }
                    }
                }
                byteArrayOutputStream2 = null;
                bufferedInputStream = null;
                m2919a(bufferedInputStream);
                m2919a(byteArrayOutputStream2);
                m2920a(zipFile);
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
                bufferedInputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            bufferedInputStream2 = null;
            zipFile = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            zipFile = null;
        }
        if (byteArrayOutputStream2 != null) {
            return C0985a.m2255c(byteArrayOutputStream2.toByteArray());
        }
        return null;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) throws Throwable {
        String strM2956d = m2956d(apkInfoActivity.m2464l());
        String str = apkInfoActivity.m2465m().f4291b;
        String str2 = interfaceC1154b.mo2903b() + "/" + ((String) this.f3313b.get(0));
        try {
            C0985a.m2245b(str2, m2925a(str2).replace("%PACKAGE_NAME%", str).replace("%RSA_DATA%", strM2956d));
            return null;
        } catch (Exception e) {
            interfaceC1154b.mo2900a(R.string.patch_error_write_to, str2);
            return null;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b) {
        this.f3267a = c1155c.m2908a();
        String line = c1155c.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if ("[/SIGNATURE_REVISE]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("TARGET:".equals(strTrim)) {
                    this.f3313b.add(c1155c.readLine().trim());
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
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        return !this.f3313b.isEmpty();
    }
}
