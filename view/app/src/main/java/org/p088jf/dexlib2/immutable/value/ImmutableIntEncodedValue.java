package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseIntEncodedValue;
import org.p088jf.dexlib2.iface.value.IntEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableIntEncodedValue extends BaseIntEncodedValue implements ImmutableEncodedValue {
    public final int value;

    public ImmutableIntEncodedValue(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableIntEncodedValue m3930of(IntEncodedValue intEncodedValue) {
        return intEncodedValue instanceof ImmutableIntEncodedValue ? (ImmutableIntEncodedValue) intEncodedValue : new ImmutableIntEncodedValue(intEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.IntEncodedValue
    public int getValue() {
        return this.value;
    }
}
