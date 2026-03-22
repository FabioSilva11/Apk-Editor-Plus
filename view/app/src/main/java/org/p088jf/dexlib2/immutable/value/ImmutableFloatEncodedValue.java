package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseFloatEncodedValue;
import org.p088jf.dexlib2.iface.value.FloatEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableFloatEncodedValue extends BaseFloatEncodedValue implements ImmutableEncodedValue {
    public final float value;

    public ImmutableFloatEncodedValue(float f) {
        this.value = f;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableFloatEncodedValue m3929of(FloatEncodedValue floatEncodedValue) {
        return floatEncodedValue instanceof ImmutableFloatEncodedValue ? (ImmutableFloatEncodedValue) floatEncodedValue : new ImmutableFloatEncodedValue(floatEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.FloatEncodedValue
    public float getValue() {
        return this.value;
    }
}
