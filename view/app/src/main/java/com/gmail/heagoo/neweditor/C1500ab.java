package com.gmail.heagoo.neweditor;

import java.text.DecimalFormat;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.ab */
/* JADX INFO: loaded from: classes.dex */
public final class C1500ab {
    static {
        new DecimalFormat("#.# kB");
        new DecimalFormat("#.# MB");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3607a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 != null) {
            return obj.equals(obj2);
        }
        return false;
    }
}
