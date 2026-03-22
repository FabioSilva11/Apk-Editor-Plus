package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.MethodTypeEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMethodTypeEncodedValue implements MethodTypeEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : getValue().compareTo(((MethodTypeEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof MethodTypeEncodedValue) {
            return getValue().equals(((MethodTypeEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 21;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
