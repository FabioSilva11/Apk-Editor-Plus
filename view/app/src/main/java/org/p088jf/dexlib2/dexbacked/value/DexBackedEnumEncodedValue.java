package org.p088jf.dexlib2.dexbacked.value;

import org.p088jf.dexlib2.base.value.BaseEnumEncodedValue;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedFieldReference;
import org.p088jf.dexlib2.iface.reference.FieldReference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedEnumEncodedValue extends BaseEnumEncodedValue {
    public final DexBackedDexFile dexFile;
    public final int fieldIndex;

    public DexBackedEnumEncodedValue(DexBackedDexFile dexBackedDexFile, DexReader dexReader, int i) {
        this.dexFile = dexBackedDexFile;
        this.fieldIndex = dexReader.readSizedSmallUint(i + 1);
    }

    @Override // org.p088jf.dexlib2.iface.value.EnumEncodedValue
    public FieldReference getValue() {
        return new DexBackedFieldReference(this.dexFile, this.fieldIndex);
    }
}
