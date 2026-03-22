package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.pro.R;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.q */
/* JADX INFO: loaded from: classes.dex */
final class C1169q extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private C1152ac f3297b;

    /* JADX INFO: renamed from: i */
    private boolean f3304i;

    /* JADX INFO: renamed from: e */
    private String f3300e = null;

    /* JADX INFO: renamed from: f */
    private boolean f3301f = false;

    /* JADX INFO: renamed from: g */
    private boolean f3302g = false;

    /* JADX INFO: renamed from: c */
    private List f3298c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private List f3299d = new ArrayList();

    /* JADX INFO: renamed from: h */
    private List f3303h = new ArrayList();

    C1169q() {
        this.f3303h.add("[/MATCH_REPLACE]");
        this.f3303h.add("TARGET:");
        this.f3303h.add("MATCH:");
        this.f3303h.add("REGEX:");
        this.f3303h.add("REPLACE:");
        this.f3303h.add("DOTALL:");
    }

    /* JADX INFO: renamed from: a */
    private static String m2938a(String str, C1170r c1170r) {
        List list = c1170r.f3307c;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return str;
            }
            str = str.replace("${GROUP" + (i2 + 1) + "}", (CharSequence) list.get(i2));
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2939a(BufferedOutputStream bufferedOutputStream, List list, int i, int i2) {
        while (i < i2) {
            bufferedOutputStream.write(((String) list.get(i)).getBytes());
            bufferedOutputStream.write("\n".getBytes());
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2940a(String str, String str2, List list) throws Throwable {
        FileOutputStream fileOutputStream;
        String strM2943c = m2943c();
        try {
            fileOutputStream = new FileOutputStream(str);
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                try {
                    C1170r c1170r = (C1170r) list.get(i2);
                    fileOutputStream.write(str2.substring(i, c1170r.f3305a).getBytes());
                    i = c1170r.f3306b;
                    fileOutputStream.write(((c1170r.f3307c == null || c1170r.f3307c.isEmpty()) ? strM2943c : m2938a(strM2943c, c1170r)).getBytes());
                } catch (Throwable th) {
                    th = th;
                    m2919a(fileOutputStream);
                    throw th;
                }
            }
            fileOutputStream.write(str2.substring(i).getBytes());
            m2919a(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2941a(String str, List list, List list2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        String strM2943c = m2943c();
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            int size = 0;
            for (int i = 0; i < list2.size(); i++) {
                try {
                    int iIntValue = ((Integer) list2.get(i)).intValue();
                    m2939a(bufferedOutputStream, list, size, iIntValue);
                    bufferedOutputStream.write(strM2943c.getBytes());
                    bufferedOutputStream.write("\n".getBytes());
                    size = this.f3298c.size() + iIntValue;
                } catch (Throwable th) {
                    th = th;
                    m2919a(bufferedOutputStream);
                    throw th;
                }
            }
            m2939a(bufferedOutputStream, list, size, list.size());
            m2919a(bufferedOutputStream);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2942a(List list, int i) {
        int i2 = 0;
        while (i2 < this.f3298c.size() && ((String) list.get(i + i2)).trim().equals((String) this.f3298c.get(i2))) {
            i2++;
        }
        return i2 == this.f3298c.size();
    }

    /* JADX INFO: renamed from: c */
    private String m2943c() {
        if (this.f3300e == null) {
            if (this.f3299d.isEmpty()) {
                this.f3300e = "";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append((String) this.f3299d.get(0));
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f3299d.size()) {
                        break;
                    }
                    sb.append("\n");
                    sb.append((String) this.f3299d.get(i2));
                    i = i2 + 1;
                }
                this.f3300e = sb.toString();
            }
        }
        return this.f3300e;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a5 A[SYNTHETIC] */
    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String mo2924a(com.gmail.heagoo.apkeditor.ApkInfoActivity r12, java.util.zip.ZipFile r13, com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.p066e.C1169q.mo2924a(com.gmail.heagoo.apkeditor.ApkInfoActivity, java.util.zip.ZipFile, com.gmail.heagoo.apkeditor.e.b):java.lang.String");
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b) {
        this.f3267a = c1155c.m2908a();
        String line = c1155c.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if ("[/MATCH_REPLACE]".equals(strTrim)) {
                break;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("TARGET:".equals(strTrim)) {
                    this.f3297b = new C1152ac(interfaceC1154b, c1155c.readLine().trim(), c1155c.m2908a());
                } else if ("REGEX:".equals(strTrim)) {
                    this.f3301f = Boolean.valueOf(c1155c.readLine().trim()).booleanValue();
                } else if ("DOTALL:".equals(strTrim)) {
                    this.f3302g = Boolean.valueOf(c1155c.readLine().trim()).booleanValue();
                } else if ("MATCH:".equals(strTrim)) {
                    line = m2917a((BufferedReader) c1155c, this.f3298c, true, this.f3303h);
                } else if ("REPLACE:".equals(strTrim)) {
                    line = m2917a((BufferedReader) c1155c, this.f3299d, false, this.f3303h);
                } else {
                    interfaceC1154b.mo2900a(R.string.patch_error_cannot_parse, Integer.valueOf(c1155c.m2908a()), strTrim);
                }
                line = c1155c.readLine();
            }
        }
        if (this.f3297b != null) {
            this.f3304i = this.f3297b.m2893d();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2928a() {
        return this.f3297b.m2890a();
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        if (this.f3297b == null || !this.f3297b.m2892c()) {
            return false;
        }
        if (!this.f3298c.isEmpty()) {
            return true;
        }
        interfaceC1154b.mo2900a(R.string.patch_error_no_match_content, new Object[0]);
        return false;
    }
}
