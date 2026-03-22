package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Shorts;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.ShortEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseShortEncodedValue implements ShortEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : Shorts.compare(getValue(), ((ShortEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof ShortEncodedValue) && getValue() == ((ShortEncodedValue) obj).getValue();
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 2;
    }

    public int hashCode() {
        return getValue();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
