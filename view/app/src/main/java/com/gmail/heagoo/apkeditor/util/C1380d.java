package com.gmail.heagoo.apkeditor.util;

import android.app.Activity;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.common.DialogC1484p;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1380d {

    /* JADX INFO: renamed from: b */
    private String f4004b;

    /* JADX INFO: renamed from: c */
    private String f4005c;

    /* JADX INFO: renamed from: d */
    private AbstractC1382f f4006d;

    /* JADX INFO: renamed from: e */
    private int f4007e = -1;

    /* JADX INFO: renamed from: f */
    private Map f4008f = new HashMap();

    /* JADX INFO: renamed from: a */
    Map f4003a = new HashMap();

    public C1380d(String str) {
        this.f4004b = str;
    }

    /* JADX INFO: renamed from: a */
    protected static void m3321a(BufferedWriter bufferedWriter) {
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m3322b(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt) || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == '_' || cCharAt == '.'))) {
                sb.append(cCharAt);
            } else {
                sb.append(C1487s.m3525a(4));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m3323a(Activity activity) {
        if (this.f4006d != null) {
            new DialogC1484p(activity, new C1381e(this, activity), -1).show();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3324a(String str) {
        this.f4005c = str;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3325a() {
        if (this.f4005c == null) {
            return false;
        }
        this.f4006d = new C1389m(this.f4004b, this.f4005c);
        if (this.f4006d.mo3339a()) {
            this.f4007e = 0;
            return true;
        }
        this.f4006d = new C1394r(this.f4004b, this.f4005c);
        if (this.f4006d.mo3339a()) {
            this.f4007e = 1;
            return true;
        }
        this.f4006d = new C1384h(this.f4004b, this.f4005c);
        if (this.f4006d.mo3339a()) {
            this.f4007e = 2;
            return true;
        }
        this.f4006d = new C1391o(this.f4004b, this.f4005c);
        if (this.f4006d.mo3339a()) {
            this.f4007e = 3;
            return true;
        }
        this.f4006d = new C1388l(this.f4004b, this.f4005c);
        if (!this.f4006d.mo3339a()) {
            return false;
        }
        this.f4007e = 4;
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final int m3326b() {
        return this.f4007e;
    }

    /* JADX INFO: renamed from: c */
    public final Map m3327c() {
        return this.f4003a;
    }
}
