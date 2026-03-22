package org.p088jf.dexlib2.base;

import java.util.Comparator;
import org.p088jf.dexlib2.iface.AnnotationElement;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAnnotationElement implements AnnotationElement {
    public static final Comparator<AnnotationElement> BY_NAME = new Comparator<AnnotationElement>() { // from class: org.jf.dexlib2.base.BaseAnnotationElement.1
        @Override // java.util.Comparator
        public int compare(AnnotationElement annotationElement, AnnotationElement annotationElement2) {
            return annotationElement.getName().compareTo(annotationElement2.getName());
        }
    };

    @Override // java.lang.Comparable
    public int compareTo(AnnotationElement annotationElement) {
        int iCompareTo = getName().compareTo(annotationElement.getName());
        return iCompareTo != 0 ? iCompareTo : getValue().compareTo(annotationElement.getValue());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AnnotationElement)) {
            return false;
        }
        AnnotationElement annotationElement = (AnnotationElement) obj;
        return getName().equals(annotationElement.getName()) && getValue().equals(annotationElement.getValue());
    }

    public int hashCode() {
        return (getName().hashCode() * 31) + getValue().hashCode();
    }
}
