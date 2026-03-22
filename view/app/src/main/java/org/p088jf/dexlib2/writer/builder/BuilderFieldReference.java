package org.p088jf.dexlib2.writer.builder;

import org.p088jf.dexlib2.base.reference.BaseFieldReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderFieldReference extends BaseFieldReference implements BuilderReference {
    public final BuilderTypeReference definingClass;
    public final BuilderTypeReference fieldType;
    public int index = -1;
    public final BuilderStringReference name;

    public BuilderFieldReference(BuilderTypeReference builderTypeReference, BuilderStringReference builderStringReference, BuilderTypeReference builderTypeReference2) {
        this.definingClass = builderTypeReference;
        this.name = builderStringReference;
        this.fieldType = builderTypeReference2;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getDefiningClass() {
        return this.definingClass.getType();
    }

    public int getIndex() {
        return this.index;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getName() {
        return this.name.getString();
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getType() {
        return this.fieldType.getType();
    }
}
