package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseFieldEncodedValue;
import org.p088jf.dexlib2.iface.value.FieldEncodedValue;
import org.p088jf.dexlib2.immutable.reference.ImmutableFieldReference;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableFieldEncodedValue extends BaseFieldEncodedValue implements ImmutableEncodedValue {
    public final ImmutableFieldReference value;

    public ImmutableFieldEncodedValue(ImmutableFieldReference immutableFieldReference) {
        this.value = immutableFieldReference;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableFieldEncodedValue m3928of(FieldEncodedValue fieldEncodedValue) {
        return fieldEncodedValue instanceof ImmutableFieldEncodedValue ? (ImmutableFieldEncodedValue) fieldEncodedValue : new ImmutableFieldEncodedValue(ImmutableFieldReference.m3912of(fieldEncodedValue.getValue()));
    }

    @Override // org.p088jf.dexlib2.iface.value.FieldEncodedValue
    public ImmutableFieldReference getValue() {
        return this.value;
    }
}
