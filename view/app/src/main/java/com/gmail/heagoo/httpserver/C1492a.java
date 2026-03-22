package com.gmail.heagoo.httpserver;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: renamed from: com.gmail.heagoo.httpserver.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1492a implements Comparator {
    /* JADX INFO: renamed from: a */
    private static int m3540a(String str, String str2) {
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
        File file = (File) obj;
        File file2 = (File) obj2;
        if (file.isDirectory()) {
            if (file2.isDirectory()) {
                return m3540a(file.getName(), file2.getName());
            }
            return -1;
        }
        if (file2.isDirectory()) {
            return 1;
        }
        return m3540a(file.getName(), file2.getName());
    }
}
