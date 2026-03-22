package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.o */
/* JADX INFO: loaded from: classes.dex */
final class C1167o extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private C1152ac f3291b;

    /* JADX INFO: renamed from: d */
    private String f3293d;

    /* JADX INFO: renamed from: e */
    private boolean f3294e = false;

    /* JADX INFO: renamed from: f */
    private boolean f3295f = false;

    /* JADX INFO: renamed from: c */
    private List f3292c = new ArrayList();

    /* JADX INFO: renamed from: g */
    private List f3296g = new ArrayList();

    C1167o() {
        this.f3296g.add("[/MATCH_GOTO]");
        this.f3296g.add("TARGET:");
        this.f3296g.add("MATCH:");
        this.f3296g.add("REGEX:");
        this.f3296g.add("GOTO:");
        this.f3296g.add("DOTALL:");
    }

    /* JADX INFO: renamed from: a */
    private boolean m2936a(ApkInfoActivity apkInfoActivity, InterfaceC1154b interfaceC1154b, String str) {
        String str2 = apkInfoActivity.m2460i() + "/" + str;
        if (!this.f3294e) {
            try {
                List listM2932b = super.m2932b(str2);
                boolean zM2937a = false;
                for (int i = 0; i < (listM2932b.size() - this.f3292c.size()) + 1 && !(zM2937a = m2937a(listM2932b, i)); i++) {
                }
                return zM2937a;
            } catch (IOException e) {
                interfaceC1154b.mo2900a(R.string.patch_error_read_from, str);
                return false;
            }
        }
        try {
            String strA = m2925a(str2);
            ArrayList arrayList = new ArrayList();
            String str3 = (String) this.f3292c.get(0);
            Matcher matcher = (this.f3295f ? Pattern.compile(str3.trim(), 32) : Pattern.compile(str3.trim())).matcher(strA);
            for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
                ArrayList arrayList2 = null;
                int iGroupCount = matcher.groupCount();
                if (iGroupCount > 0) {
                    arrayList2 = new ArrayList(iGroupCount);
                    for (int i2 = 0; i2 < iGroupCount; i2++) {
                        arrayList2.add(matcher.group(i2 + 1));
                    }
                }
                arrayList.add(new C1168p(matcher.start(), matcher.end(), arrayList2));
            }
            return !arrayList.isEmpty();
        } catch (IOException e2) {
            interfaceC1154b.mo2900a(R.string.patch_error_read_from, str);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2937a(List list, int i) {
        int i2 = 0;
        while (i2 < this.f3292c.size() && ((String) list.get(i + i2)).trim().equals((String) this.f3292c.get(i2))) {
            i2++;
        }
        return i2 == this.f3292c.size();
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) {
        m2918a(interfaceC1154b, this.f3292c);
        String strM2891b = this.f3291b.m2891b();
        while (strM2891b != null) {
            if (m2936a(apkInfoActivity, interfaceC1154b, strM2891b)) {
                return this.f3293d;
            }
            strM2891b = this.f3291b.m2891b();
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
            if ("[/MATCH_GOTO]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("TARGET:".equals(strTrim)) {
                    this.f3291b = new C1152ac(interfaceC1154b, c1155c.readLine().trim(), c1155c.m2908a());
                } else if ("REGEX:".equals(strTrim)) {
                    this.f3294e = Boolean.valueOf(c1155c.readLine().trim()).booleanValue();
                } else if ("DOTALL:".equals(strTrim)) {
                    this.f3295f = Boolean.valueOf(c1155c.readLine().trim()).booleanValue();
                } else if ("MATCH:".equals(strTrim)) {
                    line = m2917a((BufferedReader) c1155c, this.f3292c, true, this.f3296g);
                } else if ("GOTO:".equals(strTrim)) {
                    this.f3293d = c1155c.readLine().trim();
                    line = c1155c.readLine();
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
        return this.f3291b.m2890a();
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        if (this.f3291b == null || !this.f3291b.m2892c()) {
            return false;
        }
        if (this.f3292c.isEmpty()) {
            interfaceC1154b.mo2900a(R.string.patch_error_no_match_content, new Object[0]);
            return false;
        }
        if (this.f3293d == null) {
            interfaceC1154b.mo2900a(R.string.patch_error_no_goto_target, new Object[0]);
            return false;
        }
        List listMo2907f = interfaceC1154b.mo2907f();
        if (listMo2907f != null && listMo2907f.contains(this.f3293d)) {
            return true;
        }
        interfaceC1154b.mo2900a(R.string.patch_error_goto_target_notfound, this.f3293d);
        return false;
    }
}
