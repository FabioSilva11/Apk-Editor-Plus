package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseDoubleEncodedValue;
import org.p088jf.dexlib2.iface.value.DoubleEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableDoubleEncodedValue extends BaseDoubleEncodedValue implements ImmutableEncodedValue {
    public final double value;

    public ImmutableDoubleEncodedValue(double d) {
        this.value = d;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableDoubleEncodedValue m3925of(DoubleEncodedValue doubleEncodedValue) {
        return doubleEncodedValue instanceof ImmutableDoubleEncodedValue ? (ImmutableDoubleEncodedValue) doubleEncodedValue : new ImmutableDoubleEncodedValue(doubleEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.DoubleEncodedValue
    public double getValue() {
        return this.value;
    }
}
