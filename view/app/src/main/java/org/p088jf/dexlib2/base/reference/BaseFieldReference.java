package org.p088jf.dexlib2.base.reference;

import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.reference.FieldReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseFieldReference extends BaseReference implements FieldReference {
    @Override // java.lang.Comparable
    public int compareTo(FieldReference fieldReference) {
        int iCompareTo = getDefiningClass().compareTo(fieldReference.getDefiningClass());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = getName().compareTo(fieldReference.getName());
        return iCompareTo2 != 0 ? iCompareTo2 : getType().compareTo(fieldReference.getType());
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference
    public boolean equals(Object obj) {
        if (!(obj instanceof FieldReference)) {
            return false;
        }
        FieldReference fieldReference = (FieldReference) obj;
        return getDefiningClass().equals(fieldReference.getDefiningClass()) && getName().equals(fieldReference.getName()) && getType().equals(fieldReference.getType());
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference
    public int hashCode() {
        return (((getDefiningClass().hashCode() * 31) + getName().hashCode()) * 31) + getType().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getFieldDescriptor(this);
    }
}
