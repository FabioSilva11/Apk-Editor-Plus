package org.p088jf.dexlib2.writer.pool;

import java.util.Collection;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.AnnotationElement;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.writer.AnnotationSection;

/* JADX INFO: loaded from: classes.dex */
public class AnnotationPool extends BaseOffsetPool<Annotation> implements AnnotationSection<CharSequence, CharSequence, Annotation, AnnotationElement, EncodedValue> {
    public AnnotationPool(DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public CharSequence getElementName(AnnotationElement annotationElement) {
        return annotationElement.getName();
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public EncodedValue getElementValue(AnnotationElement annotationElement) {
        return annotationElement.getValue();
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public Collection<? extends AnnotationElement> getElements(Annotation annotation) {
        return annotation.getElements();
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public CharSequence getType(Annotation annotation) {
        return annotation.getType();
    }

    @Override // org.p088jf.dexlib2.writer.AnnotationSection
    public int getVisibility(Annotation annotation) {
        return annotation.getVisibility();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void intern(Annotation annotation) {
        if (((Integer) this.internedItems.put((Key) annotation, (Value) 0)) == null) {
            ((TypePool) this.dexPool.typeSection).intern(annotation.getType());
            for (AnnotationElement annotationElement : annotation.getElements()) {
                ((StringPool) this.dexPool.stringSection).intern(annotationElement.getName());
                this.dexPool.internEncodedValue(annotationElement.getValue());
            }
        }
    }
}
