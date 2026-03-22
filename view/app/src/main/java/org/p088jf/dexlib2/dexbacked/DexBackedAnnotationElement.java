package org.p088jf.dexlib2.dexbacked;

import org.p088jf.dexlib2.base.BaseAnnotationElement;
import org.p088jf.dexlib2.dexbacked.value.DexBackedEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedAnnotationElement extends BaseAnnotationElement {
    public final DexBackedDexFile dexFile;
    public final int nameIndex;
    public final EncodedValue value;

    public DexBackedAnnotationElement(DexBackedDexFile dexBackedDexFile, DexReader dexReader) {
        this.dexFile = dexBackedDexFile;
        this.nameIndex = dexReader.readSmallUleb128();
        this.value = DexBackedEncodedValue.readFrom(dexBackedDexFile, dexReader);
    }

    @Override // org.p088jf.dexlib2.iface.AnnotationElement
    public String getName() {
        return this.dexFile.getStringSection().get(this.nameIndex);
    }

    @Override // org.p088jf.dexlib2.iface.AnnotationElement
    public EncodedValue getValue() {
        return this.value;
    }
}
