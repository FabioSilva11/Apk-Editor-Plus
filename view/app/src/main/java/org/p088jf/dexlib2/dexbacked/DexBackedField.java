package org.p088jf.dexlib2.dexbacked;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.base.reference.BaseFieldReference;
import org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory;
import org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator;
import org.p088jf.dexlib2.iface.ClassDef;
import org.p088jf.dexlib2.iface.Field;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedField extends BaseFieldReference implements Field {
    public final int accessFlags;
    public final int annotationSetOffset;
    public final ClassDef classDef;
    public final DexBackedDexFile dexFile;
    public int fieldIdItemOffset;
    public final int fieldIndex;
    public final int hiddenApiRestrictions;
    public final EncodedValue initialValue;

    public DexBackedField(DexBackedDexFile dexBackedDexFile, DexReader dexReader, DexBackedClassDef dexBackedClassDef, int i, AnnotationsDirectory.AnnotationIterator annotationIterator, int i2) {
        this.dexFile = dexBackedDexFile;
        this.classDef = dexBackedClassDef;
        dexReader.getOffset();
        int largeUleb128 = dexReader.readLargeUleb128() + i;
        this.fieldIndex = largeUleb128;
        this.accessFlags = dexReader.readSmallUleb128();
        this.annotationSetOffset = annotationIterator.seekTo(largeUleb128);
        this.initialValue = null;
        this.hiddenApiRestrictions = i2;
    }

    public DexBackedField(DexBackedDexFile dexBackedDexFile, DexReader dexReader, DexBackedClassDef dexBackedClassDef, int i, EncodedArrayItemIterator encodedArrayItemIterator, AnnotationsDirectory.AnnotationIterator annotationIterator, int i2) {
        this.dexFile = dexBackedDexFile;
        this.classDef = dexBackedClassDef;
        dexReader.getOffset();
        int largeUleb128 = dexReader.readLargeUleb128() + i;
        this.fieldIndex = largeUleb128;
        this.accessFlags = dexReader.readSmallUleb128();
        this.annotationSetOffset = annotationIterator.seekTo(largeUleb128);
        encodedArrayItemIterator.getReaderOffset();
        this.initialValue = encodedArrayItemIterator.getNextOrNull();
        this.hiddenApiRestrictions = i2;
    }

    public static void skipFields(DexReader dexReader, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            dexReader.skipUleb128();
            dexReader.skipUleb128();
        }
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public Set<? extends DexBackedAnnotation> getAnnotations() {
        return AnnotationsDirectory.getAnnotations(this.dexFile, this.annotationSetOffset);
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getDefiningClass() {
        return this.classDef.getType();
    }

    public final int getFieldIdItemOffset() {
        if (this.fieldIdItemOffset == 0) {
            this.fieldIdItemOffset = this.dexFile.getFieldSection().getOffset(this.fieldIndex);
        }
        return this.fieldIdItemOffset;
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        int i = this.hiddenApiRestrictions;
        return i == 7 ? ImmutableSet.m3782of() : EnumSet.copyOf((Collection) HiddenApiRestriction.getAllFlags(i));
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public EncodedValue getInitialValue() {
        return this.initialValue;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getName() {
        return this.dexFile.getStringSection().get(this.dexFile.getBuffer().readSmallUint(getFieldIdItemOffset() + 4));
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readUshort(getFieldIdItemOffset() + 2));
    }
}
