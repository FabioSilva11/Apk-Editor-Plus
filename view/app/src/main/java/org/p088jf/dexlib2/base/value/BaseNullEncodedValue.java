package org.p088jf.dexlib2.base.value;

import com.google.common.primitives.Ints;
import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.NullEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseNullEncodedValue implements NullEncodedValue {
    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        return Ints.compare(getValueType(), encodedValue.getValueType());
    }

    public boolean equals(Object obj) {
        return obj instanceof NullEncodedValue;
    }

    @Override // org.p088jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 30;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }
}
