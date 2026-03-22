package org.p088jf.dexlib2.base.reference;

import com.google.common.collect.Ordering;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.util.CharSequenceUtils;
import org.p088jf.util.CollectionUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMethodReference extends BaseReference implements MethodReference {
    @Override // java.lang.Comparable
    public int compareTo(MethodReference methodReference) {
        int iCompareTo = getDefiningClass().compareTo(methodReference.getDefiningClass());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = getName().compareTo(methodReference.getName());
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        int iCompareTo3 = getReturnType().compareTo(methodReference.getReturnType());
        return iCompareTo3 != 0 ? iCompareTo3 : CollectionUtils.compareAsIterable(Ordering.usingToString(), getParameterTypes(), methodReference.getParameterTypes());
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MethodReference)) {
            return false;
        }
        MethodReference methodReference = (MethodReference) obj;
        return getDefiningClass().equals(methodReference.getDefiningClass()) && getName().equals(methodReference.getName()) && getReturnType().equals(methodReference.getReturnType()) && CharSequenceUtils.listEquals(getParameterTypes(), methodReference.getParameterTypes());
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public int hashCode() {
        return (((((getDefiningClass().hashCode() * 31) + getName().hashCode()) * 31) + getReturnType().hashCode()) * 31) + getParameterTypes().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getMethodDescriptor(this);
    }
}
