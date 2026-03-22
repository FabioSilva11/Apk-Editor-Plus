package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.k */
/* JADX INFO: loaded from: classes.dex */
final class C1163k extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private String f3275b;

    /* JADX INFO: renamed from: c */
    private String f3276c;

    /* JADX INFO: renamed from: d */
    private String f3277d;

    /* JADX INFO: renamed from: e */
    private String f3278e;

    /* JADX INFO: renamed from: f */
    private boolean f3279f = false;

    /* JADX INFO: renamed from: g */
    private int f3280g = 1;

    /* JADX INFO: renamed from: h */
    private List f3281h = new ArrayList();

    C1163k() {
        this.f3281h.add("[/EXECUTE_DEX]");
        this.f3281h.add("SCRIPT:");
        this.f3281h.add("INTERFACE_VERSION:");
        this.f3281h.add("SMALI_NEEDED:");
        this.f3281h.add("MAIN_CLASS:");
        this.f3281h.add("ENTRANCE:");
        this.f3281h.add("PARAM:");
    }

    /* JADX INFO: renamed from: a */
    private static String m2933a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        String str;
        Throwable targetException;
        BufferedOutputStream bufferedOutputStream2 = null;
        if (this.f3280g != 1) {
            interfaceC1154b.mo2900a(R.string.general_error, "Unsupported interface version: " + this.f3280g);
        } else {
            File dir = apkInfoActivity.getDir("outdex", 0);
            ZipEntry entry = zipFile.getEntry(this.f3275b);
            if (entry == null) {
                interfaceC1154b.mo2900a(R.string.general_error, "Cannot find '" + this.f3275b + "' inside the patch.");
            } else {
                try {
                    str = C0985a.m2263d(apkInfoActivity, "tmp") + "script.dex";
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                    try {
                        bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    } catch (Exception e) {
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        bufferedInputStream = null;
                        bufferedOutputStream2 = bufferedOutputStream;
                        th = th;
                        m2919a(bufferedInputStream);
                        m2919a(bufferedOutputStream2);
                        throw th;
                    }
                } catch (Exception e2) {
                    bufferedOutputStream = null;
                    bufferedInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
                try {
                    try {
                        C0985a.m2244b(bufferedInputStream, bufferedOutputStream);
                        m2919a(bufferedInputStream);
                        m2919a(bufferedOutputStream);
                        try {
                            Class clsLoadClass = new DexClassLoader(str, dir.getAbsolutePath(), null, apkInfoActivity.getClassLoader()).loadClass(this.f3276c);
                            clsLoadClass.getMethod(this.f3277d, String.class, String.class, String.class, String.class).invoke(clsLoadClass.newInstance(), apkInfoActivity.m2464l(), zipFile.getName(), apkInfoActivity.m2460i(), this.f3278e);
                        } catch (Throwable th3) {
                            if (!(th3 instanceof InvocationTargetException) || (targetException = ((InvocationTargetException) th3).getTargetException()) == null) {
                                interfaceC1154b.mo2900a(R.string.general_error, m2933a(th3));
                            } else {
                                interfaceC1154b.mo2900a(R.string.general_error, m2933a(targetException));
                            }
                        }
                    } catch (Throwable th4) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        th = th4;
                        m2919a(bufferedInputStream);
                        m2919a(bufferedOutputStream2);
                        throw th;
                    }
                } catch (Exception e3) {
                    interfaceC1154b.mo2900a(R.string.general_error, "Cannot extract '" + this.f3275b + "' to SD card.");
                    m2919a(bufferedInputStream);
                    m2919a(bufferedOutputStream);
                }
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
            if ("[/EXECUTE_DEX]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("SCRIPT:".equals(strTrim)) {
                    this.f3275b = c1155c.readLine().trim();
                } else if ("MAIN_CLASS:".equals(strTrim)) {
                    this.f3276c = c1155c.readLine().trim();
                } else if ("ENTRANCE:".equals(strTrim)) {
                    this.f3277d = c1155c.readLine().trim();
                } else if ("PARAM:".equals(strTrim)) {
                    ArrayList arrayList = new ArrayList();
                    String strA = m2917a((BufferedReader) c1155c, (List) arrayList, true, this.f3281h);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append((String) arrayList.get(i));
                        if (i != arrayList.size() - 1) {
                            sb.append('\n');
                        }
                    }
                    this.f3278e = sb.toString();
                    line = strA;
                } else if ("SMALI_NEEDED:".equals(strTrim)) {
                    this.f3279f = Boolean.valueOf(c1155c.readLine().trim()).booleanValue();
                } else if ("INTERFACE_VERSION:".equals(strTrim)) {
                    this.f3280g = Integer.valueOf(c1155c.readLine().trim()).intValue();
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
        return this.f3279f;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        if (this.f3275b == null) {
            interfaceC1154b.mo2900a(R.string.patch_error_no_script_name, new Object[0]);
            return false;
        }
        if (this.f3276c == null) {
            interfaceC1154b.mo2900a(R.string.patch_error_no_main_class, new Object[0]);
            return false;
        }
        if (this.f3277d != null) {
            return true;
        }
        interfaceC1154b.mo2900a(R.string.patch_error_no_entrance_func, new Object[0]);
        return false;
    }
}
