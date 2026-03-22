package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseMethodTypeEncodedValue;
import org.p088jf.dexlib2.iface.value.MethodTypeEncodedValue;
import org.p088jf.dexlib2.immutable.reference.ImmutableMethodProtoReference;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMethodTypeEncodedValue extends BaseMethodTypeEncodedValue implements ImmutableEncodedValue {
    public final ImmutableMethodProtoReference methodProtoReference;

    public ImmutableMethodTypeEncodedValue(ImmutableMethodProtoReference immutableMethodProtoReference) {
        this.methodProtoReference = immutableMethodProtoReference;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableMethodTypeEncodedValue m3934of(MethodTypeEncodedValue methodTypeEncodedValue) {
        return methodTypeEncodedValue instanceof ImmutableMethodTypeEncodedValue ? (ImmutableMethodTypeEncodedValue) methodTypeEncodedValue : new ImmutableMethodTypeEncodedValue(ImmutableMethodProtoReference.m3914of(methodTypeEncodedValue.getValue()));
    }

    @Override // org.p088jf.dexlib2.iface.value.MethodTypeEncodedValue
    public ImmutableMethodProtoReference getValue() {
        return this.methodProtoReference;
    }
}
