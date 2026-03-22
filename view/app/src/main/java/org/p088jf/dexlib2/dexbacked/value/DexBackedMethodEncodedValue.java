package org.p088jf.dexlib2.dexbacked.value;

import org.p088jf.dexlib2.base.value.BaseMethodEncodedValue;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedMethodReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedMethodEncodedValue extends BaseMethodEncodedValue {
    public final DexBackedDexFile dexFile;
    public final int methodIndex;

    public DexBackedMethodEncodedValue(DexBackedDexFile dexBackedDexFile, DexReader dexReader, int i) {
        this.dexFile = dexBackedDexFile;
        this.methodIndex = dexReader.readSizedSmallUint(i + 1);
    }

    @Override // org.p088jf.dexlib2.iface.value.MethodEncodedValue
    public MethodReference getValue() {
        return new DexBackedMethodReference(this.dexFile, this.methodIndex);
    }
}
