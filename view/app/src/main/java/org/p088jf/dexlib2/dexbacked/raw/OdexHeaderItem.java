package org.p088jf.dexlib2.dexbacked.raw;

import org.p088jf.dexlib2.dexbacked.DexBuffer;

/* JADX INFO: loaded from: classes.dex */
public class OdexHeaderItem {
    public static final byte[] MAGIC_VALUE = {100, 101, 121, 10, 0, 0, 0, 0};
    public static final int[] SUPPORTED_ODEX_VERSIONS = {35, 36};

    public static int getDexOffset(byte[] bArr) {
        return new DexBuffer(bArr).readSmallUint(8);
    }

    public static int getVersion(byte[] bArr, int i) {
        if (verifyMagic(bArr, i)) {
            return getVersionUnchecked(bArr, i);
        }
        return -1;
    }

    public static int getVersionUnchecked(byte[] bArr, int i) {
        return ((bArr[i + 4] - 48) * 100) + ((bArr[i + 5] - 48) * 10) + (bArr[i + 6] - 48);
    }

    public static boolean isSupportedOdexVersion(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = SUPPORTED_ODEX_VERSIONS;
            if (i2 >= iArr.length) {
                return false;
            }
            if (iArr[i2] == i) {
                return true;
            }
            i2++;
        }
    }

    public static boolean verifyMagic(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= 4) {
                for (int i3 = 4; i3 < 7; i3++) {
                    int i4 = i + i3;
                    if (bArr[i4] < 48 || bArr[i4] > 57) {
                        return false;
                    }
                }
                return bArr[i + 7] == MAGIC_VALUE[7];
            }
            if (bArr[i + i2] != MAGIC_VALUE[i2]) {
                return false;
            }
            i2++;
        }
    }
}
