package org.p088jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.writer.AnnotationSection;
import org.p088jf.dexlib2.writer.builder.BuilderEncodedValues;

/* JADX INFO: loaded from: classes.dex */
public class BuilderAnnotationPool extends BaseBuilderPool implements AnnotationSection<BuilderStringReference, BuilderTypeReference, BuilderAnnotation, BuilderAnnotationElement, BuilderEncodedValues.BuilderEncodedValue> {
    public final ConcurrentMap<Annotation, BuilderAnnotation> internedItems;

    public BuilderAnnotationPool(DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.newConcurrentMap();
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public BuilderStringReference getElementName(BuilderAnnotationElement builderAnnotationElement) {
        return builderAnnotationElement.name;
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public BuilderEncodedValues.BuilderEncodedValue getElementValue(BuilderAnnotationElement builderAnnotationElement) {
        return builderAnnotationElement.value;
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public Collection<? extends BuilderAnnotationElement> getElements(BuilderAnnotation builderAnnotation) {
        return builderAnnotation.elements;
    }

    @Override // org.p088jf.dexlib2.writer.OffsetSection
    public int getItemOffset(BuilderAnnotation builderAnnotation) {
        return builderAnnotation.offset;
    }

    @Override // org.p088jf.dexlib2.writer.OffsetSection
    public Collection<? extends Map.Entry<? extends BuilderAnnotation, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderAnnotation>(this, this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderAnnotationPool.1
            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(BuilderAnnotation builderAnnotation) {
                return builderAnnotation.offset;
            }

            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(BuilderAnnotation builderAnnotation, int i) {
                int i2 = builderAnnotation.offset;
                builderAnnotation.offset = i;
                return i2;
            }
        };
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public BuilderTypeReference getType(BuilderAnnotation builderAnnotation) {
        return builderAnnotation.type;
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public int getVisibility(BuilderAnnotation builderAnnotation) {
        return builderAnnotation.visibility;
    }

    public BuilderAnnotation internAnnotation(Annotation annotation) {
        BuilderAnnotation builderAnnotation = this.internedItems.get(annotation);
        if (builderAnnotation != null) {
            return builderAnnotation;
        }
        BuilderAnnotation builderAnnotation2 = new BuilderAnnotation(annotation.getVisibility(), ((BuilderTypePool) this.dexBuilder.typeSection).internType(annotation.getType()), this.dexBuilder.internAnnotationElements(annotation.getElements()));
        BuilderAnnotation builderAnnotationPutIfAbsent = this.internedItems.putIfAbsent(builderAnnotation2, builderAnnotation2);
        return builderAnnotationPutIfAbsent == null ? builderAnnotation2 : builderAnnotationPutIfAbsent;
    }
}
