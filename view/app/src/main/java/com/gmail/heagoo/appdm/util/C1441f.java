package com.gmail.heagoo.appdm.util;

import java.util.Comparator;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.util.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1441f implements Comparator {
    /* JADX INFO: renamed from: a */
    private static int m3459a(String str, String str2) {
        while (!str.isEmpty()) {
            if (str2.isEmpty()) {
                return 1;
            }
            char cCharAt = str.charAt(0);
            char cCharAt2 = str2.charAt(0);
            if (cCharAt == cCharAt2) {
                str = str.substring(1);
                str2 = str2.substring(1);
            } else {
                if (Character.isLetter(cCharAt) && Character.isLetter(cCharAt2)) {
                    char lowerCase = Character.toLowerCase(cCharAt);
                    char lowerCase2 = Character.toLowerCase(cCharAt2);
                    return lowerCase == lowerCase2 ? cCharAt < cCharAt2 ? -1 : 1 : lowerCase < lowerCase2 ? -1 : 1;
                }
                if (cCharAt != cCharAt2) {
                    return cCharAt < cCharAt2 ? -1 : 1;
                }
                str = str.substring(1);
                str2 = str2.substring(1);
            }
        }
        return str2.isEmpty() ? 0 : -1;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        C1440e c1440e = (C1440e) obj;
        C1440e c1440e2 = (C1440e) obj2;
        if (c1440e.f4245c) {
            if (c1440e2.f4245c) {
                return m3459a(c1440e.f4243a, c1440e2.f4243a);
            }
            return -1;
        }
        if (c1440e2.f4245c) {
            return 1;
        }
        return m3459a(c1440e.f4243a, c1440e2.f4243a);
    }
}
