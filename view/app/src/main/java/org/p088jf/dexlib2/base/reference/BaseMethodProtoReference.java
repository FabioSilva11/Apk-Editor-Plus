package org.p088jf.dexlib2.base.reference;

import com.google.common.collect.Ordering;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.util.CharSequenceUtils;
import org.p088jf.util.CollectionUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMethodProtoReference extends BaseReference implements MethodProtoReference {
    @Override // java.lang.Comparable
    public int compareTo(MethodProtoReference methodProtoReference) {
        int iCompareTo = getReturnType().compareTo(methodProtoReference.getReturnType());
        return iCompareTo != 0 ? iCompareTo : CollectionUtils.compareAsIterable(Ordering.usingToString(), getParameterTypes(), methodProtoReference.getParameterTypes());
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodProtoReference
    public boolean equals(Object obj) {
        if (!(obj instanceof MethodProtoReference)) {
            return false;
        }
        MethodProtoReference methodProtoReference = (MethodProtoReference) obj;
        return getReturnType().equals(methodProtoReference.getReturnType()) && CharSequenceUtils.listEquals(getParameterTypes(), methodProtoReference.getParameterTypes());
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodProtoReference
    public int hashCode() {
        return (getReturnType().hashCode() * 31) + getParameterTypes().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getMethodProtoDescriptor(this);
    }
}
