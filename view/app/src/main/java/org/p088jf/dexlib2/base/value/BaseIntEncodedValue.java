package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.IntEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseIntEncodedValue implements IntEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : Ints.compare(getValue(), ((IntEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof IntEncodedValue) && getValue() == ((IntEncodedValue) obj).getValue();
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 4;
    }

    public int hashCode() {
        return getValue();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
