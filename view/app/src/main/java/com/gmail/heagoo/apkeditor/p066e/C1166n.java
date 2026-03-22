package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.n */
/* JADX INFO: loaded from: classes.dex */
final class C1166n extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private C1152ac f3285b;

    /* JADX INFO: renamed from: e */
    private boolean f3288e = false;

    /* JADX INFO: renamed from: f */
    private boolean f3289f = false;

    /* JADX INFO: renamed from: c */
    private List f3286c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private List f3287d = new ArrayList();

    /* JADX INFO: renamed from: g */
    private List f3290g = new ArrayList();

    C1166n() {
        this.f3290g.add("[/MATCH_ASSIGN]");
        this.f3290g.add("TARGET:");
        this.f3290g.add("MATCH:");
        this.f3290g.add("REGEX:");
        this.f3290g.add("ASSIGN:");
        this.f3290g.add("DOTALL:");
    }

    /* JADX INFO: renamed from: a */
    private static String m2934a(String str, List list) {
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
    private boolean m2935a(ApkInfoActivity apkInfoActivity, InterfaceC1154b interfaceC1154b, String str) {
        try {
            String strA = m2925a(apkInfoActivity.m2460i() + "/" + str);
            String str2 = (String) this.f3286c.get(0);
            Matcher matcher = (this.f3289f ? Pattern.compile(str2.trim(), 32) : Pattern.compile(str2.trim())).matcher(strA);
            if (!matcher.find(0)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            int iGroupCount = matcher.groupCount();
            if (iGroupCount > 0) {
                for (int i = 0; i < iGroupCount; i++) {
                    arrayList.add(matcher.group(i + 1));
                }
            }
            Iterator it = this.f3287d.iterator();
            while (it.hasNext()) {
                String strTrim = ((String) it.next()).trim();
                int iIndexOf = strTrim.indexOf(61);
                if (iIndexOf != -1) {
                    String strSubstring = strTrim.substring(0, iIndexOf);
                    String strM2934a = m2934a(strTrim.substring(iIndexOf + 1), arrayList);
                    interfaceC1154b.mo2901a(strSubstring, strM2934a);
                    interfaceC1154b.mo2902a("%s=\"%s\"", false, strSubstring, strM2934a);
                }
            }
            return true;
        } catch (IOException e) {
            interfaceC1154b.mo2900a(R.string.patch_error_read_from, str);
            return false;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) {
        m2918a(interfaceC1154b, this.f3286c);
        String strM2891b = this.f3285b.m2891b();
        while (strM2891b != null && !m2935a(apkInfoActivity, interfaceC1154b, strM2891b)) {
            strM2891b = this.f3285b.m2891b();
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
            if ("[/MATCH_ASSIGN]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("TARGET:".equals(strTrim)) {
                    this.f3285b = new C1152ac(interfaceC1154b, c1155c.readLine().trim(), c1155c.m2908a());
                } else if ("REGEX:".equals(strTrim)) {
                    this.f3288e = Boolean.valueOf(c1155c.readLine().trim()).booleanValue();
                } else if ("DOTALL:".equals(strTrim)) {
                    this.f3289f = Boolean.valueOf(c1155c.readLine().trim()).booleanValue();
                } else if ("MATCH:".equals(strTrim)) {
                    line = m2917a((BufferedReader) c1155c, this.f3286c, true, this.f3290g);
                } else if ("ASSIGN:".equals(strTrim)) {
                    line = m2917a((BufferedReader) c1155c, this.f3287d, false, this.f3290g);
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
        return this.f3285b.m2890a();
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        if (this.f3285b == null || !this.f3285b.m2892c()) {
            return false;
        }
        if (this.f3286c.isEmpty()) {
            interfaceC1154b.mo2900a(R.string.patch_error_no_match_content, new Object[0]);
            return false;
        }
        if (this.f3288e) {
            return true;
        }
        interfaceC1154b.mo2900a(R.string.patch_error_regex_not_true, new Object[0]);
        return false;
    }
}
