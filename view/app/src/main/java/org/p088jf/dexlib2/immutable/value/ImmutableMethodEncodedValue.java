package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseMethodEncodedValue;
import org.p088jf.dexlib2.iface.value.MethodEncodedValue;
import org.p088jf.dexlib2.immutable.reference.ImmutableMethodReference;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMethodEncodedValue extends BaseMethodEncodedValue implements ImmutableEncodedValue {
    public final ImmutableMethodReference value;

    public ImmutableMethodEncodedValue(ImmutableMethodReference immutableMethodReference) {
        this.value = immutableMethodReference;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableMethodEncodedValue m3932of(MethodEncodedValue methodEncodedValue) {
        return methodEncodedValue instanceof ImmutableMethodEncodedValue ? (ImmutableMethodEncodedValue) methodEncodedValue : new ImmutableMethodEncodedValue(ImmutableMethodReference.m3915of(methodEncodedValue.getValue()));
    }

    @Override // org.p088jf.dexlib2.iface.value.MethodEncodedValue
    public ImmutableMethodReference getValue() {
        return this.value;
    }
}
