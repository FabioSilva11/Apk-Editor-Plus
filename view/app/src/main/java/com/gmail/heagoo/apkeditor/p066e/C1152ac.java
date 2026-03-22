package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.pro.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.ac */
/* JADX INFO: loaded from: classes.dex */
final class C1152ac {

    /* JADX INFO: renamed from: a */
    private List f3253a;

    C1152ac(InterfaceC1154b interfaceC1154b, String str, int i) {
        C1176x c1176x;
        this.f3253a = new ArrayList();
        String strM2916a = AbstractC1159g.m2916a(interfaceC1154b, str);
        str = strM2916a != null ? strM2916a : str;
        if (!str.startsWith("[") || !str.endsWith("]")) {
            if (str.contains("*")) {
                this.f3253a.add(new C1151ab(interfaceC1154b, str));
                return;
            } else {
                this.f3253a.add(new C1150aa(str));
                return;
            }
        }
        for (String str2 : m2889a(str)) {
            if ("APPLICATION".equals(str2)) {
                c1176x = new C1176x(interfaceC1154b, C1178z.f3320a);
            } else if ("ACTIVITIES".equals(str2)) {
                c1176x = new C1176x(interfaceC1154b, C1178z.f3321b);
            } else if ("LAUNCHER_ACTIVITIES".equals(str2)) {
                c1176x = new C1176x(interfaceC1154b, C1178z.f3322c);
            } else {
                interfaceC1154b.mo2900a(R.string.patch_error_invalid_target, Integer.valueOf(i));
                c1176x = null;
            }
            if (c1176x == null) {
                this.f3253a = null;
                return;
            }
            this.f3253a.add(c1176x);
        }
    }

    /* JADX INFO: renamed from: a */
    private static List m2889a(String str) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = 1;
        int iIndexOf2 = str.indexOf(93);
        while (iIndexOf > 0 && iIndexOf2 > iIndexOf) {
            arrayList.add(str.substring(iIndexOf, iIndexOf2));
            iIndexOf = str.indexOf(91, iIndexOf2) + 1;
            if (iIndexOf > 0) {
                iIndexOf2 = str.indexOf(93, iIndexOf);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    final boolean m2890a() {
        if (this.f3253a == null) {
            return false;
        }
        for (int i = 0; i < this.f3253a.size(); i++) {
            if (((AbstractC1175w) this.f3253a.get(i)).mo2887b()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    final String m2891b() {
        boolean z;
        if (this.f3253a == null) {
            return null;
        }
        String strMo2885a = ((AbstractC1175w) this.f3253a.get(0)).mo2885a();
        if (this.f3253a.size() <= 1) {
            return strMo2885a;
        }
        String strMo2885a2 = strMo2885a;
        while (strMo2885a2 != null) {
            int i = 1;
            while (true) {
                if (i >= this.f3253a.size()) {
                    z = true;
                    break;
                }
                if (!((AbstractC1175w) this.f3253a.get(i)).mo2886a(strMo2885a2)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                break;
            }
            strMo2885a2 = ((AbstractC1175w) this.f3253a.get(0)).mo2885a();
        }
        return strMo2885a2;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m2892c() {
        return this.f3253a != null;
    }

    /* JADX INFO: renamed from: d */
    final boolean m2893d() {
        if (this.f3253a == null) {
            return false;
        }
        Iterator it = this.f3253a.iterator();
        while (it.hasNext()) {
            if (!((AbstractC1175w) it.next()).mo2888c()) {
                return false;
            }
        }
        return true;
    }
}
