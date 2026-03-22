package com.gmail.heagoo.apkeditor.p066e;

import jadx.core.deobf.Deobfuscator;
import java.io.File;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1176x extends AbstractC1175w {

    /* JADX INFO: renamed from: a */
    private int f3314a;

    /* JADX INFO: renamed from: b */
    private String f3315b;

    /* JADX INFO: renamed from: c */
    private String f3316c;

    /* JADX INFO: renamed from: d */
    private List f3317d;

    /* JADX INFO: renamed from: e */
    private int f3318e = 0;

    public C1176x(InterfaceC1154b interfaceC1154b, int i) {
        this.f3314a = i;
        this.f3315b = interfaceC1154b.mo2903b();
        switch (C1177y.f3319a[i - 1]) {
            case 1:
                this.f3316c = interfaceC1154b.mo2904c();
                break;
            case 2:
                this.f3317d = interfaceC1154b.mo2905d();
                break;
            case 3:
                this.f3317d = interfaceC1154b.mo2906e();
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m2957a(String str, String str2, boolean z) {
        String str3 = str + "/" + str2.replaceAll("\\.", "/") + ".smali";
        String str4 = this.f3315b + "/" + str3;
        if (!z || new File(str4).exists()) {
            return str3;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private String m2958b(String str) {
        String strM2957a = m2957a("smali", str, true);
        int i = 2;
        while (strM2957a == null && i < 8) {
            String strM2957a2 = m2957a("smali_classes" + i, str, true);
            i++;
            strM2957a = strM2957a2;
        }
        return strM2957a == null ? m2957a("smali", str, false) : strM2957a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: a */
    public final String mo2885a() {
        switch (C1177y.f3319a[this.f3314a - 1]) {
            case 1:
                if (this.f3318e == 0) {
                    this.f3318e++;
                    return m2958b(this.f3316c);
                }
                return null;
            case 2:
            case 3:
                if (this.f3318e < this.f3317d.size()) {
                    List list = this.f3317d;
                    int i = this.f3318e;
                    this.f3318e = i + 1;
                    return m2958b((String) list.get(i));
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: a */
    public final boolean mo2886a(String str) {
        int iIndexOf = str.indexOf(47);
        if (iIndexOf != -1 && str.endsWith(".smali")) {
            String strReplaceAll = str.substring(iIndexOf + 1, str.length() - 6).replaceAll("/", Deobfuscator.CLASS_NAME_SEPARATOR);
            switch (C1177y.f3319a[this.f3314a - 1]) {
                case 1:
                    return strReplaceAll.equals(this.f3316c);
                case 2:
                case 3:
                    return this.f3317d.contains(strReplaceAll);
            }
        }
        return false;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: b */
    public final boolean mo2887b() {
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: c */
    public final boolean mo2888c() {
        return false;
    }
}
