package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.ArrayEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.util.CollectionUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseArrayEncodedValue implements ArrayEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : CollectionUtils.compareAsList(getValue(), ((ArrayEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof ArrayEncodedValue) {
            return getValue().equals(((ArrayEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 28;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
