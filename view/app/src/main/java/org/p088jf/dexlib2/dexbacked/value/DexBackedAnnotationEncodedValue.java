package org.p088jf.dexlib2.dexbacked.value;

import java.util.Set;
import org.p088jf.dexlib2.base.value.BaseAnnotationEncodedValue;
import org.p088jf.dexlib2.dexbacked.DexBackedAnnotationElement;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.dexbacked.util.VariableSizeSet;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedAnnotationEncodedValue extends BaseAnnotationEncodedValue {
    public final DexBackedDexFile dexFile;
    public final int elementCount;
    public final int elementsOffset;
    public final String type;

    public DexBackedAnnotationEncodedValue(DexBackedDexFile dexBackedDexFile, DexReader dexReader) {
        this.dexFile = dexBackedDexFile;
        this.type = dexBackedDexFile.getTypeSection().get(dexReader.readSmallUleb128());
        int smallUleb128 = dexReader.readSmallUleb128();
        this.elementCount = smallUleb128;
        this.elementsOffset = dexReader.getOffset();
        skipElements(dexReader, smallUleb128);
    }

    public static void skipElements(DexReader dexReader, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            dexReader.skipUleb128();
            DexBackedEncodedValue.skipFrom(dexReader);
        }
    }

    public static void skipFrom(DexReader dexReader) {
        dexReader.skipUleb128();
        skipElements(dexReader, dexReader.readSmallUleb128());
    }

    @Override // org.p088jf.dexlib2.iface.value.AnnotationEncodedValue
    public Set<? extends DexBackedAnnotationElement> getElements() {
        return new VariableSizeSet<DexBackedAnnotationElement>(this.dexFile.getDataBuffer(), this.elementsOffset, this.elementCount) { // from class: org.jf.dexlib2.dexbacked.value.DexBackedAnnotationEncodedValue.1
            @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeSet
            public DexBackedAnnotationElement readNextItem(DexReader dexReader, int i) {
                return new DexBackedAnnotationElement(DexBackedAnnotationEncodedValue.this.dexFile, dexReader);
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.value.AnnotationEncodedValue
    public String getType() {
        return this.type;
    }
}
