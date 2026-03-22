package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.FloatEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseFloatEncodedValue implements FloatEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int iCompare = Ints.compare(getValueType(), encodedValue.getValueType());
        return iCompare != 0 ? iCompare : Float.compare(getValue(), ((FloatEncodedValue) encodedValue).getValue());
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof FloatEncodedValue) && Float.floatToRawIntBits(getValue()) == Float.floatToRawIntBits(((FloatEncodedValue) obj).getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 16;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(getValue());
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
