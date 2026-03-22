package org.p088jf.dexlib2.writer.builder;

import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.base.reference.BaseFieldReference;
import org.p088jf.dexlib2.iface.Field;
import org.p088jf.dexlib2.writer.builder.BuilderEncodedValues;

/* JADX INFO: loaded from: classes.dex */
public class BuilderField extends BaseFieldReference implements Field {
    public final int accessFlags;
    public final BuilderAnnotationSet annotations;
    public final BuilderFieldReference fieldReference;
    public Set<HiddenApiRestriction> hiddenApiRestrictions;
    public final BuilderEncodedValues.BuilderEncodedValue initialValue;

    public BuilderField(BuilderFieldReference builderFieldReference, int i, BuilderEncodedValues.BuilderEncodedValue builderEncodedValue, BuilderAnnotationSet builderAnnotationSet, Set<HiddenApiRestriction> set) {
        this.fieldReference = builderFieldReference;
        this.accessFlags = i;
        this.initialValue = builderEncodedValue;
        this.annotations = builderAnnotationSet;
        this.hiddenApiRestrictions = set;
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public BuilderAnnotationSet getAnnotations() {
        return this.annotations;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getDefiningClass() {
        return this.fieldReference.definingClass.getType();
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.hiddenApiRestrictions;
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public BuilderEncodedValues.BuilderEncodedValue getInitialValue() {
        return this.initialValue;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getName() {
        return this.fieldReference.name.getString();
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getType() {
        return this.fieldReference.fieldType.getType();
    }
}
