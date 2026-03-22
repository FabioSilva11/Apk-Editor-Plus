package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseMethodHandleEncodedValue;
import org.p088jf.dexlib2.iface.value.MethodHandleEncodedValue;
import org.p088jf.dexlib2.immutable.reference.ImmutableMethodHandleReference;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMethodHandleEncodedValue extends BaseMethodHandleEncodedValue implements ImmutableEncodedValue {
    public final ImmutableMethodHandleReference methodHandleReference;

    public ImmutableMethodHandleEncodedValue(ImmutableMethodHandleReference immutableMethodHandleReference) {
        this.methodHandleReference = immutableMethodHandleReference;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableMethodHandleEncodedValue m3933of(MethodHandleEncodedValue methodHandleEncodedValue) {
        return methodHandleEncodedValue instanceof ImmutableMethodHandleEncodedValue ? (ImmutableMethodHandleEncodedValue) methodHandleEncodedValue : new ImmutableMethodHandleEncodedValue(ImmutableMethodHandleReference.m3913of(methodHandleEncodedValue.getValue()));
    }

    @Override // org.p088jf.dexlib2.iface.value.MethodHandleEncodedValue
    public ImmutableMethodHandleReference getValue() {
        return this.methodHandleReference;
    }
}
