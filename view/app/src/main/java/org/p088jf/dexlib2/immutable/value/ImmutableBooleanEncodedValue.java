package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseBooleanEncodedValue;
import org.p088jf.dexlib2.iface.value.BooleanEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableBooleanEncodedValue extends BaseBooleanEncodedValue implements ImmutableEncodedValue {
    public final boolean value;
    public static final ImmutableBooleanEncodedValue TRUE_VALUE = new ImmutableBooleanEncodedValue(true);
    public static final ImmutableBooleanEncodedValue FALSE_VALUE = new ImmutableBooleanEncodedValue(false);

    public ImmutableBooleanEncodedValue(boolean z) {
        this.value = z;
    }

    public static ImmutableBooleanEncodedValue forBoolean(boolean z) {
        return z ? TRUE_VALUE : FALSE_VALUE;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableBooleanEncodedValue m3922of(BooleanEncodedValue booleanEncodedValue) {
        return forBoolean(booleanEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.BooleanEncodedValue
    public boolean getValue() {
        return this.value;
    }
}
