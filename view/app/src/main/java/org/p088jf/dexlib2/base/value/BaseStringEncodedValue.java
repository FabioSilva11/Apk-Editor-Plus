package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.StringEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseStringEncodedValue implements StringEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : getValue().compareTo(((StringEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof StringEncodedValue) {
            return getValue().equals(((StringEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 23;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
