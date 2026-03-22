package org.p088jf.dexlib2.writer;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public interface AnnotationSection<StringKey, TypeKey, AnnotationKey, AnnotationElement, EncodedValue> extends OffsetSection<AnnotationKey> {
    StringKey getElementName(AnnotationElement annotationelement);

    EncodedValue getElementValue(AnnotationElement annotationelement);

    Collection<? extends AnnotationElement> getElements(AnnotationKey annotationkey);

    TypeKey getType(AnnotationKey annotationkey);

    int getVisibility(AnnotationKey annotationkey);
}
