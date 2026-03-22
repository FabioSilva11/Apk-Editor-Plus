package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Chars;
import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.CharEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseCharEncodedValue implements CharEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : Chars.compare(getValue(), ((CharEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof CharEncodedValue) && getValue() == ((CharEncodedValue) obj).getValue();
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 3;
    }

    public int hashCode() {
        return getValue();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
