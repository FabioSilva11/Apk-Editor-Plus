package org.p088jf.dexlib2.immutable;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import org.p088jf.dexlib2.base.BaseAnnotation;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.AnnotationElement;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableAnnotation extends BaseAnnotation {
    public static final ImmutableConverter<ImmutableAnnotation, Annotation> CONVERTER = new ImmutableConverter<ImmutableAnnotation, Annotation>() { // from class: org.jf.dexlib2.immutable.ImmutableAnnotation.1
        @Override // org.p088jf.util.ImmutableConverter
        public boolean isImmutable(Annotation annotation) {
            return annotation instanceof ImmutableAnnotation;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableAnnotation makeImmutable(Annotation annotation) {
            return ImmutableAnnotation.m3855of(annotation);
        }
    };
    public final ImmutableSet<? extends ImmutableAnnotationElement> elements;
    public final String type;
    public final int visibility;

    public ImmutableAnnotation(int i, String str, Collection<? extends AnnotationElement> collection) {
        this.visibility = i;
        this.type = str;
        this.elements = ImmutableAnnotationElement.immutableSetOf(collection);
    }

    public static ImmutableSet<ImmutableAnnotation> immutableSetOf(Iterable<? extends Annotation> iterable) {
        return CONVERTER.toSet(iterable);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableAnnotation m3855of(Annotation annotation) {
        return annotation instanceof ImmutableAnnotation ? (ImmutableAnnotation) annotation : new ImmutableAnnotation(annotation.getVisibility(), annotation.getType(), annotation.getElements());
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public ImmutableSet<? extends ImmutableAnnotationElement> getElements() {
        return this.elements;
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public String getType() {
        return this.type;
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public int getVisibility() {
        return this.visibility;
    }
}
