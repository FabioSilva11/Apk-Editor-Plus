package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseTypeEncodedValue;
import org.p088jf.dexlib2.iface.value.TypeEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableTypeEncodedValue extends BaseTypeEncodedValue implements ImmutableEncodedValue {
    public final String value;

    public ImmutableTypeEncodedValue(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableTypeEncodedValue m3937of(TypeEncodedValue typeEncodedValue) {
        return typeEncodedValue instanceof ImmutableTypeEncodedValue ? (ImmutableTypeEncodedValue) typeEncodedValue : new ImmutableTypeEncodedValue(typeEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.TypeEncodedValue
    public String getValue() {
        return this.value;
    }
}
