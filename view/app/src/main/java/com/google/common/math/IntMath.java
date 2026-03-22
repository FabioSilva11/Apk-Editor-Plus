package com.google.common.math;

import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
public final class IntMath {
    public static int saturatedMultiply(int i, int i2) {
        return Ints.saturatedCast(((long) i) * ((long) i2));
    }
}
