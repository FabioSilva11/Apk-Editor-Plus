package com.p048b.p049a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.List;

/* JADX INFO: renamed from: com.b.a.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0932g {

    /* JADX INFO: renamed from: a */
    public String f2299a;

    /* JADX INFO: renamed from: b */
    public String f2300b;

    /* JADX INFO: renamed from: c */
    public int f2301c;

    /* JADX INFO: renamed from: d */
    public boolean f2302d;

    public C0932g(String str, String str2) {
        this.f2299a = str;
        this.f2300b = str2;
        if (str2.startsWith("#")) {
            try {
                this.f2301c = (int) Long.parseLong(str2.substring(1), 16);
                this.f2302d = true;
            } catch (Exception e) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public final void m2046a(Context context, List list) {
        if (this.f2302d) {
            return;
        }
        if (!this.f2300b.startsWith("@color/")) {
            if (this.f2300b.startsWith("@android:color/")) {
                try {
                    Object objM2268e = C0985a.m2268e("android.R$color", this.f2300b.substring(15));
                    if (objM2268e != null) {
                        this.f2301c = context.getColor(((Integer) objM2268e).intValue());
                        this.f2302d = true;
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            return;
        }
        String strSubstring = this.f2300b.substring(7);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            C0932g c0932g = (C0932g) list.get(i2);
            if (c0932g.f2302d && strSubstring.equals(c0932g.f2299a)) {
                this.f2301c = c0932g.f2301c;
                this.f2302d = true;
                return;
            }
            i = i2 + 1;
        }
    }

    public final String toString() {
        return "    <color name=\"" + this.f2299a + "\">" + this.f2300b + "</color>";
    }
}
