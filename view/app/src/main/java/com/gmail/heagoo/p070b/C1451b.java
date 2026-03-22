package com.gmail.heagoo.p070b;

import java.util.Comparator;

/* JADX INFO: renamed from: com.gmail.heagoo.b.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1451b implements Comparator {
    /* JADX INFO: renamed from: a */
    private static int m3467a(String str, String str2) {
        while (!str.isEmpty()) {
            if (str2.isEmpty()) {
                return 1;
            }
            char cCharAt = str.charAt(0);
            char cCharAt2 = str2.charAt(0);
            if (cCharAt != cCharAt2) {
                if (!m3468a(cCharAt) || !m3468a(cCharAt2)) {
                    return cCharAt < cCharAt2 ? -1 : 1;
                }
                char lowerCase = Character.toLowerCase(cCharAt);
                char lowerCase2 = Character.toLowerCase(cCharAt2);
                return lowerCase == lowerCase2 ? cCharAt < cCharAt2 ? -1 : 1 : lowerCase < lowerCase2 ? -1 : 1;
            }
            str = str.substring(1);
            str2 = str2.substring(1);
        }
        return str2.isEmpty() ? 0 : -1;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3468a(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        C1450a c1450a = (C1450a) obj;
        C1450a c1450a2 = (C1450a) obj2;
        if (c1450a.f4256b) {
            if (c1450a2.f4256b) {
                return m3467a(c1450a.f4255a, c1450a2.f4255a);
            }
            return -1;
        }
        if (c1450a2.f4256b) {
            return 1;
        }
        return m3467a(c1450a.f4255a, c1450a2.f4255a);
    }
}
