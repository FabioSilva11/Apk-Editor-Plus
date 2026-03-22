package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.LongEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLongEncodedValue implements LongEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : Longs.compare(getValue(), ((LongEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof LongEncodedValue) && getValue() == ((LongEncodedValue) obj).getValue();
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 6;
    }

    public int hashCode() {
        long value = getValue();
        return (((int) value) * 31) + ((int) (value >>> 32));
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
