package com.gmail.heagoo.apkeditor.util;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.n */
/* JADX INFO: loaded from: classes.dex */
final class C1390n {

    /* JADX INFO: renamed from: a */
    String f4034a;

    /* JADX INFO: renamed from: b */
    String f4035b;

    /* JADX INFO: renamed from: c */
    String f4036c;

    /* JADX INFO: renamed from: d */
    String f4037d;

    /* JADX INFO: renamed from: e */
    String f4038e;

    /* JADX INFO: renamed from: f */
    private String f4039f;

    private C1390n(String str) {
        String[] strArrSplit = str.split("/");
        int length = strArrSplit.length;
        this.f4036c = strArrSplit[length - 1];
        this.f4039f = strArrSplit[length - 2];
        int iIndexOf = this.f4039f.indexOf(45);
        if (iIndexOf != -1) {
            this.f4034a = this.f4039f.substring(0, iIndexOf);
        } else {
            this.f4034a = this.f4039f;
        }
        int iLastIndexOf = this.f4036c.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            this.f4035b = this.f4036c.substring(0, iLastIndexOf);
        } else {
            this.f4035b = this.f4036c;
        }
    }

    /* synthetic */ C1390n(String str, byte b2) {
        this(str);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3355a(C1390n c1390n, int i) {
        StringBuilder sb = new StringBuilder();
        int iLastIndexOf = c1390n.f4036c.lastIndexOf(46);
        String strSubstring = iLastIndexOf != -1 ? c1390n.f4036c.endsWith(".9.png") ? ".9.png" : c1390n.f4036c.substring(iLastIndexOf) : "";
        for (int i2 = 0; i2 < c1390n.f4036c.length() - strSubstring.length(); i2++) {
            char cCharAt = c1390n.f4036c.charAt(i2);
            if (Character.isLowerCase(cCharAt)) {
                sb.append(cCharAt);
            } else if (Character.isUpperCase(cCharAt)) {
                sb.append((char) ((cCharAt - 'A') + 97));
            } else if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            } else if (cCharAt == '_' || cCharAt == '.') {
                sb.append(cCharAt);
            }
        }
        sb.append("_r" + i);
        c1390n.f4038e = sb.toString();
        if (c1390n.f4038e.length() == c1390n.f4035b.length()) {
            c1390n.f4038e += "_";
        }
        sb.append(strSubstring);
        c1390n.f4037d = sb.toString();
    }
}
