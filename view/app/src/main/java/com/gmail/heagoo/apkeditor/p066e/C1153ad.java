package com.gmail.heagoo.apkeditor.p066e;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.ad */
/* JADX INFO: loaded from: classes.dex */
public final class C1153ad {

    /* JADX INFO: renamed from: a */
    public String f3254a;

    /* JADX INFO: renamed from: b */
    public String f3255b;

    /* JADX INFO: renamed from: c */
    public int f3256c;

    private C1153ad(String str, String str2, int i) {
        this.f3254a = str;
        this.f3255b = str2;
        this.f3256c = i;
    }

    /* JADX INFO: renamed from: a */
    public static C1153ad m2894a(String str) {
        int iM2895b;
        String strSubstring;
        String strSubstring2;
        int i;
        int iIndexOf;
        int i2;
        int iIndexOf2;
        int i3;
        int iIndexOf3;
        int iIndexOf4 = str.indexOf("type=\"");
        if (iIndexOf4 == -1 || (iIndexOf = str.indexOf("\" ", (i = iIndexOf4 + 6))) == -1) {
            iM2895b = -1;
            strSubstring = null;
            strSubstring2 = null;
        } else {
            strSubstring2 = str.substring(i, iIndexOf);
            int iIndexOf5 = str.indexOf("name=\"");
            if (iIndexOf5 == -1 || (iIndexOf2 = str.indexOf("\" ", (i2 = iIndexOf5 + 6))) == -1) {
                iM2895b = -1;
                strSubstring = null;
            } else {
                strSubstring = str.substring(i2, iIndexOf2);
                int iIndexOf6 = str.indexOf("id=\"");
                iM2895b = (iIndexOf6 == -1 || (iIndexOf3 = str.indexOf("\" ", (i3 = iIndexOf6 + 4))) == -1) ? -1 : m2895b(str.substring(i3, iIndexOf3));
            }
        }
        if (strSubstring2 == null || strSubstring == null || iM2895b == -1) {
            return null;
        }
        return new C1153ad(strSubstring2, strSubstring, iM2895b);
    }

    /* JADX INFO: renamed from: b */
    public static int m2895b(String str) {
        if (str.length() != 10) {
            return 0;
        }
        int i = 2;
        int i2 = 0;
        while (i < 10) {
            int i3 = i2 << 4;
            char cCharAt = str.charAt(i);
            i++;
            i2 = i3 | ((cCharAt < '0' || cCharAt > '9') ? (cCharAt < 'a' || cCharAt > 'f') ? (cCharAt < 'A' || cCharAt > 'F') ? 0 : (cCharAt - 'A') + 10 : (cCharAt - 'a') + 10 : cCharAt - '0');
        }
        return i2;
    }

    public final String toString() {
        return String.format("<public type=\"%s\" name=\"%s\" id=\"0x%s\" />", this.f3254a, this.f3255b, Integer.toHexString(this.f3256c));
    }
}
