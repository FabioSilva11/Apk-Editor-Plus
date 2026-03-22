package org.p088jf.dexlib2.dexbacked.value;

import org.p088jf.dexlib2.base.value.BaseMethodTypeEncodedValue;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedMethodProtoReference;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedMethodTypeEncodedValue extends BaseMethodTypeEncodedValue {
    public final DexBackedDexFile dexFile;
    public final int methodProtoIndex;

    public DexBackedMethodTypeEncodedValue(DexBackedDexFile dexBackedDexFile, DexReader dexReader, int i) {
        this.dexFile = dexBackedDexFile;
        this.methodProtoIndex = dexReader.readSizedSmallUint(i + 1);
    }

    @Override // org.p088jf.dexlib2.iface.value.MethodTypeEncodedValue
    public MethodProtoReference getValue() {
        return new DexBackedMethodProtoReference(this.dexFile, this.methodProtoIndex);
    }
}
