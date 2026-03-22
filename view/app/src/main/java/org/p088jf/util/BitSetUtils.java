package org.p088jf.util;

import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class BitSetUtils {
    public static BitSet bitSetOfIndexes(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i : iArr) {
            bitSet.set(i);
        }
        return bitSet;
    }
}
