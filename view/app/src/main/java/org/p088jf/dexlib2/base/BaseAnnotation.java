package org.p088jf.dexlib2.base;

import com.google.common.primitives.Ints;
import java.util.Comparator;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.util.CollectionUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAnnotation implements Annotation {
    public static final Comparator<? super Annotation> BY_TYPE = new Comparator<Annotation>() { // from class: org.jf.dexlib2.base.BaseAnnotation.1
        @Override // java.util.Comparator
        public int compare(Annotation annotation, Annotation annotation2) {
            return annotation.getType().compareTo(annotation2.getType());
        }
    };

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        int iCompare = Ints.compare(getVisibility(), annotation.getVisibility());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = getType().compareTo(annotation.getType());
        return iCompareTo != 0 ? iCompareTo : CollectionUtils.compareAsSet(getElements(), annotation.getElements());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Annotation)) {
            return false;
        }
        Annotation annotation = (Annotation) obj;
        return getVisibility() == annotation.getVisibility() && getType().equals(annotation.getType()) && getElements().equals(annotation.getElements());
    }

    public int hashCode() {
        return (((getVisibility() * 31) + getType().hashCode()) * 31) + getElements().hashCode();
    }
}
