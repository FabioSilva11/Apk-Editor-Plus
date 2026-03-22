package com.gmail.heagoo.common;

import java.util.Random;

/* JADX INFO: renamed from: com.gmail.heagoo.common.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1487s {

    /* JADX INFO: renamed from: a */
    private static Random f4318a;

    /* JADX INFO: renamed from: b */
    private static final char[] f4319b = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* JADX INFO: renamed from: a */
    public static String m3525a(int i) {
        if (f4318a == null) {
            f4318a = new Random(System.currentTimeMillis());
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(f4319b[f4318a.nextInt(26)]);
        }
        return sb.toString();
    }
}
