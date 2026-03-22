package com.p016a.p019b.p028c.p032c;

import jadx.core.codegen.CodeWriter;

/* JADX INFO: renamed from: com.a.b.c.c.av */
/* JADX INFO: loaded from: classes.dex */
final class C0624av {

    /* JADX INFO: renamed from: a */
    private final String f1105a;

    /* JADX INFO: renamed from: b */
    private int f1106b;

    /* JADX INFO: renamed from: c */
    private int f1107c;

    /* JADX INFO: renamed from: d */
    private int f1108d;

    /* JADX INFO: renamed from: e */
    private int f1109e;

    public C0624av(AbstractC0606ad abstractC0606ad, String str) {
        int iMo1054e_ = abstractC0606ad.mo1054e_();
        this.f1105a = str;
        this.f1106b = 1;
        this.f1107c = iMo1054e_;
        this.f1108d = iMo1054e_;
        this.f1109e = iMo1054e_;
    }

    /* JADX INFO: renamed from: a */
    public final String m1109a() {
        StringBuilder sb = new StringBuilder();
        sb.append("  " + this.f1105a + ": " + this.f1106b + " item" + (this.f1106b == 1 ? "" : "s") + "; " + this.f1107c + " bytes total\n");
        if (this.f1109e == this.f1108d) {
            sb.append(CodeWriter.INDENT + this.f1109e + " bytes/item\n");
        } else {
            sb.append(CodeWriter.INDENT + this.f1109e + ".." + this.f1108d + " bytes/item; average " + (this.f1107c / this.f1106b) + "\n");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m1110a(AbstractC0606ad abstractC0606ad) {
        int iMo1054e_ = abstractC0606ad.mo1054e_();
        this.f1106b++;
        this.f1107c += iMo1054e_;
        if (iMo1054e_ > this.f1108d) {
            this.f1108d = iMo1054e_;
        }
        if (iMo1054e_ < this.f1109e) {
            this.f1109e = iMo1054e_;
        }
    }
}
