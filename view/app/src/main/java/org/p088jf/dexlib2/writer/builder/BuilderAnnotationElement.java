package org.p088jf.dexlib2.writer.builder;

import org.p088jf.dexlib2.base.BaseAnnotationElement;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.writer.builder.BuilderEncodedValues;

/* JADX INFO: loaded from: classes.dex */
public class BuilderAnnotationElement extends BaseAnnotationElement {
    public final BuilderStringReference name;
    public final BuilderEncodedValues.BuilderEncodedValue value;

    public BuilderAnnotationElement(BuilderStringReference builderStringReference, BuilderEncodedValues.BuilderEncodedValue builderEncodedValue) {
        this.name = builderStringReference;
        this.value = builderEncodedValue;
    }

    @Override // org.p088jf.dexlib2.iface.AnnotationElement
    public String getName() {
        return this.name.getString();
    }

    @Override // org.p088jf.dexlib2.iface.AnnotationElement
    public EncodedValue getValue() {
        return this.value;
    }
}
