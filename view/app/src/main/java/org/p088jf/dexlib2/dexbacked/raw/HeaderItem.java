package org.p088jf.dexlib2.dexbacked.raw;

import org.p088jf.dexlib2.VersionMap;
import org.p088jf.dexlib2.dexbacked.DexBuffer;

/* JADX INFO: loaded from: classes.dex */
public class HeaderItem {
    public static final byte[] MAGIC_VALUE = {100, 101, 120, 10, 0, 0, 0, 0};

    public static int getEndian(byte[] bArr, int i) {
        return new DexBuffer(bArr).readInt(i + 40);
    }

    public static byte[] getMagicForApi(int i) {
        return getMagicForDexVersion(VersionMap.mapApiToDexVersion(i));
    }

    public static byte[] getMagicForDexVersion(int i) {
        byte[] bArr = (byte[]) MAGIC_VALUE.clone();
        if (i < 0 || i > 999) {
            throw new IllegalArgumentException("dexVersion must be within [0, 999]");
        }
        for (int i2 = 6; i2 >= 4; i2--) {
            bArr[i2] = (byte) ((i % 10) + 48);
            i /= 10;
        }
        return bArr;
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

    public static boolean isSupportedDexVersion(int i) {
        return VersionMap.mapDexVersionToApi(i) != -1;
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
