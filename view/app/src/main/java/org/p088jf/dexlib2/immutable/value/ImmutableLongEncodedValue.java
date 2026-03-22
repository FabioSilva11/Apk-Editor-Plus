package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseLongEncodedValue;
import org.p088jf.dexlib2.iface.value.LongEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableLongEncodedValue extends BaseLongEncodedValue implements ImmutableEncodedValue {
    public final long value;

    public ImmutableLongEncodedValue(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableLongEncodedValue m3931of(LongEncodedValue longEncodedValue) {
        return longEncodedValue instanceof ImmutableLongEncodedValue ? (ImmutableLongEncodedValue) longEncodedValue : new ImmutableLongEncodedValue(longEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.LongEncodedValue
    public long getValue() {
        return this.value;
    }
}
