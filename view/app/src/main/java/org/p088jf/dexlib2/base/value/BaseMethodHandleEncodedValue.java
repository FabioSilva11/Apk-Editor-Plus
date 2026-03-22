package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.MethodHandleEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMethodHandleEncodedValue implements MethodHandleEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : getValue().compareTo(((MethodHandleEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof MethodHandleEncodedValue) {
            return getValue().equals(((MethodHandleEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 22;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
