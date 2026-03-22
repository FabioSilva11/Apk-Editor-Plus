package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.DoubleEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDoubleEncodedValue implements DoubleEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : Double.compare(getValue(), ((DoubleEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof DoubleEncodedValue) && Double.doubleToRawLongBits(getValue()) == Double.doubleToRawLongBits(((DoubleEncodedValue) obj).getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 17;
    }

    public int hashCode() {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(getValue());
        return (int) (jDoubleToRawLongBits ^ (jDoubleToRawLongBits >>> 32));
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
