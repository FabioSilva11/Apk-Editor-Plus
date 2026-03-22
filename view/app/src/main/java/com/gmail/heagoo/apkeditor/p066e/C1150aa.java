package com.gmail.heagoo.apkeditor.p066e;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C1150aa extends AbstractC1175w {

    /* JADX INFO: renamed from: a */
    private String f3244a;

    /* JADX INFO: renamed from: b */
    private int f3245b = 0;

    public C1150aa(String str) {
        this.f3244a = str;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: a */
    public final String mo2885a() {
        if (this.f3245b != 0) {
            return null;
        }
        this.f3245b++;
        return this.f3244a;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: a */
    public final boolean mo2886a(String str) {
        return this.f3244a.equals(str);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: b */
    public final boolean mo2887b() {
        int iIndexOf;
        if (this.f3244a == null || (iIndexOf = this.f3244a.indexOf(47)) == -1) {
            return false;
        }
        String strSubstring = this.f3244a.substring(0, iIndexOf);
        return "smali".equals(strSubstring) || strSubstring.startsWith("smali_");
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1175w
    /* JADX INFO: renamed from: c */
    public final boolean mo2888c() {
        return false;
    }
}
