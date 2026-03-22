package com.gmail.heagoo.apkeditor.p066e;

import jadx.core.deobf.Deobfuscator;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.ab */
/* JADX INFO: loaded from: classes.dex */
public final class C1151ab extends AbstractC1175w {

    /* JADX INFO: renamed from: a */
    private String f3246a;

    /* JADX INFO: renamed from: b */
    private String f3247b;

    /* JADX INFO: renamed from: c */
    private String f3248c;

    /* JADX INFO: renamed from: d */
    private boolean f3249d = false;

    /* JADX INFO: renamed from: e */
    private List f3250e = new LinkedList();

    /* JADX INFO: renamed from: f */
    private List f3251f = new ArrayList();

    /* JADX INFO: renamed from: g */
    private int f3252g = 0;

    public C1151ab(InterfaceC1154b interfaceC1154b, String str) {
        this.f3246a = str;
        this.f3247b = "^" + str.replace("*", ".*") + Deobfuscator.INNER_CLASS_SEPARATOR;
        this.f3248c = interfaceC1154b.mo2903b();
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: a */
    public final String mo2885a() {
        if (!this.f3249d) {
            File[] fileArrListFiles = new File(this.f3248c).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (file.isDirectory()) {
                        this.f3250e.add(file.getName());
                    } else {
                        String name = file.getName();
                        if (mo2886a(name)) {
                            this.f3251f.add(name);
                        }
                    }
                }
            }
            this.f3249d = true;
        }
        if (this.f3252g < this.f3251f.size()) {
            String str = (String) this.f3251f.get(this.f3252g);
            this.f3252g++;
            return str;
        }
        if (!this.f3250e.isEmpty()) {
            this.f3252g = 0;
            this.f3251f.clear();
            while (!this.f3250e.isEmpty()) {
                String str2 = (String) this.f3250e.remove(0);
                File[] fileArrListFiles2 = new File(this.f3248c + "/" + str2).listFiles();
                if (fileArrListFiles2 != null) {
                    for (File file2 : fileArrListFiles2) {
                        String str3 = str2 + "/" + file2.getName();
                        if (file2.isDirectory()) {
                            this.f3250e.add(str3);
                        } else if (mo2886a(str3)) {
                            this.f3251f.add(str3);
                        }
                    }
                }
                if (!this.f3251f.isEmpty()) {
                    break;
                }
            }
            if (!this.f3251f.isEmpty()) {
                this.f3252g = 1;
                return (String) this.f3251f.get(0);
            }
        }
        return null;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: a */
    public final boolean mo2886a(String str) {
        return str.matches(this.f3247b);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: b */
    public final boolean mo2887b() {
        return this.f3246a.startsWith("smali") || this.f3246a.endsWith(".smali");
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: c */
    public final boolean mo2888c() {
        return true;
    }
}
