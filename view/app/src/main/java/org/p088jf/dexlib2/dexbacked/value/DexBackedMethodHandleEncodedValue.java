package org.p088jf.dexlib2.dexbacked.value;

import org.p088jf.dexlib2.base.value.BaseMethodHandleEncodedValue;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedMethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedMethodHandleEncodedValue extends BaseMethodHandleEncodedValue {
    public final DexBackedDexFile dexFile;
    public final int methodHandleIndex;

    public DexBackedMethodHandleEncodedValue(DexBackedDexFile dexBackedDexFile, DexReader dexReader, int i) {
        this.dexFile = dexBackedDexFile;
        this.methodHandleIndex = dexReader.readSizedSmallUint(i + 1);
    }

    @Override // org.p088jf.dexlib2.iface.value.MethodHandleEncodedValue
    public MethodHandleReference getValue() {
        return new DexBackedMethodHandleReference(this.dexFile, this.methodHandleIndex);
    }
}
