package com.android.apksig.internal.util;

/* JADX INFO: loaded from: classes.dex */
public class MathCompat {
    public static int toIntExact(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
