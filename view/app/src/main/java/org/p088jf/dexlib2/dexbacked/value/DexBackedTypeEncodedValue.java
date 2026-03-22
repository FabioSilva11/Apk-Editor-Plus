package org.p088jf.dexlib2.dexbacked.value;

import org.p088jf.dexlib2.base.value.BaseTypeEncodedValue;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedTypeEncodedValue extends BaseTypeEncodedValue {
    public final DexBackedDexFile dexFile;
    public final int typeIndex;

    public DexBackedTypeEncodedValue(DexBackedDexFile dexBackedDexFile, DexReader dexReader, int i) {
        this.dexFile = dexBackedDexFile;
        this.typeIndex = dexReader.readSizedSmallUint(i + 1);
    }

    @Override // org.p088jf.dexlib2.iface.value.TypeEncodedValue
    public String getValue() {
        return this.dexFile.getTypeSection().get(this.typeIndex);
    }
}
