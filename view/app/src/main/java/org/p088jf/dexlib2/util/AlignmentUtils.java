package org.p088jf.dexlib2.util;

/* JADX INFO: loaded from: classes.dex */
public abstract class AlignmentUtils {
    public static int alignOffset(int i, int i2) {
        int i3 = i2 - 1;
        return (i + i3) & (i3 ^ (-1));
    }
}
