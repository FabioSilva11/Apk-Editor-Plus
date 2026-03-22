package com.gmail.heagoo.apkeditor.p068se;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1351g {

    /* JADX INFO: renamed from: a */
    public List f3889a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public String f3890b;

    /* JADX INFO: renamed from: c */
    public String f3891c;

    public C1351g(String str, String str2) {
        this.f3889a.add(str2);
        this.f3891c = str2;
    }

    /* JADX INFO: renamed from: b */
    private static int m3272b(String str) {
        if (str.endsWith("-hdpi")) {
            return 4;
        }
        if (str.endsWith("-xhdpi")) {
            return 5;
        }
        if (str.endsWith("-xxhdpi")) {
            return 6;
        }
        if (str.endsWith("-mdpi")) {
            return 2;
        }
        if (str.endsWith("-ldpi")) {
            return 1;
        }
        if (str.endsWith("-xxxhdpi")) {
            return 7;
        }
        return str.endsWith("-tvdpi") ? 3 : 2;
    }

    /* JADX INFO: renamed from: a */
    public final String m3273a() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f3889a.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append("\n");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m3274a(String str) {
        this.f3889a.add(str);
        if (m3272b(str) > m3272b(this.f3891c)) {
            this.f3891c = str;
        }
    }
}
