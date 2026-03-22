package org.p088jf.dexlib2.dexbacked.value;

import java.util.List;
import org.p088jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.dexbacked.util.VariableSizeList;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedArrayEncodedValue extends BaseArrayEncodedValue {
    public final DexBackedDexFile dexFile;
    public final int elementCount;
    public final int encodedArrayOffset;

    public DexBackedArrayEncodedValue(DexBackedDexFile dexBackedDexFile, DexReader dexReader) {
        this.dexFile = dexBackedDexFile;
        int smallUleb128 = dexReader.readSmallUleb128();
        this.elementCount = smallUleb128;
        this.encodedArrayOffset = dexReader.getOffset();
        skipElementsFrom(dexReader, smallUleb128);
    }

    public static void skipElementsFrom(DexReader dexReader, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            DexBackedEncodedValue.skipFrom(dexReader);
        }
    }

    public static void skipFrom(DexReader dexReader) {
        skipElementsFrom(dexReader, dexReader.readSmallUleb128());
    }

    @Override // org.p088jf.dexlib2.iface.value.ArrayEncodedValue
    public List<? extends EncodedValue> getValue() {
        return new VariableSizeList<EncodedValue>(this.dexFile.getDataBuffer(), this.encodedArrayOffset, this.elementCount) { // from class: org.jf.dexlib2.dexbacked.value.DexBackedArrayEncodedValue.1
            @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeList
            public EncodedValue readNextItem(DexReader dexReader, int i) {
                return DexBackedEncodedValue.readFrom(DexBackedArrayEncodedValue.this.dexFile, dexReader);
            }
        };
    }
}
