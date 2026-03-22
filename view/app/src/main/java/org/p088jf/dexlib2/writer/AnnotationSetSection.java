package org.p088jf.dexlib2.writer;

import java.util.Collection;
import org.p088jf.dexlib2.iface.Annotation;

/* JADX INFO: loaded from: classes.dex */
public interface AnnotationSetSection<AnnotationKey extends Annotation, AnnotationSetKey> extends NullableOffsetSection<AnnotationSetKey> {
    Collection<? extends AnnotationKey> getAnnotations(AnnotationSetKey annotationsetkey);
}
