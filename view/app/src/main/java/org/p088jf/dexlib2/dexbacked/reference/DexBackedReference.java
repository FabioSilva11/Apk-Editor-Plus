package org.p088jf.dexlib2.dexbacked.reference;

import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public abstract class DexBackedReference {
    public static Reference makeReference(DexBackedDexFile dexBackedDexFile, int i, int i2) {
        switch (i) {
            case 0:
                return new DexBackedStringReference(dexBackedDexFile, i2);
            case 1:
                return new DexBackedTypeReference(dexBackedDexFile, i2);
            case 2:
                return new DexBackedFieldReference(dexBackedDexFile, i2);
            case 3:
                return new DexBackedMethodReference(dexBackedDexFile, i2);
            case 4:
                return new DexBackedMethodProtoReference(dexBackedDexFile, i2);
            case 5:
                return new DexBackedCallSiteReference(dexBackedDexFile, i2);
            case 6:
                return new DexBackedMethodHandleReference(dexBackedDexFile, i2);
            default:
                throw new ExceptionWithContext("Invalid reference type: %d", Integer.valueOf(i));
        }
    }
}
