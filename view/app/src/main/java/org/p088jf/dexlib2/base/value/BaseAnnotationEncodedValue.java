package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.util.CollectionUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAnnotationEncodedValue implements AnnotationEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        if (iCompare != 0) {
            return iCompare;
        }
        AnnotationEncodedValue annotationEncodedValue = (AnnotationEncodedValue) encodedValue;
        int iCompareTo = getType().compareTo(annotationEncodedValue.getType());
        return iCompareTo != 0 ? iCompareTo : CollectionUtils.compareAsSet(getElements(), annotationEncodedValue.getElements());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnnotationEncodedValue)) {
            return false;
        }
        AnnotationEncodedValue annotationEncodedValue = (AnnotationEncodedValue) obj;
        return getType().equals(annotationEncodedValue.getType()) && getElements().equals(annotationEncodedValue.getElements());
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 29;
    }

    public int hashCode() {
        return (getType().hashCode() * 31) + getElements().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
