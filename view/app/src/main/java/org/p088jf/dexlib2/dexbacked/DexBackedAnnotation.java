package org.p088jf.dexlib2.dexbacked;

import java.util.Set;
import org.p088jf.dexlib2.base.BaseAnnotation;
import org.p088jf.dexlib2.dexbacked.util.VariableSizeSet;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedAnnotation extends BaseAnnotation {
    public final DexBackedDexFile dexFile;
    public final int elementsOffset;
    public final int typeIndex;
    public final int visibility;

    public DexBackedAnnotation(DexBackedDexFile dexBackedDexFile, int i) {
        this.dexFile = dexBackedDexFile;
        DexReader<? extends DexBuffer> dexReader = dexBackedDexFile.getDataBuffer().readerAt(i);
        this.visibility = dexReader.readUbyte();
        this.typeIndex = dexReader.readSmallUleb128();
        this.elementsOffset = dexReader.getOffset();
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public Set<? extends DexBackedAnnotationElement> getElements() {
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(this.elementsOffset);
        return new VariableSizeSet<DexBackedAnnotationElement>(this.dexFile.getDataBuffer(), dexReader.getOffset(), dexReader.readSmallUleb128()) { // from class: org.jf.dexlib2.dexbacked.DexBackedAnnotation.1
            @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeSet
            public DexBackedAnnotationElement readNextItem(DexReader dexReader2, int i) {
                return new DexBackedAnnotationElement(DexBackedAnnotation.this.dexFile, dexReader2);
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public String getType() {
        return this.dexFile.getTypeSection().get(this.typeIndex);
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public int getVisibility() {
        return this.visibility;
    }
}
