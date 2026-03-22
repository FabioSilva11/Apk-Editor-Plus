package com.gmail.heagoo.apkeditor.p068se;

import java.util.Comparator;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.w */
/* JADX INFO: loaded from: classes.dex */
final class C1367w implements Comparator {
    C1367w(ViewOnClickListenerC1365u viewOnClickListenerC1365u) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        C1369y c1369y = (C1369y) obj;
        C1369y c1369y2 = (C1369y) obj2;
        if (c1369y.f3940b) {
            if (!c1369y2.f3940b) {
                return -1;
            }
        } else if (c1369y2.f3940b) {
            return 1;
        }
        return c1369y.f3939a.compareTo(c1369y2.f3939a);
    }
}
